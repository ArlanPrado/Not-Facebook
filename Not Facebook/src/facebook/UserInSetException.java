package facebook;

/** Exception thrown when the User exists in the set 
 * Keeps sets unique
 * @author arlan
 *
 */
public class UserInSetException extends Exception {
	private static final long serialVersionUID = 1L;
	public UserInSetException() {super();}
	public UserInSetException(String message) {super(message);}

}
