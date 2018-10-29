package February_Silver_2018;
import java.util.*;
import java.io.*;
import java.math.BigInteger;

///Users/Bala/eclipse-workspace/USACO/src/test.in
public class reststops {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("reststops.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("reststops.out")));
	    
	    StringTokenizer st = new StringTokenizer(f.readLine());
	    int l = Integer.parseInt(st.nextToken());
	    int n = Integer.parseInt(st.nextToken());
	    int rf = Integer.parseInt(st.nextToken());
	    int rb = Integer.parseInt(st.nextToken());
	    
	    int diff = rf - rb;
	    int[] nl = new int[l];
	    for (int i = 0; i < n; i++) {
	    		st = new StringTokenizer(f.readLine());
	    		int x = Integer.parseInt(st.nextToken());
	    		int c = Integer.parseInt(st.nextToken());
	    		nl[x] = c;
	    }
	    
	    int[] maxes = new int[l];
	    int max = nl[l-1];
	    for (int i = maxes.length-1; i >= 0; i--) {
	    		if (nl[i] > max) {
	    			maxes[i] = nl[i];
	    			max = nl[i];
	    		} else {
	    			maxes[i] = max;
	    		}
	    }

	    int time = 0;
	    BigInteger taste = new BigInteger("0");
	    for (int i = 1; i < nl.length; i++) {
	    		if (nl[i] != nl[i-1]) {
	    			BigInteger t = BigInteger.valueOf(i - time - 1);
	    			BigInteger d = BigInteger.valueOf(diff);
	    			BigInteger m = BigInteger.valueOf(maxes[i-1]);
	    			BigInteger temp = t.multiply(d);
	    			BigInteger temp2 = temp.multiply(m);
	    			BigInteger lol = taste.add(temp2);
	    			taste = lol;
	    			time = i-1;
	    		}
	    }
	    
	    BigInteger t = BigInteger.valueOf(l - time - 1);
		BigInteger d = BigInteger.valueOf(diff);
		BigInteger m = BigInteger.valueOf(maxes[l-1]);
		BigInteger temp = t.multiply(d);
		BigInteger temp2 = temp.multiply(m);
		BigInteger lol = taste.add(temp2);
		taste = lol;
	    out.println(taste);
	    
	    out.close();
	}

}
