/**
 * Copyright (c) 2010-2015 http://www.transnal.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package org.jeecgframework.core.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.jeecg.ajjzz.entity.TSStaffEntity;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.ArrayUtils;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.PixelGrabber;
import java.io.*;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

/**
 * <p>
 * User: Transnal Team
 * <p>
 * Date: 13-2-12 下午9:29
 * <p>
 * Version: 1.0
 */
public class ImagesUtils {

	private static final String[] IMAGES_SUFFIXES = { "bmp", "jpg", "jpeg", "gif", "png", "tiff" };

	private static final String backPicPath = "http://ozjx9t101.bkt.clouddn.com/card_ok.png";

//	图片尺寸   850  540

	//标准行距
	private static final int line = 51;
	//证书图片二维码x距离
	private static final int CERTIFICATE_QR_X = 40;
	//证书图片二维码y距离
	private static final int CERTIFICATE_QR_Y = 410;
	//证书二维码宽
	private static final int CERTIFICATE_QR_WIDTH = 100;
	//证书二维码高
	private static final int CERTIFICATE_QR_HEIGHT = 100;
	//证书头像二维码x距离
	private static final int CERTIFICATE_PHOTO_X = 590;
	//证书头像二维码y距离
	private static final int CERTIFICATE_PHOTO_Y = 55;
	//证书头像宽
	private static final int CERTIFICATE_PHOTO_WIDTH = 220;
	//证书头像高
	private static final int CERTIFICATE_PHOTO_HEIGHT = 320;
	//证书首个信息x距离
	private static final int CERTIFICATE_TEXT_X = 47;
	//证书首个信息y距离
	private static final int CERTNIFICATE_TEXT_Y = 53;
	//证书信息字体
	private static final String CERTIFICATE_TEXT = "黑体";
	//证书信息字号
	private static final int CERTIFICATE_TEXT_SIZE = 28;
	//证书信息行高
	private static final int CERTIFICATE_TEXT_ROW_HEIGHT = 65;
	//证书信息字体颜色
	private static final String CERTIFICATE_TEXT_COLOR = "#000000";
	//证书标题字体颜色
	private static final String CERTIFICATE_TEXT_TITLE_COLOR = "#074d74";

	/**
	 * 是否是图片附件
	 *
	 * @param filename
	 * @return
	 */
	public static boolean isImage(String filename) {
		if (filename == null || filename.trim().length() == 0)
			return false;
		return ArrayUtils.contains(IMAGES_SUFFIXES, FilenameUtils.getExtension(filename).toLowerCase());
	}

