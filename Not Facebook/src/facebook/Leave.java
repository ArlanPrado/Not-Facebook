package facebook;
import mvc.*;
public class Leave extends Command{

	public Leave(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		UserManager um = (UserManager) model;
		um.leave();
	}
}
