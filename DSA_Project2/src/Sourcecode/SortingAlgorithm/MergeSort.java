package Sourcecode.SortingAlgorithm;

import java.util.ArrayList;

import Sourcecode.Main.App;
import Sourcecode.Main.Draw;

public class MergeSort extends BaseSort {
    public MergeSort(ArrayList<Integer> array) { // inherits
        super(array);
    }

    @Override
    public void excutesort(Draw draw, App app) throws InterruptedException { // constructor
        mergeSort(nums, 0, nums.size() - 1, draw);
        app.setneedReset(true);
    }

    private void mergeSort(ArrayList<Integer> arr, int left, int right, Draw draw) throws InterruptedException {
        if (left < right) { // left is left of array means start index, right is end index
            int mid = left + (right - left) / 2; // middle of array

            mergeSort(arr, left, mid, draw); // sort from the left index to the middle index
            mergeSort(arr, mid + 1, right, draw); // sort from the middle + 1 index to the right index

            merge(arr, left, mid, right, draw); // merge 2 sorted subarray
        }
    }

    private void merge(ArrayList<Integer> arr, int left, int mid, int right, Draw draw) throws InterruptedException {
        int nLeft = mid - left + 1; // size of left subarray
        int nRight = right - mid; // size of the right subarray

        ArrayList<Integer> leftArr = new ArrayList<>(arr.subList(left, left + nLeft));
        ArrayList<Integer> rightArr = new ArrayList<>(arr.subList(mid + 1, mid + 1 + nRight));

        int i = 0, j = 0; // i is index of lefrArr, j is index of rightArr
        int k = left; // k is index of arr
        while (i < nLeft && j < nRight) { // case both leftArr and rightArr still have ele to merge
            if (leftArr.get(i) <= rightArr.get(j)) {
                arr.set(k, leftArr.get(i)); // set arr at k is = leftArr at i
                i++;
            } else {
                arr.set(k, rightArr.get(j)); // set arr at k is = rightArr at j
                j++;
            }
            draw.updateArray(arr);
            draw.paintImmediately(0, 30, 2000, 800);
            Thread.sleep(50);
            k++;
        }

        while (i < nLeft) { // case leftArr still has ele remain after rightArr has merged all ele
            arr.set(k, leftArr.get(i)); // set arr at k is = leftArr at i
            i++;
            k++;
            draw.updateArray(arr);
            draw.paintImmediately(0, 30, 2000, 800);
            Thread.sleep(50);
        }

        while (j < nRight) { // case rightArr still has ele remain after leftArr has merged all ele
            arr.set(k, rightArr.get(j)); // set arr at k is = rightArr at j
            j++;
            k++;
            draw.updateArray(arr);
            draw.paintImmediately(0, 30, 2000, 800);
            Thread.sleep(50);
        }
    }
}
