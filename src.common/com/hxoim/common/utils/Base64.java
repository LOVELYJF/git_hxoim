package com.hxoim.common.utils;

/**
 * @author Mr.Ding
 * @Date 2018/06/29
 * @Version 3.0
 */
public final class Base64 {
	static public String encode(byte[] bytes) {
		char[] array = new char[((bytes.length + 2) / 3) * 4];
		for (int i = 0, index = 0; i < bytes.length; i += 3, index += 4) {
			boolean quad = false;
			boolean trip = false;
			int val = (0xFF & (int) bytes[i]);
			val <<= 8;
			if ((i + 1) < bytes.length) {
				val |= (0xFF & (int) bytes[i + 1]);
				trip = true;
			}
			val <<= 8;
			if ((i + 2) < bytes.length) {
				val |= (0xFF & (int) bytes[i + 2]);
				quad = true;
			}
			array[index + 3] = alphabet[(quad ? (val & 0x3F) : 64)];
			val >>= 6;
			array[index + 2] = alphabet[(trip ? (val & 0x3F) : 64)];
			val >>= 6;
			array[index + 1] = alphabet[val & 0x3F];
			val >>= 6;
			array[index + 0] = alphabet[val & 0x3F];
		}
		return new String(array);
	}

	static public byte[] decode(String str) {
		char[] array = str.toCharArray();
		int len = ((array.length + 3) / 4) * 3;
		if (array.length > 0 && array[array.length - 1] == '=')
			--len;
		if (array.length > 1 && array[array.length - 2] == '=')
			--len;
		byte[] out = new byte[len];
		int shift = 0;
		int accum = 0;
		int index = 0;
		for (int ix = 0; ix < array.length; ix++) {
			int value = codes[array[ix] & 0xFF];
			if (value >= 0) {
				accum <<= 6;
				shift += 6;
				accum |= value;
				if (shift >= 8) {
					shift -= 8;
					out[index++] = (byte) ((accum >> shift) & 0xff);
				}
			}
		}
		if (index != out.length)
			throw new Error("miscalculated data length!");
		return out;
	}

	static private char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/="
			.toCharArray();

	static private byte[] codes = new byte[256];
	static {
		for (int i = 0; i < 256; i++)
			codes[i] = -1;
		for (int i = 'A'; i <= 'Z'; i++)
			codes[i] = (byte) (i - 'A');
		for (int i = 'a'; i <= 'z'; i++)
			codes[i] = (byte) (26 + i - 'a');
		for (int i = '0'; i <= '9'; i++)
			codes[i] = (byte) (52 + i - '0');
		codes['+'] = 62;
		codes['/'] = 63;
	}
}