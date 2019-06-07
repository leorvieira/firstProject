import java.util.Arrays;
import java.util.Scanner;
public class mainMergSort {

	static Scanner s1 = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int n = getN();
		int [] S = new int [n];
		S = getSequence(n);
/*		for (int i=0;i<n;i++) {
			System.out.println(S[i]+" ");
		} */
/*		if (!(( S.length % 2 ) == 0)) {
			
			
		}else { */
			int [] R = new int[n];
			R = mergeSort(S);
/*			System.out.print("Resultado= "); */
			for (int i=0;i<n;i++) {
				System.out.print(R[i]+" ");
			}		
		}
	
	
	static int [] mergeSort(int [] v) {
		
		if (v.length == 1) {
			return v;
		}
		int mid = v.length / 2;
		int x = mid; int y = (v.length-mid);
/*		System.out.println("x = "+x+"y ="+y); */
		int [] A = new int[x];
		int [] B = new int[y];
		for (int i=0;i<x;i++) {
			A[i] = v[i];
		}
		for (int i=0;i<y;i++) {
			B[i] = v[mid+i];
		}
/*		System.out.print("A= ");
		for (int i=0;i<A.length;i++) {
			System.out.print(A[i]+" ");
		}
		System.out.print("B= ");
		for (int i=0;i<B.length;i++) {
			System.out.print(B[i]+" ");
		}
		System.out.println(" ");
		
/*		mergeSort(A); mergeSort(B); */
		int [] R = new int[v.length];
		R = merge(mergeSort(A),mergeSort(B));
/*		System.out.print(">>>R= ");
		for (int i=0;i<R.length;i++) {
			System.out.print(R[i]+" ");
		}
		System.out.println(" ");
*/
		return R;
	}
	
	static int [] merge(int [] A, int [] B) {
/*		System.out.println(" vai entrar no merge ");
		System.out.print("A= ");
		for (int i=0;i<A.length;i++) {
			System.out.print(A[i]+" ");
		}
		System.out.print("B= ");
		for (int i=0;i<B.length;i++) {
			System.out.print(B[i]+" ");
		}
		System.out.println("**********");
*/		
		int [] R = new int[(A.length+B.length)];
/**/		
		if ( Arrays.equals(A, B) ){
			for (int i=0;i<(A.length);i++) {
				R[i] = A[i];
			}
			for (int i=0;i<B.length;i++) {
				R[A.length+i] = B[i];
			}
/*			System.out.print("R= ");
			for (int i=0;i<R.length;i++) {
				System.out.print(R[i]+" ");
			}
			System.out.println("**********");
*/
			return R;
		}
/**/		
		int i = 0;int x = 0;int y=0;int a=0;int b=0;
		while ((x < A.length)||(y < B.length)) {
			if (x >= A.length ) {
				a = 999999999;
			}else { 
				a = A[x];}
			
			if (y >= B.length) {
				b = 999999999;
			}else {
				b = B[y];
			}
/*			System.out.println("a = "+a+" b = "+b+" i = "+i); */
			if ( a > b) {
				R[i] = B[y];
				y = y + 1;
			}else {
				R[i] = A[x];
				x = x + 1;
			}
			i = i + 1;
/*			System.out.println("x = "+x+" y = "+y+" i = "+i); */
		}
		return R;
	}

	static int [] getSequence(int n) {
		int [] S = new int [n];
		for (int i=0;i<n;i++) {
			S[i] = s1.nextInt();
		}
		return S;
	}
	
	
	static int getN() {
		int n = s1.nextInt();
		return n;
	}

}
