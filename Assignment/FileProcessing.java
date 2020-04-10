package com.assignment.copy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcessing
{
	
	//gloabal variables
	String fileName;
	File actualFile;
	
	public FileProcessing(String fileName)
	{
		this.fileName = fileName;
	}//end FileProcessing() 
	
	void openFile()
	{
		actualFile = new File(fileName);
	}//end openFile()
	
	public void readFile()
	{
		int i				= 0;
		String token1 		= "";
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
		
		try
		{
			Scanner myScanner = new Scanner(actualFile);
			while(myScanner.hasNext())
			{
				token1 = myScanner.next();
				System.out.println(token1);
				String[] tokenSplit = token1.split(",");
				for(i=0; i<6; i++)
				{
					if(i == 0)//checking numbers for temp
					{
						if(tokenSplit[i].equals("hot"))
						{
							hotcount = hotcount + 1;
						}//end if
						if(tokenSplit[i].equals("cool"))
						{
							coolcount = coolcount + 1;
						}//end if
						if(tokenSplit[i].equals("normal"))
						{
							normalcount = normalcount + 1;
						}//end if
					}//end if for temp
					
					if(i==1)//checking for number of aches
					{
						if(tokenSplit[i].equals("yes"))
						{
							achescountY	= achescountY + 1;
						}//end if
						if(tokenSplit[i].equals("no"))
						{
							achescountN	= achescountN + 1;
						}//end if
					}//end if for aches
					
					if(i==2)//checking for number of aches
					{
						if(tokenSplit[i].equals("yes"))
						{
							coughcountY	= coughcountY + 1;
						}//end if
						if(tokenSplit[i].equals("no"))
						{
							coughcountN	= coughcountN + 1;
						}//end if
					}//end if for coughs
					
					if(i==3)//checking for number of aches
					{
						if(tokenSplit[i].equals("yes"))
						{
							sThroatcountY	= sThroatcountY + 1;
						}//end if
						if(tokenSplit[i].equals("no"))
						{
							sThroatcountN	= sThroatcountN + 1;
						}//end if
						
					}//end if for sore throat
					
					if(i==4)//checking for number of aches
					{
						if(tokenSplit[i].equals("yes"))
						{
							RTDZcountY	= RTDZcountY + 1;
						}//end if
						if(tokenSplit[i].equals("no"))
						{
							RTDZcountN	= RTDZcountN + 1;
						}//end if
						
					}//end if for recently traveled in danger zone
					
					if(i==5)//checking for number of aches
					{
						if(tokenSplit[i].equals("yes"))
						{
							covidcountY	= covidcountY + 1;
						}//end if
						if(tokenSplit[i].equals("no"))
						{
							covidcountN	= covidcountN + 1;
						}//end if
						
					}//end if for covid-19
				}//end for
				count = count + 1;
				
			}//end while
		
			count = count-1;//-1 as there are 1 extra line that we don't use
			int processedcount = count;
			System.out.print(processedcount);
			System.out.println("\n");
			System.out.println("The count of people with hot temp ="+hotcount);
			System.out.println("The count of people with cool temp ="+coolcount);
			System.out.println("The count of people with normal temp ="+normalcount);
			System.out.println("The count of people with aches ="+achescountY);
			System.out.println("The count of people with no aches ="+achescountN);
			System.out.println("The count of people with cough ="+coughcountY);
			System.out.println("The count of people with no cough ="+coughcountN);
			System.out.println("The count of people with sore throat ="+sThroatcountY);
			System.out.println("The count of people with no sore throat ="+sThroatcountN);
			System.out.println("The count of people with recent travel to danger zone ="+RTDZcountY);
			System.out.println("The count of people with no recent travel to danger zone ="+RTDZcountN);
			System.out.println("The count of people with covid-19 ="+covidcountY);
			System.out.println("The count of people with no covid-19 ="+covidcountN);
			
			count = 0;
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
