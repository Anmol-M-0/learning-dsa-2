package com.app.clients.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomic {
	public static void main(String[] args) {
		AtomicInteger atomicInteger = new AtomicInteger(0);
		System.out.println(atomicInteger.incrementAndGet());
		
	}
}
