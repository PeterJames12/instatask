package com.example.instatask.util;

/**
 * @author Igor Hnes on 12/26/17.
 */
public final class StringUtil {
    private StringUtil() {
    }

    /**
     * @param time String "10:00:00"
     * @return formatted string "10:00"
     */
    public static String formatStringTimeWithoutSecond(String time) {
        return time.substring(0, time.lastIndexOf(":"));
    }

}
