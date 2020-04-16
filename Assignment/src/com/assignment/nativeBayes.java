/*	Program Name: Covid-19 database analise using native bayes law
 * 	Class Description: This class is used for calculating the values for the probability it takes all the values generated
 * 						from the FileProcessing class and the user input from the medicalGui and allows them to conbine and
 * 						calculate the probability of the user having the covid-19 virus.
 * 						This class is also used to house the method to write to the fill I chose this as it already has public static variables
 * 						so I know that the method will already have access to all the needed variables and information to write to the file.
 * 	Author : Vlads Drobovics
 * 	Compiler Used: eclipse
*/
package com.assignment;

import javax.swing.JOptionPane;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

import javax.swing.JFrame;

public class nativeBayes extends JFrame 
{
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
	//Strings needed to generate values
	public static String Temp;
	public static String Aches;
	public static String Cough;
	public static String SoreThroat;
	public static String RTDZ1;
	public static String Covid19;
	
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
	//float values needed to generate values
	public static float processYCountResult;
	public static float processNCountResult;
	public static float resultTempY;
	public static float resultTempN;
	public static float resultAchesY;
	public static float resultAchesN;
	public static float resultCoughY;
	public static float resultCoughN;
	public static float resultSoreThroatY;
	public static float resultSoreThroatN;
	public static float resultRTDZY;
	public static float resultRTDZN;
	
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
	//method used to transfer the user input 
	public void nativeBayesConfig(String temp,String aches,String cough,String soreThroat,String RTDZ)
	{
		//getting input for the admin to see if all results show up correctly.
		System.out.println("The temp is:"+temp+" there is aches:"+aches+" there is a cough:"+cough+" there is a sore throat:"+soreThroat+" they have travelled into a danger zone:"+RTDZ);
		
		Temp = temp;
		Aches = aches;
		Cough = cough;
		SoreThroat = soreThroat;
		RTDZ1 = RTDZ;
		System.out.println("The temp is:"+Temp+" there is aches:"+Aches+" there is a cough:"+Cough+" there is a sore throat:"+SoreThroat+" they have travelled into a danger zone:"+RTDZ1);
		System.out.println();
	}
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
	//method used to transfer the counted values for temperature
	public void nativeBayesCalcTemp(int hotCovidYes,int hotCovidNo,int coolCovidYes,int coolCovidNo,int normalCovidYes,int normalCovidNo,int covidcountY,int covidcountN)  
	{
		float fhotCovidYes 		= hotCovidYes;
		float fhotCovidNo 		= hotCovidNo;
		float fcoolCovidYes 	= coolCovidYes;
		float fcoolCovidNo		= coolCovidNo;
		float fnormalCovidYes 	= normalCovidYes;
		float fnormalCovidNo 	= normalCovidNo;
		
		
		System.out.println("The temp is:"+Temp);
		try
		{
			if(Temp.equals("hot"))
			{
				resultTempY = fhotCovidYes / covidcountY;
				resultTempN = fhotCovidNo / covidcountN;
			}//end if
			if(Temp.equals("cool"))
			{
				System.out.println("It works");
				resultTempY = fcoolCovidYes / covidcountY;
				resultTempN = fcoolCovidNo / covidcountN;
				System.out.println(resultTempN);
			}//end if
			if(Temp.equals("normal"))
			{
				resultTempY = fnormalCovidYes / covidcountY;
				resultTempN = fnormalCovidNo / covidcountN;
			}//end if
		}//end try
		catch(NullPointerException e)
		{
			System.out.println("Wrong");
		}
	}//end nativeBayesCalcTemp()
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
	//method used to transfer the counted values for aches
	public void nativeBayesCalcAches(int achesYCovidYes, int achesYCovidNo,int achesNCovidYes, int achesNCovidNo, int covidcountY,int covidcountN)
	{
		float fachesYCovidYes 	=achesYCovidYes;
		float fachesYCovidNo	=achesYCovidNo;
		float fachesNCovidYes	=achesNCovidYes;
		float fachesNCovidNo	=achesNCovidNo;
		
		try
		{
			if(Aches.equals("yes"))
			{
				resultAchesY = fachesYCovidYes / covidcountY;
				resultAchesN = fachesYCovidNo / covidcountN;
			}//end if
			if(Aches.equals("no"))
			{
				resultAchesY = fachesNCovidYes / covidcountY;
				resultAchesN = fachesNCovidNo / covidcountN;
			}//end if
		}//end try
		catch(NullPointerException e)
		{
			System.out.println("Wrong");
		}
	}//end nativeBayesCalcAches
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
	//method used to transfer the counted values for cough
	public void nativeBayesCalcCough(int coughYCovidYes, int coughYCovidNo,int coughNCovidYes, int coughNCovidNo, int covidcountY,int covidcountN)
	{
		float fcoughYCovidYes 	=coughYCovidYes;
		float fcoughYCovidNo 	=coughYCovidNo;
		float fcoughNCovidYes 	=coughNCovidYes;
		float fcoughNCovidNo 	=coughNCovidNo;
		
		try
		{	
			if(Cough.equals("yes"))
			{
				resultCoughY = fcoughYCovidYes / covidcountY;
				resultCoughN = fcoughYCovidNo / covidcountN;
			}//end if
			if(Cough.equals("no"))
			{
				resultCoughY = fcoughNCovidYes / covidcountY;
				resultCoughN = fcoughNCovidNo / covidcountN;
			}//end if
		}
		catch(NullPointerException e)
		{
			System.out.println("Wrong");
		}
	}//end nativeBayesCalcCough
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
	//methods used to transfer the counted values for sore throat
	public void nativeBayesCalcSThroat(int sThroatYCovidYes, int sThroatYCovidNo,int sThroatNCovidYes, int sThroatNCovidNo, int covidcountY,int covidcountN)
	{
		float fsThroatYCovidYes 	=sThroatYCovidYes;
		float fsThroatYCovidNo 		=sThroatYCovidNo;
		float fsThroatNCovidYes 	=sThroatNCovidYes;
		float fsThroatNCovidNo 		=sThroatNCovidNo;
		
		try
		{	
			if(SoreThroat.equals("yes"))
			{
				resultSoreThroatY = fsThroatYCovidYes / covidcountY;
				resultSoreThroatN = fsThroatYCovidNo / covidcountN;
			}//end if
			if(SoreThroat.equals("no"))
			{
				resultSoreThroatY = fsThroatNCovidYes / covidcountY;
				resultSoreThroatN = fsThroatNCovidNo / covidcountN;
			}//end if
		}
		catch(NullPointerException e)
		{
			System.out.println("Wrong");
		}
	}//end nativeBayesCalcSThroat
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
	//method used to transfer the counted values for recently traveled to danger zone
	public void nativeBayesCalcRTDZ(int RTDZYCovidYes, int RTDZYCovidNo,int RTDZNCovidYes, int RTDZNCovidNo, int covidcountY,int covidcountN)
	{
		float fRTDZYCovidYes 	=RTDZYCovidYes;
		float fRTDZYCovidNo 	=RTDZYCovidNo;
		float fRTDZNCovidYes 	=RTDZNCovidYes;
		float fRTDZNCovidNo 	=RTDZNCovidNo;
		
		try
		{
			if(RTDZ1.equals("yes"))
			{
				resultSoreThroatY = fRTDZYCovidYes / covidcountY;
				resultSoreThroatN = fRTDZYCovidNo / covidcountN;
			}//end if
			if(RTDZ1.equals("no"))
			{
				resultRTDZY = fRTDZNCovidYes / covidcountY;
				resultRTDZN = fRTDZNCovidNo / covidcountN;
			}//end if
		}
		catch(NullPointerException e)
		{
			System.out.println("Wrong");
		}
	}//end nativeBayesCalcSThroat
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
	//method used to transfer the counted values for the count of variables in the data and the covid counts
	//Also used to find out the final probability that the user has covid-19
	public void nativeBayesCalcProcess(int Process, int covidcountY, int covidcountN)
	{
		float fProcess 		= Process;
		float fcovidcountY 	= covidcountY;
		float fcovidcountN	= covidcountN;
		
		processYCountResult = fcovidcountY / fProcess;
		processNCountResult = fcovidcountN / fProcess;
		
		System.out.println(processYCountResult);
		System.out.println(processNCountResult);
		
		float resultYes = resultTempY * resultAchesY * resultCoughY * resultSoreThroatY * resultRTDZY * processYCountResult;
		float resultNo 	= resultTempN * resultAchesN * resultCoughN * resultSoreThroatN * resultRTDZN * processNCountResult;
		
		float resultTotal = resultYes + resultNo;
		
		float resultForYes = resultYes / resultTotal;
		float resultForNo = resultNo / resultTotal; 
		
		if(resultForYes > resultForNo)
		{
			System.out.println("You have covid-19 at a probability of:"+resultForYes+"/1");
			JOptionPane.showMessageDialog(this, "You have covid-19 at a probability of:"+resultForYes+"/1");
			Covid19 = "yes";
		}//end if
		else
		{
			System.out.println("You don't have covid-19 at a probability of:"+resultForNo+"/1");
			JOptionPane.showMessageDialog(this,"You don't have covid-19 at a probability of:"+resultForNo+"/1");
			Covid19 = "no";
		}//end else
	}//end nativeBayesCalcProcess
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
	// This method is used to write to the file with the values gotten from the gui
	public void WriteToFile()
	{
		try
		{
			FileWriter writeToDataSetF = new FileWriter("MLdata.csv", true);
			BufferedWriter writeToDataSetB = new BufferedWriter(writeToDataSetF);
			writeToDataSetB.write(Temp+","+Aches+","+Cough+","+SoreThroat+","+RTDZ1+","+Covid19+"\n");
			writeToDataSetB.flush();
			writeToDataSetB.close();
			writeToDataSetF.close();
			JOptionPane.showMessageDialog(this, "You have Wrote to the file");
			}
			catch(IOException e)
			{
				JOptionPane.showMessageDialog(this, "You have encountered an error");
			}//end catch
	}//end WriteToFile
	//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
}//end nativeBayes class
