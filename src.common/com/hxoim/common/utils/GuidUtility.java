package com.hxoim.common.utils;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class GuidUtility {


	/*******************
	 * 将  byte[] 转化成  Guid
	 * @param data 需要转化的byte数组，其数组不能为空，且数组的长度必须为16
	 * @return 返回一个生成的 UUID
	 */
	public static UUID fromBytes(byte[] data) {
		if(data == null) {
			throw new IllegalArgumentException("param data is null.");
		}
		if(data.length != 16) {
			throw new IllegalArgumentException("Invalid Guid byte[].");
		}
		long msb = 0;
		long lsb = 0;
		for(int i = 0; i < 8; i++) {
			msb = (msb << 8) | (data[i] & 0xff);
		}
		for(int i=8; i<16; i++) {
			lsb = (lsb << 8) | (data[i] & 0xff);
		}
		return new UUID(msb, lsb);
	}
	
	/*************
	 * 将Guid转化成byte数组
	 * @param guid 需要转化的 Guid
	 * @return 转化之后的  byte 数组
	 */
	public static byte[] toBytes(UUID guid) {
		ByteArrayOutputStream ba = new ByteArrayOutputStream(16);
		DataOutputStream da = new DataOutputStream(ba);
		try {
			da.writeLong(guid.getMostSignificantBits());
			da.writeLong(guid.getLeastSignificantBits());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return ba.toByteArray();
	}
	
	/******************
	 * 根据 Guid 倒算时间
	 * @param guid 需要倒算时间的唯一标识
	 * @return 倒算之后的时间
	 */
	public static Date fromDatetimeByGuid(UUID guid) {
		byte[] guidArray = toBytes(guid);
		if(guidArray != null && guidArray.length == 16) {
			byte[] daysArray = new byte[4];
			byte[] msecsArray = new byte[8];
			daysArray[0] = 0;
			daysArray[1] = 0;
			daysArray[2] = guidArray[10];
			daysArray[3] = guidArray[11];
			msecsArray[0] = 0;
			msecsArray[1] = 0;
			msecsArray[2] = 0;
			msecsArray[3] = 0;
			msecsArray[4] = guidArray[15];
			msecsArray[5] = guidArray[14];
			msecsArray[6] = guidArray[13];
			msecsArray[7] = guidArray[12];
			int days = bytes2Int(daysArray);
			long msecs = bytes2Long(msecsArray);
			long ls = (long)(msecs * 3.33333) ;	
			Date baseDate = getBaseDate();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(baseDate);
			calendar.add(Calendar.DAY_OF_MONTH, days - 1);
			calendar.add(Calendar.MILLISECOND, (int)ls);
			return calendar.getTime();
		}
		return new Date();
	}
	
	
	/*****************
	 * 根据指定的时间生成唯一标识
	 * @param datetime 需要生成唯一标识的时间
	 * @return 生成的唯一标识
	 */
	public static UUID createGuidByDatetime(Date datetime) {
		byte[] guidArray = toBytes( UUID.randomUUID());
		Date baseDate = getBaseDate();
        int days = getDistanceDays(datetime, baseDate);
        long msecs = getMillisecondsIntimepart4Date(datetime);
        byte[] dayArray = int2Bytes(days);
        byte[] msecsArray = long2Bytes(msecs);
        if(guidArray != null && dayArray != null && msecsArray != null && guidArray.length == 16 && dayArray.length == 4 && msecsArray.length == 8) {
        	guidArray[15] = msecsArray[4];
        	guidArray[14] = msecsArray[5];
        	guidArray[13] = msecsArray[6];
        	guidArray[12] = msecsArray[7];
        	guidArray[11] = dayArray[3];
        	guidArray[10] = dayArray[2];
        }        
        return fromBytes(guidArray);
	}

	public static UUID createGuidForStrByDatetime(Date datetime) {
		byte[] guidArray = toBytes( UUID.randomUUID());
		Date baseDate = getBaseDate();
		int days = getDistanceDays(datetime, baseDate);
		long msecs = getMillisecondsIntimepart4Date(datetime);
		byte[] dayArray = int2Bytes(days);
		byte[] msecsArray = long2Bytes(msecs);
		if(guidArray != null && dayArray != null && msecsArray != null && guidArray.length == 16 && dayArray.length == 4 && msecsArray.length == 8) {
			guidArray[5] = msecsArray[7];
			guidArray[4] = msecsArray[6];
			guidArray[3] = msecsArray[5];
			guidArray[2] = msecsArray[4];
			guidArray[1] = dayArray[3];
			guidArray[0] = dayArray[2];
		}
		return fromBytes(guidArray);
	}


	
	/**************
	 * 根据本地时间生成唯一标识
	 * @return 生成的唯一标识
	 */
	public static UUID createNewGuid() {
		return createGuidByDatetime(new Date());
	}
	
	// 获取 1900-01-01 00:00:00 这个基准时间
	private static Date getBaseDate() {
		Date baseDate = new Date();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			baseDate = sdf.parse("1900-01-01 00:00:00");
		}
		catch(ParseException ex) {
			ex.printStackTrace();
		}
		return baseDate;
	}
	
	// 获取两个时间之间相差多少天
	private static int getDistanceDays(Date date1, Date date2) {
		long time1 = date1.getTime();
		long time2 = date2.getTime();
		long result = 0;
		if(time1 > time2) {
			result = time1 - time2;
		}
		else {
			result = time2 - time1;
		}
		int days = (int)(result / (24 * 60 * 60 * 1000));
		return days + 1;	
	}
	
	// 获取时间日期的时间部分的毫秒数
	private static long getMillisecondsIntimepart4Date(Date datetime) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(datetime);
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		long time1 = calendar.getTimeInMillis();
		long time2 = datetime.getTime();
		return (long)((time2 - time1) / 3.33333);
	}
	
	// int 转 byte[]
    private static byte[] int2Bytes(int num) {
        byte[] byteNum = new byte[4];
        for (int ix = 0; ix < 4; ++ix) {
            int offset = 32 - (ix + 1) * 8;
            byteNum[ix] = (byte) ((num >> offset) & 0xff);
        }
        return byteNum;
    }

    // byte[] 转  int
    private static int bytes2Int(byte[] byteNum) {
        int num = 0;
        for (int ix = 0; ix < 4; ++ix) {
            num <<= 8;
            num |= (byteNum[ix] & 0xff);
        }
        return num;
    }
    //long 转 byte[]
    private static byte[] long2Bytes(long num) {
        byte[] byteNum = new byte[8];
        for (int ix = 0; ix < 8; ++ix) {
            int offset = 64 - (ix + 1) * 8;
            byteNum[ix] = (byte) ((num >> offset) & 0xff);
        }
        return byteNum;
    }

    // byte[] 转  long
    private static long bytes2Long(byte[] byteNum) {
        long num = 0;
        for (int ix = 0; ix < 8; ++ix) {
            num <<= 8;
            num |= (byteNum[ix] & 0xff);
        }
        return num;
    }
}
