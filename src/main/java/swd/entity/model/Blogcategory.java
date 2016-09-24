package swd.entity.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the blogcategory database table.
 * 
 */
@Entity
public class Blogcategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BlogcategoryPK id;

	private String blogTitle;

	public Blogcategory() {
	}

	public BlogcategoryPK getId() {
		return this.id;
	}

	public void setId(BlogcategoryPK id) {
		this.id = id;
	}

	public String getBlogTitle() {
		return this.blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

}