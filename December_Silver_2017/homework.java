package December_Silver_2017;
import java.util.*;
import java.io.*;
///Users/Bala/eclipse-workspace/USACO/src/test.in
public class homework {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("homework.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("homework.out")));
	    
	    StringTokenizer st = new StringTokenizer(f.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    int[] scores = new int[n];
	    
	    st = new StringTokenizer(f.readLine());
	    for (int i = 0; i < n; i++) {
	    		scores[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    int m = n-2;
	    double[] averages = new double[m];
	    int index = 1;
	    int averageIndex = averages.length - 1;
	    long runningSum = scores[n-1];
	    long min = scores[n-1];
	    for (int i = n-2; i > 0; i--) {
	    		min = Math.min(min, scores[i]);
	    		runningSum += scores[i];
	    		averages[averageIndex] = (double) (runningSum - min) / index;
	    		averageIndex--;
	    		index++;
	    }
	    
	    double max = 0;
	    for (int i = 0; i < m; i++) {
	    		if (averages[i] >= max) 
	    			max = averages[i];   		
	    }
	    
	    
	    for (int i = 0; i < m; i++) {
    			if (averages[i] == max)
    				out.println(i + 1);
	    }
	    out.close();
	}

}
