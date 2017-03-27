/* File: FinalResultsTextWriter.java */

// Imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;

/**
 * This class prints the final results of a waste water sample in a text file after 
 * it has been validated with the compliance test.
 * @author danteruiz
 */
public class FinalResultsTextWriter 
{
	/* Instance variables*/
	// Sample and analysis details
	private String industryNameCSV, sampleNumberCSV, laboratoryNameCSV, sampleDateCSV;
	// Concentrations
	private double arsenicResultCSV, cadmiumResultCSV, cyanidesResultCSV, copperResultCSV, chromiumResultCSV, 
				   mercuryResultCSV, nickelResultCSV,leadResultCSV,zincResultCSV;
	// Compliance
	private String arsenicComplianceResultCSV, cadmiumComplianceResultCSV, cyanidesComplianceResultCSV,
				   copperComplianceResultCSV, chromiumComplianceResultCSV, mercuryComplianceResultCSV, 
				   nickelComplianceResultCSV, leadComplianceResultCSV, zincComplianceResultCSV, 
				   complianceResultCSV;
	/*Constructor*/
	FinalResultsTextWriter(LabResults selectedAnalysis,ComplianceResults verifiedAnalysis) throws NullPointerException
	{
		// Sample details
		this.setIndustryNameTextFile(selectedAnalysis.getIndustryName());
		this.setSampleNumberTextFile(selectedAnalysis.getSampleNumber());
		this.setLaboratoryNameTextFile(selectedAnalysis.getLaboratoryName());
		this.setSampleDateTextFile(selectedAnalysis.getSampleDate());
		// Concentration test results
		this.setArsenicResultTextFile(selectedAnalysis.getArsenicResult());
		this.setCadmiumResultTextFile(selectedAnalysis.getCadmiumResult());
		this.setCyanidesResultTextFile(selectedAnalysis.getCyanidesResult());
		this.setCopperResultTextFile(selectedAnalysis.getCopperResult());
		this.setChromiumResultTextFile(selectedAnalysis.getChromiumResult());
		this.setMercuryResultTextFile(selectedAnalysis.getMercuryResult());
		this.setNickelResultTextFile(selectedAnalysis.getNickelResult());
		this.setLeadResultTextFile(selectedAnalysis.getLeadResult());
		this.setZincResultTextFile(selectedAnalysis.getZincResult());
		// Compliance test results
		this.setArsenicComplianceResultTextFile(verifiedAnalysis.getArsenicComplianceResult());
		this.setCadmiumComplianceResultTextFile(verifiedAnalysis.getCadmiumComplianceResult());
		this.setCyanidesComplianceResultCSV(verifiedAnalysis.getCyanidesComplianceResult());
		this.setCopperComplianceResultCSV(verifiedAnalysis.getCopperComplianceResult());
		this.setChromiumComplianceResultCSV(verifiedAnalysis.getChromiumComplianceResult());
		this.setMercuryComplianceResultCSV(verifiedAnalysis.getMercuryComplianceResult());
		this.setNickelComplianceResultCSV(verifiedAnalysis.getNickelComplianceResult());
		this.setLeadComplianceResultCSV(verifiedAnalysis.getLeadComplianceResult());
		this.setZincComplianceResultCSV(verifiedAnalysis.getZincComplianceResult());
		// Overall compliance result
		this.setComplianceResultCSV(verifiedAnalysis.getAnalysisOverallComplianceResult());
	}
	/*Setters*/
	private void setIndustryNameTextFile(String industryNameCSV) {
		this.industryNameCSV = industryNameCSV;
	}
	private void setSampleNumberTextFile(String sampleNumberCSV) {
		this.sampleNumberCSV = sampleNumberCSV;
	}
	private void setLaboratoryNameTextFile(String laboratoryNameCSV) {
		this.laboratoryNameCSV = laboratoryNameCSV;
	}
	private void setSampleDateTextFile(String sampleDateCSV) {
		this.sampleDateCSV = sampleDateCSV;
	}
	private void setComplianceResultCSV(String complianceResultCSV) {
		this.complianceResultCSV = complianceResultCSV;
	}
	private void setArsenicResultTextFile(double arsenicResultCSV) {
		this.arsenicResultCSV = arsenicResultCSV;
	}
	private void setCadmiumResultTextFile(double cadmiumResultCSV) {
		this.cadmiumResultCSV = cadmiumResultCSV;
	}
	private void setCyanidesResultTextFile(double cyanidesResultCSV) {
		this.cyanidesResultCSV = cyanidesResultCSV;
	}
	private void setCopperResultTextFile(double copperResultCSV) {
		this.copperResultCSV = copperResultCSV;
	}
	private void setChromiumResultTextFile(double chromiumResultCSV) {
		this.chromiumResultCSV = chromiumResultCSV;
	}
	private void setMercuryResultTextFile(double mercuryResultCSV) {
		this.mercuryResultCSV = mercuryResultCSV;
	}
	private void setNickelResultTextFile(double nickelResultCSV) {
		this.nickelResultCSV = nickelResultCSV;
	}
	private void setLeadResultTextFile(double leadResultCSV) {
		this.leadResultCSV = leadResultCSV;
	}
	private void setZincResultTextFile(double zincResultCSV) {
		this.zincResultCSV = zincResultCSV;
	}
	private void setArsenicComplianceResultTextFile(String arsenicComplianceResultCSV) {
		this.arsenicComplianceResultCSV = arsenicComplianceResultCSV;
	}
	private void setCadmiumComplianceResultTextFile(String cadmiumComplianceResultCSV) {
		this.cadmiumComplianceResultCSV = cadmiumComplianceResultCSV;
	}
	private void setCyanidesComplianceResultCSV(String cyanidesComplianceResultCSV) {
		this.cyanidesComplianceResultCSV = cyanidesComplianceResultCSV;
	}
	private void setCopperComplianceResultCSV(String copperComplianceResultCSV) {
		this.copperComplianceResultCSV = copperComplianceResultCSV;
	}
	private void setChromiumComplianceResultCSV(String chromiumComplianceResultCSV) {
		this.chromiumComplianceResultCSV = chromiumComplianceResultCSV;
	}
	private void setMercuryComplianceResultCSV(String mercuryComplianceResultCSV) {
		this.mercuryComplianceResultCSV = mercuryComplianceResultCSV;
	}
	private void setNickelComplianceResultCSV(String nickelComplianceResultCSV) {
		this.nickelComplianceResultCSV = nickelComplianceResultCSV;
	}
	private void setLeadComplianceResultCSV(String leadComplianceResultCSV) {
		this.leadComplianceResultCSV = leadComplianceResultCSV;
	}
	private void setZincComplianceResultCSV(String zincComplianceResultCSV) {
		this.zincComplianceResultCSV = zincComplianceResultCSV;
	}
	/*Getters*/
	private String getIndustryNameCSV() {
		return industryNameCSV;
	}
	private String getSampleNumberCSV() {
		return sampleNumberCSV;
	}
	private String getLaboratoryNameCSV() {
		return laboratoryNameCSV;
	}
	private String getSampleDateCSV() {
		return sampleDateCSV;
	}
	private double getArsenicResultCSV() {
		return arsenicResultCSV;
	}
	private double getCadmiumResultCSV() {
		return cadmiumResultCSV;
	}
	private double getCyanidesResultCSV() {
		return cyanidesResultCSV;
	}
	private double getCopperResultCSV() {
		return copperResultCSV;
	}
	private double getChromiumResultCSV() {
		return chromiumResultCSV;
	}
	private double getMercuryResultCSV() {
		return mercuryResultCSV;
	}
	private double getNickelResultCSV() {
		return nickelResultCSV;
	}
	private double getLeadResultCSV() {
		return leadResultCSV;
	}
	private double getZincResultCSV() {
		return zincResultCSV;
	}
	private String getArsenicComplianceResultCSV() {
		return arsenicComplianceResultCSV;
	}
	private String getCadmiumComplianceResultCSV() {
		return cadmiumComplianceResultCSV;
	}
	private String getCyanidesComplianceResultCSV() {
		return cyanidesComplianceResultCSV;
	}
	private String getCopperComplianceResultCSV() {
		return copperComplianceResultCSV;
	}
	private String getChromiumComplianceResultCSV() {
		return chromiumComplianceResultCSV;
	}
	private String getMercuryComplianceResultCSV() {
		return mercuryComplianceResultCSV;
	}
	private String getNickelComplianceResultCSV() {
		return nickelComplianceResultCSV;
	}
	private String getLeadComplianceResultCSV() {
		return leadComplianceResultCSV;
	}
	private String getZincComplianceResultCSV() {
		return zincComplianceResultCSV;
	}
	private String getComplianceResultCSV() {
		return complianceResultCSV;
	}

