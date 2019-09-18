/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

class Author
{
  private String name;
  private String email;
  private char gender;
  public Author(String name, String email, char gender)
  {
    this.name   = name;
    this.email  = email;
    this.gender = gender;
  }
  String getName()
  {
    return name;
  }
  String getEmail()
  {
    return email;
  }
  void setEmail(String email)
  {
    this.email = email;
  }
  char getGender()
  {
    return gender;
  }
}

class Book
{
  private String name;
  private Author author;
  private double price;
  private int qty = 0;
  public Book(String name, Author author, double price)
  {
    this.name = name;
    this.author = author;
    this.price = price;
  }
  public Book(String name, Author author, double price, int qty)
  {
    this.name = name;
    this.author = author;
    this.price = price;
    this.qty = qty;
  }
  String getName()
  {
    return name;
  }
  Author getAuthor()
  {
    return author;
  }
  void setPrice( double price )
  {
    this.price = price;
  }
  double getPrice()
  {
    return price;
  }
  void setQty(int qty)
  {
    this.qty = qty;
  }
  int getQty()
  {
    return qty;
  }
}

class TestBook
{
  public static void main(String args[])
  {
    Scanner in = new Scanner(System.in);
    String bname,aname,email;
    int qty=0,ch=0,bcount = 0, i = 0, flag = 0;
    double price;
    char gender, choice;
    Book[] B = new Book[100];
    Author A;
    A=new Author("name","email",'M');
    while(ch!=6)
    {
      System.out.println("\t\tMenu ");
      System.out.println("1. Enter Book Details ");
      System.out.println("2. Display Author Details ");
      System.out.println("3. Display Book Details ");
      System.out.println("4. Modify Author Details ( Email ) ");
      System.out.println("5. Modify Book Details ");
      System.out.println("6. Exit");
      System.out.print("Enter your choice : ");
      ch = in.nextInt();  
   
      if(ch==1)
      {
      System.out.print("\nEnter Name of Book : ");
      bname = in.next();
      System.out.print("Enter Name of Author of Book : ");
      aname = in.next();
      System.out.print("Enter Price of Book : ");
      price = in.nextDouble();
      System.out.print("Do you wish to Enter Quantity of Book ( Y / N ) ? ");
      choice = in.next().charAt(0);
      if(choice == 'Y'||choice == 'y')
      {
        System.out.print("Enter Quantity of Book : ");
        qty = in.nextInt();
      }
      flag=0;
      for(i=0;i<bcount;i++)
      {
        A=B[i].getAuthor();
        if(A.getName().equals(aname))
        {
          flag = 1;
          break;
        }
      }
      if(flag == 0)
      {
        System.out.print("Enter Email of Author: ");
        email = in.next();
        System.out.print("Enter Gender of Author ( M / F ): ");
        gender = in.next().charAt(0);
        A=new Author(aname, email, gender);
      }
      if( choice == 'Y'||choice == 'y')
      {
        B[bcount]=new Book(bname,A,price,qty);
        bcount+=1;
      }
      else
      {
        B[bcount]=new Book(bname,A,price);
        bcount+=1;
      }
      }

      else if(ch==2)
      {
        System.out.print("\nEnter name of Author to Display Details : ");
        aname = in.next();
        flag=0;
        for(i=0;i<bcount;i++)
        {
          A=B[i].getAuthor();
          if(A.getName().equals(aname))
          {
            flag = 1;
            break;
          }
        }
        if(flag==0)
        {
          System.out.println("No Record found ");
        }
        else
        {
          System.out.println(" Name of Author   : "+ A.getName());
          System.out.println(" Email of Author  : "+ A.getEmail());
          System.out.println(" Gender of Author : "+ A.getGender());
        }
      }

      else if(ch==3)
      {
        System.out.print("\nEnter Name of Book to Display Details : ");
      bname = in.next();
      flag=0;
      for(i=0;i<bcount;i++)
      {
        System.out.println(B[i].getName());
        if(B[i].getName().equals(bname))
        {
          flag = 1;
          break;
        }
      }
      if(flag==0)
      {
        System.out.println(" No Record found ");
      }
      else
      {
        System.out.println(" Name of Book      : "+ B[i].getName());
        System.out.println(" Name of Author    : "+ B[i].getAuthor().getName());
        System.out.println(" Price of Book     : "+ B[i].getPrice());
        System.out.println(" Quantity of Book  : "+ B[i].getQty());
      }

      }

      else if(ch==4)
      {
        System.out.print("\nEnter name of Author to Change Email : ");
        aname = in.next();
        flag=0;
        for(i=0;i<bcount;i++)
        {
          A=B[i].getAuthor();
          if(A.getName().equals(aname))
          {
            flag = 1;
            break;
          }
        }
        if(flag==0)
        {
          System.out.println(" No Record found");
        }
        else
        {
          System.out.println(" Enter new email ");
          email = in.next();
          B[i].getAuthor().setEmail(email);
          System.out.println(" Email changed !");
        }
      }
      else if(ch==5)
      {
        System.out.print("\nEnter Name of Book to Modify : ");
      bname = in.next();
      flag=0;
      for(i=0;i<bcount;i++)
      {
        if(B[i].getName().equals(bname))
        {
          flag = 1;
          break;
        }
      }
      if(flag==0)
      {
        System.out.println(" No Record found : ");
      }
      else
      {
        System.out.println(" Modify ");
        System.out.println(" 1. Price ");
        System.out.println(" 2. Quantity ");
        System.out.println("Enter Choice : ");
        ch = in.nextInt();
        if(ch == 1)
        {
          System.out.print("Enter New Price : ");
          price = in.nextDouble();
          B[i].setPrice(price);
        }
        else if(ch == 2)
        {
          System.out.print("Enter New quantity : ");
          qty = in.nextInt();
          B[i].setQty(qty);
        }
      }
      }
    }
  }
}
