package ex;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class StudentMgtSystem01 {
	
	public static void main(String[] args) {
		
		Frame f = new Frame();
		f.setSize(400,300);
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		f.setVisible(true);
	}
	
	public static void main03(String[] args) {
		
		Frame f = new Frame();
		f.setSize(400,300);
		
	/*	f.addWindowListener(new MyWindowListener() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});*/
		
		f.setVisible(true);
	}
	
	public static void main02(String[] args) {

		Frame f = new Frame("학생관리 시스템");
		f.setSize(400,300);
		
		f.addWindowListener(new WindowListener() {
			public void windowOpened(WindowEvent e) {}
			public void windowClosed(WindowEvent e) {}
			public void windowIconified(WindowEvent e) {}
			public void windowDeiconified(WindowEvent e) {}
			public void windowActivated(WindowEvent e) {}
			public void windowDeactivated(WindowEvent e) {}
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		f.setVisible(true);
	}
	
	public static void main01(String[] args) {
		
		class MyWindowListener implements WindowListener{

			public void windowOpened(WindowEvent e) {}
			public void windowClosed(WindowEvent e) {}
			public void windowIconified(WindowEvent e) {}
			public void windowDeiconified(WindowEvent e) {}
			public void windowActivated(WindowEvent e) {}
			public void windowDeactivated(WindowEvent e) {}
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}
		
		Frame f = new Frame("학생관리 시스템");
		f.setSize(400,300);
		
		MyWindowListener listener = new MyWindowListener();
		
		f.addWindowListener(listener);
		f.setVisible(true);
	}
}
