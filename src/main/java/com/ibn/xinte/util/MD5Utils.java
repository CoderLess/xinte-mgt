package com.ibn.xinte.util;

import com.ibn.xinte.exception.IbnException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte-mgt
 * @see: com.ibn.xinte.util
 * @author： RenBin
 * @createTime：2021/01/01 01:19
 */
public class MD5Utils {
    private static final Logger logger = LoggerFactory.getLogger(MD5Utils.class);

    public static String getMD5Str(String str) throws IbnException {
        byte[] digest;
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("md5");
            digest = md5.digest(str.getBytes("utf-8"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            String msg = String.format("md5加密失败：%s", str);
            logger.error(msg, e);
            throw new IbnException("获取md5信息异常");
        }

        //16是表示转换为16进制数
        String md5Str = new BigInteger(1, digest).toString(16);
        return md5Str;
    }
}
