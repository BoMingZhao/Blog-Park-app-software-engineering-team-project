package com.example.my_test6.Bean;

public class BlogSummary {
    private int id;
    private String title;
    private String Url;
    private String Description;
    private String Author;
    private String BlogApp;
    private String Avatar;
    private String PostDate;
    private int ViewCount;
    private int CommentCount;
    private int DiggCount;

    public BlogSummary(int id, String title, String url, String description, String author, String blogApp, String avatar, String postDate, int viewCount, int commentCount, int diggCount) {
        this.id = id;
        this.title = title;
        Url = url;
        Description = description;
        Author = author;
        BlogApp = blogApp;
        Avatar = avatar;
        PostDate = postDate;
        ViewCount = viewCount;
        CommentCount = commentCount;
        DiggCount = diggCount;
    }

    public BlogSummary() {
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return Url;
    }

    public String getDescription() {
        return Description;
    }

    public String getAuthor() {
        return Author;
    }

    public String getBlogApp() {
        return BlogApp;
    }

    public String getAvatar() {
        return Avatar;
    }

    public String getPostDate() {
        return PostDate;
    }

    public int getViewCount() {
        return ViewCount;
    }

    public int getCommentCount() {
        return CommentCount;
    }

    public int getDiggCount() {
        return DiggCount;
    }
}
