package com.jliu.internalFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;

import com.jliu.internalFrame.customer.CustomerAddPanel;
import com.jliu.internalFrame.customer.CustomerModifyPanel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class CustomerMgmtIFrame extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame();
					frame.add(new CustomerMgmtIFrame());
					frame.setBounds(0, 0, 600, 400);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	public CustomerMgmtIFrame() {
		setIconifiable(true);
		setBounds(100, 100, 450, 300);
		setClosable(true);
		setTitle("客户信息管理");
		
		tabbedPane = new JTabbedPane();

		final CustomerAddPanel addPanel = new CustomerAddPanel();
		final CustomerModifyPanel modifyPanel = new CustomerModifyPanel();
		tabbedPane.addTab("客户信息添加", null, addPanel, "添加客户信息");
		tabbedPane.addTab("客户信息修改和删除", null, modifyPanel, "修改和删除客户信息");
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				modifyPanel.initComboBox();
			}
		});
		getContentPane().add(tabbedPane);

		pack();
		setVisible(true);
	}
	
	private JTabbedPane tabbedPane;
}
