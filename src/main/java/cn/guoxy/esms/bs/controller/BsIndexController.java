package cn.guoxy.esms.bs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台主页Controller
 * 
 * @author gxy
 *
 */
@Controller
@RequestMapping("/bs/")
public class BsIndexController {
	/**
	 * 转发到后台主页
	 * 
	 * @return 后台主页
	 */
	@RequestMapping("toBsIndex.do")
	public String toBsIndex() {
		return "bs/bsindex";
	}
}
