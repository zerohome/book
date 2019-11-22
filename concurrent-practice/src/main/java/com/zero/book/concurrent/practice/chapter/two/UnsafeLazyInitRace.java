/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.zero.book.concurrent.practice.chapter.two;

import com.zero.book.concurrent.practice.annotation.NotThreadSafe;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2019年11月22日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  zhangjj25968
 * @version 1.0
 */
@NotThreadSafe
public class UnsafeLazyInitRace {
	private static UnsafeLazyInitRace instance = null;

	private UnsafeLazyInitRace() {

	}

	public static UnsafeLazyInitRace getInstance() {
		/*
		 * 	 先检查后执行的竞态条件
		 */
		if (instance == null) {
			instance = new UnsafeLazyInitRace();
		}
		return instance;
	}
}
