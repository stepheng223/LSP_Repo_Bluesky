package org.howard.edu.lsp.midterm.strategy;

/**
 * Applies a 20 percent discount for VIP customers.
 *
 * @author Stephen Ganthier
 */
public class VipDiscount implements DiscountStrategy {
    /**
     * Calculates the discounted price for VIP customers.
     *
     * @param price the original price
     * @return the discounted price
     */
    @Override
    public double calculatePrice(double price) {
        return price * 0.80;
    }
}