package 스택;

public class IntStack2 {
	private int max;
	private int ptr1;
	private int ptr2;
	private int[] stk;
	
	//스택이 비어있음 
	public class EmptyIntStackException extends RuntimeException{
		public EmptyIntStackException() { }
	}
	//스택이 가득 참 
	public class OverflowIntStackException extends RuntimeException{
		public OverflowIntStackException() { }
	}
	
	public IntStack2(int capacity) {
		max = capacity + 2;
		ptr1=0;
		ptr2=max - 1;
		try {
			stk = new int[max];
		}catch (OutOfMemoryError e) {   //생성할 수 없음 
			max = 0;
		}
	}
	
	public int push1(int x) throws OverflowIntStackException{
		if(ptr1 >= max/2)
			throw new OverflowIntStackException();
		return stk[ptr1++] = x;
	}
 	public int push2(int x) throws OverflowIntStackException{
 		if(ptr2 <= max/2)
 			throw new OverflowIntStackException();
 		return stk[ptr2--] = x;
 	}
 	
 	public int pop1() throws EmptyIntStackException{
 		if(ptr1 <= 0)
 			throw new EmptyIntStackException();
 		return stk[--ptr1];
 	}
 	public int pop2() throws EmptyIntStackException{
 		if(ptr2 >= max)
 			throw new EmptyIntStackException();
 		return stk[++ptr2];
 	}
 	
 	public int peek1() throws EmptyIntStackException{
 		if(ptr1 <=0)
 			throw new EmptyIntStackException();
 		return stk[ptr1-1];
 	}
 	public int peek2() throws EmptyIntStackException{
 		if(ptr2 >=max)
 			throw new EmptyIntStackException();
 		return stk[ptr2+1];
 	}
 	
 	public int size1() {
 		return ptr1;
 	}
 	
 	public int size2() {
 		return ptr2;
 	}
 	
 	public int capacity() {
 		return max/2;
 	}
}
