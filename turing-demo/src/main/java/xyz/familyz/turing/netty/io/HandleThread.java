/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package xyz.familyz.turing.netty.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import xyz.familyz.turing.CommonPool;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2020年4月23日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  1150310037
 * @version 1.0
 */
public class HandleThread implements Runnable{

	private Socket clientSocket;
	
	private int clientNo;
	
	public HandleThread(Socket clientSocket, int clientNo) {
		this.clientSocket = clientSocket;
		this.clientNo = clientNo;
	}
	
	public void run() {
		PrintStream os = null;
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			os = new PrintStream(clientSocket.getOutputStream());
			String inputLine = null;
			while((inputLine = in.readLine())!=null) {
				if (CommonPool.QUIT.equalsIgnoreCase(inputLine)) {
					System.out.println("关闭与客户端【" + clientNo + "】连接...");
					os.close();
					in.close();
					clientSocket.close();
					break;
				}else {
					System.out.println("来自客户端【" + clientNo + "】的请求:" + inputLine);
					os.println("来自服务的响应：" + inputLine);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
