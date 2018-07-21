package org.jeecgframework.core.util;

import java.io.IOException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.sound.midi.Soundbank;
import javax.xml.bind.SchemaOutputResolver;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class AESUtil {
    //生成AES秘钥，然后Base64编码
    public static String genKeyAES() throws Exception{
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey key = keyGen.generateKey();
        System.out.println(key.getEncoded());
        String base64Str = byte2Base64(key.getEncoded());
        return base64Str;
    }

    //将Base64编码后的AES秘钥转换成SecretKey对象
    public static SecretKey loadKeyAES(String base64Key) throws Exception{
        byte[] bytes = base642Byte(base64Key);
        SecretKeySpec key = new SecretKeySpec(bytes, "AES");
        return key;
    }

    //字节数组转Base64编码
    public static String byte2Base64(byte[] bytes){
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(bytes);
    }

    //Base64编码转字节数组
    public static byte[] base642Byte(String base64Key) throws IOException{
        BASE64Decoder decoder = new BASE64Decoder();
        return decoder.decodeBuffer(base64Key);
    }

    //加密
    public static byte[] encryptAES(byte[] source, SecretKey key) throws Exception{
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(source);
    }

    //解密
    public static byte[] decryptAES(byte[] source, SecretKey key) throws Exception{
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(source);
    }

    //加密id
    public static String encodeId (String id) throws Exception{
        String message = id;
        //生成AES秘钥，并Base64编码
//            String base64Str = AESUtil.genKeyAES();
        String base64Str = "ALlV/upwcjShHOT+5cG7Uw==";
        //将Base64编码的字符串，转换成AES秘钥
        SecretKey aesKey = loadKeyAES(base64Str);
        //加密
        byte[] encryptAES = encryptAES(message.getBytes(), aesKey);
        //加密后的内容Base64编码
        String byte2Base64 = AESUtil.byte2Base64(encryptAES);
        return byte2Base64;
    }

    public static String decodeId (String byte2Base64) throws Exception{
        String base64Str = "ALlV/upwcjShHOT+5cG7Uw==";
        SecretKey aesKey2 = AESUtil.loadKeyAES(base64Str);
        //加密后的内容Base64解码
        byte[] base642Byte = AESUtil.base642Byte(byte2Base64);
        //解密
        byte[] decryptAES = AESUtil.decryptAES(base642Byte, aesKey2);
        return new String(decryptAES);
    }
    public static void main(String[] args) {
        try {
//            //=================客户端=================
//            //hello, i am infi, good night!加密
//            String message = "1";
//            //生成AES秘钥，并Base64编码
////            String base64Str = AESUtil.genKeyAES();
//            String base64Str = "ALlV/upwcjShHOT+5cG7Uw==";
//            System.out.println("AES秘钥Base64编码:" + base64Str);
//            //将Base64编码的字符串，转换成AES秘钥
//            SecretKey aesKey = AESUtil.loadKeyAES(base64Str);
//            //加密
//            byte[] encryptAES = AESUtil.encryptAES(message.getBytes(), aesKey);
//            //加密后的内容Base64编码
//            String byte2Base64 = AESUtil.byte2Base64(encryptAES);
//            System.out.println("加密并Base64编码的结果：" + byte2Base64);
//
//
//            //##############    网络上传输的内容有Base64编码后的秘钥 和 Base64编码加密后的内容      #################
//
//
//            //===================服务端================
//            //将Base64编码的字符串，转换成AES秘钥
//            SecretKey aesKey2 = AESUtil.loadKeyAES(base64Str);
//            //加密后的内容Base64解码
//            byte[] base642Byte = AESUtil.base642Byte(byte2Base64);
//            //解密
//            byte[] decryptAES = AESUtil.decryptAES(base642Byte, aesKey2);
//            //解密后的明文
//            System.out.println("解密后的明文: " + new String(decryptAES));
            String aaa = encodeId("123456");
            System.out.println(aaa);
            String bbb = decodeId(aaa);
            System.out.println(bbb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
