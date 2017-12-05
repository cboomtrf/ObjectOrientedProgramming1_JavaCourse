/**
 * @author Carina Boom (MIW 10 - studentnumber 500793324)
 */
package main;

//import utilities & classes.
import vak.*;
import java.util.Scanner;

public class Main {
	
	//static scanner
	static Scanner inputUser = new Scanner(System.in);
	//create array vakken
	static Vak[] vakken = initializeCoursesArray();

	public static void main(String[] args) {
		//testBsa3();
		
		//user input
		System.out.println("Voer behaalde cijfers in: ");
		System.out.println();
		//for loop to fill setCijfers per vak
		for (int n = 0; n < vakken.length; n++) {
			System.out.print("Geef een cijfer voor " + vakken[n].getNaam() + ": ");
			vakken[n].setCijfer(inputUser.nextDouble());
			
			while (invalidEntry(vakken[n].getCijfer())) {
				System.out.println("De cijfers moeten in de range tussen 1.0 en 10.0 vallen.");
				System.out.print("Geef een cijfer voor " + vakken[n].getNaam() + ": ");
				vakken[n].setCijfer(inputUser.nextDouble());
			}
		}

		//print info for all courses
		printOverview();
		
		//calculate & print totals/BSA
		getTotals();
		
		//close scanner
		inputUser.close();
	}
	
	public static Vak[] initializeCoursesArray() {
		//maak array van vakken aan
		Vak[] vakken = new Vak[7];
		
		vakken[0] = new Vak("Fasten your Seatbelts", 12);
		vakken[1] = new Vak("Programming", 3);
		vakken[2] = new Vak("Databases", 3);
		vakken[3] = new Vak("Personal Skills", 2);
		vakken[4] = new Vak("Project Skills", 2);
		vakken[5] = new Vak("Infrastructure", 3);
		vakken[6] = new Vak("Network Engineering 1", 3);
		
		return vakken;
	}
	
	public static boolean invalidEntry(double inputNumber) {
		return (inputNumber < 1.0 || inputNumber > 10.0);
	}
	
	public static void getTotals() {
		//vars voor totalen
		int sumAllePunten = 0;
		int sumBehaaldePunten = 0;
		//for loop voor totalen
		for (Vak v : vakken) {
			sumBehaaldePunten += v.behaaldePunten();
			sumAllePunten += v.getPunten();
		}
		
		System.out.println("Totaal behaalde studiepunten: " + sumBehaaldePunten + "/" + sumAllePunten);
		//calculate bsa advice if less than 5/6 of studypoints.
		if (((double)sumBehaaldePunten / sumAllePunten) < (5.0 / 6.0)) {
			System.out.println("PAS OP: je ligt op schema voor een negatief BSA!");
		}
	}
	
	public static void printOverview() {
		System.out.println();
		for (int v = 0; v < vakken.length; v++) {
		System.out.printf("Vak/Project: %-30s Cijfer: %-5.1f Behaalde punten: %-3d \n", 
				vakken[v].getNaam(), vakken[v].getCijfer(), vakken[v].behaaldePunten());
		}
		System.out.println("");
	}
	
	public static void testBsa3() {
		//roep constructor vak aan
		Vak fys = new Vak("Fasten your Seatbelts", 12);
		
		//vraag gebruiker om cijfer & sla op met setCijfer
		System.out.print("Voer behaalde cijfer voor " + fys.getNaam() 
			+ " in: ");
		fys.setCijfer(inputUser.nextDouble());
		
		//print info
		System.out.println("Vak/Project: " + fys.getNaam()
			+ "\t Cijfer: " + fys.getCijfer() 
			+ "\t Punten: " + fys.behaaldePunten());
	}
}
