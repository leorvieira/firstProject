import java.util.Scanner;
public class mainMoneyChange {

	static Scanner s1 = new Scanner(System.in);
	
	
	public static void main(String[] args) {
	
	/*	System.out.println("money = "+getmoney()); */

		System.out.println(getNumberofCoins(getmoney()));

	}

	static int getmoney() {
		
		int n = s1.nextInt();
		return n;
		
	}
	
	static int getNumberofCoins(int money) {
		int numofcoins = 0;
		if (money >= 10){
			numofcoins = ( money / 10 );
			money = (money % 10);
		}
		if (money >= 5) {
			numofcoins = numofcoins + ( money / 5);
			money = ( money % 5);
		}

		numofcoins = numofcoins +  money;
		
		return numofcoins;
	}
	
	
}
