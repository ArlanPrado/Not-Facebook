package facebook;
import mvc.*;
/**This asks the user what the other user profile they want to see
 * Catches UserDoesNotExistException if the user they are trying to look for does not exist
 * @author arlan
 *
 */
public class Search extends Command{

	public Search(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		UserManager um = (UserManager) model;
		String name = Utilities.ask("Search Name: ");
		try {
			um.search(name);
		}catch(Exception e) {
			Utilities.error(e);
		}
	}
}
