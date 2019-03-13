package mx.com.geekflu.data.structure.stack;

public class Stack<T> {
	
	private T[] stackArray;
	private int currentTop;
	private int maxSize;
	
	public Stack(int size) {
		this.stackArray = (T[]) new Object[size];
		this.maxSize = size;
		this.currentTop = -1;
	}
	
	public void push(T value) {
		currentTop++;
		this.stackArray[currentTop] = value;
	}
	
	public T peak() {
		return this.stackArray[currentTop];
	}
	
	public T pop() {
		T curVal = peak();
		this.stackArray[this.currentTop] = null;
		this.currentTop--;
		return curVal;
	}
	
	public boolean isEmpty() {
		return this.stackArray.length == 0 ||
				this.currentTop < 0;
	}
	
	public void printSatck() {
		while(!isEmpty()) {
			System.out.println(pop());
		}
	}
	
	public static void main(String[] args) {
		Stack<String> ss = new Stack<>(15);
		ss.printSatck();
		ss.push("hola00");
		ss.push("hola01");
		ss.push("hola03");
		ss.push("hola031");
		ss.push("hola0311");
		ss.push("hola0312");
		ss.push("hola0313");
		ss.push("hola0314");
		ss.push("hola0315");
		ss.push("hola0316");
		ss.push("hola0317");
		ss.push("hola0318");
		ss.printSatck();
	}
	
}
