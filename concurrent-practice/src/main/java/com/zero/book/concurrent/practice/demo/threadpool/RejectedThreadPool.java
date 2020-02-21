/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.zero.book.concurrent.practice.demo.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p>拒绝策略线程池 .</p>
 * <p>时间 ： 2020年2月21日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  1150310037
 * @version 1.0
 */
public class RejectedThreadPool {

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
//		ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,new SynchronousQueue<Runnable>(), 
//				Executors.defaultThreadFactory(), new RejectedExecutionHandler() {
//					
//					@Override
//					public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
//						System.out.println(r.toString() + " is discard");
//					}
//		});
		ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>(), 
				Executors.defaultThreadFactory(), (r,e) -> System.out.println(r.toString() + " is discard"));
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			MyTask task = new MyTask("TASK-" + i);
//			es.execute(task);
			es.submit(task);
			Thread.sleep(10);
		}
		es.shutdown();
	}
}
