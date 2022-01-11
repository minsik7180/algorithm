package 기본알고리즘;

import java.util.Scanner;

public class JudgeSign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		int n = stdIn.nextInt();
		if(n > 0)
			System.out.println("이 수는 양수 입니다");
		else if(n < 0)
			System.out.println("이 수는 음수 입니다");
		else {
			System.out.println("이 수는 0 입니다");
		}
	}

}
