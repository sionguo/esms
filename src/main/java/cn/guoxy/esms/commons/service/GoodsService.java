package cn.guoxy.esms.commons.service;

import java.util.List;

import cn.guoxy.esms.commons.entity.Goods;

/**
 * 商品业务层接口
 * 
 * @author gxy
 *
 */
public interface GoodsService {
	/**
	 * 保存商品
	 * 
	 * @param goods
	 *            商品对象
	 */
	void saveGoods(Goods goods);

	/**
	 * 得到当季最新商品
	 * 
	 * @param season
	 *            季节
	 * @return
	 */
	List<Goods> getNewGoods(Integer season);

	/**
	 * 通过ID查询商品
	 * 
	 * @param goodsId
	 *            商品ID
	 * @return
	 */
	Goods findByGoodsId(Integer goodsId);

	/**
	 * 更新点击数
	 * 
	 * @param goodsId
	 *            商品ID
	 */
	void updateClickNum(Integer goodsId);

	void updateGoodsCount(int goodsId, int num);

	List<Goods> getHotGoods();
}
