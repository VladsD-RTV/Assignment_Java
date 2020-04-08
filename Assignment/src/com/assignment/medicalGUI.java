/*	Program Name: Covid-19 database analise using native bayes law
 * 	Program Description:
 * 	Author : Vlads Drobovics
 * 	Compiler Used: eclipse
 * 	Start Date: 
*/
package com.assignment;
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

public class medicalGUI extends JFrame implements ActionListener, MouseListener
{
	
	JButton reset, calculate;  
	JLabel titleLabel,menuSet,menuSet1,menuSet2,menuSet3,menuSet4;
	JPanel centrePanel,southPanel,northPanel,menuPanel,menuPanel1,menuPanel2,menuPanel3,menuPanel4;
	BufferedImage myCovid19Pic;
	JComboBox<String> cb,cb1,cb2,cb3,cb4;
	int count = 0;
	
	
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
		
		menuSet = new JLabel("What kind of temperture does the patient have? ");
		menuSet.setVisible(true);
		menuPanel.add(menuSet);
		
		//Aches panel/set
		menuSet1 = new JLabel("Do you have any Aches? ");
		menuSet1.setVisible(true);
		menuPanel1.add(menuSet1);
		
		//cough panel/set
		menuSet2 = new JLabel("Do you have a Cough? ");
		menuSet2.setVisible(true);
		menuPanel2.add(menuSet2);
		
		//Sore throat panel/set
		menuSet3 = new JLabel("Do you have a Sore throat? ");
		menuSet3.setVisible(true);
		menuPanel3.add(menuSet3);
		
		//Danger Zone panel/set
		menuSet4 = new JLabel("Have you recently been in a danger zone? ");
		menuSet4.setVisible(true);
		menuPanel4.add(menuSet4);
		
		//adding the options string typing
		String[] Temp = {" ","hot", "normal","cool"};
		String[] choices = {" ","Yes","No"};
		//Using the JComboBox to allow for choices for all my options.
		JComboBox<String> cb = new JComboBox<String>(Temp);
		JComboBox<String> cb1 = new JComboBox<String>(choices);
		JComboBox<String> cb2 = new JComboBox<String>(choices);
		JComboBox<String> cb3 = new JComboBox<String>(choices);
		JComboBox<String> cb4 = new JComboBox<String>(choices);
		
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
	
	public void clearAll(int count)
	{
		if(count == 1)
		{
			System.out.println("works");
			cb.setSelectedIndex(0);
		}
		
	}
	
	public void actionPerformed(ActionEvent someEvent)
	{
		//if user uses the rest button
		if(someEvent.getSource() == reset) 
		{
			JOptionPane.showMessageDialog(this, "The interface has been reset");
			count = 1;
			System.out.print(count);
			
			clearAll(count);
				
			
		}//end if
		
		if(someEvent.getSource() == calculate) 
		{
			JOptionPane.showMessageDialog(this, "Calculation will display Now");
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
