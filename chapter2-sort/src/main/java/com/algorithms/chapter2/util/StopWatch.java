package com.algorithms.chapter2.util;

public class StopWatch {
    private long startTime;
    public StopWatch(){
        startTime = System.currentTimeMillis();
    }
    public long usedTime(){
        return System.currentTimeMillis()-startTime;
    }
}
