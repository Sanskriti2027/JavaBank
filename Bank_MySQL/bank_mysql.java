
// **********************************************************************************************************	
// importing packages
// **********************************************************************************************************	

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

// **********************************************************************************************************	
	// class loadbank extends from JFrame Class and implements ActionListener
// **********************************************************************************************************	
public class bank_mysql extends JFrame implements ActionListener
{
	// Variable Declaration;

	JTabbedPane tabbedpane;
	JPanel welcomePanel,loginPanel,createNewAccountPanel,accountTransactionPanel,controlPanel,displayDetailsPanel,aboutPanel,logoutPanel;
	int accountnumber;
	java.util.Date date;
	Calendar calendar;
	JTable table;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	String userID,userPWD;
		
// **********************************************************************************************************	//	 init() Function
//**********************************************************************************************************		
		
	public bank_mysql()
	{
		// Displaying Message At StartUP
		JOptionPane.showMessageDialog(null,"Loading Java Bank Application....");
		
		// Initializing tabbedpane and the panels
		
		tabbedpane=new JTabbedPane();
		welcomePanel=new JPanel();
		welcome();
		loginPanel=new JPanel();
		login();
		createNewAccountPanel=new JPanel();
		createNewAccount();
		autoAccountNumber();
		accountTransactionPanel=new JPanel();
		accountTransation();
		controlPanel=new JPanel();
		controlPanel();
		displayDetailsPanel=new JPanel();
		accountDetails();
		logoutPanel=new JPanel();
		logoutPanel();

		// Adding panels to the tabbedpane
		
		tabbedpane.addTab("Welcome",null,welcomePanel,"Welcome Panel");
		tabbedpane.addTab("Login",null,loginPanel,"Bank Authentication Panel");
		tabbedpane.addTab("New Account",null,createNewAccountPanel,"Application Form for creating new account");
		tabbedpane.addTab("Account Transaction",null,accountTransactionPanel,"Pane for withdrawl/deposits transactions");
		tabbedpane.addTab("Control Panel",null,controlPanel,"for adding/removing users");
		tabbedpane.addTab("Account Details",null,displayDetailsPanel,"Displays Account Details");
		tabbedpane.addTab("LogOut",null,logoutPanel,"LogOut Bank Application");
		
		// Adding tabbedpane to the container
		
		getContentPane().add(tabbedpane);
		
		// Disabling the panels
		
		tabbedpane.setEnabledAt(1,false);
		tabbedpane.setEnabledAt(2,false);
		tabbedpane.setEnabledAt(3,false);
		tabbedpane.setEnabledAt(4,false);
		tabbedpane.setEnabledAt(5,false);
		tabbedpane.setEnabledAt(6,false);
		
		// Disabling controls
		
		btnSubmit.setEnabled(false);
		
		txtAccountHoldersName.setEnabled(false);
		txtCurrentBalance.setEnabled(false);
		txtTransactionDate.setEnabled(false);
		cmbTransactionMode.setEnabled(false);
		cmbTransactionType.setEnabled(false);
		
		txtAccountNumber.setEnabled(false);
		
		txtDelLoginId.setEnabled(false);
		btnDeleteUser.setEnabled(false);
		setSize(800, 600);
		setVisible( true );
	}

// **********************************************************************************************************	
		// Variable Declaration
//**********************************************************************************************************	
		// JLabel
		JLabel lblAccountNumber,lblTransactionAccountNumber,lblPersonalDetails,lblApplicantName,lblApplicantDOB,lblApplicantGender,lblApplicantProfession,lblApplicantAddress,lblAccountDetails,lblAccountMode,lblGuaranterDetails,lblGuaranterName,lblGuaranterAccountNumber,lblGuaranterAddress,lblAccountHoldersName,lblAccountBalance,lblTransactionDate,lblTransactionType,lblTransactionAmount,lblCurrentBalance,lblTransactionMode,lblNewId,lblNewPassword,lblDelLoginId,lblExitApps,lblID,lblPWD,lblLogin,lblWelcome1,lblWelcome2,lblWelcome3,lblWelcome4,lblWelcome5,lblWelcome6;
		//JTextField		
		JTextField txtAccountNumber,txtAccountNumberDet,txtApplicantName,txtApplicantDOB,txtApplicantProfession,txtGuaranterName,txtGuaranterAccountNumber,txtTransactionDate,txtTransactionAmount,txtTransactionAccountNumber,txtAccountHoldersName,txtCurrentBalance,txtNewId,txtDelLoginId,txtID;
		//JPasswordField
		JPasswordField txtNewPassword,txtPWD;
		//JTextArea
		JTextArea txtApplicantAddress,txtGuaranterAddress;
		//JComboBox
		JComboBox cmbApplicantGender,cmbAccountMode,cmbTransactionType,cmbTransactionMode;
		//JButton
		JButton btncreateAccount,btnReset1,btnSubmit,btnReset2,btnGetDetails,btnSearch,btnReset3,btnReset4,btnCreateNewLogin,btnDeleteUser,btnExitApps,btnLogin,btnReset,btnExit,btnLtoC,btnQuit;
		//JRadioButton
		JRadioButton rCreateUser,rDeleteUser;

		
// **********************************************************************************************************	
	// UDF to initialize and add  controls to specific panel
//**********************************************************************************************************		
	// welcome() Function
	public void welcome()
	{
		//showStatus("Welcome To Java bank Application....");
		lblWelcome1=new JLabel("****Welcome To Java Bank****");
		lblWelcome2=new JLabel("***Please Login To Continue***");
		
		btnLtoC=new JButton("**Click Here To Login**");
		btnQuit=new JButton("Quit Application");
		
		welcomeLayout();
		
		welcomePanel.add(lblWelcome1);
		welcomePanel.add(lblWelcome2);
		welcomePanel.add(btnLtoC);
		welcomePanel.add(btnQuit);
		
		btnLtoC.addActionListener(this);
		btnQuit.addActionListener(this);
	} 
	// welcome Function ends
	
