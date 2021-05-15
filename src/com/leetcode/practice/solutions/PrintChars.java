package com.leetcode.practice.solutions;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class PrintChars {

    public static void main(String[] args) {
        final Queue<Character> chars = new ArrayDeque<>();
        for (char c = 'A'; c <= 'Z'; c ++) {
            chars.add(c);
        }

        final Semaphore s1 = new Semaphore(1);
        final Semaphore s2 = new Semaphore(0);
        final Semaphore s3 = new Semaphore(0);
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        s1.acquire(1);
                        System.out.println("1" + chars.poll());
                        if (chars.size() <= 2) {
                            if (!chars.isEmpty()) {
                                s2.release(1);
                            }
                            break;
                        } else {
                            s2.release(1);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        s2.acquire(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("2" + chars.poll());
                    if (chars.size() <= 2) {
                        if (!chars.isEmpty()) {
                            s3.release(1);
                        }
                        break;
                    } else {
                        s3.release(1);
                    }
                }
            }
        };

        Thread t3 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        s3.acquire(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("3" + chars.poll());
                    if (chars.size() <= 2) {
                        if (!chars.isEmpty()) {
                            s1.release(1);
                        }
                        break;
                    } else {
                        s1.release(1);
                    }
                }
            }
        };

        t1.start();
        t2.start();
        t3.start();
    }

}
