package cn.guoxy.esms.commons.dao;

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
import cn.guoxy.esms.commons.entity.OrderFormGoods;

/**
 * 商品持久层实现类
 * 
 * @author gxy
 *
 */
@Repository("goodsDao")
public class GoodsDaoImpl implements GoodsDao {
	@Resource(name = "ds")
	private DataSource ds;

	public int saveGoods(Goods goods) {
		Connection conn = null;
		int x = 0;
		try {
			conn = ds.getConnection();
			String sql = "INSERT INTO goods VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, goods.getGoodsName());
			ps.setString(2, goods.getGoodsShow());
			ps.setInt(3, goods.getGoodsPrice());
			ps.setInt(4, goods.getGoodsCount());
			ps.setInt(5, goods.getSeason());
			ps.setInt(6, goods.getBtId());
			ps.setInt(7, goods.getStId());
			ps.setString(8, goods.getSmallImg());
			ps.setString(9, goods.getBigImg());
			ps.setInt(10, goods.getClickNum());
			ps.setDate(11, goods.getUpdateTime());
			x = ps.executeUpdate();
			return x;
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

	public List<Goods> getNewGoods(Integer season) {
		Connection conn = null;
		Goods goods;
		List<Goods> list = new ArrayList<Goods>();
		try {
			conn = ds.getConnection();
			String sql = "SELECT goodsId,bigImg FROM goods WHERE season = ? ORDER BY updateTime DESC LIMIT 8";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, season);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				goods = new Goods();
				goods.setGoodsId(rs.getInt("goodsId"));
				goods.setBigImg(rs.getString("bigImg"));
				list.add(goods);
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

	public Goods findByGoodsId(Integer goodsId) {
		Goods goods = null;
		Connection conn = null;
		try {
			conn = ds.getConnection();
			String sql = "SELECT * FROM goods WHERE goodsId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, goodsId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
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
				return goods;
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
		return goods;
	}

	public int updateClickNum(Integer goodsId, int num) {
		Connection conn = null;
		int x = 0;
		try {
			conn = ds.getConnection();
			String sql = "UPDATE goods SET clickNum=? WHERE goodsId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			ps.setInt(2, goodsId);
			x = ps.executeUpdate();
			return x;
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

	public int updateGoodsCount(int goodsId, int goodsCout) {
		Connection conn = null;
		int x = 0;
		try {
			conn = ds.getConnection();
			String sql = "UPDATE goods SET goodsCount = ? WHERE goodsId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, goodsCout);
			ps.setInt(2, goodsId);
			x = ps.executeUpdate();
			return x;
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

	public List<Goods> findAllGoods() {
		Connection conn = null;
		List<Goods> list = new ArrayList<Goods>();
		try {
			conn = ds.getConnection();
			String sql = "SELECT * FROM goods ORDER BY goods.goodsCount ASC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Goods goods;
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

	public int deleteGoods(int goodId) {
		Connection conn = null;
		int x = 0;
		try {
			conn = ds.getConnection();
			String sql = "DELETE FROM goods WHERE goodsId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, goodId);
			x = ps.executeUpdate();
			return x;
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

	public List<Goods> findHotGoods() {
		Connection conn = null;
		List<Goods> list = new ArrayList<Goods>();
		try {
			conn = ds.getConnection();
			String sql = "SELECT * FROM goods ORDER BY goods.clickNum DESC LIMIT 8";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Goods goods;
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
