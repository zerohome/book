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
public class Daemon {

	public static volatile int count = 0;
	public static class DaemonThread extends Thread{
		public DaemonThread(String name) {
			super.setName(name);
		}
		@Override
		public void run() {
			while(true) {
				System.out.println("I am alive");
				if (count++ == 10) {
					break;
				}
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Thread t = new DaemonThread("Daemon");
//		t.setDaemon(true);
		t.start();
	}
}
