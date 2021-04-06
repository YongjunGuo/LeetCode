package Bishi;

/*
* 二分查找
* */

import java.util.Scanner;

public class BinarySearch {
    public int binarysearch(int key, int[] array){
        int low = 0;
        int high = array.length-1;
        int middle = 0;
        if (key < array[low] || key > array[high] || low >high){
            return -1;
        }
        while(low <= high){
            middle = low + (high - low )/2;
            if (middle == key){
                return middle;
            }else if (middle < key){
                low = middle + 1;
            }else{
                high = middle -1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        //int nums[] = {1, 1, 2，4，4,5,6,6,7};


        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查找的数：");
        int key = scanner.nextInt();

        System.out.println("请输入数组长度：");
        int nl = scanner.nextInt();
        int array[] = new int[nl];
        System.out.println("请输入数组元素：");
        for (int n = 0; n < nl; n++) {
            int m = scanner.nextInt();
            array[n] = m;
        }
        System.out.println(new BinarySearch().binarysearch(key,array));
    }
}
