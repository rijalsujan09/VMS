package voting_Management_System;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

public class VoterDaoDb implements VoterDaoInterface {

	private final static String USERNAME = "root";

	private final static String PASSWORD = "Nunarijal12#";

	private final static String URL = "jdbc:mysql://localhost:3306/MyDatabase";

	@Override
	public Voter viewAll() throws IOException {
		Connection con = null;
		Statement statement = null;
		Voter voter = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String query = "SELECT * from VoterList";

			// System.out.println(query);

			statement = con.createStatement();

			ResultSet results = statement.executeQuery(query);

			while (results.next()) {
				voter = new Voter();
				voter.setVoterId(results.getInt(1));
				voter.setFirstName(results.getString(2));
				voter.setLastName(results.getString(3));
				voter.setGender(Gender.getByValue(results.getString(4)));
				LocalDate DOB = LocalDate.parse(results.getString(5));
				voter.setDateOfBirth(DOB);
				voter.setUsername(results.getString(6));
				voter.setPassword(results.getString(7));
				System.out.println(voter);
				return voter;

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return voter;
	}

	public void addTable() {
		Connection con = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			// String query = "Create table if not exists emp1 (id int not null, fistname
			// varchar(20) not null)";

			StringBuilder query = new StringBuilder();
			query.append("Create table if not exists emp1 (id int not null, firstname varchar(20) not null)");

			statement = con.createStatement();
			statement.execute(query.toString());

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@Override
	public Voter voterRegistration(Voter voter) throws IOException, ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD); // -----

		String insertQuery = "INSERT INTO VoterList (Voter_id,First_Name, Last_Name,Gender,DOB,User_Name,Password)"
				+ "value (" + "'" +voter.getVoterId()+ "','" + voter.getFirstName() + "', '" + voter.getLastName()
				+ "','" + voter.getGender() + "'," + "'" + voter.getDateOfBirth() + "','" + voter.getUsername() + "','"
				+ voter.getPassword() + "')";

		String check = "\n[ " + voter.getFirstName() + "  " + voter.getLastName() + "  " + voter.getGender() + "  "
				+ voter.getDateOfBirth() + "  " + voter.getUsername() + " " + voter.getPassword() + " ] --[Added]--";
		
		System.out.println(check);

		Statement statement = con.createStatement();
		int resultValue = statement.executeUpdate(insertQuery);

		if (resultValue == 2) {
			System.out.println("\t\t--*--Update / Insertation Failed ! Try Again--*--\n");
		}

		statement.close();
		con.close();

		return voter;

	}

// =========================================
	
//	need to copy
	
	@Override
	public Voter searchByUsernameAndPassword(String User_Name, String Password) throws IOException {
		Connection con = null;
		Statement statement = null;
		Voter voter = null;
		try {
			// Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String query = "select * from MyDatabase.VoterList Where User_Name= " + "'" + User_Name + "'"
					+ "And Password=" + "'" + Password + "'";
					
			statement = con.createStatement();
			ResultSet results = statement.executeQuery(query);
			

			while (results.next()) {
				voter = new Voter();
				voter.setVoterId(results.getInt(1));
				voter.setFirstName(results.getString(2));
				voter.setLastName(results.getString(3));
				voter.setGender(Gender.getByValue(results.getString(4)));
				LocalDate dob = LocalDate.parse(results.getString(5));
				voter.setDateOfBirth(dob);
				voter.setUsername(results.getString(6));
				voter.setPassword(results.getString(7));
				System.out.println(voter);
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

	@Override
	public Voter searchByUsername(String username) throws IOException {

		return null;
	}
	
// up to here	
	

	@Override
	public void candidatesList() throws IOException {
		Connection con = null;
		Statement statement = null;
		Voter voter = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String query = "SELECT * from candidatelist";

			// System.out.println(query);

			statement = con.createStatement();

			ResultSet results = statement.executeQuery(query);

			while (results.next()) {

				System.out.println(results.getInt(1));
				System.out.println(results.getString(2));
				System.out.println(results.getString(3));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
