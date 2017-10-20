package cn.guoxy.esms.fs.service;

import java.util.List;

import cn.guoxy.esms.commons.entity.Goods;

public interface SearchService {
	List<Goods> searchGoods(String patten);
}
