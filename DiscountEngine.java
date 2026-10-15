package discount;

import java.util.List;

public class DiscountEngine {

    private DiscountRule rule;

    public DiscountEngine(DiscountRule rule) {
        this.rule = rule;
    }

    public void apply(List<Double> prices) {

        for (double price : prices) {

            double finalPrice = rule.apply(price);

            System.out.println(
                    "Original: " + price +
                            " Final: " + finalPrice);
        }
    }
}