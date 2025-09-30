package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1522 {
    public static void main(String[] args)throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String s = br.readLine();
       int a_cnt = 0;
       int min = Integer.MAX_VALUE;
       for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                a_cnt++;
            }
       }

       for (int i = 0; i < s.length(); i++) {
            int b_cnt = 0;
            for (int j = i; j < a_cnt + i; j++) {
                if (s.charAt(j % s.length()) == 'b') {
                    b_cnt++;
                }
            }
            min = Math.min(min, b_cnt);
        }
        System.out.println(min);
    }
}
