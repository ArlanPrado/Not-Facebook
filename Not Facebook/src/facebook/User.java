package facebook;

import java.io.Serializable;

/**class that has all the properties of a user
 * 
 * @author arlan
 *
 */
public class User implements Serializable{
	private String username;
	private String password;
	private String status;
	private UserSet friendList;
	private String picturePath;
	//have an image set here
	
	//initializes the user with their name and password
	public User(String user, String pass) {
		username = user;
		password = pass;
		status = null;
		friendList = new UserSet();
		picturePath = null;
	}
	public String getName() {
		return username;
	}
	public void addFriend(User friend) throws Exception {
		friendList.addUser(friend);
	}
	public UserSet getFriendList() {
		return friendList;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	
	public void setPicture(String filePath){
		picturePath = filePath;
	}
	
	public String getPicture(){
		return picturePath;
	}
	
	//returns if the login matches with the user being accessed
	/** Returns boolean of if the user logging in has the correct credentials
	 * 	
	 * @param user
	 * @param pass
	 * @return
	 */
	public boolean isUser(String user, String pass) {
		if(username.equals(user) && password.equals(pass)) {
			return true;
		}
		return false;
	}
}
