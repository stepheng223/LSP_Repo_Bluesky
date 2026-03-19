package org.howard.edu.lsp.midterm.strategy;

/**
 * Defines the discount strategy interface for calculating final prices.
 *
 * @author Stephen Ganthier
 */
public interface DiscountStrategy {
    /**
     * Calculates the final price after applying the strategy.
     *
     * @param price the original price
     * @return the final discounted price
     */
    double calculatePrice(double price);
}