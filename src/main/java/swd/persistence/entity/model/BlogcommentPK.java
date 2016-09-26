package swd.persistence.entity.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the blogcomment database table.
 * 
 */
@Embeddable
public class BlogcommentPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int userID;

	@Column(insertable=false, updatable=false)
	private int blogID;

	public BlogcommentPK() {
	}
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BlogcommentPK)) {
			return false;
		}
		BlogcommentPK castOther = (BlogcommentPK)other;
		return 
			(this.userID == castOther.userID)
			&& (this.blogID == castOther.blogID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userID;
		hash = hash * prime + this.blogID;
		
		return hash;
	}
}