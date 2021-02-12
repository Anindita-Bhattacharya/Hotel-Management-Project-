import javax.swing.*;

import com.mysql.cj.protocol.Resultset;

import net.proteanit.sql.DbUtils;
import java.sql.*;

import java.awt.*;
import java.awt.event.*;
public class Rooms extends JFrame implements ActionListener
{
	JTable t1;
	JButton b1,b2;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	Rooms()
	{
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpeg"));
		Image  i2=i1.getImage().getScaledInstance(600, 700, Image.SCALE_DEFAULT);
		l1=new JLabel(i1);
		l1.setBounds(500,10,500,550);
		add(l1);
		
		l2=new JLabel("ROOMS");
		l2.setBounds(700,15,160,100);
		l2.setFont(new Font("serif",Font.BOLD,20));
		
		add(l2);
		
		l3=new JLabel("Room No.");
		l3.setBounds(0,0,100,60);
		l3.setFont(new Font("serif",Font.BOLD,15));
		add(l3);
		
		l4=new JLabel("Avaibility");
		l4.setBounds(89,0,100,60);
		l4.setFont(new Font("serif",Font.BOLD,15));
		add(l4);
		

		l5=new JLabel("Status");
		l5.setBounds(185,0,100,60);
		l5.setFont(new Font("serif",Font.BOLD,15));
		add(l5);
		
		l6=new JLabel("Price");
		l6.setBounds(275,0,100,60);
		l6.setFont(new Font("serif",Font.BOLD,15));
		add(l6);
		
		l7=new JLabel("Bed Type");
		l7.setBounds(345,0,100,60);
		l7.setFont(new Font("serif",Font.BOLD,15));
		add(l7);
		
		l8=new JLabel("Room Type");
		l8.setBounds(420,0,100,60);
		l8.setFont(new Font("serif",Font.BOLD,15));
		add(l8);
		
		
		
		
		t1=new JTable();
		t1.setBounds(0, 55, 500, 400);
		t1.setBackground(Color.cyan);
		add(t1);
		
		setLayout(null);
		setBounds(250,100,1000,600);
		setVisible(true);
		
		b1=new JButton("Load Data");
		b1.setBounds(100, 460, 120, 30);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton("Back");
		b2.setBounds(250, 460,120 , 30);
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.addActionListener(this);
		add(b2);
		
		
		getContentPane().setBackground(Color.cyan);
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==b1)
		{
			try {
			com c=new com();
			String str="select * from room";
			ResultSet r=c.s.executeQuery(str);
			t1.setModel(DbUtils.resultSetToTableModel(r));//in order to get the tables from the database
			
		}catch(Exception e){
			
		}
		}
		else if(ae.getSource()==b2) {
			this.setVisible(false);
		}
		}
	
	public static void main(String[] args)
	{
		new Rooms().setVisible(true);
	}

}
