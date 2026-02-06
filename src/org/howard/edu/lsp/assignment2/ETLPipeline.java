package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ETLPipeline {

    private static final String INPUT_PATH = "data/products.csv";
    private static final String OUTPUT_PATH = "data/transformed_products.csv";

    public static void main(String[] args) {
        File inputFile = new File(INPUT_PATH);

        // Case C: Missing input file -> clear error message, clean exit (no stack trace)
        if (!inputFile.exists()) {
            System.out.println("ERROR: Missing input file: " + INPUT_PATH);
            return;
        }

        int rowsRead = 0;        // non-header lines encountered (including bad ones)
        int rowsTransformed = 0; // valid rows written
        int rowsSkipped = 0;     // skipped rows

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_PATH))) {

            // Read header line (could be null if file is truly empty)
            String header = br.readLine();

            // Always write required output header row
            bw.write("ProductID,Name,Price,Category,PriceRange");
            bw.newLine();

            // Case B: Empty input file (header only) or truly empty file
            if (header == null) {
                printSummary(rowsRead, rowsTransformed, rowsSkipped, OUTPUT_PATH);
                return;
            }

            String line;
            while ((line = br.readLine()) != null) {
                rowsRead++;

                // Skip blank lines
                if (line.trim().isEmpty()) {
                    rowsSkipped++;
                    continue;
                }

                // Must contain exactly 4 comma-separated fields
                String[] parts = line.split(",", -1);
                if (parts.length != 4) {
                    rowsSkipped++;
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
                    rowsSkipped++;
                    continue;
                }

                // Parse Price
                BigDecimal price;
                try {
                    price = new BigDecimal(priceStr);
                } catch (NumberFormatException e) {
                    rowsSkipped++;
                    continue;
                }

                // ---------------- TRANSFORM (EXACT ORDER) ----------------

                // 1) Convert product name to UPPERCASE
                String outName = name.toUpperCase();

                // Remember original category for rule #3
                String originalCategory = category;

                // 2) If category is "Electronics", apply 10% discount
                BigDecimal outPrice = price;
                if ("Electronics".equals(originalCategory)) {
                    outPrice = outPrice.multiply(new BigDecimal("0.90"));
                }

                // Round HALF-UP to exactly 2 decimals (final rounded price)
                outPrice = outPrice.setScale(2, RoundingMode.HALF_UP);

                // 3) If final rounded price > 500.00 AND original category was "Electronics",
                //    change category to "Premium Electronics"
                String outCategory = category;
                if ("Electronics".equals(originalCategory) && outPrice.compareTo(new BigDecimal("500.00")) > 0) {
                    outCategory = "Premium Electronics";
                }

                // 4) PriceRange based on final rounded price
                String priceRange = getPriceRange(outPrice);

                // ---------------- LOAD ----------------
                bw.write(productId + "," + outName + "," + formatTwoDecimals(outPrice) + "," + outCategory + "," + priceRange);
                bw.newLine();

                rowsTransformed++;
            }

        } catch (IOException e) {
            // Avoid stack trace (keep it clean)
            System.out.println("ERROR: Unable to process files: " + e.getMessage());
            return;
        }

        printSummary(rowsRead, rowsTransformed, rowsSkipped, OUTPUT_PATH);
    }

    private static String getPriceRange(BigDecimal p) {
        if (p.compareTo(new BigDecimal("10.00")) <= 0) {
            return "Low";
        } else if (p.compareTo(new BigDecimal("100.00")) <= 0) {
            return "Medium";
        } else if (p.compareTo(new BigDecimal("500.00")) <= 0) {
            return "High";
        } else {
            return "Premium";
        }
    }

    private static String formatTwoDecimals(BigDecimal value) {
        return value.setScale(2, RoundingMode.HALF_UP).toPlainString();
    }

    private static void printSummary(int rowsRead, int rowsTransformed, int rowsSkipped, String outputPath) {
        System.out.println("Rows read: " + rowsRead);
        System.out.println("Rows transformed: " + rowsTransformed);
        System.out.println("Rows skipped: " + rowsSkipped);
        System.out.println("Output written to: " + outputPath);
    }
}
