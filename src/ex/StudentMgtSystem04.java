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


@SuppressWarnings("serial")
public class StudentMgtSystem04 extends Frame{
	
	public StudentMgtSystem04(){
		
		
		
		setSize(400,300);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); 		
			}
		});
		setVisible(true);
		
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

		
		setLayout(new FlowLayout());
		add(p);
	}
	
	public static void main(String[] args) {
		StudentMgtSystem04 studentMgtSystem04 = new StudentMgtSystem04();
		studentMgtSystem04.setVisible(true);
		
	}
}
