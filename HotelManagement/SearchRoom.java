import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class SearchRoom extends JFrame implements ActionListener
{
	JComboBox c1;
	JCheckBox c2;
	JButton b1,b2;
	JTable t1;
	SearchRoom()
	{
		JLabel l1=new JLabel("Search for Room");
		l1.setFont(new Font("Tahoma",Font.PLAIN,20));
		l1.setBounds(400,30,200,30);
		add(l1);
		
		JLabel l3=new JLabel("Room Number");
		l3.setBounds(45,150,100,30);
		add(l3);
		
		JLabel l4=new JLabel("Availibility");
		l4.setBounds(220,150,100,30);
		add(l4);
		
		JLabel l5=new JLabel("Room Status");
		l5.setBounds(380,150,100,30);
		add(l5);
		
		JLabel l6=new JLabel("Price");
		l6.setBounds(570,150,100,30);
		add(l6);
		
		JLabel l7=new JLabel("Bed Type");
		l7.setBounds(710,150,100,30);
		add(l7);
		
		JLabel l8=new JLabel("Room Type");
		l8.setBounds(860,150,100,30);
		add(l8);
		
		
		JLabel l2=new JLabel("Room Bed Type");
		l2.setFont(new Font("Tahoma",Font.PLAIN,15));
		l2.setBounds(50,100,200,20);
		add(l2);
		
		c1=new JComboBox(new String[] {"Single Bed","Double Bed"});
		c1.setBounds(170,100,150,25);
		c1.setBackground(Color.white);
		add(c1);
		
		c2=new JCheckBox("Only Display Available");
		c2.setBounds(650,100,150,25);
		add(c2);
		
		
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
		
	}
	public static void main(String[] args)
	{
		SearchRoom sr=new SearchRoom();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		if(ae.getSource()==b1)
		{
			
				try {
					com c=new com();
					String str="select * from room where bed_type ='"+c1.getSelectedItem()+"'";
					String str2="select * from room where available='Available' and bed_type ='"+c1.getSelectedItem()+"'";
					ResultSet r=c.s.executeQuery(str);
					
					t1.setModel(DbUtils.resultSetToTableModel(r));//in order to get the tables from the database
					if(c2.isSelected())
					{
						ResultSet rs2=c.s.executeQuery(str2);
						t1.setModel(DbUtils.resultSetToTableModel(rs2));
					}
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

	



