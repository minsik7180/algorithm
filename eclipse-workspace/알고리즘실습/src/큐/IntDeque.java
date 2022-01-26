package 큐;

public class IntDeque {
	
	private int max;
	private int front;
	private int rear;
	private int num;
	private int[] deque;
	
	public class EmptyIntDequeException extends RuntimeException{
		public EmptyIntDequeException() {}
	}
	
	public class OverflowIntDequeException extends RuntimeException{
		public OverflowIntDequeException() {}
	}
	
	public IntDeque(int capacity) {
		front = rear = -1;
		num =0;
		max = capacity;
		try {
			deque = new int[max];
		}catch (OutOfMemoryError e) {
			max = 0;
		}
	}
	
	public int L_enque(int x) throws OverflowIntDequeException{
		if (num >=max)
			throw new OverflowIntDequeException();
		
		rear = (rear+1)%max;
		
		deque[rear] = x;
		num++;
		return x;
	}
	
	public int F_enque(int x) throws OverflowIntDequeException{
		if(num>=max)
			throw new OverflowIntDequeException();
		if(front < 0)
			front = max;
		front = (front-1)%max;
		deque[front] = x;
		num++;
		return x;
		
	}
	
	public int F_deque() throws EmptyIntDequeException{
		if(num <=0)
			throw new EmptyIntDequeException();
	
			if(front < 0) {
				front = front+1;
			}
			int x = deque[front];
			front = (front+1)%max;
			num--;
			return x;
		
	
	}
	
	public int L_deque() throws EmptyIntDequeException{
		if(num <=0)
			throw new EmptyIntDequeException();
		//if(front == rear) {
		//	front = -1;
		//	rear = -1;
		//	return 0;
		//}
		
		int x = deque[rear];
		rear = (rear-1)%max;
		num--;
		return x;
	
		
	}
	
	public int F_peek() throws EmptyIntDequeException{
		if(num<=0)
			throw new EmptyIntDequeException();
		return deque[front];
	}
	
	public int L_peek() throws EmptyIntDequeException{
		if(num<=0)
			throw new EmptyIntDequeException();
		return deque[rear];
	}
	
	public int size() {
		return num;
	}
	
	public int capacity() {
		return max;
	}
}
