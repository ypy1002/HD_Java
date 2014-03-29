package basic.exam05.step03;

//	Frame 클래스의 사용
//		-	Component : 윈도우의 기본 기능을 갖고 있다.

//			=>	Atomic Comp : 기본 윈도우 객체(widget)
//			ex) Button , Checkbox , Canvas , Radiobox , ....

//			=>	Container : 다른 윈도우를 담을 수 있는 기능
//				Panel
//				Window
//						Frame , Dialog

//	Java의 리스너
//		-	인터페이스의 규칙에 따라 클래스를 작성해야 한다.
//		-	인터페이스 규칙을 따른다 => 인터페이스에 선언된 모든 메서드를 정의한다
//		-	자바스크립트와 차이점은 메서드가 아니라 객체를 등록해야한다.

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Scanner;

public class StudentMgtSystem01 {

	static Scanner scanner = new Scanner(System.in);

	// ArrayList에 저장할 인스턴스의 타입을 지정

	public static void main(String[] args) {
		
		//	Java에서 제공하는 추상 클래스의 활용 : WindowAdapter
		//	-	우리를 대신하여 WindowListener 인터페이스를 구현한 클래스이다.
	
		Frame f = new Frame("학생관리 시스템");
		f.setSize(400, 300);
		
		//	추상클래스(MyWindowListener)는 인스턴스를 생성할 수 없다.
		//	MyWindowAdapter l = new MyWindowAdapter();
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
			  System.exit(0);
			}
		});
		
		f.setVisible(true);
	}
	
	public static void main03(String[] args) {
		
		//	추상 클래스의 활용
		//		-	리스너에 선언된 메서드가 많다보니 사용하기가 불편함
		//		-	미리 리스너를 구현한 중간자 역할을 수행할 클래스를 정의한다.
		//		-	중간 클래스를 상속받아서 필요한 메서드만 재정의한다.
		//		-	코드를 간결하게 유지할 수 있다.
	
		Frame f = new Frame("학생관리 시스템");
		f.setSize(400, 300);
		
		//	추상클래스(MyWindowListener)는 인스턴스를 생성할 수 없다.
		//	MyWindowListener l = new MyWindowListener();
		
		f.addWindowListener(new MyWindowListener() {

			//	MyWindowListener를 상속받고 WindowClosing()만 재정의한다.
			//	와우~~ 간결하다!
			
			public void windowClosing(WindowEvent e) {
				//	윈도우에서 x버튼은 클릭할 때 호출됨.
			  System.exit(0);	//	0는 이상없이 종료함을 의미. JVM 종료
			}
		});
		
		f.setVisible(true);
	}
	
	public static void main02(String[] args) {
		
		//	addWindowListener() 호출할 때 익명 이너클래스 생성
		
		Frame f = new Frame("학생관리 시스템");
		f.setSize(400, 300);
		
		f.addWindowListener(new WindowListener() {

			public void windowOpened(WindowEvent e) {}
			public void windowClosed(WindowEvent e) {}
			public void windowIconified(WindowEvent e) {}
			public void windowDeiconified(WindowEvent e) {}
			public void windowActivated(WindowEvent e) {}
			public void windowDeactivated(WindowEvent e) {}
			
			public void windowClosing(WindowEvent e) {
				//	윈도우에서 x버튼은 클릭할 때 호출됨.
			  System.exit(0);	//	0는 이상없이 종료함을 의미. JVM 종료
			}
		});
		
		f.setVisible(true);

	}

	
	public static void main01(String[] args) {
		
		//	리스너를 익명 이너 클래스로 정의
		
		WindowListener  listener = new WindowListener() {

			public void windowOpened(WindowEvent e) {}
			public void windowClosed(WindowEvent e) {}
			public void windowIconified(WindowEvent e) {}
			public void windowDeiconified(WindowEvent e) {}
			public void windowActivated(WindowEvent e) {}
			public void windowDeactivated(WindowEvent e) {}
			
			public void windowClosing(WindowEvent e) {
				//	윈도우에서 x버튼은 클릭할 때 호출됨.
			  System.exit(0);	//	0는 이상없이 종료함을 의미. JVM 종료
			}
		};
		
		Frame f = new Frame("학생관리 시스템");
		f.setSize(400, 300);
		
		f.addWindowListener((WindowListener) listener);
		
		f.setVisible(true);
	}
}

