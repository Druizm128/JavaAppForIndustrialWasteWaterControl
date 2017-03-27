/* File: ComplianceResults.java */
/**
 * This class contains the methods to verify that the laboratory results comply with the maximum levels allowed of heavy
 * metals in a body of water.
 * @author Dante Ruiz
 */
public class ComplianceResults
{
	/* Constant variables */
	/** The maximum limit allowed of arsenic in a body of water is 0.2 mg/L */
	public static final double MAX_ARSENIC_ALLOWED = 0.2;
	/** The maximum limit allowed of cadmium in a body of water is 0.2 mg/L */
	public static final double MAX_CADMIUM_ALLOWED = 0.2;
	/** The maximum limit allowed of cyanides in a body of water is 2.0 mg/L */
	public static final double MAX_CYANIDES_ALLOWED = 2.0;
	/** The maximum limit allowed of copper in a body of water is 6.0 mg/L */
	public static final double MAX_COPPER_ALLOWED = 6.0;
	/** The maximum limit allowed of chromium in a body of water is 1.0 mg/L */
	public static final double MAX_CHROMIUM_ALLOWED = 1.0;
	/** The maximum limit allowed of mercury in a body of water is 0.1 mg/L */
	public static final double MAX_MERCURY_ALLOWED = 0.01;
	/** The maximum limit allowed of nickel in a body of water is 4.0 mg/L */
	public static final double MAX_NICKEL_ALLOWED = 4.0;
	/** The maximum limit allowed of lead in a body of water is 4.0 mg/L */
	public static final double MAX_LEAD_ALLOWED = 4.0;
	/** The maximum limit allowed of zinc in a body of water is 20.0 mg/L */
	public static final double MAX_ZINC_ALLOWED = 20;

	// Instance variables
	/** Compliance analysis sample number of the laboratory results */
	private String sampleNumberComplianceAnalysis;
	/** Compliance analysis laboratory name of the laboratory results*/
	private String laboratoryNameComplianceAnalysis;
	/** Compliance analysis name of the industry of the laboratory results*/
	private String industryNameComplianceAnalysis;
	/** Compliance analysis date of the laboratory results sample*/
	private String sampleDateComplianceAnalysis;
	/** Compliance results Arsenic of laboratory results in mg/L */
	private String arsenicComplianceResult;
	/** Compliance results Cadmium of laboratory results in mg/L */
	private String cadmiumComplianceResult;
	/** Compliance results Cyanides of laboratory results in mg/L */
	private String cyanidesComplianceResult;
	/** Compliance results Copper of laboratory results in mg/L */
	private String copperComplianceResult;
	/** Compliance results Chromium of laboratory results in mg/L */
	private String chromiumComplianceResult;
	/** Compliance results Mercury of laboratory results in mg/L */
	private String mercuryComplianceResult;
	/** Compliance results Nickel of laboratory results in mg/L */
	private String nickelComplianceResult;
	/** Compliance results Lead of laboratory results in mg/L */
	private String leadComplianceResult;
	/** Compliance results Zinc of laboratory results in mg/L */
	private String zincComplianceResult;
	/** Overall compliance result of laboratory analysis (satisfactory/unsatisfactory)*/
	private String analysisOverallComplianceResult;
	
	/* Getters */
	/**
	 * Get the compliance analysis sample number.
	 * @return The laboratory results sample number.
	 */
	public String getSampleNumberComplianceAnalysis(){
		return sampleNumberComplianceAnalysis;
	}
	/**
	 * Get the compliance analysis laboratory name.
	 * @return The laboratory name.
	 */
	public String getLaboratoryNameComplianceAnalysis(){
		return laboratoryNameComplianceAnalysis;
	}
	/**
	 * Get the compliance analysis industry name.
	 * @return The industry name.
	 */
	public String getIndustryNameComplianceAnalysis(){
		return industryNameComplianceAnalysis;
	}
	/**
	 * Get the sample date compliance analysis
	 * @return The sample date
	 */
	public String getSampleDateComplianceAnalysis(){
		return sampleDateComplianceAnalysis;
	}
	/**
	 * Get the arsenic compliance result
	 * @return complies or exceeds
	 */
	public String getArsenicComplianceResult() {
		return arsenicComplianceResult;
	}
	/**
	 * Get the cadmium compliance result
	 * @return complies or exceeds
	 */
	public String getCadmiumComplianceResult() {
		return cadmiumComplianceResult;
	}
	/**
	 * Get the cyanides compliance result
	 * @return complies or exceeds
	 */
	public String getCyanidesComplianceResult() {
		return cyanidesComplianceResult;
	}
	/**
	 * Get the copper compliance result
	 * @return complies or exceeds
	 */
	public String getCopperComplianceResult() {
		return copperComplianceResult;
	}
	/**
	 * Get the chromium compliance result
	 * @return complies or exceeds
	 */
	public String getChromiumComplianceResult(){
		return chromiumComplianceResult;
	}
	/**
	 * Get the mercury compliance result.
	 * @return complies or exceeds
	 */
	public String getMercuryComplianceResult(){
		return mercuryComplianceResult;
	}
	/**
	 * Get the nickel compliance result.
	 * @return complies or exceeds
	 */
	public String getNickelComplianceResult(){
		return nickelComplianceResult;
	}
	/**
	 * Get the lead compliance result.
	 * @return complies or exceeds
	 */
	public String getLeadComplianceResult() {
		return leadComplianceResult;
	}
	/**
	 * Get the zin compliance result.
	 * @return complies or exceeds
	 */
	public String getZincComplianceResult() {
		return zincComplianceResult;
	}
	/**
	 * Get the overall compliance result
	 * @return satisfactory or unsatisfactory
	 */
	public String getAnalysisOverallComplianceResult() {
		return analysisOverallComplianceResult;
	}
	
