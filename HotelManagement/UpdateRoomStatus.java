import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class UpdateRoomStatus extends JFrame implements ActionListener
{
	Choice c1,c2;
	JTextField t1,t2,t3,t4;
	JButton b1,b2,b3;
	
	UpdateRoomStatus()
	{
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpeg"));
		JLabel l10=new JLabel(i1);
		l10.setBounds(350,20,600,400);
		add(l10);
		
		JLabel l1=new JLabel("Update Room Status");
		l1.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,20));
		l1.setForeground(Color.blue);
		l1.setBounds(30,10,400,30);
		add(l1);
		
		JLabel l2=new JLabel("Guest Name");
		l2.setBounds(30,70,120,20);
		add(l2);
		
		JTextField t4=new JTextField();
		t4.setBounds(170,70,120,20);
		add(t4);
		
		JLabel l6=new JLabel("Guest Phone Number");
		l6.setBounds(30,110,120,20);
		add(l6);
		c2=new Choice();
		try
		{
			com c=new com();
			String str="select * from hotel_addcustomer";
			ResultSet r=c.s.executeQuery(str);
			while(r.next()) { //to travel till the end of the table next means columns
				c2.add(r.getString("Number"));
			}
			
		}
		catch(Exception e)
		{
			
		}
		c2.setBounds(170,110,120,20);
		add(c2);

		
		JLabel l3=new JLabel("Room Number");
		l3.setBounds(30,150,120,20);
		add(l3);
		
		t1=new JTextField();
		t1.setBounds(170,150,120,20);
		add(t1);
		
		JLabel l4=new JLabel("Availibility");
		l4.setBounds(30,190,120,20);
		add(l4);
		
		t2=new JTextField();
		t2.setBounds(170,190,120,20);
		add(t2);
		
		
		JLabel l5=new JLabel("Clean Status");
		l5.setBounds(30,230,120,20);
		add(l5);
		
		t3=new JTextField();
		t3.setBounds(170,230,120,20);
		add(t3);
		
		b1=new JButton("Check");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(95,300,90,30);
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton("Update");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setBounds(20,360,90,30);
		b2.addActionListener(this);
		add(b2);
		
		b3=new JButton("Back");
		b3.setBackground(Color.black);
		b3.setForeground(Color.white);
		b3.setBounds(150,360,90,30);
		b3.addActionListener(this);
		add(b3);
		
		getContentPane().setBackground(Color.white);
		
		
		setLayout(null);
		setBounds(190,120,1000,530);
		setVisible(true);
	}
	public static void main(String[] args)
	{
		UpdateRoomStatus urs=new UpdateRoomStatus();
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==b1)
		{
			String room=null;
			String str=c2.getSelectedItem();
			com c=new com();
			try {
				ResultSet rp=c.s.executeQuery("select * from hotel_addcustomer where Number='"+str+ "' ");
				while(rp.next())
				{
					t1.setText(rp.getString("Allocation"));
					room=rp.getString("Allocation");
				}
				ResultSet rs2=c.s.executeQuery("select * from room where room_number='"+room+ "' ");
				while(rs2.next())
				{
					t2.setText(rs2.getString("available"));
					t3.setText(rs2.getString("status"));

					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}

		}
		else if(ae.getSource()==b2)
		{
			try
			{
				com c=new com();
				String room=t1.getText();
				String available=t2.getText();
				String status=t3.getText();
				
				String str="update room set available='"+available+"'";
				String str1="update room set status='"+status+"'";
				c.s.executeUpdate(str);
				c.s.executeUpdate(str1);
				JOptionPane.showMessageDialog(null, "Room Updated Successfully");
				this.setVisible(false);
				
				
				
			}
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
		else if(ae.getSource()==b3)
		{
			this.setVisible(false);
		}
		
	}

}
