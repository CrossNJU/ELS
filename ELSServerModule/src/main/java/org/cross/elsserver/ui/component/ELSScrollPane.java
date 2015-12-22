package org.cross.elsserver.ui.component;

import java.awt.Component;

import javax.swing.JScrollPane;


public class ELSScrollPane extends JScrollPane{

	public ELSScrollPane() {
		super();
		initComponent();
	}

	public ELSScrollPane(Component view, int vsbPolicy, int hsbPolicy) {
		super(view, vsbPolicy, hsbPolicy);
		initComponent();
	}

	public ELSScrollPane(Component view) {
		super(view);
		initComponent();
	}

	public ELSScrollPane(int vsbPolicy, int hsbPolicy) {
		super(vsbPolicy, hsbPolicy);
		initComponent();
	}

	public void init(){}
	
	public void initComponent(){
		setBorder(null);
	}
	
	public void packHeight(){
		if(getViewport().getComponent(0)!=null&&getViewport().getComponent(0) instanceof ELSPanel){
			ELSPanel component = (ELSPanel)getViewport().getComponent(0);
			component.packHeight();
		}
	}
}
