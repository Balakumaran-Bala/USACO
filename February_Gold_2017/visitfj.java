package February_Gold_2017;

import java.util.*;
import java.io.*;

public class visitfj {
	
	public static class State {
		int row;
		int col;
		
		public State(int r, int c) {
			row = r;
			col = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("test.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
	    
	    StringTokenizer st = new StringTokenizer(f.readLine());
	    
	    int n = Integer.parseInt(st.nextToken());
	    int t = Integer.parseInt(st.nextToken());
	    
	    int[][] fields = new int[n][n];
	    
	    for (int i = 0; i < n; i++) {
	    		st = new StringTokenizer(f.readLine());
	    		for (int j = 0; j < n; j++) {
	    			fields[i][j] = Integer.parseInt(st.nextToken());
	    		}
	    }
	    
	    long[][] distances = new long[n][n];
	    
	    for (int i = 0; i < n; i++) {
	    		for (int j = 0; j < n; j++) {
	    			distances[i][j] = -1;
	    		}
	    }
	    
	    distances[0][0] = 0;
	    long min = Long.MAX_VALUE;
	    State start = new State(0, 0);
	    Queue<State> bfs = new LinkedList<State>();
	    bfs.add(start);
	    while (!bfs.isEmpty()) {
	    		int size = bfs.size();
	    		for (int i = 0; i < size; i++) {
	    			State curr = bfs.poll();
	    			for (int j = -3; j <= 3; j++) {
	    				for (int k = -1; k <= 1; k += 2) {
	    					int nextCol = curr.col + (k) * (Math.abs(j) - 3);
	    					int nextRow = curr.row + j;
	    					if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n) {
	    						long nextDistance = distances[curr.row][curr.col] + fields[nextRow][nextCol] + 3*t;
	    						if (distances[nextRow][nextCol] == -1 || nextDistance < distances[nextRow][nextCol]) {
	    							distances[nextRow][nextCol] = nextDistance;
	    							State next = new State(nextRow, nextCol);
			    					bfs.add(next);
	    						}
	    					}
	    				}
    				}
	    			
	    			int nextCol = curr.col + 1;
				int nextRow = curr.row;
	    			if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n) {
					long nextDistance = distances[curr.row][curr.col] + fields[nextRow][nextCol] + 3*t;
					if (distances[nextRow][nextCol] == -1 || nextDistance < distances[nextRow][nextCol]) {
						distances[nextRow][nextCol] = nextDistance;
						State next = new State(nextRow, nextCol);
    					bfs.add(next);
					}
				}
	    			
	    			nextCol = curr.col;
				nextRow = curr.row + 1;
	    			if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n) {
					long nextDistance = distances[curr.row][curr.col] + fields[nextRow][nextCol] + 3*t;
					if (distances[nextRow][nextCol] == -1 || nextDistance < distances[nextRow][nextCol]) {
						distances[nextRow][nextCol] = nextDistance;
						State next = new State(nextRow, nextCol);
    					bfs.add(next);
					}
				}
	    			
	    			nextCol = curr.col - 1;
				nextRow = curr.row;
	    			if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n) {
					long nextDistance = distances[curr.row][curr.col] + fields[nextRow][nextCol] + 3*t;
					if (distances[nextRow][nextCol] == -1 || nextDistance < distances[nextRow][nextCol]) {
						distances[nextRow][nextCol] = nextDistance;
						State next = new State(nextRow, nextCol);
    						bfs.add(next);
					}
				}
	    			
	    			nextCol = curr.col;
				nextRow = curr.row - 1;
	    			if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n) {
					long nextDistance = distances[curr.row][curr.col] + fields[nextRow][nextCol] + 3*t;
					if (distances[nextRow][nextCol] == -1 || nextDistance < distances[nextRow][nextCol]) {
						distances[nextRow][nextCol] = nextDistance;
						State next = new State(nextRow, nextCol);
    						bfs.add(next);
					}
				}
	    		}
	    }

	    for (int i = 0; i <= 2; i++) {
	    		for (int j = 2 - i; j >= 0; j--) {
	    			if (distances[n - i - 1][n - j - 1] + (i + j) * t < distances[n-1][n-1]) {
	    				distances[n-1][n-1] = distances[n - i - 1][n - j - 1] + (i + j) * t;
	    			}
	    		}
	    }
	    
	    out.println(distances[n-1][n-1]);
	    out.close();
	}
	

}
