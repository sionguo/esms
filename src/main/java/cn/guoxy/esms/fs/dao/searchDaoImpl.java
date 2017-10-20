package cn.guoxy.esms.fs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import cn.guoxy.esms.commons.entity.Goods;

@Repository("searchDao")
public class searchDaoImpl implements SearchDao {
	@Resource(name = "ds")
	private DataSource ds;

	public List<Goods> searchGoods(String patten) {
		Goods goods = null;
		Connection conn = null;
		List<Goods> list = new ArrayList<Goods>();
		try {
			conn = ds.getConnection();
			String sql = "SELECT * "
					+ "FROM goods "
					+ "WHERE goods.goodsName LIKE ? OR "
					+ "goods.goodsShow = ? OR "
					+ "goods.stId IN ( "
					+ "SELECT smalltype.stId "
					+ "FROM smalltype "
					+ "WHERE stName LIKE ? )";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, patten);
			ps.setString(2, patten);
			ps.setString(3, patten);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				goods = new Goods();
				goods.setGoodsId(rs.getInt("goodsId"));
				goods.setGoodsName(rs.getString("goodsName"));
				goods.setGoodsShow(rs.getString("goodsShow"));
				goods.setGoodsPrice(rs.getInt("goodsPrice"));
				goods.setGoodsCount(rs.getInt("goodsCount"));
				goods.setSeason(rs.getInt("season"));
				goods.setBtId(rs.getInt("btId"));
				goods.setStId(rs.getInt("stId"));
				goods.setSmallImg(rs.getString("smallImg"));
				goods.setBigImg(rs.getString("bigImg"));
				goods.setClickNum(rs.getInt("clickNum"));
				goods.setUpdateTime(rs.getDate("updateTime"));
				list.add(goods);
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
		return list;
	}

}
