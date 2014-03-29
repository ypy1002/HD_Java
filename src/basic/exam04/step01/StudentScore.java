package basic.exam04.step01;

public class StudentScore {

	String name;
	int kor;
	int eng;
	int math;
	
	public StudentScore(String name) {
		this.name = name;
	}
	
	public static StudentScore fromCSV(String values){
		
		String data[]	= values.split(",");
		
		StudentScore score = new StudentScore(data[0]);
		
		score.kor = Integer.parseInt(data[1]);
		score.eng = Integer.parseInt(data[2]);
		score.math = Integer.parseInt(data[3]);
		
		return score;
	}
}