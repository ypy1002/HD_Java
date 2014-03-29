package basic.exam05.step03;

public class StudentList {

	String name;
	int age;
	String tel;
	String email;
	String address;

	public StudentList(String name) {
		this.name = name;
	}

	// 클래스 메서드
	// - 특정 인스턴스를 위해 작업하지 않는다.
	// - 모든 인스턴스를 대상으로 공통 작업을 수행한다.
	// - this변수를 사용하지 않는 메서드라면 인스턴스 메서드일 필요가없다.
	// - static을 사용하여 클래스 메서드로 만들어주자

	public static StudentList fromCSV(String[] value) {

		StudentList obj = new StudentList(value[0]);

		obj.age = Integer.parseInt(value[1]);
		obj.tel = value[2];
		obj.email = value[3];
		obj.address = value[4];

		return obj;
	}
	
	public static StudentList fromCSV(String value) {
		
		String data[] = value.split(" , ");

		StudentList obj = new StudentList(data[0]);

		obj.age = Integer.parseInt(data[1]);
		obj.tel = data[2];
		obj.email = data[3];
		obj.address = data[4];

		return obj;
	}

	@Override
	public String toString() {
		return name + " , " + age + " , " + tel + " , " + email + " , " + address;
	}
}
