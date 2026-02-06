package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ETLPipeline {

    private static final String INPUT_PATH = "data/products.csv";
    private static final String OUTPUT_PATH = "data/transformed_products.csv";

    public static void main(String[] args) {

        File inputFile = new File(INPUT_PATH);

        // Case C: Missing input file
        if (!inputFile.exists()) {
            System.out.println("ERROR: Missing input file: " + INPUT_PATH);
            return;
        }

        int rowsRead = 0;
        int rowsTransformed = 0;
        int rowsSkipped = 0;

        File outputFile = new File(OUTPUT_PATH);
        outputFile.getParentFile().mkdirs();

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {

            // Always write header
            writer.write("ProductID,Name,Price,Category,PriceRange");
            writer.newLine();

            // Read header from input
            String header = reader.readLine();
            if (header == null) {
                printSummary(rowsRead, rowsTransformed, rowsSkipped, outputFile.getPath());
                return;
            }

            String line;
            while ((line = reader.readLine()) != null) {

                rowsRead++;

                if (line.trim().isEmpty()) {
                    rowsSkipped++;
                    continue;
                }

                String[] fields = line.split(",", -1);
                if (fields.length != 4) {
                    rowsSkipped++;
                    continue;
                }

                String idStr = fields[0].trim();
                String name = fields[1].trim();
                String priceStr = fields[2].trim();
                String category = fields[3].trim();

                int productId;
                BigDecimal price;

                try {
                    productId = Integer.parseInt(idStr);
                    price = new BigDecimal(priceStr);
                } catch (NumberFormatException e) {
                    rowsSkipped++;
                    continue;
                }

                // TRANSFORM 1: Name to uppercase
                name = name.toUpperCase();

                String originalCategory = category;

                // TRANSFORM 2: 10% discount for Electronics
                if (category.equals("Electronics")) {
                    price = price.multiply(new BigDecimal("0.90"));
                }

                // Round to two decimals
                price = price.setScale(2, RoundingMode.HALF_UP);

                // TRANSFORM 3: Premium Electronics
                if (originalCategory.equals("Electronics")
                        && price.compareTo(new BigDecimal("500.00")) > 0) {
                    category = "Premium Electronics";
                }

                // TRANSFORM 4: PriceRange
                String priceRange;
                if (price.compareTo(new BigDecimal("10.00")) <= 0) {
                    priceRange = "Low";
                } else if (price.compareTo(new BigDecimal("100.00")) <= 0) {
                    priceRange = "Medium";
                } else if (price.compareTo(new BigDecimal("500.00")) <= 0) {
                    priceRange = "High";
                } else {
                    priceRange = "Premium";
                }

                writer.write(productId + "," + name + "," + price + "," + category + "," + priceRange);
                writer.newLine();

                rowsTransformed++;
            }

            printSummary(rowsRead, rowsTransformed, rowsSkipped, outputFile.getPath());

        } catch (IOException e) {
            System.out.println("ERROR: File processing failed.");
        }
    }

    private static void printSummary(int read, int written, int skipped, String path) {
        System.out.println("Run Summary");
        System.out.println("Rows read (non-header): " + read);
        System.out.println("Rows transformed (written): " + written);
        System.out.println("Rows skipped: " + skipped);
        System.out.println("Output written to: " + path);

    }
}
