/* File: LabResults.java */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
/**
 * <p>This class extends Analysis and keeps record of test results performed by the laboratory. It contains analytic concentrations of nine heavy metals.</p>
 * <ol><li>Arsenic</li>
 * <li>Cadmium</li>
 * <li>Cyanides</li>
 * <li>Copper</li>
 * <li>Chromium</li>
 * <li>Mercury</li>
 * <li>Nickel</li>
 * <li>Lead</li>
 * <li>Zinc</li></ol>
 * <p>Such pollutants are outlined in the Mexican norm that regulates water quality of receiving bodies of waste water NOM-001-SEMARNAT-1996.<p> 
 * <p>This class has two constructors:</b>,
 * <ul><li>Standard: Creates an analysis by entering all the general details of the analysis plus each of the 9 concentrations of heavy metals.</li>
 * <li>Demo: Creates a demo analysis that only needs the general details of the analysis, while the 9 concentrations of heavy metals
 * are generated using random numbers.</li>
 * @author Dante Ruiz
 */
public class LabResults extends Analysis
{
	/*Instance variables*/
	/**Laboratory concentration results of Arsenic in mg/L*/
	private double arsenicResult;
	/**Laboratory concentration results of Cadmium in mg/L*/
	private double cadmiumResult;
	/**Laboratory concentration results of Cyanides in mg/L*/
	private double cyanidesResult;
	/**Laboratory concentration results of Copper in mg/L*/
	private double copperResult;
	/**Laboratory concentration results of Chromium in mg/L*/
	private double chromiumResult;
	/**Laboratory concentration results of Mercury in mg/L*/
	private double mercuryResult;
	/**Laboratory concentration results of Nickel in mg/L*/
	private double nickelResult;
	/**Laboratory concentration results of Lead in mg/L*/
	private double leadResult;
	/**Laboratory concentration results of Zinc in mg/L*/
	private double zincResult;
	/**Stores information on whether the laboratory results have been subject to the compliance analysis (true/false)*/
	private boolean verificationStatus = false;
	/**Stores the information on whether the user wants to build demo laboratory results*/
	private String optionDemo;
	
