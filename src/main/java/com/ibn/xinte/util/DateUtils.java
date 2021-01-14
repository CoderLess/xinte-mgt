package com.ibn.xinte.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.util
 * @author： RenBin
 * @createTime：2021/01/14 20:48
 */
public class DateUtils {
    private DateUtils() {}

    /**
     * @description: 获取年龄
     * @author：RenBin
     * @createTime：2021/1/14 20:53
     */
    public static Integer getAge(Long birthday) {
        if (null == birthday || birthday < 1) {
            return 0;
        }
        int age;
        try {
            // 当前时间
            Calendar now = Calendar.getInstance();
            now.setTime(new Date());

            // 用户出生日期
            Calendar birth = Calendar.getInstance();
            birth.setTime(new Date(birthday));

            if (birth.after(now)) {
                //如果传入的时间，在当前时间的后面，返回0岁
                age = 0;
            } else {
                // 计算年龄
                age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
                if (now.get(Calendar.DAY_OF_YEAR) > birth.get(Calendar.DAY_OF_YEAR)) {
                    age += 1;
                }
            }
            return age;
        } catch (Exception e) {//兼容性更强,异常后返回数据
            return 0;
        }
    }
}
