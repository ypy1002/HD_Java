package basic.exam02;


//	인스턴스 메서드의 사용



public class Test05 {
	public static void main(String[] args) {
		
		// 10 + 30 - 4 * 7 (연산자 우선순위 고려하지 않음)
		// 5 * 3 - 6 / 3
		
		// 인스턴스 생성
		
		Calculator05 calc1 = new Calculator05(10);
		Calculator05 calc2 = new Calculator05();
		
		calc2.init(5);
	
		calc1.plus(30);
		calc2.multiple(3);
		
		calc1.minus(4);
		calc2.minus(7);

		calc1.multiple(7);
		calc2.divide(3);
		
		System.out.println(calc1.result);
		System.out.println(calc2.result);
		
	}
}