package facebook;
import mvc.*;
/**This sets the status of the main user by using the Utilities.ask function
 * 
 * @author arlan
 *
 */
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
			if(!status.isEmpty())
				um.statusChange(status);
		}catch(Exception e) {
			Utilities.error(e);
		}
	}
}
