package swd.entity.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the blogcategory database table.
 * 
 */
@Embeddable
public class BlogcategoryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int categoryID;

	@Column(insertable=false, updatable=false)
	private int blogID;

	public BlogcategoryPK() {
	}
	public int getCategoryID() {
		return this.categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
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
		if (!(other instanceof BlogcategoryPK)) {
			return false;
		}
		BlogcategoryPK castOther = (BlogcategoryPK)other;
		return 
			(this.categoryID == castOther.categoryID)
			&& (this.blogID == castOther.blogID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.categoryID;
		hash = hash * prime + this.blogID;
		
		return hash;
	}
}