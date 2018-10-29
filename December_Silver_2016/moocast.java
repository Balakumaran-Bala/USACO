package December_Silver_2016;

import java.util.*;
import java.io.*;

public class moocast {

	public static class Graph {
		int vertices;
		private LinkedList<Integer> adjList[];
		
		public Graph(int v) {
			vertices = v;
			adjList = new LinkedList[vertices + 1];
			
			for (int i = 0; i < vertices+1; i++) {
				adjList[i] = new LinkedList<Integer>();
			}
		}
		
		public void addEdge(int src, int dest) {
            adjList[src].add(dest);
        }
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("moocast.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
	    
	    StringTokenizer st = new StringTokenizer(f.readLine());

	    int n = Integer.parseInt(st.nextToken());
	    
	    int[][] cows = new int[n][3];
	    for (int i = 0; i < n; i++) {
	    		st = new StringTokenizer(f.readLine());
	    		cows[i][0] = Integer.parseInt(st.nextToken());
	    		cows[i][1] = Integer.parseInt(st.nextToken());
	    		cows[i][2] = Integer.parseInt(st.nextToken());
	    }
	    
	    Graph g = new Graph(n);
	    
	    for (int i = 0; i < n; i++) {
	    		for (int j = 0; j < n; j++) {
	    			if (i != j) {
	    				int distance = (cows[i][0] - cows[j][0]) * (cows[i][0] - cows[j][0]) + (cows[i][1] - cows[j][1]) * (cows[i][1] - cows[j][1]);
		    			if (distance <= cows[i][2]*cows[i][2])
		    				g.addEdge(i+1, j+1);
	    			}
	    		}
	    }
	    
	    int max = 0;
	    for (int i = 1; i < n+1; i++) {
	    		int[] visited = new int[n + 1];
	    		int num = findNodes(visited, i, g);
	    		if (num > max)
	    			max = num;
	    }

	    
	    out.println(max);
	    out.close();
	}
	
	public static int findNodes(int[] v, int i, Graph g) {
		v[i] = 1;
		
		if (g.adjList[i].size() == 0) {
			return 1;
		}
		
		int sum = 0;
		for (int node : g.adjList[i]) {
			if (v[node] != 1)
				sum += findNodes(v, node, g);
		}
		
		return sum + 1;
	}

}
