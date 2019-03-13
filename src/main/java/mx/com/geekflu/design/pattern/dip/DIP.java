package mx.com.geekflu.design.pattern.dip;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.javatuples.Triplet;

/**
 * Dependency Inversion Principle
 * 
 * 1  .- High level modules should not depend on low level modules
 * 1.1.- Both should depend on abstractions
 * 
 * 2  .- Abstractions should not depend on details
 * 2.1.- Details should depend on abstractions
 * 
 * @author luisgonz
 *
 */
public class DIP {
	public static void main(String[] args) {
		Person parent = new Person("John");
		Person child1 = new Person("Iker");
		Person child2 = new Person("Malcom");
		
		Relationships rl = new Relationships();
		rl.addParentAndChild(parent, child1);
		rl.addParentAndChild(parent, child2);
		
		new Research(rl);
		
	}
}

enum Relationship{
	PARENT,
	CHILD,
	SIBLING
}

class Person {
	public String name;
	
	public Person() {
	}

	public Person(String name) {
		super();
		this.name = name;
	}
	
}

//low level module manipulates list information
class Relationships implements RelationshipBrowser{ 
	private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();
	
	public void addParentAndChild(Person parent, Person child) {
		relations.add(new Triplet<>(parent, Relationship.PARENT, child));
		relations.add(new Triplet<>(child, Relationship.CHILD, parent));
	}

	public List<Triplet<Person, Relationship, Person>> getRelations() {
		return relations;
	}

	@Override
	public List<Person> findAllChildrenOf(String name) {
		return relations.stream()
				.filter(
					x -> Objects.equals(x.getValue0().name , name) 
							&& x.getValue1() == Relationship.PARENT
				)
				.map(Triplet::getValue2)
				.collect(Collectors.toList());
	}
	
	
}

//Hihg level module
class Research{
	
	//DIP violation High level modules should not depend on low level modules
//	public Research(Relationships relationships) {
//		List<Triplet<Person,Relationship,Person>> relations = relationships.getRelations();
//		relations.stream().filter(
//				x -> x.getValue0().name.equalsIgnoreCase("John") && x.getValue1() == Relationship.PARENT
//		).forEach(ch -> System.out.println("John has a child called " + ch.getValue2().name));
//	}
	
	public Research(RelationshipBrowser rb) {
		List<Person> findAllChildrenOf = rb.findAllChildrenOf("John");
		for(Person p : findAllChildrenOf) {
			System.out.println(p.name);
		}
	}
}


////////////////

interface RelationshipBrowser{
	
	List<Person> findAllChildrenOf(String name);
	
}