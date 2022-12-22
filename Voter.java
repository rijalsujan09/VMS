package voting_Management_System;

import java.time.LocalDate;
import java.util.Objects;

public class Voter {
	private Integer voter_Id;

	private String firstName;

	private String lastName;
	private Gender gender;
	private LocalDate DOB;
	private String username;
	private String password;
	private int Party_ID;

	public Voter() {
	}

	public Voter(Integer voter_Id, String firstName, String lastName, Gender gender, LocalDate DOB, String username,
			String password) {
		this.voter_Id = voter_Id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.DOB = DOB;
		this.username = username;
		this.password = password;
	}

	public Voter(String firstName, String lastName, Gender gender, LocalDate DOB, String username, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.DOB = DOB;
		this.username = username;
		this.password = password;
	}

	public Integer getVoterId() {
		return voter_Id;
	}

	public void setVoterId(Integer voterId) {
		this.voter_Id = voterId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return DOB;
	}

	public void setDateOfBirth(LocalDate DOB) {
		this.DOB = DOB;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getParty_ID() {
		return Party_ID;
	}

	public void setParty_ID(int Party_ID) {
		this.Party_ID = Party_ID;
	}

	@Override
	public String toString() {
		return "\n\t\t------------------------------------\n\t\tvoterId : " + voter_Id + "\tName : " + firstName + " "
				+ lastName + "\n\t\tgender : " + gender + "\tDateOfBirth : " + DOB
				+ "\n\t\t------------------------------------\n";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Voter voter = (Voter) o;
		return Objects.equals(getVoterId(), voter.getVoterId()) && Objects.equals(getFirstName(), voter.getFirstName())
				&& Objects.equals(getLastName(), voter.getLastName()) && getGender() == voter.getGender()
				&& Objects.equals(getDateOfBirth(), voter.getDateOfBirth())
				&& Objects.equals(getUsername(), voter.getUsername())
				&& Objects.equals(getPassword(), voter.getPassword());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getVoterId(), getFirstName(), getLastName(), getGender(), getDateOfBirth(), getUsername(),
				getPassword());
	}

}
