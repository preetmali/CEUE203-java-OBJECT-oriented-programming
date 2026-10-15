import java.util.ArrayList;
import java.util.Scanner;

import discount.DiscountEngine;
import discount.DiscountRule;

public class Driver3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Double> prices = new ArrayList<>();

        prices.add(100.0);
        prices.add(250.0);
        prices.add(500.0);
        prices.add(1000.0);

        System.out.println("1. 10% discount");
        System.out.println("2. 20% discount above 100");
        System.out.println("3. Flat 50 discount");

        System.out.print("Choose rule: ");
        int choice = sc.nextInt();

        DiscountRule rule;

        if (choice == 1) {

            rule = price -> price * 0.90;

        } else if (choice == 2) {

            rule = price -> {
                if (price > 100) {
                    return price * 0.80;
                } else {
                    return price;
                }
            };

        } else if (choice == 3) {

            rule = price -> Math.max(0, price - 50);

        } else {

            System.out.println("Invalid choice");
            sc.close();
            return;
        }

        DiscountEngine engine = new DiscountEngine(rule);

        System.out.println("\nPrices after discount:");

        engine.apply(prices);
        System.out.println("25CE057");
        sc.close();
    }
}