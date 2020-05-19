package facebook;
import mvc.*;
public class NewStatus extends Command{

	public NewStatus(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void execute() {
		UserManager um = (UserManager) model;
		String status = Utilities.ask("New Status: ");
		try {
			um.statusChange(status);
		}catch(Exception e) {
			Utilities.error(e);
		}
	}
}
