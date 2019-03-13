package mx.com.geekflu.hacker.rank;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SockMerchant {
	private static final Integer INCOMPLETE = 0;
	private static final Integer COMPLETE = 1;
	
	// Complete the sockMerchant function below.
	static int sockMerchant(int n, int[] ar) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int complePairs = 0;
        for(int i = 0 ; i < n; i++){
        	int o = ar[i];
            if(!map.containsKey(o)) {
            	map.put(o, INCOMPLETE);
            }else if(map.containsKey(o) && 
            		map.get(o) == INCOMPLETE) {
            	complePairs++;
            	map.remove(o);
            }
        }
        return complePairs;
    }


	public static void main(String[] args) throws IOException {
		int n = 9;
		int[] ar = new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20};
		int result = sockMerchant(n, ar);
		System.out.println(result);
	}
}
