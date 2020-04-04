/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.zero.book.design.nine.deprecated;

import java.util.ArrayList;

import com.zero.book.design.nine.common.MenuItem;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2020年4月4日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  1150310037
 * @version 1.0
 */
public class WaitressV0 {

	PancakeHouseMenu pancakeHouseMenu;
	DinerMenu dinerMenu;
	
	public WaitressV0(PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu) {
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
	}
	
	public void printMenu() {
		ArrayList<MenuItem> breakfastMenu = pancakeHouseMenu.getMenuItems();
		MenuItem[] lunchMenu = dinerMenu.getMenuItems();
		
		for (int i = 0; i < breakfastMenu.size(); i++) {
			MenuItem item = breakfastMenu.get(i);
			System.out.println(item.getName() + " ");
			System.out.println(item.getPrice() + " ");
			System.out.println(item.getDescription());
		}
		
		for (int i = 0; i < lunchMenu.length; i++) {
			MenuItem item = lunchMenu[i];
			System.out.println(item.getName() + " ");
			System.out.println(item.getPrice() + " ");
			System.out.println(item.getDescription());
		}
	}
}
