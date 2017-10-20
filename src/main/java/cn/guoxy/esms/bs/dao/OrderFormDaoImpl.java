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

import cn.guoxy.esms.commons.entity.OrderFormGoods;

/**
 * 订单管理持久层实现类
 * 
 * @author gxy
 *
 */
@Repository("orderDao")
public class OrderFormDaoImpl implements OrderFormDao {
	@Resource(name = "ds")
	private DataSource ds;

	public List<OrderFormGoods> findAllOrderForm() {

		Connection conn = null;
		List<OrderFormGoods> list = new ArrayList<OrderFormGoods>();
		try {
			conn = ds.getConnection();
			String sql = "SELECT * FROM goods JOIN orderform ON goods.goodsId = orderform.goodsId "
					+ "WHERE orderform.`status` <> 3 " + "ORDER BY orderform.`status` ASC";
			PreparedStatement ps = conn.prepareStatement(sql);
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
				goods.setUserId(rs.getInt("userId"));
				goods.setOrderId(rs.getInt("orderId"));
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

	public int removeOrderForm(int orderId) {

		Connection conn = null;
		int x = 0;
		try {
			conn = ds.getConnection();
			String sql = "DELETE FROM orderform WHERE orderId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, orderId);
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

	public int updateStatus(int orderId, int status) {

		Connection conn = null;
		int x = 0;
		try {
			conn = ds.getConnection();
			String sql = "UPDATE orderform SET `status` =? WHERE orderId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, status);
			ps.setInt(2, orderId);
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
