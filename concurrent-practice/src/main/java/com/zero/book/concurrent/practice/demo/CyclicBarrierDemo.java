/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.zero.book.concurrent.practice.demo;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * <p>循环栅栏 .</p>
 * <p>时间 ： 2020年2月18日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  1150310037
 * @version 1.0
 */
public class CyclicBarrierDemo {

	public static class Soldier implements Runnable{

		private String soldier;
		private CyclicBarrier cyclicBarrier;
		
		public Soldier(String soldier, CyclicBarrier cyclicBarrier) {
			this.soldier = soldier;
			this.cyclicBarrier = cyclicBarrier;
		}
		@Override
		public void run() {
			try {
				cyclicBarrier.await();
				doWork();
				cyclicBarrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
		
		private void doWork() {
			try {
				Thread.sleep(Math.abs(new Random().nextInt()%10000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(soldier + ": 任务完成！");
		}
		
	}
	
	public static class BarrierRun implements Runnable{

		boolean flag;
		int n;
		
		public BarrierRun(boolean flag, int n) {
			this.flag = flag;
			this.n = n;
		}
		
		@Override
		public void run() {
			if (flag) {
				System.out.println("司令：【士兵" + n + "个， 任务完成！】");
			}else {
				System.out.println("司令：【士兵" + n + "个， 集合完成！】");
				flag = true;
			}
		}
		
	}
	
	public static void main(String[] args) {
		final int N = 10;
		Thread[] allSoldier = new Thread[N];
		boolean flag = false;
		CyclicBarrier cyclic = new CyclicBarrier(N, new BarrierRun(flag, N));
		System.out.println("准备集合队伍");
		for (int i = 0; i < allSoldier.length; i++) {
			System.out.println("士兵" + i + "报道");
			allSoldier[i] = new Thread(new Soldier("士兵" + i, cyclic));
			allSoldier[i].start();
			if (i == 5) {
//				allSoldier[i].interrupt();
			}
		}
	}
}
