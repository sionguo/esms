package cn.guoxy.esms.commons.resources;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * dom4j处理用户配置路径，并存入map
 * 
 * @author gxy
 *
 */
public class EsmsResource implements ApplicationListener<ContextRefreshedEvent> {
	public static Map<String, String> map;

	/**
	 * ApplicationListener接口的方法，此方法将在spring容器启动后立马执行
	 */
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (event.getApplicationContext().getParent() == null) {
			getPath();
		}
	}

	/**
	 * dom4j读取配置文件
	 */
	public void getPath() {
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		map = new HashMap<String, String>();
		try {
			SAXReader reader = new SAXReader();
			Resource re = resolver.getResource("classpath:esms.xml");
			Document doc = reader.read(re.getInputStream());
			Element root = doc.getRootElement();
			List<Element> list = root.elements();
			for (Element element : list) {
				Element e = element.element("path");
				String path = e.getText();
				Attribute attr = e.attribute("id");
				String id = attr.getValue();
				map.put(id, path);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void getUrlMap() {

	}
}
