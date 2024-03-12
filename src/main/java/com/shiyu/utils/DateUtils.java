package com.shiyu.utils;

import cn.hutool.core.date.DateUtil;

import java.util.Calendar;
import java.util.Date;

/**
 * 此工具类包含了基本上常用的工具类，包含对于各种类型的日期的转换，以及转成我们所需要的各种类型日期格式。
 */

public class DateUtils {

    /**
     * 仅显示年月日，例如 2015-08-11.
     */
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    /**
     * 显示年月日时分秒，例如 2015-08-11 09:51:53.
     */
    public static final String DATETIME_FORMAT_ONE = "yyyy-MM-dd HH:mm:ss";
    /**
     * 显示年月日时分秒，例如 2015-08-11 09:51:53.
     */
    public static final String DATETIME_FORMAT_TWO = "yyyy.MM.dd HH:mm:ss";

    /**
     * 仅显示时分秒，例如 09:51:53.
     */
    public static final String TIME_FORMAT = "HH:mm:ss";

    /**
     * 仅显示年月，例如 2015-08
     */
    public static final String MONTH_TIME_PATTERN = "yyyy-MM";

    /**
     * 仅显示年，例如 2015
     */
    public static final String YEAR_TIME_PATTERN = "yyyy";

    /**
     * 每天的毫秒数 8640000.
     */
    public static final long MILLISECONDS_PER_DAY = 86400000L;

    /**
     * 每周的天数.
     */
    public static final long DAYS_PER_WEEK = 7L;

    /**
     * 每小时毫秒数.
     */
    public static final long MILLISECONDS_PER_HOUR = 3600000L;

    /**
     * 每分钟秒数.
     */
    public static final long SECONDS_PER_MINUTE = 60L;

    /**
     * 每小时秒数.
     */
    public static final long SECONDS_PER_HOUR = 3600L;

    /**
     * 每天秒数.
     */
    public static final long SECONDS_PER_DAY = 86400L;

    /**
     * 每个月秒数，默认每月30天.
     */
    public static final long SECONDS_PER_MONTH = 2592000L;

    /**
     * 每年秒数，默认每年365天.
     */
    public static final long SECONDS_PER_YEAR = 31536000L;


    /**
     * 得到当前日期字符串.
     *
     * @return String 日期字符串，例如2015-08-11
     * @since 1.0
     */
    public static String getDate() {
        return getDate(DateUtils.DATE_FORMAT);
    }

    /**
     * 获取当前时间指定格式下的字符串.
     *
     * @param pattern 转化后时间展示的格式，例如"yyyy-MM-dd"，"yyyy-MM-dd HH:mm:ss"等
     * @return String 格式转换之后的时间字符串.
     * @since 1.0
     */
    public static String getDate(String pattern) {
        return DateUtil.format(new Date(), pattern);
    }

    /**
     * 获取指定日期的字符串格式.
     *
     * @param date    需要格式化的时间，不能为空
     * @param pattern 时间格式，例如"yyyy-MM-dd"，"yyyy-MM-dd HH:mm:ss"等
     * @return String 格式转换之后的时间字符串.
     * @since 1.0
     */
    public static String getDate(Date date, String pattern) {
        return DateUtil.format(date, pattern);
    }

    /**
     * 获取日期时间字符串，默认格式为（yyyy-MM-dd）.
     *
     * @param date    需要转化的日期时间
     * @param pattern 时间格式，例如"yyyy-MM-dd" "HH:mm:ss" "E"等
     * @return String 格式转换后的时间字符串
     * @since 1.0
     */
    public static String formatDate(Date date, Object... pattern) {
        String formatDate = null;
        if (pattern != null && pattern.length > 0) {
            formatDate = DateUtil.format(date, pattern[0].toString());
        } else {
            formatDate = DateUtil.format(date, DateUtils.DATE_FORMAT);
        }
        return formatDate;
    }

    /**
     * 获取当前日期与指定日期相隔的天数.
     *
     * @param date 给定的日期
     * @return long 日期间隔天数，正数表示给定日期在当前日期之前，负数表示在当前日期之后
     * @since 1.0
     */
    public static long pastDays(Date date) {
        // 将指定日期转换为yyyy-MM-dd格式
        date = DateUtil.parseDate(DateUtils.formatDate(date, DateUtils.DATE_FORMAT));
        // 当前日期转换为yyyy-MM-dd格式
        Date currentDate = DateUtil.parseDate(DateUtils.formatDate(new Date(), DateUtils.DATE_FORMAT));
        long t = 0;
        t = (currentDate.getTime() - date.getTime()) / DateUtils.MILLISECONDS_PER_DAY;
        return t;
    }

    /**
     * 获取当前日期指定天数之后的日期.
     *
     * @param num 相隔天数
     * @return Date 日期
     * @since 1.0
     */
    public static Date nextDay(int num) {
        Calendar curr = Calendar.getInstance();
        curr.set(Calendar.DAY_OF_MONTH, curr.get(Calendar.DAY_OF_MONTH) + num);
        return curr.getTime();
    }

