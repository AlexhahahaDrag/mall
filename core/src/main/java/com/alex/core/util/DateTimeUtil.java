package com.alex.core.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Description: 日期工具
 * @Author:     alex
 * @CreateDate: 2019/7/30 16:04
 * @Version:    1.0
 *
*/
public class DateTimeUtil {

    /**
     * @Description: 格式 yyyy-MM-dd HH:mm:ss
     * @Author:      alex
     * @CreateDate:  2019/7/30 16:04
     * @param
     * @return
    */
    public static String getDateTimeDisplayString(LocalDateTime dateTime) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String strDate = df.format(dateTime);
        return strDate;
    }
}
