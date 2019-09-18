/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testinterface;

import java.util.*;

class Person
{
    private String name;
    private String address;
    public Person(String name, String address)
    {
        this.name = name;
        this.address = address;
    }
    public String getName()
    {
        return name;
    }
    public String getAddress()
    {
        return address;
    }
    void setAddress(String address)
    {
        this.address = address;
    }
}

class Employee extends Person
{
    private String empid;
    private String dept;
    private int basic;
    public Employee( String name, String address, String empid, String dept, int basic)
    {
        super(name, address);
        this.empid = empid;
        this.dept = dept;
        this.basic = basic;
    }
    public String getEmpid()
    {
        return empid;
    }
    public String getDept()
    {
        return dept;
    }
    public void setDept(String dept)
    {
        this.dept = dept;
    }
    public void setBasic(int basic)
    {
        this.basic = basic;
    }
    public int getBasic()
    {
        return basic;
    }
    public float calSalary()
    {
        float gross,ded;
        gross = basic + 0.6f*basic + 0.1f*basic;
	ded = 0.085f*basic + 0.08f*basic;
	return gross-ded;       
    }
}

class Faculty extends Employee
{
    private String designation;
    private String course;
    public Faculty(String name, String address, String empid, String dept, int basic, String desig, String course)
    {
        super(name, address, empid, dept, basic);
        this.designation = desig;
        this.course = course;
    }
    public String getDesig()
    {
        return designation;
    }
    public void setDesig(String desig)
    {
        this.designation = desig;
    }
    public void setCourse(String course)
    {
        this.course = course;
    }
    public String getCourse()
    {
        return course;
    }
    public float calSalary()
    {
        float gross,ded;
        gross = getBasic() + 0.4f*getBasic() + 0.2f*getBasic();
	ded = 0.089f*getBasic() + 0.09f*getBasic();
	return gross-ded;
    }
}

interface Student
{
    float[] getMarks();
    float calcGPA();
}

