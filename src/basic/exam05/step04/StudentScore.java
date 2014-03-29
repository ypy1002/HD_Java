package basic.exam05.step04;

//	콤마(,)로 구분된 문자열 데이터(comma seperated value; csv)로부터 인스턴스 생성하기
//		-	클래스 메서드(static method)의 활용사례 공부
//		-	데이터 항목이 추가되거나, 문자열의 표현순서가 바뀌더라도 소스코드를 유지보수하기 쉽다.

public class StudentScore {

  String name;
	int kor;
	int eng;
	int math;

	public StudentScore(String name) {
		this.name = name;
	}
	
	//	클래스 메서드
	//		-	특정 인스턴스를 위해 작업하지 않는다.
	//		-	모든 인스턴스를 대상으로 공통 작업을 수행한다.
	//		-	this변수를 사용하지 않는 메서드라면 인스턴스 메서드일 필요가없다.
	//		-	static을 사용하여 클래스 메서드로 만들어주자
	
	public static StudentScore fromCSV(String value) {
		
		String[] data = value.split(" , ");

		StudentScore obj = new StudentScore(data[0]);

		obj.kor = Integer.parseInt(data[1]);
		obj.eng = Integer.parseInt(data[2]);
		obj.math = Integer.parseInt(data[3]);
		
		return obj;
	}

	@Override
	public String toString() {
		return name + " , " + kor + " , " + eng + " , " + math;
	}
}
