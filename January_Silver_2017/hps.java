package January_Silver_2017;
import java.util.*;
import java.io.*;

public class hps {

	public static void main(String[] args) throws IOException {
//		BufferedReader f = new BufferedReader(new FileReader("/Users/Bala/eclipse-workspace/USACO/src/test.in"));
//	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/Bala/eclipse-workspace/USACO/src/test.out")));
	    
	    BufferedReader f = new BufferedReader(new FileReader("hps.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
	    
	    StringTokenizer st = new StringTokenizer(f.readLine());
	    
	    int N = Integer.parseInt(st.nextToken());
	    int[] paper = new int[N];
	    int[] scissors = new int[N];
	    int[] hoof = new int[N];
	    
	    for (int i = 0; i < N; i++) {
	    		st = new StringTokenizer(f.readLine());
	    		String move = st.nextToken();
	    		if (move.equals("P")) {
	    			if (i == 0) {
	    				paper[i] = 1;
	    				scissors[i] = 0;
	    				hoof[i] = 0;
	    				
	    			} else {
	    				paper[i] = paper[i-1] + 1;
	    				scissors[i] = scissors[i-1];
	    				hoof[i] = hoof[i-1];
	    			}
	    		} else if (move.equals("S")) {
	    			if (i == 0) {
	    				paper[i] = 0;
	    				scissors[i] = 1;
	    				hoof[i] = 0;
	    			} else {
	    				paper[i] = paper[i-1];
	    				scissors[i] = scissors[i-1] + 1;
	    				hoof[i] = hoof[i-1];
	    			}
	    		} else {
	    			if (i == 0) {
	    				paper[i] = 0;
	    				scissors[i] = 0;
	    				hoof[i] = 1;
	    			} else {
	    				paper[i] = paper[i-1];
	    				scissors[i] = scissors[i-1];
	    				hoof[i] = hoof[i-1] + 1;
	    			}
	    		}
	    }
	    
	    int max = 0;
	    for (int i = 0; i < N; i++) {
	    		if (paper[i] + scissors[N-1] - scissors[i] > max) {
	    			max = paper[i] + scissors[N-1] - scissors[i];
	    		}
	    		
	    		if (paper[i] + hoof[N-1] - hoof[i] > max) {
	    			max = paper[i] + hoof[N-1] - hoof[i];
	    		}
	    		
	    		if (scissors[i] + paper[N-1] - paper[i] > max) {
	    			max = scissors[i] + paper[N-1] - paper[i];
	    		}
	    		
	    		if (scissors[i] + hoof[N-1] - hoof[i] > max) {
	    			max = scissors[i] + hoof[N-1] - hoof[i];
	    		}
	    		
	    		if (hoof[i] + paper[N-1] - paper[i] > max) {
	    			max = hoof[i] + paper[N-1] - paper[i];
	    		}
	    		
	    		if (hoof[i] + scissors[N-1] - scissors[i] > max) {
	    			max = hoof[i] + scissors[N-1] - scissors[i];
	    		}
	    }
	    
	    if (hoof[N-1] > max) {
	    		max = hoof[N-1];
	    }
	    
	    if (scissors[N-1] > max) {
	    		max = scissors[N-1];
	    }
	    
	    if (paper[N-1] > max) {
	    		max = paper[N-1];
	    }
	    
	    out.println(max);
	    out.close();
	    
	}

}
