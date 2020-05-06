package xyz.familyz.turing.netty.nio.demo;

import java.io.IOException;

import xyz.familyz.turing.CommonPool;

public class NIOEchoServer {

	public static void main(String[] args) throws IOException {
		int port = CommonPool.PORT;
		if (args != null && args.length > 0) {
			try {
				port = Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
				// 采用默认值
			}
		}
		EchoHandler timeServer = new EchoHandler(port);
		new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
	}
}