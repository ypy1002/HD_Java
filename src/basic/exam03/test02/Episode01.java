package basic.exam03.test02;


//	다형성 : 다형적 변수
//		-	super class의 참조 변수는 sub class의 인스턴스 주소를 저장할 수 있다.
//		- super class의 참조 변수는 sub class의 인스턴스를 가리킬 수 있다.
//		- super class의 참조 변수는 sub class 객체를 가리킬 수 있다.


class Animal /* extends Object */ {
	
}



class Car /* extends Object */ {
	
	public void move(){}
	public void stop(){}
	public void start(){}
}

class Truck extends Car {
	
	int caparity;
	
	public void dump(){}
	public void load(){}
}

class Sedan extends Car {
	
	boolean sunroof;
	int trunkSize;
	
	public void changeAutoGear(){}
}

class Bongo extends Truck {
	
	boolean isABS;
}

class Tico extends Sedan {
	
}



public class Episode01 {
	
	public static void main(String[] args) {
		
		Car c = new Truck();
		
		c.start();
		c.move();
		c.stop();
//	c.load();		컴파일러가 허락하지 않는다. 컴파일러는 융통성이 없다. 글자 그대로 해석하여 판단.
//	c.dump();
		
		//	형변환을 통해 원래 class의 메서드를 호출할 수 있다.
		//	-	임시 주소 변수를 만들어 저장한다.
		
		((Truck)c).load();
		
		Car c2 = new Car();
		
		//	((Truck)c2).load();	//	Car가 Truck이 되겠다니!! 에러!
		//	((Truck)c2).dump();
	}
	
	public static void main02(String[] args) {
		
		//	어떤 참조변수가 sub class의 인스턴스는 가리킬 수 있어도 super class의 인스턴스를 못 가리키는 이유 ?
		
		Car c = new Car();
		
		c.start();
		c.move();
		c.stop();
		
		//	sub class는 super class의 모든 기능을 갖고 있기 때문에
		//	super class 참조 변수를 통해 super class의 모든 메서드를 호출할 수 있다.
		
		Car c2 = new Truck();
		
		c2.start();
		c2.move();
		c2.stop();
		
		Car c3 = new Tico();
		
		c3.start();
		c3.move();
		c3.stop();
		
		Truck c4 = new Truck();
		
		c4.start();
		c4.move();
		c4.stop();
		c4.dump();
		c4.load();
		
		Truck c5 = new Bongo();
		
		c5.start();
		c5.move();
		c5.stop();
		c5.dump();
		c5.load();
		
		//	만약 super class의 인스턴스를 가리키는 것이 허용된다면 ?
		//	존재하지 않는 메서드를 호출할 가능성이 있기때문에 아래의 문법을 허락하지 않는다.
		
		/*
		Truck c6 = new Car();
		c6.start();	//	Car
		c6.move();	//	Car
		c6.stop();	//	Car
		c6.dump();	//  Truck메서드로	Car에 존재하지 않는다.
		c6.load();	//  Truck메서드로	Car에 존재하지 않는다.
		*/
		
	}
	
	
	public static void main01(String[] args) {
		
		//	어떤 자바 객체라도 가리키기
		
		Object obj;
		obj = new Animal();
		obj = new Car();
		obj = new Tico();
		
		//	모든 동물을 가리킨다.
		
		Animal a;
		
		
		//	모든 자동차를 가리킨다.
		
		Car c;
		
		c = new Car();
		c = new Truck();
		c = new Sedan();
		c = new Bongo();
		c = new Tico();
		
		
		//	승용차만 가리킨다.
		
		Sedan c2;
		
		c2 = new Sedan();
		c2 = new Tico();
		
		//	c2 = new Bongo();	에러!!
		
	}
}