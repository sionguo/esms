package cn.guoxy.esms.bs.service;

import java.util.List;

import cn.guoxy.esms.commons.entity.Goods;

/**
 * 库存管理业务层接口
 * 
 * @author gxy
 *
 */
public interface KuCunService {
	/**
	 * 得到所有库存信息
	 * 
	 * @return
	 */
	List<Goods> getKuCun();

	/**
	 * 更新库存信息
	 * 
	 * @param goodsId
	 *            商品ID
	 * @param count
	 *            商品总量
	 */
	void updateGoodsCount(int goodsId, int count);

	/**
	 * 删除商品
	 * 
	 * @param goodId
	 *            商品ID
	 */
	void deleteGoods(int goodId);
}
