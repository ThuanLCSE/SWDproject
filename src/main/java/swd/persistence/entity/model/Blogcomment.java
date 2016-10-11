package swd.persistence.entity.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the blogcomment database table.
 * 
 */
@Entity
public class Blogcomment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int commentID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date commentTime;
	
	private int userID;
 
    private int blogID; 
    
    public int getUserID() {
        return this.userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public int getBlogID() {
        return this.blogID;
    }
    public void setBlogID(int blogID) {
        this.blogID = blogID;
    }
	@Lob
	private String content;

	public Blogcomment() {
	}

	public int getId() {
		return this.commentID;
	}

	public void setId(int commentID) {
		this.commentID = commentID;
	}

	public Date getCommentTime() {
		return this.commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}