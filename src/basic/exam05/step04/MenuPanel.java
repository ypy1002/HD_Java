package basic.exam05.step04;

import java.awt.Button;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")	//	버전번호 관리가 필요없는 경우 시리얼경고를 띄우지 않도록 하는 명령어

public class MenuPanel extends Panel implements ActionListener {
	
	StudentMgtSystem parent;
	
	Button btnStudentMgt = new Button("StudentControl");
	Button btnScoreMgt = new Button("ScoreControl");
	
	public MenuPanel(StudentMgtSystem parent){
		
		this.parent = parent;	//	부모 윈도우의 주소를 보관
		
		//	생성자에서 자식 컴포넌트들을 준비한다.
		
		btnStudentMgt.addActionListener(this);
		btnScoreMgt.addActionListener(this);
		
		add(btnStudentMgt);
		add(btnScoreMgt);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnScoreMgt){
			parent.changePanel(StudentMgtSystem.SCORE_PANEL);
		}else{
			parent.changePanel(StudentMgtSystem.STUDENT_PANEL);
		}
	}
}