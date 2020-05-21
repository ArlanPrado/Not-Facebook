package facebook;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//@author arlan prado
public class LogInPanel extends JPanel{
	private JFrame frame;
	public static int FRAME_WIDTH = 400;
	public static int FRAME_HEIGHT = 300;
	JTextField username = new JTextField(20);
	JTextField password = new JTextField(20);
	
	public LogInPanel() {
		frame = new JFrame();
		frame.setTitle("Login to Not Facebook");
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();			//encompassing panel
		panel.setLayout(new GridLayout(2,1));
		
			JPanel allLogPanel = new JPanel();			//panel that holds the login label and text fields
			allLogPanel.setLayout(new GridLayout(1,2));
			
				JPanel labelPanel = new JPanel();			// panel that holds the text fields
				labelPanel.setLayout(new GridLayout(2,1));
				JLabel jl = new JLabel();
				jl.setText("Name: ");
				labelPanel.add(jl);
				JLabel jl1 = new JLabel();
				jl1.setText("Password: ");
				labelPanel.add(jl1);
			allLogPanel.add(labelPanel, "West");
				
				JPanel loginPanel = new JPanel();			//panel that holds the login text fields
				loginPanel.setLayout(new GridLayout(2,1));
				loginPanel.add(username);
				loginPanel.add(password);
			allLogPanel.add(loginPanel, "East");
			
		panel.add(allLogPanel);		//add login panels to the top of the encompassing panel
			
			JPanel loginButtonPanel = new JPanel();			//panel for login and new account buttons
			loginButtonPanel.setLayout(new GridLayout(1,2));
			
				JPanel p = new JPanel();
				JButton button = new JButton("Log in");		//login button
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
						String user = username.getText();
						String pass = password.getText();
						if(UserManager.userList.doesUserExist(user)) {
							User temp = UserManager.userList.getUser(user);
							if(temp.isUser(user, pass)) {	//if the user matches the user in the list
								
								frame.setVisible(false);		//close window after successful log in
								SocialPanel panel = new SocialPanel(new SocialFactory(),temp);
								panel.NewScreen(temp);			//start application window
							}else {
								mvc.Utilities.error("Wrong username or password");
							}
						}else {
							mvc.Utilities.error("Wrong username or password");
						}
						}catch(Exception e) {
							mvc.Utilities.error(e);
						}
					}
					
				});
				p.add(button);
			loginButtonPanel.add(p, "West");
				
				button = new JButton("Create a New Account");	//new account button
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							String user = username.getText();
							String pass = password.getText();
<<<<<<< Updated upstream
							User temp = new User(user, pass);
							UserManager.userList.addUser(temp);
							mvc.Utilities.inform("New User Created!");
							}
						catch (Exception er){
							mvc.Utilities.error(er);
=======
							if(!user.isEmpty() && !pass.isEmpty()) {
								User temp = new User(user, pass);
								UserManager.userList.addUser(temp);				//adds new users to the list
								mvc.Utilities.inform("New User Created!");
							}else {
								mvc.Utilities.inform("The username and password does not meet the requirements");
							}
						}catch (Exception er){
							mvc.Utilities.error(er);			//if the user is already created sends an error message
>>>>>>> Stashed changes
						}
						
					}});
				p.add(button);
			loginButtonPanel.add(p, "East");
		
		panel.add(loginButtonPanel);

		frame.add(panel, BorderLayout.CENTER);
		frame.pack();
	}

	public void display() { frame.setVisible(true); }
	
	//this is what starts up the application
	public static void main(String[] args) {
		LogInPanel panel = new LogInPanel();
		panel.display();
	}

}