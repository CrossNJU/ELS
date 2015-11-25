package org.cross.elsclient.ui.component;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

public class ELSStateBar extends JLabel{

	public static ELSStateBar instance = new ELSStateBar();
	public ELSStateBar() {
		setOpaque(true);
		setBackground(Color.DARK_GRAY);
		setHorizontalAlignment(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);
		setForeground(Color.WHITE);
		setFont(getFont().deriveFont(18f));
	}
	
	public static void showStateBar(Container c,String text){
		instance.setSize(c.getWidth(),50);
		instance.setLocation(0, c.getHeight());
		instance.setText(text);
		c.add(instance,0);
		c.repaint();
		AnimeTheard thread = instance.new AnimeTheard(instance);
		thread.execute();
//		c.remove(instance);
	}
		
	class AnimeTheard extends SwingWorker<Boolean, Boolean>{
		JComponent c;
		
		public AnimeTheard(JComponent c) {
			this.c = c;
		}
		
		@Override
		protected Boolean doInBackground() throws Exception {
			for(int i = 0;i<50;i++){
				c.setLocation(c.getLocation().x, c.getLocation().y-1);
				c.repaint();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			for(int i = 0;i<50;i++){
				c.setLocation(c.getLocation().x, c.getLocation().y+1);
				c.repaint();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
			c.getParent().remove(c);
			return null;
		}
		
//		@Override
//		public void () {
//			super.run();
//			
//			for(int i = 0;i<20;i++){
//				c.setLocation(c.getLocation().x, c.getLocation().y-1);
//				c.repaint();
//				try {
//					sleep(20);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			
//			try {
//				sleep(1000);
//			} catch (InterruptedException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			
//			for(int i = 0;i<20;i++){
//				c.setLocation(c.getLocation().x, c.getLocation().y+1);
//				c.repaint();
//				try {
//					sleep(20);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
	}
}
