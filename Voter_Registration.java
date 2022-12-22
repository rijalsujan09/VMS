package voting_Management_System;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Voter_Registration {

	static Scanner scan = new Scanner(System.in);

	public static void registrationVoter() {

		System.out.println("\t\t1. Voter Registration\n");
		// first Name
		System.out.println("Enter first name : ");
		String firstName = scan.next();
		// last Name
		System.out.println("Enter last name : ");
		String lastName = scan.next();

		Gender g = null;
		while (true) {
			System.out.println("\n[Chose Your Gender] : 1.Male\t 2.Female\t 3.Others");
			int genderChoice = scan.nextInt();
			if (genderChoice == 1) {
				g = Gender.MALE;
			} else if (genderChoice == 2) {
				g = Gender.FEMALE;
			} else if (genderChoice == 3) {
				g = Gender.OTHERS;
			} else {
				System.out.println("\t\t--*--Invalid option--*--\n");
				continue;
			}
			break;
		}
		System.out.println("Enter your Date of Birth : [yyyy-mm-dd]");
		LocalDate dateofbirth = null;
		String dateofbirth1 = scan.next();
		dateofbirth = LocalDate.parse(dateofbirth1, DateTimeFormatter.ISO_LOCAL_DATE);
		
		
		String username = null;
		while (true) {
			System.out.println("\nEnter username : ");
			username = scan.next();
			
			//fix needed
	
			VoterServices vs = new VoterServices();
			if (vs.checkIfUserNameExists(username)) {
				System.out.println("\t\t--*--User_Name Taken ! Try Different--*--");
				continue;
			}
			break;
		}
		

		System.out.println("\nEnter password : ");
		String password = scan.next();

		// Insert Voter_ID
		System.out.println("Create Voter_ID : ");
		int Voter_ID = scan.nextInt();
		

		Voter voter1 = new Voter(Voter_ID, firstName, lastName, g, dateofbirth, username, password);
		try {
			try {

				VoterServices vs = new VoterServices();
				
				vs.voterRegistration(voter1);

			} catch (SQLException e) {
				throw new RuntimeException(e);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		} catch (IOException e) {
			System.out.println("\t\t--*--Voter registration Unsucesfull ! Try Again--*--");
			e.printStackTrace();
		}

	}

}
