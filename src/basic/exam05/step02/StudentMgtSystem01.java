package basic.exam05.step02;


import java.util.Scanner;

public class StudentMgtSystem01 {
	
	//	윈도우 관련 이벤트를 처리하는 리스너가 반드시 갖춰야할 기능

	static Scanner scanner = new Scanner(System.in);

	// ArrayList에 저장할 인스턴스의 타입을 지정

	private static String promptCommand() {

		System.out.print("메뉴를 선택해주세요. >>> ");
		
		return scanner.nextLine().toLowerCase();
	}

	public static void main(String[] args) {

		do {

			System.out.println("1. 학생관리");
			System.out.println("2. 점수관리");
			System.out.println("q. 종료");
			System.out.println();

			String menu = promptCommand();

			if ("1".equals(menu)) {
				StudentControl.execute();
			} else if ("2".equals(menu)) {
				StudentScoreControl.execute();
			} else if ("q".equals(menu)) {
				break;
			} else {
				System.out.println("없는 메뉴입니다.");
			}
		} while (true);
		scanner.close();
	}
}