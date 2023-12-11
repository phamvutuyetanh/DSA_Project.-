package Sourcecode.SortingAlgorithm;

import java.util.ArrayList;
import Sourcecode.Main.App;
import Sourcecode.Main.Draw;

public class SelectionSort extends BaseSort{
    
	public SelectionSort (ArrayList<Integer> array)          // constructor
    {
    super(array);
  
    }

	@Override
	public void excutesort(Draw draw, App app) throws InterruptedException {
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
	      app.setneedReset(true);
      
		
	}
}
