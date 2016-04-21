package main;

import java.util.Scanner;

import NetBuddy.NetBuddy;

public class NetBuddy_Driver {

	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		Scanner lineScanner;
		String line;
		int number;
		
		try {
			while(inputScanner != null){
				System.out.println("Tell me something!");
				line = inputScanner.nextLine();
				lineScanner = new Scanner(line);
			
				if(lineScanner.hasNextInt()){
					number = lineScanner.nextInt();
					System.out.printf("The input number is: %d \n", number);
				
					if(number == 420){
						inputScanner.close();
					}
				}
				lineScanner.close();
			}
		} catch (Exception e) {
			System.err.println("EXCEPTIONSSSSS");
			System.err.println(e.getMessage());
		}
	}

}
