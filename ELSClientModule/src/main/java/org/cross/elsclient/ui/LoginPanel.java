package org.cross.elsclient.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.cross.elsclient.blservice.userblservice.UserBLService;
import org.cross.elsclient.blservice.userblservice.UserBLService_Stub;
import org.cross.elsclient.ui.adminui.AdminFunctionPanel;
import org.cross.elsclient.ui.businesshallclerkui.BusinessFunctionPanel;
import org.cross.elsclient.ui.component.ELSButton;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.util.UIConstant;
import org.cross.elscommon.util.UserType;

public class LoginPanel extends ELSPanel{
	UserBLService userbl;
	JPanel inputPanel;
	JTextField idTextField;
	JPasswordField pwTextField;
	ELSButton loginBtn;
	ELSButton checkBtn;
	
	public LoginPanel() {
		init();
		
	}
	public void init(){
		userbl = new UserBLService_Stub();
		
		setSize(UIConstant.WINDOW_WIDTH,UIConstant.WINDOW_HEIGHT);
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		
		inputPanel = new JPanel();
		idTextField = new JTextField("1");
		pwTextField = new JPasswordField("123456");
		loginBtn = new ELSButton("Login");
		checkBtn = new ELSButton("Check");
		
		inputPanel.setSize((int)(UIConstant.WINDOW_WIDTH*0.4),(int)(UIConstant.WINDOW_HEIGHT*0.4));
		inputPanel.setLocation((int)((UIConstant.WINDOW_WIDTH-inputPanel.getWidth())*0.5),(int)((UIConstant.WINDOW_HEIGHT-inputPanel.getHeight())*0.5));
		inputPanel.setBackground(Color.DARK_GRAY);
		inputPanel.setLayout(null);
		
		idTextField.setSize((int)(inputPanel.getWidth()*0.7),50);
		idTextField.setLocation((int)((inputPanel.getWidth()-idTextField.getWidth())*0.5), (int)(inputPanel.getHeight()*0.25-25));
		
		pwTextField.setSize((int)(inputPanel.getWidth()*0.7),50);
		pwTextField.setLocation((int)((inputPanel.getWidth()-pwTextField.getWidth())*0.5), (int)(inputPanel.getHeight()*0.5-25));
		
		loginBtn.setSize(100, 50);
		loginBtn.setLocation((int)(inputPanel.getWidth()*0.5-loginBtn.getWidth()*1.2),(int)(inputPanel.getHeight()*0.75-25));
		loginBtn.addMouseListener(new LoginBtnListener());
		
		checkBtn.setSize(100, 50);
		checkBtn.setLocation((int)(inputPanel.getWidth()*0.5+checkBtn.getWidth()*0.2),(int)(inputPanel.getHeight()*0.75-25));
		
		inputPanel.add(idTextField);
		inputPanel.add(pwTextField);
		inputPanel.add(loginBtn);
		inputPanel.add(checkBtn);
		
		this.add(inputPanel);
	}
	
	class LoginBtnListener implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			String id = idTextField.getText();
			String pw = String.valueOf(pwTextField.getPassword());
			UserType type = userbl.login(id, pw);
			
			if(type==UserType.ADMINISTRATOR){//系统管理员
				System.out.println("登录成功");
				ELSPanel parentContainer = (ELSPanel)LoginPanel.this.getParent();
				parentContainer.add(new AdminFunctionPanel(),"function");
				parentContainer.cl.show(parentContainer, "function");
			}else if(type==UserType.BUSINESSHALLCLERK){
				System.out.println("登录成功");
				ELSPanel parentContainer = (ELSPanel)LoginPanel.this.getParent();
				parentContainer.add(new BusinessFunctionPanel(),"function");
				parentContainer.cl.show(parentContainer, "function");
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
