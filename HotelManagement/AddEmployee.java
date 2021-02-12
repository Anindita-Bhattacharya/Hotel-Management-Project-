import java.awt.Color;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class AddEmployee extends JFrame implements ActionListener
{
	JLabel l1,l2;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JRadioButton r1,r2;
	JComboBox c1;
	JButton b1,b2;
	AddEmployee()
	{
		setTitle("ADD EMPLOYEES");
		l1=new JLabel("NAME");
		 l1 .setFont(new Font("Tahoma",Font.BOLD,17));
		 l1.setBounds(60,30,120,30);
		add(l1);
		
		t1=new JTextField();
		t1.setBounds(200,30,150,30);
		add(t1);
		
		 l2=new JLabel("AGE");
		 l2 .setFont(new Font("Tahoma",Font.BOLD,17));
		 l2.setBounds(60,80,150,30);
		 add(l2);
		
		t2=new JTextField();
		t2.setBounds(200,80,150,30);
		add(t2);
		

		JLabel Gender =new JLabel("GENDER");
		 Gender .setFont(new Font("Tahoma",Font.BOLD,17));
		 Gender .setBounds(60,130,150,30);
		add( Gender );
		
		r1=new JRadioButton("Male");
		r1.setBounds(200,130,70,30);
		r1.setFont(new Font("Tahoma",Font.BOLD,14));
		r1.setBackground(Color.white);
		add(r1);
		
		r2=new JRadioButton("Female");
		r2.setBounds(280,130,70,30);
		r2.setFont(new Font("Tahoma",Font.BOLD,14));
		r2.setBackground(Color.white);

		add(r2);
		
		JLabel Job =new JLabel("JOB");
		 Job .setFont(new Font("Tahoma",Font.BOLD,17));
		 Job  .setBounds(60,180,150,30);
		add( Job  );
		
		String str[]= {"Front Desk Clerks","Waiters","House Keeping","Manager","kitech Staff","Room Services","Chefs","Accountant","Receptionist"};
		c1=new JComboBox(str);
		c1.setBounds(200,180,150,30);
		c1.setBackground(Color.white);

		add(c1);
		
		
		
		JLabel Salary =new JLabel("SALARY");
		Salary .setFont(new Font("Tahoma",Font.BOLD,17));
		Salary.setBounds(60,230,150,30);
		add( Salary );
		
		t3=new JTextField();
		t3.setBounds(200,230,150,30);
		add(t3);
		
		JLabel Phone=new JLabel("PHONE");
		Phone .setFont(new Font("Tahoma",Font.BOLD,17));
		Phone.setBounds(60,280,150,30);
		add( Phone );
		
		t4=new JTextField();
		t4.setBounds(200,280,150,30);
		add(t4);
		
		JLabel Adhar =new JLabel("ADHAR");
		Adhar .setFont(new Font("Tahoma",Font.BOLD,17));
		Adhar.setBounds(60,330,150,30);
		add( Adhar );
		
		t5=new JTextField();
		t5.setBounds(200,330,150,30);
		add(t5);
		
		JLabel Email =new JLabel("EMAIL");
		Email .setFont(new Font("Tahoma",Font.BOLD,17));
		Email.setBounds(60,380,150,30);
		add(Email );
		
		t6=new JTextField();
		t6.setBounds(200,380,150,30);
		add(t6);
		
		JLabel Address =new JLabel("ADDRESS");
		Address .setFont(new Font("Tahoma",Font.BOLD,17));
		Address.setBounds(60,430,150,30);
		add(Address );
		
		t7=new JTextField();
		t7.setBounds(200,430,150,30);
		add(t7);
		
		
		
		b1=new JButton("Submit");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(40,480,150,30);
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton("Cancel");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setBounds(220,480,150,30);
		b2.addActionListener(this);

		add(b2);
		
	
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpeg"));
		Image i2=i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel l6=new JLabel(i3);
		l6.setBounds(380,60,450,450);
		add(l6);
		
		JLabel l8=new JLabel("ADD EMPLOYEE DETAILS");
		l8.setForeground(Color.BLUE);
		l8 .setFont(new Font("Tahoma",Font.BOLD,30));
		l8.setBounds(420, 30, 400, 30);
		add(l8);
		
		getContentPane().setBackground(Color.white);
		
		
		
		
		setLayout(null);
		setBounds(350,100,900,600);
		setVisible(true);
	}
public static void main(String[] args)
{
	AddEmployee ae=new AddEmployee();
}
@Override
//whenevr an interface is implemented the method (abstract) should be overrided
public void actionPerformed(ActionEvent ae) {
	
	// TODO Auto-generated method stub
	if(ae.getSource()==b1)
	{
	String name=t1.getText();
	String age=t2.getText();
	String salary=t3.getText();
	String Phone=t4.getText();
	String Adhar=t5.getText();
	String Email=t6.getText();
	String Address=t7.getText();
	String gender=null;
	if(r1.isSelected())
	{
		gender="Male";
	}
	else if(r2.isSelected())
	{
		gender="Female";
	}
	




	String Job=(String) c1.getSelectedItem();
	com c=new com();
	String str="Insert into employee values('"+name+"','"+age+"','"+gender+"','"+Job+"','"+salary+"','"+Phone+"','"+Adhar+"','"+Email+"','"+Address+"')";
	try {
		c.s.executeUpdate(str); //to keep values in database
		JOptionPane.showMessageDialog(null, "New Employee Added");
		this.setVisible(false);
	}catch(Exception e){
		System.out.println(e);
	}
	}

else if(ae.getSource()==b2)
{
	this.setVisible(false); //when we click on cancel button then the AddEmployee window will not be visible here this refers to constructor
}
}
	
	
	
	
}

