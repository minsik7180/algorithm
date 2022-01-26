package 큐;

import java.util.Scanner;

public class IntDequeTester {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntDeque d = new IntDeque(64);
		
		while(true) {
			System.out.println("현재 데이터 수 : "+ d.size() + " / " + d.capacity());
			System.out.println("(1) 앞인큐 (2) 뒤인큐 (3) 앞디큐 (4) 뒤디큐 (5) 앞피크 (6) 뒤피크 (0) 종료");
			
			int menu = stdIn.nextInt();
			if(menu == 0) break;
			
			int x;
			switch (menu) {
			case 1:
				System.out.print("데이터 : ");
				x = stdIn.nextInt();
				try {
					d.F_enque(x);
				}catch(IntDeque.OverflowIntDequeException e) {
					System.out.println("큐가 가득 찼습니다 ");
				}
				break;
				
			case 2:
				System.out.print("데이터 : ");
				x = stdIn.nextInt();
				try {
					x=d.L_enque(x);
				}catch(IntDeque.EmptyIntDequeException e) {
					System.out.println("큐가 가득 찼습니다 ");
				}
				break;
			case 3:
				try {
					x = d.F_deque();
					System.out.println("디큐한 데이터는 " + x + "입니다");
				}catch(IntDeque.EmptyIntDequeException e) {
					System.out.println("큐가 비어있습니다");
				}
				break;
			
			case 4:
				try {
					x = d.L_deque();
					System.out.println("디큐한 데이터는 " + x + "입니다");
				}catch(IntDeque.EmptyIntDequeException e) {
					System.out.println("큐가 비어있습니다");
				}
				break;
			
			case 5: 
				try {
					x = d.F_peek();
					System.out.println("피크한 데이터는 " + x + "입니다");
				}catch(IntDeque.EmptyIntDequeException e) {
					System.out.println("큐가 비어있습니다");
				}
				break;
			
			case 6:
				try {
					x= d.L_peek();
					System.out.println("피크한 데이터는 "+ x + "입니다");
				}catch(IntDeque.EmptyIntDequeException e) {
					System.out.println("큐가 비어있습니다");
				}
				break;
				
			
			}
		}
	}
}
