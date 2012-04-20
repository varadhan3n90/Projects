package sort;


class Person{
	int age;
	String name;
	int id;
	
	Person(){
		
	}
	
	Person(int id,String name,int age){
		this.age = age;
		this.name = name;
		this.id = id;
	}
	
	public int getID(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public int getAge(){
		return age;
	}
}

public class Employee extends Person{
	static final int INFINITY = 10000;
	private Person Employees[];
	
	public Employee(int number)	{
		Employees = new Person[number];
	}
	
	
	public void Merge(int p,int q,int r){
		int n1 = q - p + 1;
		int n2 = r - q;
		int i=0;
		int j=0;
		Employee leftEmp = new Employee(n1+1);
		Employee rightEmp = new Employee(n2+1);
		//System.out.println("Merge called\n p "+p+" q "+q+" r "+r+" n1 "+n1+" n2 "+n2 );
			
		for (i=0;i<n1;i++){
			leftEmp.Employees[i] = Employees[p+i];			
		}
		for (j=0;j<n2;j++){
			rightEmp.Employees[j] = Employees[q+j];
		}
		leftEmp.Employees[i] = new Employee(1);
		rightEmp.Employees[j] = new Employee(1);
		leftEmp.Employees[i].id = INFINITY;
		rightEmp.Employees[j].id = INFINITY;
		i=0;j=0;
		for(int k=p;k<r;k++){
			if(leftEmp.Employees[i].getID() <= rightEmp.Employees[j].getID()){
				this.Employees[k] = leftEmp.Employees[i];
				i++;
			}else{
				this.Employees[k] = rightEmp.Employees[j];
				j++;
			}
			
		}
	}
	
	public void MS(int p,int r){
		//System.out.println("p "+p+" r "+r);
		
		if(p<r){
			int q = (p+r)/2;
			//System.out.println("q "+q);
			MS(p,q);
			MS(q+1,r);
			Merge(p,q,r);
		}else{
			//System.out.println("p not less than r");
		}
	}
	
	public void MergeSort(){		
		MS(0,this.Employees.length-1);
	}
	
	public void CreateTestData(){
		Employees[0] = new Person(39, "Mark", 19);
		Employees[1] = new Person(67, "Kevin", 39);
		Employees[2] = new Person(25, "Frank", 47);
		Employees[3] = new Person(93, "Maria", 56);
		Employees[4] = new Person(31, "Evan", 29);
		Employees[5] = new Person(18, "Audrey", 72);
		Employees[6] = new Person(46, "Debbie", 65);
		Employees[7] = new Person(84, "Ruth", 19);
		Employees[8] = new Person(62, "Kathy", 71);
		Employees[9] = new Person(10, "Mona", 45);
	}
	
	public String toString(){
		for(int l=0; l < Employees.length ; l++)
		System.out.println("Name: "+Employees[l].getName()+"\t ID: "+Employees[l].getID());
		return "";
	} // end method toString
}
	
	