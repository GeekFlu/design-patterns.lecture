package mx.com.geekflu.design.pattern.builder;

public class FluentBuilder {
	public static void main(String[] args) {
		EmployeeBuilder personBuilder = new EmployeeBuilder();
		personBuilder
			.withName("Luis")
			.worksAt("Bati Cave")
			.wageEarn(25000f);
		System.out.println(personBuilder.build());
	}
}

class Person{
	public String name;
	public String position;
	public float wage;
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", position=" + position + ", wage=" + wage + "]";
	}
	
}


class PersonBuilder<SELF extends PersonBuilder<SELF>> {
	protected Person person = new Person();
	
	public SELF withName(String name) {
		person.name = name;
		return self();
	}
	
	public Person build() {
		return person;
	}
	
	protected SELF self() {
		return (SELF) this;
	}
}

class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {
	
	public EmployeeBuilder worksAt(String position) {
		this.person.position = position;
		return self();
	}
	
	public EmployeeBuilder wageEarn(float wage) {
		this.person.wage = wage;
		return self();
	}
	
	@Override
	protected EmployeeBuilder self() {
		return this;
	}
	
}