package mx.com.geekflu.data.structure.linked.list;

public class DemoMergeLL {
	
	public static void main(String[] args) {
		LinkedList<Float> f1 = new LinkedList<Float>(-23.5f);
		f1.add(0.1f);
		f1.add(0.2f);
		f1.add(0.3f);
		f1.add(0.4f);
		f1.add(1.1f);
		f1.add(2.1f);
		
		LinkedList<Float> f2 = new LinkedList<Float>(-23.5f);
		f2.add(2.1f);
		f2.add(3.2f);
		f2.add(4.3f);
		f2.add(5.4f);
		f2.add(6.1f);
		f2.add(8.1f);
		
		LinkedList<Float> ml = LinkedList.mergeOrderedListIteratively(f1, f2);
		
		ml.printListInOrderRecursively(ml.getRoot());
	}
	
	
}
