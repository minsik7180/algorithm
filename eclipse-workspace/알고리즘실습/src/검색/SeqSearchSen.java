package 검색;

import java.util.Scanner;

public class SeqSearchSen {

	static int seqSearchSen(int[] a, int n, int key) {
		int i=0;
		
		a[n] = key;// 보초법 (보초 추가)
		
		for(i = 0; i < n; i++) {
			if(a[i] == key)
				return i;
		}
		
//		while(true) {
//			if(a[i] == key)
//				break;
//			i++;
//		}
		return i == n ? -1 : i; // 보초인지 확인
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("요솟수 : ");
		int num = stdIn.nextInt();
		int[] x = new int[num + 1];
		
		for(int i=0; i< num; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = stdIn.nextInt();
		}
		
		System.out.print("검색할 값 : ");
		int ky = stdIn.nextInt();
		
		int idx = seqSearchSen(x,num,ky);
		
		if(idx == -1)
			System.out.println("그 값의 요소가 없습니다");
		else 
			System.out.println(ky + "은 x[" + idx + "]에 있습니다");
		
	}

}
