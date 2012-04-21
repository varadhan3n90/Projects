/*
 * Simple Employee class for inheritance
 * Answered for : http://www.cramster.com/answers-apr-12/computer-science/question-walter-savitc-define-clas-employee-objects-records-em_2442543.aspx
 */
package classesDemo;


class Person{
	String name;
	public Person(String name){
		this.name = name;
	}
	
	public boolean equals(Person p){
		if(p.name.equalsIgnoreCase(this.name))
			return true;
		else
			return false;
	}
	
	public String getName(){
		return name;
	}
	
}

/**
 * The Class Employee.
 */
public class Employee extends Person {
	
	/** The id. */
	int id;
	
	/** The hire date. */
	int hireDate;
	
	/** The salary. */
	float salary;
	
	/** The AUTO_ emp_ no. */
	static int AUTO_EMP_NO = 10;
	
	/**
	 * Equals.
	 *
	 * @param e the e
	 * @return true, if successful
	 */
	public boolean equals(Employee e){
		if(e.id == this.id)
			return true;
		else
			return false;
	}
	
	/**
	 * Instantiates a new employee.
	 *
	 * @param name the name
	 * @param id the id
	 * @param hireDate the hire date
	 * @param salary the salary
	 */
	Employee(String name,int id,int hireDate,float salary){
		super(name);
		this.hireDate = hireDate;
		this.id = id;
		this.salary = salary;				
	}

	/**
	 * Instantiates a new employee.
	 *
	 * @param name the name
	 * @param hireDate the hire date
	 * @param salary the salary
	 */
	Employee(String name,int hireDate,float salary){
		super(name);
		this.hireDate = hireDate;
		this.salary = salary;
		this.id = Employee.AUTO_EMP_NO++;
	}
	
	/**
	 * Instantiates a new employee.
	 *
	 * @param name the name
	 * @param id the id
	 */
	Employee(String name,int id){
		super(name);
		this.id = id;		
	}
	
	/**
	 * Sets the hire date.
	 *
	 * @param year the new hire date
	 */
	public void setHireDate(int year){
		this.hireDate = year;
	}
	
	/**
	 * Gets the iD.
	 *
	 * @return the iD
	 */
	public int getID(){
		return id;
	}
	
	/**
	 * Sets the salary.
	 *
	 * @param salary the new salary
	 */
	public void setSalary(float salary){
		this.salary = salary;
	}
	
	/**
	 * Gets the salary.
	 *
	 * @return the salary
	 */
	public float getSalary(){
		return salary;
	}
	
	/**
	 * Gets the hire date.
	 *
	 * @return the hire date
	 */
	public int getHireDate(){
		return hireDate;
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
		System.out.println("Testing Employee and Person class.");
		Person p1 = new Person("ABC");
		Person p2 = new Person("XYZ");
		Employee e1 = new Employee("ABC", 1990, 5000.0f);
		Employee e2 = new Employee("LMN",15);
		System.out.println("Person 1 "+p1.getName());
		System.out.println("Person 2 "+p2.getName());
		System.out.println("Employee 1 "+e1.getName()+" ID "+e1.getID()+" Salary "+e1.getSalary()+" hire date "+e1.getHireDate() );
		System.out.println("Is person 1 same as Employee 1? " +p1.equals(e1));
		System.out.println("Is employee 1 same as Employee 2? "+e1.equals(e2));
	}
	
	
}
