/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.zero.book.mq.activemq.broker;

import org.apache.activemq.broker.BrokerService;

import com.zero.book.mq.activemq.common.CommonPool;

/**
 * <p>内嵌消息队列启动，不用去activemq启动 .</p>
 * <p>时间 ： 2020年2月27日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  1150310037
 * @version 1.0
 */
public class InnerBroker {
	public static void main(String[] args) throws Exception {
		BrokerService broker = new BrokerService();
		broker.setUseJmx(CommonPool.TRUE);
		broker.addConnector(CommonPool.ACTIVE_MQ_SERVICE_CENTER);
		broker.start();
	}
}
