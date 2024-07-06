package space.vishsiri.vishsiristritytopdonate;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class StrityTopDonate extends JavaPlugin {

    private WebScraper webScraper;
    private TopDonatePlaceholder placeholder;

    @Override
    public void onEnable() {
        // Save the default config if it doesn't exist
        saveDefaultConfig();

        // Load the config values
        int duration = getConfig().getInt("duration");
        String topDonateURL = getConfig().getString("topDonateURL");

        // Initialize the web scraper with the URL from the config
        webScraper = new WebScraper(topDonateURL);

        // Initialize and register the placeholder
        placeholder = new TopDonatePlaceholder(this);
        placeholder.register();

        // Register the command
        Objects.requireNonNull(this.getCommand("stritytopdonate")).setExecutor(new RefreshTopDonateCommand(this,placeholder));

        // Schedule a task to fetch top donations periodically
        getServer().getScheduler().runTaskTimer(this, new Runnable() {
            @Override
            public void run() {
                placeholder.updateDonations();
            }
        }, 0L, duration);
    }

    @Override
    public void onDisable() {
        placeholder.unregister();
    }

    public WebScraper getWebScraper() {
        return webScraper;
    }
}
