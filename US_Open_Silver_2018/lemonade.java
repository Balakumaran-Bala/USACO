package US_Open_Silver_2018;
import java.io.*;
import java.util.*;
///Users/Bala/eclipse-workspace/USACO/src/test
public class lemonade {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("lemonade.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(f.readLine());
		int[] wait = new int[n];
		for (int i = 0; i < n; i++) {
			wait[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(wait);
		int index = wait.length - 1;
		while (index >= 0 && wait[index] >= wait.length - index - 1) {
			index--;
		}
		
		out.println(wait.length - index - 1);
		out.close();
	}

}
