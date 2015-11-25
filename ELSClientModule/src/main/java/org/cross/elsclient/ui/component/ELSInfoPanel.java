package org.cross.elsclient.ui.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.cross.elsclient.ui.util.ComponentFactory;

public class ELSInfoPanel extends JPanel{
	protected ELSPanel titlePanel;
	protected ELSLabel titleLabel;
	protected ELSBox infoPanel;
	protected ArrayList<ELSLabel> itemLabels;
	protected ArrayList<ELSLabel> contentLabels;
	protected ArrayList<ELSTextField> inputLabels;
	protected int itemHeight;
	protected ELSButton backBtn;
	protected String backName;
	protected ELSButton confirmBtn;
	protected ELSButton cancelBtn;
	protected ELSBox btnBox;
	
	public void init(){
		itemHeight = 50;
		contentLabels = new ArrayList<>();
		itemLabels = new ArrayList<>();
		inputLabels = new ArrayList<>();
		setLayout(null);
		setSize(924,600);
		
		titlePanel = new ELSPanel();
		infoPanel = new ELSBox(BoxLayout.Y_AXIS);
		backBtn = ComponentFactory.createInfoBackBtn();
		confirmBtn = ComponentFactory.createConfirmBtn();
		cancelBtn = ComponentFactory.createCancelBtn();
		
		titleLabel = new ELSLabel("Title");
		
		titlePanel.setSize(this.getWidth(),50);
		titlePanel.setLocation(0, 0);
		titlePanel.setLayout(null);
		titlePanel.setBackground(Color.DARK_GRAY);
		
		titleLabel.setSize(200,50);
		titleLabel.setLocation(50, 0);
		titleLabel.setFont(titleLabel.getFont().deriveFont(20f));
		titleLabel.setForeground(Color.white);
		titleLabel.setVerticalAlignment(JLabel.CENTER);
		titlePanel.add(titleLabel);
		
		infoPanel.setSize(getWidth(),20);
		infoPanel.setLocation(0,50);
//		infoPanel.setPreferredSize(new Dimension(this.getWidth(), 0));
//		infoPanel.setMaximumSize(new Dimension(this.getWidth(), 0));
//		infoPanel.setMinimumSize(new Dimension(this.getWidth(), 0));
		infoPanel.add(Box.createVerticalStrut(20));
		
		
		backBtn.setText("撤");
		backBtn.setBounds(12, 12, 30, 30);
		backBtn.addMouseListener(new BtnListener());
		
		this.add(infoPanel);
		this.add(backBtn);
		this.add(titlePanel);
	}
	
	public void addNormalItem(String name,String content){
		ELSLabel itemLabel = new ELSLabel();
		ELSLabel nameLabel = new ELSLabel(name);
		ELSLabel contentLabel = new ELSLabel(content);
		
		itemLabel.setLayout(new BoxLayout(itemLabel, BoxLayout.X_AXIS));
		itemLabel.setMaximumSize(new Dimension(infoPanel.getWidth(),itemHeight));
		itemLabel.setMinimumSize(new Dimension(infoPanel.getWidth(), itemHeight));
		
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
		
		infoPanel.setSize(infoPanel.getWidth(),infoPanel.getHeight()+itemHeight);
		infoPanel.add(itemLabel);
	}
	
	public void addEditableItem(String name,String defaultValue,boolean isEditabel){
		ELSLabel itemLabel = new ELSLabel();
		ELSLabel nameLabel = new ELSLabel(name);
		ELSTextField inputLabel = new ELSTextField(defaultValue);
		inputLabel.setEditable(isEditabel);
		
		itemLabel.setLayout(new BoxLayout(itemLabel, BoxLayout.X_AXIS));
		itemLabel.setMaximumSize(new Dimension(infoPanel.getWidth(),itemHeight));
		itemLabel.setMinimumSize(new Dimension(infoPanel.getWidth(), itemHeight));
		
		nameLabel.setPreferredSize(new Dimension(100, itemHeight));
		nameLabel.setMaximumSize(new Dimension(100, itemHeight));
		nameLabel.setVerticalAlignment(JLabel.CENTER);
		nameLabel.setHorizontalAlignment(JLabel.RIGHT);
		nameLabel.setFont(nameLabel.getFont().deriveFont(20f));
		
		inputLabel.setPreferredSize(new Dimension(150, itemHeight-15));
		inputLabel.setMaximumSize(new Dimension(150, itemHeight-15));
		inputLabel.setHorizontalAlignment(JTextField.LEFT);
		inputLabel.setFont(getFont().deriveFont(20f));
		
		itemLabel.add(Box.createHorizontalStrut(30));
		itemLabel.add(nameLabel);
		itemLabel.add(Box.createHorizontalStrut(10));
		itemLabel.add(inputLabel);
		
		itemLabels.add(itemLabel);
		inputLabels.add(inputLabel);
		
		infoPanel.setSize(infoPanel.getWidth(),infoPanel.getHeight()+itemHeight);
		infoPanel.add(itemLabel);
	}
	
	public void addConfirmAndCancelBtn(){
		ELSLabel itemLabel = new ELSLabel();
		
		itemLabel.setLayout(new BoxLayout(itemLabel, BoxLayout.X_AXIS));
		itemLabel.setMaximumSize(new Dimension(infoPanel.getWidth(),itemHeight));
		itemLabel.setMinimumSize(new Dimension(infoPanel.getWidth(), itemHeight));
//		itemLabel.setOpaque(true);
//		itemLabel.setBackground(Color.white);
		
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
		
		infoPanel.setSize(infoPanel.getWidth(),infoPanel.getHeight()+itemHeight*2);
		infoPanel.add(Box.createVerticalStrut(itemHeight));
		infoPanel.add(itemLabel);
	}
	
	public void setTitle(String title){
		titleLabel.setText(title);
	}
	
	public void setBackPanel(String name){
		backName = name;
	}
	
	public void back(){
		ELSPanel parent = (ELSPanel) getParent();
		if(backName == null){
			parent.cl.first(parent);
		}else{
			parent.cl.show(parent, backName);
		}
		parent.remove(ELSInfoPanel.this);
	}
	
	protected void confirm() throws RemoteException{
		
	}
	
	protected void cancel(){
		
	}
	
	class BtnListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == backBtn){
				back();
			} else if(e.getSource() == confirmBtn){
				try {
					confirm();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if(e.getSource() == cancelBtn){
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
