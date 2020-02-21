/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.zero.book.concurrent.practice.demo.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>线程池Demo .</p>
 * <p>时间 ： 2020年2月20日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  1150310037
 * @version 1.0
 */
public class ThreadPoolDemo {

	public static class Task implements Runnable{

		@Override
		public void run() {
			System.out.println(System.currentTimeMillis() + ":Thread ID-" + Thread.currentThread().getId());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Task task = new Task();
		ExecutorService exe = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
//			exe.submit(task);
			exe.execute(task);
		}
	}
	
}
