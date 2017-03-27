/*
 * File: App.java
 */
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.w3c.dom.Document;

import CustomExceptions.AnalysisIsNotValidatedException;
import CustomExceptions.BlankIndustryNameException;
import CustomExceptions.BlankSampleNumberException;
import CustomExceptions.InvalidSampleNumberException;
import CustomExceptions.VerifiedAnalysisDoesNotExistException;
import Duties.DutiesCalculator;
import sun.management.ExtendedPlatformComponent;

/*DESCRIPTION OF THE PROGRAM*/
/**
 * Description: The following class runs the COMPLIANCE APPLICATION FOR THE MONITORING AND CONTROL OF WASTE WATER DISCHARGES TO RECEIVING
 * BODIES OF WATER. This prototype is a simulator of the current 
 * waste water discharges regulation in Mexico. Private industries around the country discharge their waste waters coming from their
 * manufacturing processes to receiving bodies of water, such as: rivers, lakes, aquifers, and oceans. With the final objective
 * of monitoring and controlling the pollution of bodies of water and to encourage the clean production of industries, the government
 * demands that each fiscal quarter the industries that discharge waste water provide an analytical results of a sample of waste water. 
 * The observed concentrations of heavy metals (pollutants) are compared against their maximum limits outlined in a clean water norm.
 * If the observed concentrations of pollution are under the maximum limits, then the companies are exempted of the payment of duties.
 * Nonetheless, if the observed concentrations are above the maximum limits the corresponding industry shall pay duties for all the 
 * volume of water they discharged to the body of water. The objective of this economic mechanism is to create the appropriate 
 * incentives for industrial companies to include waste water treatment before they discharge it to a body of water.
 * @author Dante Guillermo Ruiz Martinez
 * @version 1.0
 */
public class App {
	/*CONSTANTS*/
	/** These constants keep track of the option cases that may be selected from the console menu*/
	private static final int ADD_TEST_ANALYSIS = 1;
	private static final int ADD_TEST_ANALYSIS_FROM_AN_XML_FILE = 2;
	private static final int RUN_COMPLIANCE_ANALYSIS = 3;
	private static final int PRINT_VERIFIED_TEST_ANALYSIS = 4;
	private static final int CALCULATE_TOTAL_WASTE_WATER_DUTIES = 5;
	private static final int LIST_REGISTERED_ANALYSIS = 6;
	private static final int SHOW_MAXIMUM_LEVELS_ALLOWED = 7;
	private static final int QUIT = 0;
	
	/* INSTANCE VARIABLES */
	private ArrayList<LabResults> listOfLaboratoryAnalysis = new ArrayList<LabResults>();
	private ArrayList<ComplianceResults> listOfAnalysisComplianceResults = new ArrayList<ComplianceResults>();
	
