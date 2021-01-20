package practice;

import java.util.Scanner;

public class TriangleExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		triangle(a, b, c);
	}

	private static void triangle(int a, int b, int c) {
		if(a > 0 && b > 0 && c > 0) {
			if(a+b>c && b+c>a && c+a>b) {
				if(a==b && b==c && c==a) {
					System.out.println("이 삼각형은 정삼각형입니다.");
				}
				else if(a == b || b==c || c==a) {
					System.out.println("이 삼각형은 이등변삼각형입니다.");
				}
				else {
					System.out.println("이 삼각형은 부등변삼각형입니다.");
				}
			}
			else {
				System.out.println("삼각형을 성립할 수 없습니다.");
			}
		}
		else {
			System.out.println("삼각형을 성립할 수 없습니다.");
		}
	}
}
