package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_5585 {
    static int money;
    static int change[] = {500, 100, 50, 10, 5, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        money = Integer.parseInt(br.readLine());
        money = 1000 - money;
        int cnt = 0;
        for (int i = 0; i < change.length; i++) {
            if (money/change[i] > 0) {
                cnt += money/change[i];
                money = money%change[i];
            }
        }
        System.out.println(cnt);
    }
}


