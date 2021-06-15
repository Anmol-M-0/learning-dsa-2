package com.app.clients.atomic;

import java.util.Scanner;

public class SingleThread {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("enter the counter count to perform");
			int count = sc.nextInt();
			int counter = 0;
			while (counter < count)
				counter++;
			System.out.println(counter);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
