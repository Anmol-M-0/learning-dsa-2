package com.app.clients.atomic;





class Utils {
	synchronized void test()
	{
		System.out.println("entered test "+Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		System.out.println("exited test "+Thread.currentThread().getName());
	}
synchronized void testMe()
	{
		System.out.println("entered testMe "+Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		System.out.println("exited test "+Thread.currentThread().getName());
	}
public static void main(String[] args) throws Exception {
		final Utils u1 = new Utils();
		Runnable r1 = new Runnable() {
			@Override
			public void run() { while (true) 
u1.test(); }
		};
		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				while (true)
					u1.testMe();
  		}
		};
		Thread t1 = new Thread(r1, "t1");
		Thread t2 = new Thread(r2, "t2");
		t1.start();
		t2.start();
     }
}
