import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class AddCustomer extends JFrame implements ActionListener{

JTextField t1,t2,t3,t4,t5; //if J is in front means it is in swing package
JButton b1,b2;
JComboBox c1;
JRadioButton r1,r2;
Choice c2; //this is in awt package here J is not there in beginning

	AddCustomer()
	{
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fifthy.jpeg"));
		JLabel l10=new JLabel(i1);
		l10.setBounds(450,30,400,400);
		add(l10);
		
		JLabel l1=new JLabel("NEW CUSTOMER FORM");
		l1.setBounds(100,20,300,30);
		l1.setFont(new Font("Tahoma",Font.BOLD,15));
		l1.setForeground(Color.BLUE);
		add(l1);
		
		
		
		JLabel l2=new JLabel("ID");
		l2.setBounds(35,80,100,20);
		l2.setFont(new Font("Tahoma",Font.BOLD,12));
		add(l2);
		
		c1=new JComboBox(new String[] {"Passport","Voter ID","Driving License","Adhar Card"});
		c1.setBackground(Color.white);
		c1.setBounds(200,80,150,25);
		add(c1);
		
		JLabel l3=new JLabel("Number");
		l3.setBounds(35,120,100,20);
		l3.setFont(new Font("Tahoma",Font.BOLD,12));
		add(l3);
		
		t1=new JTextField();
		t1.setBounds(200,120,150,25);
		add(t1);
		
		JLabel l4=new JLabel("Gender");
		l4.setBounds(35,160,100,20);
		l4.setFont(new Font("Tahoma",Font.BOLD,12));
		add(l4);
		
		r1=new JRadioButton("Male");
		r1.setBounds(200,160,60,25);
		r1.setBackground(Color.white);
		add(r1);
		
		r2=new JRadioButton("Female");
		r2.setBounds(270,160,75,25);
		r2.setBackground(Color.white);
		add(r2);
		
		JLabel l5=new JLabel("Name");
		l5.setBounds(35,200,100,20);
		l5.setFont(new Font("Tahoma",Font.BOLD,12));
		add(l5);
		
		t2=new JTextField();
		t2.setBounds(200,195,150,25);
		add(t2);
		
		JLabel l6=new JLabel("Country");
		l6.setBounds(35,240,100,20);
		l6.setFont(new Font("Tahoma",Font.BOLD,12));
		add(l6);
		
		t3=new JTextField();
		t3.setBounds(200,235,150,25);
		add(t3);
		
		JLabel l7=new JLabel("Allocation");
		l7.setBounds(35,280,100,20);
		l7.setFont(new Font("Tahoma",Font.BOLD,12));
		add(l7);
		
		c2=new Choice();
		try
		{
			com c=new com();
			String str="select * from room";
			ResultSet rs=c.s.executeQuery(str);
			while(rs.next()) { //to travel till the end of the table next means columns
				c2.add(rs.getString("room_number"));
			}
			
		}
		catch(Exception e)
		{
		}
		
			c2.setBounds(200,275,150,25);
			add(c2);
		
		JLabel l8=new JLabel("Checked In");
		l8.setBounds(35,320,100,20);
		l8.setFont(new Font("Tahoma",Font.BOLD,12));
		add(l8);
		
		t4 =new JTextField();
		t4.setBounds(200,315,150,25);
		add(t4);
		
		JLabel l9=new JLabel("Deposit");
		l9.setBounds(35,360,100,20);	
		l9.setFont(new Font("Tahoma",Font.BOLD,12));
		add(l9);
		
		t5=new JTextField();
		t5.setBounds(200,355,150,25);
		add(t5);
		
		b1=new JButton("Add Customer");
		b1.setForeground(Color.white);
		b1.setBackground(Color.black);
		b1.setBounds(30,430,130,25);
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton("Back");
		b2.setForeground(Color.white);
		b2.setBackground(Color.black);
		b2.setBounds(230,430,130,25);
		b2.addActionListener(this);
		add(b2);
		
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		setBounds(250,100,900,530);
		setVisible(true);
	}
	public static void main(String[] args)
	{
		AddCustomer ac=new AddCustomer();
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		String ID=(String) c1.getSelectedItem();
		String Number=t1.getText();
		String Gender=null;
		if(r1.isSelected())
		{
			Gender="Male";
		}
		else if(r2.isSelected())
		{
				Gender="Female";
		}
		if(ae.getSource()==b1) {
		String Name=t2.getText();
		String Country=t3.getText();
		String Allocation=c2.getSelectedItem();
		String Checked_in=t4.getText();
		String Deposit=t5.getText(); 
		String str1="Insert into hotel_addCustomer values('"+ID+"','"+Number+"','"+Gender+"','"+Name +"','"+Country+"','"+Allocation+"','"+ Checked_in+"','"+ Deposit+"')";
		try {
			com c=new com();
			c.s.executeUpdate(str1);
			JOptionPane.showMessageDialog(null, "New Customer Added");
			new Reception().setVisible(true);
			this.setVisible(false);
			
		}
		catch(Exception e)
		{
			
		}
		}
		else if(ae.getSource()==b2)
		{
			this.setVisible(false);

			
		}
		
	}

}
