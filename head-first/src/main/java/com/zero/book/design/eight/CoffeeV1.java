/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.zero.book.design.eight;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2020年1月14日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  1150310037
 * @version 1.0
 */
public class CoffeeV1 extends Template{

	@Override
	protected void brew() {
		System.out.println("Dripping Coffee through filter");		
	}

	@Override
	protected void addCondiments() {
		System.out.println("Adding sugar and milk");		
	}

}
