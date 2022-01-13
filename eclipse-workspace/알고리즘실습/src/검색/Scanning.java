package 검색;

import java.util.Scanner;

public class Scanning {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner stdIn = new Scanner(System.in);
		System.out.print("요솟수 입력 : ");
		int num = stdIn.nextInt();
		int n = 1;
		int[] a = new int[num];
		
		for(int i = 0; i<a.length; i++) {
			System.out.print("a["+i+"] : ");
			a[i] = stdIn.nextInt();
		}
		System.out.print("키 값 입력 : ");
		int key = stdIn.nextInt();
		for(int i=0; i<a.length; i++) {
			System.out.print(i+ " ");
		}
		System.out.println();
		for(int i=0; i< a.length; i++) {
		System.out.print("--");
		}
		System.out.println();
		
		for(int i=0; i<a.length; i++) {
			System.out.println("*");       //별 찍기
			for(int j=0; j<a.length; j++) { 
				System.out.print(a[j] + " "); // a[i] 나열
			}
			System.out.println();
			System.out.println();
			if(a.length == n) {   // key 값이 없을때
				System.out.println("key 값은 없습니다");
			}
			if(a[i] !=key ) {
				for(int k=0; k < n; k++) { // a[i]가 key값과 같지 않으면 한칸씩 뒤로 밀기 n을 이용해서 뒤로 밀기
					System.out.print("  ");
				}
				n++;
				continue;
			}
			if(a[i] == key)
				System.out.println(key + "는 a[" + i + "]에 있습니다"); // a[i]가 key값과 같으면 break
				break;
				
		}	
		
	}
}
