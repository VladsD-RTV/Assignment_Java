package com.assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import com.assignment.nativeBayes;
import com.assignment.medicalGUI;

public class FileProcessing
{
	//gloabal variables
	String fileName;
	File actualFile;
	
	public FileProcessing(String fileName)
	{
		//allocation the file name 
		this.fileName = fileName;
	}//end FileProcessing() 
	
	void openFile()
	{
		//allocating the file name to a variable 
		actualFile = new File(fileName);
	}//end openFile()
	
	public void readFile()
	{
		//token1 string to power the scanner
		String token1 		= "";
		//nessacesary variables to count the occurance of each word
		int i				= 0;
		int count 			= 0;
		int hotcount		= 0;
		int coolcount		= 0;
		int normalcount		= 0;
		int achescountY		= 0;
		int achescountN		= 0;
		int coughcountY		= 0;
		int coughcountN		= 0;
		int sThroatcountY	= 0;
		int sThroatcountN	= 0;
		int RTDZcountY		= 0;
		int RTDZcountN		= 0;
		int covidcountY		= 0;
		int covidcountN		= 0;
		
		//variables needed to count P(x|yes or no)
		int hotCovidYes		= 0;
		int hotCovidNo		= 0;
		int coolCovidYes	= 0;
		int coolCovidNo		= 0;
		int normalCovidYes	= 0;
		int normalCovidNo	= 0;
		//aches
		int achesYCovidYes	= 0;
		int achesYCovidNo	= 0;
		int achesNCovidYes	= 0;
		int achesNCovidNo	= 0;
		//cough
		int coughYCovidYes	= 0;
		int coughYCovidNo	= 0;
		int coughNCovidYes	= 0;
		int coughNCovidNo	= 0;
		//sore throat
		int sThroatYCovidYes= 0;
		int sThroatYCovidNo	= 0;
		int sThroatNCovidYes= 0;
		int sThroatNCovidNo	= 0;
		
		//recently traveled 
		int RTDZYCovidYes	= 0;
		int RTDZYCovidNo	= 0;
		int RTDZNCovidYes	= 0;
		int RTDZNCovidNo	= 0;
		
		//begin to access the file and start to find the values needed and store them into variables for future use
		try
		{
			//accessing the scanner to create a scan of the file
			Scanner myScanner = new Scanner(actualFile);
			
			//using a while loop to go through all the variables in the data and to also loop it so that the data is read
			while(myScanner.hasNext())
			{
				token1 = myScanner.next();
				//printing the token in a single line to show the read
				System.out.println(token1);
				//using the split to split the data into columns then reading each value and spliting them at the comma to represent the cloumn
				String[] tokenSplit = token1.split(",");
				//using a for loop to go through all six variables in the single line token
				for(i=0; i<6; i++)
				{
					/* This is the error correction for the data as through first run through different data appeared and calculations didn't make sense
					 * Thus adding of extra checks such as cap letters and also for the additional words such as "cool != cold" as an example.
					 * This will also allow for the user to add extras 
					 * Demo here>>
					*/
					if(i == 0)//checking numbers for temp
					{
						if(tokenSplit[i].equals("hot")|tokenSplit[i].equals("Hot"))
						{
							hotcount = hotcount + 1;
							
							//getting the P(hot|Yes) or P(hot|No)
							if(tokenSplit[5].equals("yes")|tokenSplit[5].equals("Yes"))
							{
								hotCovidYes = hotCovidYes + 1;
							}//end if 
							else
							{
								hotCovidNo = hotCovidNo + 1;
							}//end else
						}//end if
						if(tokenSplit[i].equals("cool")|tokenSplit[i].equals("cold"))
						{
							coolcount = coolcount + 1;
							
							//getting the P(cool|Yes) or P(cool|No)
							if(tokenSplit[5].equals("yes")|tokenSplit[5].equals("Yes"))
							{
								coolCovidYes = coolCovidYes + 1;
							}//end if 
							else
							{
								coolCovidNo = coolCovidNo + 1;
							}//end else
						}//end if
						if(tokenSplit[i].equals("normal"))
						{
							normalcount = normalcount + 1;
							
							//getting the P(normal|Yes) or P(normal|No)
							if(tokenSplit[5].equals("yes")|tokenSplit[5].equals("Yes"))
							{
								normalCovidYes = normalCovidYes + 1;
							}//end if 
							else
							{
								normalCovidNo = normalCovidNo + 1;
							}//end else
						}//end if
					}//end if for temp
					
					if(i==1)//checking for number of aches
					{
						if(tokenSplit[i].equals("yes")|tokenSplit[i].equals("Yes"))
						{
							achescountY	= achescountY + 1;
							
							//getting the P(aches|Yes) or P(aches|No)
							if(tokenSplit[5].equals("yes")|tokenSplit[5].equals("Yes"))
							{
								achesYCovidYes = achesYCovidYes + 1;
								
							}//end if 
							else
							{
								achesYCovidNo = achesYCovidNo + 1;
							}//end else
						}//end if
						if(tokenSplit[i].equals("no")|tokenSplit[i].equals("No"))
						{
							achescountN	= achescountN + 1;
							
							//getting the P(aches|Yes) or P(aches|No)
							if(tokenSplit[5].equals("yes")|tokenSplit[5].equals("Yes"))
							{
								achesNCovidYes = achesNCovidYes + 1;
								
							}//end if 
							else
							{
								achesNCovidNo = achesNCovidNo + 1;
							}//end else
						}//end if
					}//end if for aches
					
					if(i==2)//checking for number of cough
					{
						if(tokenSplit[i].equals("yes")|tokenSplit[i].equals("Yes"))
						{
							coughcountY	= coughcountY + 1;
							
							//getting the P(cough|Yes) or P(cough|No)
							if(tokenSplit[5].equals("yes")|tokenSplit[5].equals("Yes"))
							{
								coughYCovidYes = coughYCovidYes + 1;
								
							}//end if 
							else
							{
								coughYCovidNo = coughYCovidNo + 1;
							}//end else
						
						}//end if
						if(tokenSplit[i].equals("no")|tokenSplit[i].equals("No"))
						{
							coughcountN	= coughcountN + 1;
							
							//getting the P(cough|Yes) or P(cough|No)
							if(tokenSplit[5].equals("yes")|tokenSplit[5].equals("Yes"))
							{
								coughNCovidYes = coughNCovidYes + 1;
								
							}//end if 
							else
							{
								coughNCovidNo = coughNCovidNo + 1;
							}//end else
						}//end if
					}//end if for coughs
					
					if(i==3)//checking for number of sore throat
					{
						if(tokenSplit[i].equals("yes")|tokenSplit[i].equals("Yes"))
						{
							sThroatcountY	= sThroatcountY + 1;
							
							//getting the P(sore throat|Yes) or P(sore throat|No)
							if(tokenSplit[5].equals("yes")|tokenSplit[5].equals("Yes"))
							{
								sThroatYCovidYes = sThroatYCovidYes + 1;
								
							}//end if 
							else
							{
								sThroatYCovidNo = sThroatYCovidNo + 1;
							}//end else
						}//end if
						if(tokenSplit[i].equals("no")|tokenSplit[i].equals("No"))
						{
							sThroatcountN	= sThroatcountN + 1;
							
							//getting the P(sore throat|Yes) or P(sore throat|No)
							if(tokenSplit[5].equals("yes")|tokenSplit[5].equals("Yes"))
							{
								sThroatNCovidYes = sThroatNCovidYes + 1;
								
							}//end if 
							else
							{
								sThroatNCovidNo = sThroatNCovidNo + 1;
							}//end else
						}//end if
						
					}//end if for sore throat
					
					if(i==4)//checking for number of danger zone 
					{
						if(tokenSplit[i].equals("yes")|tokenSplit[i].equals("Yes"))
						{
							RTDZcountY	= RTDZcountY + 1;
							
							//getting the P(recently traveled danger zone|Yes) or P(recently traveled danger zone|No)
							if(tokenSplit[5].equals("yes")|tokenSplit[5].equals("Yes"))
							{
								RTDZYCovidYes = RTDZYCovidYes + 1;
								
							}//end if 
							else
							{
								RTDZYCovidNo = RTDZYCovidNo + 1;
							}//end else
						}//end if
						if(tokenSplit[i].equals("no")|tokenSplit[i].equals("No"))
						{
							RTDZcountN	= RTDZcountN + 1;
							
							//getting the P(recently traveled danger zone|Yes) or P(recently traveled danger zone|No)
							if(tokenSplit[5].equals("yes")|tokenSplit[5].equals("Yes"))
							{
								RTDZNCovidYes = RTDZNCovidYes + 1;
								
							}//end if 
							else
							{
								RTDZNCovidNo = RTDZNCovidNo + 1;
							}//end else
						}//end if
						
					}//end if for recently traveled in danger zone
					
					if(i==5)//checking for number of covid 19
					{
						if(tokenSplit[i].equals("yes")|tokenSplit[i].equals("Yes"))
						{
							covidcountY	= covidcountY + 1;
						}//end if
						if(tokenSplit[i].equals("no")|tokenSplit[i].equals("No"))
						{
							covidcountN	= covidcountN + 1;
						}//end if
						
					}//end if for covid-19
				}//end for
				count = count + 1;
				
			}//end while
		
			count = count-1;//-1 as there are 1 extra line that we don't use
			int processedcount = count;//used to represent the finished count
			
			//Output to the admin to show that all counts show correct amounts
			System.out.print(processedcount);
			System.out.println("\n");
			//hot temp
			System.out.println("The count of people with hot temp ="+hotcount);
			System.out.println("The count of people with hot temp with covid is ="+hotCovidYes+" People with hot temp with no covid is ="+hotCovidNo);
			//cool temp
			System.out.println("The count of people with cool temp ="+coolcount);
			System.out.println("The count of people with cool temp with covid is ="+coolCovidYes+" People with cool temp with no covid is ="+coolCovidNo);
			//notmal temp
			System.out.println("The count of people with normal temp ="+normalcount);
			System.out.println("The count of people with normal temp with covid is ="+normalCovidYes+" People with normal temp with no covid is ="+normalCovidNo);
			//aches
			System.out.println("The count of people with aches ="+achescountY);
			System.out.println("The count of people with no aches ="+achescountN);
			System.out.println("The count of people with aches and with covid is ="+achesYCovidYes+" People with aches and with no covid is ="+achesYCovidNo);
			System.out.println("The count of people with no aches and with covid is ="+achesNCovidYes+" People with no aches and with no covid is ="+achesNCovidNo);
			//cough
			System.out.println("The count of people with cough ="+coughcountY);
			System.out.println("The count of people with no cough ="+coughcountN);
			System.out.println("The count of people with cough and with covid is ="+coughYCovidYes+" People with cough and with no covid is ="+coughYCovidNo);
			System.out.println("The count of people with no cough and with covid is ="+coughNCovidYes+" People with no cough and with no covid is ="+coughNCovidNo);
			//sore throat
			System.out.println("The count of people with sore throat ="+sThroatcountY);
			System.out.println("The count of people with no sore throat ="+sThroatcountN);
			System.out.println("The count of people with sore throat and with covid is ="+sThroatYCovidYes+" People with sore throat and with no covid is ="+sThroatYCovidNo);
			System.out.println("The count of people with no sore throat and with covid is ="+sThroatNCovidYes+" People with no sore throat and with no covid is ="+sThroatNCovidNo);
			//recently in danger zone 
			System.out.println("The count of people who recent travel to danger zone ="+RTDZcountY);
			System.out.println("The count of people who no recent travel to danger zone ="+RTDZcountN);
			System.out.println("The count of people who recently traveled to danger zone and with covid is ="+RTDZYCovidYes+" People who recently traveled to danger zone and with no covid is ="+RTDZYCovidNo);
			System.out.println("The count of people who didn't recently traveled to danger zone and with covid is ="+RTDZNCovidYes+" People didn't who recently traveld to danger and with no covid is ="+RTDZNCovidNo);
			//have covid 19 totals
			System.out.println("The count of people with covid-19 ="+covidcountY);
			System.out.println("The count of people with no covid-19 ="+covidcountN);
			
		
			nativeBayes dataTempCountResults = new nativeBayes();
			nativeBayes dataAchesCountResults = new nativeBayes();
			nativeBayes dataCoughCountResults = new nativeBayes();
			nativeBayes dataSoreThroatCountResults = new nativeBayes();
			nativeBayes dataRTDZCountResults = new nativeBayes();
			nativeBayes dataProcessResults = new nativeBayes();
			
			dataTempCountResults.nativeBayesCalcTemp(hotCovidYes,hotCovidNo,coolCovidYes,coolCovidNo,normalCovidYes,normalCovidNo,covidcountY,covidcountN);
			dataAchesCountResults.nativeBayesCalcAches(achesYCovidYes,achesYCovidNo,achesNCovidYes,achesNCovidNo,covidcountY,covidcountN);
			dataCoughCountResults.nativeBayesCalcCough(coughYCovidYes,coughYCovidNo,coughNCovidYes,coughNCovidNo,covidcountY,covidcountN);
			dataSoreThroatCountResults.nativeBayesCalcSThroat(sThroatYCovidYes, sThroatYCovidNo, sThroatNCovidYes, sThroatNCovidNo, covidcountY, covidcountN);
			dataRTDZCountResults.nativeBayesCalcRTDZ(RTDZYCovidYes, RTDZYCovidNo, RTDZNCovidYes, RTDZNCovidNo, covidcountY, covidcountN);
			dataProcessResults.nativeBayesCalcProcess(processedcount, covidcountY, covidcountN);
			//count reset if user runs program again
			count = 0;
			//closing the scanner 
			myScanner.close();
			
			
		}//end try
		catch(FileNotFoundException e)
		{
			//TODO Auto-generated catch block
			System.out.println("Couldn't find the file");
			e.printStackTrace();
		}//end catch
	
	}//end readFile()
	
}//end FileProcessing
