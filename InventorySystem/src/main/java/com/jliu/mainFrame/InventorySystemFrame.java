package com.jliu.mainFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import com.jliu.utils.UtilTools;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

public class InventorySystemFrame extends JFrame {
	private JLabel backgroundLabel;
	private JDesktopPane desktopPane;
	// create map to store the internal frames
	private Map<String, JInternalFrame> ifs = new HashMap<String, JInternalFrame>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventorySystemFrame frame = new InventorySystemFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// set UI LookAndFeel
	static {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public InventorySystemFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("企业进销存管理系统");
		setBounds(100, 100, 800, 600);
		setVisible(true);
		setBackground(new Color(170, 188, 120));
		setLayout(new BorderLayout());
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				super.componentResized(e);

				updateBackgroundImage();
			}
		});

		desktopPane = new JDesktopPane();
		initBackgroundLabel();
		add(desktopPane, BorderLayout.CENTER);

		JTabbedPane tabbedPane = createNavigationPanel();
		add(tabbedPane, BorderLayout.NORTH);

	}

	public JTabbedPane createNavigationPanel() {
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		JPanel basicInfoPanel = new JPanel();
		basicInfoPanel.setLayout(new BoxLayout(basicInfoPanel, BoxLayout.X_AXIS));
		basicInfoPanel.add(createIFrameButton("客户信息管理", "CustomerMgmtIFrame"));
		tabbedPane.addTab("基础信息管理", null, basicInfoPanel, "基础信息管理");

		return tabbedPane;
	}

	/**
	 * Create internal frame button
	 * 
	 * @return
	 */
	public JButton createIFrameButton(String iconName, String className) {
		String imgUrl = "ActionIcon" + File.separator + iconName + ".png";
		String imgUrlRoll = "ActionIcon" + File.separator + iconName + "_roll.png";
		String imgUrlDown = "ActionIcon" + File.separator + iconName + "_down.png";
		Icon icon = new ImageIcon(UtilTools.getResourceUrl(imgUrl));
		Icon iconRoll = new ImageIcon(UtilTools.getResourceUrl(imgUrlRoll));
		Icon iconDown = new ImageIcon(UtilTools.getResourceUrl(imgUrlDown));

		JButton button = new JButton(new OpenFrameAction(iconName, className, icon));
		button.setHideActionText(true);
		button.setMargin(new Insets(0, 0, 0, 0));
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);

		if (iconRoll != null) {
			button.setRolloverIcon(iconRoll);
		}

		if (iconDown != null) {
			button.setPressedIcon(iconDown);
		}

		return button;
	}

	private JInternalFrame getIFrame(String frameName) {
		JInternalFrame iframe = null;

		if (!ifs.containsKey(frameName)) {
			try {
				Class fclass = Class.forName("com.jliu.internalFrame." + frameName);
				Constructor constructor = fclass.getConstructor(null);
				iframe = (JInternalFrame) constructor.newInstance(null);
				ifs.put(frameName, iframe);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			iframe = ifs.get(frameName);
		}

		return iframe;
	}

	protected final class OpenFrameAction extends AbstractAction {
		private String frameName = null;

		public OpenFrameAction() {
		}

		public OpenFrameAction(String iconName, String className, Icon icon) {
			this.frameName = className;

			putValue(Action.NAME, iconName);
			putValue(Action.SHORT_DESCRIPTION, iconName);
			putValue(Action.SMALL_ICON, icon);

		}

		public void actionPerformed(ActionEvent e) {
			JInternalFrame jf = getIFrame(frameName);
			jf.addInternalFrameListener(new InternalFrameAdapter() {
				@Override
				public void internalFrameClosed(InternalFrameEvent e) {
					super.internalFrameClosed(e);
					ifs.remove(frameName);
				}
			});

			if (jf.getDesktopPane() != desktopPane) {
				desktopPane.add(jf);
				jf.setVisible(true);
			}

			try {
				jf.setSelected(true);
			} catch (PropertyVetoException e1) {
				e1.printStackTrace();
			}
		}
	}

	private void updateBackgroundImage() {
		if (backgroundLabel != null) {
			int height = getHeight();
			int width = getWidth();

			backgroundLabel.setSize(width, height);
			backgroundLabel.setText("<html><body><image width='" + width + "' height='" + (height - 110) + "' src="
					+ UtilTools.getResourceUrl("welcome.jpg") + "'></img></body></html>");
		}
	}

	private void initBackgroundLabel() {
		backgroundLabel = new JLabel();
		backgroundLabel.setHorizontalAlignment(SwingConstants.CENTER);
		backgroundLabel.setVerticalAlignment(SwingConstants.TOP);

		desktopPane.add(backgroundLabel, new Integer(Integer.MIN_VALUE));

		updateBackgroundImage();
	}
}
