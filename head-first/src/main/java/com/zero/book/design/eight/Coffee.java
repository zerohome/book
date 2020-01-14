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
public class Coffee {

	void prepareRecipe() {
		boilWater();
		brewCoffeeGrinds();
		pourInCup();
		addSugarAndMilk();
	}
	
	public void boilWater() {
		System.out.println("Boiling water");
	}
	
	public void brewCoffeeGrinds() {
		System.out.println("Dripping Coffee through filter");
	}
	
	public void pourInCup() {
		System.out.println("Pouring into cup");
	}
	
	public void addSugarAndMilk() {
		System.out.println("Adding sugar and milk");
	}
}

