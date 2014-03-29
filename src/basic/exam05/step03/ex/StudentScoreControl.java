package basic.exam05.step03.ex;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentScoreControl {
	
	static Scanner scanner;

	private static ArrayList<StudentScore> scoreList = new ArrayList<StudentScore>();
	
	static {
		scanner = StudentMgtSystem.scanner;
	}

	private static String[] promptCommand() {
		
		System.out.println();
		System.out.println("--------------학생 점수관리--------------");
		System.out.println("| add : 학생점수 등록                   |");
		System.out.println("| list : 학생점수 조회                  |");
		System.out.println("| delete no : 점수정보 삭제             |");
		System.out.println("| update no : 점수정보 변경             |");
		System.out.println("| save : 점수정보 저장                  |");
		System.out.println("| load : 점수정보 불러오기              |");
		System.out.println("| back : 학생/점수 선택창으로 돌아가기  |");
		System.out.println("-----------------------------------------");
		System.out.println();
		
		System.out.print("메뉴를 선택해주세요 >> ");

		String[] value = scanner.nextLine().toLowerCase().split(" ");

		return value;
	}

	private static void executeAdd(String value) {

		StudentScore score = StudentScore.fromCSV(value);

		System.out.println("이름 : " + score.name);
		System.out.println("국어 : " + score.kor);
		System.out.println("영어 : " + score.eng);
		System.out.println("수학 : " + score.math);

		System.out.print("등록하시겠습니까 ? (y/n) : ");

		String input = scanner.nextLine().toLowerCase();

		if ("y".equals(input)) {
			scoreList.add(score);
			System.out.println("등록 되었습니다.");
		} else {
			System.out.println("등록 취소되었습니다.");
		}
	}

	public static void executeList() {

		int i = 0;

		for (StudentScore score : scoreList) {
			System.out.println(i++ + "번 : " + score);
		}
	}

	public static void executeDelete(int no) {

		int i = 0;

		if (no > -1 && no < scoreList.size()) {
			scoreList.remove(no);
			System.out.println(no + "번 정보가 삭제되었습니다.");

			for (StudentScore score : scoreList) {
				System.out.println(i++ + "번 : " + score);
			}
		} else {
			System.out.println("유효하지 않는 학생번호입니다.");
		}
	}

	public static void executeUpdate(int no) {

		if (no > -1 && no < scoreList.size()) {
			StudentScore score = scoreList.get(no);

			System.out.print("이름(" + score.name + ") - 변경할 이름은 ? ");
			String name = scanner.nextLine();

			System.out.print("국어(" + score.kor + ") - 변경할 국어점수는 ? ");
			int kor = Integer.parseInt(scanner.nextLine());

			System.out.print("영어(" + score.eng + ") - 변경할 영어점수는 ? ");
			int eng = Integer.parseInt(scanner.nextLine());

			System.out.print("수학(" + score.math + ") - 변경할 수학점수는 ? ");
			int math = Integer.parseInt(scanner.nextLine());

			System.out.print("정보를 변경하시겠습니까 ? (y/n) : ");
			String input = scanner.nextLine().toLowerCase();

			if ("y".equals(input)) {

				score.name = name;
				score.kor = kor;
				score.eng = eng;
				score.math = math;
				System.out.println("학생 점수정보가 변경되었습니다.");
				System.out.println(no + "번 : " + score);

			} else {
				System.out.println("학생 점수정보 변경이 취소되었습니다.");
			}
		} else {
			System.out.println("유효하지 않는 학생번호입니다.");
		}
	}

	public static void executeSave() {

		try {
			FileWriter out = new FileWriter("stuScore.data");

			for (StudentScore score : scoreList) {
				out.write(score.toString() + "\n");
			}
			System.out.println("저장 성공");

			out.close();
		} catch (IOException e) {
			System.out.println("저장에 실패하였습니다.");
			e.printStackTrace();
		}
	}

	public static void executeLoad() {

		try {
			FileReader in = new FileReader("stuScore.data");
			Scanner s = new Scanner(in);

			while (true) {
				try {
					scoreList.add(StudentScore.fromCSV(s.nextLine()));
				} catch (NoSuchElementException ex) {
					break;
				}
			}
			s.close();
			System.out.println("불러오기 성공");
		} catch (FileNotFoundException e) {
			System.out.println("불러오기에 실패하였습니다.");
			e.printStackTrace();
		}
	}
	
	public static void execute(){
		
		while (true) {

			String[] value = promptCommand();

			if ("add".equals(value[0])) {
				executeAdd(value[1]);
			} else if ("list".equals(value[0])) {
				executeList();
			} else if ("delete".equals(value[0])) {
				executeDelete(Integer.parseInt(value[1]));
			} else if ("update".equals(value[0])) {
				executeUpdate(Integer.parseInt(value[1]));
			} else if ("save".equals(value[0])) {
				executeSave();
			} else if ("load".equals(value[0])) {
				executeLoad();
			} else if ("back".equals(value[0])) {
				break;
			} else {
				System.out.println("잘못된 명령어입니다.");
			}
		}
	}
}
