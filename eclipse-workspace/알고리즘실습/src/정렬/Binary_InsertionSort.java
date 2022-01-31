package 정렬;

import java.util.Scanner;

public class Binary_InsertionSort {

	static int binSearch(int[] a, int key, int l, int h) {
		if (h <= l)
	        return (key > a[l]) ?
	               (l + 1) : l;
		
		int pc = (l + h)/2;
		if(a[pc] == key)
			return pc + 1;
		else if (a[pc] < key)
			return binSearch(a, key, pc + 1 , h);
		
		return binSearch(a, key , l, pc-1);
	}
	
	static void binarysort(int[] a , int n) {
		for(int i=1; i < n; i++) {
			int j = i-1;
			int key = a[i];
			int pos = binSearch(a , key , 0 , j);
			while( j >= pos) {
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = key;
		}
	}
		
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		System.out.println("binary insertionsort");
		System.out.print("index :"); int index = stdIn.nextInt();
		int[] a = new int[index];
		for(int i=0; i<a.length; i++) {
			System.out.print("a[" + i + "] : "); a[i] = stdIn.nextInt();
		}
		binarysort(a,index);
		
		for(int i=0; i<a.length; i++) {
			System.out.println("a[" + i + "] = " + a[i]);
		}
		
	}

}
