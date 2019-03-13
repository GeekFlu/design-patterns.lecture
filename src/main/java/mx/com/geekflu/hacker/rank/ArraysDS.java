package mx.com.geekflu.hacker.rank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ArraysDS {

    // Complete the reverseArray function below.
    static int[] reverseArray(int[] a) {
        int[] e = new int[0];
        int front = 0;
        int back = 0;
        if(a == null || a.length == 0){
            a = e;
        }else{
            back = a.length - 1;
            while(front < back){
                swap(front, back, a);
                front++;
                back--;
            }
        }
        return a;
    }

    static void swap(int front, int back, int[] arr){
        int temp = arr[front];
        arr[front] = arr[back];
        arr[back] = temp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out-array-da.txt"));

        int arrCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[arrCount];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] res = reverseArray(arr);

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));

            if (i != res.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
