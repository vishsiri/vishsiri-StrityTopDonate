package space.vishsiri.vishsiristritytopdonate;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebScraper {

    private final String topDonateURL;

    public WebScraper(String topDonateURL) {
        this.topDonateURL = topDonateURL;
    }

    public List<space.vishsiri.vishsiristritytopdonate.PlayerDonation> getTopDonate() {
        List<space.vishsiri.vishsiristritytopdonate.PlayerDonation> playerDonations = new ArrayList<>();
        int entriesToSkip = 5; // Number of entries to skip
        int skippedEntries = 0; // Counter for skipped entries

        try {
            Document document = Jsoup.connect(topDonateURL).get();
            Elements tableData = document.select("td");
            int position = 1;

            for (Element td : tableData) {
                if (!td.select("img").isEmpty()) {
                    // This td contains an image, so it is a player name entry
                    String playerName = td.text();
                    Element nextTd = td.nextElementSibling();
                    if (nextTd != null && !nextTd.select("b").isEmpty()) {
                        // The next td contains the donation amount
                        if (skippedEntries < entriesToSkip) {
                            skippedEntries++;
                            continue; // Skip this entry
                        }

                        String amount = nextTd.text();
                        playerDonations.add(new PlayerDonation(playerName, amount, position));
                        position++;
                    }
                }
            }

            if (playerDonations.isEmpty()) {
                System.out.println("No players found.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return playerDonations;
    }
}
