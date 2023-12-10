package com.ism510.week6.finalProject;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

public class Week6_App {

	public JFrame payrollApp;

	//
	// Employee Mgmt Tab - Vars
	//
	private JTable employeeTable;
	private JLabel empFirstNameLabel;
	private JLabel empLastNameLabel;
	private JLabel empPayRateLabel;
	private JLabel empTitleLable;
	private JLabel empStatusLabel;
	private JLabel empSelector;
	private JLabel empHoursWorkedLabel;
	private JTextField empFirstName;
	private JTextField empLastName;
	private JTextField empPayRate;
	private JTextField empTitle;
	private JTextField empEmploymentStatus;
	private JTextField empHoursWorked;
	private JButton empSubmit;
	private JButton editEmp;
	private JButton addNewEmp;
	private JButton empCancel;
	private Object[][] empData = { { "Steve", "Jobs", "15.00", "Facilities", "Full Time", "50" },
			{ "Bill", "Gates", "16.27", "Maintenance", "Full Time", "60" }, { "Hank", "Hill", "17.81", "Propane Specialist", "Full Time", "35" },
			{ "Thelma", "Tunno", "41.94", "Dental Hygienist Instructor", "Part Time", "3.5" },
			{ "Igor", "Kirgan", "16.2", "Univeristy Accountant II", "Full Time", "20.4" },
			{ "Sheridan", "Temprell", "47.36", "Design Engineer Instructor", "Full Time", "25.2" },
			{ "Bobinette", "Gunny", "43.39", "Univeristy Operations Manager", "Full Time", "10.1" },
			{ "Christos", "Semonin", "25.25", "Project Manager", "Part Time", "15.5" },
			{ "Herb", "Clash", "32.55", "Systems Administrator III", "Part Time", "19.0" },
			{ "Annadiana", "Fomichkin", "30.22", "Food Chemist Instructor", "Part Time", "20.7" },
			{ "Bibbie", "Fernant", "44.62", "Speech Pathologist Instructor", "Full Time", "1.0" },
			{ "Terrye", "Dunning", "33.97", "Physical Therapy Assistant Instructor", "Full Time", "39.4" },
			{ "Ingram", "McKean", "37.1", "Legal Assistant Instructor", "Part Time", "36.9" },
			{ "Haleigh", "Canada", "42.85", "Database Administrator IV", "Full Time", "6.7" },
			{ "Leia", "Butts", "47.77", "Data Coordinator", "Part Time", "7.5" }, { "Peta", "Yandell", "21.99", "Librarian", "Part Time", "13.0" },
			{ "Malinde", "Leftly", "34.66", "Media Manager III", "Part Time", "8.4" },
			{ "Renaud", "Curnick", "17.31", "Structural Analysis Engineer Instructor", "Full Time", "20.1" },
			{ "Leanora", "Weir", "33.52", "Electrical Engineer Instructor", "Full Time", "4.0" },
			{ "Clerkclaude", "Kulas", "49.97", "Univeristy Operator II", "Full Time", "5.3" },
			{ "Leontine", "Martineau", "35.43", "Executive Secretary", "Full Time", "17.5" },
			{ "Hobey", "Brisset", "20.28", "Database Administrator I", "Part Time", "17.5" },
			{ "Kaleb", "Murrhaupt", "48.03", "Executive Secretary", "Part Time", "12.0" },
			{ "Clayson", "Bunn", "20.75", "Geological Engineer Instructor", "Full Time", "1.2" },
			{ "Charla", "Paszek", "28.66", "Structural Analysis Engineer Instructor", "Part Time", "11.5" },
			{ "Eldridge", "Knowles", "11.56", "Office Assistant III", "Full Time", "14.7" },
			{ "Ramsay", "Rutledge", "26.23", "Environmental Tech Instructor", "Part Time", "7.6" },
			{ "Dee", "Fandrich", "12.73", "Technical Writer Instructor", "Part Time", "38.9" },
			{ "Wendy", "Deverick", "27.1", "Research Assistant III", "Part Time", "24.7" },
			{ "Akim", "Leitch", "23.17", "Quality Control Specialist", "Full Time", "57.4" },
			{ "Aloin", "Silmon", "30.59", "Physical Therapy Assistant Instructor", "Full Time", "33.4" },
			{ "Reena", "Antrobus", "26.76", "Senior Quality Engineering Instructor", "Full Time", "58.2" },
			{ "Corly", "Delany", "24.13", "Community Outreach Specialist", "Full Time", "50.1" },
			{ "Teena", "Fairclough", "31.44", "Statistician Instructor", "Full Time", "40.0" },
			{ "Thom", "Angelo", "28.17", "Media Manager Instructor", "Full Time", "59.9" },
			{ "Daria", "McMychem", "13.57", "Nurse Instructor", "Part Time", "33.4" },
			{ "Anneliese", "Grandham", "12.35", "Financial Analyst Instructor", "Part Time", "40.6" },
			{ "Paloma", "Leaf", "28.94", "Web Designer Instructor", "Part Time", "50.9" },
			{ "Guilbert", "Fordyce", "33.01", "Recruiting Manager", "Full Time", "58.2" },
			{ "Odella", "Surgey", "43.38", "Dental Hygienist Instructor", "Part Time", "45.0" },
			{ "Nadeen", "Duffit", "41.15", "Research Nurse Instructor", "Part Time", "29.8" },
			{ "Billy", "Spanton", "20.5", "Legal Assistant Instructor", "Part Time", "26.8" },
			{ "Jere", "Tothe", "14.06", "Structural Analysis Engineering Instructor", "Part Time", "32.8" },
			{ "Randie", "Curner", "43.36", "University Operations Manger II", "Full Time", "44.0" },
			{ "Selena", "Gatward", "49.92", "Safety Technician I", "Part Time", "30.5" },
			{ "Corny", "Raecroft", "44.97", "Recruiter", "Full Time", "41.4" },
			{ "Inness", "Greenham", "40.42", "Structural Engineering Instructor", "Part Time", "35.3" },
			{ "Thaddus", "Filmer", "18.54", "Clinical Specialist", "Part Time", "29.3" },
			{ "Tomlin", "Orum", "37.44", "Systems Administrator II", "Part Time", "51.2" },
			{ "Alanson", "Bedburrow", "31.52", "Electrical Engineering Instructor", "Full Time", "42.5" },
			{ "Perceval", "Faulconbridge", "32.0", "Administrative Officer", "Full Time", "40.6" },
			{ "Laverna", "Domm", "27.24", "Systems Administrator", "Full Time", "52.3" },
			{ "Frankie", "Trotman", "18.58", "Senior Associate Professor", "Part Time", "48.7" },
			{ "Rosalinde", "Orhrt", "32.15", "Safety Technician II", "Part Time", "38.2" },
			{ "Garvey", "Kahn", "34.5", "Account Coordinator", "Part Time", "37.5" },
			{ "Calli", "Haresnape", "36.88", "Recruiting Manager", "Part Time", "36.3" },
			{ "Carlen", "McInulty", "38.45", "University Editor", "Part Time", "27.3" },
			{ "Mufinella", "Deddum", "38.96", "University Executive Secretary", "Part Time", "28.3" },
			{ "Whittaker", "Waumsley", "29.6", "Accounting Instructor II", "Part Time", "53.4" },
			{ "Rosmunda", "Claw", "42.83", "Senior Developer", "Full Time", "54.3" },
			{ "Tawsha", "Casacchia", "46.28", "Nurse Instructor", "Full Time", "27.9" },
			{ "Charley", "Trench", "32.88", "Senior Quality Engineering Instructor", "Full Time", "52.4" },
			{ "Elijah", "Ivashchenko", "18.89", "Biostatistician InstructorI", "Part Time", "35.9" },
			{ "Liv", "Trafford", "39.72", "Safety Technician II", "Part Time", "54.9" },
			{ "Jaime", "McLucky", "48.84", "Pharmacist Instructor", "Full Time", "34.8" },
			{ "Kelli", "Bottoms", "43.72", "Product Engineering Instructor", "Full Time", "45.6" },
			{ "Allina", "Haysom", "40.62", "Director of Sports", "Part Time", "36.7" },
			{ "Claus", "Pierrepoint", "36.76", "Help Desk Technician", "Full Time", "41.0" },
			{ "Steffen", "Pressnell", "28.88", "Assistant Instructor Media Planner", "Part Time", "25.2" },
			{ "Emmey", "Capewell", "42.94", "Safety Technician II", "Part Time", "47.2" },
			{ "Nikolia", "Harston", "38.51", "Geological Engineering Instructor", "Full Time", "29.5" },
			{ "Devlen", "Purvess", "21.68", "Physical Therapy Assistant Instructor", "Full Time", "27.5" },
			{ "Ursola", "Heartfield", "45.75", "Engineering Instructor II", "Part Time", "53.3" },
			{ "Aldrich", "Benettolo", "13.19", "Electrical Engineering Instructor", "Full Time", "50.2" },
			{ "Orsola", "Jefferson", "30.9", "Environmental Tech Instructor", "Full Time", "27.5" },
			{ "Marve", "Ivey", "30.83", "Research Assistant Instructor III", "Part Time", "34.4" },
			{ "Berte", "Maasze", "13.34", "Nurse Instructor", "Full Time", "42.7" },
			{ "Gregor", "Piaggia", "26.72", "Desktop Support Technician", "Full Time", "48.3" },
			{ "Mariellen", "Forbes", "35.13", "Research Assistant Instructor IV", "Part Time", "58.8" },
			{ "Codi", "Rawlins", "48.32", "Software Engineering Instructor II", "Full Time", "42.4" },
			{ "Barbie", "Grolmann", "29.63", "Software Test Engineering Instructor IV", "Full Time", "44.5" },
			{ "Ursala", "Abbitt", "19.71", "Associate Professor", "Full Time", "26.3" },
			{ "Elisabeth", "Routh", "33.49", "Design Engineering Instructor", "Full Time", "53.8" },
			{ "Thacher", "Warbys", "25.05", "Nuclear Power Engineering Instructor", "Part Time", "32.3" },
			{ "Jayson", "Simkin", "30.4", "Recruiter", "Full Time", "57.0" },
			{ "Tallie", "Jendrassik", "34.79", "Environmental Tech Instructor", "Full Time", "25.9" },
			{ "Bianka", "McWhannel", "36.65", "Actuary Instructor", "Full Time", "33.1" },
			{ "Rina", "Stonuary", "49.16", "Pharmacist Instructor", "Part Time", "50.3" },
			{ "Gale", "Cranage", "48.54", "Budget/Accounting Analyst Instructor II", "Full Time", "44.9" },
			{ "Katti", "Slade", "29.78", "University Marketing Manager", "Part Time", "58.8" },
			{ "Kimmy", "Foskin", "25.69", "Software Engineering Instructor I", "Part Time", "46.5" },
			{ "Katine", "Rickerby", "48.97", "Financial Analyst Instructor", "Part Time", "50.3" },
			{ "Ford", "Maginot", "43.94", "Payment Adjustment Coordinator", "Full Time", "28.4" },
			{ "Filide", "Risborough", "32.36", "University Compensation Analyst", "Full Time", "33.4" },
			{ "Monica", "Brougham", "37.5", "Research Associate", "Part Time", "28.4" },
			{ "Albertine", "Filipson", "32.85", "Research Associate", "Full Time", "40.6" },
			{ "Helaine", "Pressdee", "18.81", "Senior Quality Engineering Instructor", "Part Time", "25.1" },
			{ "Kinnie", "Oxtoby", "16.63", "Marketing Assistant Instructor", "Full Time", "38.4" },
			{ "Jenine", "Andreoletti", "43.51", "Staff Accountant III", "Full Time", "39.9" },
			{ "Rodie", "Hollyard", "25.71", "Design Engineering Instructor", "Part Time", "42.4" },
			{ "Janenna", "Rydings", "16.37", "Chemical Engineering Instructor", "Full Time", "28.4" },
			{ "Netty", "Linscott", "31.6", "Research Associate", "Full Time", "53.4" },
			{ "Colman", "Warwicker", "27.23", "Research Associate", "Part Time", "39.0" },
			{ "Madelon", "Bratchell", "35.9", "Health Coach IV", "Part Time", "25.2" },
			{ "Dollie", "Veregan", "37.61", "Research Associate", "Part Time", "32.9" },
			{ "Kale", "Febre", "33.55", "Health Coach I", "Part Time", "59.6" },
			{ "Casey", "Nana", "12.87", "Research Associate", "Part Time", "48.1" },
			{ "Virginie", "Francombe", "37.2", "Tax Accountant Instructor", "Full Time", "56.8" },
			{ "Marielle", "Shutle", "36.11", "Research Associate II", "Part Time", "55.2" },
			{ "Delano", "Behning", "37.97", "Research Associate III", "Full Time", "35.7" },
			{ "Dita", "Lehrian", "36.35", "Web Developer Instructor", "Part Time", "44.1" },
			{ "Erika", "Beeken", "27.84", "Software Test Engineering Instructor II", "Full Time", "44.1" },
			{ "Torrence", "Elleray", "28.55", "Help Desk Associate", "Full Time", "56.9" },
			{ "Vanya", "Vallery", "33.26", "Actuary Science Instructor", "Part Time", "25.6" },
			{ "Berny", "Goldster", "19.64", "University Secretary", "Full Time", "56.4" },
			{ "Darline", "Hayball", "13.3", "Help Desk Associate", "Full Time", "59.7" },
			{ "Baxie", "Larmett", "36.31", "Cost Accountant Instructor", "Full Time", "57.9" },
			{ "Fidel", "Sapshed", "16.24", "Staff Scientist", "Part Time", "58.0" },
			{ "Reggi", "Doerren", "16.8", "Help Desk Associate", "Full Time", "44.5" },
			{ "Franni", "Deave", "20.75", "GIS Technical Architect", "Part Time", "54.1" },
			{ "Bond", "Tunnicliffe", "42.62", "University Tax Accountant", "Full Time", "48.0" },
			{ "Inger", "McBlain", "45.48", "University Compensation Analyst", "Part Time", "39.8" },
			{ "Lita", "Hackin", "31.63", "Food Chemist Instructor", "Part Time", "35.8" },
			{ "Angelita", "Radclyffe", "23.54", "Research Associate III", "Full Time", "49.5" },
			{ "Arlina", "Claricoats", "12.68", "Web Developer Instructor IV", "Part Time", "26.2" },
			{ "Manon", "Vane", "34.23", "Design Engineering Instructor", "Full Time", "32.7" },
			{ "Heywood", "Shewring", "22.64", "University Secretary", "Full Time", "48.4" },
			{ "Tamra", "Benadette", "28.56", "Systems Administrator IV", "Part Time", "38.5" },
			{ "Denise", "Lissett", "44.07", "Technical Writing Associate Instructor", "Part Time", "39.8" }, { null, null, null, null, null, null },
			{ null, null, null, null, null, null }, { null, null, null, null, null, null }, { null, null, null, null, null, null },
			{ null, null, null, null, null, null }, { null, null, null, null, null, null }, { null, null, null, null, null, null } };
	private String[] empHeaders = { "First_Name", "Last_Name", "Pay_Rate", "Title", "Employment_Status", "Hours Worked" };
	private int empDataIndex;
	private JComboBox<String> empList;
	private boolean clickedEdit = false;

