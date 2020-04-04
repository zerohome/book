/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.zero.book.design.nine.iterator;

import java.util.ArrayList;

import com.zero.book.design.nine.common.MenuItem;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2020年4月4日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  1150310037
 * @version 1.0
 */
public class WaitressV1 {

	PancakeHouseMenu pancakeHouseMenu;
	DinerMenu dinerMenu;
	
	public WaitressV1(PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu) {
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
	}
	
	public void printMenu() {
		Iterator pancakeIterator = pancakeHouseMenu.createIterator();
		Iterator dinerIterator = dinerMenu.createIterator();
		System.out.println("MENU\n---\nBREAKFAST");
		printMenu(pancakeIterator);
		System.out.println("\nLUNCH");
		printMenu(dinerIterator);
	}

	/**
	 * <p>TODO .</p>
	 * <p>时间 : 2020年4月4日</p>
	 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
	 * @author  zhangjj25968
	 * @version 1.0
	 * @param pancakeIterator
	 */
	private void printMenu(Iterator iterator) {
		while (iterator.hasNext()) {
			MenuItem item = iterator.next();
			System.out.println(item.getName() + " ");
			System.out.println(item.getPrice() + " ");
			System.out.println(item.getDescription());
		}
	}
}
