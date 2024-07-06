package space.vishsiri.vishsiristritytopdonate;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class RefreshTopDonateCommand implements CommandExecutor {

    private final StrityTopDonate plugin;
    private final TopDonatePlaceholder placeholder;

    public RefreshTopDonateCommand(StrityTopDonate plugin, TopDonatePlaceholder placeholder) {
        this.plugin = plugin;
        this.placeholder = placeholder;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("refresh")) {
                // Manually refresh the top donations
                placeholder.updateDonations();
                sender.sendMessage("Top donations have been refreshed.");
                return true;
            } else if (args[0].equalsIgnoreCase("reload")) {
                // Reload the plugin configuration
                plugin.reloadConfig();
                placeholder.updateDonations();
                sender.sendMessage("Plugin configuration has been reloaded and top donations have been refreshed.");
                return true;
            }
        }
        return false;
    }
}