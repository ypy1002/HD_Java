package basic.exam03.test02;


//	기본 타입 랩퍼(Wrapper) 클래스
//	기본 타입의 값을 조금 더 정교하게 다룰 수 있도록 클래스를 제공한다.

//	byte => java.lang.Byte
//	short => java.lang.Short
//	char => java.lang.charactor
//	int => java.lang.integer
//	long => java.lang.long
//	float => java.lang.float
//	boolean => java.lang.boolean
//	double => java.lang.double

//	Wrapper Class는 equals()를 재정의하였다. => 내용을 비교할 수 있다.


public class Episode02 {
	
	public static void main(String[] args) {
		
		//	기본 데이터형과 Wrapper클래스 사이의 교류 : corss over
		//	"Auto-boxing" , "Auto-unboxing"
		//	기본 데이터형 변수과 Wrapper 객체 사이의 값을 교환하기가 불편함
		
		Integer i1 = new Integer(10);
		int i2 = i1.intValue();
		
		int i3 = 100;
		Integer i4 = new Integer(i3);
		
		//	*	기본 데이터형 <-> Wrapper객체 변환 자동화
		//	기본 데이터형의 값을 자동으로 Wrapper객체로 만드는 것 
		//		-> Wrapper객체에 보관
		//		-> Wrapper객체에 포장
		//		"Auto-boxing"
		
		Integer i5 = 20;	//	Wrapper객체로 자동포장 => new Integer(20)과 같다.
		
		//	Wrapper객체의 값을 기본 데이터형으로 뽑아내는 것
		//		-> Wrapper객체에 들어있는 값을 꺼냄
		//		-> Wrapper객체의 포장을 품
		//		-> "Auro-unboxing"
		
		int i6 = i5;	//	자동으로 포장 해제 - i5.intValue()와 같다.
		
	}
	
	public static void main01(String[] args) {
		
		//	Wrapper Class의 사용 : hashCode()	, equals() 재정의 여부 테스트
		
		Integer i1 = new Integer(10);
		Integer i2 = new Integer(10);
		
		System.out.println(i1.hashCode());
		System.out.println(i2.hashCode());
		
		if(i1 == i2){		//	인스턴스 주소가 다르기때문에 결과는 다르다.
			System.out.println("i1과 i2는 같다.");
		}else{
			System.out.println("i1과 i2는 다르다.");
		}
		
		if(i1.equals(i2)){		//	equals()를 재정의하였기떄문에 결과는 같다.
			System.out.println("i1과 i2는 같다.");
		}else{
			System.out.println("i1과 i2는 다르다.");
		}
	
	}
}