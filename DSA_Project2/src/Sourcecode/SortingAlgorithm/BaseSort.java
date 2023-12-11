package Sourcecode.SortingAlgorithm;

import java.util.ArrayList;

import Sourcecode.Main.App;
import Sourcecode.Main.Draw;

public abstract class BaseSort {
    protected ArrayList<Integer> nums;                 // ref to array a
	protected int nElems;               // number of data items
	public static int nCompare;
	
	public BaseSort(ArrayList<Integer>array) {
		nums = array;                 // create the array
	      nElems = array.size();                        // no items yet
	      nCompare =0;
	}
	
	public void setarray(ArrayList<Integer> array) {
   	 nums = array;
   	 nElems = array.size();                        // no items yet
	      nCompare =0;
   }
	
	 protected void swap(int one, int two)
	    {
	    int temp = nums.get(one);
	    int temp2 =  nums.get(two);
	    nums.set(one, temp2);
	    nums.set(two, temp);
	    }
	public abstract void excutesort(Draw draw, App app) throws InterruptedException;
	
}
