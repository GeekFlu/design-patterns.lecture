package mx.com.geekflu.streams;

public class Employee {
	private String name;
	private int salary;
	private boolean isActive;
	
	public Employee(String name, int salary, boolean isActive) {
		super();
		this.name = name;
		this.salary = salary;
		this.isActive = isActive;
	}
	
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
}
