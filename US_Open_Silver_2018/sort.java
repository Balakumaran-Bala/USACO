package US_Open_Silver_2018;
import java.util.*;
import java.io.*;
///Users/Bala/eclipse-workspace/USACO/src/test
public class sort {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("sort.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
			
		int n = Integer.parseInt(st.nextToken());
		int[] unsorted = new int[n];
		int[] sorted = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(f.readLine());
			unsorted[i] = Integer.parseInt(st.nextToken());
			sorted[i] = unsorted[i];
		}
			
		Arrays.sort(sorted);
		HashMap<Integer, Integer> sortedIndices = new HashMap<Integer, Integer>();
		for (int i = 0; i < sorted.length; i++) {
			sortedIndices.put(sorted[i], i);
		}
		
		int max = 0;
		for (int i = 0; i < unsorted.length; i++) {
			int temp = i - sortedIndices.get(unsorted[i]);
			if (temp > max) {
				max = temp;
			}
		}
		
		out.println(max+1);
		out.close();
	}

}
