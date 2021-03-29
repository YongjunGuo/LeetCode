package Array.NC119_最小的K个数;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
* 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可
* */

public class solution {
    public int[] smallestK(int[] arr, int k) {
        randomizedSelected(arr, 0, arr.length - 1, k);

        int[] vec = new int[k];

        for (int i = 0; i < k; ++i) {
            vec[i] = arr[i];
        }
        return vec;
    }

    private void randomizedSelected(int[] arr, int l, int r, int k) {
        if (l >= r) {
            return;
        }
        int pos = randomizedPartition(arr, l, r);
        int num = pos - l + 1;
        if (k == num) {
            return;
        } else if (k < num) {
            randomizedSelected(arr, l, pos - 1, k);
        } else {
            randomizedSelected(arr, pos + 1, r, k - num);
        }
    }

    // 基于随机的划分
    private int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l;
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        //int[] arr = {1,3,5,2,4,7,6,9,8};

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组长度：");
        int nl = scanner.nextInt();
        int arr[] = new int[nl];
        System.out.println("请输入数组元素：");
        for(int n = 0; n < nl; n++){
            int m = scanner.nextInt();
            arr[n] = m;
        }
        System.out.println("请输入k的值：");
        int k = scanner.nextInt();
        solution s = new solution();
        int[] res = s.smallestK(arr, k);
        System.out.println(Arrays.toString(res));

        //System.out.println(new solution().smallestK(arr, k));
    }

}
