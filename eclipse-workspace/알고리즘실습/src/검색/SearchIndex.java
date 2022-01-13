package 검색;

import java.util.Scanner;

public class SearchIndex {

	static int SearchIndex(int[] a, int n, int key, int[] idx) {
		
		int t = 0; 
		int idxnum = 0;
		for(int i=0; i<a.length; i++) {
			if(a[i] == key) {
				idx[idxnum] = i;
				t ++;
				idxnum ++;
			}
		}
		return t;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner stdIn = new Scanner(System.in);
		System.out.print("요솟수 입력 : ");
		int num = stdIn.nextInt();
		int[] a = new int[num];
		int[] idx = new int[num];
		
		for(int i=0; i<a.length; i++) {
			System.out.print("a["+i+"] : ");
			a[i] = stdIn.nextInt();
		}
		System.out.print("키 값 : ");
		int key = stdIn.nextInt();
		
		System.out.println("키 값과 같은 수는 "+ SearchIndex(a, num , key , idx) + "개 입니다");

	}

}
