package mx.com.geekflu.design.pattern.factory.abstractf;

public interface AbstractFactory<T> {
	
	T create(String animalType);
	
}
