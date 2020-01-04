package com.company.talend.components.processor;

public class Error {
    private String row;
    private String fileName;
    private String workflowError;
    private String runtimeError;

    public Error() {
    }

    public Error(String row, String fileName, String workflowError, String runtimeError) {
        this.row = row;
        this.fileName = fileName;
        this.workflowError = workflowError;
        this.runtimeError = runtimeError;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getWorkflowError() {
        return workflowError;
    }

    public void setWorkflowError(String workflowError) {
        this.workflowError = workflowError;
    }

    public String getRuntimeError() {
        return runtimeError;
    }

    public void setRuntimeError(String runtimeError) {
        this.runtimeError = runtimeError;
    }
}
