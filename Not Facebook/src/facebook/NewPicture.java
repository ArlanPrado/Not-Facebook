package facebook;
import mvc.*;

import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
public class NewPicture extends Command {

	public NewPicture(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		UserManager um = (UserManager) model;
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			//System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
			File f = chooser.getSelectedFile();
			String fileName = f.getAbsolutePath();
			try {
				um.pictureChange(fileName);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				Utilities.error(e);
			}
		}
		//String imgFile = 
		//Ask to upload a file
			//get file location, upload it to 
		//try and catch if file is acceptable?		
			//upload image to usermanager
	}

}
