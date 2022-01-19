package 검색;

import java.util.Scanner;

public class BinScanning {
	
	static void binsearch(int[] a , int n , int key) {
		int pl = 0;
		int pr = n - 1;
		int[] b = a.clone();
		for(int i=0; i<a.length; i++) {
			int pc = (pl+pr)/2;
			if(pl != 0) {
				for(int j=0; j<pl; j++) {
					System.out.print(" ");
				}
				System.out.print("<-");
			}
			if(pc !=0 ) {
				for(int j=0; j<pc; j++) {
					System.out.print(" ");
				}
				System.out.print("+");
			}

			if(pr != 0) {
				for(int j=0; j<pr; j++) {
					System.out.print("  ");
				}
				System.out.print("->");
			}


		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner stdIn = new Scanner(System.in); 
		System.out.print("요솟수 :");
		int num = stdIn.nextInt();
		int[] a = new int[num];
		
		for(int i=0; i<a.length; i++) {
			System.out.print("a[" + i + "] : ");
			a[i] = stdIn.nextInt();
		}
		System.out.println();
		System.out.print("키 값 : ");
		int key = stdIn.nextInt();
		for(int i=0; i<a.length; i++) {
			System.out.print("--");
		}
		System.out.println();
		for(int i=0; i<a.length; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		binsearch(a,num,key);
	}

}
