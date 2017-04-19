package com.jliu.login;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame {
	private JButton loginButton;
	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField passwdTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("登录企业进销存管理系统");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new LoginPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel nameLabel = new JLabel("用户名");
		nameLabel.setBounds(80, 150, 60, 20);
		contentPane.add(nameLabel);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(165, 150, 180, 20);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		JLabel passwdLabel = new JLabel("密    码");
		passwdLabel.setBounds(80, 185, 60, 20);
		contentPane.add(passwdLabel);
		
		passwdTextField = new JTextField();
		passwdTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					loginButton.doClick();
	}
			}
		});
		passwdTextField.setBounds(165, 185, 180, 20);
		contentPane.add(passwdTextField);
		passwdTextField.setColumns(10);
		
		loginButton = new JButton("登  录");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		loginButton.setBounds(120, 225, 80, 20);
		contentPane.add(loginButton);
		
		JButton button = new JButton("退  出");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button.setBounds(280, 225, 80, 20);
		contentPane.add(button);
	}
}
