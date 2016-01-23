package com.amusoft.ultipedia;

/**
 * Created by irving on 4/10/15.
 */
public class ListItem {

    private String name;
    private String score;
    public ListItem(String name, String score) {

        this.setName(name);
        this.setScore(score);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score= score;
    }


}
