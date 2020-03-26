package com.hxoim.common.utils;

import java.util.Date;
import java.util.Calendar;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
/**
 * 时间处理工具
 * <p>Description: 处理时间的方法</p>
 */
public class UtilDateTime {
	/***
	 * 日期间隔符
	 */
	private static final String datePartition = "-";
	/***
	 * 时间间隔符
	 */
	private static final String timePartition = ":";
	/***
	 * 默认日期格式
	 */
	private static final String dateformat = "yyyy-MM-dd";
	/***
	 * 默认时间格式
	 */
	private static final String timeformat = "HH:mm:ss";
	/**
	 * 获取当前年度
	 * @return 当前年度(四位字符串型数字)
	 */
	public static String nowYear() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		return df.format(new Date());
	}
	/**
	 * 获取当前月
	 * @return 当前月(两位字符串型数字)
	 */
	public static String nowMonth() {
		SimpleDateFormat df = new SimpleDateFormat("MM");
		return df.format(new Date());
	}
	/**
	 * 获取当前日
	 * @return 当前日(两位字符串型数字)
	 */
	public static String nowDay() {
		SimpleDateFormat df = new SimpleDateFormat("dd");
		return df.format(new Date());
	}
	/**
	 * 获取当前日期
	 * @return 当前日期(默认格式)
	 */
	public static String nowDate() {
		SimpleDateFormat df = new SimpleDateFormat(dateformat);
		return df.format(new Date());
	}
	/**
	 * 获取当前时间
	 * @return 当前时间(默认格式)
	 */
	public static String nowTime() {
		SimpleDateFormat df = new SimpleDateFormat(timeformat);
		return df.format(new Date());
	}
	/**
	 * 获取当前日期时间
	 * @return 当前日期时间(默认格式)
	 */
	public static String nowDateTime() {
		SimpleDateFormat df = new SimpleDateFormat(dateformat + " " + timeformat);
		return df.format(new Date());
	}
	/**
	 * 获取当前月的开始日期
	 * @return 当前月的开始日期(默认格式)
	 */
	public static String nowMonthBegin(){
		SimpleDateFormat df = new SimpleDateFormat(dateformat);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH,1);
		return df.format(c.getTime());
	}
	/**
	 * 获取当前月的结束日期
	 * @return 当前月的结束日期(默认格式)
	 */
	public static String nowMonthEnd(){
		SimpleDateFormat df = new SimpleDateFormat(dateformat);
		Calendar c = Calendar.getInstance();    
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		return df.format(c.getTime());
	}
	/**
	 * 获取当前季度
	 * @return 当前季度(一位字符型数字)
	 */
	public static String nowQuarter() {
		int month = Integer.parseInt(getMonth(toDateTimeString(new Date())));
		if (month < 4) {
			return "1";
		} else if (month < 7) {
			return "2";
		} else if (month < 10) {
			return "3";
		} else if (month < 13) {
			return "4";
		} else {
			return null;
		}
	}
	/**
	 * 获取当前星期
	 * @return 当前星期(一位字符型数字)
	 */
	public static String nowWeek() {
		Calendar calendar = Calendar.getInstance();
		int weekNum = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		if (weekNum == 0) {
			weekNum = 7;
		}
		return String.valueOf(weekNum);
	}
	/**
	 * 获取当前日期的间隔几天的日期
	 * @return 当前日期的间隔几天的日期(统一格式)
	 */
	public static String nowDayInterval(int days){
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        date = calendar.getTime();
        return formatENDate(date);
	}
	/**
	 * 格式化日期
	 * @param date 输入Date型日期
	 * @param format 输入日期格式
	 * @return 带格式的字符串日期
	 */
	public static String formatDate(Date date, String format){
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}
	/**
	 * 格式化时间
	 * @param date 输入Date型日期
	 * @param format 输入时间格式
	 * @return 带格式的字符串时间
	 */
	public static String formatTime(Date date, String format){
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}
	/**
	 * 获取带中文的年度
	 * @param date 输入Date型日期
	 * @return 所在年度的中文(yyyy年)
	 */
	public static String formatCNYear(Date date){
		SimpleDateFormat df = new SimpleDateFormat("yyyy年");
		return df.format(date);
	}
	/**
	 * 获取带中文的月份
	 * @param date 输入Date型日期
	 * @return 日期所在的月份(yyyy年MM月)
	 */
	public static String formatCNMonth(Date date){
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月");
		return df.format(date);
	}
	/**
	 * 获取带中文的日期
	 * @param date 输入Date型日期
	 * @return 带中文的日期(yyyy年MM月dd日)
	 */
	public static String formatCNDate(Date date){
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
		return df.format(date);
	}
	/**
	 * 获取带中文的时间
	 * @param date 输入Date型日期
	 * @return 带中文的时间(HH时mm分ss秒)
	 */
	public static String formatCNTime(Date date){
		SimpleDateFormat df = new SimpleDateFormat("HH时mm分ss秒");
		return df.format(date);
	}
	/**
	 * 获取带中文的日期时间
	 * @param date 输入Date型日期
	 * @return 带中文的日期时间(yyyy年MM月dd日 HH时mm分ss秒)
	 */
	public static String formatCNDateTime(Date date){
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		return df.format(date);
	}
	/**
	 * 获取格式年度
	 * @param date 输入Date型日期
	 * @return 获取日期所在年度(yyyy)
	 */
	public static String formatENYear(Date date){
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		return df.format(date);
	}
	/**
	 * 获取格式月份
	 * @param date 输入Date型日期
	 * @return 获取日期所在月份(默认格式)
	 */
	public static String formatENMonth(Date date){
		SimpleDateFormat df = new SimpleDateFormat("yyyy"+datePartition+"MM");
		return df.format(date);
	}
	/**
	 * 获取格式日期
	 * @param date 输入Date型日期
	 * @return 获取格式日期(默认格式)
	 */
	public static String formatENDate(Date date){
		SimpleDateFormat df = new SimpleDateFormat("yyyy"+datePartition+"MM"+datePartition+"dd");
		return df.format(date);
	}
	/**
	 * 获取格式日期
	 * @param date 输入Date型日期
	 * @return 获取格式时间(默认格式)
	 */
	public static String formatENTime(Date date){
		SimpleDateFormat df = new SimpleDateFormat("HH"+timePartition+"mm"+timePartition+"ss");
		return df.format(date);
	}
	/**
	 * 获取格式日期
	 * @param date 输入Date型日期
	 * @return 获取格式日期时间(默认格式)
	 */
	public static String formatENDateTime(Date date){
		SimpleDateFormat df = new SimpleDateFormat("yyyy"+datePartition+"MM"+datePartition+"dd"+" "+"HH"+timePartition+"mm"+timePartition+"ss");
		return df.format(date);
	}
	/**
	 * 获取年度
	 * @param date 输入字符型日期
	 * @return 截取日期所在年度
	 */
	public static String getYear(String date) {
		if ((date == null) || date.equals("")) {
			return "";
		}
		int dateSlash1 = date.indexOf(datePartition);
		return date.substring(0, dateSlash1);
	}
	/**
	 * 获取月份
	 * @param date 输入字符型日期
	 * @return 截取日期所在月份
	 */
	public static String getMonth(String date) {
		if ((date == null) || date.equals("")) {
			return "";
		}
		int dateSlash1 = date.indexOf(datePartition);
		int dateSlash2 = date.lastIndexOf(datePartition);
		return date.substring(dateSlash1 + 1, dateSlash2);
	}
	/**
	 * 获取日期
	 * @param date 输入字符型日期
	 * @return 截取日期
	 */
	public static String getDay(String date) {
		if ((date == null) || date.equals("")) {
			return "";
		}
		int dateSlash2 = date.lastIndexOf(datePartition);
		return date.substring(dateSlash2 + 1, date.length() < dateSlash2 + 3 ? date.length() : dateSlash2 + 3);
	}
	/**
	 * 获取小时
	 * @param date  输入字符型日期
	 * @return 截取小时
	 */
	public static String getHour(String date) {
		if ((date == null) || date.equals("")) {
			return "";
		}
		int dateSlash1 = date.indexOf(":");
		return date.substring(dateSlash1 - 2 < 0 ? 0 : dateSlash1 - 2, dateSlash1).trim();
	}
	/**
	 * 获取分钟
	 * @param date  输入字符型日期
	 * @return 截取分钟
	 */
	public static String getMinute(String date) {
		if ((date == null) || date.equals("")) {
			return "";
		}
		int dateSlash1 = date.indexOf(":");
		int dateSlash2 = date.lastIndexOf(":");
		if (dateSlash1 == dateSlash2) {
			return date.substring(dateSlash1 + 1, date.length() < dateSlash2 + 3 ? date.length() : dateSlash2 + 3).trim();
		}
		return date.substring(dateSlash1 + 1, dateSlash2).trim();
	}
	/**
	 * 获取秒钟
	 * @param date  输入字符型日期
	 * @return 截取秒钟
	 */
	public static String getSecond(String date) {
		if ((date == null) || date.equals("")) {
			return "";
		}
		int dateSlash1 = date.indexOf(":");
		int dateSlash2 = date.lastIndexOf(":");
		if (dateSlash1 == dateSlash2) {
			return "0";
		}
		return date.substring(dateSlash2 + 1, date.length() < dateSlash2 + 3 ? date.length() : dateSlash2 + 3).trim();
	}
	/**
	 * 获取季度
	 * @param date  输入字符型日期
	 * @return 获取季度(一位字符型数字)
	 */
	public static String getQuarter(String date) {
		int month = Integer.parseInt(getMonth(date));
		if (month < 4) {
			return "1";
		} else if (month < 7) {
			return "2";
		} else if (month < 10) {
			return "3";
		} else if (month < 13) {
			return "4";
		} else {
			return null;
		}
	}
	/**
	 * 获取星期
	 * @param date  输入字符型日期
	 * @return 获取星期(一位字符型数字)
	 */
	public static String getWeek(String date) {
		Date datetime = toDate(date);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(datetime);
		int weekNum = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		if (weekNum == 0) {
			weekNum = 7;
		}
		return String.valueOf(weekNum);
	}
	/**
	 * 获取间隔天数的日期
	 * @param date  输入字符型日期
	 * @param days  间隔的天数
	 * @return 间隔天数的日期
	 */
	public static String getDayInterval(String date, int days){
		Date datetime = toDate(date);
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(datetime);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        datetime = calendar.getTime();
        return formatENDate(datetime);
	}
	/**
	 * 获取年度
	 * @param date 输入Date型日期
	 * @return 获取日期所在年度
	 */
	public static String getYear(Date date) {
		String str = toDateTimeString(date);
		return getYear(str);
	}
	/**
	 * 获取月份
	 * @param date 输入Date型日期
	 * @return 获取日期所在月份
	 */
	public static String getMonth(Date date) {
		String str = toDateTimeString(date);
		return getMonth(str);
	}
	/**
	 * 获取日
	 * @param date 输入Date型日期
	 * @return 获取日期的日
	 */
	public static String getDay(Date date) {
		String str = toDateTimeString(date);
		return getDay(str);
	}
	/**
	 * 获取小时
	 * @param date 输入Date型日期
	 * @return 获取日期所在小时
	 */
	public static String getHour(Date date) {
		String str = toDateTimeString(date);
		return getHour(str);
	}
	/**
	 * 获取分钟
	 * @param date 输入Date型日期
	 * @return 获取日期所在分钟
	 */
	public static String getMinute(Date date) {
		String str = toDateTimeString(date);
		return getMinute(str);
	}
	/**
	 * 获取秒钟
	 * @param date 输入Date型日期
	 * @return 获取日期所在秒钟
	 */
	public static String getSecond(Date date) {
		String str = toDateTimeString(date);
		return getSecond(str);
	}
	/**
	 * 获取日期所在的季度
	 * @param date 输入的日期
	 * @return 日期所在的季度
	 */
	public static String getQuarter(Date date) {
		String str = toDateTimeString(date);
		return getQuarter(str);
	}
	/**
	 * 获取日期所在的星期
	 * @param date 输入的日期
	 * @return 日期所在的星期
	 */
	public static String getWeek(Date date) {
		if (date == null) {
			return "";
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int weekNum = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		if (weekNum == 0) {
			weekNum = 7;
		}
		return String.valueOf(weekNum);
	}
	/**
	 * 获取输入日期相隔输入天数的日期(正数向后，负数向前)
	 * @param date 输入日期
	 * @param days 输入相隔天数
	 * @return 字符型日期(默认格式)
	 */
	public static String getDayInterval(Date date, int days){
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        date = calendar.getTime();
        return formatENDate(date);
	}
	/**
	 * 获取两个日期之间的天数
	 * @param startDate 开始日期
	 * @param endDate   结束日期
	 * @return 两个日期直接的天数
	 */
	public static long getDaysBetween(Date startDate,Date endDate){
		long nd = 1000*24*60*60;
		long diff = endDate.getTime() - startDate.getTime();
		long day = diff/nd;
		return day;
	}
	/**
	 * 获取两个日期之间的时间差
	 * @param startDate 开始日期
	 * @param endDate   结束日期
	 * @return 带中文的实际差
	 */
	public static String getTimesBetween(Date startDate,Date endDate){
		long nd = 1000*24*60*60;//一天的毫秒数
		long nh = 1000*60*60;//一小时的毫秒数
		long nm = 1000*60;//一分钟的毫秒数
		long ns = 1000;//一秒钟的毫秒数
		//获得两个时间的毫秒时间差异
		long diff = endDate.getTime() - startDate.getTime();
		long day = diff/nd;//计算差多少天
		long hour = (diff-day*nd)/nh;//计算差多少小时
		long min = (diff-day*nd-hour*nh)/nm;//计算差多少分钟
		long sec = (diff-day*nd-hour*nh-min*nm)/ns;//计算差多少秒//输出结果
		return day+"天"+hour+"小时"+min+"分钟"+sec+"秒";
	}
	/**
	 * 将字符串转换为Date类型日期
	 * @param date 字符串日期
	 * @return Date类型日期
	 */
	public static Date toDate(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat(dateformat);
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(date, pos);
		return strtodate;
	}
	/**
	 * 将字符串转换为Date类型日期
	 * @param date 字符串日期
	 * @return Date类型日期
	 */
	public static Date toDateFormat(String date,String format){
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(date, pos);
		return strtodate;
	}	
	/**
	 * 将Date类型换行为字符串的日期时间
	 * @param date 日期
	 * @return 带格式的日期时间(默认格式)
	 */
	public static String toDateTimeString(Date date) {
		if (date == null) {
			return "";
		}
		String dateString = toDateString(date);
		String timeString = toTimeString(date);
		if ((dateString != null) && (timeString != null)) {
			return dateString + " " + timeString;
		} else {
			return "";
		}
	}
	/**
	 * 将Date类型换行为字符串的日期
	 * @param date 输入日期
	 * @return 带格式的日期(默认格式)
	 */
	public static String toDateString(Date date) {
		if (date == null) {
			return "";
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int year = calendar.get(Calendar.YEAR);
		String monthStr;
		String dayStr;
		String yearStr;
		if (month < 10) {
			monthStr = "0" + month;
		} else {
			monthStr = "" + month;
		}
		if (day < 10) {
			dayStr = "0" + day;
		} else {
			dayStr = "" + day;
		}
		yearStr = "" + year;
		return yearStr + "-" + monthStr + "-" + dayStr;
	}
	/**
	 * 将Date类型换行为字符串的时间
	 * @param date 输入日期
	 * @return 带格式的时间(默认格式)
	 */
	public static String toTimeString(Date date) {
		if (date == null) {
			return "";
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return toTimeString(
			calendar.get(Calendar.HOUR_OF_DAY),
			calendar.get(Calendar.MINUTE),
			calendar.get(Calendar.SECOND));
	}
	/**
	 * 转换成时间格式
	 * @param hour 时
	 * @param minute 分
	 * @param second 秒
	 * @return 带格式的时间(默认格式)
	 */
	public static String toTimeString(int hour, int minute, int second) {
		String hourStr;
		String minuteStr;
		String secondStr;
		if (hour < 10) {
			hourStr = "0" + hour;
		} else {
			hourStr = "" + hour;
		}
		if (minute < 10) {
			minuteStr = "0" + minute;
		} else {
			minuteStr = "" + minute;
		}
		if (second < 10) {
			secondStr = "0" + second;
		} else {
			secondStr = "" + second;
		}
		if (second == 0) {
			return hourStr + timePartition + minuteStr;
		} else {
			return hourStr + timePartition + minuteStr + timePartition + secondStr;
		}
	}

	/**
	 * 计算年龄
	 * @param birthday 生日
	 * @return 年龄
	 */
	public static String getAgeByBirthday(String birthday) {
		if ("".equals(birthday.trim()) || birthday.trim() == null) {
			return null;
		}
		// 此处调用了获取当前日期，以yyyy-MM-dd格式返回的日期字符串方法
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String nowDate = df.format(new Date());
		int age = Integer.parseInt(nowDate.substring(0, 4)) - Integer.parseInt(birthday.substring(0, 4));
		return Integer.toString(age);
	}

}