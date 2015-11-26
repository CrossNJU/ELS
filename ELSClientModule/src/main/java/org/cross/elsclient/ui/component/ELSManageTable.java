package org.cross.elsclient.ui.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import org.cross.elsclient.ui.adminui.UserInfoPanel;
import org.cross.elsclient.ui.adminui.UserManagePanel;
import org.cross.elsclient.ui.adminui.UserUpdatePanel;
import org.cross.elsclient.ui.util.ComponentFactory;
import org.cross.elsclient.ui.util.GetPanelUtil;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.vo.UserVO;

public class ELSManageTable extends ELSPanel {
	String[] name;
	ELSBox header;
	protected ELSBox container;
	ELSLabel tempLabel;
	protected ArrayList<Box> itemLabels;
	int[] itemWidth;
	int width;
	int height;
	public int gap;
	Font font;
	public boolean isUpdateAndDelete;

	public ELSManageTable(){
		width = UIConstant.CONTENTPANEL_WIDTH;
		height = UIConstant.MANAGETABLE_ITEM_HEIGHT;
	}
	
	/**
	 * 
	 * @author:Moo
	 * @para: name-表头名，itemWidth-列宽
	 */
	public ELSManageTable(String[] name, int[] itemWidth) {
		super();
		this.name = name;
		this.itemWidth = itemWidth;
		width = UIConstant.CONTENTPANEL_WIDTH;
		height = UIConstant.MANAGETABLE_ITEM_HEIGHT;
	}

	public void init() {
		removeAll();
		
		itemLabels = new ArrayList<>();
		container = new ELSBox(BoxLayout.Y_AXIS);
		header = new ELSBox(BoxLayout.X_AXIS);
		gap = 20;
		font = getFont().deriveFont(18f);
		isUpdateAndDelete = false;

		setSize(new Dimension(width, UIConstant.MANAGETABLE_HEIGHT));
		setBorder(null);
		
		container.setSize(width,UIConstant.MANAGETABLE_HEIGHT);
//		container.setBackground(Color.LIGHT_GRAY);
//		container.setOpaque(true);
//		container.setSize(width, height);
//		container.setLocation(0, 0);

		//表头初始化
		header.setOpaque(true);
		header.setBackground(Color.GRAY);
		header.setPreferredSize(new Dimension(width,UIConstant.MANAGETABLE_ITEM_HEIGHT));
		header.setMaximumSize(new Dimension(width,UIConstant.MANAGETABLE_ITEM_HEIGHT));
		header.setMinimumSize(new Dimension(width,UIConstant.MANAGETABLE_ITEM_HEIGHT));

		for (int i = 0; i < name.length; i++) {
			tempLabel = new ELSLabel(" " + name[i]);
			tempLabel.setForeground(Color.white);
			tempLabel.setFont(font);
			tempLabel.setPreferredSize(new Dimension(itemWidth[i],UIConstant.MANAGETABLE_ITEM_HEIGHT));
			tempLabel.setMaximumSize(new Dimension(itemWidth[i],UIConstant.MANAGETABLE_ITEM_HEIGHT));
			tempLabel.setMinimumSize(new Dimension(itemWidth[i],UIConstant.MANAGETABLE_ITEM_HEIGHT));
			tempLabel.setVerticalAlignment(JLabel.CENTER);
			tempLabel.setHorizontalAlignment(JLabel.LEFT);
			header.add(tempLabel);
		}
		
		container.add(header);
		add(container);
		validate();
		repaint();
	}
	
