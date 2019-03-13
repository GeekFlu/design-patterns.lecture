package mx.com.geekflu.design.pattern.builder;


//more than one builder to build an object
public class FacetedBuilder {
	
	public static void main(String[] args) {
		PersonBuilderFacet pb = new PersonBuilderFacet();
		PersonFacet p = pb
				.lives()
					.at("Parkway Avenue #1234")
					.in("Loas Angeles")
					.withZipCode("09678")
				.works()
					.worksAt("Alliance IT")
					.asA("Java Developer")
					.earning(85000)
				.build();

		PersonBuilderFacet pb1 = new PersonBuilderFacet();
		PersonFacet p1 = pb1
				.lives()
					.at("Parkway Avenue #1234")
					.in("Loas Angeles")
					.withZipCode("09678")
				.works()
					.worksAt("Google")
					.asA("Java Developer")
					.earning(85000)
				.build();
		System.out.println(p1);
		System.out.println(p);
	}
}

class PersonFacet {
	//address
	public String street, postCode, city;
	
	//employment
	public String company, position;
	public int annualIncome;
	
	@Override
	public String toString() {
		return "PersonFacet [street=" + street + ", postCode=" + postCode + ", city=" + city + ", company=" + company
				+ ", position=" + position + ", annualIncome=" + annualIncome + "]";
	}
	
	
}

//builder facade
class PersonBuilderFacet {
	protected PersonFacet person = new PersonFacet();
	
	public PersonAddressBuilder lives() {
		return new PersonAddressBuilder(person);
	}
	
	public PersonJobBuilder works() {
		return new PersonJobBuilder(person);
	}
	
	public PersonFacet build() {
		return this.person;
	}
}


class PersonJobBuilder extends PersonBuilderFacet {

	public PersonJobBuilder(PersonFacet person) {
		this.person = person;
	}
	
	public PersonJobBuilder worksAt(String company) {
		this.person.company = company;
		return this;
	}
	public PersonJobBuilder asA(String position) {
		this.person.position = position;
		return this;
	}
	public PersonJobBuilder earning(int income) {
		this.person.annualIncome = income;
		return this;
	}
	
}

class PersonAddressBuilder extends PersonBuilderFacet{
	
	public PersonAddressBuilder(PersonFacet person) {
		this.person = person;
	}
	
	public PersonAddressBuilder at(String address) {
		this.person.street = address;
		return this;
	}
	
	public PersonAddressBuilder withZipCode(String zip) {
		this.person.postCode = zip;
		return this;
	}
	
	public PersonAddressBuilder in(String city) {
		this.person.city = city;
		return this;
	}
}