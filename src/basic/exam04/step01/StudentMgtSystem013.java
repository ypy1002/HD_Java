package basic.exam04.step01;

import java.util.Scanner;

public class StudentMgtSystem013 {

	static Scanner scanner = new Scanner(System.in);

	private static String[] promptCommand() {

		System.out.print("학생정보 입력 (종료 : quit) >> ");
		String[] input = scanner.nextLine().split(" ");

		return input;
	}

	private static void executeAdd(String[] input) {
		
		String data[] = input[1].split(",");
		
		System.out.println("이름 : " + data[0]);
		System.out.println("국어 : " + data[1]);
		System.out.println("영어 : " + data[2]);
		System.out.println("수학 : " + data[3]);
		
		System.out.print("등록 하시겠습니까 ? (y/n)");
		
		input[0] = scanner.nextLine().toLowerCase();
		
		if ("y".equals(input[0])) {
			System.out.println("등록 되었습니다.");
		} else {
			System.out.println("등록 취소되었습니다.");
		}
	}
	
	public static void main(String[] args) {

		while (true) {
		String[] input = promptCommand();

			if ("add".equals(input[0])) {
				executeAdd(input);
			} else if ("quit".equals(input[0].toLowerCase())) {
				break;
			} else {
				System.out.println("잘못된 명령어입니다.");
			}
		}
	}

}