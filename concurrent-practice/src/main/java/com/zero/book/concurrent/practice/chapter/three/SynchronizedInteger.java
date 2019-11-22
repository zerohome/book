/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.zero.book.concurrent.practice.chapter.three;

import com.zero.book.concurrent.practice.annotation.ThreadSafe;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2019年11月22日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  zhangjj25968
 * @version 1.0
 */
@ThreadSafe
public class SynchronizedInteger {

	private int value;

	public synchronized int getValue() {
		return value;
	}

	public synchronized void setValue(int value) {
		this.value = value;
	}
	
	
}
