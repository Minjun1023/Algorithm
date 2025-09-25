package baekjoon;

import java.io.*;
import java.util.*;

/*
 * 1234
 * base pt
 * 1    1
 * 2    2
 * 3    3
 * 4    4
 * 4 출력
 * 
 * 234092
 * 1    2
 * 3    3
 * 4    4
 * 10   0
 * 19   9
 * 20   2
 * 20 출력
 * 
 * 999909
 * 1    9
 * 19   9
 * 29   9
 * 39   9
 * 40   0
 * 49   9
 * 49   9
 * 49 출력
 */

public class BOJ_1515 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int pt = 0;

        int base = 0;
        while (base++ <= 30000) {
            String tmp = String.valueOf(base);
            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == input.charAt(pt)) {
                    pt++;
                }
                if (pt == input.length()) {
                    System.out.println(base);
                    return;
                }
            }
        }
    }
}

