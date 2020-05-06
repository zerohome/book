/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package xyz.familyz.turing.netty.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import xyz.familyz.turing.CommonPool;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2020年4月23日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  1150310037
 * @version 1.0
 */
public class ThreadPoolEchoServer {

	private int port;
	
	public ThreadPoolEchoServer(int port) {
		this.port = port;
	}
	
	public void startServer() {
		ServerSocket echoServer = null;
		Executor executor = Executors.newFixedThreadPool(6);
		int i = 0;
		System.out.println("服务器在端口【" + this.port + "】等待客户请求...");
		try {
			echoServer = new ServerSocket(this.port);
			while(true) {
				Socket clientSocket = echoServer.accept();
				executor.execute(new HandleThread(clientSocket, i++));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ThreadPoolEchoServer server = new ThreadPoolEchoServer(CommonPool.PORT);
		server.startServer();
	}
}
