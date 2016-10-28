package models;

public class UserInformation {
	
	private String username;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private ProductHistory productHistory;
	
	/**
	 * Constructor for User
	 * for this implementation password is set to null because it will be handled by PasswordHandler
	 * which hasn't been implemented
	 * initialized productHistory
	 * @param username
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @param email
	 */
	
	public UserInformation() {
		
	}
	
	public UserInformation(String username, String firstName, String lastName, String password, String email)
	{
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
	}
	/**
	 * return User's username
	 * @return
	 */
	public String getUsername()
	{
		return username;
	}
	/**
	 * set the username of the user
	 * @param username
	 */
	public void setUsername(String newUsername)
	{
		username = newUsername;
	}
	/**
	 * returns User's First Name
	 * @return
	 */
	public String getFirstName()
	{
		return firstName;
	}
	/**
	 * set the firstName of User
	 * @param username
	 */
	public void setFirstName(String newFirstName)
	{
		firstName = newFirstName;
	}
	/**
	 * return User's Last Name;
	 * @return
	 */
	public String getLastName()
	{
		return lastName;
	}
	/**
	 * set User's last name
	 * @param lastName
	 */
	public void setLastName(String newLastName)
	{
		lastName = newLastName;
	}
	/**
	 * Do not implement
	 * Uses determinePasswordHash from PasswordHandler. PasswordHandler has not been implemented
	 * and therefore it will return null in the meantime.
	 * @return null
	 */
	public String getPasswordHash()
	{
		return null;
	}
	/**
	 * set the User password
	 * Do not implement 
	 * will rely on PasswordHandler which has not been implemented
	 * @param username
	 */
	public void setPassword(String newPassword)
	{
		password = newPassword;
	}
	/**
	 * returns User's email
	 * @return
	 */
	public String getEmail()
	{
		return email;
	}
	/**
	 * set the User email
	 * @param email
	 */
	public void setEmail(String newEmail)
	{
		email = newEmail;
	}
	
}
