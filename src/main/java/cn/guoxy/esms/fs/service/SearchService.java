package cn.guoxy.esms.fs.service;

import java.util.List;

import cn.guoxy.esms.commons.entity.Goods;

/**
 * 搜索业务层接口
 * 
 * @author gxy
 *
 */
public interface SearchService {
	/**
	 * 搜索商品
	 * 
	 * @param patten
	 * @return
	 */
	List<Goods> searchGoods(String patten);
}
