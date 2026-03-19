package org.howard.edu.lsp.midterm.strategy;

/**
 * Uses a discount strategy to calculate final prices.
 *
 * @author Stephen Ganthier
 */
public class PriceCalculator {
    private DiscountStrategy discountStrategy;

    /**
     * Creates a PriceCalculator with the given discount strategy.
     *
     * @param discountStrategy the strategy to use
     */
    public PriceCalculator(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    /**
     * Sets the discount strategy.
     *
     * @param discountStrategy the new strategy to use
     */
    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    /**
     * Calculates the final price using the current strategy.
     *
     * @param price the original price
     * @return the final price
     */
    public double calculatePrice(double price) {
        return discountStrategy.calculatePrice(price);
    }
}