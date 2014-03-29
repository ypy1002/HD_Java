package basic.exam05.step02;


//	상속
//		-	

public class Episode01 {
	
	static class Car {
		
		String name = "자동차";
		int 	 cc = 1998;
		
		public Car() {
			//	super();  자동으로 붙는다.	즉, Object의 생성자 호출
			System.out.println("Car()...");
			name = "자동차 하하";
			cc = 2000;
		}
		
		public void start()	{
			System.out.println("출발한다.");
		}
		
		public void run()	{
			System.out.println("가속한다.");
		}
		
		public void stop() {
			System.out.println("멈춘다.");
		}
	}
	
	static class Truck extends Car {
		int	weight;
		
		public Truck() {
			
			//	super 클래스의 생성자 호출
			//	super(); 문장 이전에 다른 명령이 와서는 안된다.
			//	int i = 0; 에러!
			
			super();	//	생략하면 자동으로 생성된다. 모든 생성자는 반드시 있다.
			System.out.println("Truck()....");
			weight = 10000;
		}
		
		public void dump() {
			System.out.println("짐은 내리다");
			weight = 0;
		}
	}
	
	public static void main(String[] args) {
		
		Truck t = new Truck();
		
		System.out.println(t.name);
		System.out.println(t.cc);
		System.out.println(t.weight);
		
		System.out.println("완료!");
		
		t.dump();
		t.start();
		t.run();
		
		//	instance 생성 단계
		//		1) super 클래스를 찾아서 로딩
		//		2) 생성하려는 클래스를 찾아서 로딩
		//		3) super 클래스의 인스턴스 변수 준비
		//		4) 해당 클래스의 인스턴스 변수 준비
		//		5) super 클래스의 인스턴스 변수 초기화 문장 수행
		//		6) 해당 클래스의 인스턴스 변수 초기화 문장 수행
		
	}
}
