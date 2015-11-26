package org.cross.elsclient.ui.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.cross.elsclient.ui.util.ComponentFactory;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.InfoFormatUtil;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elscommon.util.InfoType;

public class ELSInfoPanel extends ELSScrollPane {
	protected ELSPanel container;
	protected ELSPanel titlePanel;
	protected ELSLabel titleLabel;
	protected ELSBox infoPanel;
	protected ArrayList<ELSLabel> itemLabels;
	protected ArrayList<ELSLabel> contentLabels;
	protected ArrayList<ELSTextField> inputLabels;
	protected ArrayList<ELSComboBox> boxLabels;
	protected int itemHeight;
	protected ELSButton backBtn;
	protected String backName;
	protected ELSButton confirmBtn;
	protected ELSButton cancelBtn;
	protected ELSBox btnBox;

	public void init() {
		itemHeight = 50;
		contentLabels = new ArrayList<>();
		itemLabels = new ArrayList<>();
		inputLabels = new ArrayList<>();
		boxLabels = new ArrayList<>();

		container = new ELSPanel();
		titlePanel = new ELSPanel();
		titleLabel = new ELSLabel("Title");
		infoPanel = new ELSBox(BoxLayout.Y_AXIS);
		backBtn = ComponentFactory.createInfoBackBtn();
		confirmBtn = ComponentFactory.createConfirmBtn();
		cancelBtn = ComponentFactory.createCancelBtn();

		setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		setSize(UIConstant.CONTENTPANEL_WIDTH
				+ UIConstant.CONTENTPANEL_MARGIN_LEFT * 2,
				UIConstant.CONTENTPANEL_HEIGHT
						+ UIConstant.CONTENTPANEL_MARGIN_TOP * 2);

		container.setPreferredSize(new Dimension(
				UIConstant.CONTENTPANEL_WIDTH
				+ UIConstant.CONTENTPANEL_MARGIN_LEFT * 2,
				UIConstant.CONTENTPANEL_HEIGHT
				+ UIConstant.CONTENTPANEL_MARGIN_TOP * 2));
		container.setLayout(null);

		titlePanel.setSize(this.getWidth(), 50);
		titlePanel.setLocation(0, 0);
		titlePanel.setLayout(null);
		titlePanel.setBackground(Color.DARK_GRAY);

		titleLabel.setSize(200, 50);
		titleLabel.setLocation(30, 0);
		titleLabel.setFont(titleLabel.getFont().deriveFont(20f));
		titleLabel.setForeground(Color.white);
		titleLabel.setVerticalAlignment(JLabel.CENTER);
		titlePanel.add(titleLabel);

		infoPanel.setSize(getWidth(), 20);
		infoPanel.setLocation(0, 70);

		backBtn.setText("撤");
		backBtn.setBounds(12, 12, 30, 30);
		backBtn.addMouseListener(new BtnListener());

		container.add(backBtn);
		container.add(titlePanel);
		container.add(infoPanel);

		this.getViewport().add(container);
	}

