package org.cross.elsclient.ui;

import java.awt.Color;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicTextFieldUI;
import javax.swing.plaf.multi.MultiTextUI;
import javax.swing.plaf.synth.SynthTextFieldUI;

import org.cross.elsclient.blimpl.blfactoryimpl.BLFactoryImpl;
import org.cross.elsclient.blimpl.constantblimpl.ConstantBLImpl;
import org.cross.elsclient.blservice.blfactoryservice.BLFactoryService;
import org.cross.elsclient.blservice.goodsblservice.GoodsBLService_Stub;
import org.cross.elsclient.blservice.organizationblservice.OrganizationBLService;
import org.cross.elsclient.blservice.userblservice.UserBLService;
import org.cross.elsclient.blservice.userblservice.UserBLService_Stub;
import org.cross.elsclient.ui.adminui.AdminFunctionPanel;
import org.cross.elsclient.ui.businesshallclerkui.BusinessFunctionPanel;
import org.cross.elsclient.ui.component.ELSButton;
import org.cross.elsclient.ui.component.ELSLabel;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.component.ELSTextField;
import org.cross.elsclient.ui.counterui.CounterFunctionPanel;
import org.cross.elsclient.ui.courierui.CourierFunctionPanel;
import org.cross.elsclient.ui.courierui.goodscheck.GoodsCheckPanel;
import org.cross.elsclient.ui.managerui.ManagerFunctionPanel;
import org.cross.elsclient.ui.publicui.CheckFunctionPanel;
import org.cross.elsclient.ui.stockkeeperui.StockFunctionPanel;
import org.cross.elsclient.ui.transitcenterclerkui.TransmitFunctionPanel;
import org.cross.elsclient.ui.util.ComponentFactory;
import org.cross.elsclient.ui.util.Images;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elsclient.util.ConstantVal;
import org.cross.elsclient.vo.ConstantVO;
import org.cross.elscommon.util.UserType;

public class LoginPanel extends ELSPanel{
	UserBLService userbl;
	BLFactoryService blFactory;
	OrganizationBLService organbl;
	JPanel inputPanel;
	ELSTextField idTextField;
	JPasswordField pwTextField;
	ELSButton loginBtn;
	ELSButton checkBtn;
	ELSLabel titleLabel;
	ELSLabel logoLabel;
	ELSLabel idLabel;
	ELSLabel pwLabel;
	ELSButton exitBtn;
	
	public LoginPanel() {
		init();
		ConstantVal.CONSTANT = new ConstantVO();
		ConstantVal.constantbl = ConstantVal.getConstant();
		ConstantVal.numberbl = ConstantVal.getNumber();
	}
	public void init(){
		
//		try {
//			BLFactoryService blFactory = new BLFactoryImpl();
//			userbl = blFactory.getUserBLService();
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			blFactory = new BLFactoryImpl();
			userbl = blFactory.getUserBLService();
			organbl = blFactory.organizationBLService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setSize(UIConstant.WINDOW_WIDTH,UIConstant.WINDOW_HEIGHT);
		setLayout(null);
		setOpaque(false);
		setBackground(Color.LIGHT_GRAY);
		
		inputPanel = new JPanel();
		idTextField = new ELSTextField("1");
		pwTextField = new JPasswordField("123456");
		idLabel = new ELSLabel("用户名");
		pwLabel = new ELSLabel("密码");
		loginBtn = new ELSButton("登录系统");
		checkBtn = new ELSButton("快件查询");
		titleLabel = new ELSLabel();
		logoLabel = new ELSLabel();
		exitBtn = ComponentFactory.createExitBtn();
		
		inputPanel.setSize(550,390);
		inputPanel.setLocation((int)((UIConstant.WINDOW_WIDTH-inputPanel.getWidth())*0.5),(int)((UIConstant.WINDOW_HEIGHT-inputPanel.getHeight())*0.5));
		inputPanel.setBackground(Color.WHITE);
		inputPanel.setLayout(null);
		
		titleLabel.setBackground(UIConstant.MAINCOLOR);
		titleLabel.setSize(inputPanel.getSize().width,110);
		titleLabel.setOpaque(true);
		titleLabel.setLocation(0, 0);
		titleLabel.setLayout(null);
		
		logoLabel.setSize(225,44);
		logoLabel.setLocation(27, 35);
		logoLabel.setIcon(Images.LOGO_IMAGEICON);
		
		idTextField.setSize(314,55);
		idTextField.setLocation(164,149);
		idTextField.addKeyListener(new MyKeyListener());
		idLabel.setSize(135,55);
		idLabel.setLocation(0, 149);
		idLabel.setHorizontalAlignment(JLabel.RIGHT);
		idLabel.setFont(getFont().deriveFont(20f));
		
		pwTextField.setSize(314,55);
		pwTextField.setLocation(164,212);
		pwTextField.setForeground(UIConstant.MAINCOLOR);
		pwTextField.addKeyListener(new MyKeyListener());
		pwLabel.setSize(135,55);
		pwLabel.setLocation(0, 212);
		pwLabel.setHorizontalAlignment(JLabel.RIGHT);
		pwLabel.setFont(getFont().deriveFont(20f));
		
		loginBtn.setSize(178, 55);
		loginBtn.setLocation(92,296);
		loginBtn.setColor(UIConstant.COMFIRM_BTN_COLOR);
		loginBtn.addMouseListener(new LoginBtnListener());
		
		checkBtn.setSize(178, 55);
		checkBtn.setLocation(281,296);
		checkBtn.setColor(UIConstant.NORMAL_BTN_COLOR);
		checkBtn.addMouseListener(new LoginBtnListener());
		
		exitBtn.setLocation(510, 20);
		
		titleLabel.add(logoLabel);
		titleLabel.add(exitBtn);
		
		inputPanel.add(titleLabel);
		inputPanel.add(idTextField);
		inputPanel.add(idLabel);
		inputPanel.add(pwTextField);
		inputPanel.add(pwLabel);
		inputPanel.add(loginBtn);
		inputPanel.add(checkBtn);
		
		this.add(inputPanel);
	}
	
