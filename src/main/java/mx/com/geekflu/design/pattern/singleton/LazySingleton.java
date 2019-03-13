package mx.com.geekflu.design.pattern.singleton;

public class LazySingleton {
	private static LazySingleton instance;
	
	private LazySingleton() {
		// TODO Auto-generated constructor stub
	}
	
	public static synchronized LazySingleton getInstance() {
		if(instance == null) {
			instance = new LazySingleton();
		}
		
		return instance;
	}
	
	//double check locking
	
}
