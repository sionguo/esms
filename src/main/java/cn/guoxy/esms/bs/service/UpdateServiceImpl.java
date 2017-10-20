package cn.guoxy.esms.bs.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import cn.guoxy.esms.bs.dao.GoodsTypeDao;
import cn.guoxy.esms.bs.entity.SmallType;
import cn.guoxy.esms.commons.dao.GoodsDao;
import cn.guoxy.esms.commons.entity.Goods;

/**
 * 商品上传业务层实现类
 * 
 * @author gxy
 *
 */
@Service("updateService")
public class UpdateServiceImpl implements UpdateService {
	@Resource(name = "goodsTypeDao")
	private GoodsTypeDao dao;
	@Resource(name = "goodsDao")
	private GoodsDao goodsDao;

	public List<SmallType> getSmallType(int btId) {
		List<SmallType> list = dao.getSmallType(btId);
		return list;
	}

	public void saveGoods(Goods goods) {
		goodsDao.saveGoods(goods);
	}

	public boolean isRepeatSubmit(HttpServletRequest request) {
		String client_token = request.getParameter("token");
		// 1、如果用户提交的表单数据中没有token，则用户是重复提交了表单
		if (client_token == null) {
			return true;
		}
		// 取出存储在Session中的token
		String server_token = (String) request.getSession().getAttribute("token");
		// 2、如果当前用户的Session中不存在Token(令牌)，则用户是重复提交了表单
		if (server_token == null) {
			return true;
		}
		// 3、存储在Session中的Token(令牌)与表单提交的Token(令牌)不同，则用户是重复提交了表单
		if (!client_token.equals(server_token)) {
			return true;
		}

		return false;
	}

}
