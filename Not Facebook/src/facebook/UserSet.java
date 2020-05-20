package facebook;
import java.awt.List;
import java.util.HashSet;
import java.util.Set;
/**class that represents a set of users
 * Could represent a friend list or whole userbase
 * @author arlan
 *
 */
public class UserSet{
	private Set<User> userList;
	
	public UserSet() {
		userList = new HashSet<User>();
	}
	/**adds new user when a profile is created
	 * throws exception when the user trying to be added already exists
	 * @param user
	 * @throws UserInSetException
	 */
	public void addUser(User user) throws UserInSetException  {
		if(doesUserExist(user.getName())) throw new UserInSetException(user.getName() + " is already added");	//return to whatever page it was on.
		userList.add(user);
	}
	/**if the user exists in the set, then return true; if not return false
	 * 
	 * @param name
	 * @return
	 */
	public boolean doesUserExist(String name) {
		for(User temp : userList) {
			if(temp.getName().equals(name))
				return true;
		}
		return false;
	}
	/**returns the user identified by the name
	 * 
	 * @param name String
	 * @return User
	 */
	public User getUser(String name) {
		for(User temp : userList) {
			if(temp.getName().equals(name))
				return temp;
		}
		return null;
	}
	/**return the list of names
	 * 
	 * @return
	 */
	public List getNames(){
		List names = new List();
		for(User user: userList) {
			names.add(user.getName());
		}
		return names;
	}
	/**Return Adjacency List
	 * 
	 * @return
	 */
	public String getAdjacencyList() {
		String test;
		String arrow = "->";
		String total = "";
		for(User user: userList) {
			test = user.getName();
			for(String name: user.getFriendList().getNames().getItems()) {
				test += arrow + name;
			}
			test += arrow + "NULL";
			total += test + "\n";
		}
		return total;
	}
	
}
