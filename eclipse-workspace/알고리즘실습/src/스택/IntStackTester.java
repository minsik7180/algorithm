package 스택;

import java.util.Scanner;

import 스택.IntStack.EmptyIntStackException;

public class IntStackTester {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntStack s = new IntStack(64);
		
		while(true) {
			System.out.println("현재 데이터 수 : " + s.size() + " / "+ s.capacity());
			
			System.out.print("(1) 푸시 (2) 팝 (3) 피크 (4) 덤프 (5) 크기 (6) 상태 (7) 스택 용량 (8) 초기화 (0) 종료 : ");
			
			int menu = stdIn.nextInt();
			
			if(menu == 0 )break;
			
			int x;
			boolean t , n;
			switch(menu) { 
				case 1:     // 푸시
					System.out.print("데이터 : ");
					x = stdIn.nextInt();
					try {
						s.push(x);
					}catch (IntStack.OverflowIntStackException e) {
						System.out.println("스택이 가득 찼습니다");
					}
					break;
				
				case 2:  // 팝
					try {
						x=s.pop();
						System.out.println("팝한 데이터는 " + x + "입니다");
					}catch (IntStack.EmptyIntStackException e) {
						System.out.println("스택이 비어있습니다 ");
					}
					break;
					
				case 3:  // 피크
					try {
						x = s.peek();
						System.out.println("피크 한 데이터는 " + x + "입니다");
					}catch(IntStack.EmptyIntStackException e) {
						System.out.println("스택이 비어있습니다");
					}
					break;
					
				case 4:   // 덤프
					s.dump();
					break;
				
				case 5:
					x= s.size();
					System.out.println("스택의 크기는 " + x + "입니다");
					break;
					
				case 6:
					t = s.isEmpty();
					n = s.isFull();
					if(t == true) {
						System.out.println("스택이 비어있습니다");
					}
					else if(n == true) {
						System.out.println("스택이 가득 찼습니다");
					}
					else {
						System.out.println("스택에 요소가 있고 공간이 있습니다");
					}
					break;
				
				case 7:
					x=s.capacity();
					System.out.println("스택의 최대 용량은 " + x + "입니다");
					break;
				case 8:
					s.clear();
					System.out.println("스택이 초기화 되었습니다");
			}
		}
	}

}
