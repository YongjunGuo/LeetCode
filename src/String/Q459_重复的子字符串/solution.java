package String.Q459_重复的子字符串;

import java.util.Arrays;
import java.util.Scanner;

/*
* 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
* */

public class solution {
    public boolean repeatedSubstringPattern1(String s){
        /*枚举*/
        int n = s.length();
        for(int i = 1; i * 2 <= n; i++){
            if(n % i == 0){
                boolean match = true;
                for(int j = i; j < n; j++){
                    if(s.charAt(j) != s.charAt(j - i)){
                        match = false;
                        break;
                    }
                }
                if(match){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean repeatedSubstringPattern2(String s){
        /*
        * 字符串匹配
        * */
        return (s + s).indexOf(s, 1) != s.length();
    }

    public boolean repeatedSubstringPattern3(String s) {
        /*
        * KMP算法
        * */
        return kmp(s);
    }

    public boolean kmp(String pattern) {
        int n = pattern.length();
        int[] fail = new int[n];
        Arrays.fill(fail, -1);
        for (int i = 1; i < n; ++i) {
            int j = fail[i - 1];
            while (j != -1 && pattern.charAt(j + 1) != pattern.charAt(i)) {
                j = fail[j];
            }
            if (pattern.charAt(j + 1) == pattern.charAt(i)) {
                fail[i] = j + 1;
            }
        }
        return fail[n - 1] != -1 && n % (n - fail[n - 1] - 1) == 0;
    }



    public static  void main(String [] args){
        String s = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入字符串：");
        s = sc.nextLine();
        System.out.println(new solution().repeatedSubstringPattern3(s));
    }
}
