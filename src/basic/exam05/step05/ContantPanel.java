package basic.exam05.step05;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class ContantPanel extends Panel implements ActionListener {

	//	protected 패키지가 달라도 sub 클래스라면 접근가능
	
	protected StudentMgtSystem parent;
	protected Label title = new Label();
	protected Button btnBack = new Button("back");
	protected Panel content = new Panel();
	
	public ContantPanel(StudentMgtSystem parent , String title){
		
		this.setLayout(new BorderLayout());
		
		this.parent = parent;
		this.title.setText(title);
		
		Panel titlebar = new Panel();
		titlebar.add(this.title);
		titlebar.add(btnBack);
		
		this.add(titlebar , BorderLayout.NORTH);
		
		this.add(content , BorderLayout.CENTER);
		
		btnBack.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		parent.changePanel(StudentMgtSystem.MENU_PANEL);
	}
}
