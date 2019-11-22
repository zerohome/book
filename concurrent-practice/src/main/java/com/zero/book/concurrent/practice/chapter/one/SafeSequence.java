/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.zero.book.concurrent.practice.chapter.one;

import com.zero.book.concurrent.practice.annotation.ThreadSafe;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2019年11月22日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  zhangjj25968
 * @version 1.0
 */
@ThreadSafe
public class SafeSequence {

	private static int sequence;

	/*
	 * 	 加锁
	 */
	public synchronized static int getSequence() {
		return sequence++;
	}
	
}
