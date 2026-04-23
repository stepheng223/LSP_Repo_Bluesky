package org.howard.edu.lsp.finalexam.question2;

/**
 * Report implementation for student data.
 */
public class StudentReport extends Report {
    private String studentName;
    private double gpa;

    /**
     * Loads the student report data.
     */
    @Override
    protected void loadData() {
        studentName = "Stephen Ganthier";
        gpa = 3.8;
    }

    /**
     * Formats the student report header.
     *
     * @return the student report header
     */
    @Override
    protected String formatHeader() {
        return "Student Report";
    }

    /**
     * Formats the student report body.
     *
     * @return the student report body
     */
    @Override
    protected String formatBody() {
        return "Student Name: " + studentName + "\nGPA: " + gpa;
    }

    /**
     * Formats the student report footer.
     *
     * @return the student report footer
     */
    @Override
    protected String formatFooter() {
        return "End of Student Report";
    }
}
