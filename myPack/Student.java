
package myPack;

import java.util.*;

class Person
{
	private String name;
	private int age;
	private String address;

	Person(String name, int age, String address)
	{
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public String get_name()
	{
		return name;
	}

	public int get_age()
	{
		return age;
	}
	
	public String get_address()
	{
		return address;
	}

}


interface studInterface
{
	void getMarks();
	float calGPA();
}





public class Student extends Person implements studInterface
{

	private int regno;
	private String dept;
	public float[] marks;
	private float total;
	Scanner in = new Scanner(System.in);
	
	public Student(String name, int age, String address, int regno, String dept)
	{
		super(name, age, address);
		this.regno = regno;
		this.dept = dept;
		total = 0;
		this.marks = new float[5];
	}

	public void ThrowException() throws InvalidMarksException 
	{
		
		throw new InvalidMarksException();
	}

	public int getMarks()
	{
		int flag = 0;
		for(int i=0; i<5; i++)
		{
			System.out.println(" Enter Marks for Subject"+i+":");
			marks[i] = in.nextFloat();
			if(marks[i] < 0 || marks[i] > 100)
			{	
				flag = 1;

			}
			total += marks[i];
		}
		return flag;
	}

	public float calGPA()
	{
		total = total /5;
		if(total > 95)
			return 4f;
		else if(total > 85 && total <=95)
			return 3.5f;				
		else if(total > 70 && total <=85)
			return 3f;
		else if(total > 50 && total <=70)
			return 2.5f;
		else if(total < 50)
			return 2f;
		return 0;
	}

	public String get_dept()
	{
		return dept;
	}
	
	public int get_regno()
	{
		return regno;
	}

	public float[] get_marks()
	{
		return marks;
	}
	
	public float get_total()
	{
		return total;
	}
	
}


class InvalidMarksException extends Exception
{
	
	float detail;
	
	InvalidMarksException(float detail)
	{
		this.detail = detail;
	}
	
	public String toString()
	{
		return "Invalid Marks "+detail;
	}

}
