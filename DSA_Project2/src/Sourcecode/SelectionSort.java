package Sourcecode;

import javax.swing.*;

//import java.awt.Color;
import java.util.*;

public class SelectionSort extends JPanel {
	 private ArrayList<Integer> nums;                 // ref to array a
	   private int nElems;               // number of data items
	   public static int nCompare;
	  
	//--------------------------------------------------------------
	   public SelectionSort (ArrayList<Integer> array)          // constructor
	      {
	      nums = array;                 // create the array
	      nElems = array.size();                        // no items yet
	      nCompare =0;
	    
	      }

    public void executeSelectionSort(Draw draw, App app) throws InterruptedException {
        int out, in, min; 
	      for(out=0; out<nElems - 1; out++)   // outer loop
	         {
	         min = out;                     // minimum
	         
	         for(in=out+1; in<nElems; in++) { // inner loop
	        	 nCompare++;
	            if(nums.get(in) < nums.get(min) )         // if min greater,  
	            	min = in;   }            // we have a new min
	         swap(out, min);                // swap them
	         Thread.sleep(100);
	            draw.removeAll();
	            draw.updateArray(nums);
	            draw.revalidate();
	            draw.paintImmediately(0,30,2000,1000);//870,532
	         } 
        app.needReset = true;
    }
    
    private void swap(int one, int two)
    {
    int temp = nums.get(one);
    int temp2 =  nums.get(two);
    nums.set(one, temp2);
    nums.set(two, temp);
    }
	public void setarray(ArrayList<Integer> array) {
		nums = array;
		nElems = array.size();                        // no items yet
		 nCompare =0;
   }
}
