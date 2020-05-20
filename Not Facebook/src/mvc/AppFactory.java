package mvc;

public interface AppFactory {
	public Model makeModel();
	public String[] getEditCommands();
	public Command makeEditCommand(Model model, String type);
	public String getTitle();
	public String[] getHelp();
	public String about();
	//public View getView(Model model); Only needed if there is a specific view
}
