package Array.Q122_买卖股票的最佳时机II;

import java.util.Scanner;

public class solution {
    public int maxProfit(int[] prices){
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
