package facebook;
import mvc.*;
public class Home extends Command{

	public Home(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		UserManager um = (UserManager) model;
		try {
			um.home();
		}catch(Exception e) {
			Utilities.error(e);
		}
	}
}
