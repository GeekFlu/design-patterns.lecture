package mx.com.geekflu.design.pattern.ocp;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

//Open Close principle + Specification
public class OCP {
	public static void main(String[] args) {
		Product p =  new Product("TShirt", Color.BLUE, Size.LARGE);
		Product p1 =  new Product("House", Color.GREEN, Size.MEDIUM);
		Product p2 =  new Product("Book1", Color.RED, Size.SMALL);
		Product p3 =  new Product("Watch", Color.GREEN, Size.YUGE);
		Product p4 =  new Product("Shoes", Color.BLUE, Size.YUGE);
		List<Product> products = Arrays.asList(p,p1,p2,p3,p4);
		
		ProductFilter pf = new ProductFilter();
		System.out.println("OLDDDD********************+");
		pf.filterByColor(products, Color.GREEN)
			.forEach(printProducts);
		System.out.println("New********************+");
		BetterFilter bf = new BetterFilter();
		bf.filter(products, new ColorSpecification(Color.GREEN))
			.forEach(printProducts);
		
		AndSpecification<Product>and = new AndSpecification<>(
										new ColorSpecification(Color.BLUE), 
										new SizeSpecification(Size.YUGE));
		System.out.println("New********************+");
		bf.filter(products, and).forEach(printProducts);
	}
	
	private static Consumer<Product> printProducts = new Consumer<Product>() {
		
		@Override
		public void accept(Product t) {
			System.out.println(" - " + t.getName() + " is " + t.getColor());
		}
	};
}



enum Color{
	RED, GREEN, BLUE
}

enum Size{
	SMALL, MEDIUM, LARGE, YUGE
}

class Product{
	private String name;
	private Color color;
	private Size size;
	
	public Product(String name, Color color, Size size) {
		super();
		this.name = name;
		this.color = color;
		this.size = size;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
}

class ProductFilter{
	
	public Stream<Product> filterByColor(List<Product> products, Color color){
		return products.stream().filter(p -> p.getColor() == color);
	}
	
	public Stream<Product> filterBySize(List<Product> products, Size size){
		return products.stream().filter(p -> p.getSize() == size);
	}
	
	public Stream<Product> filterBySizeAndColor(List<Product> products,
												Color color,
												Size size){
		return products.stream().filter(p -> p.getColor() == color && 
											 p.getSize() ==size);
	}
}


interface Specification<T>{
	boolean isSatisfied(T item);
}

interface Filter<T>{
	Stream<T> filter(List<T> items, Specification<T> spec);
}

class ColorSpecification implements Specification<Product>{
	private Color color;
	
	public ColorSpecification(Color color) {
		super();
		this.color = color;
	}

	@Override
	public boolean isSatisfied(Product item) {
		return item.getColor() == this.color;
	}
	
}

class SizeSpecification implements Specification<Product>{
	private Size size;

	public SizeSpecification(Size size) {
		super();
		this.size = size;
	}

	@Override
	public boolean isSatisfied(Product item) {
		return item.getSize() == this.size;
	}
	
}

class AndSpecification<T> implements Specification<T>{

	private Specification<T> first, second;
	
	public AndSpecification(Specification<T> first, Specification<T> second) {
		super();
		this.first = first;
		this.second = second;
	}
	
	
	@Override
	public boolean isSatisfied(T item) {
		return first.isSatisfied(item) && second.isSatisfied(item);
	}

	
}

class BetterFilter implements Filter<Product>{

	@Override
	public Stream<Product> filter(List<Product> items, Specification<Product> spec) {
		return items.stream().filter(p -> spec.isSatisfied(p));
	}
	
}