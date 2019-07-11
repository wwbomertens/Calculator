/* ******************************************************** *\
Naam: 			Calculator
Datum:			23-10-2018
Omschrijving:	Class om de calculator in het scherm te laten werken

\* ******************************************************** */
package main;

// Import functionaliteiten
import view.*;
import java.math.*;
import java.util.Arrays;
import java.util.List;

// Hoofdklasse
public class Calculator 
{
	public static void main(String[] args) 
	{	/* 	Programmeur: 	Wouter Mertens
			Datum:			19-10-2018
			Omschrijving:	Hoofdroutine 
		*/
		
		// Start de calculator
		SchermCalculator.main("0", "");
	}
	
	public static String[] InputCalculator(String sDisplay, String sFormule, String sKnopIngedrukt) 
	{	/* 	Programmeur: 	Wouter Mertens
			Datum:			19-10-2018
			Omschrijving:	Functie om de calculator te wijzigen 
	 	*/
		
		String[] sCalcvar=new String[2];
		String sGetallen="0123456789.";
		int iScenario=0;
		
		// Check eerst of de C knop is ingevuld
		if (sKnopIngedrukt.equals("C"))
			{iScenario=1;}
		// Check nu of er een error is 
		else if (sDisplay.equals("Err"))
			{iScenario=2;}
		// Check nu of de change knop is ingedrukt
		else if (sKnopIngedrukt.equals("+/-"))
		{
			if (sDisplay.equals("0"))
				{iScenario=14;}
			else if (sDisplay.substring(0, 1).equals("-"))
				{iScenario=15;}
			else
				{iScenario=16;}
		}
		// CHeck of een getal is ingevuld
		else if (sGetallen.contains(sKnopIngedrukt)==true)
			{iScenario=GetiScenarioGetal(sDisplay,sKnopIngedrukt);}
		// In dit geval is symbool ingedrukt
		else		
			{iScenario=GetiScenarioGeenGetal(sDisplay, sFormule, sKnopIngedrukt);}	
				
		// Bepaal nu de waarde voor de display
		sCalcvar[0]=getsDisplay(iScenario,sDisplay,sKnopIngedrukt, sFormule);
		
		// Bepaal nu de waarde voor de formule
		sCalcvar[1]=getsFormule(iScenario,sFormule,sKnopIngedrukt);
		
		// Check nu of de display niet aangepast moet worden
		sCalcvar[0]=CheckDisplay(sCalcvar[0],sKnopIngedrukt);
		
		// Geef de return waarde terug
		return sCalcvar;
	}

	private static String CheckDisplay(String sInvoer,String sKnopIngedrukt) 
	{	/* 	Programmeur: 	Wouter Mertens
			Datum:			28-10-2018
			Omschrijving:	Routine om de display aan te passen
			 				1 Check of de laatste twee cijfers een .0 is en deze weghalen
			 				2 Check of het getal niet groter is dan 20 tekens voor de punt
			 				3 Check of het getal niet groter is dan 20 tekens na de punt  
 		*/
		
		String sUitkomst=sInvoer;
		// Check eerst of de lengte groter is dan 2 tekens
		if (sInvoer.length()>2 && !sKnopIngedrukt.equals("0"))
		{	
			System.out.println(sInvoer.substring(sInvoer.length()-2, sInvoer.length()));
			if (sInvoer.substring(sInvoer.length()-2, sInvoer.length()).equals(".0"))
				{sUitkomst=sInvoer.substring(0, sInvoer.length()-2);}
		}
		// Ga nu kijken of het getal niet te groot is
		if (sUitkomst.length()>20)
		{
			if (sUitkomst.contains("."))
			{
				if (sUitkomst.indexOf(".", 0)>20)
					{return "Err";}
				else
					{return sUitkomst.substring(0, 20);}
			}
			else
				{return "Err";}
		}
		else
			{return sUitkomst;}
	}

