package com.assignment.copy;

import com.assignment.medicalGUI;
import com.assignment.FileProcessing;


public class Control 
{
	public static void main(String[] args) 
	{
		//interaction with the GUI
		medicalGUI blah = new medicalGUI("Some Title");
		
		//Doing the file here
		FileProcessing myFile = new FileProcessing("MLdata.csv");
		myFile.openFile();
		//reading from the file
		myFile.readFile();
		
	}//end main
}//end control