	/**
	 * 添加不需编辑的条目
	 * 
	 * @para name-条目名, content-条目内容
	 * @return void
	 */
	public void addNormalItem(String name, String content) {
		ELSLabel itemLabel = new ELSLabel();
		ELSLabel nameLabel = new ELSLabel(name);
		ELSLabel contentLabel = new ELSLabel(content);

		itemLabel.setLayout(new BoxLayout(itemLabel, BoxLayout.X_AXIS));
		itemLabel
				.setMaximumSize(new Dimension(infoPanel.getWidth(), itemHeight));
		itemLabel
				.setMinimumSize(new Dimension(infoPanel.getWidth(), itemHeight));

		nameLabel.setPreferredSize(new Dimension(100, itemHeight));
		nameLabel.setMaximumSize(new Dimension(100, itemHeight));
		nameLabel.setVerticalAlignment(JLabel.CENTER);
		nameLabel.setHorizontalAlignment(JLabel.RIGHT);
		nameLabel.setFont(nameLabel.getFont().deriveFont(20f));

		contentLabel.setPreferredSize(new Dimension(200, itemHeight));
		contentLabel.setMaximumSize(new Dimension(200, itemHeight));
		contentLabel.setVerticalAlignment(JLabel.CENTER);
		contentLabel.setHorizontalAlignment(JLabel.LEFT);
		contentLabel.setFont(getFont().deriveFont(20f));

		itemLabel.add(Box.createHorizontalStrut(30));
		itemLabel.add(nameLabel);
		itemLabel.add(Box.createHorizontalStrut(10));
		itemLabel.add(contentLabel);

		itemLabels.add(itemLabel);
		contentLabels.add(contentLabel);
		infoPanel.setSize(infoPanel.getWidth(), infoPanel.getHeight()
				+ itemHeight);
		infoPanel.add(itemLabel);
	}

	/**
	 * 添加可编辑的输入条目
	 * 
	 * @para name-条目名, defaultValue-默认值, isEditable-是否可编辑
	 * @return void
	 */
	public void addEditableItem(String name, String defaultValue,
			boolean isEditable) {
		ELSLabel itemLabel = new ELSLabel();
		ELSLabel nameLabel = new ELSLabel(name);
		ELSTextField inputLabel = new ELSTextField(defaultValue);
		inputLabel.setEditable(isEditable);

		itemLabel.setLayout(new BoxLayout(itemLabel, BoxLayout.X_AXIS));
		itemLabel
				.setMaximumSize(new Dimension(infoPanel.getWidth(), itemHeight));
		itemLabel
				.setMinimumSize(new Dimension(infoPanel.getWidth(), itemHeight));

		nameLabel.setPreferredSize(new Dimension(100, itemHeight));
		nameLabel.setMaximumSize(new Dimension(100, itemHeight));
		nameLabel.setVerticalAlignment(JLabel.CENTER);
		nameLabel.setHorizontalAlignment(JLabel.RIGHT);
		nameLabel.setFont(nameLabel.getFont().deriveFont(20f));

		inputLabel.setPreferredSize(new Dimension(150, itemHeight - 15));
		inputLabel.setMaximumSize(new Dimension(150, itemHeight - 15));
		inputLabel.setHorizontalAlignment(JTextField.LEFT);
		inputLabel.setFont(getFont().deriveFont(20f));
		itemLabel.add(Box.createHorizontalStrut(30));
		itemLabel.add(nameLabel);
		itemLabel.add(Box.createHorizontalStrut(10));
		itemLabel.add(inputLabel);

		itemLabels.add(itemLabel);
		inputLabels.add(inputLabel);

		infoPanel.setSize(infoPanel.getWidth(), infoPanel.getHeight()
				+ itemHeight);
		infoPanel.add(itemLabel);
	}

