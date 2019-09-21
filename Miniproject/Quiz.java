package quiz;


import java.util.*;

abstract class Detail
{
    String username;
    String passwd;
    int age;
   
    Detail(String username,String password,int age)
    {
        this.username=username;
        this.passwd=password;
        this.age=age;
    }
   
    abstract void set_username(String username);
   
}

class Master extends Detail
{
    String Questions[]=new String[100];
    String Ans[][]=new String[100][5];
    int qno;                            //Keeps Track Number of Questions
   
    Master(String username,String password,int age)
    {
        super(username,password,age);
        Questions=new String[100];
        Ans=new String[100][5];
        qno=-1;
    }
    void set_username(String username)
    {
        this.username=username;
    }
    void set_password(String passwd)
    {
        this.passwd=passwd;
    }
    void set_Question(String Question,String ans[])
    {
        qno=qno+1;
        Questions[qno]=Question;
        for(int i=0;i<5;i++)
            Ans[qno][i]=ans[i];
    }
    void display_Question(int index)
    {
        System.out.println("---------------------------------");
        System.out.print((index+1)+") ");
        System.out.println(Questions[index]);
        System.out.println("The Options are : ");
        for(int i=0;i<4;i++)
        {
            System.out.println(Ans[index][i]);
        }
    }
    String get_ans(int index)
    {
        return Ans[index][4];
    }
    
    
}


class Contestant extends Master
{
    private double points[];
    private int pno;            //Keeps track of no of Quiz Attempts
    Contestant()
    {
        super("Null","nopass",0);
        points=new double[100];
        pno=-1;
    }
    Contestant(String username,String password,int age)
    {
        super(username,password,age);
        this.points = new double[100];
        pno=-1;
    }
    Contestant(String username,String password,int age,Master m)
    {
        super(username,password,age);
        this.points = new double[100];
        set_values(m);
        pno=-1;
    }
    void set_values(Master m)
    {
        Questions=m.Questions;
        Ans=m.Ans;
        qno=m.qno;
    }
    void setpoints(double[] points)
    {
        this.points = points;
    }
    double cal_points(int c, int w)
    {
       pno=pno+1;
       c = c*5;
       w = w*2;
       points[pno]=c-w;
       return points[pno];
    }
    void display_points()
    {
        for(int i=0;i<pno+1;i++)
        {
            System.out.print("Quiz "+(i+1)+" : ");
            System.out.println(points[i]);
        }
    }
    
}

class UserNotFoundException extends Exception
{
    String detail;
    UserNotFoundException(String detail)
    {
        this.detail = detail;
    }
    public String toString()
    {
        return detail;
    }
}






public class Quiz {

    
    
