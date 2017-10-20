package cn.guoxy.esms.bs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

/**
 * 销量管理持久层实现类
 * 
 * @author gxy
 *
 */
@Repository("salesVolumeDao")
public class SalesVolumeDaoImpl implements SalesVolumeDao {
	@Resource(name = "ds")
	private DataSource ds;

	public Map<String, Integer> getSalesVolume() {

		Connection conn = null;
		Map<String, Integer> map = new HashMap<String, Integer>();
		try {
			conn = ds.getConnection();
			String sql = "SELECT Sum(orderform.count) AS count, goods.btId, bigtype.btName " + "FROM orderform "
					+ "INNER JOIN goods ON orderform.goodsId = goods.goodsId "
					+ "INNER JOIN bigtype ON goods.btId = bigtype.btId "
					+ "GROUP BY goods.btId ORDER BY goods.btId ASC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String btName = rs.getString("btName");
				int count = rs.getInt("count");
				map.put(btName, count);
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
		return map;

	}

}
