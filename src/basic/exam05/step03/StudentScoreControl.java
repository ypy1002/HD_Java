package basic.exam05.step03;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentScoreControl {
	
	static Scanner scanner;
	
	private static ArrayList<StudentScore> scoreList = new ArrayList<StudentScore>();
	
	static {
		scanner = StudentMgtSystem.scanner;
	}

	private static void executeAdd(final String value) {

		String input;

		StudentScore score = StudentScore.fromCSV(value);

		System.out.println("이름 : " + score.name);
		System.out.println("국어 : " + score.kor);
		System.out.println("영어 : " + score.eng);
		System.out.println("수학 : " + score.math);

		System.out.print("등록하시겠습니까 ? (y/n)");
		input = scanner.nextLine();

		if ("y".equals(input.toLowerCase())) {
			scoreList.add(score);

			// scoreList.add("okokok"); StudentScore가 아니면 넣을 수 없다.
			// scoreList.add(30);

			System.out.println("등록 되었습니다.");
		} else {
			System.out.println("등록 취소하였습니다.");
		}
	}

	private static void executeList() {

		// ArrayList로부터 data를 꺼낸다.
		// for(변수 : 배열 또는 항목의 타입이 지정된 Collection 구현체)

		int i = 0;

		for (StudentScore score : scoreList) {
			System.out.println(i++ + " " + score);
		}
	}

	private static void executeDelete(final int no) {

		if (no >= 0 && no < scoreList.size()) {
			scoreList.remove(no);
			System.out.println("삭제 하였습니다.");
		} else {
			System.out.println("유효하지 않는 번호입니다.");
		}
	}

	private static void executeUpdate(final int no) {

		if (no >= 0 && no < scoreList.size()) {
			StudentScore score = scoreList.get(no);
			System.out.print("이름(" + score.name + "):");
			String input = scanner.nextLine();
			StudentScore temp = new StudentScore(input);

			System.out.print("국어(" + score.kor + "):");
			input = scanner.nextLine();
			temp.kor = Integer.parseInt(input);

			System.out.print("영어(" + score.eng + "):");
			input = scanner.nextLine();
			temp.eng = Integer.parseInt(input);

			System.out.print("수학(" + score.math + "):");
			input = scanner.nextLine();
			temp.math = Integer.parseInt(input);

			System.out.print("변경하시겠습니까?(y/n)");
			input = scanner.nextLine();
			if ("y".equals(input.toLowerCase())) {
				scoreList.set(no, temp);
				System.out.println("변경되었습니다.");
			} else {
				System.out.println("변경 취소하였습니다.");
			}
		} else {
			System.out.println("유효하지 않은 번호입니다.");
		}
	}

	private static void executeSave() {

		try {
			FileWriter out = new FileWriter("studentScore.data");
			for (StudentScore score : scoreList) {
				out.write(score.toString() + "\n");
			}
			out.close();
			System.out.println("저장되었습니다.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static void executeLoad() {

		try {
			FileReader in = new FileReader("studentScore.data");
			Scanner s = new Scanner(in);

			while (true) {
				try {
					scoreList.add(StudentScore.fromCSV(s.nextLine()));
				} catch (NoSuchElementException ex) {
					break;
				}
			}
			s.close();
			in.close();
			System.out.println("로딩되었습니다.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void execute() {

		do {

			String[] values = promptCommand();

			if ("add".equals(values[0])) {
				executeAdd(values[1]);
			} else if ("list".endsWith(values[0])) {
				executeList();
			} else if ("delete".equals(values[0])) {
				executeDelete(Integer.parseInt(values[1]));
			} else if ("update".equals(values[0])) {
				executeUpdate(Integer.parseInt(values[1]));
			} else if ("load".equals(values[0])) {
				executeLoad();
			} else if ("save".equals(values[0])) {
				executeSave();
			} else if ("menu".equals(values[0])) {
				break;
			} else {
				System.out.println("사용할 수 없는 명령어 입니다.");
			}
		} while (true);
	}
	
	private static String[] promptCommand() {
		
		System.out.println("-------------------------");
		System.out.println("add : 점수 등록");
		System.out.println("list : 점수 조회");
		System.out.println("delete no : 점수정보 삭제");
		System.out.println("update no : 점수정보 변경");
		System.out.println("save : 점수정보 저장하기");
		System.out.println("load : 점수정보 불러오기");
		System.out.println("menu : 뒤로가기");
		System.out.println("-------------------------");
		System.out.println();
		System.out.print("점수관리 명령 >>> ");
		
		String input = scanner.nextLine();

		return input.toLowerCase().split(" ");
	}
	
	
}
