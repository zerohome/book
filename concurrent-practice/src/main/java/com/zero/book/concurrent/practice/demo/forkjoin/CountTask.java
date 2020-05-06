/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.zero.book.concurrent.practice.demo.forkjoin;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2020年2月21日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  1150310037
 * @version 1.0
 */
public class CountTask extends RecursiveTask<Long>{

	private static final int THRESHOLD = 10000;
	private long start;
	private long end;
	
	public CountTask(long start, long end) {
		this.start = start;
		this.end = end;
	}
	@Override
	protected Long compute() {
		long sum = 0;
		boolean canCompute = (end - start) < THRESHOLD;
		if (canCompute) {
			for (long i = start; i <= end; i++) {
				sum += i;
			}
		}else {
			long step = (start + end) / 100;
			ArrayList<CountTask> subTasks = new ArrayList<CountTask>();
			long pos = start;
			for (int i = 0; i < 100; i++) {
				long lastOne = pos + step;
				if (lastOne > end) {
					lastOne = end;
				}
				CountTask subTask = new CountTask(pos, lastOne);
				pos+=step+1;
				subTasks.add(subTask);
				subTask.fork();
			}
			for (CountTask t : subTasks) {
				sum += t.join();
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		CountTask task = new CountTask(0, 20000L);
		ForkJoinTask<Long> result = forkJoinPool.submit(task);
		try {
			long finalResult = result.get();
			System.out.println("sum=" + finalResult);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
}
