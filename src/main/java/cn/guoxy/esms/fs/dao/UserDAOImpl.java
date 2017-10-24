package cn.guoxy.esms.fs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import cn.guoxy.esms.fs.entity.User;

/**
 * 用户相关持久层实现类
 * 
 * @author gxy
 *
 */
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	@Resource(name = "ds")
	private DataSource ds;

	public User findByname(String name) {
		Connection conn = null;
		User user = null;
		try {
			conn = ds.getConnection();
			String sql = "SELECT * FROM user WHERE userName = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String userName = rs.getString("userName");
				String email = rs.getString("email");
				String pwd = rs.getString("pwd");
				int vip = rs.getInt("vip");
				user = new User(id, email, userName, pwd, vip);
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	public void save(User user) {
		Connection conn = null;
		try {
			conn = ds.getConnection();
			String sql = "INSERT INTO user VALUES(?,?,?,?,?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, 0);
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPwd());
			ps.setInt(5, 0);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public User findByid(int id1) {
		Connection conn = null;
		User user = null;
		try {
			conn = ds.getConnection();
			String sql = "SELECT * FROM user WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id1);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String userName = rs.getString("userName");
				String pwd = rs.getString("pwd");
				int vip = rs.getInt("vip");
				user = new User(id, userName, pwd, vip);
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	public User findByEmail(String email) {
		Connection conn = null;
		User user = null;
		try {
			conn = ds.getConnection();
			String sql = "SELECT * FROM user WHERE email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String userName = rs.getString("userName");
				String pwd = rs.getString("pwd");
				String email1 = rs.getString("email");
				int vip = rs.getInt("vip");
				user = new User(id, email1, userName, pwd, vip);
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	public int updatePwd(String Pwd, String email) {
		Connection conn = null;
		int x = 0;
		try {
			conn = ds.getConnection();
			String sql = "UPDATE `user` SET pwd = ? WHERE email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Pwd);
			ps.setString(2, email);
			x = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return x;
	}

}
