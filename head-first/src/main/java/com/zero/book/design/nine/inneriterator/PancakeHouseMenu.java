/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.zero.book.design.nine.inneriterator;

import java.util.ArrayList;
import java.util.Iterator;

import com.zero.book.design.nine.common.MenuItem;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2020年4月4日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  1150310037
 * @version 1.0
 */
public class PancakeHouseMenu  {
	ArrayList<MenuItem> menuItems;
 
	public PancakeHouseMenu() {
		menuItems = new ArrayList<MenuItem>();
    
		addItem("K&B's Pancake Breakfast", 
			"Pancakes with scrambled eggs, and toast", 
			true,
			2.99);
 
		addItem("Regular Pancake Breakfast", 
			"Pancakes with fried eggs, sausage", 
			false,
			2.99);
 
		addItem("Blueberry Pancakes",
			"Pancakes made with fresh blueberries",
			true,
			3.49);
 
		addItem("Waffles",
			"Waffles, with your choice of blueberries or strawberries",
			true,
			3.59);
	}

	public void addItem(String name, String description,
	                    boolean vegetarian, double price)
	{
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		menuItems.add(menuItem);
	}
 
	/**
	 * <p>TODO .</p>
	 * <p>时间 : 2020年4月4日</p>
	 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
	 * @author  zhangjj25968
	 * @version 1.0
	 * @return
	 */
	@Deprecated
	public ArrayList<MenuItem> getMenuItems() {
		return menuItems;
	}
  
	public Iterator createIterator() {
		return menuItems.iterator();
	}
  
	public String toString() {
		return "Objectville Pancake House Menu";
	}

	// other menu methods here
}
