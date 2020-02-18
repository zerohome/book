/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.zero.book.concurrent.practice.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <p>读写锁 .</p>
 * <p>时间 ： 2020年2月18日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  1150310037
 * @version 1.0
 */
public class ReadWriteLockDemo implements Runnable{

	static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	static final Lock readLock = readWriteLock.readLock();
	static final Lock writeLock = readWriteLock.writeLock();
	static AtomicInteger count = new AtomicInteger(0);
	@Override
	public void run() {
		try {
			readLock.lock();
			System.out.println(Thread.currentThread().getId() + " get read lock");
			readLock.unlock();
			System.out.println(Thread.currentThread().getId() + " release read lock");
			if (5 == count.incrementAndGet()) {
				System.out.println("--------------------------");
				System.out.println(Thread.currentThread().getId() + " get write lock");
				writeLock.lock();
				Thread.sleep(3000);
				writeLock.unlock();
				System.out.println(Thread.currentThread().getId() + " release write lock");
				System.out.println("--------------------------");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
//			System.out.println(Thread.currentThread().getId() + " release read lock");
//			readLock.unlock();
		}
	}

	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(20);
		ReadWriteLockDemo task = new ReadWriteLockDemo();
		for (int i = 0; i < 6; i++) {
			exec.submit(task);
		}
	}
}
