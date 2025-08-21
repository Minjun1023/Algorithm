package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_10162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = {300, 60, 10};
        int t = Integer.parseInt(br.readLine());
        String result = "";

        if (t % 10 != 0) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < 3; i++) {
                result += t / arr[i] + " ";
                t %= arr[i];
            }
            System.out.println(result);
        }
    }
}


