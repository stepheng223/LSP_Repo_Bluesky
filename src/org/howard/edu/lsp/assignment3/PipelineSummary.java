package org.howard.edu.lsp.assignment3;

/**
 * Tracks and prints pipeline summary stats identical to Assignment 2.
 */
public class PipelineSummary {
    private int rowsRead = 0;        // non-header lines encountered (including bad ones)
    private int rowsTransformed = 0; // valid rows written (in A3: valid records after parsing)
    private int rowsSkipped = 0;     // skipped rows

    public void incrementRead() { rowsRead++; }
    public void incrementTransformed() { rowsTransformed++; }
    public void incrementSkipped() { rowsSkipped++; }

    public int getRowsRead() { return rowsRead; }
    public int getRowsTransformed() { return rowsTransformed; }
    public int getRowsSkipped() { return rowsSkipped; }

    public void print(String outputPath) {
        System.out.println("Rows read: " + rowsRead);
        System.out.println("Rows transformed: " + rowsTransformed);
        System.out.println("Rows skipped: " + rowsSkipped);
        System.out.println("Output written to: " + outputPath);
    }
}