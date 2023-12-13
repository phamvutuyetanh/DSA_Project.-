package SortingAlgorithm;

import java.util.ArrayList;

import Main.App;
import Main.Draw;

public class InsertionSort extends BaseSort{
    // private int nAccess=0;
    // private int nCompare=0;
    public InsertionSort (ArrayList<Integer> array)          // constructor
    {
    super(array);
  
    }

	@Override
	public void excutesort(Draw draw, App app) throws InterruptedException {
		for (int out = 1; out < nElems; out++) {
            int temp = out;
            int in = temp - 1;

            while (in >= 0 && nums.get(in) > nums.get(temp)) {
                // Swap and decrement
                nCompare++;
                //nAccess += 2;
                swap(in, temp);
                temp = temp - 1;
                in = in - 1;

                Thread.sleep(25);
                draw.removeAll();
                draw.updateArray(nums);
                draw.revalidate();
                draw.paintImmediately(0,30,2000,1000);//870,532
                System.out.println(nums);
            }
        }
		app.setneedReset(true);
		
	}
}
