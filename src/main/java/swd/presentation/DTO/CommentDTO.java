package swd.presentation.DTO;

import java.util.Date; 
public class CommentDTO {
    private Date commentTime; 
    private String content;
    private String authorName;
    private int blogId;
    public Date getCommentTime() {
        return commentTime;
    }
    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public CommentDTO() {
        // TODO Auto-generated constructor stub
    }
    public CommentDTO(Date commentTime, String content, String authorName) {
        super();
        this.commentTime = commentTime;
        this.content = content;
        this.authorName = authorName;
    }
    public int getBlogId() {
        return blogId;
    }
    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }
    
}
