/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.zero.book.design.nine.composite;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2020年4月4日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  1150310037
 * @version 1.0
 */
public interface MenuComponent {
	default public void add(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}

	default public void remove(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}

	default public MenuComponent getChild(int i) {
		throw new UnsupportedOperationException();
	}

	default public String getName() {
		throw new UnsupportedOperationException();
	}

	default public String getDescription() {
		throw new UnsupportedOperationException();
	}

	default public double getPrice() {
		throw new UnsupportedOperationException();
	}

	default public boolean isVegetarian() {
		throw new UnsupportedOperationException();
	}

	default public void print() {
		throw new UnsupportedOperationException();
	}
}
