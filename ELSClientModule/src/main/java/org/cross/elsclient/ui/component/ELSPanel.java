package org.cross.elsclient.ui.component;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class ELSPanel extends JPanel {
	public CardLayout cl;
	
	public ELSPanel() {
		cl = new CardLayout();
		setLayout(cl);
	}
}
