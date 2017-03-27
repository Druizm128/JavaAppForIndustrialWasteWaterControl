/* File: AddXMLAnalysis.java */
import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

/**
 * This class allows to add an analysis to the program by parsing an XML document containing the laboratory results from a sample of waste water discharges.
 * @author danteruiz
 * */
public class AddXMLAnalysis  {
	/* Instance variables */
	/** Stores the text content from the industry name node*/
	private String parsedIndustryName;
	/** Stores the text content from the sample number node*/
	private String parsedSampleNumber;
	/** Stores the text content from the laboratory name node*/
	private String parsedLaboratoryName;
	/** Stores the text content from the sample date node*/
	private String parsedSampleDate;
	/** Stores the text content from the arsenic result node in the form of a double type */
	private double parsedArsenicResult;
	/** Stores the text content from the cadmium result node in the form of a double type */
	private double parsedCadmiumResult;
	/** Stores the text content from the chromium result node in the form of a double type */
	private double parsedChromiumResult;
	/** Stores the text content from the copper result node in the form of a double type */
	private double parsedCopperResult;
	/** Stores the text content from the cyanides result node in the form of a double type */
	private double parsedCyanidesResult;
	/** Stores the text content from the lead result node in the form of a double type */
	private double parsedLeadResult;
	/** Stores the text content from the mercury result node in the form of a double type */
	private double parsedMercuryResult;
	/** Stores the text content from the nickel result node in the form of a double type */
	private double parsedNickelResult;
	/** Stores the text content from the zinc result node in the form of a double type */
	private double parsedZincResult;

	/* Getters */
	/** Get the parsed industry name.
	 * @return A string with the industry name. */
	public String getParsedIndustryName() {
		return parsedIndustryName;
	}
	/** Get the parsed sample number.
	 * @return A string with the 4 character sample number. */
	public String getParsedSampleNumber() {
		return parsedSampleNumber;
	}
	/** Get the parsed laboratory name.
	 * @return A string with the industry name. */
	public String getParsedLaboratoryName() {
		return parsedLaboratoryName;
	}
	/** Get the parsed sample date.
	 * @return A string with the parsed sample date.*/
	public String getParsedSampleDate() {
		return parsedSampleDate;
	}
	/** Get the parsed arsenic result.
	 * @return A double with the parsed arsenic result.*/
	public double getParsedArsenicResult() {
		return parsedArsenicResult;
	}
	/** Get the parsed cadmium result.
	 * @return A double with the parsed cadmium result.*/
	public double getParsedCadmiumResult() {
		return parsedCadmiumResult;
	}
	/** Get the parsed chromium result
	 * @return A double with the parsed chromium result.*/
	public double getParsedChromiumResult() {
		return parsedChromiumResult;
	}
	/** Get the parsed copper result
	 * @return A double with the parsed copper result.*/
	public double getParsedCopperResult() {
		return parsedCopperResult;
	}
	/** Get the parsed cyanides result
	 * @return A double with the parsed cyanides result.*/
	public double getParsedCyanidesResult() {
		return parsedCyanidesResult;
	}
	/** Get the parsed lead result
	 * @return A double with the parsed lead result.*/
	public double getParsedLeadResult() {
		return parsedLeadResult;
	}
	/** Get the parsed mercury result
	 * @return A double with the parsed mercury result.*/
	public double getParsedMercuryResult() {
		return parsedMercuryResult;
	}
	/** Get the parsed nickel result
	 * @return A double with the parsed nickel result.*/
	public double getParsedNickelResult() {
		return parsedNickelResult;
	}
	/** Get the parsed zinc result
	 * @return A double with the parsed zinc result.*/
	public double getParsedZincResult() {
		return parsedZincResult;
	}
	
	/* Parse the document and store the information in fields */
	/**
	 * Parses the laboratory results XML document using a DOM parser.
	 * @param document The laboratory results DOM
	 * @throws FileNotFoundException
	 */
	public void parseDocument(Document document) throws FileNotFoundException {
		//General details
		ArrayList<String> data = new ArrayList<String>();
		
		NodeList generalDetails = document.getDocumentElement().getChildNodes();

		Node industryNameNode = generalDetails.item(1); // CEDAN
		Node sampleNumberNode = generalDetails.item(3); // SAMPLE NUMBER
		Node laboratoryNameNode = generalDetails.item(5); // LABORATORYS NUMBER
		Node sampleDateNode = generalDetails.item(7); // SAMPLE DATE
		
		parsedIndustryName = industryNameNode.getTextContent();
		parsedSampleNumber = sampleNumberNode.getTextContent();
		parsedLaboratoryName = laboratoryNameNode.getTextContent();
		parsedSampleDate = sampleDateNode.getTextContent();
		
		// Laboratory results
		
		NodeList resultsList = generalDetails.item(9).getChildNodes();
		
		Node arsenicNode = resultsList.item(1);
		Node cadmiumNode = resultsList.item(3);
		Node chromiumNode = resultsList.item(5);
		Node copperNode = resultsList.item(7);
		Node cyanidesNode = resultsList.item(9);
		Node leadNode = resultsList.item(11);
		Node mercuryNode = resultsList.item(13);
		Node nickelNode = resultsList.item(15);
		Node zincNode = resultsList.item(17);
		
		parsedArsenicResult = Double.parseDouble( arsenicNode.getTextContent() );
		parsedCadmiumResult = Double.parseDouble( cadmiumNode.getTextContent() );
		parsedChromiumResult = Double.parseDouble( chromiumNode.getTextContent() );
		parsedCopperResult = Double.parseDouble( copperNode.getTextContent() );
		parsedCyanidesResult = Double.parseDouble( cyanidesNode.getTextContent() );
		parsedLeadResult = Double.parseDouble( leadNode.getTextContent() );
		parsedMercuryResult = Double.parseDouble( mercuryNode.getTextContent() );
		parsedNickelResult = Double.parseDouble( nickelNode.getTextContent() );
		parsedZincResult = Double.parseDouble( zincNode.getTextContent() );
	}
	
	// Declaration of the getDocumentMethod
	/**
	 * Loads in memory the XML laboratory results using a DOM parser.
	 * @param fileString The name of the file (nameOfTHeFile.xml)
	 * @return A document with the information of the laboratory results.
	 * @throws FileNotFoundException
	 * @throws Exception
	 */
	public static Document getDocument(String fileString) throws FileNotFoundException, Exception
	{
			File fileSelection = new File("LaboratoryResultsInXML/" + fileString);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setValidating(false);
			factory.setIgnoringComments(true);
			factory.setIgnoringElementContentWhitespace(true);
			DocumentBuilder db = factory.newDocumentBuilder();
			return db.parse(fileSelection);

	}
	
	/* List all XML laboratory analysis stored in directory */
	/**
	 * Lists all the laboratory analysis XML files stored in the directory named LaboratoryResultsInXML in the Project file.
	 */
	public void listFilesInDirectory() {
		File directory = new File("LaboratoryResultsInXML");
		File[] allFiles = directory.listFiles();
		System.out.print("\nFile name: ");
		
		for (int i = 0; i < allFiles.length; i++){
			System.out.printf("\n%s. %s",i+1, allFiles[i].getName());
		}
		System.out.println("");
	}
}
