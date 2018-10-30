package December_Silver_2015;
import java.util.*;
import java.io.*;

public class lightson {

	public static class Pair {
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("lightson.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
	    
	    StringTokenizer st = new StringTokenizer(f.readLine());
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    
	    LinkedList<Pair>[][] grid = new LinkedList[N][N];
	    for (int i = 0; i < N; i++) {
	    		for (int j = 0; j < N; j++) {
	    			grid[i][j] = new LinkedList<Pair>();
	    		}
	    }
	    
	    for (int i = 0; i < M; i++) {
	    		st = new StringTokenizer(f.readLine());
	    		int r = Integer.parseInt(st.nextToken()) - 1;
	    		int c = Integer.parseInt(st.nextToken()) - 1;
	    		int x = Integer.parseInt(st.nextToken()) - 1;
	    		int y = Integer.parseInt(st.nextToken()) - 1;
	    		Pair p = new Pair(x, y);
	    		grid[r][c].add(p);
	    }
	    
	    int[][] visited = new int[N][N];
	    visited[0][0] = 1;
	    boolean needToExplore = true;
	    while (needToExplore) {
	    		needToExplore = dfs(grid, visited, 0, 0);
	    		for (int i = 0; i < N; i++) {
		    		for (int j = 0; j < N; j++) {
		    			if (visited[i][j] == 2)
		    				visited[i][j] = 1;
		    		}
		    }
	    }
	    
	    int count = 0;
	    for (int i = 0; i < N; i++) {
	    		for (int j = 0; j < N; j++) {
	    			if (visited[i][j] == 1)
	    				count++;
	    		}
	    }
	    
	    out.println(count);
	    out.close();
 	}
	
	public static boolean dfs(LinkedList<Pair>[][] grid, int[][] v, int row, int col) {
		if ((row < 0 || row >= grid.length) || (col < 0 || col >= grid.length))
			return false;
		
		if (v[row][col] == 0 || v[row][col] == 2)
			return false;
		
		v[row][col] = 2;
		boolean switched = false;
		for (Pair p : grid[row][col]) {
			if (v[p.x][p.y] == 0) {
				v[p.x][p.y] = 1;
				switched = true;
			}
		}
		
		switched |= dfs(grid, v, row+1, col);
		switched |= dfs(grid, v, row, col+1);
		switched |= dfs(grid, v, row-1, col);
		switched |= dfs(grid, v, row, col-1);
		return switched;
	}

}
