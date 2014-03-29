package basic.exam03;

//	Object를 상속받는다고 명시하지않으면
//	extends Object가 자동으로 추가된다.
//	그러므로, java의 모든 클래스들은 Object의 자손이다.

//	상속을 받는다는 것!
//		-	상속받는 클래스의 메서드를 호출할 수 있다는 의미
//		-	상속해주는 클래스 => parent class , super class
//		-	상속받는 클래스 => child class , sub class

public class Student /* extends Object */{

	String name;
	int kor;
	int math;
	int eng;
	
	
	public Student(String name , int kor , int math , int eng){
		this.name = name;
		this.kor = kor;
		this.math	= math;
		this.eng = eng;
	}
}
