package basic.exam03;

public class StrudentTest {
	
	public static void main09(String[] args) {
		
		Student6 s1 = new Student6("홍길동" , 90 , 100 , 90);
		System.out.println("안녕~~");
		
		
	}
	
	public static void main05(String[] args) {
		
		//	getClass() 호출
		
		Student s1 = new Student("홍길동" , 90 , 100 , 90);
		Student5 s2 = new Student5("홍길동" , 90 , 100 , 90);
		
		Class c1 = s1.getClass();	//	s1 인스턴스를 생성할 때 사용한 Class정보를 리턴
		Class c2 = s2.getClass();	//	s1 인스턴스를 생성할 때 사용한 Class정보를 리턴
		
		System.out.println(c1.getName());
		System.out.println(c2.getName());
		
		//	클래스 정보를 바로 꺼내기
		//		-	클래스 정보를 가리키는 특별한 static 변수 'class'
		
		Class c3 = Student.class;
		Class c4 = Student5.class;
		
		System.out.println(c3);
		System.out.println(c4);
		
		if(c1 == c3){
			System.out.println("c1과 c3는 같다.");
		}else{
			System.out.println("c1과 c3는 다르다.");
		}
		
		if(c2 == c4){
			System.out.println("c2과 c4는 같다.");
		}else{
			System.out.println("c2과 c4는 다르다.");
		}
	}
	
	public static void main(String[] args) {
		
		//	hashCode() 재정의 전
		
		Student s1 = new Student("홍길동" , 90 , 100 , 90);
		Student s2 = new Student("홍길동" , 90 , 100 , 90);
		
		System.out.println(Integer.toHexString(s1.hashCode()));
		System.out.println(s1);
		System.out.println(Integer.toHexString(s2.hashCode()));
		System.out.println(s2);
		
		//	hashCode()와 toString() 재정의
		
		Student4 s3 = new Student4("홍길동" , 90 , 100 , 90);
		Student4 s4 = new Student4("홍길동" , 90 , 100 , 90);
		
		System.out.println(Integer.toHexString(s3.hashCode()));
		System.out.println(s3);
		System.out.println(Integer.toHexString(s4.hashCode()));
		System.out.println(s4);
	}
	
	public static void main03(String[] args) {
		
		//	toString() 사용하기
		
		Student2 s1 = new Student2("홍길동" , 90 , 100 , 90);
		
		//	println() 함수는 파라미터로 넘어온 인스턴스에 대해 toString() 메서드를 호출한다.
		//	그리고 toString()이 리턴한 문자열을 출력한다.
		//	toString()은 Object class의 메서드이다.
		//	출력형식 : fully qualified class name(QName) @ hash code
		//	-	hash code : 인스턴스 식별 번호이다.
		
		System.out.println(s1);
		
		Student3 s2 = new Student3("홍길동" , 90 , 100 , 90);
		System.out.println(s2);
	}
	
	public static void main02(String[] args) {
		
		//	Student2에서 재정의한 equals 사용하기
		
		Student2 s1 = new Student2("홍길동" , 90 , 100 , 90);
		Student2 s2 = new Student2("홍길동" , 90 , 100 , 90);
		
		if(s1 == s2){
			System.out.println("s1과 s2는 같다.");
		}
		
		if(s1.equals(s2)){	//	주소값 비교가 아닌 data를 비교하도록 equals()를 재정의하였으므로 결과는 같다 !!
			System.out.println("s1과 s2는 같다!!");
		}
	}

	public static void main01(String[] args) {
		
		//	Object로부터 상속받은 equals()는 == 연산자와 동일하게 동작한다.
		//	인스턴스 주소가 같은지 비교한다.
		
		Student s1 = new Student("홍길동" , 90 , 100 , 90);
		Student s2 = new Student("홍길동" , 90 , 100 , 90);
		
		if(s1 == s2){
			System.out.println("s1과 s2는 같다.");
		}
		
		if(s1.equals(s2)){	//	Object의 equals는 주소값을 비교하므로 결과는 다르다.
			System.out.println("s1과 s2는 같다!!");
		}else{
			System.out.println("s1과 s2는 다르다!!");
		}
	}
}