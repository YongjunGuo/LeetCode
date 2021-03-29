package Bishi;

import java.util.Scanner;

public class Exam360 {
    public static void main(String args[]){
        Scanner sc  = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int[] score = new int[N];
        int[] dis = new int[N];
        for(int i = 0; i < N; i++){
            dis[i] = sc.nextInt();
            score[i] = sc.nextInt();
        }
        int[][] dp = new int[N+1][K+1];
        for(int i = 0;i <= N; i++){
            for (int j = 0; j <= K; j++)
                dp[i][j] = -1;
        }
        dp[0][K] = score[0];
        int res = -1;
        for (int i =1; i < N; i++){
            for (int j = i-1; j>=0; j--){
                if (dis[i] - dis[j] <= M){
                    for (int l =1; l <= K; l++){
                        if (dp[j][l] != -1){
                            dp[i][l-1] = Math.max(dp[i][l-1], dp[j][l]+score[i]);
                            res = Math.max(dp[i][l-1], res);
                        }
                    }
                }
            }
        }
        System.out.println(res);
    }

}
