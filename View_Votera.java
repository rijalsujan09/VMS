package voting_Management_System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class View_Votera {
	public static String USER = "root";

	public static String PAS = "Nunarijal12#";

	public static String URL = "jdbc:mysql://localhost:3306/MyDatabase";

	public static void viewVoters() {

		try {
			// Class.forName("com.mysql.jdbc.Driver");
			Connection connect = DriverManager.getConnection(URL, USER, PAS);
			// Create a statement object
			Statement stmt = connect.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM MyDatabase." + "VoterList;");

//			---------------------------------------------------------------------------------

			while (rs.next()) {
				int Voter_ID = rs.getInt(1);
				String First_Name = rs.getString(2);
				String Last_Name = rs.getString(3);
				String Gender = rs.getString(4);
				String DOB = rs.getString(5);
				String User_Name = rs.getString(6);
				// String Password = rs.getString(6);

				System.out.println("\t\t-------------------------------------\n" + "\t\tName : " + First_Name + " " + Last_Name + "\n\t\t" + "Gender : " + Gender
						+ "\t" + "DOB : " + DOB + "\n\t\t" + "User_Name : " + User_Name +"\n\t\t-------------------------------------"+ "\n");
				Thread.sleep(150);
			}

		} catch (Exception Ex) {
			System.out.println(Ex);
		}

	}
}
