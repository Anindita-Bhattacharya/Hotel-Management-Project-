import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.*;
public class Login extends JFrame implements ActionListener
{
	JTextField t1,t2;
	JLabel l1,l2,l3;
	JButton b1,b2;
	JPasswordField t3;
Login()
{
	l1=new JLabel("Username");
	l1.setBounds(40,20,100,30);
	add(l1);
	
	l2=new JLabel("Password");
	l2.setBounds(40,70,100,30);
	add(l2);
	
	t1=new JTextField();
	t1.setBounds(150,20,150,30);
	add(t1);
	
	t3=new JPasswordField();
	t3.setBounds(150,70,150,30);
	add(t3);
	
	b1=new JButton("Login");
	b1.setBackground(Color.black);
	b1.setForeground(Color.white);
	b1.setBounds(40, 150, 120, 30);
    b1.setFont(new Font("serif",Font.BOLD,15));
    b1.addActionListener(this);
	
	b2=new JButton("Cancel");
    b2.setBounds(180,150,120,30);
    b2.setBackground(Color.black);
    b2.setForeground(Color.white);
    b2.setFont(new Font("serif",Font.BOLD,15));
    add(b2);
    b2.addActionListener(this);

	add(b1);
	
	ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpeg"));
	Image i1=ic.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
	ImageIcon i3=new ImageIcon(i1);
	
	JLabel l3=new JLabel(i3);
	l3.setBounds(350,10,200,200);
	add(l3);
	getContentPane().setBackground(Color.white);
	setLayout(null);
	setBounds(500,300,600,300);

	setVisible(true);

}
public static void main(String args[])
{
	Login l=new Login();
}
@Override
public void actionPerformed(ActionEvent ae) {
	// TODO Auto-generated method stub
	if(ae.getSource()==b1)
	{
	String username=	t1.getText();
	String Password= 	t3.getText();
	com c=new com();
	String str="select * from login where username='"+username+"' and password='"+Password+"'";
	try { //try catch because we are working with external file
		ResultSet rs=c.s.executeQuery(str);
		if(rs.next()) //next function is for column to column jump
		{
			new Dashboard().setVisible(true);
			this.setVisible(false);
			
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Inavlid username or password");
			this.setVisible(false);
		}
	} catch (Exception e) 
	{
		// TODO Auto-generated catch block
	}
		
		
	}
	else if(ae.getSource()==b2)
	{
		System.exit(0);
	}
}
}
