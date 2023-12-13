package SortingAlgorithm;

import java.util.ArrayList;


import Main.App;
import Main.Draw;

public class BubbleSort extends BaseSort{
  // private boolean swapped = true;
	public BubbleSort (ArrayList<Integer> array)          // constructor
    {
		super(array);

    }

	@Override
	public void excutesort(Draw draw, App app) throws InterruptedException {
		int out,in;
		int nSwaps=0;
		for(out = nElems-1;out>1;out--){
			for(in=0;in<out;in++){
				if(nums.get(in)>nums.get(in+1)){
					swap(in,in+1);
					nSwaps++;
					
				}
				Thread.sleep(25);
					draw.removeAll();
					draw.updateArray(nums);
					draw.revalidate();
					draw.paintImmediately(0,30,2000,1000);//870,532
					System.out.println(nums);
			}
		}
		//    BbSort(nums,draw);
	    //     swapped = true;
	      app.setneedReset(true);
      

	}
	// private void BbSort(ArrayList<Integer> arr, Draw draw) throws InterruptedException {
	// 	int out,in, nElems;
	// 	int nSwaps=0;
	// 	nElems= arr.size();
	// 	for(out=nElems-1;out>1;out--){
	// 		for(in=0;in<out;in++){
	// 			if(arr.get(in)>arr.get(in+1)){
	// 				swap(arr.get(in),arr.get(in+1));
	// 				nSwaps++;
	// 				Thread.sleep(25);
	// 				draw.removeAll();
	// 				draw.updateArray(nums);
	// 				draw.revalidate();
	// 				draw.paintImmediately(0,30,2000,1000);//870,532
	// 				System.out.println(nums);
	// 			}
	// 		}
	// 	}


	// }
}
