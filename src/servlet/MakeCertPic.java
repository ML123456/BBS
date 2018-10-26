package servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.regexp.internal.recompile;

@WebServlet("/MakeCertPic")
public class MakeCertPic {
	
	//验证码图片中可以出现的字符集
	private char mapTable[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
			'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
			'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
			'9' };
	
	/**
	 * 生产彩色验证码图片
	 * @param 	width 生产图片宽度
	 * @param 	height 生产图片高度
	 * @param 	os 页面输出流
	 * @return	随机生产的验证码
	 */
	public String getCertPic(int width,int height,OutputStream os){
		//设定高度宽度默认值
		if(width <= 0){
			width = 60;
		}
		if(height <= 0){
			height = 20;
		}
		//创建一个特定样式的BufferedImage
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//获取图形上下文
		Graphics g = image.getGraphics();
		//设定背景色
		g.setColor(new Color(0xDCDCDC));
		g.fillRect(0, 0, width, height);
		//画边框
		g.setColor(Color.black);
		g.drawRect(0, 0, width-1, height-1);
		//取随机产生的认证码
		String strEnsure = "";
		//4代表4位验证码，如果要生产更多位的认证码，则加大数值
		for(int i = 0; i < 4; i++){
			strEnsure += mapTable[(int) (mapTable.length * Math.random())];
		}
		//将验证码显示到图像中，如果要生产更多位的验证码，增加drawString语句
		g.setColor(Color.black);
		g.setFont(new Font("Atlantic Inline", Font.PLAIN, 18));
		String str = strEnsure.substring(0, 1);
		g.drawString(str, 8, 17);
		str = strEnsure.substring(1, 2);
		g.drawString(str, 20, 15);
		str = strEnsure.substring(2, 3);
		g.drawString(str, 35, 18);
		str = strEnsure.substring(3, 4);
		g.drawString(str, 45, 15);
		//随机产生10个干扰点,产生多个修改数量10
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			int x = rand.nextInt(width);
			int y = rand.nextInt(height);
			g.drawOval(x, y, 1, 1);
		}
		//释放图形上下文
		g.dispose();
		try {
			ImageIO.write(image, "JPEG", os);
		} catch (IOException e) {
			return "";
		}
		
		System.out.println(strEnsure);
		return strEnsure;
	}
}