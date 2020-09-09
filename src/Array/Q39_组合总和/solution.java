package Array.Q39_组合总和;

/*
* 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
* candidates 中的数字可以无限制重复被选取。
* */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> res= new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, res, combine, 0 );
        return res;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> combine, int idx){
        if(idx == candidates.length){
            return;
        }

        if(target == 0){
            res.add(new ArrayList<Integer>(combine));
            return;
        }

        dfs(candidates, target, res, combine, idx + 1);

        if (target - candidates[idx] >= 0){
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], res, combine, idx);
            combine.remove(combine.size() - 1);

        }
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入candidates元素个数：");
        int cl = scanner.nextInt();
        int candidates[] = new int[cl];
        System.out.println("请输入candidates元素：");
        for(int n = 0; n < cl; n++){
            int m = scanner.nextInt();
            candidates[n] = m;
        }
        System.out.println("请输入target：");
        int target = scanner.nextInt();
        System.out.println("输出结果：");
        System.out.println(new solution().combinationSum(candidates, target));


    }
}
