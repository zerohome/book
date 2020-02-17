/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.zero.book.concurrent.practice.demo;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2020年2月16日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  1150310037
 * @version 1.0
 */
public class BadSuspend {

	public static Object lockObject = new Object();
	
	static ChangeObjectThread t1 = new ChangeObjectThread("t1");
	static ChangeObjectThread t2 = new ChangeObjectThread("t2");
	
	public static class ChangeObjectThread extends Thread{
		public ChangeObjectThread(String name) {
			super.setName(name);
		}
		@Override
		public void run() {
			synchronized (lockObject) {
				System.out.println("in " + getName());
				Thread.currentThread().suspend();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		t1.start();
		Thread.sleep(100);
		t2.start();
		t1.resume();
		t2.resume();
		t1.join();//join 当前线程等待t1运行结束
		t2.join();
	}
	
}
