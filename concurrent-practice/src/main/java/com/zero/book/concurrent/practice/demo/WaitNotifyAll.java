/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.zero.book.concurrent.practice.demo;

import com.zero.book.concurrent.practice.demo.WaitNotify.T1;
import com.zero.book.concurrent.practice.demo.WaitNotify.T2;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2020年2月17日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  1150310037
 * @version 1.0
 */
public class WaitNotifyAll {
final static Object lockObject = new Object();
	
	public static class T1 extends Thread{
		public T1(String name) {
			super.setName(name);
		}
		
		@Override
		public void run() {
			synchronized (lockObject) {
				System.out.println(System.nanoTime() + " : T1 start");
				try {
					lockObject.wait();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
				}
				System.out.println(System.nanoTime() + " : T1 end!");
			}
		}
	}
	
	public static class T2 extends Thread{
		public T2(String name) {
			super.setName(name);
		}
		
		@Override
		public void run() {
			synchronized (lockObject) {
				System.out.println(System.nanoTime() + " : T2 start！Notify all threads");
				lockObject.notifyAll();
				System.out.println(System.nanoTime() + " : T2 end");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					
				}
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread wait = new T1("Wait");
		Thread wait2 = new T1("Wait2");
		wait.start();
		wait2.start();
		Thread.sleep(1000);
		Thread notify = new T2("Notify");
		notify.start();
	}
}
