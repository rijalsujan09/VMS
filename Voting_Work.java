package voting_Management_System;

import java.util.Scanner;

public class Voting_Work {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void startVoting() {
		System.out.println("\n\n\t\t\t--*--Welcome to Voting Programme--*--\n"
				+ "\n\t\t Please Enter your user name and password for start voting\n\n\t\t");
		//Validation
		System.out.println("Enter your username::");
		String User_Name = scan.next();
		System.out.println("Enter your password");
		String Password = scan.next();
	}

}
