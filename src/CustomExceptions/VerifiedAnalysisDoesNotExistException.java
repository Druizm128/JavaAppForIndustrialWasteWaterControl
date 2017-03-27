/*File: VerifiedAnalysisDoesNotExistException.java */
package CustomExceptions;

/**
 * VerifiedAnalysisDoesNotExistException should be thrown when the name of the industry
 * and the sample number does not belong to a previously stored verified analysis. This 
 * exception may be triggered because the user misspelled the name of the industry
 * or the sample number; or maybe the analysis does not exist or has not been verified.
 * @author danteruiz
 */
public class VerifiedAnalysisDoesNotExistException extends Exception {
	@Override
	public String toString()
	{
		return "The analysis was not found because either it does not exist, it has not been verified "
				+ "or you misspelled the name of the industry or the sample number.";
	}
}
