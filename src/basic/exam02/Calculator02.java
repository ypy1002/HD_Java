package basic.exam02;


//	클래스 멤버 변수
//		-	static으로 선언된 변수
//		- 클래스가 준비될 때 자동으로 만들어진다.
//		- static 데이터 유형 변수명;

public class Calculator02 {
	
	public static int result;	//	static이 있으면 클래스가 로딩되면서 자동으로 변수가 생성됨.
	//	public int result;				static이 없으면 로딩되면서 자동으로 생성되는게 아닌, new 로 생성을 해줘야 생성됨. (인스턴스변수)
	
	public static void init(int v){
		result = v;
	}

	public static void plus(int v){
		result += v;
	}
	
	public static void minus(int v){
		result -= v;
	}
	
	public static void multiple(int v){
		result *= v;
	}
	
	public static void divide(int v){
		result /= v;
	}
}
