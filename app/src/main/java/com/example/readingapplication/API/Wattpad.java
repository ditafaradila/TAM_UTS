package com.example.readingapplication.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Wattpad {
    @SerializedName("stories")
    @Expose
    private ArrayList<Story> stories = null;
    @SerializedName("nextUrl")
    @Expose
    private String nextUrl;

    public ArrayList<Story> getStories() {
        return stories;
    }

    public void setStories(ArrayList<Story> stories) {
        this.stories = stories;
    }

    public String getNextUrl() {
        return nextUrl;
    }

    public void setNextUrl(String nextUrl) {
        this.nextUrl = nextUrl;
    }

}
