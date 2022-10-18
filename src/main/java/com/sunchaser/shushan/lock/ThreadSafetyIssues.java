package com.sunchaser.shushan.lock;

import lombok.extern.slf4j.Slf4j;

/**
 * Thread safety issues
 *
 * @author sunchaser admin@lilu.org.cn
 * @since JDK8 2022/10/18
 */
@Slf4j
public class ThreadSafetyIssues {

    public static void main(String[] args) throws InterruptedException {
        SharedResources sr = new SharedResources();
        int loopCounts = 1000;
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < loopCounts; i++) {
                sr.increment();
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < loopCounts; i++) {
                sr.decrement();
            }
        }, "t2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        LOGGER.info("count: {}", sr.getCount());
    }
}
