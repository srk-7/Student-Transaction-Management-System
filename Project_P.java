import java.util.*;
import java.util.UUID;
import javax.swing.*;
import javax.swing.JScrollPane; 
import javax.swing.JFrame;  
import javax.swing.JTextArea; 
import java.awt.FlowLayout;  
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.String;
import java.awt.*;  
import java.awt.event.*; 
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
class Project_P implements ActionListener
{
	UUID uniqueKey = UUID.randomUUID();
	String KeyAsString = uniqueKey.toString(); 
	// get date
	DateFormat dfor = new SimpleDateFormat("dd-MMM-yyyy");
	Date obj = new Date();
	String d=(dfor.format(obj));
	Calendar cobj = Calendar.getInstance();
	// get time
	DateFormat dtime = new SimpleDateFormat("hh:mm:ss");
	Date obj1 = new Date();
	String ti=(dtime.format(obj1));
	
	JLabel h2=new JLabel("System Generated Unique ID");
	JTextField h3=new JTextField();
	JFrame f=new JFrame("Student Transaction Management System");
	JLabel h1=new JLabel("Welcome to Student Transaction Management System");
	JLabel x1=new JLabel("•To Find Your Transaction Please Enter the Amount_Spend Text Field");
	JLabel x2=new JLabel("•To Delete Your Transaction Please Enter Generated id TextField");
	JLabel l0=new JLabel("Transaction_Date");
	JLabel l00=new JLabel("Transaction_Time");
	JLabel l1=new JLabel("Amount_Spent");
	JLabel l2=new JLabel("Title");
	JLabel l3=new JLabel("Payment_Mode");
	JLabel l4=new JLabel();
	JTextField l5=new JTextField();
	JTextField t0=new JTextField();
	JTextField t00=new JTextField();
	JTextField t1=new JTextField();
	JTextField t2=new JTextField();
	JTextField t3=new JTextField();
	TextArea ta=new TextArea();
	JButton b1=new JButton("Save");
	JButton b2=new JButton("Find");
	JButton b3=new JButton("Delete");
	JButton b4=new JButton("History");
	JButton b5=new JButton("Clear");
	JButton b6=new JButton("Total Amount Spent  ");
	JButton b9=new JButton("Min Amount Spent  ");
	JButton b10=new JButton("Max Amount Spent  ");
	JButton b11=new JButton("Avg Amount Spent  ");
	JButton b7 = new JButton("⭮");
	JButton b8=new JButton("Total No.of Transactions");
	Project_P()
	{
		//heading label
		h1.setBounds(140,10,400,40);
		//user helping labels
		x1.setBounds(55,50,550,25);
		x2.setBounds(55,70,550,25);
		//side labels
		h2.setBounds(50,120,300,20);
		l0.setBounds(50,140,300,20);
		l00.setBounds(50,160,300,20);
		l1.setBounds(50,180,300,20);
		l2.setBounds(50,200,300,20);
		l3.setBounds(50,220,300,20);
		//message label
		l4.setBounds(75,300,350,20);
		//total amount label
		l5.setBounds(230,550,100,20);
		//l6.setBounds(560,580,100,20);
		//text fields
		h3.setBounds(320,120,250,20);
		t0.setBounds(320,140,250,20);
		t00.setBounds(320,160,250,20);
		t1.setBounds(320,180,250,20);
		t2.setBounds(320,200,250,20);
		t3.setBounds(320,220,250,20);
		//buttons
		b1.setBounds(30,260,70,20);
		b2.setBounds(150,260,70,20);
		b3.setBounds(270,260,80,20);
		b4.setBounds(390,260,80,20);
		b5.setBounds(510,260,80,20);
		b7.setBounds(575,120,50,20);
		//total amt button
		b6.setBounds(20,580,190,20);
		b8.setBounds(350,580,190,20);
		b9.setBounds(20,610,190,20);
		b10.setBounds(350,610,190,20);
		b11.setBounds(20,640,190,20);
		//text area
		ta.setBounds(20,340,600,200);
		//adding to frame
		f.add(x1);
		f.add(x2);
		f.add(h1);
		f.add(h2);
		f.add(h3);
		f.add(t00);
		f.add(l00);
		f.add(l0);
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(b6);
		f.add(l5);
		f.add(t0);
		f.add(t1);
		f.add(t2);
		f.add(t3);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		f.add(b7);
		f.add(b8);
		f.add(b9);
		f.add(b10);
		f.add(b11);
		f.add(ta);
		h3.setText(KeyAsString);
		t0.setText(d);
		t00.setText(ti);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b10.addActionListener(this);
		b11.addActionListener(this);
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(650,800);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			if(e.getSource()==b1)
			{
				String sql = "insert into pproject values(\'"+h3.getText()+"\',\'"+t0.getText()+"\',\'"+t00.getText()+"\',"+t1.getText()+",\'"+t2.getText()+"\',\'"+t3.getText()+"\')";
				ps=con.prepareStatement(sql);
				ps.execute();
				l4.setText("ThankYou! Your data has been stored in database");
				ta.setText("ID: "+h3.getText()+",\nDate: "+t0.getText()+",\nTime: "+t00.getText()+",\nAmount Spent: "+t1.getText()+",\nSpent on: "+t2.getText()+",\nMode Of Payment: "+t3.getText()+".");
			}
			if(e.getSource()==b2)
			{
				String sql = "select * from pproject where Amount_Spent="+t1.getText()+"";
				ps=con.prepareStatement(sql);
				rs=ps.executeQuery();
				ta.setText("");
				while(rs.next())
           			{           	   
					ta.append("\nID: "+rs.getString(1)+",Date: "+rs.getString(2)+",Time: "+rs.getString(3)+", Amount Spent: "+rs.getString(4)+", Spent on: "+rs.getString(5)+", Mode Of Payment: "+rs.getString(6)+".");
            			}
				l4.setText("Your Transaction has Found in database");
			}
			if(e.getSource()==b3)
			{
				String sql="delete from pproject where SYS_ID=\'"+h3.getText()+"\'";
				ps=con.prepareStatement(sql);
				ps.executeUpdate();
				l4.setText("Your Transaction has been Deleted from database");
			}
			if(e.getSource()==b4)
			{
				String sql = "select * from pproject";
				ps=con.prepareStatement(sql);
				rs=ps.executeQuery();
				ta.setText("");
				while(rs.next())
           		{    	   
					ta.append("\nID: "+rs.getString(1)+",Date: "+rs.getString(2)+",Time: "+rs.getString(3)+", Amount Spent: "+rs.getString(4)+", Spent on: "+rs.getString(5)+", Mode Of Payment: "+rs.getString(6)+".");
            	}
				l4.setText("Your Past Transaction are Displayed in TextArea");
			}
			if(e.getSource()==b5)
			{
				h3.setText("");
				t0.setText("");
				t00.setText("");
				t1.setText("");
				t2.setText("");
				t3.setText("");
				l4.setText("Your TextFields are cleared!");
			}
			if(e.getSource()==b6)
			{
				String sql="select sum(Amount_Spent) as tsum from pproject";
				ps=con.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next())
				{
					String tsum=rs.getString("tsum");
					l5.setText(tsum);
				}
				l4.setText("Your Total Expenses are display in bottom");
			}
			if(e.getSource()==b9)
			{
				String sql="select min(Amount_Spent) as tsum from pproject";
				ps=con.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next())
				{
					String tsum=rs.getString("tsum");
					l5.setText(tsum);
				}
				l4.setText("Your Minimum spent amount are displayed in bottom");
			}
			if(e.getSource()==b10)
			{
				String sql="select max(Amount_Spent) as tsum from pproject";
				ps=con.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next())
				{
					String tsum=rs.getString("tsum");
					l5.setText(tsum);
				}
				l4.setText("Your Maximum spent amount are displayed in bottom");
			}
			if(e.getSource()==b11)
			{
				String sql="select avg(Amount_Spent) as tsum from pproject";
				ps=con.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next())
				{
					String tsum=rs.getString("tsum");
					l5.setText(tsum);
				}
				l4.setText("Your Average amount Spent is displayed in bottom");
			}
			if(e.getSource()==b7)
			{
				UUID uniqueKey = UUID.randomUUID();
				String KeyAsString = uniqueKey.toString(); 
				h3.setText(KeyAsString);
				// get date
				DateFormat dfor = new SimpleDateFormat("dd-MMM-yyyy");
				Date obj = new Date();
				String d=(dfor.format(obj));
				Calendar cobj = Calendar.getInstance();
				t0.setText(d);
				// get time
				DateFormat dtime = new SimpleDateFormat("HH:mm:ss");
				Date obj1 = new Date();
				String ti=(dtime.format(obj1));
				t00.setText(ti);
				l4.setText("New Unique id is generated!");
			}
			if(e.getSource()==b8)
			{
				String sql="select count(*) as transactions from pproject";
				ps=con.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next())
				{
					String transactions=rs.getString("transactions");
					l5.setText(transactions);
				}
				l4.setText("Your Total No.of Transactions are displayed in bottom");
			}
		}
		catch(ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	public static void main(String args[])
	{
		new Project_P();			
	}
}