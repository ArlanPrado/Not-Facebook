package facebook;

import java.io.Serializable;

public class User implements Serializable{
	private String username;
	private String password;
	private String status;
	private UserSet friendList;
	//initializes the user with their name and password
	public User(String user, String pass) {
		username = user;
		password = pass;
		status = null;
		friendList = new UserSet();
	}
	public String getName() {
		return username;
	}
	//adds friend
	public void addFriend(User friend) throws Exception {
		friendList.addUser(friend);
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public UserSet getFriendList() {
		return friendList;
	}
	//returns if the login matches with the user being accessed
	public boolean isUser(String user, String pass) {
		if(username.equals(user) && password.equals(pass)) {
			return true;
		}
		return false;
	}
}
