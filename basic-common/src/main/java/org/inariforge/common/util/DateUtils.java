package org.inariforge.common.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * 日期時間工具類.
 */
public final class DateUtils {

    public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final ZoneId DEFAULT_ZONE = ZoneId.of("Asia/Taipei");

    private static final DateTimeFormatter DEFAULT_FORMATTER =
            DateTimeFormatter.ofPattern(DEFAULT_PATTERN);

    private DateUtils() {
    }

    public static LocalDateTime now() {
        return LocalDateTime.now(DEFAULT_ZONE);
    }

    public static String format(LocalDateTime dateTime) {
        return dateTime.format(DEFAULT_FORMATTER);
    }

    public static LocalDateTime parse(String dateTimeStr) {
        return LocalDateTime.parse(dateTimeStr, DEFAULT_FORMATTER);
    }
}
