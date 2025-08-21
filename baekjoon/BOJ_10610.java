package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nStr = br.readLine();

        char[] arr = nStr.toCharArray();
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr);

        int sum = 0;
        for (int i = arr.length-1; i >= 0; i--) {
            int num = arr[i] - '0';
            sum += num;
            sb.append(num);
        }

        if (arr[0] != '0' || sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(sb.toString());
    }
}
