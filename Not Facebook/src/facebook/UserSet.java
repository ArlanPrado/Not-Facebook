package facebook;
import java.awt.List;
import java.util.HashSet;
import java.util.Set;
//class that represents the set user
public class UserSet{
	private Set<User> userList;
	
	public UserSet() {
		userList = new HashSet<User>();
	}
	//adds new user when a profile is created
	public void addUser(User user) throws UserInSetException  {
		if(doesUserExist(user.getName())) throw new UserInSetException(user.getName() + " is already added");	//return to whatever page it was on.
		userList.add(user);
	}
	//if the user exists in the set, then return true
	public boolean doesUserExist(String name) {
		for(User temp : userList) {
			if(temp.getName().equals(name))
				return true;
		}
		return false;
	}
	//returns the user identified by the name
	public User getUser(String name) {
		for(User temp : userList) {
			if(temp.getName().equals(name))
				return temp;
		}
		return null;
	}
	//return the list of names
	public List getNames(){
		List names = new List();
		for(User user: userList) {
			names.add(user.getName());
		}
		return names;
	}
	
}
