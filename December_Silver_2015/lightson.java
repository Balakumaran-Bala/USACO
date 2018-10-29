package December_Silver_2015;
import java.util.*;
import javafx.*;
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
		BufferedReader f = new BufferedReader(new FileReader("test.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
	    
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
	    int maxRooms = dfs(grid, visited, 0, 0);
	    for (int i = 0; i < N; i++) {
	    		for (int j = 0; j < N; j++) {
	    			System.out.print(visited[i][j] + " ");
	    		}
	    		System.out.println();
	    }
	    System.out.println(maxRooms);
 	}
	
	public static boolean valid(int row, int col, int n) {
		if ((row < 0 || row >= n) || (col < 0 || col >= n))
			return false;
		return true;
	}
	public static int dfs(LinkedList<Pair>[][] grid, int[][] v, int row, int col) {
		if ((row < 0 || row >= grid.length) || (col < 0 || col >= grid.length))
			return 0;
		
		if (v[row][col] == 0 || v[row][col] == 2)
			return 0;
		
		v[row][col] = 2;
		int sum = 1;
		for (Pair p : grid[row][col]) {
			v[p.x][p.y] = 1;
			System.out.println(p.x + " " + p.y);
			boolean adjacent = false;
			if (valid(p.x+1, p.y, grid.length) && v[p.x+1][p.y] == 2) {
				adjacent = true;
			}
			
			if (valid(p.x, p.y+1, grid.length) && v[p.x][p.y+1] == 2) {
				adjacent = true;
			}
			
			if (valid(p.x-1, p.y, grid.length) && v[p.x-1][p.y] == 2) {
				adjacent = true;
			}
			
			if (valid(p.x, p.y-1, grid.length) && v[p.x][p.y-1] == 2) {
				adjacent = true;
			}
			
			if (adjacent) {
				sum += dfs(grid, v, p.x, p.y);
			}
		}
		
		return sum;
	}

}
