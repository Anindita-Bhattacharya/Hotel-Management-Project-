import java.awt.Color;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import net.proteanit.sql.*;//this is inside jar rs2xml.jar
public class HotelManagement extends JFrame implements ActionListener{
	//in jframe we have labels,combo box,buttons etc
	
	HotelManagement(){
	setTitle("HOTEL MANAGEMENT SYSTEM");
	setBounds(2,100,1366,565);
	setVisible(true);
    ImageIcon li = new ImageIcon(ClassLoader.getSystemResource("firstt.jpeg"));
    JLabel jl=new JLabel(li);
    jl.setBounds(0, 0, 1366, 565);
    add(jl);
    JLabel l2= new JLabel("HOTEL MANAGEMENT SYSTEM");
    l2.setBounds(60,450,1000,70);//(left,top,width,height)
    jl.add(l2);//as we want to add the label on another label
    
    JButton b11=new JButton("Next");
    b11.setBackground(Color.white);
    b11.setForeground(Color.black);
    b11.setBounds(1000, 460, 130, 40);
    b11.addActionListener(this);
    jl.add(b11);//as we want to add the button on another label
    
    setLayout(null);

    setVisible(true);
    l2.setForeground(Color.WHITE);
    l2.setFont(new Font("serif",Font.PLAIN,50));// (style,font type,font size)
    //for dipping
    //using multithreading
    while(true)
    {
    	l2.setVisible(false);
    	try {
    		Thread.sleep(500);// (5 milli seconds) //here going
    	}catch(Exception e) {
    		l2.setVisible(true); //here coming
    	}
    	l2.setVisible(true);
    	try {
    	Thread.sleep(500);
    }catch (Exception e)
    	{
    	setLayout(null);
    	setVisible(true);
    	}
    }
    //we cannot keep image directly inside the frame
    //we should keep the image in jlabel
  //if we want to include any image in our project then we use ImaheIcon class
 //we have a class that is classLoader if we want to take any image from out laptop/desktop then we use this classloader 
 //inside ClassLoader we have a static method that is getSystemResource(image address)
    
    
	}
	public static void main(String[] args)
	{
	HotelManagement hm=new HotelManagement();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new Login().setVisible(true);
		//we made a login object and directly the login constructor will be called
		this.setVisible(false);
		//current class object that is hotel management front page to be closed
		
	}
	


}