	// login Function
	public void login()
	{
		lblLogin=new JLabel("Login :");
		lblID=new JLabel("Enter User Id : ");
		lblPWD=new JLabel("Enter Password : ");
		txtID=new JTextField(10);
		txtPWD=new JPasswordField(10);
		btnLogin=new JButton("Login");
		btnReset=new JButton("Reset");
		btnExit=new JButton("Exit");
		
		loginLayout();
		
		loginPanel.add(lblLogin);
		loginPanel.add(lblID);
		loginPanel.add(txtID);
		loginPanel.add(lblPWD);
		loginPanel.add(txtPWD);
		loginPanel.add(btnLogin);
		loginPanel.add(btnReset);
		loginPanel.add(btnExit);
		
		btnLogin.addActionListener(this);
		btnReset.addActionListener(this);
		btnExit.addActionListener(this);
	}
	// login() Function ends
	
	// createNewAccount() Function
	public void createNewAccount()
	{
		autoAccountNumber();
		
		// initializing JLabel
		
		lblAccountNumber=new JLabel("Applicant Account Number");
		lblPersonalDetails=new JLabel("Applicants Personal Details : ");
		lblApplicantName=new JLabel("Applicant Name");
		lblApplicantDOB=new JLabel("Applicant Date Of Birth");
		lblApplicantGender=new JLabel("Applicant Gender");
		lblApplicantProfession=new JLabel("Applicant Profession");
		lblApplicantAddress=new JLabel("Applicant Address");
		lblAccountDetails=new JLabel("Account Details : ");
		lblAccountMode=new JLabel("Account Mode");
		lblGuaranterDetails=new JLabel("Guaranter Details : ");
		lblGuaranterName=new JLabel("Guaranter name");
		lblGuaranterAccountNumber=new JLabel("Guaranter Account Number");
		lblGuaranterAddress=new JLabel("Guaranter Address");
		
		// initializing JTextField
		
		txtAccountNumber=new JTextField(10);
		txtApplicantName=new JTextField(10);
		txtApplicantDOB=new JTextField(10);
		txtApplicantProfession=new JTextField(10);
		txtGuaranterName=new JTextField(10);
		txtGuaranterAccountNumber=new JTextField(10);
		
		// initializing JTextArea
		
		txtApplicantAddress=new JTextArea(2,10);
		txtGuaranterAddress=new JTextArea(2,10);
		
		// initializing JComboBox
		
		String gender[]={"Male","Female"};
		cmbApplicantGender=new JComboBox(gender);
		
		String accountmode[]={"Saving","Current"};
		cmbAccountMode=new JComboBox(accountmode);
		
		// initializing JButton
		
		btncreateAccount=new JButton("Create Account");
		btnReset1=new JButton("Reset");
		
		NewAccountLayout(); // UDF to organize controls in New Account Panel
		
		// adding controls to panel
		
		createNewAccountPanel.add(lblAccountNumber);
		createNewAccountPanel.add(txtAccountNumber);
		createNewAccountPanel.add(lblPersonalDetails);
		createNewAccountPanel.add(lblApplicantName);
		createNewAccountPanel.add(txtApplicantName);
		createNewAccountPanel.add(lblApplicantDOB);
		createNewAccountPanel.add(txtApplicantDOB);
		createNewAccountPanel.add(lblApplicantGender);
		createNewAccountPanel.add(cmbApplicantGender);
		createNewAccountPanel.add(lblApplicantProfession);
		createNewAccountPanel.add(txtApplicantProfession);
		createNewAccountPanel.add(lblApplicantAddress);
		createNewAccountPanel.add(txtApplicantAddress);
		createNewAccountPanel.add(lblAccountDetails);
		createNewAccountPanel.add(lblAccountMode);
		createNewAccountPanel.add(cmbAccountMode);
		createNewAccountPanel.add(lblGuaranterDetails);
		createNewAccountPanel.add(lblGuaranterName);
		createNewAccountPanel.add(txtGuaranterName);
		createNewAccountPanel.add(lblGuaranterAccountNumber);
		createNewAccountPanel.add(txtGuaranterAccountNumber);
		createNewAccountPanel.add(lblGuaranterAddress);
		createNewAccountPanel.add(txtGuaranterAddress);
		createNewAccountPanel.add(btncreateAccount);
		createNewAccountPanel.add(btnReset1);
		
		btncreateAccount.addActionListener(this);
		btnReset1.addActionListener(this);
	}
	// createNewAccount() Function ends
		
	// accountTransaction() Function
	public void accountTransation()
	{
		// initializing Jlabel
		
		date=new java.util.Date();
		lblTransactionAccountNumber=new JLabel("Applicant Account Number");
		lblAccountHoldersName=new JLabel("Account Holder's Name");
		lblCurrentBalance=new JLabel("Current Balance");
		lblTransactionType=new JLabel("Transaction Type");
		lblTransactionAmount=new JLabel("Transaction Amount");
		lblTransactionDate=new JLabel("Transaction Date");
		lblTransactionMode=new JLabel("Transaction Mode");
		
		// initializing TextFields
		
		txtTransactionAccountNumber=new JTextField(10);
		txtAccountHoldersName=new JTextField(10);
		txtTransactionDate=new JTextField(15);
		txtTransactionAmount=new JTextField(10);
		txtCurrentBalance=new JTextField(10);
		
		txtTransactionDate.setText(date.toString());
		
		// initializing JComboBox
		
		String transactiontype[]={"Deposit","Withdrawl"};
		cmbTransactionType=new JComboBox(transactiontype);
		
		String transactionmode[]={"Cash","Cheque","Draft"};
		cmbTransactionMode=new JComboBox(transactionmode);
		
		// initializing JButton
		
		btnGetDetails=new JButton("Get Details");
		btnSubmit=new JButton("Submit");
		btnReset2=new JButton("Reset");
		
		btnGetDetails.addActionListener(this);
		btnSubmit.addActionListener(this);
		btnReset2.addActionListener(this);
		
		TransactionLayout(); // UDF to organize controls in Transaction panel
		
		// adding controls to Panel
		
		accountTransactionPanel.add(lblTransactionAccountNumber);
		accountTransactionPanel.add(txtTransactionAccountNumber);
		accountTransactionPanel.add(btnGetDetails);
		accountTransactionPanel.add(lblAccountHoldersName);
		accountTransactionPanel.add(txtAccountHoldersName);
		accountTransactionPanel.add(lblCurrentBalance);
		accountTransactionPanel.add(txtCurrentBalance);
		accountTransactionPanel.add(lblTransactionDate);
		accountTransactionPanel.add(txtTransactionDate);
		accountTransactionPanel.add(lblTransactionType);
		accountTransactionPanel.add(cmbTransactionType);
		accountTransactionPanel.add(lblTransactionMode);
		accountTransactionPanel.add(cmbTransactionMode);
		accountTransactionPanel.add(lblTransactionAmount);
		accountTransactionPanel.add(txtTransactionAmount);
		accountTransactionPanel.add(btnSubmit);
		accountTransactionPanel.add(btnReset2);
	}
	// accountTransaction() Function ends
	
