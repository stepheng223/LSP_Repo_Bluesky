package org.howard.edu.lsp.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Extract step: reads input CSV and returns only valid ProductRecord objects.
 * Must mirror A2 skipping rules + row counters.
 */
public class CsvProductReader {

    /**
     * Reads products from inputPath.
     * - Always reads (and ignores) the first line as header if present
     * - Counts rowsRead for every non-header line encountered
     * - Skips blank lines, wrong field counts, invalid ProductID, invalid Price
     */
    public List<ProductRecord> read(String inputPath, PipelineSummary summary) throws IOException {
        List<ProductRecord> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputPath))) {
            String header = br.readLine(); // could be null if file is truly empty

            // Case B: Empty input file (header only) or truly empty file
            if (header == null) {
                // A2 writes output header regardless; A3 will do that in writer
                return records;
            }

            String line;
            while ((line = br.readLine()) != null) {
                summary.incrementRead();

                // Skip blank lines
                if (line.trim().isEmpty()) {
                    summary.incrementSkipped();
                    continue;
                }

                // Must contain exactly 4 comma-separated fields
                String[] parts = line.split(",", -1);
                if (parts.length != 4) {
                    summary.incrementSkipped();
                    continue;
                }

                // Trim whitespace around each field
                String productIdStr = parts[0].trim();
                String name = parts[1].trim();
                String priceStr = parts[2].trim();
                String category = parts[3].trim();

                // Parse ProductID
                int productId;
                try {
                    productId = Integer.parseInt(productIdStr);
                } catch (NumberFormatException e) {
                    summary.incrementSkipped();
                    continue;
                }

                // Parse Price
                BigDecimal price;
                try {
                    price = new BigDecimal(priceStr);
                } catch (NumberFormatException e) {
                    summary.incrementSkipped();
                    continue;
                }

                // Valid record
                records.add(new ProductRecord(productId, name, price, category));
            }
        }

        return records;
    }
}