package com.jliu.login;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.jliu.utils.UtilTools;

public class LoginPanel extends JPanel {
	public LoginPanel() {
		super();
		icon = new ImageIcon(UtilTools.getResourceUrl("login.jpg"));
		width = icon.getIconWidth();
		height = icon.getIconHeight();
		setSize(width, height);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(icon.getImage(), 0, 0, getParent());
	}
	
	
	protected ImageIcon icon;
	private int width, height;
}
