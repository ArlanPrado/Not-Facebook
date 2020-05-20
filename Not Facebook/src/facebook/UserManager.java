package facebook;
import mvc.*;
/**This class manages the total userList and the main user
 * 
 */
public class UserManager extends Model{
	private static final long serialVersionUID = 1L;
	public static UserSet userList = new UserSet();	//can be accessed outside the model to have users be added into the set list
	private User mainUser;	//the user that is the one that is logged in
	private User viewed;	//the user that is currently on the screen
	public boolean visible;	//the application will keep running as long as visible is true
	
	public UserManager() {
		visible = true;
	}

	public void setMainUser(User main) {
		mainUser = main;
		home();
	}
	/**returns the user that is being viewed
	 * 
	 * @return User
	 */
	public User getViewedUser() {
		return viewed;
	}
	//changes the view to the main users profile
	public void home() {
		viewed = mainUser;
		changed();			//notifies the framework that the model has changed
	}
	/**Changes the status to the new status
	 * Calls home() function to change view back to main user's profile
	 * @param newStatus
	 * @throws Exception
	 */
	public void statusChange(String newStatus) throws Exception{
		mainUser.setStatus(newStatus);
		home();//change to home view
	}
	/**upload a picture to the mainUser's profile picture
	 * Calls home() function to change view back to main user's profile
	 * @param filePath String
	 */
	public void pictureChange(String filePath){
		mainUser.setPicture(filePath); 
		home();
	}
	/**searches the user
	 * Changes the view to the searched user if found
	 * @param name
	 * @throws Exception
	 */
	public void search(String name) throws Exception{
		if(!userList.doesUserExist(name)) throw new UserDoesNotExistException("This user does not exist");
		else {
			viewed = userList.getUser(name);
		}
		//change view to the profile of the name
		changed();
	}
	/**adds friend to the user's friend list
	 * Calls home() function to change view back to main user's profile
	 * @param name
	 * @throws Exception
	 */
	public void addfriend(String name) throws Exception{
		if(!userList.doesUserExist(name)) throw new UserDoesNotExistException("This user does not exist");		//if the name is not in the set then throw exception
		else if(name.equals(mainUser.getName()) || mainUser.getFriendList().doesUserExist(name)) throw new UserInSetException("Not allowed to add this user");		//throw exception if the name is themselves or is already in the friend list
		else {
			User friend = userList.getUser(name);
			friend.addFriend(mainUser);
			mainUser.addFriend(friend);
		}
		home();//change to home view
	}
	/**Returns adjacency list taken from the main userlist
	 * 
	 * @return String of adjacency list
	 */
	public String getAdjacencyList() {
		return userList.getAdjacencyList();
	}
	
	/**leave window back to login page
	 * 
	 */
	public void leave() {
		visible = false;	//now SocialPanel will catch this in the property change
		changed();		//notifies the framework that the model has changed
	}
}