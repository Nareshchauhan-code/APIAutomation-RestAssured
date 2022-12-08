package com.pojo;

public class WorkspaceRoot {

    public WorkspaceRoot(Workspace workspace) {
        this.workspace = workspace;
    }

    public WorkspaceRoot() {
    }

    private Workspace workspace;

    public Workspace getWorkspace() {
        return workspace;
    }

    public void setWorkspace(Workspace workspace) {
        this.workspace = workspace;
    }



}
