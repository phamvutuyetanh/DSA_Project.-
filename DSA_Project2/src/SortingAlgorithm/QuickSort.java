package SortingAlgorithm;

import java.util.ArrayList;

import Main.App;
import Main.Draw;

public class QuickSort extends BaseSort{
    public QuickSort (ArrayList<Integer> array)          // constructor
    {
    super(array);
  
    }

	@Override
	public void excutesort(Draw draw, App app) throws InterruptedException {
		recQuickSort(0, nElems-1, draw);
        app.setneedReset(true);
    }
	
	
	public int partitionIt(int left, int right, long pivot, Draw draw) throws InterruptedException
    {
    int leftPtr = left-1;           // left    (after ++)
    int rightPtr = right;  // right-1 (after --)
    
    while(true)
       {                            // find bigger item
       while( nums.get(++leftPtr)< pivot ){
          ;  // (nop)
                                    // find smaller item
          nCompare++;
       }
       while(rightPtr > 0 && nums.get(--rightPtr) > pivot) {
          ;  // (nop)
          nCompare++;
       }
       if(leftPtr >= rightPtr) {      // if pointers cross,
          break;          }          //    partition done
       else          {               // not crossed, so
          swap(leftPtr, rightPtr);  //    swap elements
          draw.updateArray(nums);
        draw.paintImmediately(0,30,2000,800);//870,532
        Thread.sleep(50);
       }
       }  // end while(true)
    swap(leftPtr, right);           // restore pivot
    draw.updateArray(nums);
    draw.paintImmediately(0,30,2000,1000);//870,532
    Thread.sleep(50);
    return leftPtr;                 // return pivot location
    }  // end partitionIt()

    public void recQuickSort(int left, int right, Draw draw) throws InterruptedException
    {
		//left:low, right: hight
    if(right-left <= 0)              // if size <= 1,
        return;                      //    already sorted
    else                             // size is 2 or larger
       {
       long pivot = nums.get(right);      // rightmost item
                                          // partition range
       int partition = partitionIt(left, right, pivot, draw);
       recQuickSort(left, partition-1, draw);   // sort left side
       recQuickSort(partition+1, right, draw);  // sort right side
       }
    }  // end recQuickSort()
}
