package com.pojo;

public class Workspace {

    private String name;
    private String type;
    private String discription;

    public Workspace(String name, String type, String discription) {
        this.name = name;
        this.type = type;
        this.discription = discription;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }


    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDiscription() {
        return discription;
    }


}