	// Standard constructor
	/**
	 * Builds an analysis with the laboratory results by entering the concentration in kilograms/Liter (mg/L) of each
	 * of nine heavy metals using random numbers.
	 * @param industryName A string with the industry name.
	 * @param laboratoryName A string with the name of the laboratory.
	 * @param sampleNumber A 4 character string sample number.
	 * @param sampleDate A string with the date (DDMMYYYY) when the sample of waste water was obtained.
	 * @param arsenic A double with the concentration of arsenic in mg/L.
	 * @param cadmium A double with the concentration of cadmium in mg/L.
	 * @param cyanides A double with the concentration of cyanides in mg/L.
	 * @param copper A double with the concentration of copper in mg/L.
	 * @param chromium A double with the concentration of chromium in mg/L.
	 * @param mercury A double with the concentration of mercury in mg/L.
	 * @param nickel A double with the concentration of nickel in mg/L.
	 * @param lead A double with the concentration of lead in mg/L.
	 * @param zinc A double with the concentration of zinc in mg/L.
	 */
	LabResults(String industryName, String laboratoryName, String sampleNumber, String sampleDate,
		double arsenic, double cadmium, double cyanides, double copper, double chromium, double mercury,
		double nickel, double lead, double zinc) {
			super(industryName, laboratoryName, sampleNumber, sampleDate);
			arsenicResult = arsenic;
			cadmiumResult = cadmium;
			cyanidesResult = cyanides;
			copperResult = copper;
			chromiumResult = chromium;
			mercuryResult = mercury;
			nickelResult = nickel;
			leadResult = lead;
			zincResult = zinc;	
	}
	// Standard Constructor
	/**
	 * Builds an analysis with the laboratory results of the nine heavy metals using random numbers.
	 * @param industryName A string with the industry name.
	 * @param laboratoryName A string with the name of the laboratory.
	 * @param sampleNumber A 4 character string sample number.
	 * @param sampleDate A string with the date (DDMMYYYY) when the sample of waste water was obtained.
	 * @param demo A string containing the information to enable the demo option.
	 */
	LabResults(String industryName, String laboratoryName, String sampleNumber, String sampleDate, String demo)
	{
		super(industryName, laboratoryName, sampleNumber, sampleDate);
		optionDemo = demo;
		arsenicResult = ( 1 * Math.random() );
		cadmiumResult = ( 1 * Math.random() );
		cyanidesResult = ( 3 * Math.random() );
		copperResult = ( 7 * Math.random() );
		chromiumResult = (2 * Math.random() );
		mercuryResult = ( Math.random() );
		nickelResult = ( 5 + Math.random() );
		leadResult = (5 + Math.random());
		zincResult = (21 + Math.random());	
	}
	/*Getters and Setters*/
	/**
	 * Gets the observed concentration of Arsenic in mg/L in the sample of waste water.
	 * @return The laboratory result of the arsenic concentration.
	 */
	public double getArsenicResult()
	{
		return arsenicResult;
	}
	/**
	 * Gets the observed concentration of Cadmium in mg/L in the sample of waste water.
	 * @return The laboratory result of the cadmium concentration.
	 */
	public double getCadmiumResult()
	{
		return cadmiumResult;
	}
	/**
	 * Gets the observed concentration of Cyanides in mg/L in the sample of waste water.
	 * @return The laboratory result of the cyanides concentration.
	 */
	public double getCyanidesResult()
	{
		return cyanidesResult;
	}	
	/**
	 * Gets the observed concentration of Copper in mg/L in the sample of waste water.
	 * @return The laboratory result of the copper concentration.
	 */
	public double getCopperResult()
	{
		return copperResult;
	}
	/**
	 * Gets the observed concentration of Chromium in mg/L in the sample of waste water.
	 * @return The laboratory result of the chromium concentration.
	 */
	public double getChromiumResult()
	{
		return chromiumResult;
	}
	/**
	 * Gets the observed concentration of Mercury in mg/L in the sample of waste water.
	 * @return The laboratory result of the mercury concentration.
	 */
	public double getMercuryResult()
	{
		return mercuryResult;
	}
	/**
	 * Gets the observed concentration of Nickel in mg/L in the sample of waste water.
	 * @return The laboratory result of the nickel concentration.
	 */
	public double getNickelResult()
	{
		return nickelResult;
	}
	/**
	 * Gets the observed concentration of Lead in mg/L in the sample of waste water.
	 * @return The laboratory result of the lead concentration.
	 */
	public double getLeadResult()
	{
		return leadResult;
	}
	/**
	 * Gets the observed concentration of Zinc in mg/L in the sample of waste water.
	 * @return The laboratory result of the zinc concentration.
	 */
	public double getZincResult()
	{
		return zincResult;
	}
	/**
	 * Gets a boolean result on whether the laboratory results have been subject to the compliance test
	 * of maximum levels allowed of heave metal concentrations according the NOM-001-SEMARNAT-1996.
	 * @return 
	 */
	public boolean getVerificationStatus()
	{
		return verificationStatus;
	}
	/**
	 * Sets a boolean result on whether the laboratory results have been subject to the compliance test
	 * of maximum levels allowed of heave metal concentrations according the NOM-001-SEMARNAT-1996.
	 * @return
	 */
	public void setVerificationStatus(boolean booleanResult)
	{
		this.verificationStatus = booleanResult;
	}
	/**
	 * Prints in the console the laboratory results of this sample of waste water.
	 */
	public void getResults()
	{
		System.out.println("Waste Water Discharge Test Results\n");
		System.out.println("Sample No.: " + getSampleNumber());
		System.out.println("Sample Date: " + getSampleDate());
		System.out.printf("\nPollutant\tConcentration\tUnits\n");
		System.out.printf("Arsenic:\t%2.4f\t\tmg/L\n", arsenicResult);
		System.out.printf("Cadmium:\t%2.4f\t\tmg/L\n", cadmiumResult);
		System.out.printf("Cyanides:\t%2.4f\t\tmg/L\n", cyanidesResult);
		System.out.printf("Copper:\t\t%2.4f\t\tmg/L\n", copperResult);
		System.out.printf("Chromium:\t%2.4f\t\tmg/L\n", chromiumResult);
		System.out.printf("Mercury:\t%2.4f\t\tmg/L\n", mercuryResult);
		System.out.printf("Nickel:\t\t%2.4f\t\tmg/L\n", nickelResult);
		System.out.printf("Lead:\t\t%2.4f\t\tmg/L\n", leadResult);
		System.out.printf("Zinc:\t\t%2.4f\t\tmg/L\n", zincResult);
	}
	/*public String toString()
	{
		return ("Industry name:       " +  getIndustryName() + "\n" +
				"Laboratory name:     " + getLaboratoryName() + "\n" + 
				"Sample number:       " + getSampleNumber() + "\n" +
				"Sample date:         " + getSampleDate() + "\n" +
				"Verified analysis:   " + getVerificationStatus() + "\n");
	}*/
}
