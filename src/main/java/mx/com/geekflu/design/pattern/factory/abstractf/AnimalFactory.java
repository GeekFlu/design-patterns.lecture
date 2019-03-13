package mx.com.geekflu.design.pattern.factory.abstractf;

import mx.com.geekflu.design.pattern.factory.Animal;
import mx.com.geekflu.design.pattern.factory.Duck;
import mx.com.geekflu.design.pattern.factory.Lion;

public class AnimalFactory implements AbstractFactory<Animal> {

	public Animal create(String animalType) {
		
		if("Lion".equalsIgnoreCase(animalType)) {
			return new Lion();
		}else if("Duck".equalsIgnoreCase(animalType)) {
			return new Duck();
		}
		
		return null;
	}

}
