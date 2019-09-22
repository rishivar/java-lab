//package quiz;

import java.util.*;

import myException.UserNotFoundException;

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
    private String feedback;
    
    Contestant()
    {
        super("Null","nopass",0);
        points=new double[100];
        pno=-1;
        feedback = "No Feedback yet!";
    }
    Contestant(String username,String password,int age)
    {
        super(username,password,age);
        this.points = new double[100];
        pno=-1;
        feedback = "No Feedback yet!";
    }
    Contestant(String username,String password,int age,Master m)
    {
        super(username,password,age);
        this.points = new double[100];
        set_values(m);
        pno=-1;
        feedback = "No Feedback yet!";
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
    void set_feedback(String feedback)
    {
        this.feedback = feedback;
    }
    String get_feedback()
    {
        return feedback;
    }
}

public class Quiz {
        static Contestant user[] = new Contestant[100];
        static int ch=0;                               //Main menu choice Variable
        static int choice=0;                           //Admin&User menu choice Variable
        static int cn=-1;                              //No of users(Contestant)
        static Scanner in=new Scanner(System.in);
        static Master admin = new Master("admin","123",20);
        static String name;
        static int age;
        static String pass;
    private static void admin(Master admin)
    {
        while(1!=0)
        {
        			clearScreen();
                    System.out.println("Welcome Administrator!");
                    System.out.println("\n\t\t\t\tMenu");
                    System.out.println("\t\t1.Add New Question");
                    System.out.println("\t\t2.Add Multiple Questions");
                    System.out.println("\t\t3.View Questions");
                    System.out.println("\t\t4.View LeaderBoard");
                    System.out.println("\t\t5.Give Feedback");
                    System.out.println("\t\t6.Return to Main Menu");
                    System.out.print("\t\tEnter Choice : ");
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
                        	if(i == 0) 
                            {
                                System.out.println("Enter Option a: ");
                            }
                            if(i == 1)
                            {
                                System.out.println("Enter Option b: ");
                            }
                            if(i == 2)    
                            {
                                System.out.println("Enter Option c: ");
                            }
                            if(i == 3)
                            {
                                System.out.println("Enter Option d: ");
                            }
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
                                if(i == 0) 
                                {
                                    System.out.println("Enter Option a: ");
                                }
                                if(i == 1)
                                {
                                    System.out.println("Enter Option b: ");
                                }
                                if(i == 2)    
                                {
                                    System.out.println("Enter Option c: ");
                                }
                                if(i == 3)
                                {
                                    System.out.println("Enter Option d: ");
                                }
                                ans[i]=in.nextLine();
                            }
                            System.out.println("Enter Answer: ");
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
                        leaderboard();
                    }
                    else if(choice==5)
                    {
                        for(int i=0;i<=cn;i++)
                        {
                            System.out.println(" Username :"+ user[i].username);
                        }
                        System.out.println("Enter name of user to give feedback about!");
                        name = in.nextLine();
                        for(int i=0;i<=cn;i++)
                        {
                           if(name.equals(user[i].username))
                           {
                               System.out.println("Enter Feedback: ");
                               String feedback = in.nextLine();
                               user[i].set_feedback(feedback);
                           }
                        }
                    }
                    else if(choice==6)
                    {
						clearScreen() ;
                        menu();
                    }
                    System.out.println("Press Enter to Continue ... ");
                    in.nextLine();
                    clearScreen();
        }          
    }
    
    public static void menu()
    {
            clearScreen();
            int pos;
            System.out.println("\n\t\t\tMenu");
            System.out.println("\t\t1.New User");
            System.out.println("\t\t2.Login");
	    	System.out.println("\t\t0.Exit");
            System.out.print("Enter Choice : ");
            choice=in.nextInt();
            in.nextLine();
            if(choice==1)
            {
                 create_new_user();  
                 menu();
            }                
            else if(choice==2)
            {
                login();
            }
			else if(choice ==0)
			{
				System.exit(0);
			}
			else
			{
				menu();
			}       
    }

    public static void create_new_user()
    {
        cn=cn+1;
        System.out.println("\nEnter Name(Username) : ");
        name=in.nextLine();
        System.out.println("Enter Password : ");
        pass=in.nextLine();
        System.out.println("Enter Age: ");
        age = in.nextInt();
        user[cn]=new Contestant(name,pass,age,admin);
    }
    
    public static void admin_login()
    {
        System.out.println("Enter Username: ");
        name = in.next();
        System.out.println("Enter Password: ");
        pass = in.next();
        if(name.equals("admin"))
        {
            admin(admin);
        }
        else
            menu();
    }
    
    public static void login()
    {
        int pos = -1,c ;
        System.out.println("\n1.Login as Admin");
        System.out.println("2.Login as User");
        System.out.println("Enter Choice : ");
		c = in.nextInt();
        if(c == 1)
        {
            admin_login();
        }
        else
        {
            try
            {
                pos = login_user();
                clearScreen();
            }
            catch(UserNotFoundException e)
            {
                System.out.println(e);
                menu();
            }
            user(pos);
        }
    }
    
    public static int login_user() throws UserNotFoundException
    {
                     int uindex = -1;
                        int flag = 0;
                        System.out.println("Enter Username: ");
                        name = in.next();
                        System.out.println("Enter Password: ");
                        pass = in.next();
         
                       
                        for(int i=0;i<=cn;i++)
                        {
                            if(user[i].username.equals(name) && user[i].passwd.equals(pass))
                            {
                               uindex = i;
                               flag=1;
                            }  
                        }
                        if(flag==0)
                        {
                            throw new UserNotFoundException(name);
                        }
                        
                        return uindex;
    }
    
    public static void leaderboard()
    {
        System.out.println("\nQuiz Chart");
        for(int i=0;i<=cn;i++)
        {
            System.out.println("Name :"+user[i].username);
            user[i].display_points();
        }
    }
    
    
    
    public static void user(int uindex)
    {
        while(1!=0)
        {
        int uchoice=0;
        
        System.out.println("\t\tWelcome "+user[uindex].username);
        System.out.println("\n\t\t\t\tMenu");
        System.out.println("\t\t1.Attempt Quiz");
        System.out.println("\t\t2.View LeaderBoard");
        System.out.println("\t\t3.View Points");
        System.out.println("\t\t4.View Feedback");
        System.out.println("\t\t5.Return to User Menu");
        System.out.print("\t\tEnter Choice : ");
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
                                    ans=in.nextLine();
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
                                leaderboard();
                            }
                            else if(uchoice==3)
                            {
                                    System.out.println("\n Your points are");
                                    user[uindex].display_points();  
                            }
                            else if(uchoice==4)
                            {
                                    System.out.println("Feedback: \n "+ user[uindex].get_feedback());
                            }
                            else if(uchoice==5)
                            {
                                menu();
                            }
                            System.out.println("Press Enter to Continue ... ");
                            in.nextLine();
                            clearScreen();
    
        }
    }

public static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
}  
    
    
public static void main(String[] args)     
    {
            menu();                  
    }
}
    
   
