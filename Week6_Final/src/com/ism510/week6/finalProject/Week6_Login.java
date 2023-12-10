package com.ism510.week6.finalProject;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Week6_Login {

	// variables
	public static String[] usernames = { "Admin", "Vale.Vicky", "Lane.Lois", "Kent.Clark", "Wayne.Bruce", "Parker.Peter", "Rogers.Steve",
			"Luther.Lex", "Osborn.Harry", "Prince.Diana", "Linda.Zoel" };
	public String[] passwords = { "Password1", "NwiKFnBUIo", "swShkBOGev", "dCzNjcTvSn", "uLqsQzygsJ", "YSGfWKKegc", "IkpZUeqkHB", "YoTCIbJSno",
			"EANExtpdKf", "gvYdfamUYQ", "UgNDEOeUos" };
	public Boolean[] lockedOut = { false, false, false, false, false, true, false, true, false, true, false };
	public int[] failCount = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	public Boolean[] isAdmin = { true, true, false, false, false, false, false, true, false, false, false };
	public String[] currentUser = new String[3];

	// classes
	private JFrame frmLogin;
	private JTextField usernameField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Week6_Login window = new Week6_Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Week6_Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmLogin = new JFrame();
		frmLogin.setBackground(Color.BLACK);
		frmLogin.setForeground(Color.BLACK);
		frmLogin.getContentPane().setBackground(Color.DARK_GRAY);
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 421, 282);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);

		usernameField = new JTextField();
		usernameField.setHorizontalAlignment(SwingConstants.CENTER);
		usernameField.setBackground(Color.GRAY);
		usernameField.setToolTipText("Enter Your Username");
		usernameField.setBounds(124, 82, 230, 19);
		usernameField.setColumns(10);
		frmLogin.getContentPane().add(usernameField);

		passwordField = new JPasswordField();
		passwordField.setEnabled(false);
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setToolTipText("Enter Your Password");
		passwordField.setBackground(Color.GRAY);
		passwordField.setBounds(124, 111, 230, 19);
		frmLogin.getContentPane().add(passwordField);

		JLabel lblInstructions = new JLabel("Please enter your login credentials:");
		lblInstructions.setForeground(Color.LIGHT_GRAY);
		lblInstructions.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblInstructions.setBounds(38, 31, 316, 13);
		frmLogin.getContentPane().add(lblInstructions);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(Color.LIGHT_GRAY);
		lblUsername.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblUsername.setBounds(38, 85, 91, 16);
		frmLogin.getContentPane().add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.LIGHT_GRAY);
		lblPassword.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblPassword.setBounds(38, 113, 91, 16);
		frmLogin.getContentPane().add(lblPassword);

		JButton submitButton = new JButton("Submit");
		submitButton.setEnabled(false);
		submitButton.setForeground(Color.LIGHT_GRAY);
		submitButton.setBackground(Color.DARK_GRAY);
		submitButton.setFont(new Font("Consolas", Font.PLAIN, 14));
		submitButton.setBounds(157, 170, 85, 25);
		frmLogin.getContentPane().add(submitButton);

		// key listener for enabling the password field while username field is blank.
		usernameField.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				passwordField.setEnabled(usernameField.getText().length() >= 0);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		// key listener for enabling the submit button while password field is blank.
		passwordField.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				submitButton.setEnabled(passwordField.getPassword().length >= 0);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		// action lister on submit button
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent Clicked) {
				// setup some variables
				char[] userPass = passwordField.getPassword();
				String userPassStr = String.valueOf(userPass);
				String userName = usernameField.getText();
				int doNotShowMsg = 0;
				// left over from previous work, but if you type close/Close/Close as username
				// (with a character in the pw field, app will close).
				if (userName.toLowerCase().equals("close")) {
					System.exit(0);
				} else {
					// for loop through username array
					for (int index = 0; index < usernames.length; index++) {
						// validate username and password at "index" match what user submitted & check
						// if user is locked out
						if (userName.equalsIgnoreCase(usernames[index]) && userPassStr.equals(passwords[index]) && lockedOut[index] == false) {
							// setup currentUser array if conditions above are met.
							currentUser[0] = usernames[index];
							currentUser[1] = isAdmin[index].toString();
							currentUser[2] = Instant.now().truncatedTo(ChronoUnit.SECONDS).toString();
							// show success message
							JOptionPane.showMessageDialog(frmLogin, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
							// after user hits "ok" launch app and pass some arrays.
							Week6_App prApp = new Week6_App(usernames, lockedOut, isAdmin, currentUser);
							prApp.payrollApp.setVisible(true);
							// flag to not show wrong credential error
							doNotShowMsg = 1;
							// close login frame.
							frmLogin.dispose();
							break;
							// hand locked out users.
						} else if (userName.equalsIgnoreCase(usernames[index]) && lockedOut[index] == true) {
							JOptionPane.showMessageDialog(frmLogin, "User is locked. Please contact the Helpdesk", "Error",
									JOptionPane.ERROR_MESSAGE);
							doNotShowMsg = 1;
							break;
							// handle locking out users due to too many bad password attempts.
						} else if (userName.equalsIgnoreCase(usernames[index]) && !userPassStr.equals(passwords[index])) {
							failCount[index]++;
							if (failCount[index] > 4) {
								lockedOut[index] = true;
								JOptionPane.showMessageDialog(frmLogin,
										"Too Many Incorrect Attepmts, User is now locked. Please contact the Helpdesk", "Error",
										JOptionPane.ERROR_MESSAGE);
								doNotShowMsg = 1;
							}
							break;
						}
					}
					// throw this error if username isn't here, until user is locked.
					if (doNotShowMsg < 1) {
						JOptionPane.showMessageDialog(frmLogin, "Please check the provided credentials", "Error", JOptionPane.ERROR_MESSAGE);
					}

				}
			}
		});
	}

};
