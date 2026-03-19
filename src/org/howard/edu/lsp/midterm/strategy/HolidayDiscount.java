package org.howard.edu.lsp.midterm.strategy;
/**
 * Applies a 15 percent discount for holiday purchases.
 *
 * @author Stephen Ganthier
 */
public class HolidayDiscount implements DiscountStrategy {
    /**
     * Calculates the discounted price for holiday purchases.
     *
     * @param price the original price
     * @return the discounted price
     */
    @Override
    public double calculatePrice(double price) {
        return price * 0.85;
    }
}