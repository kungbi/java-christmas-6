package cristmas.domain.promotion;

public class GiveawayPromotion {

    public static final int GIVEAWAY_PAYMENT_AMOUNT = 120_000;

    public boolean isAvailable(int paymentAmount) {
        if (paymentAmount < GIVEAWAY_PAYMENT_AMOUNT) {
            return false;
        }
        return true;
    }
}
