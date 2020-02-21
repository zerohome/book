/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.zero.book.concurrent.practice.demo.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p>扩展线程池 .</p>
 * <p>时间 ： 2020年2月21日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  1150310037
 * @version 1.0
 */
public class ExtendThreadPool {

	public static class MyTask implements Runnable{
		public String name;
		
		public MyTask(String name) {
			this.name = name;
		}
		
		@Override
		public void run() {
			System.out.println("正在执行" + ":Thread ID-" + Thread.currentThread().getId() + "-Task name=" + name);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) throws InterruptedException {
		ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>()) {
			@Override
			protected void beforeExecute(Thread t, Runnable r) {
				System.out.println("执行前:" + ((MyTask) r).name);
			}
			
			@Override
			protected void afterExecute(Runnable r, Throwable t) {
				System.out.println("执行完成:" + ((MyTask) r).name);
			}
			
			@Override
			protected void terminated() {
				System.out.println("线程池退出");
			}
		};
		for (int i = 0; i < 5; i++) {
			MyTask task = new MyTask("TASK-" + i);
			es.execute(task);
			Thread.sleep(10);
		}
		es.shutdown();
	}
}
