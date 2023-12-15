package SortingAlgorithm;
import Main.App;
import Main.Draw;
import java.util.ArrayList;
public class ShellSort extends BaseSort {

    public ShellSort(ArrayList<Integer> array) // constructor
	{
		super(array);

	}
    @Override
    public void excutesort(Draw draw, App app) throws InterruptedException {
        int inner, outer;
        int temp;
        int h = 1; // find initial value of h
        while (h <= nElems / 3)
            h = h * 3 + 1; // (1, 4, 13, 40, 121, ...)
        while (h > 0) // decreasing h, until h=1
        {
            // h-sort the file
            for (outer = h; outer < nElems; outer++) {
                temp = nums.get(outer);
                inner = outer;
                // one subpass (eg 0, 4, 8)
                while (inner > h - 1 && nums.get(inner - h) >= temp) {
                    nums.set(inner,nums.get(inner-h));
                    inner -= h;
                    Thread.sleep(50);
					draw.updateArray(nums);
					draw.paintImmediately(0, 30, 2000, 1000);// 870,532
					System.out.println(nums);
                }
                nums.set(inner,temp);
            }
            h = (h - 1) / 3; 
            app.setneedReset(true);

       
            }
           
        
       
    }}
    
