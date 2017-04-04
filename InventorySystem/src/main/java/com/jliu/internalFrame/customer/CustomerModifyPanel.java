package com.jliu.internalFrame.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jliu.dao.CustomerDao;
import com.jliu.model.Customer;

public class CustomerModifyPanel extends JPanel {
	/**
	 * Create the panel.
	 */
	public CustomerModifyPanel() {
		setLayout(null);
		setBounds(0, 0, 500, 300);

		JLabel nameLabel = new JLabel("客户名称");
		// nameLabel.setToolTipText("aaa");
		nameLabel.setBounds(30, 25, 80, 20);
		add(nameLabel);

		comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doSelectionAction();
			}
		});
		comboBox.setBounds(95, 25, 370, 20);
		add(comboBox);

		JLabel addressLabel = new JLabel("客户地址");
		addressLabel.setBounds(30, 55, 60, 20);
		add(addressLabel);

		addressTextField = new JTextField();
		addressTextField.setBounds(95, 55, 370, 20);
		add(addressTextField);
		addressTextField.setColumns(10);

		JLabel abbrLabel = new JLabel("简称");
		abbrLabel.setBounds(30, 85, 60, 20);
		add(abbrLabel);

		abbrTextField = new JTextField();
		abbrTextField.setBounds(95, 85, 140, 20);
		add(abbrTextField);
		abbrTextField.setColumns(10);

		JLabel zipcodeLabel = new JLabel("邮政编码");
		zipcodeLabel.setBounds(240, 85, 70, 20);
		add(zipcodeLabel);

		zipcodeTextField = new JTextField();
		zipcodeTextField.setBounds(320, 85, 145, 20);
		add(zipcodeTextField);
		zipcodeTextField.setColumns(10);

		JLabel phoneLabel = new JLabel("电话");
		phoneLabel.setBounds(30, 115, 60, 20);
		add(phoneLabel);

		phoneTextField = new JTextField();
		phoneTextField.setBounds(95, 115, 140, 20);
		add(phoneTextField);
		phoneTextField.setColumns(10);

		JLabel faxLabel = new JLabel("传真");
		faxLabel.setBounds(240, 115, 70, 20);
		add(faxLabel);

		faxTextField = new JTextField();
		faxTextField.setBounds(320, 115, 145, 20);
		add(faxTextField);
		faxTextField.setColumns(10);

		JLabel contactorLabel = new JLabel("<html><body><p style=\"color:red\">联系人*</p></body></html>");
		contactorLabel.setBounds(30, 145, 60, 20);
		add(contactorLabel);

		contactorField = new JTextField();
		contactorField.setBounds(95, 145, 140, 20);
		add(contactorField);
		contactorField.setColumns(10);

		JLabel contactorPhoneLabel = new JLabel("<html><body><p style=\"color:red\">联系电话*</p></body></html>");
		contactorPhoneLabel.setBounds(240, 145, 70, 20);
		add(contactorPhoneLabel);

		contactorPhoneField = new JTextField();
		contactorPhoneField.setBounds(320, 145, 145, 20);
		add(contactorPhoneField);
		contactorPhoneField.setColumns(10);

		JLabel emailLabel = new JLabel("E-mail");
		emailLabel.setBounds(30, 175, 60, 20);
		add(emailLabel);

		emailField = new JTextField();
		emailField.setBounds(95, 175, 370, 20);
		add(emailField);
		emailField.setColumns(10);

		JLabel bankLabel = new JLabel("开户银行");
		bankLabel.setBounds(30, 205, 60, 20);
		add(bankLabel);

		bankField = new JTextField();
		bankField.setBounds(95, 205, 140, 20);
		add(bankField);
		bankField.setColumns(10);

		JLabel bankAccountLabel = new JLabel("银行账号");
		bankAccountLabel.setBounds(240, 205, 70, 20);
		add(bankAccountLabel);

		bankAccountField = new JTextField();
		bankAccountField.setBounds(320, 205, 145, 20);
		add(bankAccountField);
		bankAccountField.setColumns(10);

		modifyButton = new JButton("修改");
		modifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveCustomer((String) comboBox.getSelectedItem(), abbrTextField.getText(), addressTextField.getText(),
						phoneTextField.getText(), emailField.getText(), zipcodeTextField.getText(),
						bankAccountField.getText(), bankField.getText(), faxTextField.getText(),
						contactorField.getText(), contactorPhoneField.getText());

				modifyButton.doClick();
			}
		});
		modifyButton.setBounds(136, 250, 80, 20);
		add(modifyButton);

		delButton = new JButton("删除");
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fullName = (String) comboBox.getSelectedItem();
				if (fullName.length() != 0) {
					CustomerDao dao = new CustomerDao();
					dao.deleteByName(fullName);

					// initialize the combobox again because one of items was
					// deleted
					initComboBox();
				}
			}
		});
		delButton.setBounds(309, 250, 80, 20);
		add(delButton);

		promptLabel = new JLabel("");
		promptLabel.setBounds(30, 270, 400, 20);
		add(promptLabel);
		
		initComboBox();
	}

	public void doSelectionAction() {
		String name = (String) comboBox.getSelectedItem();
		CustomerDao dao = new CustomerDao();
		Customer customer = dao.getByName(name);

		addressTextField.setText(customer.getAddress());
		abbrTextField.setText(customer.getAbbreviation());
		zipcodeTextField.setText(customer.getZipcode());
		phoneTextField.setText(customer.getTelephone());
		faxTextField.setText(customer.getFax());
		contactorField.setText(customer.getContacter());
		contactorPhoneField.setText(customer.getContacterPhone());
		emailField.setText(customer.getEmail());
		bankField.setText(customer.getBankName());
		bankAccountField.setText(customer.getAccountNo());
	}

	public void initComboBox() {
		CustomerDao dao = new CustomerDao();

		// remove all items firstly before initializing
		comboBox.removeAllItems();

		List<Customer> list = dao.findAll(Customer.class);
		for (Customer c : list) {
			comboBox.addItem(c.getName());
		}

		doSelectionAction();
	}

	public void saveCustomer(String name, String abbreviation, String address, String telephone, String email,
			String zipcode, String accountNo, String bankName, String fax, String contacter, String contacterPhone) {
		if (contacter.length() == 0) {
			promptLabel.setText("<html><body><p style=\"color:red\">联系人不能为空！</p></body></html>");
			return;
		}

		if (contacterPhone.length() == 0) {
			promptLabel.setText("<html><body><p style=\"color:red\">联系电话不能为空！</p></body></html>");
			return;
		}

		
		Customer customer = new Customer(name, abbreviation, address, telephone, email, zipcode, accountNo, bankName,
				fax, contacter, contacterPhone);
				
		CustomerDao dao = new CustomerDao();
		dao.saveOrUpdate(customer);
	}

	private JTextField addressTextField;
	private JTextField abbrTextField;
	private JTextField zipcodeTextField;
	private JTextField phoneTextField;
	private JTextField faxTextField;
	private JTextField contactorField;
	private JTextField contactorPhoneField;
	private JTextField bankField;
	private JTextField bankAccountField;
	private JTextField emailField;
	private JLabel promptLabel;
	private JButton modifyButton;
	private JButton delButton;
	private JComboBox<String> comboBox;
}
