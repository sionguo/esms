package cn.guoxy.esms.bs.service;

import java.util.Map;

/**
 * 销量业务层接口
 * 
 * @author gxy
 *
 */
public interface SalesVolumeService {
	/**
	 * 获取销量信息
	 * 
	 * @return
	 */
	Map<String, Integer> getSalesVolume();
}
