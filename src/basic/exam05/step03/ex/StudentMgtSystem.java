package basic.exam05.step03.ex;

import java.util.Scanner;

public class StudentMgtSystem {

	static Scanner scanner = new Scanner(System.in);



	public static void main(String[] args) {

		while (true) {

			System.out.println("-----------");
			System.out.println("1. 학생정보");
			System.out.println("2. 점수정보");
			System.out.println("q. 종료");
			System.out.println("-----------");
			System.out.println();
			
			System.out.print("메뉴를 선택해주세요 >> ");
			String input = scanner.nextLine().toLowerCase();
			
			if ("1".equals(input)){
				StudentListControl.execute();
			} else if ("2".equals(input)) {
				StudentScoreControl.execute();
			} else if ("q".equals(input)) {
				break;
			} else {
				System.out.println("잘못된 명령어입니다.");
			}
		}
	}
}
