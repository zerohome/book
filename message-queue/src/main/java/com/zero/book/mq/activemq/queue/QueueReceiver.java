/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.zero.book.mq.activemq.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * <p>消息队列接收器 .</p>
 * <p>时间 ： 2020年2月26日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  1150310037
 * @version 1.0
 */
public class QueueReceiver {
	
	private static final String ACTIVE_MQ_SERVICE_CENTER = "tcp://www.familyz.xyz:61616";
	private static final String ACTIVE_MQ_QUEUE_NAME = "Familyz-queue";
	private static final int ACTIVE_MQ_RECEIVE_TIMES = 3;
	
	public static void main(String[] args) throws Exception {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ACTIVE_MQ_SERVICE_CENTER);
		Connection connection = connectionFactory.createConnection();
		connection.start();
		
		Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue(ACTIVE_MQ_QUEUE_NAME);
		
		MessageConsumer consumer = session.createConsumer(destination);
		for (int i = 0; i < ACTIVE_MQ_RECEIVE_TIMES; i++) {
			TextMessage message = (TextMessage) consumer.receive();
			session.commit();
			System.out.println("收到消息：" + message.getText());
		}
		session.close();
		connection.close();
	}
}
