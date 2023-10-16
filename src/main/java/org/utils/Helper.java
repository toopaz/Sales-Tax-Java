package org.utils;

public class Helper {

    public static double roundUp (double number,double precision) {
        return (Math.ceil(number / precision) * precision);
    }
}
