/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.zero.book.concurrent.practice.demo;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * <p>死锁检测 .</p>
 * <p>时间 ： 2020年2月17日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  1150310037
 * @version 1.0
 */
public class DeadLockChecker {

	private static final ThreadMXBean mbean = ManagementFactory.getThreadMXBean();
	
	static final Runnable deadLockCheck = new Runnable() {
		
		@Override
		public void run() {
			while(true) {
				long[] deadlockedThreadIds = mbean.findDeadlockedThreads();
				if (null != deadlockedThreadIds) {
					ThreadInfo[] threadInfos = mbean.getThreadInfo(deadlockedThreadIds);
					for (Thread t : Thread.getAllStackTraces().keySet()) {
						for (int i = 0; i < threadInfos.length; i++) {
							if (t.getId() == threadInfos[i].getThreadId()) {
								t.interrupt();
							}
						}
					}
				}
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {

				}
			}
		}
	};
	
	public static void check() {
		Thread t = new Thread(deadLockCheck);
		t.setDaemon(true);
		t.start();	
	}
}
