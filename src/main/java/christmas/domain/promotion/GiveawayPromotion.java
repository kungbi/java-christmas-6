package christmas.domain.promotion;

public class GiveawayPromotion {

    private static final int GIVEAWAY_PAYMENT_AMOUNT = 120_000;
    private static final String GIVEAWAY_PRODUCT_NAME = "샴페인";
    private static final int GIVEAWAY_PRODUCT_AMOUNT = 1;

    public static boolean isAvailable(int paymentAmount) {
        if (paymentAmount < GIVEAWAY_PAYMENT_AMOUNT) {
            return false;
        }
        return true;
    }

    public static String getGiveawayProductName() {
        return GIVEAWAY_PRODUCT_NAME;
    }

    public static int getGiveawayProductQuantity() {
        return GIVEAWAY_PRODUCT_AMOUNT;
    }
}
