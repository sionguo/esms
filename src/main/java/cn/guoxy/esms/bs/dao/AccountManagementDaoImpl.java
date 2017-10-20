package cn.guoxy.esms.bs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import cn.guoxy.esms.bs.entity.Admin;
import cn.guoxy.esms.fs.entity.User;

/**
 * 账号管理实体类
 * 
 * @author gxy
 *
 */
@Repository("accountManagementDao")
public class AccountManagementDaoImpl implements AccountManagementDao {
	@Resource(name = "ds")
	private DataSource ds;

	public List<User> findAllUser() {
		Connection conn = null;
		List<User> list = null;
		try {
			conn = ds.getConnection();
			String sql = "SELECT * FROM `user`";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			list = new ArrayList<User>();
			while (rs.next()) {
				int id = rs.getInt("id");
				String userName = rs.getString("userName");
				String pwd = rs.getString("pwd");
				int vip = rs.getInt("vip");
				String email = rs.getString("email");
				User user = new User(id, email, userName, pwd, vip);
				list.add(user);
			}
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
		return list;
	}

	public List<Admin> findAllAdmin() {
		Connection conn = null;
		List<Admin> list = null;
		try {
			conn = ds.getConnection();
			String sql = "SELECT * FROM admin";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			list = new ArrayList<Admin>();
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setAdminId(rs.getInt("adminId"));
				admin.setAdminName(rs.getString("adminName"));
				admin.setAdminPwd(rs.getString("adminPwd"));
				list.add(admin);
			}
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
		return list;
	}

	public int addAdmin(Admin admin) {
		Connection conn = null;
		int x = 0;
		try {
			conn = ds.getConnection();
			String sql = "INSERT INTO admin VALUES(null , ?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, admin.getAdminName());
			ps.setString(2, admin.getAdminPwd());
			x = ps.executeUpdate();
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
		return x;
	}

	public int deleteAdmin(int adminId) {
		Connection conn = null;
		int x = 0;
		try {
			conn = ds.getConnection();
			String sql = "DELETE FROM admin WHERE adminId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, adminId);
			x = ps.executeUpdate();
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
		return x;
	}

}
