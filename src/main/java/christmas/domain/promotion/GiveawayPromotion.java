package christmas.domain.promotion;

public class GiveawayPromotion {

    public static final int GIVEAWAY_PAYMENT_AMOUNT = 120_000;

    public static boolean isAvailable(int paymentAmount) {
        if (paymentAmount < GIVEAWAY_PAYMENT_AMOUNT) {
            return false;
        }
        return true;
    }
}
