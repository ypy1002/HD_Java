package basic.exam05.step03.ex;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentListControl {
	
	static Scanner scanner;

	private static ArrayList<StudentList> studentList = new ArrayList<StudentList>();
	
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

	private static void executeAdd() {
		
		String[] student = new String[5];
		
		System.out.print("이름을 입력해주세요 : ");
		student[0] = scanner.nextLine();
		
		System.out.print("나이를 입력해주세요 : ");
		student[1] = scanner.nextLine();
		
		System.out.print("전화번호를 입력해주세요 : ");
		student[2] = scanner.nextLine();
		
		System.out.print("이메일을 입력해주세요 : ");
		student[3] = scanner.nextLine();
		
		System.out.print("주소를 입력해주세요 : ");
		student[4] = scanner.nextLine();

		StudentList list = StudentList.fromCSV(student);

		System.out.println("이름 : " + list.name);
		System.out.println("나이 : " + list.age);
		System.out.println("전화 : " + list.tel);
		System.out.println("메일 : " + list.email);
		System.out.println("주소 : " + list.address);

		System.out.print("등록하시겠습니까 ? (y/n) : ");

		String input = scanner.nextLine().toLowerCase();

		if ("y".equals(input)) {
			studentList.add(list);
			System.out.println("등록 되었습니다.");
		} else {
			System.out.println("등록 취소되었습니다.");
		}
	}

	public static void executeList() {

		int i = 0;

		for (StudentList list : studentList) {
			System.out.println(i++ + "번 : " + list);
		}
	}

	public static void executeDelete(int no) {

		int i = 0;

		if (no > -1 && no < studentList.size()) {
			studentList.remove(no);
			System.out.println(no + "번 학생정보가 삭제되었습니다.");

			for (StudentList list : studentList) {
				System.out.println(i++ + "번 : " + list);
			}
		} else {
			System.out.println("유효하지 않는 학생번호입니다.");
		}
	}

	public static void executeUpdate(int no) {

		if (no > -1 && no < studentList.size()) {
			StudentList list = studentList.get(no);

			System.out.print("이름(" + list.name + ") - 변경할 이름은 ? ");
			String name = " " + scanner.nextLine() + " ";

			System.out.print("나이(" + list.age + ") - 변경할 나이는 ? ");
			int age = Integer.parseInt(" " + scanner.nextLine() +  " ");

			System.out.print("전화(" + list.tel + ") - 변경할 전화번호는 ? ");
			String tel = scanner.nextLine();

			System.out.print("메일(" + list.email + ") - 변경할 이메일은 ? ");
			String email = scanner.nextLine();
			
			System.out.print("주소(" + list.address + ") - 변경할 주소는 ? ");
			String address = scanner.nextLine();

			System.out.print("정보를 변경하시겠습니까 ? (y/n) : ");
			String input = scanner.nextLine().toLowerCase();

			if ("y".equals(input)) {

				list.name = name;
				list.age = age;
				list.tel = tel;
				list.email = email;
				list.address = address;
				System.out.println("학생정보가 변경되었습니다.");
				System.out.println(no + "번 : " + list);

			} else {
				System.out.println("학생정보 변경이 취소되었습니다.");
			}
		} else {
			System.out.println("유효하지 않는 학생번호입니다.");
		}
	}

	public static void executeSave() {

		try {
			FileWriter out = new FileWriter("stuList.data");

			for (StudentList list : studentList) {
				out.write(list.toString() + "\n");
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
			FileReader in = new FileReader("stuList.data");
			Scanner s = new Scanner(in);

			while (true) {
				try {
					studentList.add(StudentList.fromCSV(s.nextLine()));
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
				executeAdd();
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
			} else if ("q".equals(value[0])) {
				break;
			} else {
				System.out.println("잘못된 명령어입니다.");
			}
		}
	}
}
