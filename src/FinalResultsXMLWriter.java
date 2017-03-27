
// Imports
import java.io.*;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;


/**The new document will contain information of the observed concentrations of heavy metals pollution obtained at 
 * the laboratory. It also will show the compliance results of each pollutant according to the maximum limits allowed 
 * outlined in the Mexican norm of quality of water that will be produced after the laboratory results are verified by 
 * the National Commission of Water Waste Water Discharges Compliance Application.
 * */
public class FinalResultsXMLWriter
{
	public void writeXML(LabResults selectedAnalysis, ComplianceResults selectedVerifiedAnalysis)
	{
		String sampleNumber = selectedAnalysis.getSampleNumber();
		String industryName = selectedAnalysis.getIndustryName();
		String date = selectedAnalysis.getSampleDate();
		
		File fileName = new File("AnalysisXMLDocuments/" + industryName + "_" + date + "_" + sampleNumber + ".xml");
		
		
		XMLStreamWriter xw =  null; 
		XMLOutputFactory xof = XMLOutputFactory.newInstance();
		try 
		{
			xw = xof.createXMLStreamWriter(new FileWriter(fileName));
		    xw.writeStartDocument("1.0"); //Start document
		    
		    // Start Root element <test_results>
		    xw.writeStartElement("analysis");
		    
		    // Industry name
		    xw.writeStartElement("industryName");
		    xw.writeCharacters(selectedAnalysis.getIndustryName());
		    xw.writeEndElement();
		    
		    // Sample number
		    xw.writeStartElement("sampleNumber");
		    xw.writeCharacters(selectedAnalysis.getSampleNumber());
		    xw.writeEndElement();
		    
		    // Laboratory name
		    xw.writeStartElement("laboratoryName");
		    xw.writeCharacters(selectedAnalysis.getLaboratoryName());
		    xw.writeEndElement();
		    
		    // Sample date
		    xw.writeStartElement("sampleDate");
		    xw.writeCharacters(selectedAnalysis.getSampleDate());
		    xw.writeEndElement();
		    
		    // Start results
		    xw.writeStartElement("results");
		    
		    //arsenic
		    xw.writeStartElement("arsenic");
		    //arsenicResult
		    xw.writeStartElement("arsenicResult");
		    xw.writeCharacters(Double.toString(selectedAnalysis.getArsenicResult()));
		    xw.writeEndElement();
		    //arsenicComplianceResult
		    xw.writeStartElement("arsenicComplianceResult");
		    xw.writeCharacters(selectedVerifiedAnalysis.getArsenicComplianceResult());
		    xw.writeEndElement();
		    xw.writeEndElement();
		    
		    //cadmium
		    xw.writeStartElement("cadmium");
		    //cadmiumResult
		    xw.writeStartElement("cadmiumResult");
		    xw.writeCharacters(Double.toString(selectedAnalysis.getCadmiumResult()));
		    xw.writeEndElement();
		    //cadmiumComplianceResult
		    xw.writeStartElement("cadmiumComplianceResult");
		    xw.writeCharacters(selectedVerifiedAnalysis.getCadmiumComplianceResult());
		    xw.writeEndElement();
		    xw.writeEndElement();
		    
		    //cyanides
		    xw.writeStartElement("cyanides");
		    //cyanidesResult
		    xw.writeStartElement("cyanidesResult");
		    xw.writeCharacters(Double.toString(selectedAnalysis.getCyanidesResult()));
		    xw.writeEndElement();
		    //cyanidesComplianceResult
		    xw.writeStartElement("cyanidesComplianceResult");
		    xw.writeCharacters(selectedVerifiedAnalysis.getCyanidesComplianceResult());
		    xw.writeEndElement();
		    xw.writeEndElement();
		    
		    //copper
		    xw.writeStartElement("copper");
		    //copperResult
		    xw.writeStartElement("copperResult");
		    xw.writeCharacters(Double.toString(selectedAnalysis.getCopperResult()));
		    xw.writeEndElement();
		    //copperComplianceResult
		    xw.writeStartElement("copperComplianceResult");
		    xw.writeCharacters(selectedVerifiedAnalysis.getCopperComplianceResult());
		    xw.writeEndElement();
		    xw.writeEndElement();
		    
		    //chromium
		    xw.writeStartElement("chromium");
		    //chromiumResult
		    xw.writeStartElement("chromiumResult");
		    xw.writeCharacters(Double.toString(selectedAnalysis.getChromiumResult()));
		    xw.writeEndElement();
		    //chromiumComplianceResult
		    xw.writeStartElement("chromiumComplianceResult");
		    xw.writeCharacters(selectedVerifiedAnalysis.getChromiumComplianceResult());
		    xw.writeEndElement();
		    xw.writeEndElement();
		    
		    //mercury
		    xw.writeStartElement("mercury");
		    //mercuryResult
		    xw.writeStartElement("mercuryResult");
		    xw.writeCharacters(Double.toString(selectedAnalysis.getMercuryResult()));
		    xw.writeEndElement();
		    //mercuryComplianceResult
		    xw.writeStartElement("mercuryComplianceResult");
		    xw.writeCharacters(selectedVerifiedAnalysis.getMercuryComplianceResult());
		    xw.writeEndElement();
		    xw.writeEndElement();
		    
		    //nickel
		    xw.writeStartElement("nickel");
		    //nickelResult
		    xw.writeStartElement("nickelResult");
		    xw.writeCharacters(Double.toString(selectedAnalysis.getNickelResult()));
		    xw.writeEndElement();
		    //nickelComplianceResult
		    xw.writeStartElement("nickelComplianceResult");
		    xw.writeCharacters(selectedVerifiedAnalysis.getNickelComplianceResult());
		    xw.writeEndElement();
		    xw.writeEndElement();
		    
		    //lead
		    xw.writeStartElement("lead");
		    //leadResult
		    xw.writeStartElement("leadResult");
		    xw.writeCharacters(Double.toString(selectedAnalysis.getLeadResult()));
		    xw.writeEndElement();
		    //leadComplianceResult
		    xw.writeStartElement("leadComplianceResult");
		    xw.writeCharacters(selectedVerifiedAnalysis.getLeadComplianceResult());
		    xw.writeEndElement();
		    xw.writeEndElement();
		    
		    //zinc
		    xw.writeStartElement("zinc");
		    //zincResult
		    xw.writeStartElement("zincResult");
		    xw.writeCharacters(Double.toString(selectedAnalysis.getZincResult()));
		    xw.writeEndElement();
		    //zincComplianceResult
		    xw.writeStartElement("zincComplianceResult");
		    xw.writeCharacters(selectedVerifiedAnalysis.getZincComplianceResult());
		    xw.writeEndElement();
		    xw.writeEndElement();
		    
		    // End results
		    xw.writeEndElement();
		    
		    //Compliance
		    xw.writeStartElement("compliance");
		    xw.writeCharacters(selectedVerifiedAnalysis.getAnalysisOverallComplianceResult());
		    xw.writeEndElement();		    
		   		    
		    // End Root Element <test_results>
		    xw.writeEndElement();
		   
		    xw.writeEndDocument();		  //End document
		    xw.flush();
		    xw.close();
		} 
		catch (Exception e)
		{
			e.getMessage();
		}
		System.out.println("\nAn XML document has been created to store the results of this waste water sample analysis");
		System.out.println("The path of the file is: " + fileName.getAbsolutePath());
		System.out.println();
	}
}
