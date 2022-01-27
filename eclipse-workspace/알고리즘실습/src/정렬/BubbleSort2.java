package 정렬;

import java.util.Scanner;

public class BubbleSort2 {
	
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	static void bubbleSort2(int[] a , int n) {
		for(int i=n-1; i>=0; i--) {
			for(int j=0; j<i; j++)
				if(a[j] > a[j+1])
					swap(a, j , j+1);
		}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("버블정렬 2");
		System.out.print("요솟수 :"); int nx = stdIn.nextInt();
		int[] a = new int[nx];
		
		for(int i=0; i<nx; i++) {
			System.out.print("x[" + i + "] : ");
			a[i] = stdIn.nextInt();
		}
		bubbleSort2(a,nx);
		
		System.out.println("오름차순으로 정렬했습니다");
		for(int i=0; i<a.length; i++) {
			System.out.println("a[" + i + "] = " + a[i]);
		}
	}

}
