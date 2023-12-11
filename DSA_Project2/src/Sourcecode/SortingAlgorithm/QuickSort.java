package Sourcecode.SortingAlgorithm;

import java.util.ArrayList;
import java.util.Collections;

import Sourcecode.Main.App;
import Sourcecode.Main.Draw;

public class QuickSort extends BaseSort{
    public QuickSort (ArrayList<Integer> array)          // constructor
    {
    super(array);
  
    }

	@Override
	public void excutesort(Draw draw, App app) throws InterruptedException {
		quickSort(nums, draw,0, nums.size() - 1);
        app.setneedReset(true);
    }
	
	
	public int partition(ArrayList<Integer> subArray, Draw draw, int low, int high) throws InterruptedException {
        int i = low;
        int pivot = subArray.get(high);

        for (int j = low; j < high; j++) {
            if (subArray.get(j) < pivot) {
                Collections.swap(subArray, i, j);

                draw.updateArray(subArray);
                draw.paintImmediately(0,30,2000,800);//870,532
                Thread.sleep(50);


                i++;
            }
        }
        Collections.swap(subArray, i, high);

        draw.updateArray(subArray);
        draw.paintImmediately(0,30,2000,1000);//870,532
        Thread.sleep(50);

        return i;
    }

    public void quickSort(ArrayList<Integer> array, Draw draw, int low, int high) throws InterruptedException {
        if (low < high) {
            int div = partition(array, draw, low, high);

            quickSort(array, draw, low,div - 1);
            quickSort(array, draw, div + 1, high);
        }
    }
}
