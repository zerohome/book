package xyz.familyz.turing.netty.nio.demo;

import xyz.familyz.turing.CommonPool;

public class NIOEchoClient {

	public static void main(String[] args) {

		int port = CommonPool.PORT;
		if (args != null && args.length > 0) {
			try {
				port = Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
			}
		}
		new Thread(new NIOEchoClientHandler(CommonPool.IP, port), "NIOEchoClient-001").start();
	}
}