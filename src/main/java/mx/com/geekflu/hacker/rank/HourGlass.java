package mx.com.geekflu.hacker.rank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HourGlass {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int maxSum = -9999;
        for(int fila = 0 ; fila < 4 ; fila++){
        	for(int columna = 0; columna < 4; columna++) {
        		int hSum = arr[fila][columna] + arr[fila][columna + 1] + arr[fila][columna + 2];
        		hSum += arr[fila + 1][columna + 1];
        		hSum += arr[fila + 2][columna] + arr[fila + 2][columna + 1] + arr[fila + 2][columna + 2];
        		if(maxSum < hSum){
        			maxSum = hSum;
        		}
        	}
        }
        return maxSum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("hour-glass.txt"));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