	// controlPanel() Function
 	public void controlPanel()
	{
		//initializing RadioButtons
		rCreateUser=new JRadioButton("Create New Login :",true);
		rDeleteUser=new JRadioButton("Delete User Login :",false);
		
		// initializing JLabel
		lblNewId=new JLabel("Enter User Id :");
		lblNewPassword=new JLabel("Enter User Password :");
		lblDelLoginId=new JLabel("Enter User Id To Delete :");
		
		// initializing JTextField
		txtNewId=new JTextField(10);
		txtNewPassword=new JPasswordField(10);
		txtDelLoginId=new JTextField(10);
		
		// initializing JButton
		btnCreateNewLogin=new JButton("Create New User");
		btnReset4=new JButton("Reset");
		btnDeleteUser=new JButton("Delete User Login");
		
		// registering controls with ActionListener
		btnCreateNewLogin.addActionListener(this);
		btnReset4.addActionListener(this);
		btnDeleteUser.addActionListener(this);
		rCreateUser.addActionListener(this);
		rDeleteUser.addActionListener(this);
		
		controlPanelLayout(); // UDF to organize controls in controlPanel panel
		
		// adding controls to the panel
		controlPanel.add(rCreateUser);
		controlPanel.add(lblNewId);
		controlPanel.add(txtNewId);
		controlPanel.add(lblNewPassword);
		controlPanel.add(txtNewPassword);
		controlPanel.add(btnCreateNewLogin);
		controlPanel.add(btnReset4);
		controlPanel.add(rDeleteUser);
		controlPanel.add(lblDelLoginId);
		controlPanel.add(txtDelLoginId);
		controlPanel.add(btnDeleteUser);
		
	}
	// controlPanel()  Function ends
	
	// accountDetails() Function
	public void accountDetails()
	{
		// initializing JLabel
		lblAccountNumber=new JLabel("Enter Account Number :");
		lblTransactionDate=new JLabel("");
		lblTransactionType=new JLabel("");
		lblTransactionAmount=new JLabel("");
		lblTransactionMode=new JLabel("");
		lblAccountBalance=new JLabel("");
		
		// initializing JTextField
		txtAccountNumberDet=new JTextField(10);
		
		// initializing JButton
		btnSearch=new JButton("Display Account Details");
		btnReset3=new JButton("Reset");
		
		accountDetailsLayout(); // UDF to organize controls in accountDetails panel
		
		// adding controls to the accountDetails panel
		displayDetailsPanel.add(lblAccountNumber);
		displayDetailsPanel.add(txtAccountNumberDet);
		displayDetailsPanel.add(btnSearch);
		displayDetailsPanel.add(btnReset3);
	
		// registering the controls with the Actionlistener
		btnSearch.addActionListener(this);
		btnReset3.addActionListener(this);
	}
	// accountTransaction() Function ends
	
	// logoutPanel() Function
	public void logoutPanel()
	{
		// initializing JLabel
		lblExitApps=new JLabel("Click To LogOut Application : ");
		
		// initializing JButton
		btnExitApps=new JButton("LogOut Application");
		
		logoutPanelLayout(); // UDF to organize controls in the logoutPanel
		
		// adding controls to the logoutPanel
		logoutPanel.add(lblExitApps);
		logoutPanel.add(btnExitApps);
		
		// registering control with the Actionlistener
		btnExitApps.addActionListener(this);
		
	}
	// logoutPanel() Function ends
	
