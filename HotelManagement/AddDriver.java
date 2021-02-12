import javax.swing.*;


import java.awt.*;
import java.awt.event.*;


public class AddDriver extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JTextField t1,t2,t3,t4,t5;
	JRadioButton r1,r2;
	JButton b1,b2;
	JComboBox c1;
	AddDriver() //Constructor
	{
		l2=new JLabel("ADD DRIVERS");
		l2.setBounds(150,10,150,30);
		l2.setFont(new Font("Tahoma",Font.BOLD,18));
		add(l2);
		
		l1=new JLabel("Name");
		l1.setBounds(60,70,100,30);
		l1.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l1);
		
		t1=new JTextField();
		t1.setBounds(200, 70, 150, 30);
		add(t1);
		
		l3=new JLabel("Age");
		l3.setBounds(60,110,100,30);
		l3.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l3);
		
		t2=new JTextField();
		t2.setBounds(200, 110, 150, 30);
		add(t2);
		
		l4=new JLabel("Gender");
		l4.setBounds(60,150,100,30);
		l4.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l4);
		
		r1=new JRadioButton("Male");
		r1.setBounds(200,150,70,30);
		r1.setFont(new Font("Tahoma",Font.BOLD,14));
		add(r1);
		
		r2=new JRadioButton("Female");
		r2.setBounds(280,150,85,30);
		r2.setFont(new Font("Tahoma",Font.BOLD,14));

		add(r2);

		
		
		l5=new JLabel("Car Company");
		l5.setBounds(60,190,100,30);
		l5.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l5);
		
		t3=new JTextField();
		t3.setBounds(200, 190, 150, 30);
		add(t3);
		
		l6=new JLabel("Car Model");
		l6.setBounds(60,230,100,30);
		l6.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l6);
		
		t4=new JTextField();
		t4.setBounds(200, 230, 150, 30);
		add(t4);

		
		
		l7=new JLabel("Availibility");
		l7.setBounds(60,270,100,30);
		l7.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(l7);
		
		String str[]= {"Available","Not Available"};
		c1=new JComboBox(str);
		c1.setBounds(200,270,100,30);
		c1.setBackground(Color.white);
		add(c1);
		
		 b1=new JButton("Add Drivers");
			b1.setBounds(60,350,130,30);
			b1.setBackground(Color.black);
			b1.setForeground(Color.white);
			b1.addActionListener(this);
			
			add(b1);
			
		    b2=new JButton("Cancel");
			b2.setBounds(220,350,130,30);
			b2.setBackground(Color.black);
			b2.setForeground(Color.white);
			b2.addActionListener(this);
			add(b2);
		
			getContentPane().setBackground(Color.white);
			
			ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpeg"));
			Image i2=i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
			ImageIcon i3=new ImageIcon(i2);
			l8=new JLabel(i3);
			l8.setBounds(400,50,500,300);
			add(l8);
			
		setLayout(null);
		setBounds(300,120,1000,450);
		setBackground(Color.white);
		setVisible(true);
		
	}
	public static void main(String[] args)
	{
		AddDriver ar=new AddDriver();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==b1)
		{
		String name=t1.getText();
		String age=t2.getText();
		String gender=null;
		String car_company = t3.getText();
		String car_model = t4.getText();
		String avaiibility=(String) c1.getSelectedItem();
		if(r1.isSelected())
		{
			gender="Male";
		}
		else if(r2.isSelected())
		{
			gender="Female";
		}
		com c=new com();
		String str1="Insert into driver values('"+name+"','"+age+"','"+gender+"','"+car_company +"','"+car_model+"','"+avaiibility+"')";
		try {
			c.s.executeUpdate(str1); //to keep values in database
			JOptionPane.showMessageDialog(null, "New Driver Added");
			this.setVisible(false);
		}catch(Exception e){
			System.out.println(e);
		}
		}

	else if(ae.getSource()==b2)
	{
		this.setVisible(false);
	}
	}
		
		
		
	}

