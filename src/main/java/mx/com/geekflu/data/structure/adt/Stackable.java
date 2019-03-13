package mx.com.geekflu.data.structure.adt;

public interface Stackable<T> {
	
	T peak();
	T pop();
	void push(T value);
	void print();
	boolean isEmpty();
}
