package String.Offer48_最长不含重复字符的子字符串;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
* 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
* 输入: "abcabcbb"
* 输出: 3
* 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
* */

public class Solution {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for(int j = 0; j < str.length(); j++) {
            int i = dic.getOrDefault(str.charAt(j), -1); // 获取索引 i
            dic.put(str.charAt(j), j); // 更新哈希表
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        System.out.println(res);
    }
}
