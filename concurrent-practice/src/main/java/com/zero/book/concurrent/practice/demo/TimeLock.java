/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.zero.book.concurrent.practice.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import com.zero.book.concurrent.practice.demo.PriorityInfo.LowPriority;

/**
 * <p>限时获取锁 .</p>
 * <p>时间 ： 2020年2月17日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  1150310037
 * @version 1.0
 */
public class TimeLock implements Runnable{

	public static ReentrantLock lock = new ReentrantLock();
	
	@Override
	public void run() {
		try {
			if (lock.tryLock(5, TimeUnit.SECONDS)) {
				Thread.sleep(6000);
			}else {
				System.out.println("获取锁超时");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (lock.isHeldByCurrentThread()) {
				lock.unlock();
			}
		}
	}
	
	public static void main(String[] args) {
		TimeLock lock = new TimeLock();
		Thread t1 = new Thread(lock);
		Thread t2 = new Thread(lock);
		t1.start();
		t2.start();
	}

}
