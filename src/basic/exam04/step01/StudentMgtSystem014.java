package basic.exam04.step01;

import java.util.Scanner;

public class StudentMgtSystem014 {
	
	static Scanner scanner = new Scanner(System.in);
	
	private static StudentScore[] scoreList;
	private static int ScoreSize;
	
	static{
		scoreList = new StudentScore[3];
	}
	
	private static String[] promptCommand(){
		System.out.print("학생 정보를 입력해주세요(종료: quit) >> ");
		String[] input = scanner.nextLine().split(" ");
		return input;
	}
	
	private static void executeAdd(String values) {
		
		String input;

		if(scoreSize < 3){
			StudentScore scoreList = 
		}
		
		System.out.println("이름 : " + score.name);
		System.out.println("국어 : " + score.kor);
		System.out.println("영어 : " + score.eng);
		System.out.println("수학 : " + score.math);
		
		System.out.print("학생 정보를 등록하시겠습니까 ? (y/n)");
		
		input = scanner.nextLine();
		
		if("y".equals(input)){
			System.out.println("학생 정보가 등록되었습니다.");
		}else{
			System.out.println("학생 정보 등록이 취소되었습니다.");
		}
	}
	
	public static void main(String[] args) {

		while (true) {

			String[] input = promptCommand();
			
			if ("add".equals(input[0].toLowerCase())) {
				executeAdd(input[1]);
			} else if ("quit".equals(input[0].toLowerCase())) {
				break;
			} else {
				System.out.println("잘못된 명령어 입니다.");
			}
		}
	}



}