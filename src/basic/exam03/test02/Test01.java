package basic.exam03.test02;


//	문자열 만들기
//		-	C에서는 char[] 배열로 만든다.
//		-	자바에서도 char[] 배열로 만든다. --> 
//			내부의 복잡한 명령어를 감추고(캡슐화) --> 
//			java.lang.String 제공



public class Test01 {
	
	public static void main(String[] args) {
		
		//	String의 비교
		
		StringBuffer s1 = new StringBuffer("나는 홍길동이다.");
		StringBuffer s2 = new StringBuffer("나는 홍길동이다.");
		
		//	인스턴스가 같은지를 비교 => 주소가 같은지 비교
		
		if(s1 == s2){
			System.out.println("s1과 s2는 같다.");
		}
		
		//	Object에서 상속받은 equals()를 재정의 하지 않았기때문에 결과는 다르다.
		
		if(s1.equals(s2)){
			System.out.println("s1과 s2는 같다...");
		}else{
			System.out.println("s1과 s2는 다르다.");
		}
	}
	
	public static void main08(String[] args) {
		
		//	String의 비교
		
		String s1 = new String("나는 홍길동이다.");
		String s2 = new String("나는 홍길동이다.");
		
		//	인스턴스가 같은지를 비교 => 주소가 같은지 비교
		
		if(s1 == s2){
			System.out.println("s1과 s2는 같다.");
		}

		//	내용물이 같은지 비교 <-- String class에서 상속받은 equals()를 재정의하였기때문에 결과는 같다.
		
		if(s1.equals(s2)){
			System.out.println("s1과 s2는 같다...");
		}
	}
	
	public static void main07(String[] args) {
		
		//	Heap에 있는 String 인스턴스를 Constant Pool에 복제하기
		
		String s1 = new String("나는 홍길동이다.");
		
		String s2 = s1.intern();	//	heap영역에 있는 s1 data를 constant Pool에 복제
		String s3 = "나는 홍길동이다.";
		
		if(s2 == s3){
			System.out.println("s2와 s3는 같다");
		}
	}
	
	
	public static void main06(String[] args) {
		
		//	상수 String의 subString()	리턴 값 ?
		
		String s1 = "나는 홍길동이다.";
		String s2 = s1.substring(3);
		String s3 = s1.substring(3);
		
		//	상수 String의 subString은 heap영역에 안스턴스로 각각 저장되기때문에 결과는 다르다.
		
		if(s2 == s3){
			System.out.println("s2와 s3는 같다.");
		}else{
			System.out.println("s2와 s3는 다르다.");
		}
	}
	
	public static void main05(String[] args) {
		
		//	상수 String
		//		- new String() 의 단축 명령이다.
		//		- 상수 String으로 만든 인스턴스는 heap영역이 아닌 Constant Pool에 존재한다
		//		-	데이터가 저장되는 영역이 다름.
		//		- 중복해서 생성되지 않는다.	=> 메모리 절약위해
		
		String s1 = new String("나는 홍길동이다");
		String s2 = "나는 홍길동이다.";		//	new String("나는 홍길동이다."); 의 단축!  상수String이라한다.
		String s3 = "나는 홍길동이다.";
		
		System.out.println(s1);
		System.out.println(s2);
		
		if(s1 == s2){
			System.out.println("s2와 s3는 같다.");
		}
		
		if(s1 == s3){
			System.out.println("s2와 s3는 같다.");
		}
		
		if(s2 == s3){
			System.out.println("s2와 s3는 같다.");
		}
	}
	
	public static void main04(String[] args) {
		
		//	mutable vs immutable 테스트
		//	String 인스턴스의 값은 변경되지않는다. => immutable
		//	절대 변경이 안된다!!
		
		String s1 = new String("나는 홍길동이다");
		String s2 = s1.replace("홍길동", "임꺽정");	//	new String 인스턴스 생성 후 리턴
	
		System.out.println(s1);
		System.out.println(s2);
		
		//	String 인스턴스의 원본값을 변경하고 싶다면 StringBuffer를 사용하라
		
		StringBuffer s3 = new StringBuffer("나는 홍길동이다");
		s3.replace(3, 6, "임꺽정");
		
		System.out.println(s3);
	} 	
	
	public static void main03(String[] args) {
		
		String s1 = new String("나는 홍길동이다");
		System.out.println(s1.charAt(3));
		System.out.println(s1.indexOf("홍"));
		
		// String클래스에있는 indexOf 메서드를 호출하고 indexOf에 숨겨져있는 this라는 히든변수에 s1 문자열이 저장되있는 주소값을 저장하고,
		// 파라미터로 넘어온 '홍'이라는 글자를 this에 저장되있는 주소에서 찾아서 해당배열의 index를 출력하라.
		
		String s2 = s1.substring(3);	// new String 인스턴스를 사용하여 리턴
		String s3 = s1.substring(3);
		
		System.out.println(s2);
		System.out.println(s3);
		
		if(s2 == s3){
			System.out.println("s2와 s3는 같다.");
		}else{
			System.out.println("s2와 s3는 다르다.");
		}
		
		//	3번째 index부터 끝까지의 새로운 인스턴스를 만들어서 s2 , s3에 각각 저장되므로 주소값이 다르기때문에 결과는 다르다.
	} 	
	
	public static void main02(String[] args) {
		
		String s1 = new String("나는 홍길동이다");
		String s2 = new String("나는 홍길동이다");
		
		//	s1과 s2의 주소값이 다르기때문에 결과는 다르다.
		
		if(s1 == s2){
			System.out.println("s1과 s2는 같다");
		}else{
			System.out.println("s1과 s2는 다르다");
		}
	}

	public static void main01(String[] args) {
		
		String s1 = new String("나는 홍길동이다");
		String s2 = s1;
		String s3 = s2;
		
		System.out.println(s3);
	}
}
