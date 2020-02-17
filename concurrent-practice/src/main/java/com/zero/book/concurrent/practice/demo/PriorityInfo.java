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
public class PriorityInfo {

	public static class HighPriority extends Thread{
		public HighPriority(String name) {
			super.setName(name);
		}
		static int count = 0;
		@Override
		public void run() {
			while(true) {
				synchronized (PriorityInfo.class) {
					count++;
					if (count > 100000000) {
						System.out.println("HighPriority is completed");
						break;
					}
				}
			}
		}
	}
	
	public static class LowPriority extends Thread{
		public LowPriority(String name) {
			super.setName(name);
		}
		static int count = 0;
		@Override
		public void run() {
			while(true) {
				synchronized (PriorityInfo.class) {
					count++;
					if (count > 100000000) {
						System.out.println("LowPriority is completed");
						break;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Thread high = new HighPriority("High");
		Thread low = new LowPriority("Low");
		high.setPriority(Thread.MAX_PRIORITY);
		low.setPriority(Thread.MIN_PRIORITY);
		low.start();
		high.start();
	}
}
