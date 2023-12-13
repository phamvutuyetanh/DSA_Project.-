package SortingAlgorithm;

import java.util.ArrayList;

import Main.App;
import Main.Draw;

public abstract class BaseSort {
	protected ArrayList<Integer> nums; // ref to array a
	protected int nElems; // number of data items
	public static int nCompare;
	public static int nSwaps;

	public BaseSort(ArrayList<Integer> array) {
		nums = array; // create the array
		nElems = array.size(); // no items yet
		nCompare = 1;
		nSwaps = 0;
	}

	public int getncompare() {
		return nCompare;
	}

	public void setncompare() {
		nCompare = 0;
	}

	public int getnSwaps() {
		return nSwaps;
	}

	public void setnSwaps() {
		nSwaps = 0;
	}

	public void setarray(ArrayList<Integer> array) {
		nums = array;
		nElems = array.size(); // no items yet
		nCompare = 0;
		nSwaps = 0;
	}

	protected void swap(int one, int two) {
		int temp = nums.get(one);
		int temp2 = nums.get(two);
		nums.set(one, temp2);
		nums.set(two, temp);
	}

	public abstract void excutesort(Draw draw, App app) throws InterruptedException;

}
