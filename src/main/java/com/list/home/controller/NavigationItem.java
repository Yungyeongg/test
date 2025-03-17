package com.list.home.controller;

import java.util.List;

public class NavigationItem {
    private String title;
    private List<String> subTitles;

    public NavigationItem() {}

    public NavigationItem(String title, List<String> subTitles) {
        this.title = title;
        this.subTitles = subTitles;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getSubTitles() {
        return subTitles;
    }

    public void setSubTitles(List<String> subTitles) {
        this.subTitles = subTitles;
    }
}
