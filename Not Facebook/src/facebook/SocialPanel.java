package facebook;
import java.awt.*;
import java.beans.PropertyChangeEvent;

import javax.swing.*;
import mvc.*;

public class SocialPanel extends AppPanel{		//this itself is the encompassing panel
	
	static final int WIDTH = 220;
	static final int HEIGHT = 160;

	JTextField name = new JTextField();
	JTextField status = new JTextField();
	JLabel imageLabel = new JLabel();
	//JTextArea friends = new JTextArea();
	List friendsList = new List();

	public SocialPanel(AppFactory factory, User newUser) {	//factory makes the window and provides the action listeners
		super(factory);		
		UserManager userMG = (UserManager)model;
		userMG.setMainUser(newUser);

		this.setLayout(new GridLayout(1,2));
		//button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout (6, 1));
		
		JPanel p = new JPanel();
		JButton button = new JButton("Home");
		button.addActionListener(this);
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
		button = new JButton("Log Out");
		button.addActionListener(this);
		p.add(button);
		buttonPanel.add(p);
		
		add(buttonPanel);		//add button panel to this encompassing panel
		
		
		//profile view
		JPanel profilePanel = new JPanel();
		profilePanel.setLayout(new GridLayout(1,2));
		
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
		
		profilePanel.add(labelPanel);
	
		//all evenly laid out
		
			JPanel textPanel = new JPanel();
			textPanel.setLayout(new GridLayout(3,1));
			
				p = new JPanel();
				p.setLayout(new BorderLayout(2,1));
	
					JPanel q = new JPanel();
					q.setLayout(new BorderLayout());
					q.add(imageLabel, "Center");
	
				p.add(q, "North");
				p.add(name, "South");
			
			textPanel.add(p);
			p.add(status);
			textPanel.add(status);

			textPanel.add(friendsList);
		
		profilePanel.add(textPanel);
		
		add(profilePanel);
	}

	//receives the changed() command and changes the view for the user based on the command
	public void propertyChange(PropertyChangeEvent arg0) {
		UserManager userMG = (UserManager)model;
		name.setText(userMG.getViewedUser().getName());		//set name
		status.setText(userMG.getViewedUser().getStatus());		//set status
		
		ImageIcon icon = new ImageIcon(userMG.getViewedUser().getPicture());
		Image image = icon.getImage();
		Image newimg = image.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		imageLabel.setIcon(icon);			//set the profile picture
		
		friendsList.removeAll();					//to prevent from duplicating friends names, remove all the contents from the list and reenter
		for(String c : userMG.getViewedUser().getFriendList().getNames().getItems()) {
			friendsList.add(c);
		}
		
		if(!userMG.visible) {			//if the model gets the leave command, 
			frame.setVisible(false);	//then "log out" by closing the window 
			LogInPanel.main(null);		//and return to login page
		}
		super.propertyChange(arg0);
	}

	public static void NewScreen(User main) {
		AppPanel socialPanel = new SocialPanel(new SocialFactory(),main);
		socialPanel.display();
	}
}
