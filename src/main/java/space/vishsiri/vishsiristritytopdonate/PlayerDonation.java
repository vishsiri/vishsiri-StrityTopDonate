package space.vishsiri.vishsiristritytopdonate;

import java.util.List;

public class PlayerDonation {
    private String player;
    private String amount;
    private int position;

    public PlayerDonation(String player, String amount, int position) {
        this.player = player;
        this.amount = amount;
        this.position = position;
    }

    public String getPlayer() {
        return player;
    }

    public String getAmount() {
        return amount;
    }

    public int getPosition() {
        return position;
    }

    public static String getNameByPosition(List<PlayerDonation> donations, int position) {
        for (PlayerDonation donation : donations) {
            if (donation.getPosition() == position) {
                return donation.getPlayer();
            }
        }
        return null; // or throw an exception if position is invalid
    }

    public static String getAmountByPosition(List<PlayerDonation> donations, int position) {
        for (PlayerDonation donation : donations) {
            if (donation.getPosition() == position) {
                return donation.getAmount();
            }
        }
        return null; // or throw an exception if position is invalid
    }
}
