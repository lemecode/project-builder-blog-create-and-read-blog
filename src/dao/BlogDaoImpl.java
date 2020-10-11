package dao;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Blog;
import utility.ConnectionManager;

public class BlogDaoImpl implements BlogDaoInterface {

	@Override
	public void insertBlog(Blog blog) {
		// TODO Auto-generated method stub

		int id = blog.getBlogId();
		String title = blog.getBlogTitle();
		String description = blog.getBlogDescription();
		Date postedOn = blog.getPostedOn();

		String sql = "insert into blog values(?,?,?,?)";

		PreparedStatement st = null;
		try {
			st = ConnectionManager.getConnection().prepareStatement(sql);
			st.setInt(1, id);
			st.setString(2, title);
			st.setString(3, description);
			st.setDate(4, postedOn);

			st.executeUpdate();
			ConnectionManager.getConnection().close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Blog> selectAllBlogs() {
		// TODO Auto-generated method stub

		ArrayList<Blog> listBlog = new ArrayList<Blog>();

		String sql = "select * from blog";
		Blog blog = new Blog();
		try {
			Statement st = ConnectionManager.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				blog.setBlogId(rs.getInt(1));
				blog.setBlogTitle(rs.getString(2));
				blog.setBlogDescription(rs.getString(3));
				blog.setPostedOn(rs.getDate(4));

				listBlog.add(blog);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listBlog;

	}

}