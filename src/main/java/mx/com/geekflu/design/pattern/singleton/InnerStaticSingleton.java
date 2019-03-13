package mx.com.geekflu.design.pattern.singleton;

public class InnerStaticSingleton {
	private InnerStaticSingleton() {
	}
	
	private static class Impl{
		private static final InnerStaticSingleton INSTANCE = new InnerStaticSingleton();
		
		public InnerStaticSingleton getInstance() {
			return Impl.INSTANCE;
		}
	}
	
	public static void main(String[] args) {
	}
}
