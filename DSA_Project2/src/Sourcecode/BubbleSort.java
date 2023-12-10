package Sourcecode;
import javax.swing.*;
import java.util.*;

public class BubbleSort extends JPanel {
    boolean swapped = true;
    
    public void executeBubbleSort(ArrayList<Integer> nums, Draw draw, App app) throws InterruptedException {
        // Start bubble sorting
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
        app.needReset = true;
    }
}
