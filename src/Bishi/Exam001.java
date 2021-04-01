package Bishi;

import java.math.BigInteger;
import java.util.*;


/*
* 给定一个非负整数num，反复将个位数上的数字相加，知道结果为一位数
* */

public class Exam001 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String string = s.nextLine();
        BigInteger n = new BigInteger(string);
        int len = string.length();

        while (string.length() > 1) {
            BigInteger temp = new BigInteger("0");
            for(int i = 0; i < string.length(); i ++){
                temp = temp.add(new BigInteger(string.substring(i, i+1)));
            }
            string = temp.toString();
        }
        System.out.println(string);
    }
}
