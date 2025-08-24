package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_4673 {
    public static void main(String[] args)throws IOException {

        // 생성자인지 체크 여부
        boolean[] check = new boolean[10001];

        // 1~10000까지의 숫자
        for (int i = 1; i < 100001; i++) {
            int n = d(i);

            // 1~10000까지의 숫자내에서 조건이 만족하면 참(생성자)
            if (n < 10001) {
                check[n] = true;
            }   
        }

        StringBuilder sb = new StringBuilder();


        for (int i = 1; i < 10001; i++) {
            // 생성자가 아닌경우
            if (!check[i]) {
                // 해당 값을 출력 및 줄바꿈
                sb.append(i).append("\n");
            }
        }
        // 출력
        System.out.println(sb);
    }

    public static int d(int num) {
        int sum = num;
        while(num != 0) {
            sum += (num % 10);
            num = num / 10;
        }

        return sum;
    }
}
