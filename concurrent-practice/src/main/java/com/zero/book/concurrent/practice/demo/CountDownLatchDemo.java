/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.zero.book.concurrent.practice.demo;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>倒数计数器 .</p>
 * <p>时间 ： 2020年2月18日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  1150310037
 * @version 1.0
 */
public class CountDownLatchDemo implements Runnable{

	static final CountDownLatch end = new CountDownLatch(10);
	static final CountDownLatchDemo task = new CountDownLatchDemo();
	@Override
	public void run() {
		try {
			Thread.sleep(new Random().nextInt(10) * 1000);
			System.out.println(Thread.currentThread().getId() + " check completed");
			end.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			exec.submit(task);
		}
		end.await();
		System.out.println("准备就绪，发射火箭");
		exec.shutdown();
	}
}
