/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.zero.book.design.four.factorymethod;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2020年4月6日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  1150310037
 * @version 1.0
 */
public class Test {

	public static void main(String[] args) {
		Bike bike = new Bike();
		bike.move();
		
		Vehicle vahicle = new Car();
		vahicle.move();
		vahicle = new Plane();
		vahicle.move();
		
		Vehicle plane = new PlaneFactory().createPlane();
		plane.move();
		
		VahicleFactory vahicleFactory = new CarFactory();
		Vehicle car = vahicleFactory.createVahicle();
		car.move();
	}
}