	private static int GetiScenarioGeenGetal(String sDisplay, String sFormule, String sKnopIngedrukt) 
	{	/* 	Programmeur: 	Wouter Mertens
			Datum:			28-10-2018
			Omschrijving:	Routine om te bepalen wat het scenario is als de knop die ingedrukt is geen getal is. 
							In deze routine wordt enkel getest of het laatste teken in sFormule een teken of getal is  
	 	*/
		
		String sTekens="/*+-=";
		
		if (sFormule.length()==0)
			{return 7;}
		else
		{
			// Bepaal het laatste teken in de formule
			String sLaatsteTeken=sFormule.substring(sFormule.length()-1, sFormule.length());
						
			// Check nu of het laatste teken in de formule wiskundig is of niet
			if (sTekens.contains(sLaatsteTeken)==true)
				{return GetiScenarioGeenGetalWis(sDisplay, sFormule, sKnopIngedrukt);}
			else
				{return GetiScenarioGeenGetalNietWis(sDisplay, sFormule, sKnopIngedrukt);}
		}
	}

	private static int GetiScenarioGeenGetalNietWis(String sDisplay, String sFormule, String sKnopIngedrukt) 
	{	/* 	Programmeur: 	Wouter Mertens
			Datum:			28-10-2018
			Omschrijving:	Routine om te bepalen wat het scenario is als de  het laatste teken in de formule niet wiskundig is 
							en de knop die ingedrukt is geen getal is.
							Scenario 10 (of de formule is leeg of de backspace wordt ingedrukt --> Geen wijziging
							Scenario 11 (het = teken wordt ingedrukt --> reken de formule uit    
							Scenario 12 (het teken wordt ingedrukt maar er moet gerekend worden 
							Scenario 13 in de formule staat alleen een getal dus het teken wordt toegevoegd
		*/
		// Indien de backspace ingedrukt is verandert nu niets
		if (sKnopIngedrukt.equals("<---") && sFormule.length()>1)
			{return 10;}
		else if (sKnopIngedrukt.equals("<---") && sFormule.length()==1)
			{return 1;}
		else if (sKnopIngedrukt.equals("<---"))
			{return 7;}
		else if (sKnopIngedrukt.equals("="))
			{return 11;}				
		else if (ContainsMath(sFormule))
			{return 12;}
		else
			{return 13;}
	
	}

	private static int GetiScenarioGeenGetalWis(String sDisplay, String sFormule, String sKnopIngedrukt) 
	{	/* 	Programmeur: 	Wouter Mertens
			Datum:			28-10-2018
			Omschrijving:	Routine om te bepalen wat het scenario is als de  het laatste teken in de formule wiskunidg is 
							en de knop die ingedrukt is geen getal is.
							Scenario 7 (of de formule is leeg of de backspace wordt ingedrukt --> Geen wijziging
							Scenario 8 (het = teken wordt ingedrukt --> laatste teken wissen (bv "100+"--> 100)   
							Scenario 9 (alle andere gevallen --> Laatste teken wordt vervangen (bv 100+ --> 100-
 		*/
		
		// Indien de backspace ingedrukt is verandert nu niets
		if (sKnopIngedrukt.equals("<---") && sFormule.length()==0)
			{return 7;}
		else if (sKnopIngedrukt.equals("="))
			{return 8;}				
		else
			{return 9;}
	}

	private static int GetiScenarioGetal(String sDisplay, String sKnopIngedrukt) 
	{	/* 	Programmeur: 	Wouter Mertens
			Datum:			28-10-2018
			Omschrijving:	Routine om te bepalen wat het scenario is als een getal ingedrukt wordt
							Scenario 3 De display geeft 0 aan en 0 wordt ingedrukt --> Geen wijziging
							Scenario 4 De display geeft 0 en een ander getal wordt ingedrukt  --> het getal wordt vervangen   
							Scenario 5 Alle andere gevallen --> Getal wordt uitgebreid (bv 1 --> 12 als 2 ingedrukt is)
		*/

		if (sDisplay.equals("0") && sKnopIngedrukt.equals("0"))
			{return 3;}
		else if (sDisplay.equals("0"))
			{return 4;}	
		else
			{return 5;}
	}
	
