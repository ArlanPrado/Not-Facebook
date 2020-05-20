package facebook;
import mvc.*;
/**This logs out the user from the Not Facebook application
 * 
 * @author arlan
 *
 */
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
