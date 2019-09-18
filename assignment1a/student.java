
import java.util.Scanner;
class student
{
Scanner input=new Scanner(System.in);
private int regno,total;
private String name,dept,grade;
private float avg;
private int mark[]=new int[3];
int get_id()
{
    return regno;
}
String get_name()
{
    return name;
}
String get_dept()
{
    return dept;
}
student(String Name, int reg, String dep, int marks[])
{
	regno = reg;
	name = Name;
	dept = dep;
	for(int i=0;i<3;i++)
		mark[i]=marks[i];
}
void calculate()
{
	total=mark[0]+mark[1]+mark[2];
	avg=total/3;
	if(avg>90)
	{	grade="O";
		
	}
	else if((avg<90)&&(avg>=80))
	{
		grade="A+";
		
	}
	else if((avg<80)&&(avg>=70))
	{
		grade="A";
		
	}
	else if((avg<70)&&(avg>=60))
	{
		grade="B+";
		
	}
	else if((avg<60)&&(avg>=50))
	{
		grade="B";
		
	}
	else
	{
		grade="RA";
	}
}
void display(int xregno)
{
	System.out.println("***************************");
	System.out.println("     Student Details    ");
	System.out.println("Name          : "+name);
	System.out.println("Regno         : "+regno);
	System.out.println("Department    : "+dept);
	System.out.println("Grade         : "+grade);
	System.out.println("***************************");
	
}
void display(String xdep)
{
	System.out.println("***************************");
	System.out.println("     Student Details    ");
	System.out.println("Name          : "+name);
	System.out.println("Regno         : "+regno);
	System.out.println("Department    : "+dept);
	System.out.println("Grade         : "+grade);
	System.out.println("***************************");
	
}
void marksheet(int xregno)
{
        System.out.println("***************************");
	System.out.println("     Student Marksheet    ");
	System.out.println("Name          : "+name);
	System.out.println("Regno         : "+regno);
	System.out.println("Department    : "+dept);
        System.out.println("Total Marks   : "+total);
        System.out.println("Average Marks : "+avg);
	System.out.println("Grade         : "+grade);
	System.out.println("***************************");
}
}
class Stu
{
static int n,id,choice,b;
static String dep;
public static void main(String args[])
{	
	Scanner input=new Scanner(System.in);
	student a[]=new student[100];
	do
	{
        System.out.println("1. Add Student records ");
        System.out.println("2. Display Student details ");
        System.out.println("3. Generate Marksheet ");
	System.out.println("4. Search the student using ID ");
	System.out.println("5. Search the student using Dept");
        System.out.println("6. Exit");
	System.out.println("Enter your choice: ");
	choice=input.nextInt();
        if(choice==1)
        {
            System.out.println("Enter the number of students: ");
            n=input.nextInt();
            String name, dept;
            int regno, mark[] = new int [3];
            for(int i=0;i<n;i++)
            {
		System.out.println("Enter the student name");
		name=input.next();
		System.out.println("Enter the student regno");
		regno=input.nextInt();
		System.out.println("Enter the student department");
		dept=input.next();
		System.out.println("Enter the mark of subject 1");
		mark[0]=input.nextInt();
		System.out.println("Enter the mark of subject 2");
		mark[1]=input.nextInt();
		System.out.println("Enter the mark of subject 3");
		mark[2]=input.nextInt();
		a[i]=new student(name,regno,dept,mark);
		a[i].calculate();
            }
            
        }
        else if(choice==2)
        {
            for(int i=0;i<n;i++)
            {
                a[i].display(a[i].get_id());
            }
        }
        else if(choice==3)
        {
            System.out.println(" Enter ID to Print Marksheet ");
            id=input.nextInt();
            int flag=0;
            for(int i=0;i<n;i++)
		{	
			if((a[i].get_id()==id))
			{
				flag = 1;
				a[i].marksheet(id);
			}
		}
		if(flag == 0)
		{
			System.out.println(" Student Not Found of entered details! ");
		}
        }
        else if(choice==4)
	{
		System.out.println("Enter ID of Student to search: ");	
		id=input.nextInt();
		int flag = 0;
		for(int i=0;i<n;i++)
		{	
			if((a[i].get_id()==id))
			{
				flag = 1;
				a[i].display(id);
			}
		}
		if(flag == 0)
		{
			System.out.println(" Student Not Found of entered details! ");
		}
	}
	else if(choice==5)
	{
		System.out.println("Enter Dept of Student to search:");
		dep=input.next();
		int flag = 0;
		for(int i=0;i<n;i++)
		{
			if((a[i].get_dept()).equals(dep))
			{
				flag = 1;
				a[i].display(dep);
			}
		}
		if(flag == 0)
		{
			System.out.println(" Student Not Found of entered details! ");
		}
	}
	}while(choice!=6);
	}
}	
