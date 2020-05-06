/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package xyz.familyz.turing.netty.nio.buffer;

import java.nio.ByteBuffer;

import xyz.familyz.turing.CommonPool;

/**
 * <p>TODO .</p>
 * <p>时间 ： 2020年4月27日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  1150310037
 * @version 1.0
 */
public class BufferAccess {

	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(CommonPool.CAPACITY);
		printBuffer(buffer);
		
		buffer.put((byte) 'H').put((byte)'e').put((byte)'l').put((byte)'l').put((byte)'0');
		printBuffer(buffer);
		
		buffer.flip();
		printBuffer(buffer);
		
		// 取buffer
		System.out.println("" + (char) buffer.get() + (char) buffer.get());
		printBuffer(buffer);
		
		buffer.mark();
		printBuffer(buffer);
		
		//读取两个元素后，恢复到之前mark的位置处
		System.out.println("" + (char) buffer.get() + (char) buffer.get());
		printBuffer(buffer);
		
		buffer.reset();
//		buffer.rewind();
		printBuffer(buffer);
		
		buffer.compact();
		printBuffer(buffer);
		
		buffer.clear();
		printBuffer(buffer);
	}

	private static void printBuffer(ByteBuffer buffer) {
		System.out.println("[limit=" + buffer.limit() 
			+ ", position=" + buffer.position()
			+ ", capacity=" + buffer.capacity()
			+ ", array=" + buffer.toString() + "]");
	}
}