	/**
	 * 添加条目
	 * @para item-条目项
	 * @return void
	 */
	protected void addItemLabel(String[] item) {
		Box itemLabel = new Box(BoxLayout.X_AXIS);

		itemLabel.setOpaque(true);
		itemLabel.setBackground(Color.lightGray);
		itemLabel.setPreferredSize(new Dimension(width,UIConstant.MANAGETABLE_ITEM_HEIGHT));
		itemLabel.setMaximumSize(new Dimension(width,UIConstant.MANAGETABLE_ITEM_HEIGHT));
		itemLabel.setMinimumSize(new Dimension(width,UIConstant.MANAGETABLE_ITEM_HEIGHT));

		for (int i = 0; i < item.length; i++) {
			tempLabel = new ELSLabel(" " + item[i]);
			tempLabel.setFont(font);
			tempLabel.setPreferredSize(new Dimension(itemWidth[i],UIConstant.MANAGETABLE_ITEM_HEIGHT));
			tempLabel.setMaximumSize(new Dimension(itemWidth[i],UIConstant.MANAGETABLE_ITEM_HEIGHT));
			tempLabel.setMinimumSize(new Dimension(itemWidth[i],UIConstant.MANAGETABLE_ITEM_HEIGHT));
			tempLabel.setVerticalAlignment(JLabel.CENTER);
			tempLabel.setHorizontalAlignment(JLabel.LEFT);
			itemLabel.add(tempLabel);
		}
		
		if(isUpdateAndDelete){
			ELSButton updateBtn = ComponentFactory.createUpdateBtn();
			ELSButton deleteBtn = ComponentFactory.createDeleteBtn();
			
			updateBtn.setVisible(false);
			updateBtn.addMouseListener(new BtnListener(itemLabel));
			
			deleteBtn.setVisible(false);
			deleteBtn.addMouseListener(new BtnListener(itemLabel));
			
			itemLabel.add(Box.createHorizontalGlue());
			itemLabel.add(updateBtn);
			itemLabel.add(Box.createHorizontalStrut(gap));
			itemLabel.add(deleteBtn);
			itemLabel.add(Box.createHorizontalStrut(gap));
			itemLabel.validate();
			itemLabel.addMouseListener(new ItemListener(itemLabel));
			repaint();
			
			itemLabels.add(itemLabel);
			container.add(itemLabel);
			packHeight();
			validate();
			repaint();
		}
	}
	
	/**
	 * 点击信息按钮的响应事件，需要被重写
	 * @para index-对应条目的序号
	 * @return void
	 */
	public void infoBtn(int index){
	}
	
	/**
	 * 点击修改按钮的响应事件，如果添加了修改按钮则需要被重写
	 * @para index-对应条目的序号
	 * @return void
	 */
	public void updateBtn(int index){
	}
	
	/**
	 * 点击删除按钮的响应事件，如果添加了删除按钮则需要被重写
	 * @para index-对应条目的序号
	 * @return void
	 */
	public void deleteBtn(int index){
	}
	
	class ItemListener implements MouseListener{
		Box itemLabel;
		
		public ItemListener(Box itemLabel) {
			this.itemLabel = itemLabel;
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			int index = itemLabels.indexOf(itemLabel);
			infoBtn(index);
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
			if(isUpdateAndDelete){
				itemLabel.getComponent(itemLabel.getComponentCount()-2).setVisible(true);
				itemLabel.getComponent(itemLabel.getComponentCount()-4).setVisible(true);
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if(isUpdateAndDelete){
				itemLabel.getComponent(itemLabel.getComponentCount()-2).setVisible(false);
				itemLabel.getComponent(itemLabel.getComponentCount()-4).setVisible(false);
			}
		}
	}
	
	class BtnListener implements MouseListener{
		Box itemLabel;
		
		public BtnListener(Box itemLabel) {
			this.itemLabel = itemLabel;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			ELSButton btn = (ELSButton)e.getSource();
			int index = itemLabels.indexOf(itemLabel);
			
			if(btn.getName()=="update"){
				updateBtn(index);
			}else if(btn.getName()=="delete"){
				if(ELSDialog.showConfirmDlg(SwingUtilities.getWindowAncestor(ELSManageTable.this), "删除","是否删除")){
					deleteBtn(index);
				}
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
			if(isUpdateAndDelete){
				itemLabel.getComponent(itemLabel.getComponentCount()-2).setVisible(true);
				itemLabel.getComponent(itemLabel.getComponentCount()-4).setVisible(true);
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if(isUpdateAndDelete){
				itemLabel.getComponent(itemLabel.getComponentCount()-2).setVisible(false);
				itemLabel.getComponent(itemLabel.getComponentCount()-4).setVisible(false);
			}
		}
	}
	
	@Override
	public void packHeight() {
		container.setSize(getWidth(),container.getComponentCount()*UIConstant.MANAGETABLE_ITEM_HEIGHT);
		setSize(getWidth(),container.getComponentCount()*UIConstant.MANAGETABLE_ITEM_HEIGHT);
	}
	
}
