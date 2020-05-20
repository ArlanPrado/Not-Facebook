package facebook;
import java.awt.*;
import java.beans.PropertyChangeEvent;

import javax.swing.*;
import mvc.*;

/**Social Panel is the main panel for Not Facebook
 * 
 * @author arlan
 *
 */
public class SocialPanel extends AppPanel{		//this itself is the encompassing panel
	
	static final int WIDTH = 220;		//profile picture width
	static final int HEIGHT = 160;		//profile picture height

	//these are fields that are going to be changed through user interaction
	JTextField name = new JTextField();
	JTextField status = new JTextField();
	JLabel imageLabel = new JLabel();			//JLabel image for profile picture
	List friendsList = new List();

	/**Constructs the new social panel
	 * 	
	 * @param factory	AppFactory, this is what commits the factory
	 * @param newUser	newUser is the main user of the application
	 */
	public SocialPanel(AppFactory factory, User newUser) {	//factory makes the window and provides the action listeners
		super(factory);		
		UserManager userMG = (UserManager)model;
		userMG.setMainUser(newUser);

		this.setLayout(new GridLayout(1,2));	//overall layout/panel
		
		//button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout (7, 1));
		
		JPanel p = new JPanel();					//p is a subpanel for the button panel, this fits buttons together nicely
		JButton button = new JButton("Home");
		button.addActionListener(this);				//action listener is done by the superclass AppPanel to be then carried about by the AppFactory
		p.add(button);
		buttonPanel.add(p);
		
		p = new JPanel();
		button = new JButton("New Status");
		button.addActionListener(this);
		p.add(button);
		buttonPanel.add(p);
		
		p = new JPanel();
		button = new JButton("New Profile Picture");
		button.addActionListener(this);
		p.add(button);
		buttonPanel.add(p);
		
		p = new JPanel();
		button = new JButton("Search");
		button.addActionListener(this);
		p.add(button);
		buttonPanel.add(p);
		
		p = new JPanel();
		button = new JButton("Add Friend");
		button.addActionListener(this);
		p.add(button);
		buttonPanel.add(p);
		
		p = new JPanel();
		button = new JButton("User Relations");
		button.addActionListener(this);
		p.add(button);
		buttonPanel.add(p);
		
		p = new JPanel();
		button = new JButton("Log Out");
		button.addActionListener(this);
		p.add(button);
		buttonPanel.add(p);
		
		add(buttonPanel);		//add button panel to the encompassing panel
		
		
		//profile view
		JPanel profilePanel = new JPanel();
		profilePanel.setLayout(new GridLayout(1,2));
		
			//label panel describing what each section is
			JPanel labelPanel = new JPanel();		
			labelPanel.setLayout(new GridLayout(3,1));
			JLabel jl = new JLabel();
			jl.setText("Name: ");
			labelPanel.add(jl);
			JLabel jl1 = new JLabel();
			jl1.setText("Status: ");
			labelPanel.add(jl1);
			JLabel jl2 = new JLabel();
			jl2.setText("Friend List: ");
			labelPanel.add(jl2);
		
		profilePanel.add(labelPanel);		//add label panel to left side of profile panel
	
		//all evenly laid out
		
			JPanel textPanel = new JPanel();		//this is the panel that would include all user content
			textPanel.setLayout(new GridLayout(3,1));
			
				p = new JPanel();						//subpanel p with profile picture above the user name
				p.setLayout(new BorderLayout(2,1));
	
					JPanel q = new JPanel();			//subpanel q for profile picture
					q.setLayout(new BorderLayout());
					q.add(imageLabel, "Center");
	
				p.add(q, "North");
				p.add(name, "South");
			
			textPanel.add(p);
			p.add(status);
			textPanel.add(status);

			textPanel.add(friendsList);
		
		profilePanel.add(textPanel);			//add text panel to profile panel
				
		add(profilePanel);				//add profile panel on right side
	}

	/**Receives the property change event and changes the JComponents accordingly
	 * This can change user views, add or change information
	 */
	public void propertyChange(PropertyChangeEvent arg0) {
		UserManager userMG = (UserManager)model;
		name.setText(userMG.getViewedUser().getName());		//set name
		status.setText(userMG.getViewedUser().getStatus());		//set status
		
		ImageIcon icon = new ImageIcon(userMG.getViewedUser().getPicture());			//gets the picture file path and creates a new ImageIcon
		Image image = icon.getImage();												//creates a new image using the icon
		Image newimg = image.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);			//scale the new image
		icon = new ImageIcon(newimg);												//set the icon as the new scaled image
		imageLabel.setIcon(icon);			//set the profile picture as the new icon
		
		friendsList.removeAll();					//to prevent from duplicating friends names, remove all the contents from the list and reenter
		for(String c : userMG.getViewedUser().getFriendList().getNames().getItems()) {		//get the names of the friendslist in an iterator list
			friendsList.add(c);
		}
		
		if(!userMG.visible) {			//if the model gets the leave command, 
			frame.setVisible(false);	//then "log out" by closing the window 
			LogInPanel.main(null);		//and return to login page
		}
		super.propertyChange(arg0);
	}

	/** Starts up and displays the SocialPanel
	 * 
	 * @param main User, gets the User object that will be the main user of this application
	 */
	public static void NewScreen(User main) {				//display this new screen 
		AppPanel socialPanel = new SocialPanel(new SocialFactory(),main);		//create a new social panel 
		socialPanel.display();			//call display method in App Panel
	}
}
