package swd.persistence.DAO;

import java.util.List;

import swd.persistence.entity.model.Blogcomment;



public interface BlogCommentRepository {
    public List<Blogcomment> getCommentByBlogId(int blogId);
	public boolean create(Blogcomment blogComment);
	public boolean delete(int commentId);
	public boolean updateInfor(Blogcomment blogComment);
}
