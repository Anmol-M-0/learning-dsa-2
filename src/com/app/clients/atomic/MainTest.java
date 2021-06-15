package com.app.clients.atomic;

import java.util.LinkedList;
import java.util.List;

public class MainTest implements IInt{
	static int a;
	static Animals b;
	public static void main(String[] args) {
		int a = 75;
		class Met{
			public Met() {
				System.out.println(a);
			}
		}
		new Met();
		
	}

	public static void test(String e) {
		final int i = 2;
		System.out.println("in string"+i + e);
	}

	public static void test(Integer e) {
		System.out.println("in Integer");
	}
	static void testMe(int i1,int i2) throws Exception
	 {
	    System.out.println("Result "+(i1/i2));  // 2
	    Thread.sleep(100); // 3
	    System.out.println("Method over..");
	 }

}


