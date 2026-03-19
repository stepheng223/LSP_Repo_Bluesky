package org.howard.edu.lsp.midterm.strategy;

/**
 * Applies a 10 percent discount for member customers.
 *
 * @author Stephen Ganthier
 */
public class MemberDiscount implements DiscountStrategy {
    /**
     * Calculates the discounted price for member customers.
     *
     * @param price the original price
     * @return the discounted price
     */
    @Override
    public double calculatePrice(double price) {
        return price * 0.90;
    }
}