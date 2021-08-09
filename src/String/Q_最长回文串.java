package String;

import String.Q647_回文子串.A1.solution;

import java.util.Scanner;

public class Q_最长回文串 {


    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }


    public static  void main(String [] args){
        String s = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入字符串：");
        s = sc.nextLine();
        System.out.println(new Q_最长回文串().longestPalindrome(s));
    }
}
