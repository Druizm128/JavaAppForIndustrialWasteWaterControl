/* File: Analysis.java
 * */
/**
 * This superclass keeps track of the basic information that an analysis of waste water dischargess must have: 
 * <ul><li>The name of the industry that discharged the waste water to a receiving body.</li>
 * <li>The name of the laboratory that took the sample of water and performed the tests to determine the concentration of each pollutant.</li>
 * <li>A 4 character number which serves the laboratory to identify the sample of waste water that was analyzed</li>
 * <li>The date when the sample of waste water was obtained.</li></ul>
 * @author Dante Ruiz
 */
public class Analysis
{
	/* INSTANCE VARIABLES */
	/** Stores the name of the industry that discharged waste waters. */
	private String industryName;
	/** Stores the laboratory name of the company that obtained the waste water samples from a receiving body of water. */
	private String laboratoryName;
	/** Stores a 4 character string that acts as an identifier of the laboratory sample of waste water to be analyzed.*/
	private String sampleNumber;
	/** Stores the date when the sample of waste water was obtained by the laboratory (DDMMYYYY).*/
	private String sampleDate;
	
	/* CONSTRUCTOR */
	/**
	 * Builds an Analysis object with no pollution or compliance results.
	 * @param industryName The name of the industry.
	 * @param laboratoryName The name of the laboratory
	 * @param sampleNumber The 4 character sample number
	 * @param sampleDate The sample date
	 */
	Analysis(String industryName, String laboratoryName, String sampleNumber, String sampleDate){
		this.industryName = industryName;
		this.laboratoryName = laboratoryName;
		this.sampleNumber = sampleNumber;
		this.sampleDate = sampleDate;	
	}
	/*GETTERS AND SETTERS*/
	/**
	 * Gets the name of the industry to which the sample of waste water belongs.
	 * @return The name of the industry
	 */
	public String getIndustryName() {
		return industryName;
	}
	/**
	 * Gets the name of the laboratory that obtained the sample of water and performed the water quality tests.
	 * @return The laboratory name
	 */
	public String getLaboratoryName() {
		return laboratoryName;
	}
	/**
	 * Gets the number that identifies this sample. It consists in a 4 character string. It may contain numbers and characters.
	 * @return The sample number
	 */
	public String getSampleNumber() {
		return sampleNumber;
	}
	/**
	 * Gets the date when the sample was obtained and taken to the laboratory for the corresponding tests. It is a string in the format DDMMYYYY.
	 * @return The sample date
	 */
	public String getSampleDate() {
		return sampleDate;
	}
	/**
	 * Sets the name of the owner of the waste water sample.
	 * @param industryName A string industry name
	 */
	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}
	/**
	 *  Sets the laboratory name that obtained the tests and that will perform the analytical tests.
	 * @param laboratoryName A string laboratory name
	 */
	public void setLaboratoryName(String laboratoryName) {
		this.laboratoryName = laboratoryName;
	}
	/**
	 * Sets a 4 character string that identifies this sample from the rest.
	 * @param sampleNumber A string 4 character sample number
	 */
	public void setSampleNumber(String sampleNumber) {
		this.sampleNumber = sampleNumber;
	}
	/**
	 * Sets the date when the sample was obtained and taken to the laboratory for tests.
	 * @param sampleDate A string sample date in the format DDMMYYYY.
	 */
	public void setSampleDate(String sampleDate) {
		this.sampleDate = sampleDate;
	}
}
