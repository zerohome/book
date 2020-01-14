/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.zero.book.design.seven;

/**
 * <p>适配器模式 .</p>
 *	将一个类的接口转换成客户期望的另一个接口
 * <p>时间 ： 2020年1月14日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  1150310037
 * @version 1.0
 */
public class Adapter {

	public interface Duck {
		void quack();
		void fly();
	}
	
	class MallardDuck implements Duck{
		@Override
		public void quack() {
			System.out.println("Quack");
		}
		@Override
		public void fly() {
			System.out.println("I'm flying");
		}
	}
	
	public interface Turkey {
		void gobble();
		void fly();
	}
	
	class WildTurkey implements Turkey{
		@Override
		public void gobble() {
			System.out.println("gobble");
		}
		@Override
		public void fly() {
			System.out.println("I'm flying a short distance");
		}
	}
	
	/**
	 * <p>Turkey 适配成  Duck.</p>
	 * <p>时间 ： 2020年1月14日</p>
	 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
	 * @author  1150310037
	 * @version 1.0
	 */
	class TurkeyAdapter implements Duck{
		Turkey turkey;
		
		public TurkeyAdapter(Turkey turkey) {
			this.turkey = turkey;
		}
		@Override
		public void quack() {
			turkey.gobble();
		}
		@Override
		public void fly() {
			turkey.fly();
		}
		
	}
}
