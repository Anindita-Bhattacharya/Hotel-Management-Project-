import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class CheckOut extends JFrame implements ActionListener
{
	Choice c1;
	JTextField t1;
	JButton b1,b2,b3;
	CheckOut()
	{
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tick.jpeg"));
		Image i2=i1.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		b3=new JButton(i3);
		b3.setBounds(350,80,20,20);
		b3.addActionListener(this);
		add(b3);
		
		ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpeg"));
		Image i5=i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
		ImageIcon i6=new ImageIcon(i5);
		JLabel l6=new JLabel(i6);
		l6.setBounds(380,20,400,250);
		add(l6);
		
		JLabel l1=new JLabel("Check Out");
		l1.setFont(new Font("Tahoma",Font.PLAIN,25));
		l1.setForeground(Color.blue);
		l1.setBounds(100,20,150,30);
		add(l1);
		
		JLabel l2=new JLabel("Customer Id");	
		l2.setFont(new Font("Tahoma",Font.PLAIN,18));
		l2.setBounds(30,80,100,30);
		add(l2);
		
		c1=new Choice();
		try 
		{
		com c=new com();
		ResultSet rs= c.s.executeQuery("select * from hotel_addcustomer");
		while(rs.next())
		{
			c1.add(rs.getString("Number"));
		}
		}
		catch(Exception e)
		{
			
		}
		c1.setBounds(180,80,150,25);
		add(c1);
		JLabel l3=new JLabel("Room Number");
		l3.setFont(new Font("Tahoma",Font.PLAIN,18));
		l3.setBounds(30,140,150,30);
		add(l3);

		t1=new JTextField();
		t1.setBounds(180,140,150,25);
		add(t1);
		
		b1=new JButton("CheckOut");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(30,200,100,30);
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton("Back");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setBounds(180,200,100,30);
		b2.addActionListener(this);
		add(b2);
		
		getContentPane().setBackground(Color.white);
		
		
		
		setLayout(null);
		setBounds(400,200,800,330);
		setVisible(true);
	}
	public static void main(String[] args)
	{
		CheckOut co=new CheckOut();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==b1)
		{
			String id=c1.getSelectedItem();
			String room=t1.getText();
			String str="delete from hotel_addcustomer where Number='"+id+"'";
			String str1="update room set available ='Available' where room_number='"+room+"'";
			com c=new com();
			try {
				c.s.executeUpdate(str);
				c.s.executeUpdate(str1);
				JOptionPane.showMessageDialog(null, "Checked Out Successfully");
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
		else if(ae.getSource()==b3)
		{
			com c=new com();
			String id=c1.getSelectedItem();
			try {
				ResultSet rs=c.s.executeQuery("select * from hotel_addcustomer where Number='"+id+"'");
				while(rs.next())
				{
					t1.setText(rs.getString("Allocation"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
