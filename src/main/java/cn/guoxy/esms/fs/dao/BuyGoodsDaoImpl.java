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

import cn.guoxy.esms.commons.entity.GwcGoods;
import cn.guoxy.esms.commons.entity.OrderFormGoods;
import cn.guoxy.esms.fs.entity.Gwc;
import cn.guoxy.esms.fs.entity.OrderForm;

@Repository("buyGoodsDao")
public class BuyGoodsDaoImpl implements BuyGoodsDao {
	@Resource(name = "ds")
	private DataSource ds;

	public int saveGwc(Gwc gwc) {
		Connection conn = null;
		int x = 0;
		try {
			conn = ds.getConnection();
			String sql = "INSERT INTO gwc VALUES(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, gwc.getGwcId());
			ps.setInt(2, gwc.getGoodsId());
			ps.setInt(3, gwc.getUserId());
			ps.setInt(4, gwc.getCount());
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

	public int saveOrderForm(OrderForm orderFrom) {
		int x = 0;
		Connection conn = null;
		try {
			conn = ds.getConnection();
			String sql = "INSERT INTO orderForm VALUES(null,?,?,?,?,?,now());";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, orderFrom.getOrderNumber());
			ps.setInt(2, orderFrom.getUserId());
			ps.setInt(3, orderFrom.getGoodsId());
			ps.setInt(4, orderFrom.getStatus());
			ps.setInt(5, orderFrom.getCount());
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

	public List<OrderFormGoods> findByGoodsId_OrderForm(int userId) {
		Connection conn = null;
		List<OrderFormGoods> list = new ArrayList<OrderFormGoods>();
		try {
			conn = ds.getConnection();
			String sql = "SELECT * FROM goods JOIN orderform ON goods.goodsId = orderform.goodsId WHERE orderform.userId = ? ORDER BY orderform.`status` ASC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			OrderFormGoods goods;
			while (rs.next()) {
				goods = new OrderFormGoods();
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
				goods.setOrderNumber(rs.getString("orderNumber"));
				goods.setStatus(rs.getInt("status"));
				goods.setCount(rs.getInt("count"));
				goods.setCreateTime(rs.getDate("createTime"));
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

	public List<GwcGoods> findByGoodsId_gwc(int userId) {
		Connection conn = null;
		List<GwcGoods> list = new ArrayList<GwcGoods>();
		try {
			conn = ds.getConnection();
			String sql = "SELECT * FROM goods "
					+ "INNER JOIN gwc "
					+ "ON goods.goodsId = gwc.goodsId "
					+ "WHERE gwc.userId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			GwcGoods goods;
			while (rs.next()) {
				goods = new GwcGoods();
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
				goods.setCount(rs.getInt("count"));
				goods.setGwcId(rs.getInt("gwcId"));
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

	public int updateVip(int userId, int vip) {
		Connection conn = null;
		int x = 0;
		try {
			conn = ds.getConnection();
			String sql = "UPDATE `user` SET vip = ? WHERE id= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, vip);
			ps.setInt(2, userId);
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

	public int delgwc(int gwcId) {
		Connection conn = null;
		int x = 0;
		try {
			conn = ds.getConnection();
			String sql = "DELETE FROM gwc WHERE gwcId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, gwcId);
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
