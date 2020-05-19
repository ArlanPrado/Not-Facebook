package facebook;
import mvc.*;
public class AddFriend extends Command{

	public AddFriend(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		UserManager um = (UserManager) model;
		String name = Utilities.ask("Search Name: ");
		try {
			um.addfriend(name);
		}catch(Exception e) {
			Utilities.error(e);
		}
	}

}
