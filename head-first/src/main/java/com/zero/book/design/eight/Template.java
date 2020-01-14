/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.zero.book.design.eight;

/**
 * <p>模板方法模式 .</p>
 * 模板方法定义了一个算法的步骤，并允许子类为一个或多个步骤提供实现
 * <p>时间 ： 2020年1月14日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  1150310037
 * @version 1.0
 */
public abstract class Template {
	
	final void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		addCondiments();
	}
	
	protected abstract void brew();

	protected abstract void addCondiments();

	void boilWater() {
		System.out.println("Boiling water");
	}
	
	void pourInCup() {
		System.out.println("Pouring into cup");
	}
}
