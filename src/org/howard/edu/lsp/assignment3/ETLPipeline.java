package org.howard.edu.lsp.assignment3;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Orchestrates Extract -> Transform -> Load while preserving Assignment 2 behavior.
 */
public class ETLPipeline {
    public static final String INPUT_PATH = "data/products.csv";
    public static final String OUTPUT_PATH = "data/transformed_products.csv";

    private final CsvProductReader reader;
    private final CsvProductWriter writer;
    private final List<Transformer> transformers;

    public ETLPipeline(CsvProductReader reader, CsvProductWriter writer, List<Transformer> transformers) {
        this.reader = reader;
        this.writer = writer;
        this.transformers = transformers;
    }

    /**
     * Builds the pipeline with the exact same transformation order as A2.
     */
    public static ETLPipeline defaultPipeline() {
        return new ETLPipeline(
                new CsvProductReader(),
                new CsvProductWriter(),
                Arrays.asList(
                        new UppercaseNameTransformer(),
                        new ElectronicsDiscountTransformer(),
                        new PremiumCategoryTransformer(),
                        new PriceRangeTransformer()
                )
        );
    }

    /**
     * Runs the pipeline, matching A2 error handling + summary printing.
     */
    public void run() {
        File inputFile = new File(INPUT_PATH);

        // Case C: Missing input file -> clear error message, clean exit (no stack trace)
        if (!inputFile.exists()) {
            System.out.println("ERROR: Missing input file: " + INPUT_PATH);
            return;
        }

        PipelineSummary summary = new PipelineSummary();

        try {
            List<ProductRecord> records = reader.read(INPUT_PATH, summary);

            // Apply transforms in exact order
            for (ProductRecord r : records) {
                for (Transformer t : transformers) {
                    t.apply(r);
                }
                summary.incrementTransformed();
            }

            writer.write(OUTPUT_PATH, records);

        } catch (IOException e) {
            // Avoid stack trace (keep it clean)
            System.out.println("ERROR: Unable to process files: " + e.getMessage());
            return;
        }

        summary.print(OUTPUT_PATH);
    }
}