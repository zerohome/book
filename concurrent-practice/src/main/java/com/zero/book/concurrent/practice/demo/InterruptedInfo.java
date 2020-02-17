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
public class InterruptedInfo implements Runnable{

	/**
	 * <p>TODO .</p>
	 * <p>时间 : 2020年2月16日</p>
	 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
	 * @author  zhangjj25968
	 * @version 1.0
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while(true) {
			if (Thread.currentThread().isInterrupted()) {//①
				System.out.println("Interrupted");
				break;
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("Interrupted When Sleep");
				//设置中断状态，抛出异常后会清除中断标记位，所以自己再次中断自己以便①处检测到
				Thread.currentThread().interrupt();
			}
		}
	}
	
}