	private static boolean ContainsMath(String sFormule)
	{	/* 	Programmeur: 	Wouter Mertens
			Datum:			28-10-2018
			Omschrijving:	Routine om te kijken of de formule een wiskundig teken bevat
	 	*/
		if (sFormule.contains("*") || sFormule.contains("/") || sFormule.contains("+") || sFormule.indexOf("-")>0)
			{return true;}
		else
			{return false;}		
	}
	
	private static String getsFormule(int iScenario, String sFormule, String sKnopIngedrukt) 
	{	/* 	Programmeur: 	Wouter Mertens
			Datum:			28-10-2018
			Omschrijving:	Routine om op basis van het scenario de juiste waarde terug te geven voor de formule
 		*/

		if 	(iScenario==1 || iScenario==2)
			{return "";}
		else if (iScenario==3 || iScenario==7 || iScenario==14)
			{return sFormule;}
		else if (iScenario==4 || iScenario==5 || iScenario==13)
			{return sFormule+sKnopIngedrukt;}	
		else if (iScenario==8)
			{return sFormule.substring(0,sFormule.length()-1);}
		else if (iScenario==9)
			{return sFormule.substring(0,sFormule.length()-1)+sKnopIngedrukt;}
		else if (iScenario==10)
			{return sFormule.substring(0,sFormule.length()-1);}
		else if (iScenario==11)
			{return CalculateFormula(sFormule);}
		else if (iScenario==12)
			{return CalculateFormula(sFormule)+sKnopIngedrukt;}
		else if (iScenario==16)
			{return "-" + sFormule;}
		else if (iScenario==15)
			{return sFormule.substring(1, sFormule.length());}
		else
			{return "";}
	}
	
	private static String getsDisplay(int iScenario , String sDisplay , String sKnopIngedrukt, String sFormule)
	{	/* 	Programmeur: 	Wouter Mertens
			Datum:			28-10-2018
			Omschrijving:	Routine om op basis van het scenario de juiste waarde terug te geven voor de formule
		*/

		if 	(iScenario==1 || iScenario==3 || iScenario==12 || iScenario==13 || iScenario==14)
			{return "0";}
		else if (iScenario==2 || iScenario==7 || iScenario==9 )
			{return sDisplay;}
		else if (iScenario==4)
			{return sKnopIngedrukt;}		
		else if (iScenario==5)
			{return sDisplay+sKnopIngedrukt;}
		else if (iScenario==8)
			{return sFormule.substring(0,sFormule.length()-1);}
		else if (iScenario==10)
			{return sDisplay.substring(0,sDisplay.length()-1);}
		else if (iScenario==11)
			{return CalculateFormula(sFormule);}	
		else if (iScenario==16)
			{return "-" + sDisplay;}
		else if (iScenario==15)
			{return sDisplay.substring(1, sDisplay.length());}
		else
			{return "";}
	}
	
	private static String CalculateFormula(String sFormule) 
	{	/* 	Programmeur: 	Wouter Mertens
			Datum:			28-10-2018
			Omschrijving:	Functie om de sFormule uit te rekenen. In deze functie wordt alleen bepaald welke type formule nodig is 
	 	*/
		
		String sUitkomst = null;
		
		// Bereken de uitkomst
		if (sFormule.contains("*"))
			{sUitkomst=CalcMultiply(sFormule);}
		else if (sFormule.contains("/"))
			{sUitkomst=CalcDivide(sFormule);}
		else if (sFormule.contains("+"))
			{sUitkomst=CalcAdd(sFormule);}
		else if (sFormule.contains("-"))
			{sUitkomst= CalcSubstract(sFormule);}
		
		// Geef de waarde terug
		return sUitkomst;
	}
	
