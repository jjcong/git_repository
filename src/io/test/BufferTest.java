package io.test;

import java.nio.CharBuffer;
/**
 * @author j_cong
 * @date 2017年10月3日
 * @describe NIO中的Buffer测试，position，limit，capacity
 * @version V1.0.0
 */
public class BufferTest {

	public static void main(String[] args) {
		
		CharBuffer buff = CharBuffer.allocate(8);
		buff.append('1');
		buff.append('2');
		buff.append('3');
		buff.append('4');

		//将数据刷新到缓存CharBuffer中
		buff.flip();

		System.out.println(buff.capacity());
		System.out.println(buff.limit());
		System.out.println(buff.position());
	}
}
