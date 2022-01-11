package 기본알고리즘;

public class Max_Min {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(max4(1,5,3,5));
		System.out.println(min(1,5,3));
		System.out.println(min4(1,5,3,0));
	}

	
	static int max4(int a, int b, int c, int d) {
		int max;
		max = a;
		if(max<b) {
			max = b;
		}
		if(max<c) {
			max = c;
		}
		if(max<d) {
			max = d;
		}
		
		return max;
	}
	
	static int min(int a, int b, int c) {
		int min = a;
		if(min > b) {
			min = b;
		}
		if(min > c) {
			min = c;
		}
		return min;
	}
	
	static int min4(int a, int b, int c, int d) {
		int min;
		min = a;
		if(min > b) {
			min = b;
		}
		if(min > c) {
			min = c;
		}
		if(min > d) {
			min = d;
	
		}
		return min;
	}

}
