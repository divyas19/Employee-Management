import java.util.*;


class Employee {
	
	private int emp_id;
	private String name;
	private String contact;
	private String designation;
	private String department;
	private int  age;
	private int salary;
	
	public void setId(int emp_id) 
	{
		this.emp_id = emp_id;
	}
	public int getId() 
	{
		return emp_id;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getName() 
	{
		return name;
	}

	public void setContact(String contact) 
	{
		this.contact = contact;
	}
	public String getContact() {
		return contact;
	}
	
	public void setDesignation(String designation) 
	{
		this.designation = designation;
	}
	public String getDesignation() 
	{
		return designation;
	}
	
	public void setDepartment(String department) 
	{
		this.department = department;
	}
	public String getDepartment() 
	{
		return department;
	}
	
	public void setAge(int age) 
	{
		this.age = age;
	}
	public int getAge() 
	{
		return age;
	}
	
	public void setSalary(int salary) 
	{
		this.salary = salary;
	}
	public int getSalary() 
	{
		return salary;
	}
	
	@Override
	public String toString() 
	{
		return "Employee [id=" + emp_id + ", name=" + name  + ", contact=" + contact
				+ ", designation=" + designation + ", department=" + department+ ", age=" + age + ", salary=" + salary + "]";
	}
	public Employee(int emp_id, String name,  String contact, String designation, String department,int age, int salary) 
	{
		super();
		this.emp_id = emp_id;
		this.name = name;
		this.contact = contact;
		this.designation = designation;
		this.department = department;
		this.age = age;
		this.salary = salary;
	}
	
}





class Perform {
	
	HashSet<Employee> empdet=new HashSet<Employee>();
	
	Employee e1=new Employee(101, "Diya", "8889999000", "Tester", "IT", 33,29000);
	Employee e2=new Employee(102, "Joy", "7778880000", "Developer","IT",  26,68000);
	Employee e3=new Employee(103, "Bob Roy","8888999900", "Manager","IT", 27,  40000);
	
	
	Scanner sc=new Scanner(System.in);
	boolean rec_exist=false;
	int emp_id;
	String name;
	String contact;
	String department;
	String designation;
	int age;
	int salary;
	
	public Perform() 
	{
		empdet.add(e1);
		empdet.add(e2);
		empdet.add(e3);	
	}
	
	//view all employees details
	public void viewAllEmps() 
	{
		for(Employee emp:empdet) 
		{
			System.out.println(emp);
		}
	}
	
	//view employees based on there id
	public void viewEmp()
	{
		
		System.out.println("Enter Employeeid: ");
		emp_id=sc.nextInt();
		for(Employee emp:empdet) 
		{
			if(emp.getId()==emp_id) 
			{
				System.out.println(emp);
				rec_exist=true;
			}
		}
		if(!rec_exist) 
		{
			System.out.println("No such Employee exists");
		}
	}
	
	//add employee detail
	public void addEmp() 
	{
		System.out.println("Enter the id:");
		emp_id=sc.nextInt();
//		for(Employee emp:empdet) {
//			if(emp.getId()==emp_id) {
//				System.out.println("Employee id already exsits:");
//				addEmp();
//			}
//		}
		System.out.println("Enter Employee name");
		name=sc.next();
		System.out.println("Enter Employee Contact");
		contact=sc.next();
		System.out.println("Enter Designation");
		designation=sc.next();
		System.out.println("Enter Department");
		department=sc.next();
		System.out.println("Enter the age");
		age=sc.nextInt();
		System.out.println("Enter salary");
		salary =sc.nextInt();
		
		Employee emp=new Employee(emp_id, name,  contact, designation, department, age,salary);
		System.out.println("Employee addeed successfully");
		empdet.add(emp);
		System.out.println(emp);
		
		
	}
	//update  the employee details
	public void updateEmployee() 
	{
		System.out.println("Enter id: ");
		emp_id=sc.nextInt();
		boolean rec_exist=false;
		for(Employee emp:empdet) 
		{
			if(emp.getId()==emp_id) {
				System.out.println("Enter Employee contact: ");
				contact=sc.next();
				System.out.println("Enter Employee designation: ");
				designation=sc.next();
				System.out.println("Enter new Age");
				age=sc.nextInt();
				System.out.println("Enter new Salary");
				salary=sc.nextInt();
				emp.setContact(contact);
				emp.setDesignation(designation);
				emp.setAge(age);
				emp.setSalary(salary);
				System.out.println("Updated Details are: ");
				System.out.println(emp);
				rec_exist=true;
			}
		}
		if(rec_exist) 
		{
		    System.out.println("Employee details are updated !!!");
			
		}
		else 
		{
			System.out.println("Employee not present");
		}
	}
	//delete emp
	public void delEmp() 
	{
		System.out.println("Enter id");
		emp_id=sc.nextInt();
		boolean rec_exist=false;
		Employee deleted_emp=null;
		for(Employee emp:empdet) 
		{
			if(emp.getId()==emp_id) 
			{
				deleted_emp=emp;
				rec_exist=true;
			}
		}
		if(rec_exist) 
		{
			empdet.remove(deleted_emp);
			System.out.println("Employee deleted successfully !!!");
		}
		else 
		{
			System.out.println("Employee not present");
		}
	 }
	
	
}
	




class Main {

	Perform option=new Perform();
	static boolean run = true;
	
	public static void menu() 
	{
        System.out.println("Welcome To Employee Managment System"
        		+ "\n1. View All Employee "
        		+ "\n2.View Employee"
        		+ "\n3.Add Employee"
        		+ "\n4. Update Employee"
        		+ "\n5.Delete Employee"
        		+ "\n6. Exit ");
    }
	 
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		Perform option=new Perform();
		
		do {
			menu();
			System.out.println("Enter your Choice");
			int choice=sc.nextInt();
			switch(choice) 
			{
			
			case 1:
			    System.out.println("view All Employee");
				option.viewAllEmps();
				break;
			case 2:
				System.out.println("View Employee Details");
				option.viewEmp();
				break;
			case 3:
			    System.out.println("Add Employee Details");
				option.addEmp();
				break;
			case 4:
			    System.out.println("Update Employee Details");
				option.updateEmployee();
				break;
			case 5:
				System.out.println("Delete Employee");
				option.delEmp();
				break;
			case 6:
				System.out.println("Exit");
				System.exit(0);
				
			default:
				System.out.println("Enter proper choice");
				break;
				
			}
			
		}while(run);
		sc.close();
		
			}
	}
