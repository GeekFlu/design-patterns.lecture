package mx.com.geekflu.design.pattern.isp;


/**
 * Interface segratation principle how to split interfaces into smaller interfaces
 * @author luisgonz
 *
 */
public class ISP {

}

class Document{
	
}

interface Printer {
	void print(Document d);
}

interface Scanner {
	void scan(Document d);
}

interface Fax {
	void fax(Document d);
}

interface MultifuncionDevice extends Printer, Scanner {
	void mail(Document d);
}

//YAGNI = You Ain't Going To Need It 

class Photocopier implements Printer, Scanner {

	@Override
	public void scan(Document d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void print(Document d) {
		// TODO Auto-generated method stub
		
	}
	
}

class JustAPrinter implements Printer {

	@Override
	public void print(Document d) {
		// TODO Auto-generated method stub
		
	}
	
}



/*** withou Interface Segration Principle *****/
interface Machine{
	void print(Document d);
	void fax(Document d);
	void scan(Document d);
}

/**
 * This is a bad desing because perhaps all the methos wont be used
 * @author luisgonz
 *
 */
class OldFashionPrinter implements Machine{

	@Override
	public void print(Document d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fax(Document d) {
		// uncertain how an old fashioned printer does this
		
	}

	@Override
	public void scan(Document d) {
		// uncertain how an old fashioned printer does this
		
	}
	
}

class MultifuncionPrinter implements Machine{

	@Override
	public void print(Document d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fax(Document d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void scan(Document d) {
		// TODO Auto-generated method stub
		
	}
	
}