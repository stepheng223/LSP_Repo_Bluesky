package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/**
 * Transform #3:
 * If final rounded price > 500.00 AND original category was "Electronics",
 * change category to "Premium Electronics".
 */
public class PremiumCategoryTransformer implements Transformer {
    @Override
    public void apply(ProductRecord record) {
        if ("Electronics".equals(record.getOriginalCategory())
                && record.getPrice().compareTo(new BigDecimal("500.00")) > 0) {
            record.setCategory("Premium Electronics");
        }
    }
}