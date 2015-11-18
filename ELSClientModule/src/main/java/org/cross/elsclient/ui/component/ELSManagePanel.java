package org.cross.elsclient.ui.component;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.xml.bind.Marshaller.Listener;

import org.cross.elsclient.blservice.userblservice.UserBLService;
import org.cross.elsclient.blservice.userblservice.UserBLService_Stub;
import org.cross.elsclient.vo.UserVO;
import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

public class ELSManagePanel extends ELSPanel {
	protected JPanel contentPanel;
	protected JPanel searchPanel;

	public ELSManagePanel() {
		init();
	}
	
	void init() {
		setLayout(null);
		setSize(900,600);
		
		contentPanel = new JPanel();
		searchPanel = new JPanel();
		
		searchPanel.setSize(getWidth(),100);
		searchPanel.setLayout(null);
		searchPanel.setLocation(0, 0);
		setSearchPanel();
		
		contentPanel.setSize(getWidth(), 800);
		contentPanel.setLayout(null);
		contentPanel.setLocation(0,100);
		setContentPanel();
		
		add(searchPanel);
		add(contentPanel);
		
	}
	
	public void setSearchPanel(){
		
	}
	
	public void setContentPanel(){
		
	}
	
}
