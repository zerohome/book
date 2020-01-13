/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.zero.book.design;

/**
 * <p>单例模式 .</p>
 * <p>时间 ： 2020年1月13日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  1150310037
 * @version 1.0
 */
public class Singleton {
	
	private volatile static Singleton uniqueInstance;
	
	private Singleton(){
		
	}
	
	public static Singleton getInstance() {
		if (null == uniqueInstance) {
			synchronized (Singleton.class) {
				if (null == uniqueInstance) {
					uniqueInstance = new Singleton();
				}
			}
		}
		return uniqueInstance;
	}
}
