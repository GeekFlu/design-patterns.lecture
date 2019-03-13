package mx.com.geekflu.data.structure.linked.list;

public class Node<T>  {
	
	private T value;
	private Node<T> next;

	/**
	 * CReates a node with next reference with null
	 * @param value
	 */
	public Node(T value) {
		this(value, null);
	}
	
	public Node(T value, Node<T> next) {
		super();
		this.value = value;
		this.next = next;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

}
