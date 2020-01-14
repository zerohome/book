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
public class Tea {

	void prepareRecipe() {
		boilWater();
		steepTeaBag();
		pourInCup();
		addLemon();
	}
	
	public void boilWater() {
		System.out.println("Boiling water");
	}
	
	public void steepTeaBag() {
		System.out.println("Steeping the tea");
	}
	
	public void pourInCup() {
		System.out.println("Pouring into cup");
	}
	
	public void addLemon() {
		System.out.println("Adding Lemon");
	}
}
