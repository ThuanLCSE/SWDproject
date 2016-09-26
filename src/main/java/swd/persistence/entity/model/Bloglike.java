package swd.persistence.entity.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bloglike database table.
 * 
 */
@Entity
public class Bloglike implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BloglikePK id;

	public Bloglike() {
	}

	public BloglikePK getId() {
		return this.id;
	}

	public void setId(BloglikePK id) {
		this.id = id;
	}

}