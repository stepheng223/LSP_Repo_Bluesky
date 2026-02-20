package org.howard.edu.lsp.assignment3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.List;

/**
 * Load step: writes output CSV in the exact A2 format.
 */
public class CsvProductWriter {

    /**
     * Writes the required header and each transformed record.
     */
    public void write(String outputPath, List<ProductRecord> records) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))) {
            // Always write required output header row (exactly A2)
            bw.write("ProductID,Name,Price,Category,PriceRange");
            bw.newLine();

            for (ProductRecord r : records) {
                // A2 used formatTwoDecimals(outPrice) where outPrice already half-up 2dp
                String priceStr = r.getPrice().setScale(2, RoundingMode.HALF_UP).toPlainString();

                bw.write(r.getProductId() + "," + r.getName() + "," + priceStr + ","
                        + r.getCategory() + "," + r.getPriceRange());
                bw.newLine();
            }
        }
    }
}
