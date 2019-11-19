package com.hqgml.utils;

import org.springframework.core.convert.converter.Converter;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @data 11/15/2019 10:14 AM
 **/
public class DateUtlis implements Converter<String, Date> {

    /**
     * 日期转字符串
     *
     * @param date
     * @param patt
     * @return
     */
    public static String dateToString(Date date, String patt) {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        String format = sdf.format(date);
        return format;
    }

    /**
     * 字符串转日期
     *
     * @param dataString
     * @param patt
     * @return
     * @throws ParseException
     */
    public static Date stringToDate(String dataString, String patt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        Date parse = sdf.parse(dataString);
        return parse;
    }

    /**
     * 自定义类型转换器
     *
     * @param source 传进来的字符串
     * @return
     */
    @Override
    public Date convert(String source) {

        if (source == null) {
            throw new RuntimeException("请输入你要转换的字符串");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            return sdf.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException("转换日期失败");
        }
    }
}
