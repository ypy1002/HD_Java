package basic.exam05.step03;

//	LayoutManager
//		-	컨테이너에 UI 컴포넌트를 위치시키는 역할을 담당

//		1) BorderLayout
//			- 동,서,남,북,가운데

//		2) FlowLayout
//			-	왼쪽에서 오른쪽으로 배치 => 끝을 만나면 다음 라인에 이어서 배치

//		3) GridLayout
//			-	바둑판 방식으로 배치 => 모든 셀의 너비와 높이가 같다.

//		4) CardLayout
//			-	중첩하여 배치 => 탭화면을 만들 때

//		5) GridBagLayout
//			-	GridLayout + 셀 병합기능 추가

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.peer.MenuPeer;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class StudentMgtSystem04 extends Frame {

	static Scanner scanner = new Scanner(System.in);
	
  Panel menuPanel = new Panel(); // 기본 FlowLayout
	Button btnStudentMgt = new Button("학생관리");
	Button btnScoreMgt = new Button("점수관리");
	
	public StudentMgtSystem04(){

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
		
		btnStudentMgt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "오호라..이거야!!");
			}
		});
	
		
		btnScoreMgt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "오호라..이거야!! 2");
			}
		});
		
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

		StudentMgtSystem04 f = new StudentMgtSystem04();
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