package ExchangeCoin;

import java.util.Arrays;
import java.util.Scanner;

public class ExchangeCoin2 {
	private static int count;
	private static int count2;
	private static int count3;
	private static int count4;
	private static int[] u = { 1, 4, 5, 6 };
	private static int[] result = new int[4];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("잔돈 입력 >>");
		int coin = sc.nextInt();
		exchange(coin);
		exchange2(coin);
		exchange3(coin);
		exchange4(coin);
		Arrays.sort(result);
		System.out.println(Arrays.toString(result));
		
		System.out.println("가장 적게 받을 수 있는 동전의 개수는" + result[0]);
	}

	private static void exchange(int coin) {
		int s[] = new int[coin+1];
		s[0] = coin;
		for (int i = 1; i < s.length; i++) {
			s[i] = s[i-1] - u[0];
			count++;
			if(s[i-1] == 0) break;
		}
		System.out.println(Arrays.toString(s));
		result[0] = count;
	} // 잔돈을 1원으로만 계산할때

	private static void exchange2(int coin) {
		int s[] = new int[coin+1];
		s[0] = coin;
		for (int i = 1; i < s.length; i++) {
			if(s[i-1] >= 4) {
				s[i] = s[i-1] - u[1];
				count2++;				
			}
			else if (s[i-1] >= 1 && s[i-1] < 4) {
				s[i] = s[i-1] - u[0];
				count2++;
			} 
			else if (s[i-1] == 0)
				break;
		}
		System.out.println(Arrays.toString(s));
		result[1] = count2;
	} // 잔돈을 1원, 4원으로 계산할때

	private static void exchange3(int coin) {
		int s[] = new int[coin+1];
		s[0] = coin;
		for (int i = 1; i < s.length; i++) {
			if(s[i-1]>=5) {
				s[i] = s[i-1] - u[2];
				count3++;
			}
			else if(s[i-1] >= 4 && s[i-1] <5) {
				s[i] = s[i-1] - u[1];
				count3++;
			}
			else if(s[i-1] >= 1 && s[i-1] < 4) {
				s[i] = s[i-1] - u[0];
				count3++;
			}
			else if(s[i-1] == 0) break;
		}
		System.out.println(Arrays.toString(s));
		result[2] = count3;
	} // 잔돈을 1원, 4원, 5원으로 계산할때

	private static void exchange4(int coin) {
		int s[] = new int[coin+1];
		s[0] = coin;
		for (int i = 1; i < s.length; i++) {
			if(s[i-1] >= 6) {
				s[i] = s[i-1] - u[3];
				count4++;
			}
			else if(s[i-1] >= 5 && s[i-1] < 6) {
				s[i] = s[i-1] - u[2];
				count4++;
			}
			else if(s[i-1] >=4 && s[i-1] <5) {
				s[i] = s[i-1] - u[1];
				count4++;
			}
			else if(s[i-1] >=1 && s[i-1] <4) {
				s[i] = s[i-1] - u[0];
				count4++;
			}
			else if(s[i-1] == 0) break;
		}
		System.out.println(Arrays.toString(s));
		result[3] = count4;
	} // 잔돈을 1원, 4원, 5원, 6원으로 계산할때
}