	public void login(){
		String id = idTextField.getText();
		String pw = String.valueOf(pwTextField.getPassword());
		UserType type = null;
		try {
			type = userbl.login(id, pw);
			if(type!=null){
				UIConstant.CURRENT_USER = userbl.findById(id);
				UIConstant.CURRENT_ORG = organbl.findById(UIConstant.CURRENT_USER.orgNameID);
//				System.out.println(UIConstant.CURRENT_USER);
			}
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		
		if(type==UserType.ADMINISTRATOR){//系统管理员
			System.out.println("登录成功");
			ELSPanel parentContainer = (ELSPanel)LoginPanel.this.getParent();
			parentContainer.add("function",new AdminFunctionPanel());
			parentContainer.cl.show(parentContainer, "function");
		}else if(type==UserType.BUSINESSHALLCLERK){
			System.out.println("登录成功");
			ELSPanel parentContainer = (ELSPanel)LoginPanel.this.getParent();
			parentContainer.add("function",new BusinessFunctionPanel());
			parentContainer.cl.show(parentContainer, "function");
		}else if(type==UserType.COURIER){
			System.out.println("登录成功");
			ELSPanel parentContainer = (ELSPanel)LoginPanel.this.getParent();
			parentContainer.add("function",new CourierFunctionPanel());
			parentContainer.cl.show(parentContainer, "function");
		}else if(type==UserType.TRANSITCENTERCLERK){
			System.out.println("登录成功");
			ELSPanel parentContainer = (ELSPanel)LoginPanel.this.getParent();
			parentContainer.add("function",new TransmitFunctionPanel());
			parentContainer.cl.show(parentContainer, "function");
		}else if(type==UserType.COUNTER){
			System.out.println("登录成功");
			ELSPanel parentContainer = (ELSPanel)LoginPanel.this.getParent();
			parentContainer.add("function",new CounterFunctionPanel());
			parentContainer.cl.show(parentContainer, "function");
		}else if(type==UserType.SUPERCOUNTER){
			System.out.println("登录成功");
			ELSPanel parentContainer = (ELSPanel)LoginPanel.this.getParent();
			parentContainer.add("function",new CounterFunctionPanel());
			parentContainer.cl.show(parentContainer, "function");
		}else if(type==UserType.MANAGER){
			System.out.println("登录成功");
			ELSPanel parentContainer = (ELSPanel)LoginPanel.this.getParent();
			parentContainer.add("function",new ManagerFunctionPanel());
			parentContainer.cl.show(parentContainer, "function");
		}else if(type==UserType.STOCKKEEPER){
			System.out.println("登录成功");
			ELSPanel parentContainer = (ELSPanel)LoginPanel.this.getParent();
			parentContainer.add("function",new StockFunctionPanel());
			parentContainer.cl.show(parentContainer, "function");
		}
		System.out.println("用户类型为:"+type.toString());
	
	}
	
	class LoginBtnListener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==loginBtn){
				login();
			}else {
				ELSPanel parentContainer = (ELSPanel)LoginPanel.this.getParent();
				try {
					parentContainer.add("check",new CheckFunctionPanel(blFactory.goodsBLService()));
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				parentContainer.cl.show(parentContainer, "check");
			}
				
		}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}
	}
	
	class MyKeyListener implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()==e.VK_ENTER){
				login();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {}
		
	}
}
