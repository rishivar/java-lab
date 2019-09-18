import java.util.*;
public class NumberGuess {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in=new Scanner(System.in);
        int inp=0,n;
        int count=1;
        double num;
        num=Math.random()*100;
        n=(int)num;
        System.out.println("Key in your Guess :");
        while(inp!=n)
        {
            inp=in.nextInt();
            if(inp==n)
            {
                System.out.println("You got it in "+count+" Tries");
                break;
            }
            else if(inp>n)
            {
                System.out.println("Try Lower");
            }
            else
            {
                System.out.println("Try Higher");
            }
            count++;
        }
        System.out.println("End!!!");
    }
}