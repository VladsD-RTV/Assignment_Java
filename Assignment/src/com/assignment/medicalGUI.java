/*	Program Name: Covid-19 database analise using native bayes law
 * 	Program Description:
 * 	Author : Vlads Drobovics
 * 	Compiler Used: eclipse
 * 	Start Date: 25th March 2020 do out initial processing of the GUI and the main concepts as well as learn how to do menu items with JComboBox.
 * 				1th April Finishing GUI positions and cleaning up the code with labeling.
 * 				5th April Complete the GUI have a fully functional GUI component that will now be able to link with the fileProccessor.
 * 				6th April File Processor Class start and also align the  
*/
package com.assignment;
//imports from java
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class medicalGUI extends JFrame implements ActionListener, MouseListener
{
	
	JButton reset, calculate;  
	JLabel titleLabel,menuSet,menuSet1,menuSet2,menuSet3,menuSet4;
	JPanel centrePanel,southPanel,northPanel,menuPanel,menuPanel1,menuPanel2,menuPanel3,menuPanel4;
	JTextArea mainText,sideText;
	BufferedImage myCovid19Pic;
	
	public medicalGUI(String someTitle)
	{
		super(someTitle);
		//setting interface size
		setSize(1000,1000);
		
		//setting up the buttons
		reset = new JButton("Reset the results");
		calculate = new JButton("Calculate chance of Covid-19");
		//setting up the label
		
		titleLabel = new JLabel("Covid-19 Test");
		titleLabel.addMouseListener(this);
		titleLabel.setOpaque(true);
		
		//setting up the panels
		menuPanel = new JPanel();
		menuPanel1 = new JPanel();
		menuPanel2 = new JPanel();
		menuPanel3 = new JPanel();
		menuPanel4 = new JPanel();
		
		//temp panel/set
		menuSet = new JLabel("What kind of temperture does the patient have?");
		menuSet.setVisible(true);
		menuPanel.add(menuSet);
		
		//cough panel/set
		menuSet1 = new JLabel("Do you have any Aches?");
		menuSet1.setVisible(true);
		menuPanel1.add(menuSet1);
		
		//cough panel/set
		menuSet2 = new JLabel("Do you have a Cough?");
		menuSet2.setVisible(true);
		menuPanel2.add(menuSet2);
		
		//cough panel/set
		menuSet3 = new JLabel("Do you have a Sore throat");
		menuSet3.setVisible(true);
		menuPanel3.add(menuSet3);
		
		//cough panel/set
		menuSet4 = new JLabel("Have you recently been in a danger zone?");
		menuSet4.setVisible(true);
		menuPanel4.add(menuSet4);
		
		centrePanel = new JPanel();
		
		//adding the options string typing
		String[] Temp = {"hot", "normal","cool"};
		String[] choices = {"Yes","No"};
		//Using the JComboBox to allow for choices for all my options.
		final JComboBox<String> cb = new JComboBox<String>(Temp);
		final JComboBox<String> cb1 = new JComboBox<String>(choices);
		final JComboBox<String> cb2 = new JComboBox<String>(choices);
		final JComboBox<String> cb3 = new JComboBox<String>(choices);
		final JComboBox<String> cb4 = new JComboBox<String>(choices);
		
		cb.setVisible(true);
		menuPanel.add(cb);
		menuPanel1.add(cb1);
		menuPanel2.add(cb2);
		menuPanel3.add(cb3);
		menuPanel4.add(cb4);
		add(menuPanel,BorderLayout.CENTER);
		menuPanel.setAlignmentX(0);
		add(menuPanel1,BorderLayout.CENTER);
		menuPanel.setAli;
		add(menuPanel2,BorderLayout.NORTH);
		add(menuPanel3,BorderLayout.AFTER_LAST_LINE);
		add(menuPanel4,BorderLayout.AFTER_LAST_LINE);
		
		//adding the buttons
		reset.addActionListener(this);
		calculate.addActionListener(this);
		
		//try if the image is there in the file
		try
		{
			myCovid19Pic = ImageIO.read(new File ("C:\\Users\\WORKSTATION\\.eclipse\\covid-19.jpg"));
			
		}//end try
		catch (IOException e) 
		{
			e.printStackTrace();
		}//end catch
		centrePanel.add(titleLabel);
		add(centrePanel, BorderLayout.NORTH);
		setVisible(true);
		
		JLabel picLabel = new JLabel(new ImageIcon(myCovid19Pic));
		centrePanel.add(picLabel);
		
		
		
		
		//adding the different panels for the generated screen
		
	}//end MedicalGUI()
	
	public void actionPerformed(ActionEvent someEvent)
	{
		
		if(someEvent.getSource() == reset) 
		{
			JOptionPane.showMessageDialog(this, "The interface has been reset");
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
