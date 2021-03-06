# Compliance Application for the Monitoring and Control of Waste Water Discharges to Receiving Bodies of Water

## Abstract:
This is the <b>final project</b> I presented for the course <b><i>Java: Discovering Its Power at UC Berkeley Extension</i></b>. It is a <b>Java Program that
solves a real problem</b>. This console program <b>attempts to help analysts in the National Commission of Water (CONAGUA) in Mexico to enforce the monitoring and control of industrial waste water discharges to bodies of water</b>. The program allows to input the quality results of waste waters of a particular company, which later are evaluated according to the regulation limits. Moreover, it allows to upload the results in XML files that come from a Web Service. These results can be read, stored and accessed using the program. Finally, after conducting the compliance analysis the program produces a text document containing the results indicating whether the industry complied or not, and indicating how much duties it has to pay to CONAGUA for the pollution generated.

## Context:
I work for the National Commission of Water (CONAGUA) in Mexico doing economic analysis about the collection of duties coming from water abstraction and waste water discharges. In 2013, I participated in the design of a new methodology to price the water abstraction and the waste water discharges. Such pricing methodologies served to reform the National Duties Law, and since 2014 I have been participating in the implementation of this mechanics. 

With respect to the compliance of the waste water discharges regulation, industries shall pay a duty for each cubic meter they dispose to a receiving body of water such as a river, a lake, an aquifer or the ocean.  The duty is calculated in pesos per cubic meter. However, the law allows industries to exempt the payment of the duty, as long as, they provide a treatment to improve the quality of their waste waters.  In order to do so they shall contract the services of an official laboratory that will obtain samples of their waste waters, which will also analyze them with special tests and equipment in the lab. A laboratory analysis of waste waters will comply with the environmental regulation, as long as, it demonstrate that the pollutants' concentrations remain below the maximum limits outlined in an official norm named NOM-001-SEMARNAT-1996.

## Problematic:
Bearing this in mind, the results of the laboratory analysis of waste waters are captured in a system called SIRALAB that runs the tests of the maximums limits of pollutant concentration in a Web Serivce, which throws a boolean result that will enable or impede the industries to exempt the payment of duties in another system. However, the team of analysts, that audit such laboratory results to verify that the analysis comply with the regulation, requires a computer application that will allow them to input the laboratory results, and verify that each of the pollutants concentrations are under the maximum concentrations allowed by the environmental norm. Moreover, if one of such parameters exceeds such limits, they want to know which ones exceeded the limits and by how much.  Finally, they need an application that can check the compliance of each laboratory analysis with the NOM-001-SEMARNAT-1996, and if necessary a mean to calculate the total amount of duties to be paid in a quarterly fiscal year.

## Program objective:
Simulate the monitoring and control activities that the Mexican National Commission of Water (CONAGUA) performs to enforce the regulation of industrial water pollution. 

## Program description:
The “Compliance Application for the Monitoring and Control of Waste Water Discharges to Receiving Bodies of Water” is a console program that was written in Java. The main purpose of this application is to model the activities that CONAGUA does to enforce the regulation of water quality in receiving bodies, and to encourage waste water treatment to diminish the water pollution generated by industries. In general, this program features the following functions:

<ul><li><b>Laboratory Results.</b> Stores in memory the laboratory results of waste water samples obtained from the discharges of a given industry.
<ul><li>Allows to input laboratory results for 9 concentrations of heavy metals according to the Mexican norm of quality of water in receiving bodies of waste water named NOM-001-SEMARNAT-1996.</li>
<li>Allows to generate a laboratory result in which the 9 concentrations of heavy metals are generated using random numbers.</li>
<li>Allows to load in the program existing laboratory results stored in XML documents.</li></ul>
</ul>

<ul><li><b>Compliance Tests.</b> Performs a test that compares the laboratory results against the maximum levels of concentration of heavy metals in bodies of water according to the NOM-001-SEMARNAT-1996.
<ul><li>Compares maximum limits against observed results and generates a compliance result per parameter: complies or exceeds maximum limits.</li>
<li>Generates an overall compliance result (satisfactory/unsatisfactory).</li>
<li>Stores laboratory and compliance results by creating an XML document.</li></ul>
</ul>

<ul><li><b>Interpretation documents.</b> For each laboratory results where a compliance test is performed, the program allows to generate a summary of the results in a text file. This is intended to provide analysts and top management with a document with relevant information for the decision making processes.</li></ul>

<ul><li><b>Duties payment estimations.</b> Calculates the total amount of duties in dollars to be paid by each industry that fails to comply with the regulation of water quality of waste waters in cubic meters. For such calculations the compliance test results, waste water discharged volume, industry classification and receiving bodies of water classifications are considered.</li></ul>

Finally, it is worth to point out that for purposes of this final project, the regulation model was simplified in order to build an easy and an understandable Java program, so that peers could understand its primary functions without any previous knowledge on Mexican waste water discharges and fiscal regulations.
  
