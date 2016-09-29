package swd.persistence.DAO;

import swd.persistence.entity.model.Blogcomment;



public interface BlogCommentRepository {

	public boolean create(Blogcomment blogComment);
	public boolean delete(Blogcomment blogComment);
	public boolean updateInfor(Blogcomment blogComment);
}
