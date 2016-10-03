package swd.persistence.entity.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the publishedblog database table.
 * 
 */
@Entity
public class Publishedblog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int blogID;

	@Lob
	private String content;

	@Lob
	private String imageUrl;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdateDay;

	private int numberOfComment;

	private int numberOfLike;

	private byte published;

	@Temporal(TemporalType.TIMESTAMP)
	private Date publishedDay;

	private String title;
	private String authorName;
	private int userID;

	public Publishedblog() {
	}

	public int getBlogID() {
		return this.blogID;
	}

	public void setBlogID(int blogID) {
		this.blogID = blogID;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Date getLastUpdateDay() {
		return this.lastUpdateDay;
	}

	public void setLastUpdateDay(Date lastUpdateDay) {
		this.lastUpdateDay = lastUpdateDay;
	}

	public int getNumberOfComment() {
		return this.numberOfComment;
	}

	public void setNumberOfComment(int numberOfComment) {
		this.numberOfComment = numberOfComment;
	}

	public int getNumberOfLike() {
		return this.numberOfLike;
	}

	public void setNumberOfLike(int numberOfLike) {
		this.numberOfLike = numberOfLike;
	}

	public byte getPublished() {
		return this.published;
	}

	public void setPublished(byte published) {
		this.published = published;
	}

	public Date getPublishedDay() {
		return this.publishedDay;
	}

	public void setPublishedDay(Date publishedDay) {
		this.publishedDay = publishedDay;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getUserID() {
		return this.userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

}