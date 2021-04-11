package com.sparta.jack.utilities;

public class Timer {

    private static long startTime, endTime;

    public static void startTimer(){
        startTime = System.nanoTime();
    }

    public static double stopTimerAndGetTime(){
        endTime = System.nanoTime();
        return (endTime - startTime)/1000000000d;
    }
}
