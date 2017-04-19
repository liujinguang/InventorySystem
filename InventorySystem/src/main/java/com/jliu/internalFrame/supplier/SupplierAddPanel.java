package com.jliu.internalFrame.supplier;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.jliu.internalFrame.GBC;

public class SupplierAddPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public SupplierAddPanel() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new GridBagLayout());

		JLabel nameLabel = new JLabel("全称");
		setupComponet(nameLabel, 0, 0, 1, 1, false);

		nameField = new JTextField();
		setupComponet(nameField, 1, 0, 3, 350, true);

		JLabel addressLabel = new JLabel("地址");
		setupComponet(addressLabel, 0, 1, 1, 1, false);

		addressField = new JTextField();
		setupComponet(addressField, 1, 1, 3, 350, true);

		JLabel zipcodeLabel = new JLabel("邮政编码");
		setupComponet(zipcodeLabel, 0, 2, 1, 1, false);

		zipcodeField = new JTextField();
		setupComponet(zipcodeField, 1, 2, 1, 160, true);

		JLabel telLabel = new JLabel("电话");
		setupComponet(telLabel, 2, 2, 1, 1, false);

		telField = new JTextField();
		setupComponet(telField, 3, 2, 1, 160, true);

		JLabel faxLabel = new JLabel("传真");
		setupComponet(faxLabel, 0, 3, 1, 1, false);

		faxField = new JTextField();
		setupComponet(faxField, 1, 3, 1, 160, true);

		JLabel bankLabel = new JLabel("开户行");
		setupComponet(bankLabel, 2, 3, 1, 1, false);

		bankField = new JTextField();
		setupComponet(bankField, 3, 3, 1, 160, true);

		JLabel accountLabel = new JLabel("银行账户");
		setupComponet(accountLabel, 0, 4, 1, 1, false);

		accountField = new JTextField();
		setupComponet(accountField, 1, 4, 1, 160, true);

		JLabel contactorLabel = new JLabel("联系人");
		setupComponet(contactorLabel, 2, 4, 1, 1, false);

		contactorField = new JTextField();
		setupComponet(contactorField, 3, 4, 1, 160, true);

		JLabel contactorTelLabel = new JLabel("联系人电话");
		setupComponet(contactorTelLabel, 0, 5, 1, 1, false);

		contactorTelField = new JTextField();
		setupComponet(contactorTelField, 1, 5, 1, 160, true);

		JLabel emailLabel = new JLabel("电子邮箱");
		setupComponet(emailLabel, 2, 5, 1, 1, false);

		emailField = new JTextField();
		setupComponet(emailField, 3, 5, 1, 160, true);

		addButton = new JButton("添加");
		setupComponet(addButton, 1, 7, 1, 0, false);

		resetButton = new JButton("重置");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetFields();
			}
		});
		setupComponet(resetButton, 3, 7, 1, 0, false);
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
					frame.setBounds(100, 100, 500, 350);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void setupComponet(JComponent component, int gridx, int gridy, int gridWidth, int ipadx, boolean fill) {
		GBC gbc = new GBC(gridx, gridy);

		gbc.setInsets(5, 5, 5, 5);
		if (gridWidth > 1) {
			gbc.gridwidth = gridWidth;
		}
		if (ipadx > 0) {
			gbc.ipadx = ipadx;
		}
		if (fill) {
			gbc.fill = GridBagConstraints.HORIZONTAL;
		} else {
			gbc.fill = GridBagConstraints.EAST;
		}

		add(component, gbc);
	}

	private void resetFields() {
		nameField.setText("");
		zipcodeField.setText("");
		addressField.setText("");
		telField.setText("");
		faxField.setText("");
		bankField.setText("");
		accountField.setText("");
		contactorField.setText("");
		contactorTelField.setText("");
		emailField.setText("");
	}

	private JTextField nameField;
	private JTextField zipcodeField;
	private JTextField addressField;
	private JTextField telField;
	private JTextField faxField;
	private JTextField bankField;
	private JTextField accountField;
	private JTextField contactorField;
	private JTextField contactorTelField;
	private JTextField emailField;
	private JButton addButton;
	private JButton resetButton;
}
