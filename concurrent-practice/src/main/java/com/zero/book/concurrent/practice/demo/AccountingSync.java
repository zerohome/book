/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.zero.book.concurrent.practice.demo;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2020年2月17日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  1150310037
 * @version 1.0
 */
public class AccountingSync implements Runnable{
	static AccountingSync instance = new AccountingSync();
	static int count = 0;
	@Override
	public void run() {
		for (int i = 0; i < 10000000; i++) {
			synchronized (instance) {
				count++;
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(instance);
		Thread t2 = new Thread(instance);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(count);
	}
	
}
