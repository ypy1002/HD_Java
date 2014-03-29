package basic.exam05.step04;

import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class ScorePanel extends Panel implements ActionListener {

	StudentMgtSystem parent;

	Label title = new Label("Score Control");

	Button btnBack = new Button("back");

	public ScorePanel(StudentMgtSystem parent) {

		this.parent = parent;
		add(title);

		btnBack.addActionListener(this);
		add(btnBack);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		parent.changePanel(StudentMgtSystem.MENU_PANEL);
	}
}