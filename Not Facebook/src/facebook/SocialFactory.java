package facebook;
import mvc.*;

public class SocialFactory implements AppFactory{

	@Override
	public Model makeModel() {
		
		return new UserManager();
	}

	@Override
	public String[] getEditCommands() {
		return new String[] {"Home", "New Status", "New Profile Picture", "Search", "Add Friend", "Log Out"};
	}

	//Uses the CommandProcessor in mvc package to execute these actions
	@Override
	public Command makeEditCommand(Model model, String type) {		
		switch(type) {
		case("Home"): return new Home(model);
		case("New Status"): return new NewStatus(model);
		case("New Profile Picture"): return new NewPicture(model);
		case("Search"): return new Search(model);
		case("Add Friend"): return new AddFriend(model);
		case("Log Out"): return new Leave(model);
		}
		return null;
	}

	@Override
	public String getTitle() {
		return "Not Facebook";
	}

	@Override
	public String[] getHelp() {
		return new String[] {"Home: Return to Home Page", 
				"New Status: Change your status", 
				"New Profile Picture: Upload a picture (210x160)",
				"Search: Search for another user's profiles", 
				"Add Friend: Add another user to your friend list", 
				"Log Out: Log out of your account"};
	}

	@Override
	public String about() {
		return "Not Facebook is a social media platform";
	}

}
