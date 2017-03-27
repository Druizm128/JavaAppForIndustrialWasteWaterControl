/*File: BlankSampleNumberException.java*/
package CustomExceptions;

/**Custom BlankSampleNumberException. Should be thrown when the sample number
 *  is left in blank by the user.*/
public class BlankSampleNumberException extends Exception{

	
		@Override
		public String toString()
		{
			return "You cannot leave the sample number as a blank space. Please try again!";
		}
}
