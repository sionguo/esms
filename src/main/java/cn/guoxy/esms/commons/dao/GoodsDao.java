package cn.guoxy.esms.commons.dao;

import java.util.List;

import cn.guoxy.esms.commons.entity.Goods;

/**
 * 商品持久层接口
 * 
 * @author gxy
 *
 */
public interface GoodsDao {
	/**
	 * 保存商品
	 * 
	 * @param goods
	 *            商品对象
	 * @return 记录更改的条数
	 */
	int saveGoods(Goods goods);

	/**
	 * 获得最新商品
	 * 
	 * @param season
	 *            商品适用季节
	 * @return 符合条件的商品
	 */
	List<Goods> getNewGoods(Integer season);

	/**
	 * 根据商品ID查找商品
	 */
	Goods findByGoodsId(Integer goodsId);

	/**
	 * 更新商品点击数
	 * 
	 * @param goodsId
	 *            商品ID
	 * @param num
	 *            更新后的点击数
	 * @return 记录更改的条数
	 */
	int updateClickNum(Integer goodsId, int num);

	/**
	 * 更新商品库存
	 * 
	 * @param goodsId
	 *            商品ID
	 * @param goodsCout
	 *            商品总量
	 * @return 记录更改的条数
	 */
	int updateGoodsCount(int goodsId, int goodsCout);

	/**
	 * 查询所有商品
	 * 
	 */
	List<Goods> findAllGoods();

	/**
	 * 删除商品
	 * 
	 * @return
	 */
	int deleteGoods(int goodId);

	/**
	 * 得到点击数最高的8条记录
	 * 
	 */
	List<Goods> findHotGoods();

}
