package baekjoon;

import java.io.*;
import java.util.*;
/*
 * Mississipi   ?
 * zZa  Z
 * z    Z
 * baaa A
 */
public class BOJ_1157 {
    
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 대문자로 통일
        String input = br.readLine().toUpperCase();
        int[] result = new int[26];

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
                result[input.charAt(i)-'A']++;
            }
        }

        int max = 0;
        for (int r : result) {
            if (r > max) {
                max = r;
            }
        }

        int cnt = 0;
        int ans = 0;
        for (int j = 0; j < 26; j++) {
            if (max == result[j]) {
                cnt++;
                ans = j;
            }
        }

        System.out.println(cnt == 1 ? (char)(ans +'A') : "?");
    }
}
