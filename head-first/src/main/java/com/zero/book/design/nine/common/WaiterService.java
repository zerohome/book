/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.zero.book.design.nine.common;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2020年4月4日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  1150310037
 * @version 1.0
 */
public interface WaiterService {
	default void printMenu() {
		
	};
	
	default void printBreakfastMenu() {
		
	};
	
	default void printLunchMenu() {
		
	};
	
	default void printVegetatianMenu() {
		
	};
	
	default boolean isItemVegetarian(String name) {
		return true;
	};
}
