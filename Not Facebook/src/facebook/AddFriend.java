package facebook;
import mvc.*;
/**Adds a friend by having the user pick out another user
 * Catches UserDoesNotExistException if the user they are trying to look for does not exist
 * @author arlan
 *
 */
public class AddFriend extends Command{

	public AddFriend(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		UserManager um = (UserManager) model;
		String name = Utilities.ask("Add Friend: ");
		try {
			um.addfriend(name);
		}catch(Exception e) {
			Utilities.error(e);
		}
	}

}
