package swd.entity.model;

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

	@EmbeddedId
	private BlogcommentPK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date commentTime;

	@Lob
	private String content;

	public Blogcomment() {
	}

	public BlogcommentPK getId() {
		return this.id;
	}

	public void setId(BlogcommentPK id) {
		this.id = id;
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