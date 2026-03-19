package org.howard.edu.lsp.midterm.strategy;

/**
 * Demonstrates the Strategy Pattern implementation for price calculation.
 *
 * @author Stephen Ganthier
 */
public class Driver {
    /**
     * Runs the driver program for different customer discount strategies.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        double price = 100.0;

        PriceCalculator calculator = new PriceCalculator(new RegularDiscount());
        System.out.println("REGULAR: " + calculator.calculatePrice(price));

        calculator.setDiscountStrategy(new MemberDiscount());
        System.out.println("MEMBER: " + calculator.calculatePrice(price));

        calculator.setDiscountStrategy(new VipDiscount());
        System.out.println("VIP: " + calculator.calculatePrice(price));

        calculator.setDiscountStrategy(new HolidayDiscount());
        System.out.println("HOLIDAY: " + calculator.calculatePrice(price));
    }
}