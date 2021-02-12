import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.event.*;

import net.proteanit.sql.DbUtils;

public class PickUpService extends JFrame implements ActionListener{
	
	Choice c1;
	JButton b1,b2;
	JTable t1;
	JCheckBox c2;

	PickUpService()
	{
		JLabel l1=new JLabel("Pick Up Services");
		l1.setFont(new Font("Tahoma",Font.PLAIN,20));
		l1.setBounds(400,30,200,30);
		add(l1);
		
		JLabel l2=new JLabel("Car Type");
		l2.setFont(new Font("Tahoma",Font.PLAIN,15));
		l2.setBounds(50,100,200,20);
		add(l2);
		
		
		
		JLabel l3=new JLabel("Name");
		l3.setBounds(60,150,100,40);
		add(l3);
		
		JLabel l4=new JLabel("Age");
		l4.setBounds(240,150,100,40);
		add(l4);
		
		JLabel l5=new JLabel("Gender");
		l5.setBounds(390,150,100,40);
		add(l5);
		
		JLabel l6=new JLabel("Car Type");
		l6.setBounds(550,150,100,40);
		add(l6);
		
		JLabel l7=new JLabel("Car Model");
		l7.setBounds(720,150,100,40);
		add(l7);
		
		JLabel l8=new JLabel("Availibility");
		l8.setBounds(880,150,100,40);
		add(l8);
		
		
		c1=new Choice();
		try
		{
			com c=new com();
			ResultSet rs=c.s.executeQuery("select * from driver");
			while(rs.next())
			{
				c1.add(rs.getString("car_company"));
			}
		}
		catch(Exception e)
		{
			
		}
		c1.setBounds(150,100,200,25);
		add(c1);
		
		
		
		
		t1=new JTable();
		t1.setBounds(0,200,1000,300);
		add(t1);
		
		b1=new JButton("Submit");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(300,540,120,30);
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton("Back");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setBounds(500,540,120,30);
		b2.addActionListener(this);
		add(b2);
		
		
		
		
		setLayout(null);
		setBounds(220,70,1000,650);
		setVisible(true);
		
		getContentPane().setBackground(Color.white);
		
	}
	public static void main(String[] args)
	{
		PickUpService pus=new PickUpService();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		if(ae.getSource()==b1)
		{
			
				try {
					com c=new com();
					String str="select * from driver where car_company ='"+c1.getSelectedItem()+"'";
					
					ResultSet r=c.s.executeQuery(str);
					t1.setModel(DbUtils.resultSetToTableModel(r));//in order to get the tables from the database
					
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
		}
			else if(ae.getSource()==b2) {
				this.setVisible(false);
			}
		}
}

	







