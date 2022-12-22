package voting_Management_System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class View_Candidate {

	public static String USER = "root";

	public static String PAS = "Nunarijal12#";

	public static String URL = "jdbc:mysql://localhost:3306/MyDatabase";

	public static void viewCandidate() throws InterruptedException {

		System.out.println("\t\t---*For Election 2022 Registered Party is given below--*--");
		Connection con = null;
		Statement statement = null;

		// Voter voter = null;

		try {

			con = DriverManager.getConnection(URL, USER, PAS);

			String query = "SELECT * from MyDatabase.Candidates";

			statement = con.createStatement();

			ResultSet results = statement.executeQuery(query);

			while (results.next()) {
				int party_id = results.getInt(1);
				String party_name = results.getString(2);
				String Cd_name = results.getString(3);
				System.out.println("\n\t\t-----------------------------\n\t\tParty_Id : " + party_id
						+ "\n\t\tParty_Name : " + party_name + "\n\t\tCandidate_Name : " + Cd_name
						+ "\n\t\t---------------------------");

				Thread.sleep(150);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
