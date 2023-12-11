package Sourcecode.SortingAlgorithm;

import java.util.ArrayList;
import java.util.Collections;

import Sourcecode.Main.App;
import Sourcecode.Main.Draw;

public class BubbleSort extends BaseSort{
    private boolean swapped = true;
	public BubbleSort (ArrayList<Integer> array)          // constructor
    {
		super(array);
  
    }
	
	@Override
	public void excutesort(Draw draw, App app) throws InterruptedException {
		 while (swapped) {
	            swapped = false;
	            for (int i = 0; i < nums.size() - 1; i++) {
	                if (nums.get(i) > nums.get(i+1)) {
	                    Collections.swap(nums, i, i+1);
	                    swapped = true;

	                    Thread.sleep(10);
	                    draw.removeAll();
	                    draw.updateArray(nums);
	                    draw.revalidate();
	                    draw.paintImmediately(0,30,2000,800);//870,532
	                }
	            }
	        }
	        swapped = true;
	      app.setneedReset(true);
      
		
	}
}
