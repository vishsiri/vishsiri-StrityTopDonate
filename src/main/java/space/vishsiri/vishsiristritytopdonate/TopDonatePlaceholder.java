package space.vishsiri.vishsiristritytopdonate;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TopDonatePlaceholder extends PlaceholderExpansion {

    private final StrityTopDonate plugin;
    private List<PlayerDonation> donations;

    public TopDonatePlaceholder(StrityTopDonate plugin) {
        this.plugin = plugin;
        this.donations = plugin.getWebScraper().getTopDonate();
    }

    @Override
    public boolean persist() {
        return true; // This means our placeholder expansion will persist through reloads
    }

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public @NotNull String getIdentifier() {
        return "stritytopdonate";
    }

    @Override
    public @NotNull String getAuthor() {
        return "VisherRyz";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier) {
        if (identifier.startsWith("player_")) {
            int position = Integer.parseInt(identifier.split("_")[1]);
            return PlayerDonation.getNameByPosition(donations, position);
        }
        if (identifier.startsWith("amount_")) {
            int position = Integer.parseInt(identifier.split("_")[1]);
            return PlayerDonation.getAmountByPosition(donations, position);
        }
        return null; // Placeholder is unknown by the expansion
    }

    public void updateDonations() {
        this.donations = plugin.getWebScraper().getTopDonate();
    }
}
