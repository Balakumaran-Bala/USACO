package December_Gold_2017;

import java.util.*;
import java.io.*;

public class moocast {
	
	public static class Edge implements Comparable<Edge> {
		int src;
		int dest;
		int length;
		
		public Edge(int s, int d, int l) {
			src = s;
			dest = d;
			length = l;
		}
		
		public int compareTo(Edge e1) {
			return this.length - e1.length;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("moocast.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
	    
	    StringTokenizer st = new StringTokenizer(f.readLine());
	    
	    int n = Integer.parseInt(st.nextToken());
	    int[][] points = new int[n][2];
	    
	    for (int i = 0; i < n; i++) {
	    		st = new StringTokenizer(f.readLine());
	    		points[i][0] = Integer.parseInt(st.nextToken());
	    		points[i][1] = Integer.parseInt(st.nextToken());
	    }
	    
	    int[] components = new int[n+1];
	    for (int i = 0; i < n + 1; i++) {
	    		components[i] = i;
	    }
	    
	    ArrayList<Edge> edges = new ArrayList<Edge>();
	    for (int i = 0; i < n; i++) {
	    		for (int j = i + 1; j < n; j++) {
	    			int distance = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
	    			Edge e = new Edge(i+1, j+1, distance);
	    			edges.add(e);
	    		}
	    }
	    
	    int max = Integer.MAX_VALUE;
	    Collections.sort(edges);
	    	    
	    for (Edge e : edges) {
	    		boolean connected = true;
	    		for (int i = 1; i < n; i++) {
	    			if (components[i] != components[i+1])
	    				connected = false;
	    		}
	    		
	    		if (connected) {
	    			break;
	    		}
	    		
	    		max = e.length;

	    		if (components[e.src] != components[e.dest]) {
	    			int dest = components[e.dest];
	    			for (int i = 1; i < n+1; i++) {
		    			if (components[i] == dest) {
		    				components[i] = components[e.src];
		    			}
		    		}
	    		}
	    }
	    
	    out.println(max);
	    out.close();
	}

}
