package basic.exam05.step03.ex;

public class StudentScore {

	String name;
	int kor;
	int eng;
	int math;
	
	public StudentScore(String name){
		this.name = name;
	}
	
	public static StudentScore fromCSV(String value){
		
		String[] data = value.split(",");
		
		StudentScore score = new StudentScore(data[0]);
		
		score.kor = Integer.parseInt(data[1]);
		score.eng = Integer.parseInt(data[2]);
		score.math = Integer.parseInt(data[3]);
		
		return score;
	}

	@Override
	public String toString() {
		return name + "," + kor + "," + eng + "," + math;
	}
	
	
}
