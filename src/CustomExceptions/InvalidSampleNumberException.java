/* File: InvalidSampleNumberException.java */
package CustomExceptions;

/**
 * InvalidSampleNumberException should be thrown when the user inputs a sample number
 * either bigger than 4 characters or less than 4 characters long.
 * @author danteruiz
 */
public class InvalidSampleNumberException extends Exception {
	@Override
	public String toString()
	{
		return "The sample number must be of length 4. Please try again.";
	}
}
