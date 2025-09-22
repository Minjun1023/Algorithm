package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_9046 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        while (T --> 0) {
            String input = br.readLine();
            int[] result = new int[26];
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
                    result[input.charAt(i) - 'a']++;
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

            System.out.println(cnt == 1 ? (char)(ans + 'a') : "?");
        }
    }
}
