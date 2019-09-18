
import java.util.Date;  
import java.util.Scanner;
class employee
{
Scanner input=new Scanner(System.in);
private float id,da,hra,lic,pf,hours,gross,net,hourlywage,deductions,basic;
private String name,designation,dob,doj;
private int years;
float get_id()
{
return id;
}
void input()
{
System.out.println("Enter Employee ID                                          :");
id=input.nextFloat();
System.out.println("Enter Employee name                                        :");
name=input.next();
System.out.println("Enter Employee Designation  (Manager/Intern/Others)        :");
designation=input.next();
System.out.println("Enter Employee DOB                                         :");
dob=input.next();
System.out.println("Enter Employee DOJ                                         :");
doj=input.next();
System.out.println("Enter Employee Basic                                       :");
basic=input.nextFloat();
System.out.println("Does Employee Opt for LIC Premium Account? (1. Yes / 2. No):");
lic=input.nextFloat();
if(lic==1)
{
                  System.out.println("Enter Employee LIC Amount                              :");
lic=input.nextFloat();
}
else 
{
lic=0;
}
if(designation.equals("Intern"))
{
    System.out.println("Enter Employee hours worked                                 :");
    hours=input.nextFloat();
    System.out.println("Enter hourly wage                                           :");
    hourlywage=input.nextFloat();
}
else
{
    hours=0;
    hourlywage=0;
}

}
void calc()
{
if(designation.equals("Intern"))
{
da=2000;
hra=1000;
pf=500;
gross=(hours*hourlywage)+da+hra;
deductions=lic+pf;
net=gross-deductions;
}
else if(designation.equals("Manager"))
{
da=((0.4f)*basic);
hra=((0.1f)*basic);
pf=((0.08f)*basic);
gross=basic+da+hra;
deductions=lic+pf;
net=gross-deductions;
}
else
{
da=(0.3f*basic);
hra=(0.1f*basic);
pf=(0.08f*basic);
gross=basic+da+hra;
deductions=lic+pf;
net=gross-deductions;
}
}
void payslip()
{
System.out.println("**************************************");
System.out.println("           Employer Details           ");
System.out.println("               Payslip                ");
System.out.println("Emp id            : " +id);
System.out.println("Emp name          : " +name);
System.out.println("Designation       : " +designation);
System.out.println("Basic Pay         : " +basic);
System.out.println("DA                : " +da);
System.out.println("HRA               : " +hra);
System.out.println("PF                : " +pf);
System.out.println("LIC               : " +lic);
System.out.println("Gross Pay         : " +gross);
System.out.println("Deductions        : " +deductions);
System.out.println("Net Salary        : " +net);
System.out.println("**************************************");

}
void display()
{
    System.out.println(" Salary Details ");
    System.out.println(" Gross Pay       : "+ gross);
    System.out.println(" Deductions      : "+ deductions);
    System.out.println(" Net Pay         : "+ net);
}
void promote()
{	
        String year;
        Date d=new Date();  
        int year1=d.getYear();
        int last;
        last = year1 + 1900;
        year= (doj.substring(6,10));
        int first = Integer.parseInt(year);
        years = last - first;
int ch;
        System.out.println(" Number of years Employee worked: "+ years);
if(designation.equals("Others"))
        {
            if((years>5))
            {
System.out.println("Promotion to Manager Available!");
System.out.println("Do you want to Promote individual ?(1.Yes / 2.No)");
                ch=input.nextInt();
                if(ch==1)
                {
                    designation = "Manager";
                }
            }
            calc();
        }
        else if(designation.equals("Intern"))
        {
             if(years>2)
             {
                System.out.println("Promotion to Others Available!");
System.out.println("Do you want to Promote individual ?(1.Yes / 2.No)");
                ch=input.nextInt();
                if(ch==1)
                {
                    designation = "Others";
                }
             }
             calc();
        }
else if(designation.equals("Manager"))
{
System.out.println("Already Highly Posted!");
        }
}


}
class emp
{
static int n,id,k,ch;
public static void main(String args[])
{
Scanner input=new Scanner(System.in);
System.out.println("Enter the number of employees: ");
n=input.nextInt();
employee a[]=new employee[n];
for(int i=0;i<n;i++)
{
a[i]=new employee();
a[i].input();
a[i].calc();
a[i].display();
}
do
{
System.out.println(" Menu ");
System.out.println("1. Promote Employee ");
System.out.println("2. Print Payslip ");
ch=input.nextInt();
if(ch==2)
{
    System.out.println("Enter ID of Employee to print payslip: ");
    id=input.nextInt();
    for(k=0;k<n;k++)
    {
        if(a[k].get_id()==id)
                {
                    break;
                }
    }
    a[k].payslip();
}
else if(ch==1)
{
    System.out.println(" Enter ID of employee to promote: ");
    id=input.nextInt();
    for(k=0;k<n;k++)
    {
        if(a[k].get_id()==id)
                {
                    break;
                }
    }
    a[k].promote();
}
System.out.println("Do you want to continue: (1.Yes / 2.No) ");
ch=input.nextInt();

}while(ch==1);

}
}
