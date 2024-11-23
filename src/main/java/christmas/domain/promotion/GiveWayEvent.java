package christmas.domain.promotion;

public class GiveWayEvent {
    private final int MIN_PURCHASE_PRICE = 120_000;
    private final String GIVE_WAY_PRODUCT_NAME = "샴페인";

    public boolean isAvailable(int price) {
        return MIN_PURCHASE_PRICE <= price;
    }

    public String getGiveWayProductName() {
        return GIVE_WAY_PRODUCT_NAME;
    }

}
