/* File: DutiesCalculator.java */
package Duties;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * <p>This class contains all the methods necessary to calculate the duties for discharging waste water to receiving bodies of water.
 * An industry should pay the National Commission of Water for each cubic meter of waste water discharged to bodies of water if the 
 * laboratory analysis of a sample of their waste water during the corresponding quarter fiscal year exceeds the maximum levels
 * allowed of heavy metals according to the Mexican regulation named NOM-001-SEMARNAT-1996. However, if the compliance results of the
 * laboratory analysis are 'satisfactory', meaning that they demonstrate that the concentration of heavy metals is under the maximum
 * levels, the user will be exempted of duties payment during the quarter fiscal year.</p> 
 * 
 * <p>Bearing this in mind the rate of the duty is calculated as a result of mapping the classification of the industry (services, food,
 * heavy industry, petroleum) that generates the waste water discharge and the classification of the body of water (river, lake, ocean,
 * aquifer) that receives the discharge. This obeys to the fact that the social costs of providing treatment to wastes water depends on
 * the concentrations of heavy metals according to the industry classification, and that it is more expensive to provide treatment to
 * ground water than in surface water.</p> 
 * 
 * <p>Furthermore, once the rate is selected it is necessary to ask the industry how many volume, in cubic meters, of waste water it
 * discharged to the receiving body during a fiscal quarter year. Then in order to calculate the total amount duties to be paid during
 * the quarter fiscal year to the National Commission of Water the rate should be multiplied by the volume discharged.</p>
 * @author Dante Ruiz
 */
public class DutiesCalculator {
	/*Instance Variables*/
	
	// Duties matrix (in dollars per cubic meter)
	private double[][] dutiesMatrix = {
			//Rivers	// Lakes	//Oceans	//Aquifers
				{1,			2,			3,			4}, 	// Services
				{5,			6,			7,			8}, 	// Food
				{9,			10,			11,			12}, 	// Heavy Industry
				{13,		14,			15,			16} 	// Petroleum
	};
	
	// Receiving body of waste water classification
	private String[] bodiesOfWaterClassifications = {
					"river",
					"lake",
					"ocean",
					"aquifer"
					
	};
	
	// Industry classifications
	private String[] industryClassifications = {
					"services",
					"food",
					"heavy industry",
					"petroleum"
	};

	/* Total amount of waste water duties method */
	/**
	 * Calculates the total amount of duties to be paid by the industry during a fiscal quarter year. If the overall compliance result
	 * of the laboratory analysis is satisfactory, the industry will pay zero dollars. However, is the result is unsatisfactory the 
	 * total amount of duties is calculated as a result of multiplying rate times discharged volume.
	 * @param rate The rate should be in dollars per cubic meter.
	 * @param volume The waste water discharged volume should be in cubic meters, and should correspond to the total amount discharged
	 * during the quarter fiscal year.
	 * @param complianceResults A string value equal to satisfactory or unsatisfactory.
	 * @return The total amount of duties to be paid in dollars.
	 */
	public double getTotalWasteWaterDuties(double rate, double volume, String complianceResults){
		if(complianceResults.equalsIgnoreCase("satisfactory")){
			return 0;
		} else {
			return rate * volume;
		}
	}
	
	/* Duties rate getter */
	/**
	 * Picks the correct rate of duties in cubic meters from a matrix of rates by passing the correct industry classification index
	 * and receiving bodies of waste water classification index.
	 * @param industryClassificationIndex The industry classification index is obtained by calling the getIndustryClassification method.
	 * @param bodyOfWaterIndex The receiving body of water classification is obtained by calling the getBodyOfWaterClassification method.
	 * @return The correct rate of duties as a result of the selected industry classification and body of water.
	 */
	public double getDutiesRate(int industryClassificationIndex, int bodyOfWaterIndex)
	{
		return dutiesMatrix[industryClassificationIndex][bodyOfWaterIndex];
	}

	/* Industry classification getter */
	/** Asks the user to enter the name of the industry classification as a string. Then it searches the string in
	 * an array of strings that contains all possible industry classifications (services, food, heavy industry, petroleum).
	 * @return The method returns an integer with the position of the name of the  industry classification entered by the user.
	 * However, if the name of the industry is not found the value of the returned integer is -1.
	 */
	public int getIndustryClassification() {
		int index = -1;
		Scanner scanner = new Scanner(System.in);
		while(index == -1)
		{
			String name = scanner.nextLine();
			index = findStringInArray(name, industryClassifications);
			if (index == -1){
				System.out.println("Unknown industry classification, please try again.");
			}
		}
		return index;
	}

	/* Receiving body of waste water classification getter*/
	/** Asks the user to enter the name of the receiving body of waste water classification as a string. Then it searches the string in
	 * an array of strings that contains all possible receiving body of waste water classifications classifications (river, lake, ocean,
	 * aquifer).
	 * @return The method returns an integer with the position of the name of the receiving body classification entered by the user.
	 * However, if the name of the receiving body of water is not found the value of the returned integer is -1.
	 */
	public int getBodyOfWaterClassification() {
		int index = -1;
		Scanner scanner = new Scanner(System.in);
		
		while(index == -1)
		{
			String name = scanner.nextLine();
			index = findStringInArray(name, bodiesOfWaterClassifications);
			if (index == -1){
				System.out.println("Unknown body of water classification, please try again.");
			}
		}
		return index;
	}
	
	/* Find string in array method */
	/** Finds a key string in a string array.  It implements a linear search algorithm.
	 * @param key The name of the string to be searched
	 * @param array The array of strings where the key will be searched.
	 * @return If it finds the key it returns the position of the string in the array. However, if it does not find the key it returns -1.
	 */
	private int findStringInArray(String key, String[] array){
		for (int i = 0; i < array.length; i++) {
			if (key.equals(array[i])) return i;
		}
		return -1;
	}	
	
	/* Waste water discharge volume getter*/
	/**
	 * Asks the user to enter the volume discharged in cubic meters.
	 * @return The amount of waste water discharged to the receiving body of water in cubic meters.
	 */
	public double getTotalVolumeDischarged() throws InputMismatchException
	{
		double volume = -1;
		Scanner scanner = new Scanner(System.in);
		
		volume = scanner.nextDouble();
		return volume;
	}
}
