import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
class FDemo extends JFrame implements ActionListener
{
JComboBox tx1;
JTextField tx2;
JButton b1;
JLabel l1,l2,l3;
Vector <String>v;
FDemo()
{
	v=new Vector<String>();
	v.add("India");
	v.add("Nepal");
	v.add("America");
	v.add("Pakistan");
	v.add("Australia");
	v.add("Srilanka");
	v.add("Russia");
	v.add("China");
	v.add("Japan");
	v.add("France");
	v.add("Bangladesh");
	v.add("Iraq");
	v.add("United kingdom");
	v.add("Hong Kong");
	setLayout(null);

	l1=new JLabel("Country Name:");
	l1.setBounds(120,80,150,30);
     l1.setFont(new Font("Times New Roman", Font.BOLD, 21));
     l1.setForeground(new Color(0, 0, 0));
	  add(l1);
	  
	  l3=new JLabel("");
	  add(l3);

	tx1=new JComboBox(v);
	tx1.setBounds(260,80,200,45);
	add(tx1);
	
	l2=new JLabel("        Time :");
	l2.setBounds(140,140,150,30);
     l2.setFont(new Font("Times New Roman", Font.BOLD, 21));
     l2.setForeground(new Color(0, 0, 0));
	 add(l2);

	tx2=new JTextField(50);
	tx2.setBounds(260,140,200,45);
	add(tx2);
	
	
	
	b1=new JButton("Done");
	b1.setBounds(250,200,150,35);
	add(b1);
	b1.addActionListener(this);

	
}
public void actionPerformed(ActionEvent e)
{
	String s,s2;
	if(e.getSource()==b1)
	{
		s=(String)tx1.getSelectedItem();
		s2=getSelectTimeZone(s);
		
    DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-mm-yyyy, hh:mm:ss a z");
	LocalDateTime todayDateTime=LocalDateTime.now();
	
	ZoneId z1= ZoneId.of(s2);
	
	ZonedDateTime cdt1=todayDateTime.atZone(z1);
	ZonedDateTime cdt2=cdt1.withZoneSameInstant(z1);
	tx2.setText(""+dtf.format(cdt1));
		
	}
}

public String getSelectTimeZone(String selectTimeZone) {
	
		switch (selectTimeZone) {
		case "India":	
			return "Asia/Kolkata";
		case "Nepal":	
			return "Asia/Kathmandu";
		case "America":	
			return "America/New_York";
		case "Pakistan":	
			return "Asia/Karachi";
		case "Srilanka":	
			return "Asia/Colombo";
		case "Australia":	
			return "Europe/Vienna";
		case "China":	
			return "Asia/Shanghai";
		case "Russia":	
			return "Europe/Moscow";
		case "Japan":	       
			return "Asia/Tokyo";
		case "France":	
			return "Europe/Paris";
		case "Bangladesh":	
			return "Asia/Dhaka";
		case "Iraq":	
			return "Asia/Baghdad";
		case "United kingdom":	
			return "Europe/London";
		case "Hong Kong":	
			return "Asia/Hong_Kong";
		default:
			break;
		}
		return "Asia/Kolkata";
	}

	
}
class Demo
{
	public static void main(String ar[])
	{
		FDemo f=new FDemo();
		f.getContentPane().setBackground(Color.PINK);
		f.setVisible(true);
		f.setTitle("Time Conversion");
		Image icon = Toolkit.getDefaultToolkit().getImage("D:\\Project\\time.jpeg");    
        f.setIconImage(icon);
		f.setBounds(100,100,800,500);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
	}
	
}