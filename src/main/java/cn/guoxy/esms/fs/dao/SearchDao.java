package cn.guoxy.esms.fs.dao;

import java.util.List;

import cn.guoxy.esms.commons.entity.Goods;

public interface SearchDao {
	List<Goods> searchGoods(String patten);
}
