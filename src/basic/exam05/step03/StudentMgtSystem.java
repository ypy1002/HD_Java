package basic.exam05.step03;

//	Frame에 들어갈 화면 제작
//	1) MenuPanel : 메뉴 출력 화면
//	2) StudentPanel : 학생 관리 화면
//	3) ScorePanel : 점수 관리 화면

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class StudentMgtSystem extends Frame implements ActionListener {

	static Scanner scanner = new Scanner(System.in);
	
  Panel menuPanel = new Panel(); // 기본 FlowLayout
	Button btnStudentMgt = new Button("학생관리");
	Button btnScoreMgt = new Button("점수관리");
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnScoreMgt){
			JOptionPane.showMessageDialog(null, "학생관리");
		}else{
			JOptionPane.showMessageDialog(null, "점수관리");
		}
	}
	
	public StudentMgtSystem(){

		super("학생관리 시스템");		//	호출 할 수퍼클래서를 지정할 수 있다,
		//	super();	호출 할 수퍼클래스 생성자를 지정하지 않는다면 기본 생성자를 호출함
		//	setTitle("학생관리 시스템");	기본 생성자 호출 후 setTitle()을 호출해도됨
		
		setSize(400, 300);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		menuPanel.setPreferredSize(new Dimension(70, 70)); // 원하는 크기
		
		btnStudentMgt.addActionListener(this);
		btnScoreMgt.addActionListener(this);
		
		menuPanel.add(btnStudentMgt);
		menuPanel.add(btnScoreMgt);
		
		setLayout(new FlowLayout());
		add(menuPanel);
	}

	private static String promptCommand() {

		System.out.print("메뉴를 선택해주세요. >>> ");
		return scanner.nextLine().toLowerCase();
	}

	public static void main(String[] args) {

		StudentMgtSystem f = new StudentMgtSystem();
		f.setVisible(true);

		/*
		 * do {
		 * 
		 * System.out.println("1. 학생관리"); System.out.println("2. 점수관리");
		 * System.out.println("q. 종료"); System.out.println();
		 * 
		 * String menu = promptCommand();
		 * 
		 * if ("1".equals(menu)) { StudentControl.execute(); } else if
		 * ("2".equals(menu)) { StudentScoreControl.execute(); } else if
		 * ("q".equals(menu)) { break; } else { System.out.println("없는 메뉴입니다."); } }
		 * while (true); scanner.close();
		 */
	}
}