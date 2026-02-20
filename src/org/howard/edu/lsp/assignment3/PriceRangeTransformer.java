package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/**
 * Transform #4: PriceRange based on final rounded price (exact A2 thresholds).
 */
public class PriceRangeTransformer implements Transformer {
    @Override
    public void apply(ProductRecord record) {
        BigDecimal p = record.getPrice();

        String range;
        if (p.compareTo(new BigDecimal("10.00")) <= 0) {
            range = "Low";
        } else if (p.compareTo(new BigDecimal("100.00")) <= 0) {
            range = "Medium";
        } else if (p.compareTo(new BigDecimal("500.00")) <= 0) {
            range = "High";
        } else {
            range = "Premium";
        }

        record.setPriceRange(range);
    }
}