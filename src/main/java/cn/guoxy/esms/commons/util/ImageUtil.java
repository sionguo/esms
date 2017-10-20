package cn.guoxy.esms.commons.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

import cn.guoxy.esms.commons.entity.Goods;
import cn.guoxy.esms.commons.resources.EsmsResource;

/**
 * 图片处理工具类
 * 
 * @author gxy
 *
 */
public final class ImageUtil {

	/** 验证码字符集 */
	private static final char[] chars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
			'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	/** 字符数量 */
	private static final int SIZE = 4;
	/** 干扰线数量 */
	private static final int LINES = 5;
	/** 宽度 */
	private static final int WIDTH = 130;
	/** 高度 */
	private static final int HEIGHT = 45;
	/** 字体大小 */
	private static final int FONT_SIZE = 24;

	/**
	 * 生成图片验证码
	 */
	public static Object[] createImage() {
		StringBuffer sb = new StringBuffer();
		// 1.创建空白图片
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		// 2.获取图片画笔
		Graphics graphic = image.getGraphics();
		// 3.设置画笔颜色
		graphic.setColor(Color.WHITE);
		// 4.绘制矩形背景
		graphic.fillRect(0, 0, WIDTH, HEIGHT);
		// 5.画随机字符
		Random ran = new Random();
		for (int i = 0; i < SIZE; i++) {
			// 取随机字符索引
			int n = ran.nextInt(chars.length);
			// 设置随机颜色
			graphic.setColor(getRandomColor());
			// 设置字体大小
			graphic.setFont(new Font(null, Font.BOLD + Font.ITALIC, FONT_SIZE));
			// 画字符
			graphic.drawString(chars[n] + "", i * WIDTH / SIZE, HEIGHT / (i % 2 + 1));
			// 记录字符
			sb.append(chars[n]);
		}
		// 6.画干扰线
		for (int i = 0; i < LINES; i++) {
			// 设置随机颜色
			graphic.setColor(getRandomColor());
			// 随机画线
			graphic.drawLine(ran.nextInt(WIDTH), ran.nextInt(HEIGHT), ran.nextInt(WIDTH), ran.nextInt(HEIGHT));
		}
		// 7.返回验证码和图片
		return new Object[] { sb.toString(), image };
	}

	/**
	 * 获得随机颜色
	 */
	public static Color getRandomColor() {
		Random ran = new Random();
		Color color = new Color(ran.nextInt(256), ran.nextInt(256), ran.nextInt(256));
		return color;
	}

	/**
	 * 获取图片尺寸
	 * 
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public static int[] getSizeInfo(InputStream input) throws Exception {
		try {
			BufferedImage img = ImageIO.read(input);
			int w = img.getWidth(null);
			int h = img.getHeight(null);
			return new int[] { w, h };
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}

	/**
	 * 对图片进行初步处理，参数后期可考虑写入配置文件中
	 * 
	 * @param input
	 */
	public static BufferedImage resize(InputStream input, String filePath, String fileName) {
		try {
			BufferedImage image = ImageIO.read(input);
			int width = image.getWidth();
			int height = image.getHeight();
			int newwidth;
			int newheight;
			int x = 0;
			int y = 0;
			double bi = 0;
			if (height > 530) {
				bi = 300d / height;
				newwidth = (int) (width * bi);
				newheight = (int) (height * bi);
				x = (272 - newwidth) / 2;
			} else {
				bi = 270d / width;
				newwidth = (int) (width * bi);
				newheight = (int) (height * bi);
				y = (300 - newheight) / 2;
			}

			// 获得缩放后的图片
			Image img = image.getScaledInstance(newwidth, newheight, Image.SCALE_SMOOTH);
			// 获得大图
			BufferedImage image1 = new BufferedImage(272, 414, BufferedImage.TYPE_INT_RGB);
			Graphics graphic = image1.getGraphics();
			graphic.setColor(Color.WHITE);
			graphic.fillRect(0, 0, 390, 600);
			Graphics g = image1.getGraphics();
			g.drawImage(img, x, y, null);
			ImageIO.write(image1, "jpg", new File(filePath, fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 添加商品描述
	 * 
	 * @param goods
	 */
	public static void addShow(Goods goods) {
		try {
			String path = EsmsResource.map.get("imgPath");
			BufferedImage image = ImageIO.read(new File(path, goods.getBigImg()));
			Graphics2D g = image.createGraphics();
			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g.setColor(Color.BLACK);
			int namesize = 28;
			if (goods.getGoodsName().length() > 9) {
				namesize = 270 / goods.getGoodsShow().length();
			}
			g.setFont(new Font("黑体", Font.BOLD, namesize));
			g.drawString(goods.getGoodsName(), 10, 328);
			g.setColor(Color.GRAY);
			int size = 24;
			if (goods.getGoodsShow().length() > 10) {
				size = 270 / goods.getGoodsShow().length();
			}
			g.setFont(new Font("宋体", Font.BOLD, size));
			g.drawString(goods.getGoodsShow(), 10, 362);
			g.setColor(new Color(175, 22, 24));
			g.setFont(new Font("黑体", Font.BOLD, 36));
			g.drawString("￥" + goods.getGoodsPrice(), 10, 400);
			ImageIO.write(image, "jpg", new File(path, goods.getBigImg()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}