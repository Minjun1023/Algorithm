package baekjoon;

import java.util.*;
import java.io.*;
public class BOJ_1789 {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long s = Long.parseLong(br.readLine());

        long sum = 0L;

        int n = 1;
       
        while (sum <= s){
            sum += n++;
        }

        System.out.println(n-2);

    }
    
}
