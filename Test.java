import java.util.*;
import myPack.*;


class Test
{
	static Scanner in = new Scanner(System.in);
	static int n;	
	static String name, address, dept;
	static int age, regno;
	static float[] marks = new float[5];	
		
	public static void main(String args[])
	{
			
		System.out.println(" Enter number of Students: ");
		n = in.nextInt();
		Student[] S = new Student[n];		
	
		for(int i=0; i<n ; i++)
		{
			System.out.println();
			System.out.println(" Enter Student Name: ");
			name = in.next();
			System.out.println(" Enter Student Age: ");
			age = in.nextInt();
			System.out.println(" Enter Student Address: ");	
			address = in.next();
			System.out.println(" Enter Student Department: ");
			dept = in.next();
			System.out.println(" Enter Student Reg no: ");
			regno = in.nextInt();
	
			S[i] = new Student(name, age, address, regno, dept);
			int f = 0;
			f = S[i].getMarks();
			try
			{	
				if(f!=0)
				{
					S[i].ThrowException();
			}			
			}
			catch(InvalidMarksException e)
			{
				System.out.println(e);
			}
		}

		System.out.println();
		System.out.println("Details of Students!");
		
		for(int i=0; i<n ; i++)
		{
			marks = S[i].get_marks();
			System.out.println();
			System.out.println("*********************************************");
			System.out.println(" Student Name         : "+ S[i].get_name());
			System.out.println(" Student Regno        : "+ S[i].get_regno());
			System.out.println(" Student Age          : "+ S[i].get_age());
			System.out.println(" Student Address      : "+ S[i].get_address());	
			System.out.println(" Student Department   : "+ S[i].get_dept());
			for(int k=0; k<5; k++)
			{
				System.out.println("Mark in Subject "+k+" : "+ S[i].marks[k]);
			}
			System.out.println(" Student GPA          : "+ S[i].calGPA());
			System.out.println("*********************************************");
		}

	}

}

