	private static String CalcSubstract(String sFormule) 
	{	/* 	Programmeur: 	Wouter Mertens
			Datum:			28-10-2018
			Omschrijving:	Functie om de sFormule uit te rekenen.
			 				In deze functie wordt minus uitgerekend 
 		*/
		
		double dDeel1;
		double dDeel2;
		double dUitkomst;
		
		// Splits de formule uit in twee delen
			int iPositie=sFormule.indexOf("-", 1);
			String sDeel1=sFormule.substring(0, iPositie);
			String sDeel2=sFormule.substring( iPositie+1,sFormule.length());

		// Bereken nu de twee delen numeriek
			dDeel1=Double.parseDouble(sDeel1);
			dDeel2=Double.parseDouble(sDeel2);
			dUitkomst=dDeel1-dDeel2;
		
		// Maak van de numerieke waarde een String
		String sUitkomst=Double.toString(dUitkomst);
		
		// Geef de waarde terug
		return sUitkomst;
	}

	private static String CalcAdd(String sFormule) 
	{	/* 	Programmeur: 	Wouter Mertens
			Datum:			28-10-2018
			Omschrijving:	Functie om de sFormule uit te rekenen.
		 					In deze functie wordt plus uitgerekend 
		*/
		
		double dDeel1;
		double dDeel2;
		double dUitkomst;
		
		// Splits de formule uit in twee delen
			int iPositie=sFormule.indexOf("+");
			String sDeel1=sFormule.substring(0, iPositie);
			String sDeel2=sFormule.substring( iPositie+1,sFormule.length());


		// Bereken nu de twee delen numeriek
			dDeel1=Double.parseDouble(sDeel1);
			dDeel2=Double.parseDouble(sDeel2);
			dUitkomst=dDeel1+dDeel2;
		
		// Maak van de numerieke waarde een String
		String sUitkomst=Double.toString(dUitkomst);
		
		// Geef de waarde terug
		return sUitkomst;
	}

	private static String CalcDivide(String sFormule) 
	{	/*	Programmeur: 	Wouter Mertens
			Datum:			28-10-2018
			Omschrijving:	Functie om de sFormule uit te rekenen.
	 						In deze functie wordt gedeeld door uitgerekend
	 						Wel moet rekening gehouden worden met de foutmelding als door
	 						0 gedeeld wordt 
	 	*/
		
		// Check de positie van de deel door streep
		int iPositie=sFormule.indexOf("/");
		
		// Check of er geen /, /0 staat
		if (iPositie==sFormule.length())
			{return "Err";}
		else
		{
			double dDeel1;
			double dDeel2;
			double dUitkomst;
			
			// Splits de formule uit in twee delen
				String sDeel1=sFormule.substring(0, iPositie);
				String sDeel2=sFormule.substring( iPositie+1,sFormule.length());

			// Bereken de twee delen numeriek
				dDeel1=Double.parseDouble(sDeel1);
				dDeel2=Double.parseDouble(sDeel2);
			
			// Check nog of deel2 niet gelijk is aan 0
			if (dDeel2==0)
				{return "Err";}
			else
			{
				// Bereken de waaarde en zet deze om in string
					dUitkomst=dDeel1/dDeel2;					
					String sUitkomst=Double.toString(dUitkomst);
				
					// Geef de waarde terug
				return sUitkomst;
			}
		}
	}

	private static String CalcMultiply(String sFormule) 
	{	/* 	Programmeur: 	Wouter Mertens
			Datum:			28-10-2018
			Omschrijving:	Functie om de sFormule uit te rekenen.
	 						In deze functie wordt vermenigvuldigem uitgerekend 
	 	*/
	
		double dDeel1;
		double dDeel2;
		double dUitkomst;
		
		// Splits de formule uit in twee delen
			int iPositie=sFormule.indexOf("*");
			String sDeel1=sFormule.substring(0, iPositie);
			String sDeel2=sFormule.substring( iPositie+1,sFormule.length());
	
	
		// Bereken nu de twee delen numeriek
			dDeel1=Double.parseDouble(sDeel1);
			dDeel2=Double.parseDouble(sDeel2);
			dUitkomst=dDeel1*dDeel2;
		
		// Maak van de numerieke waarde een String
		String sUitkomst=Double.toString(dUitkomst);
		
		// Geef de waarde terug
		return sUitkomst;
	}		
}