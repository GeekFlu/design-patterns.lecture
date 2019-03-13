package mx.com.geekflu.data.structure.linked.list;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> strL = new LinkedList<String>("initial");
		strL.add("double");
		strL.add("triple");
		strL.add("cuatro");
		strL.add("chincue");
		strL.printList();
		System.out.println(strL.getRoot());
		
		strL.addFirst("nuevo root");
		strL.printList();
		System.out.println(strL.getRoot());
		
		System.out.println("********* deleting root: " + strL.deleteFirst());
		strL.printList();
		
		LinkedList<Integer> slInts = new LinkedList<>();
		slInts.add(10);
		slInts.add(101);
		slInts.add(102);
		slInts.add(103);
		slInts.add(104);
		slInts.printList();

		slInts.delete();
		slInts.printList();
		
		slInts.delete();
		slInts.printList();

		slInts.delete();
		slInts.printList();
		
		slInts.delete();
		slInts.printList();
		
		slInts.delete();
		slInts.printList();
		slInts.delete();
		slInts.printList();
		slInts.delete();
		slInts.printList();
		
		LinkedList<String> sl = new  LinkedList<>();
		sl.add("A");
		sl.add("n");
		sl.add("i");
		sl.add("t");
		sl.add("a");
		sl.add(" ");
		sl.add("l");
		sl.add("a");
		sl.add("v");
		sl.add("a");
		sl.add(" ");
		sl.add("l");
		sl.add("a");
		sl.add(" ");
		sl.add("t");
		sl.add("i");
		sl.add("n");
		sl.add("a");
		
		System.out.println("Printing list in order using recursion: ");
		sl.printListInOrderRecursively(sl.getRoot());
		
		System.out.println("Printing list in reverse order using recursion: ");
		sl.printListInRevereseRecursively(sl.getRoot());
		
		System.out.println("\nOriginal List:");
		LinkedList<String> csl = (LinkedList<String>) sl.clone();
		csl.printList();
		System.out.println("Reverse the list: ");
		csl.reverse().printList();
		csl.printList();
		
		System.out.println("\n\nnew-----");
		LinkedList<Integer> nums = new LinkedList<>();
		nums.add(-10);
		nums.add(-20);
		nums.add(-30);
		nums.add(-40);
		nums.add(-50);
		nums.add(-60);
		nums.add(-70);
		nums.add(-80);
		System.out.println();
		nums.printListInOrderRecursively(nums.getRoot());
		nums.reverse();
		System.out.println();
		nums.printListInOrderRecursively(nums.getRoot());
		
		System.out.println("\n\nComparing two lists-----");
		System.out.println("\n\n");
		
		LinkedList<Integer> nums2 = (LinkedList<Integer>) nums.clone();
		nums2.add(1);
		nums2.add(2);
		System.out.print("Lista 1: ");
		nums.printListInOrderRecursively(nums.getRoot());
		
		System.out.print("\nLista 2: ");
		//nums2.reverse(nums2.getRoot());
		nums2.printListInOrderRecursively(nums2.getRoot());
		
		System.out.println("\nComparing lists result: " + nums.compare(nums, nums2));
		LinkedList<Integer> mergd = LinkedList.mergeOrderedListIteratively(nums, nums2);
		mergd.printListInOrderRecursively(mergd.getRoot());
		System.out.println(LinkedList.mergeOrderedListIteratively(sl, strL));
		
	}

}
