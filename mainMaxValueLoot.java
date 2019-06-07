import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.text.DecimalFormat;
import java.text.ParseException; 



public class mainMaxValueLoot {

	static Scanner s = new Scanner(System.in);
	static DecimalFormat df = new DecimalFormat("###########.###");

	public static void main(String[] args) {
		
		int[] y = new int[2];
		y = getNandW();
		int n = y[0];
		int W = y[1];
/*		System.out.println(y[0]+"-"+y[1]); */

		double [][] m = new double[n][2];

		m = getValues(n);

		double[] p = new double[n];
		double[] w = new double[n];
		int[] index = new int[n];
		double[] k = new double[n];
		double[] c = new double[n];
		
		for (int i=0;i<n;i++) {
			p[i] = m[i][0];
			w[i] = m[i][1];
/*			System.out.println("passou aqui 1"); */
			String Aux = df.format(m[i][0]/m[i][1]);
/*			System.out.println("passou aqui 2 "+Aux); */
			double floatAux = 0;
			try {
				floatAux = df.parse(Aux).floatValue(); }
			catch (ParseException e){
				System.out.println("not valid conversion");
			}
			k[i] = floatAux;

		}

		for (int i=0;i<n;i++) {
			c[i] = k[i];
			
		}
		
		Arrays.sort(k);

		for ( int i=0;i<n;i++ ) {
			int j = ( n - i) - 1;
			for (int l=0;l<n;l++) {
				if ( c[l] == k[j] ) {
					index[i] = l;
					l = n;
				}
			}
		}
		
		System.out.println(getMaxValuePack(n, p, w, index, W));
	}
	
		static double getMaxValuePack(int n, double [] p, double[] w, int[] index,  int W) {
			double MaxPrice = 0;
			if (W > 0) {
			BigDecimal MaxPriceAux = new BigDecimal(0);
			int Waux = 0;
			for (int i=0;i<n;i++) {
				int partesPeso = 0;
				int ind = index [i];
				for (int j=0;j<w[ind];j++) {
					partesPeso = j;
					Waux = Waux + 1;
					if (Waux >= W) {
						j = (int) w[ind];
						i = n;
					}
				}
				
				partesPeso = partesPeso + 1; 
/*				System.out.println("partesPeso = "+partesPeso+"Waux = "+Waux);	*/ 
				double doubleAux = partesPeso*(p[ind]/w[ind]);
				BigDecimal doubleAuxPrice = new BigDecimal(doubleAux).setScale(3, RoundingMode.HALF_UP);
				String Aux = df.format(p[ind]/w[ind]);
				double floatAux = 0;
				try {
					floatAux = df.parse(Aux).floatValue(); }
				catch (ParseException e){
					System.out.println("not valid conversion");
				}
				MaxPriceAux = MaxPriceAux.add(doubleAuxPrice);
				MaxPrice = MaxPriceAux.doubleValue();
				Math.round(MaxPrice);
			}
			return MaxPrice;
			}
			else {
				return 0;
			}
	}
	
	static int [] getNandW() {
		
		int [] x = new int[2];
		x[0] = s.nextInt();
		x[1] = s.nextInt();
		
		return x;
	}
	
	static double [][] getValues(int n){
/*		System.out.println("passou aqui com n= "+n); */
		double [][] m = new double[n][2];
		for (int i=0;i<n;i++) {
/*			System.out.println("passou aqui com i = "+i); */
			m[i][0] = s.nextInt();
			m[i][1] = s.nextInt();
		}
		return m;
	}
}
