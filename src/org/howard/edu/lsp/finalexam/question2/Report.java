package org.howard.edu.lsp.finalexam.question2;

/**
 * Abstract base class for reports that follow a fixed Template Method workflow.
 */
public abstract class Report {
    /**
     * Template method that defines the fixed report generation workflow.
     */
    public final void generateReport() {
        loadData();
        System.out.println("=== HEADER ===");
        System.out.println(formatHeader());
        System.out.println();
        System.out.println("=== BODY ===");
        System.out.println(formatBody());
        System.out.println();
        System.out.println("=== FOOTER ===");
        System.out.println(formatFooter());
        System.out.println();
    }

    /**
     * Loads the data needed by the report.
     */
    protected abstract void loadData();

    /**
     * Formats the report-specific header.
     *
     * @return the formatted header text
     */
    protected abstract String formatHeader();

    /**
     * Formats the report-specific body.
     *
     * @return the formatted body text
     */
    protected abstract String formatBody();

    /**
     * Formats the report-specific footer.
     *
     * @return the formatted footer text
     */
    protected abstract String formatFooter();
}
