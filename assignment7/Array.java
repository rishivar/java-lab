/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array;


import java.util.*;

class Array
{
	public static void main(String args[])
	{       int i = 0;
		Scanner in = new Scanner(System.in);
		ArrayList<String> alist = new ArrayList<String>();
		for(i=0;i < 10; i++)
		{
			System.out.print("Enter String: ");
			String n = in.next();
			alist.add(n);
		}
                System.out.println();
		System.out.println("List After Adding 10 Elements: "+ alist);
		System.out.println();
                
                System.out.println("Enter String to enter at speciic position: ");
                String target = in.next();
                System.out.println("\nEnter position to insert element in list: ");
                int pos = in.nextInt();
                alist.add(pos, target);
                System.out.println("\nList After Inserting ELement : "+ alist);
              
                
                System.out.println("\nEnter element to display occurence: ");
                target = in.next();
                int count = 0;
                Iterator<String> itr = alist.iterator();
                while(itr.hasNext())
                {
                    String tmp = itr.next();
                    if(tmp.equals(target))
                    {
                        count+=1;
                    }
                }
                if(count!=0)
                    System.out.print("\nOccurence: \n"+ count);
                else
                    System.out.println("No Occurence\n");
                
                System.out.println("\nEnter Letter to find String that starts with it: ");
                char t1 = in.next().charAt(0);
                System.out.println("Strings that start with "+ t1 +" are");
                for(String t: alist)
                {
                    char t2 = t.charAt(0);
                    if(t2==t1)
                    {
                       System.out.print(t+ " ");
                    }
                }
                System.out.println();
                
                System.out.println("\nEnter SubString: ");
                target = in.next();
                System.out.println("Strings that contain the Substring are: ");
                for(String t: alist)
                {
                    if(t.contains(target))
                    {
                        System.out.println(t+ " ");
                    }
                }
                
                System.out.println();
                System.out.println("Enter String to replace");
                String tar1 = in.next();
                System.out.println("Enter replacement String");
                String tar2 = in.next();
                ListIterator<String> it = alist.listIterator();
                while(it.hasNext()) 
                {
                    it.set(it.next().replace(tar1,tar2));
                }
                System.out.println("\nList After Replacement: "+ alist );
                System.out.println();
                
                System.out.println("Enter element to remove: ");
                target = in.next();
                alist.remove(target);
                System.out.println("\nList After Removal: "+ alist );
                System.out.println();
             
                Set<String> set = new HashSet<>(alist);
                alist.clear();
                alist.addAll(set);
                System.out.println("After Removal of Duplicates: "+ alist);
                System.out.println();
                
                System.out.println("Displaying List: "+ alist);
                
        }
        
}
