package facebook;

import mvc.Command;
import mvc.Model;
import mvc.Utilities;

/** Shows a popup message using Utilities.inform of the connections users have with each other.
 * 
 * @author arlan
 *
 */
public class AdjacencyList extends Command {

	public AdjacencyList(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		UserManager um = (UserManager) model;
		Utilities.inform(um.getAdjacencyList());

	}

}
