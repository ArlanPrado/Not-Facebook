package facebook;
import mvc.*;
/** Home executes the home method in UserManager which would reset the viewed user to the main user
 * 
 * @author arlan
 *
 */
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