	/**
	 * 合成志愿证书图片
	 *
	 * @param qrCodeText  二维码内容（志愿者编号）
	 * @param name        姓名
	 * @param sex         性别
	 * @param address     注册地点
	 * @param date        注册日期
	 * @param no          证书编号
	 * @throws IOException
	 * @throws WriterException
	 */
	public static BufferedImage imagesSynthesis(String qrCodeText, TSStaffEntity staff, HttpServletRequest request) throws IOException, WriterException {
		// 读取图片
		Image backImage = ImagesUtils.loadImageUrl(backPicPath);
		// 各个图片的高/宽度
		int bWidth = backImage.getWidth(null);
		int bHeight = backImage.getHeight(null);
		// 处理背景图片信息
		//证号标题
		backImage = ImagesUtils.pressText("证  号:", backImage, CERTIFICATE_TEXT, Font.BOLD,
				ImagesUtils.String2Color(CERTIFICATE_TEXT_TITLE_COLOR), CERTIFICATE_TEXT_SIZE, CERTIFICATE_TEXT_X,
                CERTNIFICATE_TEXT_Y, 1);
		//证号
		backImage = ImagesUtils.pressText(staff.getCardNo(), backImage, CERTIFICATE_TEXT, Font.BOLD,
				ImagesUtils.String2Color(CERTIFICATE_TEXT_COLOR), CERTIFICATE_TEXT_SIZE, CERTIFICATE_TEXT_X + 120,
				CERTNIFICATE_TEXT_Y, 1);
		//姓名
		backImage = ImagesUtils.pressText("姓  名:", backImage, CERTIFICATE_TEXT, Font.BOLD,
				ImagesUtils.String2Color(CERTIFICATE_TEXT_TITLE_COLOR), CERTIFICATE_TEXT_SIZE, CERTIFICATE_TEXT_X,
                CERTNIFICATE_TEXT_Y + CERTIFICATE_TEXT_ROW_HEIGHT, 1);
		//姓名
		backImage = ImagesUtils.pressText(staff.getRealName(), backImage, CERTIFICATE_TEXT, Font.BOLD,
				ImagesUtils.String2Color(CERTIFICATE_TEXT_COLOR), CERTIFICATE_TEXT_SIZE, CERTIFICATE_TEXT_X + 120,
				CERTNIFICATE_TEXT_Y + CERTIFICATE_TEXT_ROW_HEIGHT, 1);
		//性别
		backImage = ImagesUtils.pressText("性  别:", backImage, CERTIFICATE_TEXT, Font.BOLD,
				ImagesUtils.String2Color(CERTIFICATE_TEXT_TITLE_COLOR), CERTIFICATE_TEXT_SIZE, CERTIFICATE_TEXT_X + 306,
                CERTNIFICATE_TEXT_Y + CERTIFICATE_TEXT_ROW_HEIGHT, 1);
		//性别
		backImage = ImagesUtils.pressText(staff.getSex(), backImage, CERTIFICATE_TEXT, Font.BOLD,
				ImagesUtils.String2Color(CERTIFICATE_TEXT_COLOR), CERTIFICATE_TEXT_SIZE, CERTIFICATE_TEXT_X + 440,
				CERTNIFICATE_TEXT_Y + CERTIFICATE_TEXT_ROW_HEIGHT, 1);
		//作业类别
		backImage = ImagesUtils.pressText("工作类别:", backImage, CERTIFICATE_TEXT, Font.BOLD,
				ImagesUtils.String2Color(CERTIFICATE_TEXT_TITLE_COLOR), CERTIFICATE_TEXT_SIZE - 2, CERTIFICATE_TEXT_X,
                CERTNIFICATE_TEXT_Y + CERTIFICATE_TEXT_ROW_HEIGHT * 2, 1);
		//作业类别
		backImage = ImagesUtils.pressText(staff.getWorkType(), backImage, CERTIFICATE_TEXT, Font.BOLD,
				ImagesUtils.String2Color(CERTIFICATE_TEXT_COLOR), CERTIFICATE_TEXT_SIZE - 2, CERTIFICATE_TEXT_X + 140,
				CERTNIFICATE_TEXT_Y + CERTIFICATE_TEXT_ROW_HEIGHT * 2, 1);
		//准操项目
		backImage = ImagesUtils.pressText("准操项目:", backImage, CERTIFICATE_TEXT, Font.BOLD,
				ImagesUtils.String2Color(CERTIFICATE_TEXT_TITLE_COLOR), CERTIFICATE_TEXT_SIZE - 2, CERTIFICATE_TEXT_X,
                CERTNIFICATE_TEXT_Y + CERTIFICATE_TEXT_ROW_HEIGHT * 3, 1);
		//准操项目
		backImage = ImagesUtils.pressText(staff.getAllowProject(), backImage, CERTIFICATE_TEXT, Font.BOLD,
				ImagesUtils.String2Color(CERTIFICATE_TEXT_COLOR), CERTIFICATE_TEXT_SIZE - 2, CERTIFICATE_TEXT_X + 140,
				CERTNIFICATE_TEXT_Y + CERTIFICATE_TEXT_ROW_HEIGHT * 3, 1);
		//初领日期
		backImage = ImagesUtils.pressText("初领日期:", backImage, CERTIFICATE_TEXT, Font.BOLD,
				ImagesUtils.String2Color(CERTIFICATE_TEXT_TITLE_COLOR), CERTIFICATE_TEXT_SIZE - 2, CERTIFICATE_TEXT_X,
				CERTNIFICATE_TEXT_Y + CERTIFICATE_TEXT_ROW_HEIGHT * 4, 1);
		//初领日期
		backImage = ImagesUtils.pressText(staff.getFirstGetDate(), backImage, CERTIFICATE_TEXT, Font.BOLD,
				ImagesUtils.String2Color(CERTIFICATE_TEXT_COLOR), CERTIFICATE_TEXT_SIZE - 2, CERTIFICATE_TEXT_X + 140,
				CERTNIFICATE_TEXT_Y + CERTIFICATE_TEXT_ROW_HEIGHT * 4, 1);
		//有效日期
		backImage = ImagesUtils.pressText("有效日期:", backImage, CERTIFICATE_TEXT, Font.BOLD,
				ImagesUtils.String2Color(CERTIFICATE_TEXT_TITLE_COLOR), CERTIFICATE_TEXT_SIZE - 2, CERTIFICATE_TEXT_X,
				CERTNIFICATE_TEXT_Y + CERTIFICATE_TEXT_ROW_HEIGHT * 5, 1);
		//有效日期
		backImage = ImagesUtils.pressText(staff.getFirstGetDate() + "--" + staff.getSecondRecheckDate(), backImage, CERTIFICATE_TEXT, Font.BOLD,
				ImagesUtils.String2Color(CERTIFICATE_TEXT_COLOR), CERTIFICATE_TEXT_SIZE - 2, CERTIFICATE_TEXT_X + 140,
				CERTNIFICATE_TEXT_Y + CERTIFICATE_TEXT_ROW_HEIGHT * 5, 1);
		//第一次复审
		backImage = ImagesUtils.pressText("第一次复审:", backImage, CERTIFICATE_TEXT, Font.BOLD,
				ImagesUtils.String2Color(CERTIFICATE_TEXT_TITLE_COLOR), CERTIFICATE_TEXT_SIZE - 2, CERTIFICATE_TEXT_X + 110,
				CERTNIFICATE_TEXT_Y + 420, 1);
		//第一次复审
		backImage = ImagesUtils.pressText(staff.getFirstRecheckDate(), backImage, CERTIFICATE_TEXT, Font.BOLD,
				ImagesUtils.String2Color(CERTIFICATE_TEXT_COLOR), CERTIFICATE_TEXT_SIZE - 2, CERTIFICATE_TEXT_X + 150 + 110,
				CERTNIFICATE_TEXT_Y + 420, 1);
		//第二次复审
		backImage = ImagesUtils.pressText("第二次复审:", backImage, CERTIFICATE_TEXT, Font.BOLD,
				ImagesUtils.String2Color(CERTIFICATE_TEXT_TITLE_COLOR), CERTIFICATE_TEXT_SIZE - 2, CERTIFICATE_TEXT_X + 280 + 110,
				CERTNIFICATE_TEXT_Y + 420, 1);
		//第二次复审
		backImage = ImagesUtils.pressText(staff.getSecondRecheckDate(), backImage, CERTIFICATE_TEXT, Font.BOLD,
				ImagesUtils.String2Color(CERTIFICATE_TEXT_COLOR), CERTIFICATE_TEXT_SIZE - 2, CERTIFICATE_TEXT_X + 430 + 110,
				CERTNIFICATE_TEXT_Y + 420, 1);
		int alphaType = BufferedImage.TYPE_INT_RGB;
		// 画图
		BufferedImage backgroundImage = new BufferedImage(bWidth, bHeight, alphaType);
		Graphics2D graphics2D = backgroundImage.createGraphics();
		graphics2D.drawImage(backImage, 0, 0, null);
		graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1));
