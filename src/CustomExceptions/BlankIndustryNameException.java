/*File: BlankIndustryNameException.java*/
package CustomExceptions;

/**Custom BlankIndustryNameException. Should be thrown when the industry name
 *  is left blank by the user.*/
public class BlankIndustryNameException extends Exception {
	@Override
	public String toString()
	{
		return "You cannot leave the industry name as a blank space. Please try again!";
	}
}