    /**
     * 获取当前日期指定月数之后的日期.
     *
     * @param num 间隔月数
     * @return Date 日期
     * @since 1.0
     */
    public static Date nextMonth(int num) {
        Calendar curr = Calendar.getInstance();
        curr.set(Calendar.MONTH, curr.get(Calendar.MONTH) + num);
        return curr.getTime();
    }

    /**
     * 获取当前日期指定年数之后的日期.
     *
     * @param num 间隔年数
     * @return Date 日期
     * @since 1.0
     */
    public static Date nextYear(int num) {
        Calendar curr = Calendar.getInstance();
        curr.set(Calendar.YEAR, curr.get(Calendar.YEAR) + num);
        return curr.getTime();
    }

    /**
     * getDayOfWeek(获取当前日期是星期几)
     *
     * @param dateStr 日期
     * @return 星期几
     */
    public static String getDayOfWeek(String dateStr) {
        String[] weekOfDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Date date = DateUtil.parseDate(dateStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int num = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        return weekOfDays[num];
    }

    /**
     * 在日期上增加数个整年
     */
    public static Date addYear(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, n);
        return cal.getTime();
    }

    /**
     * 在日期上增加数个整月
     */
    public static Date addMonth(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return cal.getTime();
    }

    /**
     * 在日期上增加数个整日(n为负数则是减少数日)
     */
    public static Date addDay(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, n);
        return cal.getTime();
    }

    /**
     * 在日期上增加数个小时(n为负数则是减少数小时)
     */
    public static Date addHour(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR_OF_DAY, n);
        return cal.getTime();
    }

    /**
     * 获取明日0点时刻
     * <p>
     * 比如今天是2019-02-01，调用这个方法会返回2019-02-02
     *
     * @return
     */
    public static Date getTomorrowDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, 1);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        return cal.getTime();
    }

    /**
     * 获取昨天0点时刻
     * <p>
     * 比如今天是2021-11-26，调用这个方法会返回2021-11-25
     *
     * @return
     */
    public static Date getYesterdayDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, -1);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        return cal.getTime();
    }

    /**
     * 获取当天日期0点时刻
     * <p>
     * 比如今天是2021-11-26，调用这个方法会返回2021-11-26
     *
     * @return
     */
    public static Date getTodayDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        return cal.getTime();
    }

    /**
     * 获取当月1号0点时刻
     * <p>
     * 比如今天是2021-11-26，调用这个方法会返回2021-11-01
     *
     * @return
     */
    public static Date getMonthFirstDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1, 0, 0, 0);
        return cal.getTime();
    }

    /**
     * 获取上月1号0点时刻
     * <p>
     * 比如今天是2021-11-26，调用这个方法会返回2021-11-01
     *
     * @return
     */
    public static Date getLastMonthFirstDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, -1);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1, 0, 0, 0);
        return cal.getTime();
    }
    /**
     * 获取N月之后 N月1号0点时刻
     * <p>
     * 比如今天是2021-11-26，调用这个方法会返回2021-n-01
     *
     * @return
     */
    public static Date getNMonthFirstDate(int  n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, n);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1, 0, 0, 0);
        return cal.getTime();
    }

    /**
     * 获取下月1号0点时刻
     * <p>
     * 比如今天是2021-11-26，调用这个方法会返回2021-12-01
     *
     * @return
     */
    public static Date getNextMonthFirstDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, 1);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1, 0, 0, 0);
        return cal.getTime();
    }

    /**
     * 获取当年1月1号0点时刻
     * <p>
     * 比如今天是2021-11-26，调用这个方法会返回2021-01-01
     *
     * @return
     */
    public static Date getYearFirstDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(cal.get(Calendar.YEAR), 0, 1, 0, 0, 0);
        return cal.getTime();
    }

    /**
     * 在日期上增加数个分钟(n为负数则是减少数分钟)
     */
    public static Date addMinute(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, n);
        return cal.getTime();
    }

    /**
     * 获取去年1月1号0点时刻
     * <p>
     * 比如今天是2021-11-26，调用这个方法会返回2020-01-01
     *
     * @return
     */
    public static Date getLastYearFirstDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.YEAR, -1);
        cal.set(cal.get(Calendar.YEAR), 0, 1, 0, 0, 0);
        return cal.getTime();
    }

    /**
     * 获取明年1月1号0点时刻
     * <p>
     * 比如今天是2021-11-26，调用这个方法会返回2022-01-01
     *
     * @return
     */
    public static Date getNextYearFirstDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.YEAR, 1);
        cal.set(cal.get(Calendar.YEAR), 0, 1, 0, 0, 0);
        return cal.getTime();
    }

    /**
     * 时间格式化到天
     * <p>
     * 比如时间是2021-11-26 13:42:00，调用这个方法会返回2021-11-26 00:00:00
     *
     * @return
     */
    public static Date formatDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, 1);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        return cal.getTime();
    }

    /**
     * 判断当前时间是否在开始事假和结束时间之间
     *
     * @param nowTime   现在时间
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return boolean
     */
    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        return date.after(begin) && date.before(end);
    }

}
