package cn.guoxy.esms.bs.dao;

import java.util.List;

import cn.guoxy.esms.bs.entity.SmallType;

/**
 * 商品类型持久层接口
 * 
 * @author gxy
 *
 */
public interface GoodsTypeDao {
	/**
	 * 根据大分类查询所有的小分类
	 * 
	 * @param btId
	 *            大分类Id
	 */
	List<SmallType> getSmallType(int btId);
}
