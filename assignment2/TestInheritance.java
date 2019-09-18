import java.util.*;
class Person
{
	private int aadhar;
	private String name, address;
	private char gender;
	public Person(int aadhar, String name, String address, char gender)
	{
		this.aadhar = aadhar;
		this.name = name;
		this.address = address;
		this.gender = gender;
	}
	public String getName()
	{
		return name;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public char getGender()
	{
		return gender;
	}
}

class Student extends Person
{
	private String program;
	private int year;
	private float totalmark;
	public Student( int aadhar, String name, String address, char gender, String program, int year, float total)
	{
		super(aadhar, name, address, gender);
		this.program = program;
		this.year = year;
		this.totalmark = total;
	}
	public String getProgram()
	{
		return program;
	}
	public int getYear()
	{
		return year;
	}
	public void setYear(int year)
	{
		this.year = year;
	}
	public float getTotal()
	{
		return totalmark;
	}
	public void setTotal(float tot)
	{
		this.totalmark = tot;
	}
	public float calGPA()
	{
		if(totalmark == 100)
			return 4.0f;
		else if(totalmark > 90)
			return 3.5f;
		else if(totalmark > 80)
			return 3.0f;
		else if(totalmark > 70)
			return 2.5f;
		else 
			return 2.0f;
	}
}

class Faculty extends Person
{
	private String designation;
	private String department;
	private float basicpay;
	public Faculty(int aadhar, String name, String address, char gender, String designation, String dept, float pay )
	{
		super(aadhar, name, address, gender);
		this.designation = designation;
		this.department = department;
		this.basicpay = pay;
	}
	public String getDesig()
	{
		return designation;
	}
	public void setDesig(String desig)
	{
		this.designation = desig;
	}
	public void setBasic(float basic)
	{
		this.basicpay = basic;
	}
	public float getBasic()
	{
		return basicpay;
	}
	public float calSalary()
	{
		float gross,ded;
		gross = basicpay + 0.6f*basicpay + 0.1f*basicpay;
		ded = 0.085f*basicpay + 0.08f*basicpay;
		return gross-ded; 
	}
}

public class TestInheritance{
	static Scanner in = new Scanner(System.in);
	static String name, address, program, designation, dept;
	static int aadhar, year;
	static char gender;
	static float totalmark, bp;
	public static void main (String args[]){
		System.out.println(" Testing Sub Class : Student ");
		System.out.println(" Enter Student Name :");
		name = in.next();
		System.out.println(" Enter Student Address :");
		address = in.next();
		System.out.println(" Enter Student Gender ( M / F ) :");
		gender = in.next().charAt(0);
		System.out.println(" Enter Student Aadhar :");
		aadhar = in.nextInt();
		System.out.println(" Enter Student Program :");
		program = in.next();
		System.out.println(" Enter Student Year :");
		year = in.nextInt();
		System.out.println(" Enter Total Mark :");
		totalmark = in.nextInt();
		System.out.println(" Initialising Student Class Object with Details ");
		Student S = new Student(aadhar, name, address, gender, program, year, totalmark);
		System.out.println(" Now Values Initialised are");
		System.out.println(" Name :"+ S.getName());
		System.out.println(" Address :"+ S.getAddress());
		System.out.println(" Gender :"+ S.getGender());
		System.out.println(" Program :"+ S.getProgram());
		System.out.println(" Total Mark :"+ S.getTotal());
		System.out.println(" GPA :"+ S.calGPA());
		System.out.println(" Testing setYear() ");
		System.out.println(" Enter new Student year : ");
		year = in.nextInt();
		S.setYear(year);
		System.out.println(" Student Year Changed to "+ S.getYear());
		System.out.println(" Testing setTotal() ");
		System.out.println(" Enter new Student total: ");
		totalmark = in.nextFloat();
		S.setTotal(totalmark);
		System.out.println(" Testing setAddress() ");
		System.out.println(" Enter new Student Address ");
		address = in.next();
		S.setAddress(address);
		System.out.println(" Faculty new Address :"+ S.getAddress());
		System.out.println(" Student New Total "+ S.getTotal() + " and New GPA "+ S.calGPA());
		System.out.println(" Testing Sub CLass : Faculty ");
		System.out.println(" Enter Faculty Name :");
		name = in.next();
		System.out.println(" Enter Faculty Address :");
		address = in.next();
		System.out.println(" Enter Faculty Gender ( M / F ) :");
		gender = in.next().charAt(0);
		System.out.println(" Enter Faculty Aadhar :");
		aadhar = in.nextInt();
		System.out.println(" Enter Faculty Designation :");
		designation = in.next();
		System.out.println(" Enter Faculty Department :");
		dept = in.next();
		System.out.println(" Enter Faculty Basic Pay :");
		bp = in.nextFloat();
		System.out.println(" Initialising Faculty Class Object with Details ");
		Faculty F = new Faculty(aadhar, name, address, gender, designation, dept, bp);
		System.out.println(" Values Initialised in Faculty Object are ");
		System.out.println(" Name :"+ F.getName());
		System.out.println(" Address :"+ F.getAddress());
		System.out.println(" Gender :"+ F.getGender());
		System.out.println(" Designation :"+ F.getDesig());
		System.out.println(" Basic Pay :"+ F.getBasic());
		System.out.println(" Salary :"+ F.calSalary());
		System.out.println(" Testing setDesig() ");
		System.out.println(" Enter New Designation :");
		designation = in.next();
		F.setDesig(designation);
		System.out.println(" Faculty New Designation :"+ F.getDesig());
		System.out.println(" Testing setBasic()");
		System.out.println(" Enter new basic pay: ");
		bp = in.nextInt();
		F.setBasic(bp);
		System.out.println(" Faculty New Basic Pay :"+ F.getBasic() +"and Salary :"+ F.calSalary());
		System.out.println(" Testing setAddress() ");
		System.out.println(" Enter new Faculty Address ");
		address = in.next();
		F.setAddress(address);
		System.out.println(" Faculty new Address :"+ F.getAddress());
	}
}

