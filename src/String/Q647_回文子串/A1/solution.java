package String.Q647_回文子串.A1;

import java.util.Scanner;

/*
* 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
* 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
* 长度为 n 的字符串会生成 2n-1 组回文中心 [l, r],l = i / 2, r = l+ i mod 2
* */
public class solution {
    public int countSubstrings(String s){
        int n = s.length(), ans = 0;
        for(int i = 0; i < 2 * n - 1; i++){
            int l = i / 2, r = i / 2 + i % 2;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
               --l;
               ++r;
               ++ans;
            }
        }
        return ans;
    }

    public static  void main(String [] args){
        String s = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入字符串：");
        s = sc.nextLine();
        System.out.println(new solution().countSubstrings(s));
    }
}
