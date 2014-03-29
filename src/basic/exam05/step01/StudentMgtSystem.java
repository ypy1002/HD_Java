package basic.exam05.step01;

//	fileReader 사용
//		-	문자 데이터를 읽어들일 때 사용하는 클래스
//		-	문자 데이터 읽기에 관련된 메서드가 들어있다.
//		-	바이너리 데이터(메모장에서 편집 불가 데이터)의 읽기는 FileInputStream 클래스 사용

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentMgtSystem {

	static Scanner scanner = new Scanner(System.in);

	// ArrayList에 저장할 인스턴스의 타입을 지정

	private static ArrayList<StudentScore> scoreList = new ArrayList<StudentScore>();
	private static int scoreSize;

	private static String[] promptCommand() {

		System.out.print("명령>");
		String input = scanner.nextLine();

		return input.split(" ");
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

	public static void executeList() {

		// ArrayList로부터 data를 꺼낸다.
		// for(변수 : 배열 또는 항목의 타입이 지정된 Collection 구현체)

		int i = 0;

		for (StudentScore score : scoreList) {
			System.out.println(i++ + " " + score);
		}
	}

	private static void executeDelete(int no) {

		if (no >= 0 && no < scoreList.size()) {
			scoreList.remove(no);
			System.out.println("삭제 하였습니다.");
		} else {
			System.out.println("유효하지 않는 번호입니다.");
		}
	}

	private static void executeUpdate(int no) {

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

	public static void executeSave() {

		try {
			FileWriter out = new FileWriter("student.data");
			for (StudentScore score : scoreList) {
				out.write(score.toString() + "\n");
			}
			out.close();
			System.out.println("저장되었습니다.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void executeLoad() {

		try {
			FileReader in = new FileReader("student.data");
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

	public static void main(String[] args) {

		do {

			String[] values = promptCommand();

			if ("add".equals(values[0].toLowerCase())) {
				executeAdd(values[1]);
			} else if ("list".endsWith(values[0].toLowerCase())) {
				executeList();
			} else if ("delete".equals(values[0].toLowerCase())) {
				executeDelete(Integer.parseInt(values[1]));
			} else if ("update".equals(values[0].toLowerCase())) {
				executeUpdate(Integer.parseInt(values[1]));
			} else if ("load".equals(values[0].toLowerCase())) {
				executeLoad();
			} else if ("save".equals(values[0].toLowerCase())) {
				executeSave();
			} else if ("quit".equals(values[0].toLowerCase())) {
				break;
			} else {
				System.out.println("사용할 수 없는 명령어 입니다.");
			}
		} while (true);

		scanner.close();
	}

}