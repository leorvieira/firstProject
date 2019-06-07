import java.io.*;
import java.util.*;

public class mainBinarySearchCoursera {

	public static void main(String[] args) {

	FastScanner scanner = new FastScanner(System.in);
	int n = scanner.nextInt();
	int [] a = new int[n];
	for (int i=0;i<n;i++) {
		a[i] = scanner.nextInt();
	}
	int m = scanner.nextInt();
	int[] b = new int[m];
	for (int i=0;i<m;i++) {
		b[i] = scanner.nextInt();
	}


	
	for (int i=0;i<m;i++) {
			int result = binarysearch(a,b[i]);
			System.out.print(result + " ");
		}
	}
	
	static int binarysearch(int [] firstline, int key) {

		int midIndex = 0;
		int firstIndex = 0;
		int lastIndex = firstline.length - 1;
		while (firstIndex <= lastIndex) { 		
			midIndex = ( lastIndex + firstIndex ) / 2;
			if ( key == firstline[midIndex] ) {
				return midIndex;
			}else {
				if ( key > firstline[midIndex]) {
					firstIndex = midIndex + 1;
				}else{
					lastIndex = midIndex - 1;
				}
			}	
		}
		return -1;
	}

	
	static class FastScanner{
		BufferedReader br;
		StringTokenizer st;
		
		FastScanner (InputStream stream){
			try {
				br = new BufferedReader( new InputStreamReader (stream));
			} catch ( Exception e ) {
				e.printStackTrace();
			}
		}
		
		String next() {
			while ( st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch ( IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
	}

}
