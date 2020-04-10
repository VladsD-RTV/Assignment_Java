/*	Program Name: Covid-19 database analise using native bayes law
 * 	Program Description:
 * 	Author : Vlads Drobovics
 * 	Compiler Used: eclipse
 * 	Start Date: 
*/
package com.assignment.copy;
//imports from java

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.util.*;
import java.awt.event.*;
import java.io.*;
import com.assignment.nativeBayes;
import com.assignment.nativeBayesConfig;

public class medicalGUI extends JFrame implements ActionListener, MouseListener
{
	//j prefix
	JButton reset, calculate;  
	JLabel titleLabel,menuSet,menuSet1,menuSet2,menuSet3,menuSet4;
	JPanel centrePanel,southPanel,northPanel,menuPanel,menuPanel1,menuPanel2,menuPanel3,menuPanel4;
	BufferedImage myCovid19Pic;
	JTextArea cb,cb1,cb2,cb3,cb4;
	//Variables used
	int count 			= 0;
	int check 			= 0;
	int check1 			= 0;
	int check2 			= 0;
	int check3 			= 0;
	int check4 			= 0;
	String temp 		= "";
	String aches		= "";
	String cough 		= "";
	String soreThroat 	= "";
	String RTDZ 		= "";
	
	public medicalGUI(String someTitle)
	{
		super(someTitle);
		//setting interface size
		centrePanel = new JPanel(new GridBagLayout()); 
		setSize(1000,1000);
		
		//setting up the buttons
		reset = new JButton("Reset the results");
		calculate = new JButton("Calculate chance of Covid-19");
		//setting up the label
		
		titleLabel = new JLabel("Covid-19 Test (This test is to find the percentage chance that the "
				+ "Person is infect with the Virsu checking their symtoms and their resent travel)");
		titleLabel.addMouseListener(this);
		titleLabel.setOpaque(true);
		
		
		//setting up the panels
		menuPanel = new JPanel(new GridBagLayout());
		menuPanel1 = new JPanel(new GridBagLayout());
		menuPanel2 = new JPanel(new GridBagLayout());
		menuPanel3 = new JPanel(new GridBagLayout());
		menuPanel4 = new JPanel(new GridBagLayout());
		
		
		//try if the image is there in the file
		try
		{
			myCovid19Pic = ImageIO.read(new File ("C:\\Users\\WORKSTATION\\.eclipse\\covid-19.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon(myCovid19Pic));
			centrePanel.add(picLabel);
			setVisible(true);
		}//end try
		catch (IOException e) 
		{
			e.printStackTrace();
		}//end catch
		
		menuSet = new JLabel("What kind of temperture does the patient have? (Answer(1=hot,2=normal,3=cool))");
		menuSet.setVisible(true);
		menuPanel.add(menuSet);
		
		//Aches panel/set
		menuSet1 = new JLabel("Do you have any Aches? (Answer(1=yes or 2=no))");
		menuSet1.setVisible(true);
		menuPanel1.add(menuSet1);
		
		//cough panel/set
		menuSet2 = new JLabel("Do you have a Cough? (Answer(1=yes or 2=no))");
		menuSet2.setVisible(true);
		menuPanel2.add(menuSet2);
		
		//Sore throat panel/set
		menuSet3 = new JLabel("Do you have a Sore throat? (Answer(1=yes or 2=no))");
		menuSet3.setVisible(true);
		menuPanel3.add(menuSet3);
		
		//Danger Zone panel/set
		menuSet4 = new JLabel("Have you recently been in a danger zone? (Answer(1=yes or 2=no))");
		menuSet4.setVisible(true);
		menuPanel4.add(menuSet4);
		
		//adding the text area
		cb = new JTextArea(1, 10);
		cb1 = new JTextArea(1, 10);
		cb2= new JTextArea(1, 10);
		cb3 = new JTextArea(1, 10);
		cb4 = new JTextArea(1, 10);
		
		//adding the Jcombobox menu string to the menus
		menuPanel.add(cb);
		menuPanel1.add(cb1);
		menuPanel2.add(cb2);
		menuPanel3.add(cb3);
		menuPanel4.add(cb4);
		
		//adding a way to align the menus horizontally
		GridBagConstraints XY = new GridBagConstraints();
		GridBagConstraints XY1 = new GridBagConstraints();
		GridBagConstraints XY2 = new GridBagConstraints();
		GridBagConstraints XY3 = new GridBagConstraints();
		GridBagConstraints XY4 = new GridBagConstraints();
		GridBagConstraints BR = new GridBagConstraints();
		GridBagConstraints BC = new GridBagConstraints();
		GridBagConstraints MT = new GridBagConstraints();
		
		//Menu 1
		XY.gridx = 0;
		XY.gridy = 5;
		centrePanel.add(menuPanel,XY);
		//Menu 2
		XY1.gridx = 0;
		XY1.gridy = 10;
		centrePanel.add(menuPanel1,XY1);
		//Menu 3
		XY2.gridx = 0;
		XY2.gridy = 15;
		//Menu 4
		centrePanel.add(menuPanel2,XY2);
		XY3.gridx = 0;
		XY3.gridy = 20;
		//Menu 5
		centrePanel.add(menuPanel3,XY3);
		XY4.gridx = 0;
		XY4.gridy = 25;
		centrePanel.add(menuPanel4,XY4);
		
		//adding the buttons
		reset.addActionListener(this);
		calculate.addActionListener(this);
		
		//button constraints
		BR.gridx = 0;
		BR.gridy = 40;
		centrePanel.add(reset,BR);
		BC.gridx = 0;
		BC.gridy = 45;
		centrePanel.add(calculate,BC);
		
		MT.gridx = 0;
		MT.gridy = 50;
		centrePanel.add(titleLabel,MT);
		
		add(centrePanel,BorderLayout.CENTER);
		setVisible(true);
		
	}//end MedicalGUI()
	
	public void actionPerformed(ActionEvent someEvent)
	{
		//if user uses the rest button
		if(someEvent.getSource() == reset) 
		{
			JOptionPane.showMessageDialog(this, "The interface has been reset");
			//changing all the texxt to nothing
			cb.setText("");
			cb1.setText("");
			cb2.setText("");
			cb3.setText("");
			cb4.setText("");

		}//end if
		if(someEvent.getSource() == calculate) 
		{
			try
			{
				check = Integer.parseInt(cb.getText());
				check1 = Integer.parseInt(cb1.getText());
				check2 = Integer.parseInt(cb2.getText());
				check3 = Integer.parseInt(cb3.getText());
				check3 = Integer.parseInt(cb4.getText());
			}
			catch(NumberFormatException nfe) 
			{
				JOptionPane.showMessageDialog(this, "One of the answers you entered was not a number");
			}
			
			if(cb.getText().matches("[1-3]"))
			{
				if(cb1.getText().matches("[1-2]"))
				{
					if(cb2.getText().matches("[1-2]"))
					{
						if(cb3.getText().matches("[1-2]"))
						{
							if(cb4.getText().matches("[1-2]"))
							{
								JOptionPane.showMessageDialog(this, "Calculation will display Now");
								//1-3 is for temperature readings in native bayes 
								if(cb.getText().matches("1"))
								{
									temp = "hot";
								}//end if
								if(cb.getText().matches("2"))
								{
									temp = "normal";
								}//end if
								if(cb.getText().matches("3"))
								{
									temp = "cool";
								}//end if
								
								//1-2 is yes no in the other sections.
								//Aches 
								if(cb1.getText().matches("1"))
								{
									aches = "yes";
								}//end if
								else
								{
									aches = "no";
								}//end if
								
								//Cough
								if(cb2.getText().matches("1"))
								{
									cough = "yes";
								}//end if
								else
								{
									cough = "no";
								}//end if
								
								//Sore Throat
								if(cb3.getText().matches("1"))
								{
									soreThroat = "yes";
								}//end if
								else
								{
									soreThroat = "no";
								}//end if
								
								//Recently Travel Danger Zone 
								if(cb4.getText().matches("1"))
								{
									RTDZ = "yes";
								}//end if
								else
								{
									RTDZ = "no";
								}//end if
								
								
							}//end if cb4
							else
							{
								JOptionPane.showMessageDialog(this, "You entered a wrong number in danger zone");
							}
						}//end if cb3
						else
						{
							JOptionPane.showMessageDialog(this, "You entered a wrong number in Sore throat");
						}
					}//end if cb2
					else
					{
						JOptionPane.showMessageDialog(this, "You entered a wrong number in cough");
					}
				}//end if cb1
				else
				{
					JOptionPane.showMessageDialog(this, "You entered a wrong number in aches");
				}
			}//end if cb 
			else
			{
				JOptionPane.showMessageDialog(this, "You entered a wrong number in Temperature");
			}
		}//end if 
	}//end actionPerformed()

	//Override Section
	@Override
	public void mouseClicked(MouseEvent anEvent)
	{
		
	}//end mouseCLicked()
	
	@Override
	public void mouseEntered(MouseEvent e)
	{
		
	}//end mouseEntered()
	
	@Override
	public void mouseExited(MouseEvent e)
	{
		
	}//end mouseExited()
	
	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
	}//end mousePressed()
	
	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
	}//end mousePressed()

}//end MedicalGUI ()
