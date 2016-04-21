package main;

import java.util.Scanner;

import NetBuddy.NetBuddy;

public class NetBuddy_Driver {

	public static void main(String[] args) {
		NetBuddy netBud = new NetBuddy();
		Thread netThread = new Thread(netBud);
		Scanner inputScanner = new Scanner(System.in);
		Scanner lineScanner;
		String line;
		int number;
		
		try {
			netThread.start();
			while(true){
				System.out.println("Tell me something!");
				line = inputScanner.nextLine();
				lineScanner = new Scanner(line);
			
				if(lineScanner.hasNextInt()){
					number = lineScanner.nextInt();
					System.out.printf("The input number is: %d \n", number);
				
					if(number == 420){
						inputScanner.close();
						lineScanner.close();
						break;
					}
				}
				lineScanner.close();
			}
			netBud.deactivate();
			netThread.join();
		} catch (InterruptedException e) {
			System.err.println("Failed Clean Join :(");
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("EXCEPTIONSSSSS");
			System.err.println(e.getMessage());
		} 
		System.out.println("Excecution Ended");
	}

}
