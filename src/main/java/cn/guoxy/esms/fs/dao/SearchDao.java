package cn.guoxy.esms.fs.dao;

import java.util.List;

import cn.guoxy.esms.commons.entity.Goods;

/**
 * 查找商品持久层接口
 * 
 * @author gxy
 *
 */
public interface SearchDao {
	List<Goods> searchGoods(String patten);
}
