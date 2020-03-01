/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package com.zero.book.zookeeper.zkclient;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.ZkConnection;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2020年3月1日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  1150310037
 * @version 1.0
 */
public class ZkClientDemo {

	public static final String ZOOKEEPER_SERVER = "111.229.3.73:2180,111.229.3.73:2181,111.229.3.73:2182";
	
	public static final int SESSION_OUTTIME = 5000;
	
	public static void main(String[] args) {
		ZkClient zkClient = new ZkClient(new ZkConnection(ZOOKEEPER_SERVER), 10000);
		
		zkClient.createEphemeral("/temp");
		zkClient.createPersistent("/base/c1/c2", true);
		
		zkClient.close();
	}
	
}
