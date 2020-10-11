package dao;

import java.util.List;

import model.Blog;

public interface BlogDaoInterface {

	void insertBlog(Blog blog);

	List selectAllBlogs();
}