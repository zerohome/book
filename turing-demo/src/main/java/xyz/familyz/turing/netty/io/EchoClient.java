/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package xyz.familyz.turing.netty.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import xyz.familyz.turing.CommonPool;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2020年4月23日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  1150310037
 * @version 1.0
 */
public class EchoClient {

	public static void main(String[] args) {
		Socket echoSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		
		try {
			echoSocket = new Socket(CommonPool.IP, CommonPool.PORT);
			out = new PrintWriter(echoSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
			System.out.println("连接服务器...");
			System.out.println("输入【quit】断开与服务器的连接：");
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			String command;
			while((command = stdIn.readLine()) != null) {
				out.println(command);
				System.out.println(in.readLine());
				if (CommonPool.QUIT.equalsIgnoreCase(command)) {
					System.out.println("关闭...");
					out.close();
					in.close();
					stdIn.close();
					echoSocket.close();
					System.exit(0);
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
