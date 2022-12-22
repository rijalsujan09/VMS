package voting_Management_System;

import java.util.Scanner;

public class Login_Work {
	static Scanner scan = new Scanner(System.in);

	public static void login() {
		while (true) {
			System.out.println("Authorization ID : ");
			String a_id = scan.nextLine();

			System.out.println("Authorization Pass :  ");
			String a_pass = scan.nextLine();

			if ((a_id.equals("1")) && (a_pass.equals("1"))) {

				System.out.print("\t\t--*--Authorization Sucessfull--*--\nNow Begin : \n\n");
				break;
			} else {
				System.out.println("\t\t--*--Authorization Unsucessfull ! Try AGAIN--*--\n");
				continue;
			}

		}

	}
//---------------------------------------------------------------------------------------------------------------------------------
	public static void stopVotingProgramme() {
		Scanner scan = new Scanner(System.in);
		System.out.println("\n\t\tVoting Completed ! Authorize to stop:");
		System.out.println("\n[Enter Authoization Code] : ");
		while(true){
		String Id = scan.next();
		if ((Id.equals("1"))) {
			
			System.out.println("\n\t\t--*--Voting Stoped ! Now Begin count--*--");
			
			
			
			break;
		} else {
			System.out.println("\n\t\t--*--Authorization Faild ! Try again\n--*--");
			continue;
		}
		}
	}
}
