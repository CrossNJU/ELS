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
	protected TitlePanel titlePanel;
	protected ELSBox infoPanel;
	protected ArrayList<InfoItemLabel> itemLabels;
	protected int itemHeight;
	protected String backName;
	protected ELSButton confirmBtn;
	protected ELSButton cancelBtn;
	protected ELSBox btnBox;

	public void init() {
		itemHeight = 50;
		itemLabels = new ArrayList<>();

		container = new ELSPanel();
		titlePanel = new TitlePanel();
		infoPanel = new ELSBox(BoxLayout.Y_AXIS);
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
		container.setBackground(Color.white);

		titlePanel.init("Title");
		titlePanel.setLocation(UIConstant.CONTENTPANEL_MARGIN_LEFT, UIConstant.CONTENTPANEL_MARGIN_TOP);
		titlePanel.titleLabel.setFont(getFont().deriveFont(18f));
		titlePanel.backBtn.addMouseListener(new BtnListener());

		infoPanel.setSize(getWidth(), 20);
		infoPanel.setLocation(0, 70);


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
		InfoItemLabel itemLabel = new InfoItemLabel();
		itemLabel.initNormal(name, content);

		itemLabels.add(itemLabel);
//		contentLabels.add(contentLabel);
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
		InfoItemLabel itemLabel = new InfoItemLabel();
		itemLabel.initEditable(name, defaultValue, isEditable);;


		itemLabels.add(itemLabel);
//		inputLabels.add(inputLabel);

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
			boolean isEditable, InfoType type) {
		InfoItemLabel itemLabel = new InfoItemLabel();
		itemLabel.initEditable(name, defaultValue, isEditable,type);;

		itemLabels.add(itemLabel);
//		inputLabels.add(inputLabel);

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
		InfoItemLabel itemLabel = new InfoItemLabel();
		itemLabel.initBox(name, items, isEditable);

		itemLabels.add(itemLabel);

		infoPanel.setSize(infoPanel.getWidth(), infoPanel.getHeight()
				+ itemHeight);
		infoPanel.add(itemLabel);
	}
	
	public void addComboxItem(String name, String[] items,String defaultValue, boolean isEditable) {
		InfoItemLabel itemLabel = new InfoItemLabel();
		itemLabel.initBox(name, items,defaultValue, isEditable);

		itemLabels.add(itemLabel);

		infoPanel.setSize(infoPanel.getWidth(), infoPanel.getHeight()
				+ itemHeight);
		infoPanel.add(itemLabel);
	}
	
	public void addAutoItem(String name, String defaultValue,
			boolean isEditable){
		InfoItemLabel itemLabel = new InfoItemLabel();
		itemLabel.initAuto(name, defaultValue, isEditable);
		
		itemLabels.add(itemLabel);
		itemLabel.autoBtn.addMouseListener(new AutoBtnListener(itemLabel));

		infoPanel.setSize(infoPanel.getWidth(), infoPanel.getHeight()
				+ itemHeight);
		infoPanel.add(itemLabel);
	}
	
	/**
	 * 添加日期条目
	 * @para name-条目名, isEditable-是否可编辑
	 * @return void
	 */
	public void addDateItem(String name, boolean isEditable) {
		InfoItemLabel itemLabel = new InfoItemLabel();
		itemLabel.initDatePicker(name, isEditable);

		

		itemLabels.add(itemLabel);

		infoPanel.setSize(infoPanel.getWidth(), infoPanel.getHeight()
				+ itemHeight);
		infoPanel.add(itemLabel);
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
		titlePanel.titleLabel.setText(title);
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
	 * 返回是否含有非法信息的值
	 * @para 
	 * @return void
	 */
	public boolean isAllLegal(){
		for (InfoItemLabel infoItemLabel : itemLabels) {
			if(!infoItemLabel.isLegal){
				return false;
			}
		}
		return true;
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
	protected void cancel() {}
	
	public void autoBtn(String text){}
	
	class AutoBtnListener implements MouseListener{
		InfoItemLabel label;
		
		public AutoBtnListener(InfoItemLabel label) {
			this.label = label;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			autoBtn(label.toString());
			for (InfoItemLabel infoItemLabel : itemLabels) {
				infoItemLabel.validate();
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

	class BtnListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == titlePanel.backBtn) {
				System.out.println("Pressed");
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

	

}