//		graphics2D.drawImage(headImage, CERTIFICATE_HEAD_X, CERTIFICATE_HEAD_Y, CERTIFICATE_HEAD_WIDTH, CERTIFICATE_HEAD_HEIGHT, null);
		//生成二维码
		Image qrCodeImage = ImagesUtils.getQrCodeImage(CERTIFICATE_QR_WIDTH, CERTIFICATE_QR_HEIGHT, qrCodeText);
		//头像图片
		File aa = new File(request.getSession().getServletContext().getRealPath("/") + "/" + "upload" + File.separator + staff.getRealName() + "_" + staff.getCardNo() + ".jpg");
		InputStream is=new FileInputStream(aa);
		BufferedImage bi=ImageIO.read(is);
		Image im=(Image)bi;
		graphics2D.drawImage(im, CERTIFICATE_PHOTO_X, CERTIFICATE_PHOTO_Y, CERTIFICATE_PHOTO_WIDTH, CERTIFICATE_PHOTO_HEIGHT, null);
		graphics2D.drawImage(qrCodeImage, CERTIFICATE_QR_X, CERTIFICATE_QR_Y, CERTIFICATE_QR_WIDTH, CERTIFICATE_QR_HEIGHT, null);


		return backgroundImage;
	}

//	/**
//	 * 合成推荐图片
//	 * @param backPicPath 背景图片url
//	 * @param headPicUrl 头像url
//	 * @param qrCodeText 二维码内容
//	 * @throws IOException
//	 * @throws WriterException
//	 */
//	public static InputStream imagesSynthesis(InputStream backPicPath, String headPicUrl, String qrCodeText) throws IOException, WriterException {
//		// 读取图片
//		Image backImage = ImageIO.read(backPicPath);
//		Image headImage = ImagesUtils.loadImageUrl(headPicUrl);
//		Image qrCodeImage = ImagesUtils.loadImageUrl(qrCodeText);
//		// 各个图片的高/宽度
//		int bWidth = backImage.getWidth(null);
//		int bHeight = backImage.getHeight(null);
//		// 处理背景图片信息
//		int alphaType = BufferedImage.TYPE_INT_RGB;
//		// 画图
//        BufferedImage bi1 = toBufferedImage(headImage);
//
//        // 根据需要是否使用 BufferedImage.TYPE_INT_ARGB
//        BufferedImage image = new BufferedImage(bi1.getWidth(), bi1.getHeight(),
//                BufferedImage.TYPE_INT_ARGB);
//
//        Ellipse2D.Double shape = new Ellipse2D.Double(0, 0, bi1.getWidth(), bi1
//                .getHeight());
//
//        Graphics2D g2 = image.createGraphics();
//        image = g2.getDeviceConfiguration().createCompatibleImage(bi1.getWidth(), bi1.getHeight(), Transparency.TRANSLUCENT);
//        g2 = image.createGraphics();
//        g2.setComposite(AlphaComposite.Clear);
//        g2.fill(new Rectangle(image.getWidth(), image.getHeight()));
//        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC, 1.0f));
//        g2.setClip(shape);
//        // 使用 setRenderingHint 设置抗锯齿
//        g2.drawImage(bi1, 0, 0, null);
//
//		BufferedImage backgroundImage = new BufferedImage(bWidth, bHeight, alphaType);
//		Graphics2D graphics2D = backgroundImage.createGraphics();
//		graphics2D.drawImage(backImage, 0, 0, null);
//		graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1));
//		graphics2D.drawImage(image, RECOMMONED_HEAD_X, RECOMMONED_HEAD_Y, RECOMMONED_HEAD_WIDTH, RECOMMONED_HEAD_HEIGHT, null);
//		graphics2D.drawImage(qrCodeImage, RECOMMONED_QR_X, RECOMMONED_QR_Y, RECOMMONED_QR_WIDTH, RECOMMONED_QR_HEIGHT, null);
//
//		// 返回
//		// ImageIO.write(backgroundImage, "png", new File("E:\\test\\1.png"));
//		ByteArrayOutputStream os = new ByteArrayOutputStream();
//		ImageIO.write(backgroundImage, "jpeg", os);
//		InputStream is = new ByteArrayInputStream(os.toByteArray());
//		return is;
//	}

