package facebook;
import mvc.*;
public class ModifyProfile extends Command{

	public ModifyProfile(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		UserManager um = (UserManager) model;
		String status = Utilities.ask("New Status: ");
		try {
			um.modify(status);
		}catch(Exception e) {
			Utilities.error(e);
		}
	}
}
