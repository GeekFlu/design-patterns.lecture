package mx.com.geekflu.data.structure.linked.list;

public class DemoReverse {
	public static void main(String[] args) {
		LinkedList<String> l = new LinkedList<String>("a");
		l.add("b");
		l.add("c");
//		l.add("d");
//		l.add("e");
		
		l.reverse().printList();
	}
}
