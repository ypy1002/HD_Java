package basic.exam05.step05;

import java.awt.Button;

@SuppressWarnings("serial")
public class StudentPanel extends ContantPanel{

	public StudentPanel(StudentMgtSystem parent) {
		super(parent, "Student Control");
		
		content.add(new Button("Want to in Score Control"));
	}
}