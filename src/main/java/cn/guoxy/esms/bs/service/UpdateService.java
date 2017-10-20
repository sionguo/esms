package cn.guoxy.esms.bs.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cn.guoxy.esms.bs.entity.SmallType;
import cn.guoxy.esms.commons.entity.Goods;

/**
 * 上传商品业务层接口
 * 
 * @author gxy
 *
 */
public interface UpdateService {
	/**
	 * 得到分类信息
	 * 
	 * @param btId
	 *            大类型Id
	 */
	List<SmallType> getSmallType(int btId);

	/**
	 * 保存商品
	 * 
	 * @param goods
	 *            商品对象
	 */
	void saveGoods(Goods goods);

	/**
	 * 判断表单是否重复提交
	 * 
	 * @param request
	 *            请求对象
	 * @return 返回boolean类型 重复提交返回true
	 */
	boolean isRepeatSubmit(HttpServletRequest request);
}
