package mx.com.geekflu.data.structure.linked.list;

public class LinkedList<T>  {
	
	private Node<T> root;
	private Node<T> last;
	private int size;

	public LinkedList() {
		
	}
	
	public LinkedList(T root) {
		super();
		this.root = new Node<T>(root);
		this.last = this.root;
	}
	
	
	public void add(T data) {
		if(isEmpty()) {
			addFirst(data);
			this.last = this.root;
		}else {
			Node<T> nt = new Node<>(data);
			this.last.setNext(nt);
			this.last = nt;
			this.size++;
		}
	}
	
	public void addFirst(T data) {
		Node<T> nt = new Node<>(data);
		Node<T> oldFirst = this.root;
		this.root = nt;
		this.root.setNext(oldFirst);
		this.size++;
	}
	
	public Node<T> deleteFirst(){
		Node<T> old = this.root;
		this.root = old.getNext();
		if(this.size >= 0) {
			this.size--;
		}
		return old;
	}
	
	public Node<T> delete(){
		Node<T> n = this.root;
		Node<T> prev = null;
		Node<T> ret = this.last;

		//last
		if(this.root == this.last) {
			this.last = null;
			this.root = null;
		}else {
			while(n != null) {
				//previous node before last
				if(n.getNext() != null && 
						n.getNext().getNext() == null) {
					prev = n;
					break;
				}
				n = n.getNext();
			}
			this.last = prev;
			this.last.setNext(null);
		}
		if(this.size >= 0) {
			this.size--;
		}
		return ret;
	}
	
	public Node<T> getRoot(){
		return this.root;
	}
	
	public void printList() {
		Node<T> n = this.root;
		while(n != null) {
			System.out.print(n.getValue() + " ");
			n = n.getNext();
		}
		System.out.print("->NULL");
		System.out.println();
	}
	
	public void printListInOrderRecursively(Node<T> head) {
		if(head == null) {
			System.out.print(" -> NULL");
			System.out.print("\n");
			return;
		}
		System.out.print(head.getValue() + " ");
		printListInOrderRecursively(head.getNext());
	}
	
	public void printListInRevereseRecursively(Node<T> head) {
		if(head == null) {
			System.out.print("NULL -> ");
			return;
		}
		printListInRevereseRecursively(head.getNext());
		System.out.print(head.getValue() + " ");
	}
	
	public LinkedList<T> reverse() {
		LinkedList<T> copy = (LinkedList<T>) this.clone();
		reverse(copy.root, copy.root);
		return copy;
	}
	
	private void reverse(Node<T> current, Node<T> head) {
		if(current.getNext() == null) {
			current = head;
			return;
		}
		reverse(current.getNext(), head);
		Node<T> q = current.getNext();
		q.setNext(current);
//		current.setNext(null);
	}

	public static <T> LinkedList<T> mergeOrderedListRecursively(LinkedList<T> list1, LinkedList<T> list2){
		
		return null;
	}
	
	public static <T extends Comparable<T>> LinkedList<T> mergeOrderedListIteratively(LinkedList<T> list1, LinkedList<T> list2){
		if(list1 == null || list1.root == null) return list2;
		if(list2 == null || list2.root == null) return list1;
		Node<T> p1 = list1.root;
		Node<T> p2 = list2.root;
		Node<T> current = null;
		Node<T> newHead = null;
		LinkedList<T> mList = new LinkedList<>();
		while(p1 != null && 
				p2 != null) {
			if(newHead == null) {
				if(p1.getValue().compareTo(p2.getValue()) <= 0) {
					newHead = current = p1;
					p1 = p1.getNext();
				}else {
					newHead = current = p2;
					p2 = p2.getNext();
				}
			}else {
				if(p1.getValue().compareTo(p2.getValue()) <= 0) {
					current.setNext(p1);
					current = p1;
					p1 = p1.getNext();
				}else {
					current.setNext(p2);
					current = p2;
					p2 = p2.getNext();
				}
			}
		}
		if(p1!=null) current.setNext(p1);
        if(p2!=null) current.setNext(p2);
		mList.root = newHead;
		return mList;
	}

	public static <T> boolean compare(LinkedList<T> list1, LinkedList<T> list2) {
		if(list1 == null || list2 == null) {
			return false;
		}else if(list1.getSize() != list2.getSize()) {
			return false;
		}else {
			Node<T> h1 = list1.root;
			Node<T> h2 = list2.root;
			while(h1.getNext() != null) {
				if(h1.getValue() instanceof Number) {
					if(h1.getValue() != h2.getValue()) {
						return false;
					}
				}else {
					if(!h1.equals(h2)) {
						return false;
					}
				}
				h1 = h1.getNext();
				h2 = h2.getNext();
			}
		}
		return true;
	}
	
	@Override
	protected Object clone(){
		LinkedList<T> myl = new LinkedList<>();
		Node<T> n = this.getRoot();
		while(n != null) {
			myl.add(n.getValue());
			n = n.getNext();
		}
		return myl;
	}
	
	public boolean isEmpty() {
		return this.root == null;
	}

	public int getSize() {
		return size;
	}

}
