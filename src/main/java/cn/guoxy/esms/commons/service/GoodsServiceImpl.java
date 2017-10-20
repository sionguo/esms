package cn.guoxy.esms.commons.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.guoxy.esms.commons.dao.GoodsDao;
import cn.guoxy.esms.commons.entity.Goods;

/**
 * 商品业务层实现类
 * 
 * @author gxy
 *
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
	@Resource(name = "goodsDao")
	private GoodsDao dao;

	public void saveGoods(Goods goods) {
		dao.saveGoods(goods);
	}

	public List<Goods> getNewGoods(Integer season) {
		List<Goods> list = dao.getNewGoods(season);
		return list;
	}

	public Goods findByGoodsId(Integer goodsId) {
		Goods goods = dao.findByGoodsId(goodsId);
		return goods;
	}

	public void updateClickNum(Integer goodsId) {
		Goods goods = dao.findByGoodsId(goodsId);
		int num = goods.getClickNum();
		synchronized (this) {
			num++;
		}
		dao.updateClickNum(goodsId, num);
	}

	public void updateGoodsCount(int goodsId, int num) {
		Goods goods = dao.findByGoodsId(goodsId);
		int count = goods.getGoodsCount();
		synchronized (this) {
			count -= num;
		}
		dao.updateGoodsCount(goodsId, count);

	}

	public List<Goods> getHotGoods() {
		List<Goods> list = dao.findHotGoods();
		return list;
	}

}
