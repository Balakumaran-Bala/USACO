package February_Silver_2018;
import java.util.*;
import java.io.*;
///Users/Bala/eclipse-workspace/USACO/src/test.in
public class snowboots {

	public static int min = Integer.MAX_VALUE;
	public static int[][] memo;
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("snowboots.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("snowboots.out")));
	    //BufferedReader f = new BufferedReader(new FileReader("/Users/Bala/eclipse-workspace/USACO/src/test.in"));
	    //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/Bala/eclipse-workspace/USACO/src/test.out")));
	    StringTokenizer st = new StringTokenizer(f.readLine());
	    
	    int n = Integer.parseInt(st.nextToken());
	    int b = Integer.parseInt(st.nextToken());
	    
	    int[] tiles = new int[n];
	    st = new StringTokenizer(f.readLine());
	    for (int i = 0; i < n; i++) {
	    		tiles[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    int[][] boots = new int[b][2];
	    for (int i = 0; i < b; i++) {
		    st = new StringTokenizer(f.readLine());
	    		boots[i][0] = Integer.parseInt(st.nextToken());
	    		boots[i][1] = Integer.parseInt(st.nextToken());
	    }
	    
	    memo = new int[b + 10][n + 10];
	    recurse(0, 0, boots, tiles);
	    //System.out.println(min);
	    out.println(min);
	    out.close();
	}
	
	public static void recurse(int bootsUsed, int tile, int[][] boots, int[] tiles) {
		
		if (bootsUsed >= boots.length) {
			return;
		}
		
		if (tile >= tiles.length - 1) {
			min = Math.min(bootsUsed, min);
			return;
		}
		
		if (tiles[tile] > boots[bootsUsed][0]) {
			recurse(bootsUsed + 1, tile, boots, tiles);
			return;
		}
		
		for (int i = 0; i <= boots[bootsUsed][1]; i++) {
			if(tile + i < tiles.length) {
				if (tiles[tile + i] <= boots[bootsUsed][0]) {
					if (i != 0 && memo[bootsUsed][tile + i] == 0) {
						memo[bootsUsed][tile + i] = 1;
						recurse(bootsUsed, tile + i, boots, tiles);
					}
					if (memo[bootsUsed + 1][tile + i] == 0) {
						memo[bootsUsed + 1][tile + i] = 1;
						recurse(bootsUsed + 1, tile + i, boots, tiles);
					}
				}
			} else {
				min = Math.min(bootsUsed, min);
				return;
			}
			
		}
	}

}
