/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llist;

import java.util.*;
/**
 *
 * @author rishi
 */
public class Llist {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner in = new Scanner(System.in);
        LinkedList<Integer> llist = new LinkedList <Integer>();
        System.out.println("Enter Size of List :");
        int n = in.nextInt();
        int i, ele, pos;
        for(i = 0;i<n;i++)
        {
            System.out.print("Enter element: ");
            ele = in.nextInt();
            llist.add(ele);
        }
        
        System.out.println("\nList is as follows"+ llist);
        System.out.println("Enter Element to insert at FRONT: ");
        ele = in.nextInt();
        llist.addFirst(ele);
        System.out.println("Enter Element to insert at END: ");
        ele = in.nextInt();
        llist.addLast(ele);
        System.out.println("Modified List is "+ llist);
        
        System.out.println("Enter Element to insert at position: ");
        ele = in.nextInt();
        System.out.println("Enter position to insert ELement: ");
        pos = in.nextInt();
        llist.add(pos, ele);
        System.out.println("Modified List is "+ llist);

        System.out.println("Removing elements from both sides!");
        llist.removeFirst(); 
        llist.removeLast();
        System.out.println("Modified List is "+ llist);
        
        System.out.println("Enter element to remove: ");
        ele = in.nextInt();
        if(llist.contains(ele))
            llist.remove(new Integer(ele));
        else
            System.out.println("No Element Found!");
        
        System.out.println("List After Deletion: "+ llist);
        

        LinkedList<Integer> k = new LinkedList<Integer>();
        Collections.copy(llist,k);

        
        Collections.sort(llist);
        System.out.println("Sorted List: "+ llist);
       
        System.out.println("Enter element to find position: ");
        ele = in.nextInt();
        pos = llist.indexOf(ele);
        System.out.println("Position of "+ ele + " in list : "+ pos);
        
        LinkedList<Integer> tmp = new LinkedList<Integer>();
        tmp = llist;
        System.out.println("Displaying list in forward order "+ llist);
        System.out.println("\nDisplaying list in reverse order");
        System.out.println("\nAlgorithm Manner");
        Collections.reverse(llist);
        System.out.println(llist);
        
        System.out.println("\nUn Algorithm Manner");
        ListIterator<Integer> litr = tmp.listIterator(tmp.size());
        while(litr.hasPrevious())
        {
            System.out.print(litr.previous());
        }
        
        int total = 0, avg;
        for(i = 0; i<llist.size(); i++)
        total = total+llist.get(i);
        avg = total / llist.size();
        System.out.println("\n\nThe Total is: "+ total);
        System.out.println("The Average IS:" + avg);
        
        LinkedList<Integer> newll = new LinkedList<Integer>(llist.subList(3,llist.size()));
        
        LinkedList<Integer> result = new LinkedList<Integer>();
        result.addAll(k);
        result.addAll(newll);
        System.out.println("Newly Created List is: "+ result);

    
    
    }
    
}
