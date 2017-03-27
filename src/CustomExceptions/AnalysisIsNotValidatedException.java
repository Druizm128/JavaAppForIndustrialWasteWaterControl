/* File: AnalysisIsNotValidatedException.java */
package CustomExceptions;

/**
 * SampleDoesNotExistException should be thrown when the name of the industry
 * and the sample number does not belong to a previously stored analysis. This 
 * exception may be triggered because the user misspelled the name of the industry
 * or the sample number; or maybe the analysis does not exist. 
 * @author danteruiz
 */
public class AnalysisIsNotValidatedException extends Exception {
	@Override
	public String toString()
	{
		return "The analysis was not found because either it does not exist "
				+ "or you misspelled the name of the industry or the sample number.";
	}
}
