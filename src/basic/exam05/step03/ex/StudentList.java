package basic.exam05.step03.ex;

public class StudentList {

	String name;
	int age;
	String tel;
	String email;
	String address;
	
	public StudentList(String name){
		this.name = name;
	}
	
	public static StudentList fromCSV(String value){
		
		String[] data = value.split(",");
		
		StudentList score = new StudentList(data[0]);
		
		score.age = Integer.parseInt(data[1]);
		score.tel = data[2];
		score.email = data[3];
		score.address = data[4];
		
		return score;
	}
	
	public static StudentList fromCSV(String[] value){
		
		StudentList score = new StudentList(value[0]);
		
		score.age = Integer.parseInt(value[1]);
		score.tel = value[2];
		score.email = value[3];
		score.address = value[4];
		
		return score;
	}

	@Override
	public String toString() {
		return name + "," + age + "," + tel + "," + email + "," + address;
	}
	
	
}
