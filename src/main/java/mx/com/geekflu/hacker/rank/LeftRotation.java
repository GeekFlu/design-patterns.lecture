package mx.com.geekflu.hacker.rank;

import java.util.Scanner;

public class LeftRotation {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[] nd = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nd[0]);

		int d = Integer.parseInt(nd[1]);

		int[] a = new int[n];

		String[] aItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int aItem = Integer.parseInt(aItems[i]);
			a[i] = aItem;
		}

		leftRotation(a, d);
		printArr(a);
		scanner.close();
	}

	static void leftRotation(int[] arr, int numSteps2Left) {
		if (numSteps2Left == arr.length) {
			printArr(arr);
		} else {

			for (int i = 0; i < numSteps2Left; i++) {
				leftRotate(arr);
			}

		}
	}

	static void leftRotate(int[] arr) {
		int temp = arr[0];
		int j = 0;
		for (j = 0; j < arr.length - 1; j++) {
			arr[j] = arr[j + 1];
		}
		arr[j] = temp;
	}

	static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(" ");
		}
	}
}