	Connection connection; // declaring connection variable

// **********************************************************************************************************	
	//Event Handling....
//**********************************************************************************************************		
	public void actionPerformed(ActionEvent et)
	{
		
	// Event handling for login panel
		userID=null;
		userPWD=null;
	if(et.getSource()==btnLogin)
	{
		userID=txtID.getText();
		userPWD=txtPWD.getText();
		Connection connection;
		
		if(userID.length()==0)
		{
			JOptionPane.showMessageDialog(null,"Please Specify Login Id..");
			return;
		}
		else if(userPWD.length()==0)
		{
			JOptionPane.showMessageDialog(null,"Please Specify Login Password..");
			return;
		}
		else
		{
			try
			{
				Class.forName( "oracle.jdbc.driver.OracleDriver" );	// to load the driver
				String url = "jdbc:oracle:thin:@localhost:1521:xe";			// to connect to the database
				connection = DriverManager.getConnection( url, "SYSTEM", "SYSTEM" );
			
				PreparedStatement preparedstatement=connection.prepareStatement("select * from usertbl where userid=? and userpassword=?");
				preparedstatement.setString(1,userID);
				preparedstatement.setString(2,userPWD);
				ResultSet resultset=preparedstatement.executeQuery();
			
				if(resultset.next())
				{
					JOptionPane.showMessageDialog(null,"Login Successfull....");
					txtID.setText("");
					txtPWD.setText("");
					
					tabbedpane.setEnabledAt(1,false);
					tabbedpane.setEnabledAt(2,true);
					tabbedpane.setEnabledAt(3,true);
					tabbedpane.setEnabledAt(4,true);
					tabbedpane.setEnabledAt(5,true);
					tabbedpane.setEnabledAt(6,true);
					
					tabbedpane.setSelectedIndex(3);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Authentication Failed....");
					txtID.setText("");
					txtPWD.setText("");
				}
			}
			catch(Exception psexception)
			{
				JOptionPane.showMessageDialog(null,"Login Error....");
			}
		}
	} 
		if(et.getSource()==btnReset)
		{
			txtID.setText("");
			txtPWD.setText("");
		}
		
		if(et.getSource()==btnExit)
		{
			JOptionPane.showMessageDialog(null,"Thanks....");
			tabbedpane.setSelectedIndex(0);
			tabbedpane.setEnabledAt(0,true);
			tabbedpane.setEnabledAt(1,false);
			//showStatus("Welcome To Java Bank Application....");
			
		}
	//Event handling for login panel ends
	
	// Event handling for New Account
		
		if(et.getSource()==btncreateAccount)
		{

		if(txtApplicantName.getText().length()==0)
		{
			JOptionPane.showMessageDialog(null,"Please Specify Applicant's Name..");
			return;
		}
		else if(txtApplicantDOB.getText().length()==0)
		{
			JOptionPane.showMessageDialog(null,"Please Specify Applicant's Date Of Birth..");
			return;
		}
		else if(txtApplicantProfession.getText().length()==0)
		{
			JOptionPane.showMessageDialog(null,"Please Specify Applicant's Profession..");
			return;
		}
		else if(txtApplicantAddress.getText().length()==0)
		{
			JOptionPane.showMessageDialog(null,"Please Specify Applicant's Address..");
			return;
		}
		else if(txtGuaranterName.getText().length()==0)
		{
			JOptionPane.showMessageDialog(null,"Please Specify Guaranter's Name");
			return;
		}
		else if(txtGuaranterAccountNumber.getText().length()==0)
		{
			JOptionPane.showMessageDialog(null,"Please Specify Guaranter's Account Number..");
			return;
		}
		else if(txtGuaranterAddress.getText().length()==0)
		{
			JOptionPane.showMessageDialog(null,"Please Specify Guaranter's Address..");
			return;
		}
		else if(checkNumbers(txtApplicantName.getText())==true)
		{
			JOptionPane.showMessageDialog(null,"Applicant Name cannot contain Numbers....");
			return;
		}
		else if(checkNumbers(txtApplicantProfession.getText())==true)
		{
			JOptionPane.showMessageDialog(null,"Applicant Profession cannot contain Numbers....");
			return;
		}
		else if(checkNumbers(txtGuaranterName.getText())==true)
		{
			JOptionPane.showMessageDialog(null,"Guaranter Name cannot contain Numbers....");
			return;
		}
		else if(checkCharacters(txtGuaranterAccountNumber.getText())==true)
		{
			JOptionPane.showMessageDialog(null,"Guaranter Account Number cannot contain Numbers....");
			return;
		}
		else
		{
			
			connectDB();
			try
			{
				PreparedStatement preparedstatement=connection.prepareStatement("insert into accounttbl values(?,?,?,?,?,?,?,?,?,?)");
				
				preparedstatement.setInt(1,Integer.parseInt(txtAccountNumber.getText()));
				preparedstatement.setString(2,txtApplicantName.getText());
				preparedstatement.setString(3,txtApplicantDOB.getText());
				preparedstatement.setString(4,String.valueOf(cmbApplicantGender.getSelectedItem()));
				preparedstatement.setString(5,txtApplicantProfession.getText());
				preparedstatement.setString(6,txtApplicantAddress.getText());
				preparedstatement.setString(7,String.valueOf(cmbAccountMode.getSelectedItem()));
				preparedstatement.setString(8,txtGuaranterName.getText());
				preparedstatement.setInt(9,Integer.parseInt(txtGuaranterAccountNumber.getText()));
				preparedstatement.setString(10,txtGuaranterAddress.getText());
				
				preparedstatement.executeUpdate();
				JOptionPane.showMessageDialog(null,"Account Created Successfully....");
				preparedstatement.close();
				
				date=new java.util.Date();
				preparedstatement=connection.prepareStatement("insert into \"transactiontbl\" values(?,?,?,?,?,?)");
				preparedstatement.setInt(1,Integer.parseInt(txtAccountNumber.getText()));
				preparedstatement.setString(2,date.toString());
				preparedstatement.setString(3,"Deposit");
				preparedstatement.setInt(4,500);
				preparedstatement.setString(5,"Cash");
				preparedstatement.setInt(6,500);
				preparedstatement.executeUpdate();
				JOptionPane.showMessageDialog(null,"Transaction table updated....");
				
				// Clearing field values....
				
				txtAccountNumber.setText("");
				txtApplicantName.setText("");
				txtApplicantDOB.setText("");
				txtApplicantProfession.setText("");
				txtApplicantAddress.setText("");
				txtGuaranterName.setText("");
				txtGuaranterAccountNumber.setText("");
				txtGuaranterAddress.setText("");
				accountnumber=accountnumber+1;
				txtAccountNumber.setText(String.valueOf(accountnumber));
				
			}
			catch(Exception NewAccountErr)
			{
				JOptionPane.showMessageDialog(null,"Error Creating New Account! Please Check Specified Field Values [i.e. Numerical Fields sgould not contain Characters and vice-versa....]");
			}
			
		}
	}
		if(et.getSource()==btnReset1)
		{
			txtApplicantName.setText("");
			txtApplicantDOB.setText("");
			txtApplicantProfession.setText("");
			txtApplicantAddress.setText("");
			txtGuaranterName.setText("");
			txtGuaranterAccountNumber.setText("");
			txtGuaranterAddress.setText("");
		}
		
	//Event handling for New Account ends
		
	//Event handling for Transaction begins
		
		int totalamount=0;
		int amountDep=0;int amountWid=0;
		
		if(et.getSource()==btnGetDetails)
		{
		if(txtTransactionAccountNumber.getText().length()==0)
		{
				JOptionPane.showMessageDialog(null,"PLease Specify Account Number..");
				return;
		}
		else if(checkCharacters(txtTransactionAccountNumber.getText())==true)
		{
			JOptionPane.showMessageDialog(null,"Account Number cannot contain Characters....");
			return;
		}
		else
		{
		
			connectDB();
			ResultSet resultset=null;
			try
			{
				PreparedStatement preparedstatement=connection.prepareStatement("select * from accounttbl where accnum=?");
				preparedstatement.setInt(1,Integer.parseInt(txtTransactionAccountNumber.getText()));
				resultset=preparedstatement.executeQuery();
				if(resultset.next())
				{
					txtAccountHoldersName.setText(resultset.getString(2));
					btnSubmit.setEnabled(true);
					btnGetDetails.setEnabled(false);
					txtTransactionAccountNumber.setEnabled(false);
					cmbTransactionMode.setEnabled(true);
					cmbTransactionType.setEnabled(true);
					txtTransactionAmount.setEnabled(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid Account Number....");
				}
			}	
			catch(Exception err){JOptionPane.showMessageDialog(null,"Error Searching Account Details! Please enter Valid Account Number");}		
			
			try
			{
				PreparedStatement preparedstatement1=connection.prepareStatement("select * from \"transactiontbl\" where accnum=? and Type=?");
				preparedstatement1.setInt(1,Integer.parseInt(txtTransactionAccountNumber.getText()));
				preparedstatement1.setString(2,"Deposit");
				ResultSet resultset1=preparedstatement1.executeQuery();
							
				PreparedStatement preparedstatement2=connection.prepareStatement("select * from \"transactiontbl\" where accnum=? and Type=?");
				preparedstatement2.setInt(1,Integer.parseInt(txtTransactionAccountNumber.getText()));
				preparedstatement2.setString(2,"Withdrawl");
				ResultSet resultset2=preparedstatement2.executeQuery();
				
				while(resultset1.next())
				{
					amountDep=amountDep+resultset1.getInt(4);
						while(resultset2.next())
						{
											
							amountWid=amountWid+resultset2.getInt(4);
						}	
				}
				totalamount=amountDep-amountWid;
				txtCurrentBalance.setText(String.valueOf(totalamount));
			}
			catch(Exception errr){}
			
		}
	}		
		if(et.getSource()==btnSubmit)
		{
		if(txtTransactionAmount.getText().length()==0)
		{
				JOptionPane.showMessageDialog(null,"PLease Specify Transaction Amount..");
				return;
		}
		else if(checkCharacters(txtTransactionAmount.getText())==true)
		{
			JOptionPane.showMessageDialog(null,"Transaction Amount cannot contain Characters....");
			return;
		}
		else
		{
		
			connectDB();
			totalamount=0;
				
			if(String.valueOf(cmbTransactionType.getSelectedItem())=="Withdrawl")
			{
				totalamount=Integer.parseInt(txtCurrentBalance.getText())-Integer.parseInt(txtTransactionAmount.getText());
				
			}
			else
			{
				totalamount=Integer.parseInt(txtCurrentBalance.getText())+Integer.parseInt(txtTransactionAmount.getText());
				
			}
			try
			{
				
				PreparedStatement preparedstatement=connection.prepareStatement("insert into \"transactiontbl\" values(?,?,?,?,?,?)");
				preparedstatement.setInt(1,Integer.parseInt(txtTransactionAccountNumber.getText()));
				preparedstatement.setString(2,date.toString());
				preparedstatement.setString(3,String.valueOf(cmbTransactionType.getSelectedItem()));
				preparedstatement.setInt(4,Integer.parseInt(txtTransactionAmount.getText()));
				preparedstatement.setString(5,String.valueOf(cmbTransactionMode.getSelectedItem()));
				preparedstatement.setInt(6,totalamount);
				preparedstatement.executeUpdate();
				JOptionPane.showMessageDialog(null,"Transaction Successfull....");
			}
			catch(Exception err)
			{
				JOptionPane.showMessageDialog(null,"Error Updating Transaction Table! ");
				txtTransactionAccountNumber.setText("");
				txtAccountHoldersName.setText("");
				txtCurrentBalance.setText("");
				txtTransactionAmount.setText("");
				btnGetDetails.setEnabled(true);
				txtTransactionAccountNumber.setEnabled(true);
				cmbTransactionMode.setEnabled(false);
				cmbTransactionType.setEnabled(false);
			}
			txtTransactionAmount.setEnabled(false);
			btnSubmit.setEnabled(false);
		}
	}
		if(et.getSource()==btnReset2)
		{
			txtTransactionAccountNumber.setText("");
			txtAccountHoldersName.setText("");
			txtCurrentBalance.setText("");
			txtTransactionAmount.setText("");
			btnGetDetails.setEnabled(true);
			txtTransactionAccountNumber.setEnabled(true);
			cmbTransactionMode.setEnabled(false);
			cmbTransactionType.setEnabled(false);
		}
	// Event handling for transaction ends
		
	// Event handling for display details begins
	if(et.getSource()==btnSearch)
	{
		if(txtAccountNumberDet.getText().length()==0)
		{
				JOptionPane.showMessageDialog(null,"PLease Specify Account Number..");
				return;
		}
		else if(checkCharacters(txtAccountNumberDet.getText())==true)
		{
			JOptionPane.showMessageDialog(null,"Invalid Data Entered : Account Number cannot contain characters....");
			txtAccountNumberDet.setText("");
			return;
		}
		else
		{
			connectDB();
			try
			{
				PreparedStatement preparedstatement=connection.prepareStatement("select * from \"transactiontbl\" where accnum=?");
				preparedstatement.setInt(1,Integer.parseInt(txtAccountNumberDet.getText()));
				ResultSet resultset=preparedstatement.executeQuery();
				
			if(resultset.next())
			{
				ResultSetMetaData rsmd=resultset.getMetaData();
				
				Vector rows,columnNames,newRow;

			   int numberOfColumns =  rsmd.getColumnCount();
               columnNames = new Vector();
               for(int column = 0; column < numberOfColumns; column++)
               {
                     columnNames.addElement(rsmd.getColumnLabel(column+1));
               }
               rows = new Vector();
			   rows.addElement(columnNames);
			   resultset.previous();
               while (resultset.next())
               {
                    newRow = new Vector();
                    for (int i = 1; i <= rsmd.getColumnCount(); i++)
                    {
                         newRow.addElement(resultset.getObject(i));
                    }
                    rows.addElement(newRow);
               }
               table = new JTable(rows, columnNames);

				JOptionPane.showMessageDialog(null,"Valid Account Number : Displaying Details....");
				
				JFrame f=new JFrame("Account Details");
				f.setSize(800,600);
				f.setVisible(true);
				JPanel p=new JPanel();
				f.getContentPane().add(p);
				p.add(table);
				
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Invalid Account Number....");
				return;
			}
		}	
			catch(Exception err)
			{
				JOptionPane.showMessageDialog(null,"Error Executing Query or Invalid Account Number....");
				txtAccountNumber.setText("");
			}
			btnSearch.setEnabled(false);
		}
	}
		if(et.getSource()==btnReset3)
		{
			txtAccountNumberDet.setText("");
			btnSearch.setEnabled(true);
		}
	//Event handling for displaydetails ends
		
	//Event handling for control panel begins
	if(et.getSource()==btnCreateNewLogin)
	{
		
		if(txtNewId.getText().length()==0)
		{
			JOptionPane.showMessageDialog(null,"Please Specify New Login Id..");
			return;
		}
		else if(txtNewPassword.getText().length()==0)
		{
			JOptionPane.showMessageDialog(null,"Please Specify New Login Password..");
			return;
		}
		else
		{
			connectDB();
			try
			{
				PreparedStatement preparedstatement=connection.prepareStatement("insert into usertbl values(?,?)");
				preparedstatement.setString(1,txtNewId.getText());
				preparedstatement.setString(2,txtNewPassword.getText());
				preparedstatement.executeUpdate();
				JOptionPane.showMessageDialog(null,"New Login Created Successfully....");
				txtNewId.setText("");
				txtNewPassword.setText("");
			}
			catch(Exception err)
			{
				JOptionPane.showMessageDialog(null,"Id Already Exists....Please Choose Another Login Id....");
			}
		}
	}
		if(et.getSource()==btnReset4)
		{
			txtNewId.setText("");
			txtNewPassword.setText("");
		}
		if(et.getSource()==btnDeleteUser)
		{
		if(txtDelLoginId.getText().length()==0)
		{
			JOptionPane.showMessageDialog(null,"Please Specify Login Id To Delete..");
			return;
		}
		else
		{
			connectDB();
			try
			{
				PreparedStatement preparedstatement=connection.prepareStatement("select * from usertbl where userid=?");
				preparedstatement.setString(1,txtDelLoginId.getText());
				ResultSet resultset=preparedstatement.executeQuery();
				
				if(resultset.next())
				{
					PreparedStatement preparedstatement1=connection.prepareStatement("delete from usertbl where userid=?");
					preparedstatement1.setString(1,txtDelLoginId.getText());
					preparedstatement1.executeUpdate();
					JOptionPane.showMessageDialog(null,"Deletion Successfull....");
					txtDelLoginId.setText("");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Id Does Not Exist....");
					txtDelLoginId.setText("");
				}
				
			}
			catch(Exception err){JOptionPane.showMessageDialog(null,"Invalid User Login Id....");}
			
		}
	}
	// Event handling for control panel ends
		
	// Event handling for logout Panel
		if(et.getSource()==btnExitApps)
		{
			JOptionPane.showMessageDialog(null,"You Have Been Logged Out....");
			tabbedpane.setSelectedIndex(1);
			
			tabbedpane.setEnabledAt(1,true);
			tabbedpane.setEnabledAt(2,false);
			tabbedpane.setEnabledAt(3,false);
			tabbedpane.setEnabledAt(4,false);
			tabbedpane.setEnabledAt(5,false);
			tabbedpane.setEnabledAt(6,false);
		}
	// Event handling for logout Panel ends
		
	// Event handling for welcome panel
		if(et.getSource()==btnLtoC)
		{
			JOptionPane.showMessageDialog(null,"Welcome Guest : Continue!!");
			tabbedpane.setSelectedIndex(1);
			tabbedpane.setEnabledAt(0,false);
			tabbedpane.setEnabledAt(1,true);
		}
		if(et.getSource()==btnQuit)
		{
			JOptionPane.showMessageDialog(null,"Exitting Application....");
			System.exit(0);
		}
	// Event handling for welcome panel ends
		
	//Event handling for control panel
		if(et.getSource()==rCreateUser)
		{
			rDeleteUser.setSelected(false);
			txtDelLoginId.setEnabled(false);
			btnDeleteUser.setEnabled(false);
			
			txtNewId.setEnabled(true);
			txtNewPassword.setEnabled(true);
			btnCreateNewLogin.setEnabled(true);
			btnReset4.setEnabled(true);
		}
		if(et.getSource()==rDeleteUser)
		{
			rCreateUser.setSelected(false);
			txtNewId.setEnabled(false);
			txtNewPassword.setEnabled(false);
			btnCreateNewLogin.setEnabled(false);
			btnReset4.setEnabled(false);
			
			txtDelLoginId.setEnabled(true);
			btnDeleteUser.setEnabled(true);
		}
	//Event handling for control panel ends
	
	}
	// Event handling ends
	
// **********************************************************************************************************		//		user defined functions
//**********************************************************************************************************		
	// UDF to connect to the database
	public void connectDB()
	{
		try
		{
			Class.forName( "oracle.jdbc.driver.OracleDriver" );	// to load the driver
				String url = "jdbc:oracle:thin:@localhost:1521:xe";			// to connect to the database
				connection = DriverManager.getConnection( url, "SYSTEM", "SYSTEM" );
			    
		}
		catch(Exception connectErr)
		{
			//showStatus("Error Connectiong To database.."+connectErr);
		}
	}
	
	// UDF to increement the account number
	public void autoAccountNumber()
	{
		accountnumber=0;
		connectDB();
			try
			{
				Statement statement=connection.createStatement();
				ResultSet resultset=statement.executeQuery("select * from accounttbl");
				while(resultset.next())
				{
					accountnumber=0;
					accountnumber=resultset.getInt(1);
				}
				accountnumber=accountnumber+1;
				txtAccountNumber.setText("");
				txtAccountNumber.setText(String.valueOf(accountnumber));
			}
			catch(Exception err)
			{
				//showStatus("");
				//showStatus("Increement Error..../Query Error...."+err);
			}
	} // function autoAccountNumber() ends
	
public boolean checkNumbers(String s)
	{
		int len=s.length();
		int flag=0;
		boolean set=false;
		for(int i=0;i<len;i++)
		{
			if(s.charAt(i)>=48 && s.charAt(i)<=57)
			{
				flag=flag+1;
			}
			else
			{
				flag=0;
			}
		}
		if(flag>0)
		{
			set=true;
	//			JOptionPane.showMessageDialog(null,"Invalid Data Entered..Numbers Found in place of Characters....");
		}
		return set;
	}
	
	public boolean checkCharacters(String s)
	{
		int len=s.length();
		int flag=0;
		boolean set=false;
		for(int i=0;i<len;i++)
		{
			if((s.charAt(i)>=97 && s.charAt(i)<=123) || (s.charAt(i)>=65 && s.charAt(i)<=91))
			{
				flag=flag+1;
			}
			else
			{
				flag=0;
			}
		}
		if(flag>0)
		{
			set=true;
		//	JOptionPane.showMessageDialog(null,"Invalid Data Entered..Characters Found in place in Numerical Fields....");
		}
		return set;
	}	
// **********************************************************************************************************	
	
// **********************************************************************************************************	
	// Organizing controls....
// **********************************************************************************************************		
	// welcomeLayout()  Function 
	public void welcomeLayout()
	{
		gbl=new GridBagLayout();
		welcomePanel.setLayout(gbl);
		gbc=new GridBagConstraints();
		
		gbc.gridx=5;
		gbc.gridy=0;
		gbl.setConstraints(lblWelcome1,gbc);
		
		gbc.gridx=5;
		gbc.gridy=10;
		gbl.setConstraints(lblWelcome2,gbc);
	
		gbc.gridx=10;
		gbc.gridy=10;
		gbl.setConstraints(btnLtoC,gbc);
		
		gbc.gridx=12;
		gbc.gridy=10;
		gbl.setConstraints(btnQuit,gbc);
		
	} // welcome layout ends
	
	// loginLayout()  Function
	public void loginLayout()
	{
		gbl=new GridBagLayout();
		loginPanel.setLayout(gbl);
		gbc=new GridBagConstraints();
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbl.setConstraints(lblLogin,gbc);
		
		gbc.gridx=1;
		gbc.gridy=1;
		gbl.setConstraints(lblID,gbc);
	
		gbc.gridx=10;
		gbc.gridy=1;
		gbl.setConstraints(txtID,gbc);
		
		gbc.gridx=1;
		gbc.gridy=2;
		gbl.setConstraints(lblPWD,gbc);
	
		gbc.gridx=10;
		gbc.gridy=2;
		gbl.setConstraints(txtPWD,gbc);
		
		gbc.gridx=20;
		gbc.gridy=5;
		gbl.setConstraints(btnLogin,gbc);
		
		gbc.gridx=21;
		gbc.gridy=5;
		gbl.setConstraints(btnReset,gbc);
		
		gbc.gridx=22;
		gbc.gridy=5;
		gbl.setConstraints(btnExit,gbc);
		
	} // login layout ends
	
	// NewAccountLayout() Function
	public void NewAccountLayout()
	{
		gbl=new GridBagLayout();
		createNewAccountPanel.setLayout(gbl);
		gbc=new GridBagConstraints();
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbl.setConstraints(lblAccountNumber,gbc);
		
		gbc.gridx=1;
		gbc.gridy=0;
		gbl.setConstraints(txtAccountNumber,gbc);
		
		gbc.gridx=0;
		gbc.gridy=5;
		gbl.setConstraints(lblPersonalDetails,gbc);
		
		gbc.gridx=1;
		gbc.gridy=22;
		gbl.setConstraints(lblApplicantName,gbc);
		
		gbc.gridx=20;
		gbc.gridy=22;
		gbl.setConstraints(txtApplicantName,gbc);
		
		gbc.gridx=1;
		gbc.gridy=24;
		gbl.setConstraints(lblApplicantDOB,gbc);
				
		gbc.gridx=20;
		gbc.gridy=24;
		gbl.setConstraints(txtApplicantDOB,gbc);
		
		gbc.gridx=1;
		gbc.gridy=26;
		gbl.setConstraints(lblApplicantGender,gbc);
		
		gbc.gridx=15;
		gbc.gridy=26;
		gbl.setConstraints(cmbApplicantGender,gbc);
		
		gbc.gridx=1;
		gbc.gridy=28;
		gbl.setConstraints(lblApplicantProfession,gbc);
		
		gbc.gridx=20;
		gbc.gridy=28;
		gbl.setConstraints(txtApplicantProfession,gbc);
		
		gbc.gridx=1;
		gbc.gridy=30;
		gbl.setConstraints(lblApplicantAddress,gbc);
		
		
		gbc.gridx=20;
		gbc.gridy=30;
		gbl.setConstraints(txtApplicantAddress,gbc);
		
		gbc.gridx=0;
		gbc.gridy=40;
		gbl.setConstraints(lblAccountDetails,gbc);
		
		gbc.gridx=1;
		gbc.gridy=42;
		gbl.setConstraints(lblAccountMode,gbc);
		
		gbc.gridx=15;
		gbc.gridy=42;
		gbl.setConstraints(cmbAccountMode,gbc);
		
		gbc.gridx=0;
		gbc.gridy=50;
		gbl.setConstraints(lblGuaranterDetails,gbc);
		
		gbc.gridx=1;
		gbc.gridy=52;
		gbl.setConstraints(lblGuaranterName,gbc);
		
		
		gbc.gridx=20;
		gbc.gridy=52;
		gbl.setConstraints(txtGuaranterName,gbc);
		
		gbc.gridx=1;
		gbc.gridy=54;
		gbl.setConstraints(lblGuaranterAccountNumber,gbc);
		
		gbc.gridx=20;
		gbc.gridy=54;
		gbl.setConstraints(txtGuaranterAccountNumber,gbc);
		
		gbc.gridx=1;
		gbc.gridy=56;
		gbl.setConstraints(lblGuaranterAddress,gbc);
		
		gbc.gridx=20;
		gbc.gridy=56;
		gbl.setConstraints(txtGuaranterAddress,gbc);
		
		gbc.gridx=35;
		gbc.gridy=70;
		gbl.setConstraints(btncreateAccount,gbc);
		
		gbc.gridx=36;
		gbc.gridy=70;
		gbl.setConstraints(btnReset1,gbc);
			
	} // new account layout ends 
	
	// TransactionLayout() Function
	public void TransactionLayout()
	{
		gbl=new GridBagLayout();
		accountTransactionPanel.setLayout(gbl);
		gbc=new GridBagConstraints();
		
		gbc.gridx=1;
		gbc.gridy=0;
		gbl.setConstraints(lblTransactionAccountNumber,gbc);
		
		gbc.gridx=1;
		gbc.gridy=1;
		gbl.setConstraints(txtTransactionAccountNumber,gbc);
		
		gbc.gridx=5;
		gbc.gridy=1;
		gbl.setConstraints(btnGetDetails,gbc);
		
		gbc.gridx=0;
		gbc.gridy=14;
		gbl.setConstraints(lblAccountHoldersName,gbc);
		
		gbc.gridx=10;
		gbc.gridy=14;
		gbl.setConstraints(txtAccountHoldersName,gbc);
		
		gbc.gridx=0;
		gbc.gridy=16;
		gbl.setConstraints(lblCurrentBalance,gbc);
		
		gbc.gridx=10;
		gbc.gridy=16;
		gbl.setConstraints(txtCurrentBalance,gbc);
		
		gbc.gridx=0;
		gbc.gridy=18;
		gbl.setConstraints(lblTransactionDate,gbc);
		
		gbc.gridx=10;
		gbc.gridy=18;
		gbl.setConstraints(txtTransactionDate,gbc);
		
		gbc.gridx=0;
		gbc.gridy=20;
		gbl.setConstraints(lblTransactionType,gbc);
		
		gbc.gridx=10;
		gbc.gridy=20;
		gbl.setConstraints(cmbTransactionType,gbc);
		
		gbc.gridx=0;
		gbc.gridy=22;
		gbl.setConstraints(lblTransactionMode,gbc);
		
		gbc.gridx=10;
		gbc.gridy=22;
		gbl.setConstraints(cmbTransactionMode,gbc);
		
		gbc.gridx=0;
		gbc.gridy=24;
		gbl.setConstraints(lblTransactionAmount,gbc);
		
		gbc.gridx=10;
		gbc.gridy=24;
		gbl.setConstraints(txtTransactionAmount,gbc);
		
		gbc.gridx=20;
		gbc.gridy=25;
		gbl.setConstraints(btnSubmit,gbc);
		
		gbc.gridx=22;
		gbc.gridy=25;
		gbl.setConstraints(btnReset2,gbc);
		
	} // transaction layout ends
	
	// controlPanelLayout() Function
	public void controlPanelLayout()
	{
		gbl=new GridBagLayout();
		controlPanel.setLayout(gbl);
		gbc=new GridBagConstraints();
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbl.setConstraints(rCreateUser,gbc);
		
		gbc.gridx=1;
		gbc.gridy=10;
		gbl.setConstraints(lblNewId,gbc);
		
		gbc.gridx=10;
		gbc.gridy=10;
		gbl.setConstraints(txtNewId,gbc);
		
		gbc.gridx=1;
		gbc.gridy=14;
		gbl.setConstraints(lblNewPassword,gbc);
		
		gbc.gridx=10;
		gbc.gridy=14;
		gbl.setConstraints(txtNewPassword,gbc);
		
		gbc.gridx=20;
		gbc.gridy=20;
		gbl.setConstraints(btnCreateNewLogin,gbc);
		
		gbc.gridx=21;
		gbc.gridy=20;
		gbl.setConstraints(btnReset4,gbc);
		
		gbc.gridx=0;
		gbc.gridy=30;
		gbl.setConstraints(rDeleteUser,gbc);
		
		
		gbc.gridx=1;
		gbc.gridy=34;
		gbl.setConstraints(lblDelLoginId,gbc);
		
		gbc.gridx=10;
		gbc.gridy=34;
		gbl.setConstraints(txtDelLoginId,gbc);
		
		gbc.gridx=20;
		gbc.gridy=40;
		gbl.setConstraints(btnDeleteUser,gbc);
		
	} // control panel layout ends
	
	// accountDetailsLayout() Function
	public void accountDetailsLayout()
	{
		gbl=new GridBagLayout();
		displayDetailsPanel.setLayout(gbl);
		gbc=new GridBagConstraints();
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbl.setConstraints(lblAccountNumber,gbc);
	
		gbc.gridx=1;
		gbc.gridy=0;
		gbl.setConstraints(txtAccountNumberDet,gbc);
		
		gbc.gridx=10;
		gbc.gridy=10;
		gbl.setConstraints(btnSearch,gbc);
		
		gbc.gridx=11;
		gbc.gridy=10;
		gbl.setConstraints(btnReset3,gbc);
	} // account details layout ends
	
	// logoutPanelLayout() Function
	public void logoutPanelLayout()
	{
		gbl=new GridBagLayout();
		logoutPanel.setLayout(gbl);
		gbc=new GridBagConstraints();
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbl.setConstraints(lblExitApps,gbc);
	
		gbc.gridx=5;
		gbc.gridy=0;
		gbl.setConstraints(btnExitApps,gbc);
	} // exit panel layout ends

	public static void main( String args[] )
	{
		bank_mysql b = new bank_mysql();
	}

}
// class bank_mysql ends

//*******************************************************************************************************
//					code ends
//*******************************************************************************************************
// 1. 	first create database (bankdb with table) in MySQL using bank_mysql.sql file.
//
// 2.	Command to Compile : 
//		>javac -cp ".;mysql.jar"  bank_mysql.java
// 3.	Command to Run : 
//		>java -cp ".;mysql.jar" bank_mysql

//*******************************************************************************************************

