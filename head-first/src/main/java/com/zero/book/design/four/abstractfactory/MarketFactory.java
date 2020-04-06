/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.zero.book.design.four.abstractfactory;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2020年4月6日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  1150310037
 * @version 1.0
 */
public class MarketFactory extends AbstractFactory {

	/**
	 * <p>TODO .</p>
	 * <p>时间 : 2020年4月6日</p>
	 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
	 * @author  1150310037
	 * @version 1.0
	 * @return
	 * @see com.zero.book.design.four.abstractfactory.AbstractFactory#createVehicle()
	 */
	@Override
	public Vehicle createVehicle() {
		return new Car();
	}

	/**
	 * <p>TODO .</p>
	 * <p>时间 : 2020年4月6日</p>
	 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
	 * @author  1150310037
	 * @version 1.0
	 * @return
	 * @see com.zero.book.design.four.abstractfactory.AbstractFactory#createFood()
	 */
	@Override
	public Food createFood() {
		return new Turkey();
	}

	/**
	 * <p>TODO .</p>
	 * <p>时间 : 2020年4月6日</p>
	 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
	 * @author  1150310037
	 * @version 1.0
	 * @return
	 * @see com.zero.book.design.four.abstractfactory.AbstractFactory#createWeapon()
	 */
	@Override
	public Weapon createWeapon() {
		return new AK47();
	}


}
