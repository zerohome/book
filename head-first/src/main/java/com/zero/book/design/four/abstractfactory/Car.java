/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.zero.book.design.four.abstractfactory;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2020年4月6日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  1150310037
 * @version 1.0
 */
public class Car extends Vehicle {

	/**
	 * <p>TODO .</p>
	 * <p>时间 : 2020年4月6日</p>
	 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
	 * @author  1150310037
	 * @version 1.0
	 * @see com.zero.book.design.four.factorymethod.Moveable#move()
	 */
	@Override
	public void run() {
		System.out.println("汽车行驶中...");
	}

}
