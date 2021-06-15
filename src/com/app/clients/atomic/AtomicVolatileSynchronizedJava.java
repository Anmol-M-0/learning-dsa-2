package com.app.clients.atomic;

import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVolatileSynchronizedJava {
	public static void main(String args[]) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("please enter the *number of threads* ,\nand *counter count* to test the task");
			new RunTask(sc.nextInt(), sc.nextInt());
		} catch (Exception e) {
			e.printStackTrace();
		}
		float[] a = {1, 2};
//		throw new NullPointerException();
	}

	private static class RunTask {

		RunTask(int threadCount, int counterCount) {
			final IntegerCounter counter = new IntegerCounter();
			final CyclicBarrier startingBarrier = new CyclicBarrier(threadCount);
			final CyclicBarrier endingBarrier = new CyclicBarrier(threadCount + 1);
			Runnable task = () -> {

				try {
					startingBarrier.await();
					int count = 0;
					for (int i = 0; i < counterCount/threadCount; i++) {
						count = counter.getCount();
//						if (count >= counterCount)
//							break;
					}
					endingBarrier.await();
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				} catch (BrokenBarrierException ex) {
					ex.printStackTrace();
				}

			};

			for (int i = 0; i < threadCount; i++)// lol, wont work
				new Thread(task).start();
			try {
				endingBarrier.await();
				System.out.println("Expected count : "+ counterCount+1 + " Actual count : " + counter.getCount());
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			} catch (BrokenBarrierException ex) {
				ex.printStackTrace();
			}
		}

	}
	private static class IntegerCounter{
//		private int count = 1;
		private AtomicInteger count = new AtomicInteger(0);
		public  int getCount() {
			return count.incrementAndGet();
		}
	}
}
