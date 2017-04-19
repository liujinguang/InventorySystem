package com.jliu.internalFrame.supplier;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SupplierModifyPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public SupplierModifyPanel() {
		setBorder(new EmptyBorder(5, 5, 5, 5));

	}
	
	/**
	 * Launch the application./
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame("Test");
					frame.setContentPane(new SupplierAddPanel());
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setBounds(100, 100, 450, 300);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JTextField nameField;
	private JTextField abbrField;
	private JTextField zipcodeField;
	private JLabel addressLabel;
	private JTextField textField;
	private JLabel telLabel;
	private JTextField telField;
	private JLabel faxLabel;
	private JTextField faxField;
	private JLabel bankLabel;
	private JTextField bankField;
	private JLabel accountLabel;
	private JTextField accountField;
	private JLabel contactorLabel;
	private JTextField contactorField;
	private JLabel contactorTelLabel;
	private JTextField contactorTelField;
	private JLabel emailLabel;
	private JButton addButton;
	private JButton resetButton;
}
