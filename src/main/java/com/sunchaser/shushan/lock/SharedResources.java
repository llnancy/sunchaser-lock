package com.sunchaser.shushan.lock;

/**
 * shared resources
 *
 * @author sunchaser admin@lilu.org.cn
 * @since JDK8 2022/10/18
 */
public class SharedResources {

    private int count = 0;

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }

    public int getCount() {
        return count;
    }
}
