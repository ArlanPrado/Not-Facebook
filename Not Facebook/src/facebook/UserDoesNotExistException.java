package facebook;

/** Thrown when the user in the set does not exist
 * 
 * @author arlan
 *
 */
public class UserDoesNotExistException extends Exception{
	private static final long serialVersionUID = 1L;
	public UserDoesNotExistException() {super();}
	public UserDoesNotExistException(String message) {super(message);}
}
