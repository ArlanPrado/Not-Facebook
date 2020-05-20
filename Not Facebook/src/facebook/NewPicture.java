package facebook;
import mvc.*;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**Changes the profile picture of the user by getting the filepath of the image
 * This only accepts JPGs and PNGs
 * @author arlan
 *
 */
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
			File f = chooser.getSelectedFile();
			String fileName = f.getAbsolutePath();
			try {
				um.pictureChange(fileName);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				Utilities.error(e);
			}
		}
	}

}
