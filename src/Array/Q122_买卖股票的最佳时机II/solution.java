package Array.Q122_买卖股票的最佳时机II;

/*
* 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
* 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
* 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
* */

import java.util.Scanner;


public class solution {
    public int maxProfit(int[] prices){
        /*
        * 我们可以直接继续增加加数组的连续数字之间的差值，如果第二个数字大于第一个数字，我们获得的总和将是最大利润。
        * */
        int maxprofit = 0;
        for(int i = 1; i < prices.length; i++){
            if (prices[i] > prices[i - 1]){
                maxprofit += prices[i] - prices[i -1];
            }
        }
        return maxprofit;
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入股票天数：");
        int pl = scanner.nextInt();
        int prices[]  = new int[pl];
        System.out.println("请输入每天股票的价格：");
        for(int n = 0; n < pl; n++){
            int m = scanner.nextInt();
            prices[n] = m;
        }

        System.out.println(new solution().maxProfit(prices));
    }
}
