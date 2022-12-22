package voting_Management_System;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class VoterServices {
	public void viewAll() throws IOException {
		VoterDaoInterface dao = new VoterDaoDb();
		dao.viewAll();
	}

//                           ==========================
	public static Voter votingProcess(String User_Name, String Password) throws IOException {
		VoterDaoInterface dao = new VoterDaoDb();
		return dao.searchByUsernameAndPassword(User_Name, Password);
		
		

	}

	public void doVoteNow(Integer voter_Id, String User_Name, Integer Party_ID)
			throws SQLException, ClassNotFoundException {
		try {
			VoteRecordDb dao = new VoteRecordDb(voter_Id, User_Name, Party_ID);
			
			dao.doVote(voter_Id, User_Name, Party_ID);
			
			
			System.out.println("\n\t\t--*--Voter Registeration Successfully--*--");

		} catch (SQLIntegrityConstraintViolationException e) {
			

			e.printStackTrace();

			System.out.println("\t\t--*--Faild to registere your vote--*--");
		}
	}

	public Voter voterRegistration(Voter voter) throws IOException, SQLException, ClassNotFoundException {
		VoterDaoInterface dao = new VoterDaoDb();

		dao.voterRegistration(voter);
		return voter;
	}
	
	
	
	

// Check if voter exist
//	need to  copy
	public boolean checkIfUserNameExists(String username) {
		

		VoterDaoInterface dao = new VoterDaoDb();
		Voter voter = null;
		try {
			voter = dao.searchByUsername(username);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Some issue occurred");
			e.printStackTrace();
		}
		
		if (voter == null) {
			return false;
		} else if(voter.equals(voter)) {
			return true;
		}
		return false;
	}

	
	
	

	public void finalResult() throws SQLException, ClassNotFoundException {
		VoteRecordDb result = new VoteRecordDb();
		{
			result.voteCount();

		}

	}
}
