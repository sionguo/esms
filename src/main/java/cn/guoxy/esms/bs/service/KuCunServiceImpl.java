package cn.guoxy.esms.bs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.guoxy.esms.commons.dao.GoodsDao;
import cn.guoxy.esms.commons.entity.Goods;

/**
 * 库存管理业务层实现类
 * 
 * @author gxy
 *
 */
@Service("kuCunService")
public class KuCunServiceImpl implements KuCunService {
	@Resource(name = "goodsDao")
	private GoodsDao dao;

	public List<Goods> getKuCun() {
		// TODO Auto-generated method stub
		List<Goods> list = dao.findAllGoods();
		return list;
	}

	public void updateGoodsCount(int goodsId, int count) {
		dao.updateGoodsCount(goodsId, count);

	}

	public void deleteGoods(int goodId) {
		dao.deleteGoods(goodId);
	}

}
