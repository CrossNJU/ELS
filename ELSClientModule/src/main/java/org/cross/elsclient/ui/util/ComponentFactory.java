package org.cross.elsclient.ui.util;

import java.awt.Color;
import java.awt.Dimension;

import org.cross.elsclient.ui.component.ELSButton;
import org.cross.elsclient.ui.component.ELSComboBox;
import org.cross.elsclient.ui.component.ELSDatePicker;
import org.cross.elsclient.ui.component.ELSPanel;
import org.cross.elsclient.ui.component.ELSTextField;
import org.cross.elsclient.ui.component.FunctionBtn;

public class ComponentFactory {
	
	/**
	 * 创建功能选择按钮
	 * @para 
	 * @return ELSButton
	 */
	public static ELSButton createFunctionBtn(){
		return new FunctionBtn();
	}
	
	/**
	 * 创建信息展示界面返回按钮
	 * @para 
	 * @return ELSButton
	 */
	public static ELSButton	createInfoBackBtn(){
		return new ELSButton();
	}
	
	/**
	 * 创建信息展示界面确认按钮
	 * @para 
	 * @return ELSButton
	 */
	public static ELSButton createConfirmBtn(){
		ELSButton btn = new ELSButton();
		btn.setColor(Color.decode("#7ed09d"));
		
		return btn;
	}
	
	/**
	 * 创建信息展示界面取消按钮
	 * @para 
	 * @return ELSButton
	 */
	public static ELSButton createCancelBtn(){
		ELSButton btn = new ELSButton();
		btn.setColor(Color.decode("#7ebcd0"));
		
		return btn;
	}
	
	/**
	 * 创建管理表界面修改按钮
	 * @para 
	 * @return ELSButton
	 */
	public static ELSButton createUpdateBtn(){
		ELSButton updateBtn = new ELSButton("改");
		updateBtn.setPreferredSize(new Dimension(30, 30));
		updateBtn.setMaximumSize(new Dimension(30, 30));
		updateBtn.setMinimumSize(new Dimension(30, 30));
		updateBtn.setName("update");
		return updateBtn;
	}
	
	/**
	 * 创建管理表界面删除按钮
	 * @para 
	 * @return ELSButton
	 */
	public static ELSButton createDeleteBtn(){
		ELSButton deleteBtn = new ELSButton("删");
		deleteBtn.setPreferredSize(new Dimension(30, 30));
		deleteBtn.setMaximumSize(new Dimension(30, 30));
		deleteBtn.setMinimumSize(new Dimension(30, 30));
		deleteBtn.setName("delete");
		return deleteBtn;
	}
	
	/**
	 * 创建搜索栏搜索框
	 * @para 
	 * @return ELSButton
	 */
	public static ELSTextField createSearchTextField(){
		ELSTextField searchTextField = new ELSTextField();
		
		searchTextField.setPreferredSize(new Dimension(300, UIConstant.SEARCHPANEL_HEIGHT));
//		searchTextField.setMaximumSize(new Dimension(50, searchPanel.getHeight()));
		searchTextField.setMinimumSize(new Dimension(200,UIConstant.SEARCHPANEL_HEIGHT));
		
		return searchTextField;
	}
	/**
	 * 创建搜索栏日历控件
	 * @para 
	 * @return ELSButton
	 */
	public static ELSDatePicker createDatePicker(){
		ELSDatePicker datePicker = new ELSDatePicker();
		datePicker.setMaximumSize(new Dimension(200, UIConstant.SEARCHPANEL_HEIGHT));
		datePicker.setMinimumSize(new Dimension(150, UIConstant.SEARCHPANEL_HEIGHT));
		return datePicker;
	}
	
	/**
	 * 创建搜索栏下拉框
	 * @para 
	 * @return ELSButton
	 */
	public static ELSComboBox createSearchBox(){
		ELSComboBox box = new ELSComboBox();
		box.setMaximumSize(new Dimension(200, UIConstant.SEARCHPANEL_HEIGHT));
		box.setMinimumSize(new Dimension(200, UIConstant.SEARCHPANEL_HEIGHT));
		return box;
	}
	/**
	 * 创建搜索栏按钮
	 * @para 
	 * @return ELSButton
	 */
	public static ELSButton createSearchBtn(){
		ELSButton btn = new ELSButton();
		btn.setPreferredSize(new Dimension(150, UIConstant.SEARCHPANEL_HEIGHT));
		btn.setMaximumSize(new Dimension(250, UIConstant.SEARCHPANEL_HEIGHT));
		btn.setMinimumSize(new Dimension(150, UIConstant.SEARCHPANEL_HEIGHT));
		btn.setColor(Color.decode("#7ebcd0"));
		return btn;
	}
}
