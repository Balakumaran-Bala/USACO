package December_Silver_2017;

import java.util.*;
import java.io.*;

public class measurement {

	public static class Entry implements Comparable<Entry> {
		long day;
		long cow;
		long milk;
		
		public Entry(long d, long c, long m) {
			day = d;
			cow = c;
			milk = m;
		}
		
		public int compareTo(Entry o) {
			return (int) (this.day - o.day);
		}
	}
	
	public static class pqEntry implements Comparable<pqEntry> {
		long cow;
		long milk;
		long updates;
		
		public pqEntry(long c, long m, long u) {
			cow = c;
			milk = m;
			updates = u;
		}
		
		public int compareTo(pqEntry o) {
			return (int) (this.milk - o.milk);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
	    
	    StringTokenizer st = new StringTokenizer(f.readLine());
	    int N = Integer.parseInt(st.nextToken());
	    long G = Integer.parseInt(st.nextToken());
	    
	    Entry[] log = new Entry[N];
	    for (int i = 0; i < N; i++) {
	    		st = new StringTokenizer(f.readLine());
	    		long d = Long.parseLong(st.nextToken());
	    		long c = Long.parseLong(st.nextToken());
	    		String diff = st.nextToken();
	    		long m;
	    		if (diff.charAt(0) == '+') {
	    			m = Long.parseLong(diff.substring(1, diff.length()));
	    		} else {
	    			m = -1 * Long.parseLong(diff.substring(1, diff.length()));
	    		}
	    		Entry e = new Entry(d, c, m);
	    		log[i] = e;
	    }
	    
	    Arrays.sort(log);
	    long total = 0;
	    
	    TreeMap<Long, Long> redBlackTree = new TreeMap<Long, Long>();
	    redBlackTree.put(G, (long) 100000);
	    HashMap<Long, Long> cowOutput = new HashMap<Long, Long>(); // maps cows to their milk output
	    for (Entry e : log) {
	    		if (cowOutput.containsKey(e.cow)) { // maps cows to the number of times they have been updated
	    			cowOutput.put(e.cow, cowOutput.get(e.cow) + e.milk);
	    		} else {
	    			cowOutput.put(e.cow, e.milk + G);
	    		}
	    		
	    		//System.out.println(e.day + " " + e.cow + " " + cowOutput.get(e.cow));
	    		// cowOutput.get(key) gives the milk output of the specific cow
	    		// redBlackTree has keys of milk outputs and values of a hashset of all cows that have that milk output
	    		long milkOutput = cowOutput.get(e.cow); // updated milk output of the current cow
	    			    		
	    		if (redBlackTree.lastKey() > milkOutput) { // output less than max
	    			redBlackTree.put(milkOutput - e.milk, redBlackTree.get(milkOutput - e.milk) - 1);
	    			if (redBlackTree.lastKey() == milkOutput - e.milk) { // if the previous value is = to max
		    			if (redBlackTree.get(milkOutput - e.milk) == 0) { // was it the only max 
		    				redBlackTree.remove(milkOutput - e.milk);
		    				if (milkOutput <= redBlackTree.lastKey()) // is it still the only max
		    					total++;
		    			} else {
			    			total++;
		    			}
	    			}
	    			
	    			if (redBlackTree.containsKey(milkOutput - e.milk) && redBlackTree.get(milkOutput - e.milk) == 0) { 
	    				redBlackTree.remove(milkOutput - e.milk);
	    			}
	    			if (redBlackTree.containsKey(milkOutput)) {
	    				redBlackTree.put(milkOutput, redBlackTree.get(milkOutput) + 1);
	    			} else {
	    				redBlackTree.put(milkOutput, (long) 1);
	    			}
	    			//System.out.println("a");
	    		} else if (milkOutput > redBlackTree.lastKey()) {
	    			redBlackTree.put(milkOutput - e.milk, redBlackTree.get(milkOutput - e.milk) - 1);
	    			if (redBlackTree.lastKey() == milkOutput - e.milk) {
		    			if (redBlackTree.get(milkOutput - e.milk) == 0) {
		    				redBlackTree.remove(milkOutput - e.milk);
		    			} else {
			    			total++;
		    			}
	    			} else {
	    				total++;
	    			}
	    			if (redBlackTree.containsKey(milkOutput - e.milk) && redBlackTree.get(milkOutput - e.milk) == 0) { 
	    				redBlackTree.remove(milkOutput - e.milk);
	    			}
	    			redBlackTree.put(milkOutput, (long) 1);
	    			//System.out.println("b");
	    		} else if (milkOutput == redBlackTree.lastKey()) {
	    			redBlackTree.put(milkOutput - e.milk, redBlackTree.get(milkOutput - e.milk) - 1);
	    			if (redBlackTree.get(milkOutput - e.milk) == 0) {
	    				redBlackTree.remove(milkOutput - e.milk);
	    			}
	    			
	    			if (redBlackTree.containsKey(milkOutput - e.milk) && redBlackTree.get(milkOutput - e.milk) == 0) { 
	    				redBlackTree.remove(milkOutput - e.milk);
	    			}
	    			redBlackTree.put(milkOutput, redBlackTree.get(milkOutput) + 1);
	    			total++;
	    			//System.out.println("c");
	    		}
	    }
	    
	    //System.out.println(total);
	    out.println(total);
	    out.close();
	    
	}

}
