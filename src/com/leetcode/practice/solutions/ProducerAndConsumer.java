package com.leetcode.practice.solutions;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerAndConsumer {

    public static BlockingQueue<String> channel = new LinkedBlockingQueue<>(10);

    public static void main(String[] args) throws InterruptedException {
        // Producer
        new Thread(() -> {
            while (true) {
                try {
                    channel.put("Produce: " + System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // Consumer
        new Thread(() -> {

            while(true) {
                try {
                    Thread.sleep(200);
                    String result = channel.take();
                    System.out.println("Consumer: " + result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
