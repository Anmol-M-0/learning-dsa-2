package com.app.clients.lists;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class StackOfStringsApp {
	public static void main(String[] args) {

		boolean exit = false;
		int key = 0;
		try (Scanner sc = new Scanner(System.in)) {
			while (!exit) {
				System.out.println("enter an option");
				key = sc.nextInt();
				switch (key) {
				case 1:
					System.out.println("add a string");
					sc.next();
					break;
				case 2:
					System.out.println("read from a file");
					try(
							Stream<String> str = Files.lines(Paths.get("c:/clutter/samples/"+sc.next()))
							){
						str.forEach(line->System.out.println(line));
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println(e);
					}
					break;
				case 100:
					exit = true;
					break;
				default:
					break;
				}
			}
		}
	}
}
