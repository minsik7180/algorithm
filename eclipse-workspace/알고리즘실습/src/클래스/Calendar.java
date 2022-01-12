package 클래스;

import java.util.Scanner;

public class Calendar {

	static int isLeap(int year) {
		return (year%4 == 0 && year%100 != 0|| year % 400 == 0) ? 1:0;
	}
	static class YDM {
		int y;
		int m;
		int d;
		
		YDM(int y, int m, int d){
			this.y = y;
			this.m = m;
			this.d = d;
		}
	
		void YDMafter(int n) {
			
			int day = d;
			int year = y;
			int month = m;
			day = day + n;
			
			if((day > 29)&&(isLeap(year) == 1 && month == 2)) {
				day = day - 29;
				month = month + 1;
				if(month > 12) {
					month = month - 12;
					year = year + 1;
				}
			}
			else if((day > 28) && (isLeap(year) == 0 && month ==2)) {
				day = day - 28;
				month = month + 1;
				if(month > 12) {
					month = month - 12;
					year = year + 1;
				}
			}
			else if((day > 31) &&(m == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month ==12)) {
				day = day - 31;
				month = month + 1;
				if(month > 12) {
					month = month - 12;
					year = year + 1;
				}
					
			}
			
			else if((day > 30) &&(month == 4 || month == 6 || month == 9 || month == 11)) {
				day = day - 30;
				month = month + 1;
				if(month > 12) {
					month = month - 12;
					year = year + 1;
				}
			}
			System.out.println(year + "년 " + month + "월 " + day + "일 ");
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner stdIn = new Scanner(System.in);
		System.out.print("년도 : ");
		int year = stdIn.nextInt();
		System.out.print("월 : ");
		int month = stdIn.nextInt();
		System.out.print("일 : ");
		int day = stdIn.nextInt();
		
		YDM ydm = new YDM(year, month, day);
		
		System.out.print("더할 날짜 : ");
		int n = stdIn.nextInt();
		ydm.YDMafter(n);
		
	}

}
