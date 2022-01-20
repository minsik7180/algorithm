package 스택;

public class Gstack<E> {
	private int max;
	private int ptr;
	private E[] stk;
	
	public Gstack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			stk = (E[])new Object[max]; 
		}catch(OutOfMemoryError e) {
			max = 0;
		}
	}
	
	public E push(E x) throws Exception{
		if(ptr >= max)
			throw new Exception();
		
		return stk[ptr++] = x;
	}
	
	public E pop() throws Exception{
		if(ptr <= 0) 
			throw new Exception();
		
		return stk[--ptr];
	}
	
	public E peek() throws Exception{
		if(ptr <= 0)
			throw new Exception();
		
		return stk[ptr -1];
	}
	
	public int indexOf(E x) {
		for(int i = ptr - 1; i >=0; i--)
			if(stk[i] == x)
				return i;
		return -1;
	}
	
	public void clear() {
		ptr  = 0 ;
	}
	
	public int capacity() {
		return max;
	}
	
	public int size() {
		return ptr;
	}
	
	public boolean isEmpty() {
		return ptr <=0; 
	}
	
	public boolean isFull() {
		return ptr >= max;
	}
	
	public void dump() {
		if(ptr <= 0 )
			System.out.println("스택이 비어있습니다");
		else {
			for(int i=0; i<ptr; i++)
				System.out.print(stk[i] + " ");
			System.out.println();
		}
	}

}