	public void printTextFile()
	{
		File fileName = new File("AnalysisTextResults/" + getIndustryNameCSV() + "_" + getSampleDateCSV() + "_" + getSampleNumberCSV() + ".txt");
		
		Formatter textDoc;
		
		try {
			textDoc = new Formatter(fileName);
			textDoc.format("%s\n","National Commission of Water");
			textDoc.format("%s\n","Waste Water Discharges Compliance Results");
			textDoc.format("\n%17s\t%15s\n", "Industry name: ", getIndustryNameCSV());
			textDoc.format("%17s\t%15s\n", "Sample number: ", getSampleNumberCSV());
			textDoc.format("%17s\t%15s\n", "Laboratory name: ", getLaboratoryNameCSV());
			textDoc.format("%17s\t%15s\n", "Sample date: ", getSampleDateCSV());
			textDoc.format("\n%10s\t%13s %10s\n", "Pollutant","Concentration","Compliance");
			textDoc.format("%10s\t%f\t%10s\n", "Arsenic", getArsenicResultCSV(), getArsenicComplianceResultCSV());
			textDoc.format("%10s\t%f\t%10s\n", "Cadmium", getCadmiumResultCSV(), getCadmiumComplianceResultCSV());
			textDoc.format("%10s\t%f\t%10s\n", "Cyanides", getCyanidesResultCSV(), getCyanidesComplianceResultCSV());
			textDoc.format("%10s\t%f\t%10s\n", "Copper", getCopperResultCSV(), getCopperComplianceResultCSV());
			textDoc.format("%10s\t%f\t%10s\n", "Chromium", getChromiumResultCSV(), getChromiumComplianceResultCSV());
			textDoc.format("%10s\t%f\t%10s\n", "Mercury", getMercuryResultCSV(), getMercuryComplianceResultCSV());
			textDoc.format("%10s\t%f\t%10s\n", "Nickel", getNickelResultCSV(), getNickelComplianceResultCSV());
			textDoc.format("%10s\t%f\t%10s\n", "Lead", getLeadResultCSV(), getLeadComplianceResultCSV());
			textDoc.format("%10s\t%f\t%10s\n", "Zinc", getZincResultCSV(), getZincComplianceResultCSV());
			textDoc.format("\n%s%s\n", "Overall compliance result: ", getComplianceResultCSV());
			textDoc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("The analysis was successuflly written to a textfile");
		System.out.println("Path: " + fileName.getAbsolutePath());
		System.out.println();
	}	
}
