package com.javaedge.datetime.newdate;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class CommonMistakesApplication {

    public static void main(String[] args) throws Exception {
        wrong();
        right();
        better();
        midnightGap();
    }

    private static void wrong() {
        System.out.println("bad");
        Date date = new Date(2019, 12, 31, 11, 12, 13);
        System.out.println(date);
    }

    private static void wrongfix() {
        System.out.println("right");
        Date date = new Date(2019 - 1900, 11, 31, 11, 12, 13);
        System.out.println(date);
    }

    private static void right() {
        System.out.println("right");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 11, 31, 11, 12, 13);
        System.out.println(calendar.getTime());
        Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));
        calendar2.set(2019, Calendar.DECEMBER, 31, 11, 12, 13);
        System.out.println(calendar2.getTime());

    }

    private static void better() {
        System.out.println("better");
        LocalDateTime localDateTime = LocalDateTime.of(2019, Month.DECEMBER, 31, 11, 12, 13);
        System.out.println(localDateTime);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("America/New_York"));
        System.out.println(zonedDateTime);
    }

    /**
     * 当天剩余秒数
     */
    private static void midnightGap() {
        LocalDateTime midnight = LocalDateTime.now().plusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
        long seconds = ChronoUnit.SECONDS.between(LocalDateTime.now(),midnight);
        System.out.println("当天剩余秒数：" + seconds);
    }
}

