package ex;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;


public class StudentMgtSystem02 {
	
	public static void main(String[] args) {
		
		Frame f = new Frame("학생관리 시스템");
		f.setSize(400,300);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); 		
			}
		});
		f.setVisible(true);
		
		Panel p = new Panel();
		p.setPreferredSize(new Dimension(100, 100));
		
		Button btnStudentScore = new Button("StudentScore");
		
		btnStudentScore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "오호랏 이거얏!!");
			}
		});
		
		p.add(btnStudentScore);
		
		Button btnStudentList = new Button("StudentList");
		
		btnStudentList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "오호랏 이거얏!!zz");
			}
		});
		
		p.add(btnStudentList);

		
		f.setLayout(new FlowLayout());
		f.add(p);
	}
}
