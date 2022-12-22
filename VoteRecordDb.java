package voting_Management_System;

import java.sql.*;

/**
 * DO vote and vote count method is in here,Vote Record DB.... in do vote they
 * have to log in by username and password . need to put their id number and
 * need to choose one symbolfor vote ... keep the record in VOTE entity. search
 * result in vote table in voter database . where voter id from voter list is
 * foreign key in vote table .
 */
public class VoteRecordDb {
	private int Voter_Id;
	private int Party_ID;
	private String User_Name;

	public String getUser_Name() {
		return User_Name;
	}

	public void setVoterId(String User_Name) {
		this.User_Name = User_Name;
	}

	public int getVoterId() {
		return Voter_Id;
	}

	public void setVoterId(int voterId) {
		this.Voter_Id = voterId;
	}

	public int getSParty_ID() {
		return Party_ID;
	}

	public void setParty_ID(int Party_ID) {
		this.Party_ID = Party_ID;
	}

	public VoteRecordDb() {
	}

	public VoteRecordDb(int voterId, String User_Name, int Party_ID) {
		this.Voter_Id = voterId;
		this.Party_ID = Party_ID;
	}
	

	private final static String USERNAME = "root";

	private final static String PASSWORD = "Nunarijal12#";

	private final static String URL = "jdbc:mysql://localhost:3306/MyDatabase";

	public void voteCount() throws ClassNotFoundException, SQLException {

		// =================================

		Connection con = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			Statement stmt1 = con.createStatement();

			ResultSet rs1 = stmt1.executeQuery("SELECT COUNT(*) AS COUNT FROM Ballot where symbol=1");
			Integer Party1 = null;
			while (rs1.next()) {
				System.out.println("The total vote for Symbol 1 (MaoBadi) is:: " + rs1.getInt("COUNT"));
				Party1 = rs1.getInt(1);
			}

			// Create a Statement class to execute the SQL statement
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS COUNT FROM Ballot where symbol=2");
			Integer Party2 = null;
			while (rs.next()) {
				System.out.println("The total vote for Symbol 2 (Cangress) is:: " + rs.getInt("COUNT"));
				Party2 = rs.getInt(1);

				// Closing the connection
			}
			if (Party2 < Party1) {
				System.out.println("YOUNG PARTY IS WIN");
			} else {
				System.out.println("OLD PARTY IS WIN");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Voter doVote(Integer Voter_ID, String User_Name, Integer Party_ID) throws ClassNotFoundException, SQLException {

		// have to make table and chagne voting system ....
		VoteRecordDb vote = new VoteRecordDb(Voter_ID,User_Name,Party_ID);

		// Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		String insertQuery = "INSERT INTO Ballot (Voter_Id, User_Name, Party_Id)" + "value ("
				+ vote.getVoterId() + ", '"+User_Name+"' ," + vote.getSParty_ID() + ")";

		Statement statement = con.createStatement();
		int resultValue = statement.executeUpdate(insertQuery);

		if (resultValue == 2) {
			System.out.println("You already voted");
		}

		statement.close();
		con.close();

		return null;

	}

}
