package December_Silver_2017;

import java.util.*;
import java.io.*;

public class shuffle {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("shuffle.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
	    
	    StringTokenizer st = new StringTokenizer(f.readLine());
	    
	    int N = Integer.parseInt(st.nextToken());
	    
	    int[] cows = new int[N+1];
		st = new StringTokenizer(f.readLine());
	    for (int i = 1; i < N+1; i++) {
	    		cows[i] = Integer.parseInt(st.nextToken());
	    }

	    
	    int total = 0;
	    int[] v = new int[N+1];
	    int[] temp = new int[N+1];
	    for (int i = 1; i < N+1; i++) {
	    		int cycleLength = 0;
	    		if (v[i] == 0) {
	    			int ptr = i;
	    			while (temp[ptr] != 1) {
	    				if (v[ptr] == 1) {
	    					cycleLength = 0;
	    					break;
	    				}
	    				
	    				temp[ptr] = 1;
	    				v[ptr] = 1;
	    				ptr = cows[ptr];
	    				cycleLength++;
	    			}
	    			
	    			int tempPtr = i;
	    			while (tempPtr != ptr) {
	    				tempPtr = cows[tempPtr];
	    				cycleLength--;
	    			}
	    			
	    			
	    		}

	    		//System.out.println(cycleLength);
	    		
	    		total += cycleLength;
	    }
	    
	    out.println(total);
	    out.close();
	}

}
