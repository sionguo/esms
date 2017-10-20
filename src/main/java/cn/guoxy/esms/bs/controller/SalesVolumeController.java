package cn.guoxy.esms.bs.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.guoxy.esms.bs.service.SalesVolumeService;

/**
 * 销量处理相关
 * 
 * @author gxy
 *
 */
@Controller
@RequestMapping("/bs/")
public class SalesVolumeController {
	@Resource(name = "salesVolumeService")
	private SalesVolumeService salesVolumeService;

	/**
	 * 转发到图表页面
	 * 
	 * 已弃用
	 * 
	 * @return 视图名
	 */
	@RequestMapping("tochart.do")
	public String tochart() {
		return "bs/chart";
	}

	/**
	 * 获得销量信息
	 * 
	 * @return 销量信息
	 */
	@RequestMapping("getValue.do")
	@ResponseBody
	public Map<String, Integer> getValue() {
		Map<String, Integer> map = salesVolumeService.getSalesVolume();
		return map;
	}
}