	/* Verify laboratory results method*/
	/**
	 * It compares the concentrations of laboratory results with the maximum limits allowed of the NOM-001-SEMARNAT-1996. If all pollutants remain under 
	 * the maximum limits, then the method will allocate a 'satisfactory' or an 'unsatisfactory' overall compliance result. 
	 * @param inputAnalysis The laboratory results object to be tested for compliance of maximum limits allowed of heavy metals.
	 */
	public void verifyAnalysis(LabResults inputAnalysis)
	{
		sampleNumberComplianceAnalysis = inputAnalysis.getSampleNumber();
		laboratoryNameComplianceAnalysis = inputAnalysis.getLaboratoryName();
		industryNameComplianceAnalysis = inputAnalysis.getIndustryName();
		sampleDateComplianceAnalysis = inputAnalysis.getSampleDate();

		arsenicComplianceResult = (inputAnalysis.getArsenicResult() <= MAX_ARSENIC_ALLOWED) ? "complies" : "exceeds";
		cadmiumComplianceResult = (inputAnalysis.getCadmiumResult() <= MAX_CADMIUM_ALLOWED) ? "complies" : "exceeds";
		cyanidesComplianceResult = (inputAnalysis.getCyanidesResult() <= MAX_CYANIDES_ALLOWED) ? "complies" : "exceeds";
		copperComplianceResult = (inputAnalysis.getCopperResult() <= MAX_COPPER_ALLOWED) ? "complies" : "exceeds";
		chromiumComplianceResult = (inputAnalysis.getChromiumResult() <= MAX_CHROMIUM_ALLOWED) ? "complies" : "exceeds";
		mercuryComplianceResult = (inputAnalysis.getMercuryResult() <= MAX_MERCURY_ALLOWED) ? "complies" : "exceeds";
		nickelComplianceResult = (inputAnalysis.getNickelResult() <= MAX_NICKEL_ALLOWED) ? "complies" : "exceeds";
		leadComplianceResult = (inputAnalysis.getLeadResult() <= MAX_LEAD_ALLOWED) ? "complies" : "exceeds";
		zincComplianceResult = (inputAnalysis.getZincResult() <= MAX_ZINC_ALLOWED) ? "complies" : "exceeds";
		
		if( (arsenicComplianceResult=="complies") && (cadmiumComplianceResult=="complies") && (cyanidesComplianceResult=="complies") &&
			(copperComplianceResult=="complies") && (chromiumComplianceResult=="complies") && (mercuryComplianceResult=="complies") &&
			(nickelComplianceResult=="complies") && (leadComplianceResult=="complies") && (zincComplianceResult=="complies"))
		{
			analysisOverallComplianceResult = "Satisfactory";
		} else {
			analysisOverallComplianceResult = "Unsatisfactory";
		}
		
		inputAnalysis.setVerificationStatus(true);
		System.out.println("Compliance of the Maximum Pollution Concentration Levels");
		System.out.println("========================================================");
		System.out.println("Laboratory name: " + laboratoryNameComplianceAnalysis);
		System.out.println("Industry name: " + industryNameComplianceAnalysis);
		System.out.println("Sample number: " + sampleNumberComplianceAnalysis);
		System.out.println("Sample date: " + sampleDateComplianceAnalysis);
		System.out.println("");
		System.out.format("%10s\t%10s\n","Pollutant","Result");
		System.out.format("%10s\t%10s\n","Arsenic:",arsenicComplianceResult);
		System.out.format("%10s\t%10s\n","Cadmium:",cadmiumComplianceResult);
		System.out.format("%10s\t%10s\n","Cyanides:",cyanidesComplianceResult);
		System.out.format("%10s\t%10s\n","Copper:",copperComplianceResult);
		System.out.format("%10s\t%10s\n","Chromium:",chromiumComplianceResult);
		System.out.format("%10s\t%10s\n","Mercury:",mercuryComplianceResult);
		System.out.format("%10s\t%10s\n","Nickel:",nickelComplianceResult);
		System.out.format("%10s\t%10s\n","Lead:",leadComplianceResult);
		System.out.format("%10s\t%10s\n","Zinc:",zincComplianceResult);
		System.out.println("\nOverall Result: " +  analysisOverallComplianceResult);
	}	
}
