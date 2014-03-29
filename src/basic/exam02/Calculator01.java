package basic.exam02;


//	함수 선언
//		- 객체지향에서는 함수 -> 메서드라는 용어를 사용
//		-	procedure(프로시저) -> function(함수) -> method(메서드)

//		-	문법
//			- 접근제어 리턴유형값 메서드명(파라미터 선언들){}

//		-	접근제어
//			-	(default)	:	같은 패키지 회원(member)는 접근 가능
//			-	public		:	모두 접근 가능
//			- protected : 같은 패키지 회원 + 자식 클래스 접근가능
//			- private   : 클래스 내에서만 사용가능

//	클래스 멤버 선언
//		-	static 키워드 사용
//		-	즉, 클래스 멤버임을 선언한다
//		- static이 없으면 객체멤버이다.

//	클래스 멤버 메서드 호출
//		-	클래스명.메서드명();


public class Calculator01 {

	public static int plus(int a , int b){
		return a + b;
	}
	
	public static int minus(int a , int b){
		return a - b;
	}
	
	public static int multiple(int a , int b){
		return a * b;
	}
	
	public static int divide(int a , int b){
		return a / b;
	}
}
