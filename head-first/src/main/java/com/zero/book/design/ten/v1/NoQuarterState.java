/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.zero.book.design.ten.v1;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2020年4月4日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  1150310037
 * @version 1.0
 */
public class NoQuarterState implements State{

	GumballMachine gumballMachine;
	
	public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
	
	/**
	 * <p>TODO .</p>
	 * <p>时间 : 2020年4月4日</p>
	 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
	 * @author  zhangjj25968
	 * @version 1.0
	 * @see com.zero.book.design.ten.v1.State#insertQuarter()
	 */
	@Override
	public void insertQuarter() {
		System.out.println("You inserted a quarter");
		gumballMachine.setState(gumballMachine.getHasQuarterState());
	}

	/**
	 * <p>TODO .</p>
	 * <p>时间 : 2020年4月4日</p>
	 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
	 * @author  zhangjj25968
	 * @version 1.0
	 * @see com.zero.book.design.ten.v1.State#ejectQuarter()
	 */
	@Override
	public void ejectQuarter() {
		System.out.println("You haven't inserted a quarter");
	}

	/**
	 * <p>TODO .</p>
	 * <p>时间 : 2020年4月4日</p>
	 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
	 * @author  zhangjj25968
	 * @version 1.0
	 * @see com.zero.book.design.ten.v1.State#turnCrank()
	 */
	@Override
	public void turnCrank() {
		System.out.println("You turned, but there's no quarter");
	}

	/**
	 * <p>TODO .</p>
	 * <p>时间 : 2020年4月4日</p>
	 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
	 * @author  zhangjj25968
	 * @version 1.0
	 * @see com.zero.book.design.ten.v1.State#dispense()
	 */
	@Override
	public void dispense() {
		System.out.println("You need to pay first");
	}

	public String toString() {
		return "waiting for quarter";
	}
}
