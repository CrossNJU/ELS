package org.cross.elsclient.ui.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import org.cross.elsclient.blservice.initialblservice.InitialBLService;

public class ELSButton extends JLabel {
	Color backColor = Color.GRAY;
	Color pressColor = Color.DARK_GRAY;
	

	public ELSButton() {
		super();
		init();
	}
	
	public ELSButton(String string){
		super(string);
		init();
	}
	
	public void init(){
		setOpaque(true);
		setBackground(Color.gray);
		setForeground(Color.WHITE);
		setFont(getFont().deriveFont(Font.BOLD));
		setVerticalAlignment(JLabel.CENTER);
		setHorizontalAlignment(JLabel.CENTER);
		setFocusable(false);
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				release();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				press();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				requestFocus();
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				click();
			}
		});
	}
	
	public void setColor(Color bg){
		setBackground(bg);
		backColor = bg;
	}
	
	public void click(){
		setBackground(backColor);
	}
	
	public void press(){
		setBackground(pressColor);
	}
	
	public void release(){
		setBackground(backColor);
	}
	
}
