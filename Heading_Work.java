package voting_Management_System;

import java.util.Scanner;

public class Heading_Work {

	public static void getheading() throws InterruptedException {

		Scanner scan = new Scanner(System.in);

		String abc[] = { "\n\t\t\t\t\t", "W", "E", "L", "C", "O", "M", "E", "   ", "T", "O", "   ", "E", "L", "E", "C",
				"T", "I", "O", "N", "    ", "2", "0", "2", "2", "\n" };
		String zxc = "\t\t\t\t\t===============================";
		for (String efg : abc) {
			System.out.print(efg);
			Thread.sleep(100);
		}

		System.out.println(zxc);

		System.out.println("ENTER:");
		String enter = scan.nextLine();
		
	}

}
