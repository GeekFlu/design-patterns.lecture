package mx.com.geekflu.data.structure.linked.list;

public class DemoStackLL {

	public static void main(String[] args) {
		StackLL<String> s = new StackLL<>();
		s.push("a");
		s.push("l");
		s.push("o");
		s.push("H");
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}
	
	static boolean isParenthesis(String line) {
		//()[]{}{)()
		//
		
		StackLL<Character> s = new StackLL<>();
		int i = 0;
		char[] c = line.toCharArray();
		for(char cc : c) {
			s.push(cc);
		}
		return false;
	}

}