    public static void main(String[] args) throws UserNotFoundException{
        Master admin;
        Contestant user[] = new Contestant[100];
        int ch=0;                               //Main menu choice Variable
        int choice=0;                           //Admin&User menu choice Variable
        int cn=-1;                              //No of users(Contestant)
        Scanner in=new Scanner(System.in);
        admin=new Master("user","pass",19);
        while(ch!=3)
        {
            System.out.println("\n\tMenu");
            System.out.println("1.Admin");
            System.out.println("2.User");
            System.out.println("3.Exit");
            System.out.print("Enter Choice : ");
            ch=in.nextInt();
            if(ch==1)
            {
                choice=0;
                while(choice!=4)
                {   
                    Administrator:
                    System.out.println("Welcome Administrator!");
                    System.out.println("\n\tMenu");
                    System.out.println("1.Add New Question");
                    System.out.println("2.Add Multiple Questions");
                    System.out.println("3.View Questions");
                    System.out.println("4.Return to Main Menu");
                    System.out.print("Enter Choice : ");
                    choice=in.nextInt();
                    in.nextLine();
                    if(choice==1)
                    {
                        String s1;
                        String ans[]=new String[5];
                        System.out.print("Enter Question : ");
                        s1=in.nextLine();
                        System.out.println("Enter Options : ");
                        for(int i=0;i<4;i++)
                        {
                            ans[i]=in.nextLine();
                        }
                        System.out.println("Enter Answer : ");
                        ans[4]=in.nextLine();
                        admin.set_Question(s1,ans);
                    }
                    else if(choice==2)
                    {
                        int n=0;
                        System.out.print("Enter No of Questions : ");
                        n=in.nextInt();
                        in.nextLine();
                        for(int j=0;j<n;j++)
                        {
                            String s1;
                            String ans[]=new String[5];
                            System.out.print("Enter Question : ");
                            s1=in.nextLine();
                            System.out.println("Enter Options : ");
                            for(int i=0;i<4;i++)
                            {
                                switch(i)
                                {
                                    case 0: System.out.println("Enter Option a: ");
                                            break;
                                    case 1: System.out.println("Enter Option b: ");
                                            break;
                                    case 2: System.out.println("Enter Option c: ");
                                            break;
                                    case 3: System.out.println("Enter Option d: ");
                                            break;
                                }
                                ans[i]=in.nextLine();
                            }
                            System.out.println("Enter Answer Option : ");
                            ans[4]=in.nextLine();
                            admin.set_Question(s1,ans);
                        }
                        
                    }
                    else if(choice==3)
                    {
                        for(int i=0;i<admin.qno+1;i++)
                        {
                            admin.display_Question(i);
                            System.out.println("Ans = "+admin.get_ans(i));
                        }
                    }
                    else if(choice==4)
                    {
                        //else  if Not needed 
                        break;
                    }
                }
            }
            else if(ch==2)
            {
                choice=0;
                String name;
                int age;
                String pass;

                while(choice!=3)
                {                    
                    System.out.println("\n\tMenu");
                    System.out.println("1.New User");
                    System.out.println("2.Login User");
                    System.out.println("3.Return to Main Menu");
                    System.out.print("Enter Choice : ");
                    choice=in.nextInt();
                    in.nextLine();
                    if(choice==1)
                    {
                        cn=cn+1;
                        System.out.println("Enter Name(Username) : ");
                        name=in.nextLine();
                        System.out.println("Enter Password : ");
                        pass=in.nextLine();
                        System.out.println("Enter Age: ");
                        age = in.nextInt();
                        user[cn]=new Contestant(name,pass,age,admin); //Add Input functions HERE
                    }
                    else if(choice==2)
                    {
                        int uindex = -1;
                        int uchoice=0;
                        System.out.println("Enter Username: ");
                        name = in.nextLine();
                        System.out.println("Enter Password: ");
                        pass = in.nextLine();
                        
                        for(int i=0;i<=cn;i++)
                        {
                            if(user[i].username.equals(name) && user[i].passwd.equals(pass))
                            {
                               uindex = i;
                            }
                            else
                            {
                                //throw new UserNotFoundException(name);
                                System.out.println("User Not Found!");
                            }
                                  
                        }
                        
                        
                        while(uchoice!=4)
                        {
                            System.out.println("\n\nWelcome "+user[uindex].username);
                            System.out.println("\n\tMenu");
                            System.out.println("1.Attempt Quiz");
                            System.out.println("2.View LeaderBoard");
                            System.out.println("3.View Points");
                            System.out.println("4.Return to User Menu");
                            System.out.println("Enter Choice : ");
                            uchoice=in.nextInt();
                            in.nextLine();
                            if(uchoice==1)
                            {
                                String ans;
                                int c_ans=0,w_ans=0;
                                for(int i=0;i<admin.qno+1;i++)
                                {
                                    admin.display_Question(i);
                                    System.out.println("Enter Option : ");
                                    ans=in.next();
                                    if(ans.equals(admin.get_ans(i)))
                                    {
                                        c_ans=c_ans+1;
                                    }
                                    else
                                    {
                                        w_ans=w_ans+1;
                                    }
                                }      
                                user[uindex].set_values(admin);
                                System.out.print("\nYour Points : ");
                                System.out.println(user[uindex].cal_points(c_ans,w_ans));
                            }
                            else if(uchoice==2)
                            {
                                System.out.println("Quiz Chart");
                                for(int i=0;i<=uindex;i++)
                                {
                                    System.out.println("Name :"+user[i].username);
                                    user[i].display_points();
                                }
                            }
                            else if(uchoice==3)
                            {
                                    System.out.println("\n Your points are");
                                    user[uindex].display_points();  
                            }
                            else if(uchoice==4)
                            {
                                //System.out.println("This elif is not needed");
                                //System.out.println("Remove this if you want");
                                break;
                            }
                        }
                    }
                    else if(choice==3)
                    {
                        break;
                    }
                } 
            }
            
        }
    }
   
}
