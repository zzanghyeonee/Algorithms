package ExchangeCoin;

import java.util.Arrays;
import java.util.Scanner;

public class ExchangeCoin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("잔돈 입력 >>");
		int coin = sc.nextInt();
		Exchange(coin);
	}

	private static void Exchange(int coin) {
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int e = coin;
		while (coin > 0) {
			if (coin >= 6) {
				a = coin / 6;
				coin = coin - 6 * a;
			} else if (coin >= 5) {
				b = coin / 5;
				coin = coin - 5 * b;
			} else if (coin >= 4) {
				c = coin / 4;
				coin = coin - 4 * c;
			} else if (coin >= 1) {
				d = coin / 1;
				coin = coin - d;
			}
			if (coin == 0)
				break;
		}
		System.out.println(e + "은 6원 짜리" + a + "개  5원 짜리" + b + "개 4원 짜리" + c + "개 1원 짜리" + d + "개로 거슬러 받을 수 있다.");
	}
}