class ResearchAssistant extends Employee implements Student
{
    String project;
    String course;
    float[] marks;
    public ResearchAssistant(String name, String address, String empid, String dept, int basic, String project, String course, float marks[])
    {
        super(name, address, empid, dept, basic);
        this.project = project;
        this.course = course;
        this.marks = marks;
    }
    public String getProject()
    {
        return project;
    }
    public String getCourse()
    {
        return course;
    }
    public void setCourse(String course)
    {
        this.course = course;
    }
    public float[] getMarks()
    {
        return marks;
    }
    public float calcGPA()
    {
        float totalmark=0;
        for(int i=0;i<3;i++)
            totalmark+=marks[i];
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
    public float calSalary()
    {
        float gross,ded;
        gross = getBasic() + 0.3f*getBasic() + 0.1f*getBasic();
	ded = 0.095f*getBasic() + 0.09f*getBasic();
	return gross-ded;
    }
}

public class TestInterface
{
    static Scanner in = new Scanner(System.in);
    static String name, address, empid, dept, desig, course, project;
    static int basic, choice;
    static float marks[] = new float[3];
    public static void main(String[] args) 
    {
        System.out.println("*******************************************");
        System.out.println(" Class : Employee ");
        System.out.println(" Enter Name : ");
        name = in.next();
        System.out.println(" Enter Address: ");
        in.nextLine();
        address = in.nextLine();
        System.out.println(" Enter Emp ID: ");
        empid = in.next();
        System.out.println(" Enter Department: ");
        dept = in.next();
        System.out.println(" Enter Basic: ");
        basic = in.nextInt();
        
        Employee Ref;
        
        Employee E = new Employee(name, address, empid, dept, basic);
        Ref = E;
        
        System.out.println();
        System.out.println("*******************************************");
        System.out.println(" Name: "+ Ref.getName());
        System.out.println(" Address: "+ Ref.getAddress());
        System.out.println(" Emp ID: "+ Ref.getEmpid());
        System.out.println(" Department: "+Ref.getDept());
        System.out.println(" Basic: "+ Ref.getBasic());
        System.out.println(" Salary: "+ Ref.calSalary());
        System.out.println("*******************************************");
        System.out.println(" Do you want to Change Address: (1.Yes /2.No) ");
        choice = in.nextInt();
        if(choice == 1)
        {
            System.out.println(" Enter New Address: ");
            in.nextLine();
            address = in.nextLine();
            Ref.setAddress(address);
            System.out.println(" New Address of Employee: "+ Ref.getAddress());
        }
        System.out.println(" Do you want to Change Department: (1.Yes /2.No) ");
        choice = in.nextInt();
        if(choice == 1)
        {
            System.out.println(" Enter New Department: ");
            dept = in.next();
            Ref.setDept(dept);
            System.out.println(" New Department of Employee: "+ Ref.getDept());
        }
        System.out.println(" Do you want to Change Basic: (1.Yes /2.No) ");
        choice = in.nextInt();
        if(choice == 1)
        {
            System.out.println(" Enter New Basic : ");
            basic = in.nextInt();
            Ref.setBasic(basic);
            System.out.println(" New Basic of Employee: "+ Ref.getBasic());
            System.out.println(" New Salary of Employee: "+ Ref.calSalary());
        }
        System.out.println();
        System.out.println("*******************************************");
        System.out.println(" Class : Faculty ");
        System.out.println(" Enter Name : ");
        name = in.next();
        System.out.println(" Enter Address: ");
        in.nextLine();
        address = in.nextLine();
        System.out.println(" Enter Emp ID: ");
        empid = in.next();
        System.out.println(" Enter Department: ");
        dept = in.next();
        System.out.println(" Enter Designation: ");
        desig = in.next();
        System.out.println(" Enter Course: ");
        course = in.next();
        System.out.println(" Enter Basic: ");
        basic = in.nextInt();
        System.out.println();
        
        Faculty F = new Faculty(name, address, empid, dept, basic, desig, course);
        Ref = F;
        
        System.out.println("*******************************************");
        System.out.println(" Name: "+ Ref.getName());
        System.out.println(" Address: "+ Ref.getAddress());
        System.out.println(" Emp ID: "+ Ref.getEmpid());
        System.out.println(" Department: "+Ref.getDept());
        System.out.println(" Designation: "+ F.getDesig());
        System.out.println(" Course : "+ F.getCourse());
        System.out.println(" Basic: "+ Ref.getBasic());
        System.out.println(" Salary: "+ Ref.calSalary());
        System.out.println("*******************************************");
        System.out.println(" Do you want to Change Designation: (1.Yes /2.No) ");
        choice = in.nextInt();
        if(choice == 1)
        {
            System.out.println(" Enter New Designation: ");
            dept = in.next();
            Ref.setDept(dept);
            System.out.println(" New Designation of Faculty: "+ Ref.getDept());
        }
        System.out.println(" Do you want to Change Course: (1.Yes /2.No) ");
        choice = in.nextInt();
        if(choice == 1)
        {
            System.out.println(" Enter New Course : ");
            course = in.next();
            F.setCourse(course);
            System.out.println(" New Course of Employee: "+ F.getCourse());
        }
        
        System.out.println();
        System.out.println("*******************************************");
        System.out.println(" Class : Research Assistant ");
        System.out.println(" Enter Name : ");
        name = in.next();
        System.out.println(" Enter Address: ");
        in.nextLine();
        address = in.nextLine();
        System.out.println(" Enter Emp ID: ");
        empid = in.next();
        System.out.println(" Enter Department: ");
        dept = in.next();
        System.out.println(" Enter Project: ");
        project = in.next();
        System.out.println(" Enter Course: ");
        course = in.next();
        System.out.println(" Enter Basic: ");
        basic = in.nextInt();
        System.out.println(" Enter Marks for 3 Subjects: ");
        for(int i=0;i<3;i++)
        {
            System.out.println(" Enter Mark for Subject "+(i+1));
            marks[i]=in.nextInt();
        }
        System.out.println();
        System.out.println("*******************************************");
        
        ResearchAssistant R = new ResearchAssistant(name, address, empid, dept, basic, project, course,marks);
        Ref = R;
        
        System.out.println(" Name: "+ Ref.getName());
        System.out.println(" Address: "+ Ref.getAddress());
        System.out.println(" Emp ID: "+ Ref.getEmpid());
        System.out.println(" Department: "+Ref.getDept());
        System.out.println(" Basic: "+ Ref.getBasic());
        System.out.println(" Project: "+R.getProject());
        System.out.println(" Course: "+R.getCourse());
        marks = R.getMarks();
        for(int i=0;i<3;i++)
        {
            System.out.println("Mark for Subject "+(i+1)+"is"+marks[i]);
        }
        System.out.println(" Salary: "+ Ref.calSalary());
        System.out.println(" GPA: "+ R.calcGPA());
        System.out.println("*******************************************");
        System.out.println();
        System.out.println(" Do you want to Change Course: (1.Yes /2.No) ");
        choice = in.nextInt();
        if(choice == 1)
        {
            System.out.println(" Enter New Course: ");
            course = in.next();
            R.setCourse(course);
            System.out.println(" New Course of Research Assistant: "+ R.getCourse());
        }
    
    }
    
}
