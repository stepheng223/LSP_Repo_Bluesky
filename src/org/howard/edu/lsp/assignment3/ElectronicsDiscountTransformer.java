package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Transform #2: If original category is "Electronics", apply 10% discount.
 * Then round HALF-UP to exactly 2 decimals.
 */
public class ElectronicsDiscountTransformer implements Transformer {
    @Override
    public void apply(ProductRecord record) {
        BigDecimal outPrice = record.getPrice();

        if ("Electronics".equals(record.getOriginalCategory())) {
            outPrice = outPrice.multiply(new BigDecimal("0.90"));
        }

        // Round HALF-UP to exactly 2 decimals (final rounded price)
        outPrice = outPrice.setScale(2, RoundingMode.HALF_UP);
        record.setPrice(outPrice);
    }
}