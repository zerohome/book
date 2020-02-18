/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.zero.book.concurrent.practice.demo;

import java.util.concurrent.locks.ReentrantLock;

import com.zero.book.concurrent.practice.demo.PriorityInfo.LowPriority;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2020年2月17日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  1150310037
 * @version 1.0
 */
public class ReentrantLockDemo implements Runnable{

	public static ReentrantLock lock = new ReentrantLock();
	public static int count;
	@Override
	public void run() {
		for (int i = 0; i < 10000000; i++) {
			lock.lock();
//			lock.lock();//重入
			try {
				count++;
			} finally {
				lock.unlock();
//				lock.unlock();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ReentrantLockDemo tl = new ReentrantLockDemo();
		Thread t1 = new Thread(tl);
		Thread t2 = new Thread(tl);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(count);
		
	}
}
