import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.*;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;

public class Patient_Database extends JFrame implements Printable, ActionListener {
	public JInternalFrame mFrame;
	public JTextField f1;
	public JTextField l1;
	public JTextField dob;
	public JTextField gender;
	public JTextField address;
	public JTextField address2;
	public JTextField city;
	public JTextField state;
	public JTextField zipcode;
	public JTextField email;
	public JTextField phoneNumber;
	public JTextField arrivalDate;
	public JTextField dischargeDate;
	public JTextField reasonVisit;
	public static final int WIDTH = 600;
	public static final int HEIGHT = 1000;
	
	public String firstname;
	public String lastname;
	public String dobVar;
	public String genderVar;
	public String add1;
	public String add2;
	public String cityVar;
	public String zipcodeVar;
	public String stateVar;
	public String emailVar;
	public String phoneNumberVar;
	public String arrivalDateVar;
	public String dischargeDateVar;
	public String reasonVisitVar;
	
	int patientIDCount = 0;
	int addressIDCount = 0;
	int emailIDCount = 0;
	int phoneIDCount = 0;
	int visitIDCount = 0;
	
	public Patient_Database()
	{
		super("Patient_Database");
		setSize(WIDTH, HEIGHT);
		setLocation(600, 600); // setting the location on the screen
		setTitle("Patient Registration Form");
		
		JDesktopPane dtp = new JDesktopPane();
		setContentPane(dtp);
		getContentPane().setBackground(Color.lightGray);
		addWindowListener(new WindowDestroyer());
		
		JPanel buttonPanel = new JPanel(); // Java panel to hold buttons
		buttonPanel.setLayout(new FlowLayout());// Setting the layout of buttons
		
		JPanel textPanel = new JPanel();// Java panel to hold labels and text fields
		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.PAGE_AXIS));
		
		JPanel FirstName = new JPanel();
		FirstName.setLayout(new FlowLayout());
		JLabel fname = new JLabel("First Name");
		f1 = new JTextField(25);
		
		JPanel LastName = new JPanel();
		LastName.setLayout(new FlowLayout());
		JLabel lname = new JLabel("Last Name");
		l1 = new JTextField(25);
		
		JPanel dobPanel = new JPanel();
		dobPanel.setLayout(new FlowLayout());
		JLabel dobLabel = new JLabel("Date of Birth");
		dob = new JTextField(25);

		JPanel genPanel = new JPanel();
		genPanel.setLayout(new FlowLayout());
		JLabel gen = new JLabel("Gender");
		gender = new JTextField(25);

		JPanel addrPanel = new JPanel();
		addrPanel.setLayout(new FlowLayout());
		JLabel addr = new JLabel("Address");
		address = new JTextField(25);
		
		JPanel addrPanel2 = new JPanel();
		addrPanel2.setLayout(new FlowLayout());
		JLabel addr2 = new JLabel("Address2");
		address2 = new JTextField(25);
		
		JPanel cityPanel = new JPanel();
		cityPanel.setLayout(new FlowLayout());
		JLabel cityP = new JLabel("City");
		city = new JTextField(25);

		JPanel statePanel = new JPanel();
		statePanel.setLayout(new FlowLayout());
		JLabel stateP = new JLabel("State");
		state = new JTextField(25);
		
		JPanel zipcodePanel = new JPanel();
		zipcodePanel.setLayout(new FlowLayout());
		JLabel zipcodeP = new JLabel("Zipcode");
		zipcode = new JTextField(25);
		
		JPanel emailPanel = new JPanel();
		emailPanel.setLayout(new FlowLayout());
		JLabel emailLabel = new JLabel("Email");
		email = new JTextField(25);
		
		JPanel phonePanel = new JPanel();
		phonePanel.setLayout(new FlowLayout());
		JLabel phoneLabel = new JLabel("Phone Number");
		phoneNumber = new JTextField(25);

		JPanel arrivalPanel = new JPanel();
		arrivalPanel.setLayout(new FlowLayout());
		JLabel arrivalLabel = new JLabel("Arrival Date");
		arrivalDate = new JTextField(25);

		JPanel dischargePanel = new JPanel();
		dischargePanel.setLayout(new FlowLayout());
		JLabel dischargeLabel = new JLabel("Discharge Date");
		dischargeDate = new JTextField(25);

		JPanel reasonPanel = new JPanel();
		reasonPanel.setLayout(new FlowLayout());
		JLabel reasonLabel = new JLabel("Reason for Visit");
		reasonVisit = new JTextField(25);
		
		
		
		FirstName.add(fname);
		FirstName.add(f1);
		LastName.add(lname);
		LastName.add(l1);
		dobPanel.add(dobLabel);
		dobPanel.add(dob);
		genPanel.add(gen);
		genPanel.add(gender);
		emailPanel.add(emailLabel);
		emailPanel.add(email);
		phonePanel.add(phoneLabel);
		phonePanel.add(phoneNumber);
		addrPanel.add(addr);
		addrPanel.add(address);
		addrPanel2.add(addr2);
		addrPanel2.add(address2);
		cityPanel.add(cityP);
		cityPanel.add(city);
		zipcodePanel.add(zipcodeP);
		zipcodePanel.add(zipcode);
		statePanel.add(stateP);
		statePanel.add(state);
		arrivalPanel.add(arrivalLabel);
		arrivalPanel.add(arrivalDate);
		dischargePanel.add(dischargeLabel);
		dischargePanel.add(dischargeDate);
		reasonPanel.add(reasonLabel);
		reasonPanel.add(reasonVisit);

		//continue adding the text fields
		
		textPanel.add(FirstName);
		textPanel.add(LastName);
		textPanel.add(dobPanel);
		textPanel.add(genPanel);
		textPanel.add(phonePanel);
		textPanel.add(emailPanel);
		textPanel.add(addrPanel);
		textPanel.add(addrPanel2);
		textPanel.add(cityPanel);
		textPanel.add(statePanel);
		textPanel.add(zipcodePanel);
		textPanel.add(arrivalPanel);
		textPanel.add(dischargePanel);
		textPanel.add(reasonPanel);


		mFrame = new JInternalFrame("Please input patient details below:", true, true, true, true);
		mFrame.setLayout(new BorderLayout());

		JButton insertButton = new JButton("Insert");
		insertButton.addActionListener(this);

		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(this);
		
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(this);
		
		JButton updateButton = new JButton("Update");
		updateButton.addActionListener(this);
		
		JButton PrintButton = new JButton("Print");
		PrintButton.addActionListener(this);
		
		JButton newButton = new JButton("New");
		newButton.addActionListener(this);
		
		
		buttonPanel.add(insertButton);
		buttonPanel.add(deleteButton);
		buttonPanel.add(searchButton);
		buttonPanel.add(updateButton);
		buttonPanel.add(PrintButton);
		buttonPanel.add(newButton);
		
		
		mFrame.setSize(500,800);
		mFrame.setLocation(50, 25);

	    mFrame.add(textPanel, BorderLayout.CENTER); // adds textPanel to the main frame of the window
	    mFrame.add(buttonPanel, BorderLayout.SOUTH);// adds buttons to the main frame
	    mFrame.setVisible(true);
	    dtp.add(mFrame);
	    
	    
	    try {
	    	Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/acsoteldo/Desktop/Patient_Database.db", 
	    	"root", "admin");
	    	Statement statement = connection.createStatement();
	    	ResultSet rs = statement.executeQuery("SELECT MAX(patientID) from names");
	    	rs.next();
			patientIDCount = rs.getInt(1);
	    	rs = statement.executeQuery("SELECT MAX(addressID) from addresses");
	    	rs.next();
	    	addressIDCount = rs.getInt(1);
	    	rs = statement.executeQuery("SELECT MAX(emailID) from emailAddresses");
	    	rs.next();
	    	emailIDCount = rs.getInt(1);
	    	rs = statement.executeQuery("SELECT MAX(phoneID) from phoneNumbers");
	    	rs.next();
	    	phoneIDCount = rs.getInt(1);
			rs = statement.executeQuery("SELECT MAX(visitID) from visits");
	    	rs.next();
	    	visitIDCount = rs.getInt(1);
	    	statement.close();
	    	rs.close();
	    	connection.close();
	    	} 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    	}
	    }
	public void actionPerformed(ActionEvent e)
	{
		// insert one or more fields
		if(e.getActionCommand().equals("Insert"))
		{
			try {
				Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/acsoteldo/Desktop/Patient_Database.db", 
				"root", "admin");
				Statement statement = connection.createStatement();
				firstname = f1.getText();
				lastname = l1.getText();
				dobVar = dob.getText();
				genderVar = gender.getText();
				add1 = address.getText();
				add2 = address2.getText();
				cityVar = city.getText();
				stateVar = state.getText();
				zipcodeVar = zipcode.getText();
				emailVar = email.getText();
				phoneNumberVar = phoneNumber.getText();
				arrivalDateVar = arrivalDate.getText();
				dischargeDateVar = dischargeDate.getText();
				reasonVisitVar = reasonVisit.getText();

				
				patientIDCount++;
				addressIDCount++;
				emailIDCount++;
				phoneIDCount++;
				visitIDCount++;
				
				System.out.println(emailIDCount + " " + phoneIDCount);
				//inserts a record into names table
				statement.executeUpdate("INSERT INTO names (patientID, firstName, lastName, dob, gender)" + " VALUES ('"+patientIDCount+"','"+firstname+"','"+lastname+"','"+dobVar+"','"+genderVar+"')");
				statement.close();

				statement = connection.createStatement();
				statement.executeUpdate("INSERT INTO addresses (addressID, patientID, address1, address2," + "city, state, zipcode)" + " VALUES ('"+addressIDCount+"','"+patientIDCount+"','"+add1+"','"+add2+"','"+cityVar+"','"+stateVar+"','"+zipcodeVar+"')");
				statement.close();
				
				statement = connection.createStatement();
				statement.executeUpdate("INSERT INTO emailAddresses (emailID, patientID, emailAddresses)" + " VALUES('"+emailIDCount+"','"+patientIDCount+"','"+emailVar+"')");
				statement.close();
				
				statement = connection.createStatement();
				statement.executeUpdate("INSERT INTO phoneNumbers (phoneID, patientID, phoneNumber)" + " VALUES('"+phoneIDCount+"','"+patientIDCount+"','"+phoneNumberVar+"')");
				statement.close();

				statement = connection.createStatement();
				statement.executeUpdate("INSERT INTO visits (visitID, patientID, arrivalDate, dischargeDate, reasonVisit)" + " VALUES ('"+visitIDCount+"','"+patientIDCount+"','"+arrivalDateVar+"','"+dischargeDateVar+"','"+reasonVisitVar+"')");
				statement.close();


				Object ins3 = "Success! Insert was successful!";
				JOptionPane.showMessageDialog(null, ins3);
				statement.close();
				connection.close();
				}
			catch (SQLException sqlException) 
			{
				JOptionPane.showMessageDialog(null, sqlException.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
				System.exit(1);
				}
			}
		// tends to only delete recently inserted fields
		else if(e.getActionCommand().equals("Delete"))
		{
			try {
				Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/acsoteldo/Desktop/Patient_Database.db", "root", "admin");
				Statement statement = connection.createStatement();

				firstname = f1.getText();
				lastname = l1.getText();
				dobVar = dob.getText();
				genderVar = gender.getText();
				add1 = address.getText();
				add2 = address2.getText();
				cityVar = city.getText();
				stateVar = state.getText();
				zipcodeVar = zipcode.getText();
				emailVar = email.getText();
				phoneNumberVar = phoneNumber.getText();
				arrivalDateVar = arrivalDate.getText();
				dischargeDateVar = dischargeDate.getText();
				reasonVisitVar = reasonVisit.getText();
				
				statement.executeUpdate("DELETE FROM names WHERE " +
				"patientID = '"+patientIDCount+"' AND firstname = '"+firstname+"' AND " +
				"lastName = '"+lastname+"' AND " +
				"dob = '"+dobVar+"' AND " +
				"gender = '"+genderVar+"'");
				statement.close();
				statement = connection.createStatement();
				
				statement.executeUpdate("DELETE FROM addresses WHERE " +
				"addressID = '"+addressIDCount+"' AND " +
				"patientID = '"+patientIDCount+"' AND " +
				"address1 = '"+add1+"' AND " +
				"address2 = '"+add2+"' AND " +
				"city = '"+cityVar+"' AND " +
				"state = '"+stateVar+"' AND " +
				"zipcode = '"+zipcodeVar+"'");
				statement.close();
				statement = connection.createStatement();

				statement.executeUpdate("DELETE FROM emailAddresses WHERE " +
				"emailID = '"+emailIDCount+"' AND " +
				"patientID = '"+patientIDCount+"' AND " +
				"emailAddresses = '"+emailVar+"'");
				statement.close();
				statement = connection.createStatement();
				
				statement.executeUpdate("DELETE FROM phoneNumbers WHERE " +
				"phoneID = '"+phoneIDCount+"' AND " +
				"patientID = '"+patientIDCount+"' AND " +
				"phoneNumber = '"+phoneNumberVar+"'");
				statement.close();
				statement = connection.createStatement();

				statement.executeUpdate("DELETE FROM visits WHERE " +
				"visitID = '"+visitIDCount+"' AND " +
				"patientID = '"+patientIDCount+"' AND " +
				"arrivalDate = '"+arrivalDateVar+"' AND " +
				"dischargeDate = '"+dischargeDateVar+"' AND " +
				"reasonVisit = '"+reasonVisitVar+"'");
				statement.close();
				statement = connection.createStatement();

		        
				Object ins3 = "Success! Deletion was successful!";
				JOptionPane.showMessageDialog(null, ins3);
				statement.close();
				connection.close();
		        }
			catch (SQLException sqlException) 
			{
				JOptionPane.showMessageDialog(null, sqlException.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE );
				System.exit( 1 );
				}
			}
		// search with first and last name
		else if(e.getActionCommand().equals("Search"))
		{
			try {
				Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/acsoteldo/Desktop/Patient_Database.db", "root", "admin");
				Statement statement = connection.createStatement();
				firstname = f1.getText();
				lastname = l1.getText();
				
				ResultSet rs = statement.executeQuery("SELECT patientID FROM names WHERE firstName = '"+firstname+"' AND lastName = '"+lastname+"' AND dob = '"+dobVar+"'" );
				Integer pid = 0;
				
				while(rs.next()) 
				{
					pid = rs.getInt("patientID");
					}
				if(pid == 0) 
				{
					Object none = "No record found!";
					JOptionPane.showMessageDialog(null, none);
					}
				rs = statement.executeQuery("SELECT * FROM addresses WHERE patientID = " + pid);
				while(rs.next()) {
					address.setText(rs.getString("address1"));
					address2.setText(rs.getString("address2"));
					city.setText(rs.getString("city"));
					state.setText(rs.getString("state"));
					zipcode.setText(rs.getString("zipcode"));
					}
				rs = statement.executeQuery("SELECT * FROM emailAddresses WHERE patientID = "+ pid);
				while(rs.next()) {
					email.setText(rs.getString("emailAddresses"));
					}
				rs = statement.executeQuery("SELECT * FROM phoneNumbers WHERE patientID = " + pid);
				while(rs.next()) {
					phoneNumber.setText(rs.getString("phoneNumber"));
					}
				rs = statement.executeQuery("SELECT * FROM visits WHERE patientID = " + pid);
				while(rs.next()) {
					arrivalDate.setText(rs.getString("arrivalDate"));
					dischargeDate.setText(rs.getString("dischargeDate"));
					reasonVisit.setText(rs.getString("reasonVisit"));
					}
				statement.close();
				connection.close();
				}
			catch (SQLException sqlException) {
				JOptionPane.showMessageDialog(null, sqlException.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE );
				System.exit(1);
				}
			}
		// search, then update as needed
		else if(e.getActionCommand().contentEquals("Update")) {
			try {
				Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/acsoteldo/Desktop/Patient_Database.db", "root", "admin");
				Statement statement = connection.createStatement();

				firstname = f1.getText();
				lastname = l1.getText();
				dobVar = dob.getText();
				genderVar = gender.getText();
				add1 = address.getText();
				add2 = address2.getText();
				cityVar = city.getText();
				stateVar = state.getText();
				zipcodeVar = zipcode.getText();
				emailVar = email.getText();
				phoneNumberVar = phoneNumber.getText();
				arrivalDateVar = arrivalDate.getText();
				dischargeDateVar = dischargeDate.getText();
				reasonVisitVar = reasonVisit.getText();
				
				ResultSet rs = statement.executeQuery("SELECT patientID FROM names WHERE firstName = '"+firstname+"' AND lastName = '"+lastname+"'" );
				int pid = 0;
				while(rs.next()) {
					pid = rs.getInt("patientID");
					}
				statement.executeUpdate("UPDATE names Set firstName = '"+firstname+"', lastName = '"+lastname+"', dob = '"+dobVar+"', gender = '"+genderVar+"' WHERE patientID = '"+pid+"'");
				statement.executeUpdate("UPDATE emailAddresses Set emailAddresses = '"+emailVar+"' WHERE patientID = '"+pid+"'");
				statement.executeUpdate("UPDATE addresses Set address1 = '"+add1+"', address2 = '"+add2+"', city = '"+cityVar+"', state = '"+stateVar+"', zipcode = '"+zipcodeVar+"' WHERE patientID = '"+pid+"'");
				statement.executeUpdate("UPDATE phoneNumbers Set phoneNumber = '"+phoneNumberVar+"' WHERE patientID = '"+pid+"'");
				statement.executeUpdate("UPDATE visits Set arrivalDate = '"+arrivalDateVar+"', dischargeDate = '"+dischargeDateVar+"', reasonVisit = '"+reasonVisitVar+"' WHERE patientID = '"+pid+"'");
				
				Object ins3 = "Success! Update was successful!";
				JOptionPane.showMessageDialog(null, ins3);
				statement.close();
				connection.close();
				}
			catch(SQLException sqlException) {
				JOptionPane.showMessageDialog(null, sqlException.getMessage(), "Databse Error", JOptionPane.ERROR_MESSAGE);
				System.exit(1);
				}
			}
		// sort of working now
		// pdf opens when "Untitled"
		else if(e.getActionCommand().contentEquals("Print")) {
			PrinterJob job = PrinterJob.getPrinterJob();
			job.setPrintable(this::print);
			boolean ok = job.printDialog();
			if(ok) {
				try {
					job.print();
					} 
				catch(PrinterException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Printing Error", JOptionPane.ERROR_MESSAGE);
					System.exit(1);
					}
				}
			}
		else if (e.getActionCommand().equals("New")) // clear text on panel
		{
			try {
				f1.setText("");
				l1.setText("");
				dob.setText("");
				gender.setText("");
				address.setText("");
				address2.setText("");
				city.setText("");
				state.setText("");
				zipcode.setText("");
				email.setText("");
				phoneNumber.setText("");
				arrivalDate.setText("");
				dischargeDate.setText("");
				reasonVisit.setText("");
			}
		         finally{
		        	// br.close();
		         }
			}
		else
			System.out.println("Error in button interface");
		}
	public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
	    if (page > 0) {
	        return NO_SUCH_PAGE;
	    }
	    Graphics2D g2d = (Graphics2D)g;
	    g2d.translate(pf.getImageableX(), pf.getImageableY());
	    // Print the entire visible contents of a
	    // java.awt.Frame.
	    mFrame.printAll(g);

	    return PAGE_EXISTS;
		}	
	public static void main( String args[] )
	{
		Patient_Database window = new Patient_Database();
		window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		window.setVisible(true);
		}
	}  // end class DbConnection
class WindowDestroyer extends WindowAdapter
{
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
		}
	}
