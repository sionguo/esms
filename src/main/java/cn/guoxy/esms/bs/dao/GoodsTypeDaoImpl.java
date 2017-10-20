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

import cn.guoxy.esms.bs.entity.SmallType;

/**
 * 商品类型持久化接口实现类
 * 
 * @author gxy
 *
 */
@Repository("goodsTypeDao")
public class GoodsTypeDaoImpl implements GoodsTypeDao {
	@Resource(name = "ds")
	private DataSource ds;

	public List<SmallType> getSmallType(int btId) {
		Connection conn = null;
		try {
			conn = ds.getConnection();
			List<SmallType> list = new ArrayList<SmallType>();
			String sql = "SELECT * FROM smalltype WHERE btId= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, btId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SmallType smallType = new SmallType();
				smallType.setStId(rs.getInt("stId"));
				smallType.setStName(rs.getString("stName"));
				smallType.setBtId(rs.getInt("btId"));
				list.add(smallType);
			}
			return list;
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
		return null;
	}

}
