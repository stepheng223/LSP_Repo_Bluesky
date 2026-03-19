package org.howard.edu.lsp.midterm.strategy;

/**
 * Applies no discount for regular customers.
 *
 * @author Stephen Ganthier
 */
public class RegularDiscount implements DiscountStrategy {
    /**
     * Returns the original price for regular customers.
     *
     * @param price the original price
     * @return the unchanged price
     */
    @Override
    public double calculatePrice(double price) {
        return price;
    }
}