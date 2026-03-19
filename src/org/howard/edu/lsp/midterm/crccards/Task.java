package org.howard.edu.lsp.midterm.crccards;

/**
 * Represents a task with an ID, description, and status.
 * A task can be OPEN, IN_PROGRESS, COMPLETE, or UNKNOWN.
 *
 * @author Stephen Ganthier
 */
public class Task {
    private String taskId;
    private String description;
    private String status;

    /**
     * Creates a new Task with default status OPEN.
     * @param taskId unique identifier
     * @param description task description
     */
    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = "OPEN";
    }

    public String getTaskId() {
        return taskId;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    /**
     * Updates the status of the task.
     * If invalid, sets status to UNKNOWN.
     * @param status new status
     */
    public void setStatus(String status) {
        if (status.equals("OPEN") || status.equals("IN_PROGRESS") || status.equals("COMPLETE")) {
            this.status = status;
        } else {
            this.status = "UNKNOWN";
        }
    }

    @Override
    public String toString() {
        return taskId + " " + description + " [" + status + "]";
    }
}