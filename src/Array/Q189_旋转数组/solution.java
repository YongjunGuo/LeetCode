package Array.Q189_旋转数组;

/*
* 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
示例 1:
输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
*/

import java.util.Scanner;

public class solution {
    public void rotate(int[] nums, int k){
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    public void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入nums元素个数：");
        int nn = scanner.nextInt();
        int nums[] = new int[nn];
        System.out.println("请输入nums元素：");
        for(int n = 0; n < nn; n++){
            int m = scanner.nextInt();
            nums[n] = m;
        }
        System.out.println("请输入k：");
        int k = scanner.nextInt();
        System.out.println("输出结果k：");
        new solution().rotate(nums, k);
        for (int i : nums) System.out.print(i + " ");



    }
}
