package 스택;

import java.util.Scanner;

public class GstackTester {

	public static void main(String[] args){
		Scanner stdIn = new Scanner(System.in);
		Gstack g = new Gstack(64);

		while(true) {
			System.out.println("현재 데이터 수 : " + g.size() + " / " + g.capacity());
			System.out.print("(1) 푸시 (2) 팝 (3) 피크 (4) 덤프 (5) 종료 : ");
			
			int menu = stdIn.nextInt();
			if(menu == 0 ) break;
			
			String x;
			switch (menu) {
			case 1:
				System.out.print("데이터 : ");
				x = stdIn.next();
				try {
					g.push(x);
				}catch(Exception e) {
					System.out.println("스택 오류");
				}
				break;
			
			case 2:
				try {
					x=(String)g.pop();	
					System.out.println("팝한 데이터는 " + x + "입니다 ");
				}catch(Exception e) {
					System.out.println("스택 오류");
				}
				break;
				
			case 3:
				try {
					x = (String)g.peek();
					System.out.println("피크한 데이터는 "+ x + "입니다");
				}catch(Exception e) {
					System.out.println("스택 오류");
				}
				break;
			
			case 4:
				g.dump();
				break;
			}
			
		}
	}

}