	/**
	 * 添加可编辑的输入条目
	 * 
	 * @para name-条目名, defaultValue-默认值, isEditable-是否可编辑, type-信息类型(不需判断则为null)
	 * @return void
	 */
	public void addEditableItem(String name, String defaultValue,
			boolean isEditabel, InfoType type) {
		ELSLabel itemLabel = new ELSLabel();
		ELSLabel nameLabel = new ELSLabel(name);
		ELSTextField inputLabel = new ELSTextField(defaultValue);
		ELSLabel iconLabel = new ELSLabel();
		ELSLabel textLabel = new ELSLabel();
		inputLabel.setEditable(isEditabel);

		itemLabel.setLayout(new BoxLayout(itemLabel, BoxLayout.X_AXIS));
		itemLabel
				.setMaximumSize(new Dimension(infoPanel.getWidth(), itemHeight));
		itemLabel
				.setMinimumSize(new Dimension(infoPanel.getWidth(), itemHeight));

		nameLabel.setPreferredSize(new Dimension(100, itemHeight));
		nameLabel.setMaximumSize(new Dimension(100, itemHeight));
		nameLabel.setVerticalAlignment(JLabel.CENTER);
		nameLabel.setHorizontalAlignment(JLabel.RIGHT);
		nameLabel.setFont(nameLabel.getFont().deriveFont(20f));

		inputLabel.setPreferredSize(new Dimension(150, itemHeight - 15));
		inputLabel.setMaximumSize(new Dimension(150, itemHeight - 15));
		inputLabel.setHorizontalAlignment(JTextField.LEFT);
		inputLabel.setFont(getFont().deriveFont(20f));
		inputLabel.addFocusListener(new TextFormatListener(inputLabel,
				iconLabel, textLabel, type));

		iconLabel.setMaximumSize(new Dimension(itemHeight, itemHeight));
		iconLabel.setMinimumSize(new Dimension(itemHeight, itemHeight));

		// textLabel.setMaximumSize(new Dimension(itemHeight*6, itemHeight));
		textLabel.setMinimumSize(new Dimension(itemHeight * 3, itemHeight));
		textLabel.setHorizontalAlignment(JLabel.LEFT);
		textLabel.setVerticalAlignment(JLabel.CENTER);
		textLabel.setFont(getFont().deriveFont(15f));
		textLabel.setForeground(Color.red);

		itemLabel.add(Box.createHorizontalStrut(30));
		itemLabel.add(nameLabel);
		itemLabel.add(Box.createHorizontalStrut(10));
		itemLabel.add(inputLabel);
		itemLabel.add(iconLabel);
		itemLabel.add(textLabel);

		itemLabels.add(itemLabel);
		inputLabels.add(inputLabel);

		infoPanel.setSize(infoPanel.getWidth(), infoPanel.getHeight()
				+ itemHeight);
		infoPanel.add(itemLabel);
	}

	/**
	 * 添加下拉框条目
	 * 
	 * @para name-条目名, items-下拉框内容, isEditable-是否可编辑
	 * @return void
	 */
	public void addComboxItem(String name, String[] items, boolean isEditable) {
		ELSLabel itemLabel = new ELSLabel();
		ELSLabel nameLabel = new ELSLabel(name);
		ELSComboBox comboBox = new ELSComboBox();
		comboBox.setEnabled(isEditable);

		itemLabel.setLayout(new BoxLayout(itemLabel, BoxLayout.X_AXIS));
		itemLabel
				.setMaximumSize(new Dimension(infoPanel.getWidth(), itemHeight));
		itemLabel
				.setMinimumSize(new Dimension(infoPanel.getWidth(), itemHeight));

		nameLabel.setPreferredSize(new Dimension(100, itemHeight));
		nameLabel.setMaximumSize(new Dimension(100, itemHeight));
		nameLabel.setVerticalAlignment(JLabel.CENTER);
		nameLabel.setHorizontalAlignment(JLabel.RIGHT);
		nameLabel.setFont(nameLabel.getFont().deriveFont(20f));

		comboBox.setModel(new DefaultComboBoxModel<>(items));
		comboBox.setPreferredSize(new Dimension(150, itemHeight - 15));
		comboBox.setMaximumSize(new Dimension(150, itemHeight - 15));
		comboBox.setFont(getFont().deriveFont(20f));

		itemLabel.add(Box.createHorizontalStrut(30));
		itemLabel.add(nameLabel);
		itemLabel.add(Box.createHorizontalStrut(10));
		itemLabel.add(comboBox);

		itemLabels.add(itemLabel);
		boxLabels.add(comboBox);

		infoPanel.setSize(infoPanel.getWidth(), infoPanel.getHeight()
				+ itemHeight);
		infoPanel.add(itemLabel);
	}

	public void addComboxItem(String name, String... items) {

	}

