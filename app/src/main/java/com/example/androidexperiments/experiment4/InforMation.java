package com.example.androidexperiments.experiment4;

import java.io.Serializable;

public class InforMation implements Serializable {
    private String name;
    private String hobby;
    private String tag;

    public String getName() {
        return name;
    }

    public String getHobby() {
        return hobby;
    }

    public String getTag() {
        return tag;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
