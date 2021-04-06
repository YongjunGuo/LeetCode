package Bishi;

import java.util.Scanner;

/*
* 请实现一个函数，将一个字符串中的空格替换成“%20”。
* 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
* */

public class ReplaceSpace {
    public String replaceSpace(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }

    public static  void main(String [] args) {
        String s = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入字符串：");
        s = sc.nextLine();
        System.out.println(new ReplaceSpace().replaceSpace(s));
    }

}
