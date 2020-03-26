package com.hxoim.common.utils;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Date 2019/07/27
 * @author zb
 */
public class RsaUtil {

    private static final String RSA_ALGORITHM = "RSA";
    private static final String SIGNATURE_ALGORITHM = "MD5withRSA";
    private static final String RSA_PUBLIC_KEY = "RSAPublicKey";
    private static final String RSA_PRIVATE_KEY = "RSAPrivateKey";
    private static final int MAX_ENCRYPT_BLOCK = 117;
    private static final int MAX_DECRYPT_BLOCK = 128;

    //公钥
    private static String public_key ="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCDkayP3rX4FaSSYHon8mAFzgfeRi2AKDAbgAeJQ2ohT0Wt/1o1/pto250y8" +
            "c3pzFCkzC78ykFXAWRdn7rfeM58VOY/3jcQsuAOZYKs601yZoHP22ph09wZhsUZdmdjQ3T/0gpOpHVmUSJRKlEUDwXU7xTe3WJc3xQG72WYryZ9nQIDAQAB";
    //私钥
    private static String private_key ="MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIORrI/etfgVpJJgeifyYAXOB95GLYAoMBuAB4lDaiFPRa3/W" +
            "jX+m2jbnTLxzenMUKTMLvzKQVcBZF2fut94znxU5j/eNxCy4A5lgqzrTXJmgc/bamHT3BmGxRl2Z2NDdP/SCk6kdWZRIlEqURQPBdTvFN7dYlzfFAbvZZivJn2d" +
            "AgMBAAECgYB56q5F7vEePyft//qSM7WpC18dKFiXbiYOBZh2KIMa9LMz5fB5IkJuazsC7zCJGqwL2a0c0Gq1rfOMEix/Uhm7pj7Zkynl3Nhi7c211TRc1PKkUUL" +
            "nb1xLegEtGCjFGpvP2eQU8/IBpNwtQ/Tu6hunqEkRXL6qfuYTswU6/SZY4QJBAL1/w8o9m1e8YzjhOUd4q+5qQMdigQfS+5MWLHQsph+BrgoPX2AiRYBnoZUcdc" +
            "aeeyklls0WecrAkqASdkUvV0UCQQCxvZXFaLzcCuDoaeB0Jj4tmU0FxwQq8GxwJVmZ+k35JavKasItp3oR0hxPtGBez4YaZHJ54F75KMMP/fyNqiZ5AkEAr70PbD" +
            "1aFTGmqxdkMX4dpMtxK/eURhdKLAxCSbMmlM2FA9thzhu6bOyuk0SDjSFogq5Tffs8E+YnlL/KYzsWKQJAcj7nHw20n0eKyzkK4f2W595q6LTElAkX2nnXfyapqe" +
            "Sx6Jj4mTnWN9AzDHRnoWmIzDwWbQpwYXz27LeX90MQGQJAMlsfBQDArO4Fvi7pJhXVFyOjht96n2Z6kt3aU30lqeJCQU0f2a7CNKsNYOwT2pdFu2ZlDZDu87QNlE" +
            "mndLrRUw==";

    public static byte[] decryptBASE64(String key) {
        return Base64.decode(key);
    }

    public static String encryptBASE64(byte[] bytes) {
        return Base64.encode(bytes);
    }

