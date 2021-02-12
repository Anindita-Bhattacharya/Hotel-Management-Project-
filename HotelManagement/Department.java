import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

import net.proteanit.sql.DbUtils;

public class Department extends JFrame implements ActionListener {
	
	JButton b1,b2;
	JTable t1;
	JCheckBox c2;

	Department()
	{
		
		
		
		
		
		
		JLabel l3=new JLabel("Department");
		l3.setBounds(100,10,100,40);
		add(l3);
		
		JLabel l4=new JLabel("Budget");
		l4.setBounds(350,10,100,40);
		add(l4);
		
		
		
		
		
		
		
		t1=new JTable();
		t1.setBounds(0,50,500,300);
		add(t1);
		
		b1=new JButton("Submit");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(180,400,120,30);
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton("Back");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setBounds(380,400,120,30);
		b2.addActionListener(this);
		add(b2);
		
		
		
		
		setLayout(null);
		setBounds(220,70,700,550);
		setVisible(true);
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		
	}
	public static void main(String[] args)
	{
		Department d=new Department();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		if(ae.getSource()==b1)
		{
			
				try {
					com c=new com();
					String str="select * from department";
					
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

	
