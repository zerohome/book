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
public class Test {

	public static void main(String[] args) {
		AbstractFactory factory = new MarketFactory();
		Vehicle vehicle = factory.createVehicle();
		vehicle.run();
		
		Food food = factory.createFood();
		food.printName();
		
		Weapon weapon = factory.createWeapon();
		weapon.shoot();
	}
}