    /**
     *  使用私钥对数据进行签名
     * @param binaryData
     * @param privateKey
     * @return
     * @throws Exception
     */
    public static String sign(byte[] binaryData, String privateKey) throws Exception {
        byte[] keyBytes = Base64.decode(privateKey);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        PrivateKey priKey = keyFactory.generatePrivate(keySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(priKey);
        signature.update(binaryData);
        return Base64.encode(signature.sign());
    }

    /**
     * 使用公钥对数据签名进行验证
     */
    public static boolean verify(byte[] binaryData, String publicKey, String sign) throws Exception {
        byte[] keyBytes = Base64.decode(publicKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        PublicKey pubKey = keyFactory.generatePublic(keySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(pubKey);
        signature.update(binaryData);
        return signature.verify(Base64.decode(sign));
    }

    /**
     * 获取RSA算法私钥、公钥
     */
    public static Map<String, Object> getKey() throws NoSuchAlgorithmException {
        Map<String, Object> keyMap = new HashMap<String, Object>(2);
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(RSA_ALGORITHM);
        keyPairGen.initialize(1024);//1024代表密钥二进制位数
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        keyMap.put(RSA_PUBLIC_KEY, publicKey);//公钥
        keyMap.put(RSA_PRIVATE_KEY, privateKey);//私钥
        return keyMap;
    }

    /**
     * 获取公钥
     */
    public static String getPublicKey(Map<String, Object> map) {
        Key key = (Key) map.get(RSA_PUBLIC_KEY);
        return Base64.encode(key.getEncoded());
    }

    /**
     * 获取私钥
     */
    public static String getPrivateKey(Map<String, Object> map) {
        Key key = (Key) map.get(RSA_PRIVATE_KEY);
        return Base64.encode(key.getEncoded());
    }

    /**
     * 使用私钥对数据进行加密
     */
    public static byte[] encryptPrivateKey(byte[] binaryData, String privateKey) throws Exception {
        byte[] keyBytes = Base64.decode(privateKey);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        Key priKey = keyFactory.generatePrivate(keySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, priKey);
        byte[] encryptedData = cipherDoFinal(cipher,binaryData,MAX_ENCRYPT_BLOCK);
        return encryptedData;
    }

    /**
     * 使用公钥对数据进行加密
     */
    public static byte[] encryptPublicKey(byte[] binaryData, String publicKey) throws Exception {
        byte[] keyBytes = Base64.decode(publicKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        Key pubKey = keyFactory.generatePublic(keySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        byte[] encryptedData = cipherDoFinal(cipher,binaryData,MAX_ENCRYPT_BLOCK);
        return encryptedData;
    }

    /**
     * 使用私钥对数据进行解密
     */
    public static byte[] decryptPrivateKey(byte[] binaryData, String privateKey) throws Exception {
        byte[] keyBytes = Base64.decode(privateKey);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        Key priKey = keyFactory.generatePrivate(keySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        byte[] encryptedData = cipherDoFinal(cipher,binaryData,MAX_DECRYPT_BLOCK);
        return encryptedData;
    }

    /**
     * 使用公钥对数据进行解密
     */
    public static byte[] decryptPublicKey(byte[] binaryData, String publicKey) throws Exception {
        byte[] keyBytes = Base64.decode(publicKey);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        Key pubKey = keyFactory.generatePublic(x509KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, pubKey);
        byte[] encryptedData = cipherDoFinal(cipher,binaryData,MAX_DECRYPT_BLOCK);
        return encryptedData;
    }

    /**
     * 分段加密计算
     * @param cipher
     * @param srcBytes
     * @param segmentSize
     * @return
     * @throws Exception
     */
    public static byte[] cipherDoFinal(Cipher cipher, byte[] srcBytes, int segmentSize) throws Exception{
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int inputLen = srcBytes.length;
        int offSet = 0;
        byte[] cache;
        int i = 0;
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > segmentSize) {
                cache = cipher.doFinal(srcBytes, offSet, segmentSize);
            } else {
                cache = cipher.doFinal(srcBytes, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * segmentSize;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        return encryptedData;
    }

    /**
     *  公钥加密
     * @param data
     * @return
     * @throws Exception
     */
    public static String encryptPublicKey(String data)throws Exception{
        byte datas[];
        try {
            datas = encryptPublicKey(data.getBytes("utf-8"),public_key);
            return encryptBASE64(datas);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 私钥解密
     * @param data
     * @return
     * @throws Exception
     */
    public static String decryptPrivateKey(String data) throws Exception{
        byte datas[];
        try {
            datas =decryptPrivateKey(decryptBASE64(data),private_key);
            return new String(datas, "UTF8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *  私钥加密
     * @param data
     * @return
     * @throws Exception
     */
    public static String encryptPrivateKey(String data)throws Exception{
        byte datas[];
        try {
            datas = encryptPrivateKey(data.getBytes("utf-8"),private_key);
            return encryptBASE64(datas);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 公钥解密
     * @param data
     * @return
     * @throws Exception
     */
    public static String decryptPublicKey(String data) throws Exception{
        byte datas[];
        try {
            datas = decryptPublicKey(decryptBASE64(data),public_key);
            return new String(datas, "UTF8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) throws Exception {

//    	Map<String, Object> key_map = getKey()  ;
//
//    	String public_key = encryptBASE64(((PublicKey) key_map.get(RSA_PUBLIC_KEY)).getEncoded());
//    	String private_key = encryptBASE64(((PrivateKey) key_map.get(RSA_PRIVATE_KEY)).getEncoded());
//
//    	System.out.println("public_key:" +public_key);
//    	System.out.println("private_key:" +private_key);

//    	String data = "test123" ;
//
//        byte[] s1 = encryptPublicKey(data.getBytes() , public_key);
//        String en_str = encryptBASE64(s1) ;
//        System.out.println(en_str);
//
//
//    	 byte[] s2 = decryptPrivateKey(decryptBASE64(en_str) , private_key);
//    	 String de_str = new String(s2);
//     	 System.out.println(de_str);

        String data = "asdfgthyjukijuyhtrewddefrtghyujiyjtrgf驾驶人佛教而融if今儿个评委而苹果味儿匍匐前进二鹏为人父";
        //公加
        String rsa_str = encryptPublicKey(data);

        System.out.println("加密后:" + rsa_str);
        //私解
        String encode_str = decryptPrivateKey(rsa_str);

        System.out.println("解密后:" + encode_str);

//        //私加
//        String rsa = encryptPrivateKey(data);
//
//        System.out.println("加密后:" + rsa);
//        //公解
//        String encode = decryptPublicKey(rsa);
//
//        System.out.println("解密后:" + encode);

    }

}
