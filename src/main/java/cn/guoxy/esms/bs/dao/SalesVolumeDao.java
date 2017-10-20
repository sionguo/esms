package cn.guoxy.esms.bs.dao;

import java.util.Map;

/**
 * 销量持久层接口
 * 
 * @author gxy
 *
 */
public interface SalesVolumeDao {
	/**
	 * 获得各类型商品销量信息
	 * 
	 */
	Map<String, Integer> getSalesVolume();
}
