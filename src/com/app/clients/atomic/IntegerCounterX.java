package com.app.clients.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/** * A counter, which should return different count each time */
public class IntegerCounterX{
//	private int count = 1;
	private AtomicInteger count = new AtomicInteger(0);
	public  int getCount() {
		return count.incrementAndGet();
	}
}
