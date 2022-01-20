package 스택;

import java.util.Scanner;

public class IntStack2Tester {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntStack2 s2 = new IntStack2(10);

		
		while(true) {
			
			System.out.print("몇번 스택을 사용하시겠습니까? (1 , 2) : ");
			int S_choise = stdIn.nextInt();
			

			if(S_choise == 1) {
				System.out.println("스택 1 현재 데이터 수 : " + s2.size1() + " / " + s2.capacity());
				System.out.print("(1) 푸시 (2) 팝 (3) 피크 (0) 종료 : ");
				int menu = stdIn.nextInt();
				
				if(menu == 0) break;
				
				int x;
				switch(menu) {
				
					case 1:
						System.out.print("데이터 : ");
						x=stdIn.nextInt();
						
						try {
							s2.push1(x);
						}catch(IntStack2.OverflowIntStackException e) {
							System.out.println("스택이 가득찼습니다");
						}
						break;
					
					case 2:
						try {
							x = s2.pop1();
							System.out.println("팝한 데이터는 " + x + "입니다 ");
						}catch(IntStack2.EmptyIntStackException e) {
							System.out.println("스택이 비어있습니다");
						}
						break;
						
					case 3:
						try {
							x= s2.peek1();
							System.out.println("피크한 데이터는 " + x + "입니다");
						}catch(IntStack2.EmptyIntStackException e) {
							System.out.println("스택이 비어있습니다");
						}
						break;
				}
				
			}
			
			if(S_choise == 2) {
				System.out.println("스택 2 현재 데이터 수 : " + s2.size2() + " / " + s2.capacity());
				System.out.print("(1) 푸시 (2) 팝 (3) 피크 (0) 종료 : ");
				int menu = stdIn.nextInt();
				
				if(menu == 0) break;
				
				int x;
				switch(menu) {
				
					case 1:
						System.out.print("데이터 : ");
						x=stdIn.nextInt();
						
						try {
							s2.push2(x);
						}catch(IntStack2.OverflowIntStackException e) {
							System.out.println("스택이 가득찼습니다");
						}
						break;
					
					case 2:
						try {
							x = s2.pop2();
							System.out.println("팝한 데이터는 " + x + "입니다 ");
						}catch(IntStack2.EmptyIntStackException e) {
							System.out.println("스택이 비어있습니다");
						}
						break;
						
					case 3:
						try {
							x= s2.peek2();
							System.out.println("피크한 데이터는 " + x + "입니다");
						}catch(IntStack2.EmptyIntStackException e) {
							System.out.println("스택이 비어있습니다");
						}
						break;
				}
				
				
			}
		}
	}

}