	//
	// Payroll Tab - Vars
	//
	private JLabel payrollSelectEmp;
	private JComboBox<String> payrollEmpList;
	private JLabel payrollOutputKey;

	//
	// Settings Tab - Vars
	//
	private JLabel taxRateLbl;
	private JLabel regularHourCapLbl;
	private JLabel overTimeRateLbl;
	private JLabel maxHoursLbl;
	private JTextField taxRateField;
	private JTextField regHourCapField;
	private JTextField overTimeRateField;
	private JTextField maxHoursField;
	private JButton cancelSettingBtn;
	private JButton editSettingBtn;
	private JButton saveSettingBtn;
	private String[] settingsValues = { "5", "40", "1.5", "60" };

	//
	// Admin Tab - Vars
	//
	private JList<String> adminUserList;
	private JLabel adminUserLbl;
	private JButton adminSaveBtn;
	private JButton adminCancelBtn;
	private JButton adminResetPwBtn;
	private JTextField adminUsernameField;
	private JCheckBox adminIsAdminChck;
	private JCheckBox adminLockedOutChck;
	private JButton payrollRun;
	private JTable payrollOutput;
	private JScrollPane payrollOutputPane;
	private JLabel payrollErrorLbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Week6_App window = new Week6_App(args, null, null, args);
					window.payrollApp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application. here is where the arrays come in from login screen.
	 * reassign them and send them to initialize.
	 */
	public Week6_App(String[] usernames, Boolean[] lockedOut, Boolean[] isAdmin, String[] currentUser) {
		String[] loginUsernames = usernames;
		Boolean[] loginLockedOut = lockedOut;
		Boolean[] loginIsAdmin = isAdmin;
		String[] loginCurrentUser = currentUser;
		initialize(loginUsernames, loginLockedOut, loginIsAdmin, loginCurrentUser);
		empListMaker();
		defaultSettings();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize(String[] loginUsernames, Boolean[] loginLockedOut, Boolean[] loginIsAdmin, String[] loginCurrentUser) {
		// setting up arrays again, this was the only way I could get the login
		// app values here without just creating them at the top of file.
		String[] usernames = loginUsernames;
		Boolean[] isLockedOut = loginLockedOut;
		Boolean[] isAdmin = loginIsAdmin;
		String[] currentUser = loginCurrentUser;

		// check if user isAdmin and enable admin tab if true.
		Boolean enableAdminPage = false;
		if (currentUser[1].toString() == "true") {
			enableAdminPage = true;
		}

		payrollApp = new JFrame();
		payrollApp.setBounds(100, 100, 1188, 522);
		payrollApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		payrollApp.getContentPane().setLayout(null);

		// Current user from login displayed in lower right corner.
		String CurrentUserStr = "Current User: " + currentUser[0].toString() + " | Logged on: " + currentUser[2].toString();
		JLabel CurrentUserInfo = new JLabel(CurrentUserStr);
		CurrentUserInfo.setHorizontalAlignment(SwingConstants.TRAILING);
		CurrentUserInfo.setBounds(702, 451, 462, 21);
		payrollApp.getContentPane().add(CurrentUserInfo);

		// creates the tabbeed pane ( Employees / Payroll / Settings / Admin );
		JTabbedPane payrollAppPane = new JTabbedPane(JTabbedPane.BOTTOM);
		payrollAppPane.setBounds(10, 10, 1154, 464);
		payrollApp.getContentPane().add(payrollAppPane);

		//
		// Employee Mgmt Tab - GUI
		//
		JPanel employeePane = new JPanel();
		payrollAppPane.addTab("Employees", employeePane);
		payrollAppPane.setEnabledAt(0, true);
		employeePane.setLayout(null);

		JScrollPane employeeTablePane = new JScrollPane();
		employeeTablePane.setAutoscrolls(true);
		employeeTablePane.setBounds(29, 37, 876, 217);
		employeePane.add(employeeTablePane);

		// table for employee user management.
		employeeTable = new JTable();
		employeeTable.setAutoCreateRowSorter(true);
		employeeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		employeeTable.setSurrendersFocusOnKeystroke(true);
		employeeTable.setCellSelectionEnabled(true);
		employeeTable.setColumnSelectionAllowed(true);
		employeeTable.setBounds(145, 264, 823, 105);
		employeeTable.setEnabled(false);
		employeeTable.setModel(new DefaultTableModel(empData, empHeaders));
		employeeTablePane.setViewportView(employeeTable);

		// edit existing employees
		editEmp = new JButton("Edit Employee");
		editEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickedEdit = true;
				empSubmit.setEnabled(false);
				SetEmpVisiblity(true);
				SetEmpEditVisibility(true);
				disableEmpButtons(false);
			}
		});
		editEmp.setBounds(957, 37, 160, 21);
		employeePane.add(editEmp);

		// add new employees (these will only exist while program is open).
		addNewEmp = new JButton("Add New Employee");
		addNewEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empSubmit.setEnabled(false);
				disableEmpButtons(false);
				SetEmpVisiblity(true);
			}
		});
		addNewEmp.setBounds(957, 74, 160, 21);
		employeePane.add(addNewEmp);

		// dropdown list of employees after clicking edit button (made more sense when
		// only working with a handful of employees, added a lot more after everything
		// was working)
		empList = new JComboBox<String>();
		empList.setBounds(29, 296, 135, 21);
		empList.setVisible(false);
		empList.addItem(null);
		empList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent b) {
				if (empList.getSelectedIndex() <= 0) {
					clearEmpFields();
				} else {
					Object[] employee = empData[empList.getSelectedIndex() - 1];
					int index = (empList.getSelectedIndex() - 1);
					editEmpFields(employee, index);
				}
			}
		});
		employeePane.add(empList);

		// labels above fields
		empSelector = new JLabel("Select Employee");
		empSelector.setBounds(29, 276, 135, 13);
		empSelector.setVisible(false);
		employeePane.add(empSelector);

		empFirstNameLabel = new JLabel("First Name");
		empFirstNameLabel.setBounds(29, 327, 135, 13);
		empFirstNameLabel.setVisible(false);
		employeePane.add(empFirstNameLabel);

		empLastNameLabel = new JLabel("Last Name");
		empLastNameLabel.setBounds(182, 327, 135, 13);
		empLastNameLabel.setVisible(false);
		employeePane.add(empLastNameLabel);

		empPayRateLabel = new JLabel("Pay Rate");
		empPayRateLabel.setBounds(334, 327, 135, 13);
		empPayRateLabel.setVisible(false);
		employeePane.add(empPayRateLabel);

		empTitleLable = new JLabel("Title");
		empTitleLable.setBounds(487, 327, 135, 13);
		empTitleLable.setVisible(false);
		employeePane.add(empTitleLable);

		empStatusLabel = new JLabel("Employment Status");
		empStatusLabel.setBounds(641, 327, 135, 13);
		empStatusLabel.setVisible(false);
		employeePane.add(empStatusLabel);

		empHoursWorkedLabel = new JLabel("Hours Worked");
		empHoursWorkedLabel.setBounds(796, 327, 135, 13);
		empHoursWorkedLabel.setVisible(false);
		employeePane.add(empHoursWorkedLabel);

		// fields
		// lots of listening here... wanted to ensure each field had text before
		// enabling save...
		empFirstName = new JTextField();
		empFirstName.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				empSubmit.setEnabled((!empFirstName.getText().isBlank() && !empLastName.getText().isBlank() && !empPayRate.getText().isBlank()
						&& !empTitle.getText().isBlank() && !empEmploymentStatus.getText().isBlank() && !empHoursWorked.getText().isBlank()));
			}
		});
		empFirstName.setBounds(29, 344, 135, 19);
		empFirstName.setColumns(10);
		empFirstName.setVisible(false);
		employeePane.add(empFirstName);

		empLastName = new JTextField();
		empLastName.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				empSubmit.setEnabled((!empFirstName.getText().isBlank() && !empLastName.getText().isBlank() && !empPayRate.getText().isBlank()
						&& !empTitle.getText().isBlank() && !empEmploymentStatus.getText().isBlank() && !empHoursWorked.getText().isBlank()));
			}
		});
		empLastName.setColumns(10);
		empLastName.setBounds(182, 344, 135, 19);
		empLastName.setVisible(false);
		employeePane.add(empLastName);

		empPayRate = new JTextField();
		empPayRate.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				empSubmit.setEnabled((!empFirstName.getText().isBlank() && !empLastName.getText().isBlank() && !empPayRate.getText().isBlank()
						&& !empTitle.getText().isBlank() && !empEmploymentStatus.getText().isBlank() && !empHoursWorked.getText().isBlank()));
			}
		});
		empPayRate.setColumns(10);
		empPayRate.setBounds(334, 344, 135, 19);
		empPayRate.setVisible(false);
		employeePane.add(empPayRate);

		empTitle = new JTextField();
		empTitle.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				empSubmit.setEnabled((!empFirstName.getText().isBlank() && !empLastName.getText().isBlank() && !empPayRate.getText().isBlank()
						&& !empTitle.getText().isBlank() && !empEmploymentStatus.getText().isBlank() && !empHoursWorked.getText().isBlank()));
			}
		});
		empTitle.setColumns(10);
		empTitle.setBounds(487, 344, 135, 19);
		empTitle.setVisible(false);
		employeePane.add(empTitle);

		empEmploymentStatus = new JTextField();
		empEmploymentStatus.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				empSubmit.setEnabled((!empFirstName.getText().isBlank() && !empLastName.getText().isBlank() && !empPayRate.getText().isBlank()
						&& !empTitle.getText().isBlank() && !empEmploymentStatus.getText().isBlank() && !empHoursWorked.getText().isBlank()));
			}
		});
		empEmploymentStatus.setColumns(10);
		empEmploymentStatus.setBounds(641, 344, 135, 19);
		empEmploymentStatus.setVisible(false);
		employeePane.add(empEmploymentStatus);

		empHoursWorked = new JTextField();
		empHoursWorked.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				empSubmit.setEnabled((!empFirstName.getText().isBlank() && !empLastName.getText().isBlank() && !empPayRate.getText().isBlank()
						&& !empTitle.getText().isBlank() && !empEmploymentStatus.getText().isBlank() && !empHoursWorked.getText().isBlank()));
			}
		});
		empHoursWorked.setColumns(10);
		empHoursWorked.setBounds(795, 344, 135, 19);
		empHoursWorked.setVisible(false);
		employeePane.add(empHoursWorked);

		// submit button, handles updating existing employee or adding new employee.
		empSubmit = new JButton("Submit");
		empSubmit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (clickedEdit == true) {
					empData[empDataIndex][0] = empFirstName.getText();
					empData[empDataIndex][1] = empLastName.getText();
					empData[empDataIndex][2] = empPayRate.getText();
					empData[empDataIndex][3] = empTitle.getText();
					empData[empDataIndex][4] = empEmploymentStatus.getText();
					empData[empDataIndex][5] = empHoursWorked.getText();
					employeeTable.setModel(new DefaultTableModel(empData, empHeaders));
					SetEmpVisiblity(false);
					SetEmpEditVisibility(false);
					disableEmpButtons(true);
					clearEmpFields();
					clickedEdit = false;
				} else {
					int firstNullRow = -1;
					for (int i = 0; i < empData.length; i++) {
						if (empData[i][0] == null && empData[i][1] == null) {
							firstNullRow = i;
							break;
						}
					}
					empData[firstNullRow][0] = empFirstName.getText();
					empData[firstNullRow][1] = empLastName.getText();
					empData[firstNullRow][2] = empPayRate.getText();
					empData[firstNullRow][3] = empTitle.getText();
					empData[firstNullRow][4] = empEmploymentStatus.getText();
					empData[firstNullRow][5] = empHoursWorked.getText();
					employeeTable.setModel(new DefaultTableModel(empData, empHeaders));
					SetEmpVisiblity(false);
					SetEmpEditVisibility(false);
					disableEmpButtons(true);
					clearEmpFields();
				}
				empListMaker();
			}
		});
		empSubmit.setBounds(957, 343, 160, 21);
		empSubmit.setVisible(false);
		empSubmit.setEnabled(false);
		employeePane.add(empSubmit);

		// cancel clears all fields and resets pane.
		empCancel = new JButton("Cancel");
		empCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearEmpFields();
				SetEmpVisiblity(false);
				SetEmpEditVisibility(false);
				disableEmpButtons(true);
				clickedEdit = false;
			}
		});
		empCancel.setBounds(957, 374, 160, 21);
		empCancel.setVisible(false);
		employeePane.add(empCancel);

		//
		// Payroll Tab - GUI
		//
		JPanel payrollPane = new JPanel();
		payrollAppPane.addTab("Payroll", payrollPane);
		payrollAppPane.setEnabledAt(1, true);
		payrollAppPane.setSelectedIndex(1);
		payrollPane.setLayout(null);

		// list of employees from employee mgmt page (and an "all employees" option).
		payrollEmpList = new JComboBox<String>();
		payrollEmpList.setToolTipText("Please make a selection");
		payrollEmpList.setBounds(27, 26, 135, 21);
		payrollEmpList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// not enabling run payroll report if selection is blank.
				if (payrollEmpList.getSelectedIndex() >= 1) {
					payrollRun.setEnabled(true);
				} else {
					// do something.... (oops, I never got back to doing something here.)
				}
			}
		});
		payrollPane.add(payrollEmpList);

		// labels
		payrollSelectEmp = new JLabel("Select Employee");
		payrollSelectEmp.setBounds(27, 10, 135, 13);
		payrollPane.add(payrollSelectEmp);

		payrollOutputKey = new JLabel();
		payrollOutputKey.setVisible(false);
		payrollOutputKey.setBounds(921, 80, 218, 242);
		payrollPane.add(payrollOutputKey);

		// run payroll button, where most of the magic happens.
		payrollRun = new JButton("Run Payroll");
		payrollRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// clear error label from previous run
				payrollErrorLbl.setVisible(false);
				// since the list has a blank at 0, and all employees at 1,
				// we minus 2 from index
				int index = payrollEmpList.getSelectedIndex() - 2;
				// if all employees was selected (index 1 minus 2 == -1)
				if (index == -1) {
					// left some null indexes so people to add employees
					// without resizing the object array...
					// so we must handle removing those for what is about to happen.
					int lastNonNull = empData.length;
					for (int trim = 0; trim < empData.length; trim++) {
						if (empData[trim][0] == null) {
							lastNonNull--;
						}
					}
					// now that are nulls are gone.. we can set the new array to the
					// "trimmed" length of the original
					Object[][] selectedEmpData = new Object[lastNonNull][empData[0].length];
					// start looping through and adding employees.
					for (int newIndex = 0; newIndex < lastNonNull; newIndex++) {
						selectedEmpData[newIndex] = empData[newIndex];
					}
					// call method for running the payroll maths with all employees.
					payrollEmpSelected(selectedEmpData);
					// if index is 0 or great, individual employee was selected, so extract
					// single employee data to new array
				} else if (index >= 0) {
					Object[][] selectedEmpData = new Object[1][empData[0].length];
					selectedEmpData[0][0] = empData[index][0];
					selectedEmpData[0][1] = empData[index][1];
					selectedEmpData[0][2] = empData[index][2];
					selectedEmpData[0][3] = empData[index][3];
					selectedEmpData[0][4] = empData[index][4];
					selectedEmpData[0][5] = empData[index][5];
					// call method for running payroll maths with single employee
					payrollEmpSelected(selectedEmpData);
				} else {
					// throw error (another oops... never got back here...)
				}

			}
		});
		payrollRun.setBounds(183, 26, 147, 21);
		payrollRun.setEnabled(false);
		payrollPane.add(payrollRun);

		// pane for to make table display-able.
		payrollOutputPane = new JScrollPane();
		payrollOutputPane.setVisible(false);
		payrollOutputPane.setBounds(27, 80, 887, 305);
		payrollPane.add(payrollOutputPane);

		// the report table
		payrollOutput = new JTable();
		payrollOutput.setAutoCreateRowSorter(true);
		payrollOutput.setVisible(false);
		payrollOutput.setEnabled(false);
		payrollOutputPane.setViewportView(payrollOutput);

		// error label that gets called if employees worked over 60 hours.
		payrollErrorLbl = new JLabel();
		payrollErrorLbl.setHorizontalAlignment(SwingConstants.CENTER);
		payrollErrorLbl.setForeground(new Color(255, 0, 0));
		payrollErrorLbl.setBounds(27, 57, 887, 13);
		payrollErrorLbl.setVisible(false);
		payrollPane.add(payrollErrorLbl);

		//
		// Settings Tab - GUI
		//
		JPanel settingsPane = new JPanel();
		payrollAppPane.addTab("Settings", settingsPane);
		payrollAppPane.setEnabledAt(2, true);
		settingsPane.setLayout(null);

		// labels
		taxRateLbl = new JLabel("Tax Rate (%)");
		taxRateLbl.setBounds(391, 139, 110, 13);
		settingsPane.add(taxRateLbl);

		overTimeRateLbl = new JLabel("Overtime Rate");
		overTimeRateLbl.setBounds(391, 257, 110, 13);
		settingsPane.add(overTimeRateLbl);

		regularHourCapLbl = new JLabel("Regular Hour Max");
		regularHourCapLbl.setBounds(391, 200, 110, 13);
		settingsPane.add(regularHourCapLbl);

		maxHoursLbl = new JLabel("Max Weekly Hours");
		maxHoursLbl.setBounds(391, 318, 110, 13);
		settingsPane.add(maxHoursLbl);

		// fields
		taxRateField = new JTextField();
		taxRateField.setHorizontalAlignment(SwingConstants.CENTER);
		taxRateField.setEditable(false);
		taxRateField.setBounds(391, 155, 110, 19);
		taxRateField.setColumns(10);
		taxRateField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				saveSettingBtn.setEnabled(true);
			}
		});
		settingsPane.add(taxRateField);

		regHourCapField = new JTextField();
		regHourCapField.setHorizontalAlignment(SwingConstants.CENTER);
		regHourCapField.setEditable(false);
		regHourCapField.setBounds(391, 216, 110, 19);
		regHourCapField.setColumns(10);
		regHourCapField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				saveSettingBtn.setEnabled(true);
			}
		});
		settingsPane.add(regHourCapField);

		overTimeRateField = new JTextField();
		overTimeRateField.setHorizontalAlignment(SwingConstants.CENTER);
		overTimeRateField.setEditable(false);
		overTimeRateField.setBounds(391, 273, 110, 19);
		overTimeRateField.setColumns(10);
		overTimeRateField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				saveSettingBtn.setEnabled(true);
			}
		});
		settingsPane.add(overTimeRateField);

		maxHoursField = new JTextField();
		maxHoursField.setHorizontalAlignment(SwingConstants.CENTER);
		maxHoursField.setEditable(false);
		maxHoursField.setBounds(391, 331, 110, 19);
		maxHoursField.setColumns(10);
		maxHoursField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				saveSettingBtn.setEnabled(true);
			}
		});
		settingsPane.add(maxHoursField);

		// buttons
		editSettingBtn = new JButton("Edit");
		editSettingBtn.setBounds(672, 186, 110, 21);
		editSettingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editSettingsVisibility(true);
				editSettingsEditability(true);
				editSettingBtn.setEnabled(false);
			}
		});
		settingsPane.add(editSettingBtn);

		cancelSettingBtn = new JButton("Cancel");
		cancelSettingBtn.setBounds(672, 155, 110, 21);
		cancelSettingBtn.setVisible(false);
		cancelSettingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editSettingBtn.setEnabled(true);
				editSettingsVisibility(false);
				editSettingsEditability(false);
				defaultSettings();
			}
		});
		settingsPane.add(cancelSettingBtn);

		// note, if you change these from apps defaut settings,
		// they will be used when payroll report is run
		saveSettingBtn = new JButton("Save");
		saveSettingBtn.setBounds(672, 216, 110, 21);
		saveSettingBtn.setVisible(false);
		saveSettingBtn.setEnabled(false);
		saveSettingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				settingsValues[0] = taxRateField.getText();
				settingsValues[1] = regHourCapField.getText();
				settingsValues[2] = overTimeRateField.getText();
				settingsValues[3] = maxHoursField.getText();
				editSettingBtn.setEnabled(true);
				editSettingsVisibility(false);
				editSettingsEditability(false);
			}
		});
		settingsPane.add(saveSettingBtn);

		//
		// Admin Tab - GUI
		//
		JPanel adminPane = new JPanel();
		payrollAppPane.addTab("Admin", adminPane);
		payrollAppPane.setEnabledAt(3, enableAdminPage);
		adminPane.setLayout(null);

		// admin users from login page
		adminUserList = new JList<String>();
		adminUserList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		adminUserList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		adminUserList.setBounds(56, 110, 173, 229);
		adminUserList.setListData(usernames);
		adminUserList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedUser(adminUserList.getSelectedValue(), isLockedOut[adminUserList.getSelectedIndex()],
						isAdmin[adminUserList.getSelectedIndex()]);

			}
		});
		adminPane.add(adminUserList);

		// labels
		adminUserLbl = new JLabel("Users");
		adminUserLbl.setBounds(56, 90, 45, 13);
		adminPane.add(adminUserLbl);

		JLabel adminUsernameLbl = new JLabel("Username");
		adminUsernameLbl.setBounds(275, 186, 92, 13);
		adminPane.add(adminUsernameLbl);

		// fields
		adminUsernameField = new JTextField();
		adminUsernameField.setEnabled(false);
		adminUsernameField.setBounds(274, 201, 96, 19);
		adminUsernameField.setColumns(10);
		adminPane.add(adminUsernameField);

		adminIsAdminChck = new JCheckBox("Is Admin ?");
		adminIsAdminChck.setEnabled(false);
		adminIsAdminChck.setBounds(274, 276, 110, 21);
		adminIsAdminChck.setSelected(false);
		adminIsAdminChck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminSaveStatus(true);
			}
		});
		adminPane.add(adminIsAdminChck);

		adminLockedOutChck = new JCheckBox("Locked Out ?");
		adminLockedOutChck.setEnabled(false);
		adminLockedOutChck.setBounds(274, 239, 110, 21);
		adminLockedOutChck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminSaveStatus(true);
			}
		});
		adminPane.add(adminLockedOutChck);
		// buttons (these really don't do much, just give illusion of doing
		// something...)
		adminSaveBtn = new JButton("Save");
		adminSaveBtn.setEnabled(false);
		adminSaveBtn.setBounds(411, 200, 110, 21);
		adminSaveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dialogMessageStr = adminUserList.getSelectedValue() + " Updated!";
				JOptionPane.showMessageDialog(payrollApp, dialogMessageStr, "Success", JOptionPane.INFORMATION_MESSAGE);
				adminPanelReset();
			}
		});
		adminPane.add(adminSaveBtn);

		adminCancelBtn = new JButton("Cancel");
		adminCancelBtn.setEnabled(false);
		adminCancelBtn.setBounds(411, 239, 110, 21);
		adminCancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminPanelReset();
			}
		});
		adminPane.add(adminCancelBtn);

		adminResetPwBtn = new JButton("Reset Password");
		adminResetPwBtn.setEnabled(false);
		adminResetPwBtn.setBounds(411, 276, 110, 21);
		adminResetPwBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dialogMessageStr = adminUserList.getSelectedValue() + "'s Password has been reset!";
				JOptionPane.showMessageDialog(payrollApp, dialogMessageStr, "Success", JOptionPane.INFORMATION_MESSAGE);
				adminPanelReset();
			}
		});
		adminPane.add(adminResetPwBtn);

	}

	//
	// Employee Mgmt Tab - Methods
	//
	private void SetEmpEditVisibility(boolean viz) {
		empList.setVisible(viz);
		empSelector.setVisible(viz);
	}

	private void SetEmpVisiblity(boolean viz) {
		empFirstName.setVisible(viz);
		empLastName.setVisible(viz);
		empPayRate.setVisible(viz);
		empTitle.setVisible(viz);
		empEmploymentStatus.setVisible(viz);
		empHoursWorked.setVisible(viz);
		empFirstNameLabel.setVisible(viz);
		empLastNameLabel.setVisible(viz);
		empPayRateLabel.setVisible(viz);
		empTitleLable.setVisible(viz);
		empStatusLabel.setVisible(viz);
		empHoursWorkedLabel.setVisible(viz);
		empSubmit.setVisible(viz);
		empCancel.setVisible(viz);
	}

	private void editEmpFields(Object[] employee, int index) {
		empFirstName.setText(employee[0].toString());
		empLastName.setText(employee[1].toString());
		empPayRate.setText(employee[2].toString());
		empTitle.setText(employee[3].toString());
		empEmploymentStatus.setText(employee[4].toString());
		empHoursWorked.setText(employee[5].toString());
		empDataIndex = index;
	}

	private void clearEmpFields() {
		empFirstName.setText(null);
		empLastName.setText(null);
		empPayRate.setText(null);
		empTitle.setText(null);
		empEmploymentStatus.setText(null);
		empHoursWorked.setText(null);
	}

	private void disableEmpButtons(boolean viz) {
		editEmp.setEnabled(viz);
		addNewEmp.setEnabled(viz);
	}

	//
	// Payroll Tab - Methods
	//
	// here is all the sauce for the rest of the payroll calculation.
	private void payrollEmpSelected(Object[][] selectedEmpData) {
		// create some placeholders
		Object[][] payrollSelectedEmp = new Object[selectedEmpData.length][9];
		double hoursWorked = 0;
		double overtimeHoursWorked = 0;
		Double maxWeeklyHours = Double.parseDouble(settingsValues[3]);
		Double overtimeRate = Double.parseDouble(settingsValues[2]);
		Double regHoursCap = Double.parseDouble(settingsValues[1]);
		Double taxRate = (Double.parseDouble(settingsValues[0]) / 100);
		// for looping through incoming arrays
		for (int employee = 0; employee < selectedEmpData.length; employee++) {
			hoursWorked = Double.parseDouble(selectedEmpData[employee][5].toString());
			// ^ set out hours worked var, v confirm employee is not null (never removed
			// that...), and they haven't worked more than
			// "60" hours/maxWeeklyHours (or whatever someone may have set it to...
			if (selectedEmpData[employee][0] != null && hoursWorked <= maxWeeklyHours) {
				// now we have employees who worked "60"/maxWeeklyHours hours or less
				// breaking out the employees who worked over "40"/ hours.
				if (hoursWorked > regHoursCap) {
					hoursWorked = regHoursCap;
					// maths for getting values to 2 decimals and for building the output data of
					// the report.
					overtimeHoursWorked = Math.round(
							(Double.parseDouble(selectedEmpData[employee][5].toString()) - Double.parseDouble(settingsValues[1])) * 100.0) / 100.0;
					String employeeName = selectedEmpData[employee][0].toString() + " " + selectedEmpData[employee][1].toString();
					Double payRate = Double.parseDouble(selectedEmpData[employee][2].toString());
					Double overtimePayRate = Math.round((payRate * overtimeRate) * 100.0) / 100.0;
					Double grossPay = Math.round(((hoursWorked * payRate) + (overtimeHoursWorked * overtimePayRate)) * 100.0) / 100.0;
					Double taxes = Math.round((grossPay * taxRate) * 100.0) / 100.0;
					Double netPay = Math.round((grossPay - taxes) * 100.0) / 100.0;
					Double totalHoursWorked = Double.parseDouble(selectedEmpData[employee][5].toString());
					// build array with overtime employee
					payrollSelectedEmp[employee][0] = employeeName;
					payrollSelectedEmp[employee][1] = hoursWorked;
					payrollSelectedEmp[employee][2] = payRate;
					payrollSelectedEmp[employee][3] = overtimeHoursWorked;
					payrollSelectedEmp[employee][4] = overtimePayRate;
					payrollSelectedEmp[employee][5] = totalHoursWorked;
					payrollSelectedEmp[employee][6] = grossPay;
					payrollSelectedEmp[employee][7] = taxes;
					payrollSelectedEmp[employee][8] = netPay;
				} else {
					// non-overtime employees have a bit less maths.
					hoursWorked = Double.parseDouble(selectedEmpData[employee][5].toString());
					String employeeName = selectedEmpData[employee][0].toString() + " " + selectedEmpData[employee][1].toString();
					Double payRate = Double.parseDouble(selectedEmpData[employee][2].toString());
					Double grossPay = Math.round(((hoursWorked * payRate) + (0 * 0)) * 100.0) / 100.0;
					Double taxes = Math.round((grossPay * taxRate) * 100.0) / 100.0;
					Double netPay = Math.round((grossPay - taxes) * 100.0) / 100.0;
					Double totalHoursWorked = Double.parseDouble(selectedEmpData[employee][5].toString());
					// build array with non-overtime employee
					payrollSelectedEmp[employee][0] = employeeName;
					payrollSelectedEmp[employee][1] = hoursWorked;
					payrollSelectedEmp[employee][2] = payRate;
					payrollSelectedEmp[employee][3] = 0;
					payrollSelectedEmp[employee][4] = 0;
					payrollSelectedEmp[employee][5] = totalHoursWorked;
					payrollSelectedEmp[employee][6] = grossPay;
					payrollSelectedEmp[employee][7] = taxes;
					payrollSelectedEmp[employee][8] = netPay;
				}
			} else {
				// employees who worked over 60/
				String employeeName = selectedEmpData[employee][0].toString() + " " + selectedEmpData[employee][1].toString();
				Double totalHoursWorked = Double.parseDouble(selectedEmpData[employee][5].toString());
				String error = "ERROR";
				payrollSelectedEmp[employee][0] = employeeName;
				payrollSelectedEmp[employee][1] = selectedEmpData[employee][5];
				payrollSelectedEmp[employee][1] = selectedEmpData[employee][2];
				payrollSelectedEmp[employee][3] = error;
				payrollSelectedEmp[employee][4] = error;
				payrollSelectedEmp[employee][5] = totalHoursWorked;
				payrollSelectedEmp[employee][6] = error;
				payrollSelectedEmp[employee][7] = error;
				payrollSelectedEmp[employee][8] = error;
				// throw error above report and make it visible.
				payrollErrorLbl.setText(" !! Warning: Payroll Report Finished with Errors !! ");
				payrollErrorLbl.setVisible(true);

			}
		}

		// report headers and key
		String[] payrollHeaders = { "Employee Name", "HWR", "PRR", "HWOT", "PROT", "HWT", "GP", "ID", "NP" };
		String payrollOutputKeyStr = "<html>Key: <br>" + "HWR - Hours Worked, Reg<br>" + "PRR - Pay Rate, Reg<br>" + "HWOT - Hours Worked, O.T<br>"
				+ "PROT - Pay Rate, O.T<br>" + "HWT - Hours Worked, Total<br>" + "GP - Gross Pay<br>"
				+ "ID - Itemized Deductions (inc Federal, Medicare, FICA)<br>" + "NP - Net Pay</html>";

		// report data and headers set.
		payrollOutput.setModel(new DefaultTableModel(payrollSelectedEmp, payrollHeaders));
		// key set
		payrollOutputKey.setText(payrollOutputKeyStr);
		// display it all to screen
		payrollOutputPane.setVisible(true);
		payrollOutput.setVisible(true);
		payrollOutputKey.setVisible(true);
	}

	//
	// Settings Tab - Methods
	//
	private void defaultSettings() {
		taxRateField.setText(settingsValues[0]);
		regHourCapField.setText(settingsValues[1]);
		overTimeRateField.setText(settingsValues[2]);
		maxHoursField.setText(settingsValues[3]);
	}

	private void editSettingsVisibility(boolean viz) {
		cancelSettingBtn.setVisible(viz);
		saveSettingBtn.setVisible(viz);
	}

	private void editSettingsEditability(boolean viz) {
		taxRateField.setEditable(viz);
		regHourCapField.setEditable(viz);
		overTimeRateField.setEditable(viz);
		maxHoursField.setEditable(viz);
	}

	//
	// Admin Tab - Methods
	//
	private void selectedUser(String selectedUsername, Boolean isLockedOut, Boolean isAdmin) {
		adminUsernameField.setText(selectedUsername);
		adminLockedOutChck.setEnabled(true);
		adminLockedOutChck.setSelected(isLockedOut);
		adminIsAdminChck.setEnabled(true);
		adminIsAdminChck.setSelected(isAdmin);
		adminCancelBtn.setEnabled(true);
		adminResetPwBtn.setEnabled(true);
	}

	private void adminSaveStatus(boolean status) {
		adminSaveBtn.setEnabled(status);
	}

	private void adminPanelReset() {
		adminUsernameField.setText(null);
		adminLockedOutChck.setEnabled(false);
		adminLockedOutChck.setSelected(false);
		adminIsAdminChck.setEnabled(false);
		adminIsAdminChck.setSelected(false);
		adminCancelBtn.setEnabled(false);
		adminResetPwBtn.setEnabled(false);
		adminSaveStatus(false);
	}

	//
	// Shared Methods
	//
	// reused method for creating employee dropdown menus (JComboBoxes
	private void empListMaker() {
		String[] employees = new String[empData.length];
		String[] empShortList = null;
		// start extracting non-null records from array (oversized initial array so we
		// don't have to resize it.
		for (int index = 0; index < empData.length; index++) {
			if (empData[index][0] != null || empData[index][1] != null) {
				employees[index] = empData[index][0].toString() + " " + empData[index][1].toString();
			} else {
				break;
			}
		}
		// find the end the main array (might grow if users get added)
		int lastNonNull = empData.length;
		for (int trim = 0; trim < employees.length; trim++) {
			if (employees[trim] == null) {
				lastNonNull--;
			}
		}
		// ^ now we know the true length.
		// v lets start populating the lists.
		empShortList = Arrays.copyOf(employees, lastNonNull);
		// since lists have already been populated, we clear them
		empList.removeAllItems();
		payrollEmpList.removeAllItems();
		// add our blank placeholder at 0, and all employees at 1 (for payroll)
		empList.addItem(null);
		payrollEmpList.addItem(null);
		payrollEmpList.addItem("All Employees");
		// re-populate lists
		for (String emp : empShortList) {
			empList.addItem(emp);
			payrollEmpList.addItem(emp);
		}
	}
}
