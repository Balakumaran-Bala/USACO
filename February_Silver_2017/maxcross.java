package February_Silver_2017;
import java.util.*;
import java.io.*;

///Users/Bala/eclipse-workspace/USACO/src/test.in
public class maxcross {

	public static void main(String[] args) throws IOException {
		
		//BufferedReader f = new BufferedReader(new FileReader("//Users/Bala/eclipse-workspace/USACO/src/test.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("//Users/Bala/eclipse-workspace/USACO/src/test.out")));
		
		BufferedReader f = new BufferedReader(new FileReader("maxcross.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("maxcross.out")));
		
		
	    StringTokenizer st = new StringTokenizer(f.readLine());
	    int N = Integer.parseInt(st.nextToken());
	    int K = Integer.parseInt(st.nextToken());
	    int B = Integer.parseInt(st.nextToken());
	    
	    int[] damaged = new int[N+1];
	    for (int i = 0; i < B; i++) {
	    		st = new StringTokenizer(f.readLine());
	    		int light = Integer.parseInt(st.nextToken());
	    		damaged[light] = 1;
	    }
	    
	    int[] prefixSum = new int[N+1];
	    int sum = 0;
	    for (int i = 0; i <= N; i++) {
	    		if (damaged[i] == 1)
	    			sum++;
	    		
	    		prefixSum[i] = sum;
	    }
	    
//	    for (int i = 1; i <= N; i++) {
//	    		System.out.println(prefixSum[i]);
//	    }

	    int min = Integer.MAX_VALUE;
	    for (int i = 1; i <= N - K + 1; i++) {
	    		int repairs = prefixSum[i+K-1] - prefixSum[i-1];
	    		if (repairs < min) {
	    			min = repairs;
	    		}
	    		//System.out.println(prefixSum[i+K-1] + " " + prefixSum[i-1]);
	    }
	    
	    //System.out.println(min);
	    out.println(min);
	    out.close();
	}

}
