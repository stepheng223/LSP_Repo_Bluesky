package org.howard.edu.lsp.assignment3;

/**
 * Entry point for Assignment 3 ETL pipeline.
 * Preserves the same relative paths, behavior, and outputs as Assignment 2.
 */
public class ETLDriver {
    public static void main(String[] args) {
        ETLPipeline pipeline = ETLPipeline.defaultPipeline();
        pipeline.run();
    }
}