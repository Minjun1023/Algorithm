package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_11720 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split("");
        int sum = 0;
        
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(str[i]);
        }
        System.out.println(sum);
    }
    
}
