package com.evgen3.xmlparser.app.misc;

/**
 * Created by Евгений on 25.03.2014.
 */
public class State {
    private String title,comment;

    public State(String title, String comment) {
        this.title = title;
        this.comment = comment;
    }

    public String getComment() {

        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
