package org.example;

public class Post {

    private int userId;

    private int id;

    private String title;

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("userId", userId)
                .append("id", id)
                .append("title", title)
                .append("body", body)
                .toString();
    }

    private String body;


    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getUserId() {
        return userId;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setBody(String body) {
        this.body = body;
    }
    public String getBody() {
        return body;
    }


}
