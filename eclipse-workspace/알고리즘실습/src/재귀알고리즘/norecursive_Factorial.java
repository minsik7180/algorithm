package 재귀알고리즘;

import java.util.Scanner;

public class norecursive_Factorial {
	static int factorial(int x) {
		int sum = x;
		for(int i = x-1;  i>0; i--) {
			if(i == 0 ) {
				i = 1;
			}else {
				sum = sum * i;
			}	
		}
		return sum;
	}
	public static void main(String[] args) {
	
		Scanner stdIn = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : "); int num = stdIn.nextInt();
		System.out.println(num + "의 팩토리얼은 " + factorial(num) + "입니다");
		
		
	}

}
