package com.hxoim.common.utils;


import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"rawtypes","unchecked"})
public class WebUtil {
	private static int counter = 0; 
	
	//检索字符串str中strindex出现的个数
	public static int stringNumbers(String str,String strindex)
	{
		
		if (str.indexOf(strindex)==-1)
		{
			return 0;
		}
		else if(str.indexOf(strindex) != -1)
		{
			counter++;
			stringNumbers(str.substring(str.indexOf(strindex)+strindex.length()),strindex);
			return counter;
		}
		return 0;
	}
	public static String getPid(String pid){
		if(pid == null || "".equals(pid)|| "null".equals(pid)){
			pid = "0";
		}
		return pid;
	}
    public static Map getPageInfo(String beginPage,String pageSize){
		if (beginPage == null || "".equals(beginPage)) {
			beginPage = "1";
		}
		int beginpage = Integer.parseInt(beginPage);
		if (pageSize == null || "".equals(pageSize)) {
			pageSize = Constants.PAGE_SIZE+"";
		}
		int pagesize = Integer.parseInt(pageSize);
		int beginindex = (beginpage - 1) * pagesize + 1;
		Map map = new HashMap();
		map.put("pagesize", pagesize);
		map.put("beginpage", beginpage);
		map.put("beginindex", beginindex);
		return map;
    }
    public static Map getPageInfo(String beginPage,String pageSize,int defaultpagesize){
		if (defaultpagesize == 0) {
			defaultpagesize = Constants.PAGE_SIZE;
		}
		if (beginPage == null || "".equals(beginPage)) {
			beginPage = "1";
		}
		int beginpage = Integer.parseInt(beginPage);
		if (pageSize == null || "".equals(pageSize)) {
			pageSize = defaultpagesize+"";
		}
		int pagesize = Integer.parseInt(pageSize);
		int beginindex = (beginpage - 1) * pagesize + 1;
		Map map = new HashMap();
		map.put("pagesize", pagesize);
		map.put("beginpage", beginpage);
		map.put("beginindex", beginindex);
		return map;
    }
	// 获取客户端IP地址
	public static String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	public static Object[] getObj(List list) {
		Object[] obj = null;
		if (list != null && list.size() > 0) {
			int size = 0;
			for (int i = 0; i < list.size(); i++) {
				Object[] object = (Object[]) list.get(i);
				if (object != null && object.length > 0) {
					for (int k = 0; k < object.length; k++) {
						if (object[k] != null)
							size++;
					}
				}
			}
			obj = new Object[size];
			int m = 0;
			for (int j = 0; j < list.size(); j++) {
				Object[] object = (Object[]) list.get(j);
				if (object != null) {
					for (int n = 0; n < object.length; n++) {
						if (object[n] != null && !"".equals(object[n])
								&& !"null".equals(object[n])) {
							obj[m] = object[n];
							m++;
						}
					}
				}
			}
		}
		return obj;
	}
	/**
	 * @param inputfilepath 输入文件绝对路径(带文件名)
	 * @param outputfilepath 输出文件绝对路径(带文件名)
	 * @param width 缩略图宽度
	 * @param height 缩略图高度
	 */
	public static void thumbFile(String inputfilepath,String outputfilepath,int width,int height){
		//ImageHelper.thumb(inputfilepath, outputfilepath, width,height);
	}
	//转换脚本XSS
	public static String cleanXSS(String value){
		value = value.replaceAll("/\\*(.|[\\r\\n])*?\\*/", "");
		value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		value = value.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
		value = value.replaceAll("'", "&#39;").replaceAll("\"", "&#34;");
		value = value.replaceAll("(?i)eval", "");
		value = value.replaceAll("(?i)javascript", "");
		value = value.replaceAll("(?i)expression", "");
		value = value.replaceAll("(?i)alert", "");
		value = value.replaceAll("(?i)script", "");
		return value;
	}
	//获取基本路径
	public static String getBasePath(HttpServletRequest request){
	    String basePath=null;
	    if(80==request.getServerPort()){
	    	basePath =request.getScheme() + "://" + request.getServerName() + request.getContextPath();
	    }else {
	    	basePath =request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
		}
	    return basePath;
	}
	public static String formatLog(String str,int length){
		if(str == null){
			str = "";
		}
		String returnstr = str;
		while(returnstr.length() < length){
			returnstr = returnstr + " ";
		}
		return returnstr;
	}
	public static String formatStr(String str,int length){
		String returnstr = str;
		while(returnstr.length() < length){
			returnstr = "0" + returnstr;
		}
		return returnstr;
	}
	public static String formatNum(int num,int length){
		String returnstr = num+"";
		while(returnstr.length() < length){
			returnstr = "0" + returnstr;
		}
		return returnstr;
	}
	public static boolean isNumber(String str){
		for (int i = 0; i < str.length(); i++){
			if (!Character.isDigit(str.charAt(i))){
				return false;
			}
		}
		return true;
	}
	public static int getIndexOfArray(String[] array, String value){
		if(array != null && array.length > 0){
			for(int i = 0;i < array.length;i ++){
				if(value.equals(array[i])){
					return i;
				}
			}
		}
		return -1;
	}

	//将字节转换为MB或者GB...
	public static String getPrintSize(long size) {
		//如果字节数少于1024，则直接以B为单位，否则先除于1024，后3位因太少无意义
		if (size < 1024) {
			return String.valueOf(size) + "B";
		} else {
			size = size / 1024;
		}
		//如果原字节数除于1024之后，少于1024，则可以直接以KB作为单位
		//因为还没有到达要使用另一个单位的时候
		//接下去以此类推
		if (size < 1024) {
			return String.valueOf(size) + "KB";
		} else {
			size = size / 1024;
		}
		if (size < 1024) {
			//因为如果以MB为单位的话，要保留最后1位小数，
			//因此，把此数乘以100之后再取余
			size = size * 100;
			return String.valueOf((size / 100)) + "."
					+ String.valueOf((size % 100)) + "MB";
		} else {
			//否则如果要以GB为单位的，先除于1024再作同样的处理
			size = size * 100 / 1024;
			return String.valueOf((size / 100)) + "."
					+ String.valueOf((size % 100)) + "GB";
		}
	}

	public static boolean isBlank(String s) {
		return s == null ? true : s.trim().length() == 0;
	}
	/*****
	 * 获取局域网内客户端ip
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static String getIpAddr(HttpServletRequest request)
			throws Exception {
		if (request == null) {
			throw (new Exception("getIpAddr method HttpServletRequest Object is null"));
		}
		String ipString = request.getHeader("x-forwarded-for");
		if (isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)) {
			ipString = request.getHeader("Proxy-Client-IP");
		}
		if (isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)) {
			ipString = request.getHeader("WL-Proxy-Client-IP");
		}
		if (isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)) {
			ipString = request.getRemoteAddr();
		}
		// 多个路由时，取第一个非unknown的ip
		final String[] arr = ipString.split(",");
		for (final String str : arr) {
			if (!"unknown".equalsIgnoreCase(str)) {
				ipString = str;
				break;
			}
		}
		return ipString;
	}
	
	 public static void main(String[] args) throws Exception{
		 
	 }  
}