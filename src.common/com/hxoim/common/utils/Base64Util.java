package com.hxoim.common.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.Clob;
import java.sql.SQLException;

public class Base64Util {
	
	public static void main(String[] args) {
//		String returnStr = Base64Util.imageToBase64("D:\\TEST\\rmb.jpg");
//		System.out.println(returnStr);
//		Base64Util.generateImage(returnStr, "D:\\TEST\\rmbnew.jpg");
		String returnStr = Base64Util.imageToBase64("");
		System.out.println(returnStr);
		Base64Util.generateImage(returnStr, "D:\\TEST\\rmbnew.jpg");
	}
	
	

    /** 
     * base64图片编码转为图片
     * @param imgStr base64编码字符串
     * @param path   图片路径-具体到文件
     */
    public static boolean generateImage(String imgStr, String path) {
        if (imgStr == null || "".equals(imgStr))
            return false;
//        BASE64Decoder decoder = new BASE64Decoder();
        try {
           // 解密
        	if(imgStr.contains(" ")) {
        		imgStr=imgStr.replace(" ", "+");
        	}
            // 处理数据
//			byte[] b = decoder.decodeBuffer(imgStr);
//			for (int i = 0; i < b.length; ++i) {
//				if (b[i] < 0) {// 调整异常数据
//					b[i] += 256;
//				}
//			}
			byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(imgStr);
			BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageBytes));
			File outputfile = new File(path);
			ImageIO.write(image, "jpg", outputfile);
			
//            OutputStream out = new FileOutputStream(path);
//            out.write(b);
//            out.flush();
//            out.close();
            return true;
        } catch (Exception e) {
        	e.printStackTrace();
            return false;
        }
    }
    
    /****
     * 传入字符串转为base64编码
     * @param str
     * @return
     */
	public static String getBase64(String str) {
		byte[] b = null;
		String s = null;
		try {
			b = str.getBytes("utf-8");
			s = Base64.encode(b);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return s;
	}

 /******
  * 将Clob 转为String 
  * @param clob
  * @return
  * @throws SQLException
  * @throws IOException
  */
	 public static String ClobToString(Clob clob) throws SQLException, IOException {
	        String reString = "";
	        if(clob!=null) {
		        Reader is = clob.getCharacterStream();// 得到流
		        BufferedReader br = new BufferedReader(is);
		        String s = br.readLine();
		        StringBuffer sb = new StringBuffer();
		        while (s != null) {// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
		        sb.append(s);
		        s = br.readLine();
		        }
		        reString = sb.toString();
		        if(br != null){
		            br.close();
		        }
		        if(is != null){
		        	is.close();
		        }
	        }
	        return reString;
	        }

/****
 * 将图片转为base64编码
 * @param imagePath
 * @return
 */
  public static String imageToBase64(String imagePath) {
	  if(imagePath == null || "".equals(imagePath)) {
		  return "";
	  }
      //将图片文件转化为字节数组字符串，并对其进行Base64编码处理
	      InputStream in = null;
	      byte[] bytes = null;
	      //读取图片字节数组
	      try 
	      {
	          in = new FileInputStream(imagePath);        
	          bytes = new byte[in.available()];
	          in.read(bytes);
	          in.close();
	      } 
	      catch (IOException e) 
	      {
	          e.printStackTrace();
	      }
	      return Base64.encode(bytes);
  }
}
