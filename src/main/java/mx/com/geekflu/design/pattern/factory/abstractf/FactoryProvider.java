package mx.com.geekflu.design.pattern.factory.abstractf;

import mx.com.geekflu.design.pattern.factory.Animal;
import mx.com.geekflu.design.pattern.factory.Color;

public class FactoryProvider {
	
	public static AbstractFactory<?> getFactory(String choice) {
		if("Animal".equalsIgnoreCase(choice)) {
			return new AnimalFactory();
		}else if("Color".equalsIgnoreCase(choice)) {
			return new ColorFactory();
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		AnimalFactory af = (AnimalFactory) FactoryProvider.getFactory("Animal");
		ColorFactory cf = (ColorFactory) FactoryProvider.getFactory("Color");
		Animal lion = af.create("Lion");
		Color red = cf.create("Red");
		System.out.println("Im a " + lion.getAnimal());
		System.out.println("  " + lion.getSound());
		
		System.out.println("Im a " + red.getColor());
	}
}
