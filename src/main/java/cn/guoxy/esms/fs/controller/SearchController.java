package cn.guoxy.esms.fs.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.guoxy.esms.commons.entity.Goods;
import cn.guoxy.esms.fs.service.SearchService;

/**
 * 搜索功能，
 * 
 * @author gxy
 *
 */
@Controller
public class SearchController {
	@Resource(name = "searchService")
	private SearchService searchService;

	/**
	 * 处理搜索的请求
	 * 
	 * @param request
	 * @return
	 */

	@RequestMapping("/search.do")
	@ResponseBody
	public List<Goods> search(HttpServletRequest request) {
		String patten = request.getParameter("keyword");
		patten = "%" + patten + "%";
		List<Goods> list = searchService.searchGoods(patten);
		return list;
	}
}
