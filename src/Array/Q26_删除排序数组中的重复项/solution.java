package Array.Q26_删除排序数组中的重复项;

/*
* 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
* 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
*/

import java.util.Scanner;

public class solution {
    public int removeDuplicate(int[] nums){
        if(nums.length == 0){
            return 0;
        }
        int i =0; //慢指针
        for(int j = 1; j < nums.length; j++){ //快指针
            if(nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String args[]){
        //int nums[] = {1, 1, 2};
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组长度：");
        int nl = scanner.nextInt();
        int nums[] = new int[nl];
        System.out.println("请输入数组元素：");
        for(int n = 0; n < nl; n++){
            int m = scanner.nextInt();
            nums[n] = m;
        }

        System.out.println(new solution().removeDuplicate(nums));
    }
}