	/* MAIN METHOD */
	/**This method launches the Waste Water Discharges Compliance Application
	 * @throws InputMismatchException */
	public static void main(String[] args) {
		
		App app = new App();
		
		System.out.println("===================================== NATIONAL COMMISSION OF WATER =====================================");
		System.out.println();
		System.out.println("                         COMPLIANCE APPLICATION FOR THE MONITORING AND CONTROL                          ");
		System.out.println("                        OF WASTE WATER DISCHARGES TO RECEIVING BODIES OF WATER                          ");
		System.out.println();
		while(true){
			int selection = app.getMenuSelection();
			if (selection == QUIT){
				break;
			} else {
				switch(selection) {
					case ADD_TEST_ANALYSIS:
						app.addAnalysis();
						break;
					case ADD_TEST_ANALYSIS_FROM_AN_XML_FILE:
						app.addAnalysisFromXMLFile();
						break;
					case RUN_COMPLIANCE_ANALYSIS:
						app.runComplianceText();
						break;
					case PRINT_VERIFIED_TEST_ANALYSIS:
						app.printFinalResultsToTextFile();
						break;
					case CALCULATE_TOTAL_WASTE_WATER_DUTIES:
						app.calculateWasteWaterDuties();
						break;
					case LIST_REGISTERED_ANALYSIS:
						app.listRegisteredAnalysis();
						break;
					case SHOW_MAXIMUM_LEVELS_ALLOWED:
						app.displayMaximumLevelsAllowed();
						break;
					case QUIT:
						break;
					default:
						System.out.println("Invalid selection");
						break;
				}
			}
		}
	}
	/** This method launches a console menu selection with the following options:
	 *  1. Add the results of a new laboratory analysis of waste water discharges.
	 *  2. Add the results of a new laboratory analysis of waste water discharges from an XML file.
	 *  3. Run a compliance analysis against the norm of quality of water in receiving bodies of waste water.
	 *  4. Print laboratory and compliance results of an analysis to a text file.
	 *  5. Calculate waste water discharges duties.
	 *  6. List of registered analysis.
	 *  7. Display the maximum levels allowed of pollutants in receiving bodies of waste water.
	 *  0. Quits the application 
	 * @throws OptionMenuDoesNotExist */
	public int getMenuSelection()  {	//throws InputMismatchException
		int selection = -1;
		Scanner scannerForMenuSelection = new Scanner(System.in);
		System.out.print("\n=============================================== MAIN MENU ===============================================");
		System.out.println("\nPlease select an option from the menu:\n");
		System.out.println("1. Add the results of a new laboratory analysis of waste water discharges.");
		System.out.println("2. Add the results of a new laboratory analysis of waste water discharges from an XML file.");
		System.out.println("3. Run a compliance analysis against the norm of quality of water in receiving bodies of waste water");
		System.out.println("4. Print laboratory and compliance results of an analysis to a text file.");
		System.out.println("5. Calculate waste water discharges duties.");
		System.out.println("6. List of registered analysis.");
		System.out.println("7. Display the maximum levels allowed of pollutants in receiving bodies of waste water.");
		System.out.println("0. Quit");
		System.out.print("Enter number option: ");
		
		try {
			selection = scannerForMenuSelection.nextInt();
		} catch (InputMismatchException ime) {
			getMenuSelection();
		} 
		return selection;
	}
	/** This method adds a new analysis to an ArrayList that stores Analysis type objects 
	 * to keep track of their information while the application is running. */
	public void addAnalysis() throws InputMismatchException
	{	
		// Local Variables
		String scannedLaboratoryName, scannedIndustryName, scannedSampleNumber, scannedDate;
		String optionResult = new String("");
		double arsenic, cadmium, cyanides, copper, chromium, mercury, nickel, lead, zinc;
		int analysisLabResultsIndex;
		LabResults analysis = null;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n========================================== ADD ANALYSIS ================================================");
		System.out.println("\nInstructions: To add a new analysis please enter the name of the industry that discharged the waste water");
		System.out.println("to a receiving body of water, then enter the name of the laboratory that obtained the sample of waste water,");
		System.out.println("then enter the identifier of the sample according to the laboratory management system.");
		
		// INDUSTRY NAME
		System.out.print( "\nEnter the industry name: " );
		scannedIndustryName = scanner.nextLine();
		while( scannedIndustryName.equals("") ){
			System.out.print( "Please enter the name of the industry: " );
			scannedIndustryName = scanner.nextLine();
		}
		// LABORATORY NAME
		System.out.print( "Enter the laboratory name: " );
		scannedLaboratoryName = scanner.nextLine();
		while( scannedLaboratoryName.equals("") ){
			System.out.print( "Please enter the name of the laboratory: " );
			scannedLaboratoryName = scanner.nextLine();
		}
		// SAMPLE NUMBER
		System.out.print( "Enter sample number (4 character ID): " );
		scannedSampleNumber = scanner.nextLine();
		while ( scannedSampleNumber.length() != 4 ){
			System.out.print( "Please enter a valid 4 character ID: " );
			scannedSampleNumber = scanner.nextLine();
		}
		// SAMPLE DATE
		System.out.print( "Enter the date of the sample extraction (DDMMYYYY): " );
		scannedDate = scanner.nextLine();
		while ( scannedDate.length() != 8 ){
			System.out.print( "Please enter a date in the valid format (DDMMYYYY): " );
			scannedDate = scanner.nextLine();
		}	
		// NO DUPLICATE SAMPLES VERIFICATION
		analysisLabResultsIndex = findAnalysisLabResults( scannedSampleNumber , scannedIndustryName );
		if ( analysisLabResultsIndex != -1 ){
			System.out.println("The analysis is already in the system. Please try again. ");
		} else {
			// ENTER LABORATORY RESULTS
			System.out.println("\nHow do you wish to add the new analysis: ");
			System.out.println("1. Type NEW to enter the result of each of the 9 pollutants.");
			System.out.println("2. Type DEMO to create the results of each of the 9 pollutants with random numbers.");
			optionResult = scanner.nextLine();
			if( optionResult.compareToIgnoreCase("NEW") == 0){
				try {
					System.out.println("Start entering pollutants' concentration:");
					System.out.print("Enter arsenic (mg/L): ");
					arsenic = scanner.nextDouble();
					System.out.print("Enter cadmium (mg/L): ");			
					cadmium = scanner.nextDouble();
					System.out.print("Enter cyanides (mg/L): ");	
					cyanides = scanner.nextDouble();
					System.out.print("Enter copper (mg/L): ");
					copper = scanner.nextDouble();
					System.out.print("Enter chromium (mg/L): ");
					chromium = scanner.nextDouble();
					System.out.print("Enter mercury (mg/L): ");
					mercury = scanner.nextDouble();
					System.out.print("Enter nickel (mg/L): ");
					nickel = scanner.nextDouble();
					System.out.print("Enter lead (mg/L): ");
					lead = scanner.nextDouble();
					System.out.print("Enter zinc (mg/L): ");
					zinc = scanner.nextDouble();
					analysis = new LabResults(scannedIndustryName, scannedLaboratoryName, scannedSampleNumber, scannedDate, arsenic, cadmium, cyanides, copper, chromium, mercury, nickel, lead, zinc);
					listOfLaboratoryAnalysis.add( analysis );
					System.out.print( "\nNew analysis was added to the system.\n" );
				} catch (InputMismatchException ime) {
					System.out.println("Wrong format. Please capture numbers and try again.");
					getMenuSelection();
				}
			} else if (optionResult.compareToIgnoreCase("DEMO") == 0) {
				analysis = new LabResults( scannedIndustryName, scannedLaboratoryName, scannedSampleNumber, scannedDate, optionResult);
				listOfLaboratoryAnalysis.add( analysis );
				System.out.print( "\nNew analysis was added to the system.\n" );
			} else {
				System.out.println("Wrong selection. You need to type NEW or DEMO. Please try again.");
				getMenuSelection();
			}
		}
	}
	/* ADD ANALYSIS FROM AN XML FILE */
	/**
	 * This method adds an analysis from an XML file. It calls the AddXMLAnalysis class and creates an object that
	 * parses the XML file and stores the information on field variables, that later are called by this method to
	 * create a LaboratoryAnalysis object.
	 */
	private void addAnalysisFromXMLFile() {
		LabResults analysis = null;
		AddXMLAnalysis machine = new AddXMLAnalysis();
		Scanner scannerXMLFileName = new Scanner(System.in);
		// Welcome message
		System.out.println("\n=========================== LOAD A NEW LABORATORY RESULT FROM AN XML DOCUMENT ===========================");
		// Instructions
		System.out.println("The following is a list of all XML documents containing laboratory results in the default directory:");
		// Display all stored analysis in LaboratoryResultsInXML (files)
		machine.listFilesInDirectory();
		// Select a file by entering it to the console
		System.out.println("\nChoose the XML file that you want to parse and add to the Laboratory Results in the system: ");
		
		try{
			System.out.print("Enter the file name: ");
			String stringFile = scannerXMLFileName.nextLine();
			// Create the dom document
			Document xmlDocument = machine.getDocument(stringFile);
			System.out.println("The document was successfully loaded into the system.");
			// Start parsing results by node
			System.out.println("Starting to parse results...");
			machine.parseDocument(xmlDocument);
			// Send a message to the user that the XML file has been added to the list of analysis
			analysis = new LabResults(machine.getParsedIndustryName(),machine.getParsedLaboratoryName(),
									  machine.getParsedSampleNumber(),machine.getParsedSampleDate(),machine.getParsedArsenicResult(),
									  machine.getParsedCadmiumResult(),machine.getParsedCyanidesResult(),machine.getParsedCopperResult(),
									  machine.getParsedChromiumResult(),machine.getParsedMercuryResult(),machine.getParsedNickelResult(),
									  machine.getParsedLeadResult(),machine.getParsedZincResult()
									  );
			listOfLaboratoryAnalysis.add( analysis );
			System.out.println("\nThe new laboratory results were successufully created. You may now see them in the list of analysis.\n");
		} catch(FileNotFoundException fnfe) {
			System.out.println("Wrong file name. Please try again.");
			getMenuSelection();
		} catch(Exception e) {
			System.out.println("An exception has occured. Please try again!");
			getMenuSelection();
		}
	}
	/* FIND LABORATORY ANALYSIS RESULTS  */
	/**
	 * This method searches in an ArrayList that contains LaboratoryResults for the resulting analysis that 
	 * matches the parameters of Sample Number and Industry Name. If the method finds a matching analysis it
	 * will return an index integer number with the corresponding position of the analysis in the ArrayList.
	 * If it does not find the analysis it will return a value of -1.
	 * @param scannedSampleNumber The sample number of the analysis to be located.
	 * @param scannedIndustryName The name of the industry of the analysis to be located.
	 * @return The position of the LaboratoryAnalysis in the list of laboratory analysis ArrayList.
	 */
	public int findAnalysisLabResults(String scannedSampleNumber,String scannedIndustryName)
	{
		int index = -1;
		for(int i = 0 ; i < listOfLaboratoryAnalysis.size() ; i++){
			if(listOfLaboratoryAnalysis.get(i).getSampleNumber().equals(scannedSampleNumber)
			&& listOfLaboratoryAnalysis.get(i).getIndustryName().equals(scannedIndustryName))
			{
				index = i;
				break;
			}
		}
		return index;	
	}
	/* RUN A COMPLIANCE TEST */
	/**
	 * This method performs a compliance test to each pollutant in the indicated analysis.
	 * The user must select a matching sample number and name of industry from the list of analysis displayed.
	 * Such list contains all the analysis that have been entered into the system.
	 */
	public void runComplianceText()
	{
		// Local variables
		String sampleNumberSelection = "", industryNameSelection = "";
		int sampleIndex = -1;
		Scanner findScanner = new Scanner(System.in);
		ComplianceResults complianceResult = new ComplianceResults();
		FinalResultsXMLWriter analysisWriter = new FinalResultsXMLWriter();
		
		
		System.out.println("\n=============== RUN A COMPLIANCE TEST AGAINST THE MAXIMUM LEVELS ALLOWED OF POLLUTANTS ===============");
		// List all analysis of waste water discharges in inventory
		listRegisteredAnalysis();
		
		// Choose an analysis of waste water entering the industry name and sample number
		System.out.println("Select the analyisis to verify its compliance against the laws.");
		try {
			System.out.print("Enter industry name: ");
			industryNameSelection = findScanner.nextLine();
			if(industryNameSelection.compareToIgnoreCase("") == 0) {
				throw new BlankIndustryNameException();
			}
			System.out.print("Enter sample number: ");
			sampleNumberSelection = findScanner.nextLine();
			if(sampleNumberSelection.compareToIgnoreCase("") == 0){
				throw new BlankSampleNumberException();
			}
			if(sampleNumberSelection.length() != 4){
				throw new InvalidSampleNumberException();
			}
			sampleIndex = findAnalysisLabResults(sampleNumberSelection,industryNameSelection);
			if (sampleIndex == -1){
				throw new AnalysisIsNotValidatedException();
			} else {
				complianceResult.verifyAnalysis(listOfLaboratoryAnalysis.get(sampleIndex));
				listOfAnalysisComplianceResults.add(complianceResult);
			}
			System.out.println("Validating analysis: " + sampleNumberSelection + "\t" + industryNameSelection);
			// Write the analysis to an XML document
			analysisWriter.writeXML(listOfLaboratoryAnalysis.get(sampleIndex), complianceResult);
			System.out.println("The analysis was stored in an XML file.");
		} catch (BlankIndustryNameException bine) {
			System.out.println(bine.toString());
			getMenuSelection();
		} catch (BlankSampleNumberException bsne) {
			System.out.println(bsne.toString());
			getMenuSelection();
		} catch (InvalidSampleNumberException isne){
			System.out.println(isne.toString());
			getMenuSelection();
		} catch (AnalysisIsNotValidatedException ainve) {
			System.out.println(ainve.toString());
			getMenuSelection();
		} catch (ArrayIndexOutOfBoundsException aioobe) {
			System.out.println("An exception has occurred. Please try again.");
			getMenuSelection();
		} catch (Exception e) {
			System.out.println("An exception has occurred. Please try again!");
			getMenuSelection();
		}		
		
	}
	/*PRINT FINAL RESULTS TO TEXT FILE*/
	/**
	 * This method prints a text file containing the analytical results of a waste water sample.
	 * The information presented in the text file includes pollution concentrations of heavy metals,
	 * compliance results that verify that each pollutant observed concentration is under the maximum
	 * levels permitted by the federal norms.
	 */
	public void printFinalResultsToTextFile()
	{
		// Local variables
		LabResults analysis = null ;
		ComplianceResults verifiedAnalysis = null;
		String sampleNumber = "", industryName = "";
		int analysisIndex, verifiedAnalysisIndex;
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("\n======================== PRINT ANALYSIS AND COMPLIANCE RESULTS TO A TEXT FILE ========================");
		// List all verified analysis
		listComplianceResults();
		
		// Choose an analysis of waste water to be printed by entering the industry name and the sample number
		try {
			System.out.print("Enter industry name: ");
			industryName = scanner.nextLine();
			if(industryName.compareToIgnoreCase("") == 0) {
				throw new BlankIndustryNameException();
			}
			System.out.print("Enter sample number: ");
			sampleNumber = scanner.nextLine();
			if(sampleNumber.compareToIgnoreCase("") == 0){
				throw new BlankSampleNumberException();
			}
			if(sampleNumber.length() != 4){
				throw new InvalidSampleNumberException();
			}			
			// Search the analysis
			analysisIndex = findAnalysisLabResults(sampleNumber, industryName);
			verifiedAnalysisIndex = findAnalysisComplianceResults(sampleNumber,industryName);
			if (verifiedAnalysisIndex == -1){
				throw new VerifiedAnalysisDoesNotExistException();
			} else {
				analysis = listOfLaboratoryAnalysis.get(analysisIndex);
				verifiedAnalysis = listOfAnalysisComplianceResults.get(verifiedAnalysisIndex);
			}
			// Print the corresponding analysis to a text file
			FinalResultsTextWriter textFile = new FinalResultsTextWriter(analysis, verifiedAnalysis);
			textFile.printTextFile();
		} catch (BlankIndustryNameException wse) {
			System.out.println(wse.toString());
			getMenuSelection();
		} catch (BlankSampleNumberException blsne) {
			System.out.println(blsne.toString());
			getMenuSelection();
		} catch (InvalidSampleNumberException isne){
			System.out.println(isne.toString());
			getMenuSelection();
		} catch (VerifiedAnalysisDoesNotExistException vadnee) {
			System.out.println(vadnee.toString());
			getMenuSelection();
		} catch (Exception e){
			System.out.println("An exception has occurred. Please try again.");
			getMenuSelection();
		}
	}
	/* LIST LABORATORY ANALYSIS STORED IN ARRAY LIST */
	/**
	 * This methods displays in the console a list of all the laboratory analysis stored in the inventory.
	 * In this case the inventory is an ArrayList that stores objects of type LabResults.
	 */
	public void listRegisteredAnalysis(){
		System.out.println("\nThis is a list of all laboratory analysis stored in inverntory:");
		System.out.format("\n%25s\t%10s\t%12s\t%18s\t%18s\t\n","Industry","Date","Sample No.","Laboratory","Compliance Test");
		if(listOfLaboratoryAnalysis.size() == 0){
			System.out.println("\nNone laboratory analysis in inventory.\n");
			getMenuSelection();
		}
		System.out.println();
		for (int i = 0; i < listOfLaboratoryAnalysis.size(); i++) {
			System.out.format("%25s\t%10s\t%12s\t%18s\t%18s\t\n",
								listOfLaboratoryAnalysis.get(i).getIndustryName(),
								listOfLaboratoryAnalysis.get(i).getSampleDate(),
								listOfLaboratoryAnalysis.get(i).getSampleNumber(),
								listOfLaboratoryAnalysis.get(i).getLaboratoryName(),
								listOfLaboratoryAnalysis.get(i).getVerificationStatus());
		}
		System.out.println();
	}
	/* LIST COMPLAIANCE TEST RESULTS */
	/**
	 * This methods displays in the console a list of all the compliance results of laboratory analysis of waste waters that are stored in the inventory.
	 * In this case the inventory is an ArrayList that stores objects of type ComplianceResults.
	 */
	public void listComplianceResults(){
		System.out.println("\nThis is a list of all waste water analysis compliance results:");
		System.out.format("\n%25s\t%10s\t%12s\t%18s\t%18s\t%20s\n","Industry","Date","Sample No.","Laboratory","Compliance Test","Compliance Result");
		if(listOfLaboratoryAnalysis.size() == 0){
			System.out.println("\nNone laboratory analysis in inventory.\n");
			getMenuSelection();
		}
		for (int j = 0; j < listOfAnalysisComplianceResults.size(); j++) {
			System.out.format("\n%25s\t%10s\t%12s\t%18s\t%18s\t%20s\n",
								listOfAnalysisComplianceResults.get(j).getIndustryNameComplianceAnalysis(),
								listOfAnalysisComplianceResults.get(j).getSampleDateComplianceAnalysis(),
								listOfAnalysisComplianceResults.get(j).getSampleNumberComplianceAnalysis(),
								listOfAnalysisComplianceResults.get(j).getLaboratoryNameComplianceAnalysis(),
								"true",
								listOfAnalysisComplianceResults.get(j).getAnalysisOverallComplianceResult());
		}
		System.out.println();
	}
	/* FIND VERIFIED ANALYSIS SAMPLE NUMBER */
	/**
	 * This method searches in an ArrayList that contains ComplianceResults for the resulting analysis that 
	 * matches the parameters of Sample Number and Industry Name. If the method finds a matching analysis it
	 * will return an index integer number with the corresponding position of the analysis in the ArrayList.
	 * If it does not find the analysis it will return a value of -1.
	 * @param scannedVerifiedSampleNumber The sample number of the analysis with compliance results to be found.
	 * @param scannedVerifiedIndustryName The industry name of the analysis with compliance results to be found.
	 * @return The position of the Analysis with the compliance results in the ArrayList of compliance results.
	 */
	public int findAnalysisComplianceResults( String scannedVerifiedSampleNumber,String scannedVerifiedIndustryName ){
		int index = -1;
		for ( int i = 0 ; i < listOfAnalysisComplianceResults.size() ; i++ ){
			if(listOfAnalysisComplianceResults.get(i).getSampleNumberComplianceAnalysis().equals(scannedVerifiedSampleNumber)
			&& listOfAnalysisComplianceResults.get(i).getIndustryNameComplianceAnalysis().equals(scannedVerifiedIndustryName))
			{
				index = i;
				break;
			}
		}
		return index;	
	}
	/**This method calculates the total waste water duties to an industry that exceeds the maximum limits
	 * of concentration of pollutants*/
	public void calculateWasteWaterDuties(){
		// Local variables
		String industryName = "", sampleNumber = "", compliance, complianceResults;
		int verifiedAnalysisIndex, industryClassificationIndex, bodyOfWaterClassificationIndex;
		ComplianceResults verifiedAnalysis = null;
		double dutiesRate, dischargedVolume, totalDuties;	
		Scanner scanner = new Scanner(System.in);
		DutiesCalculator calculator = new DutiesCalculator();
				
		System.out.println("\n=============================== WASTE WATER DISCHARGES DUTIES CALCULATOR ===============================");
		// List all analysis of waste water discharges in inventory
		listRegisteredAnalysis();
		
		// Choose an analysis of waste water entering the industry name and sample number	
		System.out.println("Select the analyisis to run the economic analysis");
		try {
			System.out.print("Enter industry name: ");
			industryName = scanner.nextLine();
			if (industryName.compareTo("") == 0) {
				throw new BlankIndustryNameException();
			}
			System.out.print("Enter sample number: ");
			sampleNumber = scanner.nextLine();	
			if (sampleNumber.compareTo("") == 0) {
				throw new BlankSampleNumberException();
			}
			if(sampleNumber.length() != 4){
				throw new InvalidSampleNumberException();
			}
			// Search analysis
			verifiedAnalysisIndex = findAnalysisComplianceResults( sampleNumber, industryName);
			if (verifiedAnalysisIndex == -1){
				throw new AnalysisIsNotValidatedException();
			} else {
				verifiedAnalysis = listOfAnalysisComplianceResults.get(verifiedAnalysisIndex);
			}
			// Get the compliance result
			compliance = verifiedAnalysis.getAnalysisOverallComplianceResult();
			// Assign the correct duties rate by entering industry classification and receiving body of water
			// classification
			System.out.print("Enter the industry classification (services, food, heavy industry, petroleum): ");
			industryClassificationIndex = calculator.getIndustryClassification();
			System.out.print("Enter the classification of the body of water (river, lake, ocean, aquifer): ");
			bodyOfWaterClassificationIndex = calculator.getBodyOfWaterClassification();
			dutiesRate = calculator.getDutiesRate(industryClassificationIndex, bodyOfWaterClassificationIndex);
			// Enter the discharged volume of waste water to the receiving body of water
			System.out.print("Enter the volume of waste water discharged (cubic meters) to the body of water during the quarter of the year: ");
			dischargedVolume = calculator.getTotalVolumeDischarged();
			// Calculate and display the total amount of duties to be payed by the industry
			totalDuties = calculator.getTotalWasteWaterDuties( dutiesRate , dischargedVolume , compliance);
			System.out.printf("\nDischarged volume (m3): %.2f\n", dischargedVolume);
			System.out.printf("Duties rate ($/m3): %.2f\n",dutiesRate);
			System.out.printf("\n%s has to pay %.2f dollars for this quarter fiscal year.\n", verifiedAnalysis.getIndustryNameComplianceAnalysis(),totalDuties);
		} catch (BlankIndustryNameException wse) {
			System.out.println(wse.toString());
			getMenuSelection();
		} catch(BlankSampleNumberException bsne) {
			getMenuSelection();
		} catch(InvalidSampleNumberException isne){
			System.out.println(isne.toString());
			getMenuSelection();
		} catch (AnalysisIsNotValidatedException adnee) {
			System.out.println("Please enter an analysis which compliance test result is marked as true.");
			System.out.println("If the compliance test is false please run a compliance test first.");
			getMenuSelection();
		} catch (InputMismatchException ime){
			System.out.println("Invalid input format. Please try again.");
			getMenuSelection();
		} catch (Exception e){
			System.out.println("An exception has occured. Please try again.");
			getMenuSelection();
		}	
	}
	/* SHOW MAXIMUM LEVELS ALLOWED OF POLLUTION IN RECEIVING BODIES OF WATER */
	/**
	 * Shows the maximun limits allowed of heavy metals in receiving bodies of waste water according to the Mexican regulation
	 * NOM-001-SEMARNAT-1996
	 */
	public void displayMaximumLevelsAllowed(){
		
		System.out.println("\n=============== MAXIMUM LEVELS ALLOWED OF POLLUTANTS IN RECEIVING BODIES OF WASTE WATER ===============");
		System.out.println("\nAccording to the Mexican Official Norm of Quality of Water in Receiving bodies of waste water");
		System.out.println("NOM-001-SEMARNAT-1996 the maximum concentrations in (mg/L) of heavy metals are:\n");
		System.out.printf( "%10s\t%12s\t%5s\n", "Pollutant", "Concentration", "Units" );
		System.out.printf( "%10s\t%12s\t%5s\n", "Arsenic", ComplianceResults.MAX_ARSENIC_ALLOWED, " mg/L");
		System.out.printf( "%10s\t%12s\t%5s\n", "Cadmium", ComplianceResults.MAX_CADMIUM_ALLOWED, " mg/L");
		System.out.printf( "%10s\t%12s\t%5s\n", "Chromium", ComplianceResults.MAX_CHROMIUM_ALLOWED, " mg/L");
		System.out.printf( "%10s\t%12s\t%5s\n", "Copper", ComplianceResults.MAX_COPPER_ALLOWED, " mg/L");
		System.out.printf( "%10s\t%12s\t%5s\n", "Cyanides", ComplianceResults.MAX_CYANIDES_ALLOWED, " mg/L");
		System.out.printf( "%10s\t%12s\t%5s\n", "Lead", ComplianceResults.MAX_LEAD_ALLOWED, " mg/L");
		System.out.printf( "%10s\t%12s\t%5s\n", "Mercury", ComplianceResults.MAX_MERCURY_ALLOWED, " mg/L");
		System.out.printf( "%10s\t%12s\t%5s\n", "Nickel", ComplianceResults.MAX_NICKEL_ALLOWED, " mg/L");
		System.out.printf( "%10s\t%12s\t%5s\n", "Zinc", ComplianceResults.MAX_ZINC_ALLOWED, " mg/L");
		System.out.println();
	}
	
}
