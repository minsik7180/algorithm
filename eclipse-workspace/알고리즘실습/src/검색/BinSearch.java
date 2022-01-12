package 검색;

import java.util.Scanner;


//이진 검색 알고리즘  (수가 정렬되어있어야함)
public class BinSearch {

	static int binSearch(int[] a , int n , int key) {
		int pl = 0;
		int pr = n - 1;
		
		do {
			int pc = (pl + pr)/2; // 중앙값을 설정
			if(a[pc] == key)  // key 값이 중앙값과 같으면 중앙값 반환
				return pc;    
			else if (a[pc] < key)    // 검색 범위를 절반으로 좁힘 (key 값이 중앙값보다 클때)
				pl = pc + 1;
			else                  //검색 범위를 절반으로 좁힘  ( key 값이 중앙갑 보다 작을때)
				pr = pc - 1;
		}while(pl<=pr);
		
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("요솟수 : ");
		int num = stdIn.nextInt();
		int[] x = new int [num];
		
		System.out.println("오름차순으로 입력하세요");
		
		System.out.print("x[0] :");
		x[0] = stdIn.nextInt();
		
		for(int i = 1; i<num; i++) {
			do {
				System.out.print("x[" + i + "] : ");
				x[i] = stdIn.nextInt();
			}while(x[i] < x[i-1]); // 앞수가 뒷 수보다 크면 반복
		}
		
		System.out.print("검색할 값 : ");
		int ky = stdIn.nextInt();
		
		int idx = binSearch(x,num,ky);
		
		if(idx == -1)
			System.out.println("그 값의 요소가 없습니다");
		else
			System.out.println(ky + "은 x[" + idx + "]에 있습니다");
	}

}
