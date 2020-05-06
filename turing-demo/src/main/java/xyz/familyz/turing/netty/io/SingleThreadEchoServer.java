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

import xyz.familyz.turing.CommonPool;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2020年4月23日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  1150310037
 * @version 1.0
 */
public class SingleThreadEchoServer {

	private int port;
	
	public SingleThreadEchoServer(int port) {
		this.port = port;
	}
	
	public void startServer() {
		ServerSocket echoServer = null;
		int i = 0;
		System.out.println("服务器在端口【" + this.port + "】等待客户请求...");
		try {
			echoServer = new ServerSocket(this.port);
			while(true) {
				Socket clientRequest = echoServer.accept();
				handleRequest(clientRequest, i++);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * <p>接收客户请求，进行响应 .</p>
	 * <p>时间 : 2020年4月23日</p>
	 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
	 * @author  1150310037
	 * @version 1.0
	 * @param clientRequest
	 * @param i
	 */
	private void handleRequest(Socket clientSocket, int clientNo) {
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
	
	public static void main(String[] args) {
		SingleThreadEchoServer server = new SingleThreadEchoServer(CommonPool.PORT);
		server.startServer();
	}
}
