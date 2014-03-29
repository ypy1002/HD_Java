package basic.exam05.step04;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentListControl {
	
	static Scanner scanner;
	
	private static ArrayList<StudentList> studentList = new ArrayList<StudentList>();
	
	static{
		scanner = StudentMgtSystem.scanner;
	}
	
	private static void executeAdd() {
		
		String[] input = new String[5];
		String yn;

		System.out.print("이름을 입력하세요 : ");
		input[0] = scanner.nextLine();
		
		System.out.print("나이를 입력하세요 : ");
		input[1] = scanner.nextLine();
		
		System.out.print("전화번호를 입력하세요 : ");
		input[2] = scanner.nextLine();
		
		System.out.print("이메일을 입력하세요 : ");
		input[3] = scanner.nextLine();
		
		System.out.print("주소를 입력하세요 : ");
		input[4] = scanner.nextLine();
		
		StudentList student = StudentList.fromCSV(input);
		
		System.out.println();
		System.out.println("입력하신 학생정보입니다.");
		System.out.println();

		System.out.println("이름 : " + student.name);
		System.out.println("나이 : " + student.age);
		System.out.println("전화번호 : " + student.tel);
		System.out.println("이메일 : " + student.email);
		System.out.println("주소 : " + student.address);

		System.out.print("등록하시겠습니까 ? (y/n)");
		yn = scanner.nextLine().toLowerCase();

		if ("y".equals(yn)) {
			studentList.add(student);
			
			System.out.println("등록 되었습니다.");
		} else {
			System.out.println("등록 취소하였습니다.");
		}
	}
	
	private static void executeList() {

		int i = 0;

		for (StudentList student : studentList) {
			System.out.println(i++ + "  " + student);
		}
	}
	
	private static void executeDelete(final int no) {

		if (no >= 0 && no < studentList.size()) {
			studentList.remove(no);
			System.out.println("삭제 하였습니다.");
		} else {
			System.out.println("유효하지 않는 번호입니다.");
		}
	}
	
	private static void executeUpdate(final int no) {

		if (no >= 0 && no < studentList.size()) {
			StudentList list = studentList.get(no);
			System.out.print("이름(" + list.name + "):");
			String name = scanner.nextLine();

			System.out.print("나이(" + list.age + "):");
			int age = Integer.parseInt(scanner.nextLine());

			System.out.print("전화번호(" + list.tel + "):");
			String tel = scanner.nextLine();

			System.out.print("이메일(" + list.email + "):");
			String email = scanner.nextLine();
			
			System.out.print("주소(" + list.email + "):");
			String address = scanner.nextLine();

			System.out.print("변경하시겠습니까?(y/n)");
			String input = scanner.nextLine().toLowerCase();
			
			if("y".equals(input)){
				list.name = name;
				list.age = age;
				list.tel = tel;
				list.email = email;
				list.address = address;
				System.out.println("학생정보가 변경되었습니다.");
			}else{
				System.out.println("학생정보 변경이 취소되었습니다.");
			}
		} else {
			System.out.println("유효하지 않은 번호입니다.");
		}
	}
	
	private static void executeSave() {

		try {
			FileWriter out = new FileWriter("studentList.data");
			for (StudentList score : studentList) {
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
			FileReader in = new FileReader("studentList.data");
			Scanner s = new Scanner(in);

			while (true) {
				try {
					studentList.add(StudentList.fromCSV(s.nextLine()));
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
				executeAdd();
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
		System.out.println("add : 학생정보 등록");
		System.out.println("list : 학생정보 조회");
		System.out.println("delete no : 학생정보 삭제");
		System.out.println("update no : 학생정보 변경");
		System.out.println("save : 학생정보 저장하기");
		System.out.println("load : 학생정보 불러오기");
		System.out.println("menu : 뒤로가기");
		System.out.println("-------------------------");
		System.out.println();
		System.out.print("학생관리 명령 >>> ");
	
		String input = scanner.nextLine();

		return input.toLowerCase().split(" ");
	}
	
}
