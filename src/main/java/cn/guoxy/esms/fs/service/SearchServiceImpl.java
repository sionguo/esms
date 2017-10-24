package cn.guoxy.esms.fs.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.guoxy.esms.commons.entity.Goods;
import cn.guoxy.esms.fs.dao.SearchDao;

/**
 * 搜索业务层实现类
 * 
 * @author gxy
 *
 */
@Service("searchService")
public class SearchServiceImpl implements SearchService {
	@Resource(name = "searchDao")
	private SearchDao dao;

	public List<Goods> searchGoods(String patten) {
		List<Goods> list = dao.searchGoods(patten);
		return list;
	}

}
