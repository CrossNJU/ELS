package org.cross.elsserver.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.TextArea;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.text.BadLocationException;

import org.cross.elsserver.ui.component.ELSPanel;
import org.cross.elsserver.ui.component.ELSScrollPane;
import org.cross.elsserver.ui.component.ELSTextArea;
import org.cross.elsserver.ui.util.UIConstant;

public class LogTable extends ELSScrollPane{
	ELSPanel container;
	ELSTextArea textArea;
	int width;
	int height;
	int lineCount;
	
	public LogTable() {
		init();
	}
	
	@Override
	public void init() {
		super.init();
		container = new ELSPanel();
		textArea = new ELSTextArea();
		width = UIConstant.WINDOW_WIDTH-2*UIConstant.CONTENTPANEL_MARGIN_LEFT;
		height = 522;
		lineCount=0;
		
		this.setBounds(17, 230, width, height);
		this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		container.setPreferredSize(new Dimension(width,height));
		container.setLayout(new BorderLayout());
		
		textArea.setBackground(UIConstant.BACKCOLOR);
		textArea.setEditable(false);
		textArea.setFont(getFont().deriveFont(18f));
		textArea.setForeground(UIConstant.MAINCOLOR);
		
		
		container.add(textArea);
		this.getViewport().add(container);
		
		textArea.setText("===================================");
	}
	
	public void addLog(String logStr){
		textArea.setText(textArea.getText()+"\n"+logStr);
		if(textArea.getLineCount()>21){
			container.setPreferredSize(new Dimension(width,container.getPreferredSize().height+textArea.getFont().getSize()+6));
		}
		Point p = new Point();
	    p.setLocation(0, textArea.getLineCount() * (textArea.getFont().getSize()+6));
	    this.getViewport().setViewPosition(p);
		container.repaint();
	}
}