	/**
	 * 添加确认与取消按钮，一般单纯展示信息的界面不需调用此方法
	 * 
	 * @para
	 * @return void
	 */
	public void addConfirmAndCancelBtn() {
		ELSLabel itemLabel = new ELSLabel();

		itemLabel.setLayout(new BoxLayout(itemLabel, BoxLayout.X_AXIS));
		itemLabel
				.setMaximumSize(new Dimension(infoPanel.getWidth(), itemHeight));
		itemLabel
				.setMinimumSize(new Dimension(infoPanel.getWidth(), itemHeight));
		// itemLabel.setOpaque(true);
		// itemLabel.setBackground(Color.white);

		confirmBtn.setPreferredSize(new Dimension(100, 50));
		confirmBtn.setMaximumSize(new Dimension(100, 50));
		confirmBtn.setMinimumSize(new Dimension(100, 50));
		confirmBtn.addMouseListener(new BtnListener());

		cancelBtn.setPreferredSize(new Dimension(100, 50));
		cancelBtn.setMaximumSize(new Dimension(100, 50));
		cancelBtn.setMinimumSize(new Dimension(100, 50));
		cancelBtn.addMouseListener(new BtnListener());

		itemLabel.add(Box.createHorizontalStrut(20));
		itemLabel.add(confirmBtn);
		itemLabel.add(Box.createHorizontalStrut(20));
		itemLabel.add(cancelBtn);

		infoPanel.setSize(infoPanel.getWidth(), infoPanel.getHeight()
				+ itemHeight * 2);
		infoPanel.add(Box.createVerticalStrut(itemHeight));
		infoPanel.add(itemLabel);
	}

	/**
	 * 设置界面标题
	 * 
	 * @para
	 * @return void
	 */
	public void setTitle(String title) {
		titleLabel.setText(title);
	}

	/**
	 * 设置返回的界面
	 * 
	 * @para name-界面的名称
	 * @return void
	 */
	public void setBackPanel(String name) {
		backName = name;
	}

	/**
	 * 执行返回界面
	 * 
	 * @para
	 * @return void
	 */
	public void back() {
		ELSPanel parent = (ELSPanel) getParent();
		if (backName == null) {
			parent.cl.first(parent);
		} else {
			parent.cl.show(parent, backName);
		}
		parent.remove(ELSInfoPanel.this);
	}

	/**
	 * 执行确认按钮的方法，若是执行了addConfirmAndCancelBtn(),需要重写这一方法
	 * 
	 * @para
	 * @return void
	 */
	protected void confirm() throws RemoteException {

	}

	/**
	 * 执行取消按钮的方法，若是执行了addConfirmAndCancelBtn(),需要重写这一方法
	 * 
	 * @para
	 * @return void
	 */
	protected void cancel() {

	}

	class BtnListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == backBtn) {
				if (ELSDialog.showConfirmDlg(
						GetPanelUtil.getMainFrame(ELSInfoPanel.this), "退出",
						"确认退出？")) {
					back();
				}
			} else if (e.getSource() == confirmBtn) {
				try {
					confirm();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (e.getSource() == cancelBtn) {
				cancel();
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

	class TextFormatListener implements FocusListener {
		ELSTextField inputLabel;
		ELSLabel iconLabel;
		ELSLabel textLabel;
		InfoType type;

		public TextFormatListener(ELSTextField inputLabel, ELSLabel iconLabel,
				ELSLabel textLabel, InfoType type) {
			super();
			this.inputLabel = inputLabel;
			this.iconLabel = iconLabel;
			this.textLabel = textLabel;
			this.type = type;
		}

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			String src = inputLabel.getText();
			String result = InfoFormatUtil.CheckFormat(src, type);
			if (result == null) {
				iconLabel.setText("Y");
				textLabel.setText("");
			} else {
				iconLabel.setText("N");
				textLabel.setText(result);
				// System.out.println(result);
			}
		}

	}

}
