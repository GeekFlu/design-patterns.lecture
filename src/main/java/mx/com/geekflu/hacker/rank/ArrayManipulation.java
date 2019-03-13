package mx.com.geekflu.hacker.rank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/**
 * 
 * @author luisgonz

IN:
5 3
1 2 100
2 5 100
3 4 100

OUT:
200
 
 *
 *
 *
 */
public class ArrayManipulation {

	// Complete the arrayManipulation function below.
	static long arrayManipulation(int n, int[][] queries) {
		// n number of array size
		long[] arr = new long[n + 1];
		int m = queries.length;
		for (int row = 0; row < m; row++) {
			int a = queries[row][0];
			int b = queries[row][1];
			int k = queries[row][2];
			arr[a - 1] += k;
			arr[b] -= k;
		}
		long sum = 0;
		long max = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			max = Math.max(max, sum);
		}
		return max;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("array-manipulation.txt"));

		String[] nm = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nm[0]);

		int m = Integer.parseInt(nm[1]);

		int[][] queries = new int[m][3];

		for (int i = 0; i < m; i++) {
			String[] queriesRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 3; j++) {
				int queriesItem = Integer.parseInt(queriesRowItems[j]);
				queries[i][j] = queriesItem;
			}
		}

		long result = arrayManipulation(n, queries);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
