package com.example.android;

public class Link {

    private String full_link;
    private String abbreviated_link;

    public Link(String full_link, String abbreviated_link) {
        this.full_link = full_link;
        this.abbreviated_link = abbreviated_link;
    }

    public String getFull_link() {
        return full_link;
    }

    public void setFull_link(String full_link) {
        this.full_link = full_link;
    }

    public String getAbbreviated_link() {
        return abbreviated_link;
    }

    public void setAbbreviated_link(String abbreviated_link) {
        this.abbreviated_link = abbreviated_link;
    }
}
