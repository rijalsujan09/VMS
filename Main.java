package voting_Management_System;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args)
			throws IOException, SQLException, ClassNotFoundException, InterruptedException {

		// heading work
		Heading_Work.getheading();

		// Calling function for Login Work
		Login_Work.login();

		// Initialize service and utilities
		Scanner scan = new Scanner(System.in);

		VoterServices voterServices = new VoterServices();
		Voter voter = null;

		int choice = 0;

		while (true) {

			System.out.println("\t\t1. Voter Registration");
			System.out.println("\t\t2. View Voter List ");
			System.out.println("\t\t3. View Candidates");
			System.out.println("\t\t4. Start Voting");
			System.out.println("\t\t5. Stop Voting");
			System.out.println("\t\t6. Logout");
			System.out.println("\nEnter your choice :");

			choice = scan.nextInt();

			// Registration Work--------------------------------------
			if (choice == 1) {
				
				Voter_Registration.registrationVoter();
			}

			// View votters----------------------------------------
			else if (choice == 2) {
				View_Votera.viewVoters();

				// View Candidates ----------------------------------------
			} else if (choice == 3) {
				// view candidates
				View_Candidate.viewCandidate();

			} else if (choice == 4) {
				// Voting process
				System.out.println("\n\n\t\t\t\t\t\t Welcome to Voting Programme \n"
						+ "\n\t\t\t\t Please Enter your user name and password for start voting\n"
						+ "\t\t\t\t===========================================================\n");

				System.out.println("Enter your username : ");
				String User_Name = scan.next();
				System.out.println("Enter your password : ");
				String Password = scan.next();
				
				// validation check
				

				voter = VoterServices.votingProcess(User_Name, Password);

				if (voter != null) {
					System.out.println("\n\t\t--*--Matched ! Begin Process--*--\n");
				} else {
					System.out.println(
							"\n\t\t--*--You are not registered in voter list--*--\n\t\t--*--Or make sure you Enter Corect User_Name and Password--*-\n\n");

					continue;
				}

//				voterServices.candidatesList();
				System.out.println("Enter your voter Id : ");
				int voter_Id = scan.nextInt();
				
				View_Candidate.viewCandidate();

				System.out.println("\n\t\t--*--Enter a party_ID to caste a vote--*--\n");
				System.out.println("[Enter]:");
				int Party_ID = scan.nextInt();
				voterServices.doVoteNow(voter_Id, User_Name, Party_ID);

			} else if (choice == 5) {
				// from login service
				Login_Work.stopVotingProgramme();
				
				System.out.println("Final Vote count of Election 2023  is Finished ");
				// method is in voterservice data is in voterecorddb class
				voterServices.finalResult();
				
				
			} else if (choice == 6) {
				// Logout
				System.out.println("GOOD BYE!!!!");
				break;
			} else {
				System.out.println("Invalid Choice.");
			}
		}

	}
}
