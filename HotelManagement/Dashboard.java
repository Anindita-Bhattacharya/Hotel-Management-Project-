import javax.sound.sampled.Line;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Dashboard extends JFrame implements ActionListener
{
	
		 JMenuBar mb;
		 JMenu m1,m2,m3;
		 JMenuItem i1,i2,i3,i4,i5;
		 JLabel l1;
		 Dashboard()
		 {
			 mb=new JMenuBar();
			 add(mb);
			 m1=new JMenu("HOTEL MANAGEMENT");
			 mb.add(m1);
			 
			
			 
			 m2=new JMenu("ADMIN");
			 m2.setForeground(Color.BLUE);
			 mb.add(m2);
			 
			 m3=new JMenu("EXIT");
			 m3.setForeground(Color.GREEN);
			 mb.add(m3);
			 
			
			 
			 i1=new JMenuItem("RECEPTION");
			 i1.addActionListener(this);
			 m1.add(i1);
			 m1.setForeground(Color.RED);
			 
			 i2=new JMenuItem("ADD EMPLOYEE");
			 i2.addActionListener(this);
			 m2.add(i2);
			 
			 i3=new JMenuItem("ADD ROOMS");
			 i3.addActionListener(this);
			 m2.add(i3);
			 
			 
			 i4=new JMenuItem("ADD DRIVERS");
			 i4.addActionListener(this);
			 m2.add(i4);
			 
			 i5=new JMenuItem("LOGOUT");
			 i5.addActionListener(this);
			 m3.add(i5);
			 
			 
			 mb.setBounds(0,0,250,30);
			 setLayout(null);
			 setBounds(0,0,2050,1020);
			 ImageIcon li = new ImageIcon(ClassLoader.getSystemResource("icons/hms.jpeg"));
			 Image i2=li.getImage().getScaledInstance(1950,1000,Image.SCALE_DEFAULT);
			 ImageIcon i3=new ImageIcon(i2);
			 l1=new JLabel(i3);
			 l1.setBounds(0, 0, 1950,1000);
			 add(l1);
			 JLabel l2=new JLabel("OUR HOTEL WELCOMES YOU ");
			 l2.setBounds(430,20,600,50);
			 l1.add(l2);
			 l2.setForeground(Color.white);
			 l2.setFont(new Font("serif",Font.BOLD,35));
			 setVisible(true);
			 
			 
			 
			 
		 
	 }
		 public static void main(String[] args)
		 {
			 new Dashboard().setVisible(true);
		 }
		@Override
		public void actionPerformed(ActionEvent ae)
		{
			
			// TODO Auto-generated method stub
			if(ae.getActionCommand().contentEquals("RECEPTION"))
			{
				new Reception().setVisible(true);
				
			}
			else if(ae.getActionCommand().equals("ADD EMPLOYEE"))
			{
				new AddEmployee().setVisible(true);
			}
			else if(ae.getActionCommand().equals("ADD ROOMS"))
			{
				
				new AddRooms().setVisible(true);
			}
			else if(ae.getActionCommand().equals("ADD DRIVERS"))
			{
				new AddDriver().setVisible(true);
			}
			else if(ae.getActionCommand().equals("LOGOUT"))
			{
				System.exit(0);
			}
		}

}
