package swd.presentation.DTO;

import java.util.Date; 

public class BlogDTO {
    private int blogID;
 
    private String content;
 
    private String imageUrl;
 
    private Date lastUpdateDay;

    private int numberOfComment;

    private int numberOfLike;
 
    private Date publishedDay;

    private String title;
    private String authorName;
    private int userID;
    public int getBlogID() {
        return blogID;
    }
    public void setBlogID(int blogID) {
        this.blogID = blogID;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public Date getLastUpdateDay() {
        return lastUpdateDay;
    }
    public void setLastUpdateDay(Date lastUpdateDay) {
        this.lastUpdateDay = lastUpdateDay;
    }
    public int getNumberOfComment() {
        return numberOfComment;
    }
    public void setNumberOfComment(int numberOfComment) {
        this.numberOfComment = numberOfComment;
    }
    public int getNumberOfLike() {
        return numberOfLike;
    }
    public void setNumberOfLike(int numberOfLike) {
        this.numberOfLike = numberOfLike;
    }
    public Date getPublishedDay() {
        return publishedDay;
    }
    public void setPublishedDay(Date publishedDay) {
        this.publishedDay = publishedDay;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public BlogDTO(int blogID, String content, String imageUrl, Date lastUpdateDay, int numberOfComment,
            int numberOfLike, Date publishedDay, String title, String authorName, int userID) {
        super();
        this.blogID = blogID;
        this.content = content;
        this.imageUrl = imageUrl;
        this.lastUpdateDay = lastUpdateDay;
        this.numberOfComment = numberOfComment;
        this.numberOfLike = numberOfLike;
        this.publishedDay = publishedDay;
        this.title = title;
        this.authorName = authorName;
        this.userID = userID;
    }
    public BlogDTO() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public String toString() {
       
        return this.authorName+" "+this.blogID+" "+this.content+" "+this.imageUrl+" "+this.numberOfComment+" "+this.numberOfLike+" "+this.title+" "+this.userID;
    }
}
