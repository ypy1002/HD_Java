package basic.exam02;

public class TvTest {
	public static void main(String[] args) {
		
		Tv tv1 = new Tv("tv1");
		Tv tv2 = new Tv("tv2");
		
		tv1.color(3);
		tv2.color(2);
		System.out.println();
		
		tv1.channal(2);
		tv2.channal(1);
		System.out.println();
		
		tv1.power();
		tv2.power();
		System.out.println();
		
		tv1.channal(3);
		tv2.channal(7);
		System.out.println();
		
		tv1.power();
		System.out.println();
		
		tv1.channalUp();
		System.out.println();
		
		tv2.volumeUp();
		tv2.volumeUp();
		tv2.volumeUp();
		tv2.volumeDown();
		tv2.volumeDown();
		System.out.println();
		
		tv1.power();
		System.out.println();
		
		tv1.volumeUp();
		tv1.volumeUp();
		System.out.println();
		
		tv2.power();
		System.out.println();
		
		tv2.volumeUp();
		tv2.volumeDown();
		System.out.println();
		
		tv1.power();
		System.out.println();
		
		tv1.volumeDown();
		System.out.println();
		
		System.out.println("tv1의 볼륨은 " + tv1.volume + "입니다.");
		System.out.println("tv2의 볼륨은 " + tv2.volume + "입니다.");
		System.out.println("tv1의 체널은 " + tv1.channal + "번 입니다.");
		System.out.println("tv2의 체널은 " + tv2.channal + "번 입니다.");
	}
}




