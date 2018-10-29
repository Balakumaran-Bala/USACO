package January_Gold_2017;
import java.util.*;
import java.io.*;

public class bphoto {

	public static class Pair implements Comparable<Pair> {
		int num;
		int id;
		
		public Pair(int n, int d) {
			num = n;
			id = d;
		}
		
		public int compareTo(Pair p) {
			return this.num - p.num;
		}
	}
	
	public static int getSum(int[] bit, int index) {
		int sum = 0;
		for (int x = index; x > 0; x -= x&(-x)) {
			sum += bit[x];
		}
		
		return sum;
	}
	
	public static void update(int[] bit, int val, int index) {
		for (int x = index; x < bit.length; x += x & (-x)) {
			bit[x] += val;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("bphoto.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bphoto.out")));
	    
	    StringTokenizer st = new StringTokenizer(f.readLine());

	    int n = Integer.parseInt(st.nextToken());
	    Pair[] cows = new Pair[n];	    
	    
	    
	    for (int i = 0; i < n; i++) {
	    		st = new StringTokenizer(f.readLine());
	    		int height = Integer.parseInt(st.nextToken());
	    		Pair p = new Pair(height, i+1);
	    		cows[i] = p;
	    }
	    
	    Arrays.sort(cows);
	    
	    int[] heights = new int[n];
	    for (int i = 0; i < cows.length; i++) {
	    		heights[cows[i].id - 1] = i+1;
	    }
	    
	    int[] BITRight = new int[heights.length+1];		
		int[] greaterLeft = new int[heights.length];
		
		for (int i = 0; i < heights.length; i++) {
			greaterLeft[i] +=  i - getSum(BITRight, heights[i]);
			update(BITRight, 1, heights[i]);
		}
		
		int[] BITLeft = new int[heights.length+1];
		int[] greaterRight = new int[heights.length];
		
		for (int i = heights.length - 1; i >= 0; i--) {
			greaterRight[i] += heights.length - i - getSum(BITLeft, heights[i]) - 1;
			update(BITLeft, 1, heights[i]);
		}
		
		int unbalanced = 0;
		for (int i = 0; i < greaterLeft.length; i++) {
			
			if (Math.max(greaterLeft[i], greaterRight[i]) > 2*Math.min(greaterLeft[i], greaterRight[i]))
				unbalanced++;
		}
		
		out.println(unbalanced);
		out.close();
	}

}
