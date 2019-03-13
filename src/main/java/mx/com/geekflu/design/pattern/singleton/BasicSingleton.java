package mx.com.geekflu.design.pattern.singleton;

import java.io.Serializable;

public class BasicSingleton implements Serializable{
	
	private static final long serialVersionUID = -4848041492738387831L;
	private static final BasicSingleton INSTANCE = new BasicSingleton();
	private int value = 0;
	// cannot new this class, however
	  // * instance can be created deliberately (reflection)
	  // * instance can be created accidentally (serialization)
	private BasicSingleton() {
		System.out.println("Singleton is initializing...");
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public static BasicSingleton getInstance() {
		return INSTANCE;
	}
	
	//To avoid breaking singleton by serialization add this method to the singleton
	protected Object readResolve() {
		return INSTANCE;
	}
}
