package mx.com.geekflu.data.structure.linked.list;

import mx.com.geekflu.data.structure.adt.Stackable;

/**
 * Stack implementation using a linked list
 * @author luisgonz
 *
 * @param <T>
 */
public class StackLL<T> implements Stackable<T>{
	
	private LinkedList<T> stack = new LinkedList<>();
	
	@Override
	public T peak() {		
		return stack.getRoot().getValue();
	}

	@Override
	public T pop() {
		T val = null;
		if(!isEmpty()) {
			val = this.stack.getRoot().getValue();
			this.stack.deleteFirst();
		}
		return val;
	}

	@Override
	public void push(T value) {
		this.stack.addFirst(value);
	}

	@Override
	public void print() {
		this.stack.printList();
	}

	@Override
	public boolean isEmpty() {
		return this.stack.getRoot() == null;
	}
}
