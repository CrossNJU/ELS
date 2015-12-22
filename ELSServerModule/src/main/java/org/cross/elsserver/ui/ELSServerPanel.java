package org.cross.elsserver.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.cross.elsserver.ui.component.ELSButton;
import org.cross.elsserver.ui.component.ELSLabel;
import org.cross.elsserver.ui.component.ELSPanel;
import org.cross.elsserver.ui.component.ELSTextField;
import org.cross.elsserver.ui.component.TitlePanel;
import org.cross.elsserver.ui.util.ComponentFactory;
import org.cross.elsserver.ui.util.UIConstant;

import com.mysql.fabric.Server;

public class ELSServerPanel extends ELSPanel{
	ELSLabel logo;
	ELSButton exitBtn;
	ELSLabel title;
	ELSLabel infoLabel;
	ELSTextField portField;
	ELSLabel stateLabel;
	ELSButton changeBtn;
	ELSButton launchBtn;
	ELSButton stopBtn;
	TitlePanel logTitle;
	LogTable logTable;
	
	public ELSServerPanel() {
		init();
	}
	
	public void init(){
		super.init();
		//member var initial
		logo = new ELSLabel();
		exitBtn = ComponentFactory.createExitBtn();
		title = new ELSLabel();
		infoLabel = new ELSLabel();
		portField = new ELSTextField();
		stateLabel = new ELSLabel();
		changeBtn = ComponentFactory.createSearchBtn();
		launchBtn = ComponentFactory.createSearchBtn();
		stopBtn = ComponentFactory.createSearchBtn();
		logTitle = new TitlePanel("服务器Log");
		logTable = new LogTable();
		
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		
		logo.setSize(225,44);
		logo.setLocation(27, 30);
		logo.setIcon(new ImageIcon("img/Logo.png"));
		
		exitBtn.setLocation(984, 20);
	
		title.setSize(UIConstant.WINDOW_WIDTH,100);
		title.setLocation(0, 0);
		title.setBackground(UIConstant.MAINCOLOR);
		title.setOpaque(true);
		title.setLayout(null);;
		
		infoLabel.setText("服务器信息:");
		infoLabel.setBounds(UIConstant.CONTENTPANEL_MARGIN_LEFT, 120, 110, 48);
		infoLabel.setHorizontalAlignment(JLabel.LEFT);
		infoLabel.setFont(getFont().deriveFont(18f));
		infoLabel.setForeground(UIConstant.MAINCOLOR);
		
		stateLabel.setText("服务器状态:未启动");
		stateLabel.setBounds(504, 120, 200, 48);
		stateLabel.setHorizontalAlignment(JLabel.LEFT);
		stateLabel.setFont(getFont().deriveFont(18f));
		stateLabel.setForeground(UIConstant.MAINCOLOR);
		
		portField.setBounds(125, 120, 200, 48);
		
		changeBtn.setLocation(340, 120);
		changeBtn.setText("更改端口");
		
		launchBtn.setLocation(708, 120);
		launchBtn.setText("启动服务");
		launchBtn.setColor(UIConstant.COMFIRM_BTN_COLOR);
		
		stopBtn.setLocation(864, 120);
		stopBtn.setText("停止服务");
		
		logTitle.setBounds(UIConstant.CONTENTPANEL_MARGIN_LEFT,183,UIConstant.WINDOW_WIDTH-2*UIConstant.CONTENTPANEL_MARGIN_LEFT,48);
		
		title.add(logo);
		title.add(exitBtn);
		title.validate();
		this.add(title);
		this.add(infoLabel);
		this.add(stateLabel);
		this.add(changeBtn);
		this.add(portField);
		this.add(changeBtn);
		this.add(launchBtn);
		this.add(stopBtn);
		this.add(logTitle);
		this.add(logTable);
	}
}
