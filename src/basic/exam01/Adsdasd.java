package basic.exam01;

public class Adsdasd {
	public static void main(String[] args) {

		int[] arr = { 4, 5, 7, 10, 8, 2, 12, 6, 13, 9, 0, 11, 1, 3, 14 };

		int a = 0;
		int b = 0;

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr.length - 1 - i; j++) {

				if (arr[j] > arr[j + 1]) {
					a = arr[j];
					b = arr[j + 1];
					arr[j] = b;
					arr[j + 1] = a;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}