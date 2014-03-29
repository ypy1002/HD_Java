package basic.exam02;

public class Tv {
	
	
	String name;
	boolean power;
	int volume;
	int channal;
	String color;
	String[] colorSel = {"red" , "blue" , "yellow" , "orange" , "black"};
	
	public String toString() {
		return "현재" + this.name + "은 꺼져있습니다";
	}
	
	public Tv(String name) {
		this.name = name;
	}
	
	public void power(){
		power = !power;
		if(power == true){
			System.out.println( this.name + " ON");
		}else{
			System.out.println( this.name + " OFF");
		}
	}
	
	public void channal(int i){
		if(power == false){
			System.out.println( this.name + "은 꺼져있어 체널을 조작할 수 없습니다.");
		}else{
			channal = i;
			System.out.println( this.name + " channal : " + channal + "번");
		}
	}
	
	public void color(int i){
		color = colorSel[i];
		System.out.println( this.name + " color : " + color);
	}
	
	public void channalUp(){
		if(power == false){
			System.out.println( this.name + "은 꺼져있어 체널을 조작할 수 없습니다.");
		}else{
			channal++;
			System.out.println( this.name + " channal : " + channal + "번");
		}
	}
	
	public void channalDown(){
		if(power == false){
			System.out.println( this.name + "은 꺼져있어 체널을 조작할 수 없습니다.");
		}else{
			channal--;
			System.out.println( this.name + " channal : " + channal + "번");
		}
	}
	
	public void volumeUp(){
		if(power == false){
			System.out.println( this.name + "은 꺼져있어 볼륨을 조작할 수 없습니다.");
		}else{
			volume++;
			System.out.println( this.name + " volume : " + volume);
		}
	}
	
	public void volumeDown(){
		if(power == false){
			System.out.println( this.name + "은 꺼져있어 볼륨을 조작할 수 없습니다.");
		}else{
			volume--;
			System.out.println( this.name + " volume : " + volume);
		}
	}
}

