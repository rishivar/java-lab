/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
class Electricitybill{
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        String name;
        int id;
        float prev;
        float curr;
        char type;
        System.out.println("Enter name of consumer");
        name=(String) in.nextLine();
        System.out.println("Enter ID of consumer");
        id= (int) in.nextInt();
        System.out.println("Enter Previous Current rating ( units) : ");
        prev = (float) in.nextFloat();
        System.out.println("Enter Current Current rating ( units) : ");
        curr = (float) in.nextFloat();
        System.out.println("Enter type , Commercial ('c') or Domestic ('d') ");
        type = (char) in.next().charAt(0);
        
        
        EB e = new EB(type,name,prev,curr,id);
        e.calctarrif();
        e.printbill();
        
    }
    
}
/**
 *
 * @author cs1126
 */
class EB {
    
    private String consumer_name;
    private int consumer_no;
    private float prev;
    private float curr;
    private char t;
    private float tarrif;
    
    
    
    public EB(char type, String name, float pre, float cur, int con)
    {
        consumer_name=name;
        consumer_no=con;
        prev=pre;
        curr=cur;
        t=type;
    }
    void calctarrif() 
    {
        float diff=curr-prev;
        if(t=='d')
        {
            if(diff<=100)
            {
                tarrif = diff*1;
            }
            if(diff>100 && diff<=200)
            {
                tarrif = 100f + (diff-100)*(2.5f);
            }
            if(diff>200 && diff<=500)
            {
                tarrif = 100 + 100*(2.5f) + (diff-200) * 4;
            }
            if (diff>500)
            {
                tarrif = 100 + 100 * (2.5f) + 300 * 4 + (diff-500) * 6;
            }
        }
        if(t=='c')
        {
            if(diff<=100)
            {
                tarrif = diff*2;
            }
            else if(diff>100 && diff<=200)
            {
                tarrif = 200 + (diff-100)*(4.5f);
            }
            else if(diff>200 && diff<=500)
            {
                tarrif = 200 + 100*(4.5f) + (diff-200) * 6;
            }
            else if (diff>500)
            {
                tarrif = 200 + 100 * (4.5f) + 300 * 6 + (diff-500) * 7;
            }
        }
    }
    void printbill()
    {
                String str;
                if(t=='c')
                     str = "Commercial";
                else
                     str = "Domestic";
                float diff=curr-prev;
              
                System.out.println("*************************************************");
                System.out.println("Consumer Name                :"+ consumer_name);
                System.out.println("Consumer ID                  :"+ consumer_no);
                System.out.println("Previous Reading             :"+ prev);
                System.out.println("Current Reading              :"+ curr);
                System.out.println("Type of EB Connection        :"+ str);
                System.out.println("Number of Units              :"+ diff);
                System.out.println("Tarrif                       :"+ tarrif + "rs");
                System.out.println("*************************************************");

                
              
    }
}
    

   
