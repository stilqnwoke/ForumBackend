package com.forum.forum.posts;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private long id;
    private String title;
    private Date madeOn;
    private String username;
    private String text;
    public Post() {
    }

    public Post(long id, String title, Date madeOn, String username, String text) {
        this.id = id;
        this.title = title;
        this.madeOn = madeOn;
        this.username = username;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getMadeOn() {
        return madeOn;
    }

    public void setMadeOn(Date madeOn) {
        this.madeOn = madeOn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", madeOn=" + madeOn +
                ", username='" + username + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
