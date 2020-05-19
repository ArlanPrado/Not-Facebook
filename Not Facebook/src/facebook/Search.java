package facebook;
import mvc.*;
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
