package 리스트;

import java.util.Comparator;

public class LinkedList<E> {

	class Node<E> {
		private E data;       // 데이터
		private Node<E> next; // 뒷쪽 포인터( 다음 노드 ) 
		
		Node(E data, Node<E> next){
			this.data = data;
			this.next = next;
		}
	}
	
	private Node<E> head; // 머리 (처음 노드)
	private Node<E> crnt; // 선택 (검색 노드선택 , 삭제용도)
	
	public LinkedList() {
		head = crnt = null;
	}
	
	
	//검색 메소드
	public E search(E obj , Comparator<? super E> c) { // obj = key값 , c = 비교값 
		Node<E> ptr = head; // 스캔중인 노드 (처음부터 비교해야 되므로 head로 초기화 후 비교)
		
		while(ptr != null) { // 꼬리까지 비교 ( ptr 이 null이면 꼬리 노드)
			if(c.compare(obj, ptr.data) == 0) { // obj이 data와 같으면
				crnt = ptr;
				return ptr.data; // 검색 성공 data 반환
			}
			ptr = ptr.next; // 현재 노드가 아니면 다음 노드 선택
		}
		return null; //검색 실패
	}
	
	
	//머리에 노드 삽입 메소드
	public void addFirst(E obj) {
		Node<E> ptr = head; // ptr을 head로 초기화 
		head = crnt = new Node<E>(obj,ptr); // head포인터가 생성한 노드를 가르키게 함 next를 ptr로 초기화(head갱신)
											// ptr은 전 머리 노드
	}
	//꼬리에 노드 삽입 메소드
	public void addLast(E obj) {
		if (head == null) // head가 null값 = 리스트가 비어있다
			addFirst(obj); // 리스트가 비어있으므로 머리노드 삽입으로 대체
		else {
			Node<E> ptr = head; //ptr을 head로 초기화 (ptr을 이용해 머리 노드부터 검색)
			while(ptr.next != null) // ptr이 꼬리 노드를 검색
				ptr = ptr.next;  //ptr이 꼬리노드를 가르키게 함
			ptr.next = crnt = new Node<E>(obj,null); // 노드 생성
		}
	}
	
	
	//머리노드 삭제 메소드
	public void removeFirst() {
		if(head != null) // 리스트가 비어있지 않아야함
			head = crnt = head.next; // head포인터를 머리 노드의 다음 노드를 가르키게 함
	}
	//꼬리노드 삭제 메소드
	public void removeLast() {
		if(head != null) {
			if(head.next == null) // 리스트에 노드가 한개이면 머리 노드 삭제 메소드로 대체
				removeFirst();
			else {
				Node<E> ptr = head; // 꼬리노드
				Node<E> pre = head; // 꼬리노드 앞 노드
				
				while(ptr.next != null) { //꼬리 노드 찾기
					pre = ptr; //꼬리노드 앞 노드 포인터 (꼬리 노드를 가르키고있음)
					ptr = ptr.next; // 꼬리노드 포인터
				}
				pre.next = null; // 꼬리 노드 앞 노드가 가르키는 노드를 null로 바꿈 (삭제)
				crnt = pre;
			}
		}
		
	}
	//노드 p 삭제
	public void remove(Node p) {
		if(head != null) {
			if(p == head) // p가 머리 노드이면 머리노드삭제 메소드로 대체
				removeFirst();
			else {
				Node<E> ptr = head; //ptr 을 head로 초기화
				
				while(ptr.next != p) { //선택 노드를 검색 (while문 종료후 ptr은 선택 노드의 앞 노드 참조)
					ptr = ptr.next; // ptr을 선택 노드를 가르키게 함
					if(ptr == null) return; // 선택 노드가 없음
				}
				ptr.next = p.next; //ptr을 선택 노드 다음 노드를 가르키게 함
				crnt = ptr;
			}
		}
	}
	 //선택 노드를 삭제
	public void removeCurrentNode() {
		remove(crnt); 
	}
	
	//전체 노드 삭제
	public void clear() {
		while(head != null) // head가 null값을 가질때까지
			removeFirst();	// 머리 노드를 지움
		crnt = null;
	}
	
	//선택노드 하나를 뒤쪽으로 이동
	public boolean next() {
		if(crnt == null || crnt.next == null) // 노드가 비어있고 뒤쪽 노드가 없으면
			return false; // 이동할 수 없음
		crnt = crnt.next;
		return true;
	}
	
	//선택 노드 출력 메소드
	public void printCurrentNode() {
		if(crnt == null)//선택 노드가 null일때
			System.out.println("선택한 노드가 없습니다");
		else
			System.out.println(crnt.data); // 선택 노드의 데이터 출력
	}
	//모든 노드 출력
	public void dump() {
		Node<E> ptr = head; //ptr 을 헤드로 초기화
		
		while(ptr != null) { //ptr 을 꼬리 노드까지 탐색
			System.out.println(ptr.data); //data 출력
			ptr = ptr.next; //ptr 을 다음 노드로 초기화
		}
	}
}
