import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
public class AddRooms extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField t1,t2;
	JButton b1,b2;
	JComboBox c1,c2,c3,c4;
	AddRooms()
	{
		setTitle("ADD ROOMS");
		setBounds(250,120,1000,500);
		setLayout(null);
		setVisible(true);
		
		JLabel l3=new JLabel("ADD ROOMS");
		l3.setFont(new Font("Tahoma",Font.BOLD,18));
		l3.setBounds(250,20,250,20);
		add(l3);

		
		l1=new JLabel("Room Number");
		l1 .setFont(new Font("Tahoma",Font.BOLD,16));
		l1.setBounds(60,80,120,30);
		add(l1 );
		
		t1=new JTextField();
		t1.setBounds(200,80,150,30);
		add(t1);
		
		l2=new JLabel("Avaibility");
		l2 .setFont(new Font("Tahoma",Font.BOLD,16));
		l2.setBounds(60,130,120,30);
		add(l2 );
		
		
		String str[]= {"Available","Not Available"};
		c1=new JComboBox(str);
		c1.setBounds(200,130,150,30);
		c1.setBackground(Color.white);
		add(c1);

		l3=new JLabel("Cleaning Status");
		l3 .setFont(new Font("Tahoma",Font.BOLD,16));
		l3.setBounds(60,180,150,30);
		add(l3 );
		
		String str1[]= {"Clean","Not Clean"};
		c2=new JComboBox(str1);
		c2.setBounds(200,180,150,30);
		c2.setBackground(Color.white);
		add(c2);
		
		
		
		l4=new JLabel("Price");
		l4.setFont(new Font("Tahoma",Font.BOLD,16));
		l4.setBounds(60,230,120,30);
		add(l4 );
		

		t2=new JTextField();
		t2.setBounds(200,230,150,30);
		add(t2);
		
		l5=new JLabel("Bed Type");
		l5.setFont(new Font("Tahoma",Font.BOLD,16));
		l5.setBounds(60,280,120,30);
		add(l5 );
		
		String str2[]= {"Single Bed","Double Bed"};
		c3=new JComboBox(str2);
		c3.setBounds(200,280,150,30);
		c3.setBackground(Color.white);
		add(c3);
		
		l6=new JLabel("Room Type");
		l6.setFont(new Font("Tahoma",Font.BOLD,16));
		l6.setBounds(60,330,120,30);
		add(l6 );
		
		String str3[]= {"AC","Non-AC"};
		c4=new JComboBox(str3);
		c4.setBounds(200,330,150,30);
		c4.setBackground(Color.white);
		add(c4);


		
		 b1=new JButton("Add Rooms");
		b1.setBounds(60,380,130,30);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.addActionListener(this);
		add(b1);
		
	    b2=new JButton("Cancel");
		b2.setBounds(220,380,130,30);
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpeg"));
		JLabel l8=new JLabel(i1);
		l8.setBounds(450,30,500,400);
		add(l8);
		
		getContentPane().setBackground(Color.white);
		
		

		
		
		
	}
	public static void main(String[] args)
	{
		AddRooms ar=new AddRooms();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==b1)
		{
			String room=t1.getText();
			String avaibility=(String) c1.getSelectedItem();
			String status=(String) c2.getSelectedItem();
			String price=t2.getText();
			String bed_type=(String) c3.getSelectedItem();
			String room_type=(String) c4.getSelectedItem();
			
			com c=new com();
			try {
				
			String str1="insert into room values('"+room+"','"+avaibility+"','"+status+"','"+price+"','"+bed_type+"','"+room_type+"')";
			c.s.executeUpdate(str1);
			JOptionPane.showMessageDialog(null,"New Room Added");
			this.setVisible(false);
			
			}catch(Exception e)
			{
				System.out.println(e);
			}
			
			
		}else if(ae.getSource()==b2) {
			this.setVisible(false);
		}
		
	}
	
}
