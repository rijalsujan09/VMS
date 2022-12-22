package voting_Management_System;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Check_Caste {
	private final static String USERNAME = "root";

	private final static String PASSWORD = "Nunarijal12#";

	private final static String URL = "jdbc:mysql://localhost:3306/MyDatabase";

	public static Voter check_Caste(String User_Name) {
		Connection con = null;
		Statement statement = null;
		Voter voter = null;
		try {
			// Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String query = "select * from MyDatabase.Ballot Where User_Name= " + "'" + User_Name + "'";

			statement = con.createStatement();
			ResultSet results = statement.executeQuery(query);

			while (results.next()) {
				voter = new Voter();
				voter.setVoterId(results.getInt(1));
				voter.setFirstName(results.getString(2));
				voter.setParty_ID(results.getInt(3));
				return voter;
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

		return voter;
	}
	
	public Voter check_Caste1(String username) throws IOException {

		return null;
	}

}
