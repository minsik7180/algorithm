package 배열;

import java.util.Scanner;

public class DayOfYear {

	static int[][] mday = {
			{31,28,31,30,31,30,31,31,30,31,30,31}, //평년
			{31,29,31,30,31,30,31,31,30,31,30,31} //윤년		
	};
	
	static int isLeap(int year) { //윤년 확인 함수 윤년이면 1 평년이면 0
		return (year %4 ==0 && year %100 !=0 || year %400 ==0) ? 1 : 0;
	}
	
	static int dayOfYear(int y, int m, int d) {
		int days = d;
		for(int i=1; i<m; i++)
			days += mday[isLeap(y)][i-1];
		return days;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner stdIn = new Scanner(System.in);
		int retry;
		
		System.out.println("그 해 경과 일수를 구합니다");
		
		do {
			System.out.print("년 : "); int year = stdIn.nextInt();
			System.out.print("월 : "); int month = stdIn.nextInt();
			System.out.print("일 : "); int day = stdIn.nextInt();
			
			
			System.out.printf("그 해 %d일째 입니다\n", dayOfYear(year,month,day));
			System.out.print("한번 더 할까요? (1. 예 /0 . 아니오) :");
			retry = stdIn.nextInt();
		}while(retry ==1);
	}

}