//	/**
//	 * 合成熊宝证书
//	 * @param headPicUrl 头像url
//	 * @throws IOException
//	 * @throws WriterException
//	 */
//	public static BufferedImage imagesBearbaby(Image backImage, String headPicUrl, Long userId,
//											   String realName, String sex, Long time, Long birthday) throws IOException, WriterException {
//
//		// 处理证书日期格式
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(new Date(time));
//		//注册时间
//		Integer createDateYear = cal.get(Calendar.YEAR);
//		Integer createDateMonth = cal.get(Calendar.MONTH);
//		Integer createDateDay = cal.get(Calendar.DAY_OF_MONTH);
//		//生日
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(new Date(birthday));
//		//注册时间
//		String birthDate = calendar.get(Calendar.YEAR) + "年" + (calendar.get(Calendar.MONTH) + 1) + "月"
//				+ calendar.get(Calendar.DAY_OF_MONTH) + "日";
//
//
//		Image headImage = ImagesUtils.loadImageUrl(headPicUrl);
//		String cardNo = "BEARBABY" + String.format("%07d", userId.intValue());
//		// 各个图片的高/宽度
//		int bWidth = backImage.getWidth(null);
//		int bHeight = backImage.getHeight(null);
//		// 处理背景图片信息
//		//姓名
//
//		backImage = ImagesUtils.pressText(realName, backImage, CERTIFICATE_TEXT, Font.BOLD,
//				ImagesUtils.String2Color(CERTIFICATE_TEXT_COLOR), CERTIFICATE_TEXT_SIZE, CERTIFICATE_TEXT_X,
//				CERTNIFICATE_TEXT_y, 1);
//		//性别
//		backImage = ImagesUtils.pressText(sex, backImage, CERTIFICATE_TEXT, Font.BOLD,
//				ImagesUtils.String2Color(CERTIFICATE_TEXT_COLOR), CERTIFICATE_TEXT_SIZE, CERTIFICATE_TEXT_X + 140,
//				CERTNIFICATE_TEXT_y , 1);
//		//生日
//		backImage = ImagesUtils.pressText(birthDate, backImage, CERTIFICATE_TEXT, Font.BOLD,
//				ImagesUtils.String2Color(CERTIFICATE_TEXT_COLOR), CERTIFICATE_TEXT_SIZE, CERTIFICATE_TEXT_X + 33,
//				CERTNIFICATE_TEXT_y + 30 , 1);
//		//证件号码
//		backImage = ImagesUtils.pressText("DWXZ"+DateUtils.stampToformatDate(birthday,"yyyyMMdd")+String.format("%06d", userId.intValue()), backImage, CERTIFICATE_TEXT, Font.BOLD,
//				ImagesUtils.String2Color(CERTIFICATE_TEXT_COLOR), CERTIFICATE_TEXT_SIZE, CERTIFICATE_TEXT_X + 32,
//				CERTNIFICATE_TEXT_y + 90, 1);
//		//创建时间年月日
//		backImage = ImagesUtils.pressText(createDateYear.toString(), backImage, CERTIFICATE_TEXT, Font.BOLD,
//				ImagesUtils.String2Color(CERTIFICATE_TEXT_COLOR), CERTIFICATE_TEXT_SIZE, CERTIFICATE_TEXT_X + 105,
//				CERTNIFICATE_TEXT_y + 490, 1);
//		backImage = ImagesUtils.pressText(createDateMonth.toString(), backImage, CERTIFICATE_TEXT, Font.BOLD,
//				ImagesUtils.String2Color(CERTIFICATE_TEXT_COLOR), CERTIFICATE_TEXT_SIZE, CERTIFICATE_TEXT_X + 175,
//				CERTNIFICATE_TEXT_y + 490, 1);
//		backImage = ImagesUtils.pressText(createDateDay.toString(), backImage, CERTIFICATE_TEXT, Font.BOLD,
//				ImagesUtils.String2Color(CERTIFICATE_TEXT_COLOR), CERTIFICATE_TEXT_SIZE, CERTIFICATE_TEXT_X + 220,
//				CERTNIFICATE_TEXT_y + 490, 1);
//
//		// 处理背景图片信息
//		int alphaType = BufferedImage.TYPE_INT_RGB;
//
//		BufferedImage backgroundImage = new BufferedImage(bWidth, bHeight, alphaType);
//		Graphics2D graphics2D = backgroundImage.createGraphics();
//		graphics2D.drawImage(backImage, 0, 0, null);
//		graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1));
//		graphics2D.drawImage(headImage, CERTIFICATE_HEAD_X, CERTIFICATE_HEAD_Y, CERTIFICATE_HEAD_WIDTH, CERTIFICATE_HEAD_HEIGHT, null);
//
//
//		return backgroundImage;
//	}

	/**
	 * 获取网络图片地址
	 * @param imgUrl
	 * @return
	 * @throws IOException
	 */
	public static BufferedImage loadImageUrl(String imgUrl) throws IOException {
		URL url = new URL(imgUrl);
		return ImageIO.read(url);
	}

	/**
	 * 是否开启alpha通道
	 *
	 * @param image
	 * @return
	 * @throws InterruptedException
	 */
	public static boolean hasAlpha(Image image) throws InterruptedException {

		if (image instanceof BufferedImage) {
			BufferedImage bimage = (BufferedImage) image;
			return bimage.getColorModel().hasAlpha();
		}

		PixelGrabber pGrabber = new PixelGrabber(image, 0, 0, 1, 1, false);
		pGrabber.grabPixels();
		ColorModel colorModel = pGrabber.getColorModel();

		return colorModel.hasAlpha();
	}

	/**
	 * @param pressText 添加内容
	 * @param targetImg 目标图片
	 * @param fontName 字体
	 * @param fontStyle
	 * @param x
	 * @param y
	 * @param alpha
	 * @return
	 * @throws IOException
	 */
	public static BufferedImage pressText(String pressText, Image targetImg, String fontName, int fontStyle,
			Color color, int fontSize, int x, int y, float alpha) throws IOException {

		// 图片宽高
		int width = targetImg.getWidth(null);
		int height = targetImg.getHeight(null);
		// 样式
		Font font = new Font(fontName, fontStyle, fontSize);

		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();
		g.drawImage(targetImg, 0, 0, width, height, null);
		g.setColor(color.darker());// 颜色
		g.setFont(font);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,RenderingHints.VALUE_STROKE_DEFAULT);
		g.drawString(pressText, x, y);
		g.dispose();

		return image;
	}

	/**
	 * 16进制转Color对象
	 * 
	 * @param str
	 * @return
	 */
	public static Color String2Color(String str) {
		int i = Integer.parseInt(str.substring(1), 16);
		return new Color(i);
	}

	/**
	 * Color对象转16进制
	 * 
	 * @param color
	 * @return
	 */
	public static String Color2String(Color color) {
		String R = Integer.toHexString(color.getRed());
		R = R.length() < 2 ? ('0' + R) : R;
		String B = Integer.toHexString(color.getBlue());
		B = B.length() < 2 ? ('0' + B) : B;
		String G = Integer.toHexString(color.getGreen());
		G = G.length() < 2 ? ('0' + G) : G;
		return '#' + R + B + G;
	}
	
	/**
	 * 生成二维码图片
	 * @param width 二维码宽
	 * @param height 二维码高
	 * @param text 二维码内容
	 * @return
	 * @throws WriterException
	 */
	public static BufferedImage getQrCodeImage(int width, int height, String text) throws WriterException {
		Hashtable hints= new Hashtable();   
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hints.put(EncodeHintType.MARGIN, 1);   //设置白边
        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height,hints);
		return MatrixToImageWriter.toBufferedImage(bitMatrix);
	}

	//image转BufferedImage
	public static BufferedImage toBufferedImage(Image image) {
		if (image instanceof BufferedImage) {
			return (BufferedImage) image;
		}
		// This code ensures that all the pixels in the image are loaded
		image = new ImageIcon(image).getImage();
		// Determine if the image has transparent pixels; for this method's
		// implementation, see e661 Determining If an Image Has Transparent Pixels
		//boolean hasAlpha = hasAlpha(image);
		// Create a buffered image with a format that's compatible with the screen
		BufferedImage bimage = null;
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try {
			// Determine the type of transparency of the new buffered image
			int transparency = Transparency.OPAQUE;
           /* if (hasAlpha) {
             transparency = Transparency.BITMASK;
             }*/
			// Create the buffered image
			GraphicsDevice gs = ge.getDefaultScreenDevice();
			GraphicsConfiguration gc = gs.getDefaultConfiguration();
			bimage = gc.createCompatibleImage(
					image.getWidth(null), image.getHeight(null), transparency);
		} catch (HeadlessException e) {
			// The system does not have a screen
		}

		if (bimage == null) {
			// Create a buffered image using the default color model
			int type = BufferedImage.TYPE_INT_RGB;
			//int type = BufferedImage.TYPE_3BYTE_BGR;//by wang
            /*if (hasAlpha) {
             type = BufferedImage.TYPE_INT_ARGB;
             }*/
			bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
		}

		// Copy image to buffered image
		Graphics g = bimage.createGraphics();

		// Paint the image onto the buffered image
		g.drawImage(image, 0, 0, null);
		g.dispose();

		return bimage;
	}
}
