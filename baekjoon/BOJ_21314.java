package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_21314 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        
        StringBuilder max = new StringBuilder();
        StringBuilder min = new StringBuilder();

        int cntM = 0;

        for (int i = 0; i < a.length(); i++) {
            char currentChar = a.charAt(i);

            if (currentChar == 'M') {
                cntM++; // 1
            } else if (currentChar == 'K') { // K일 경우
                // 1. 최댓값 구하기
                if (cntM > 0) { // 이전에 M이 있을 경우
                    max.append('5');    // 5
                    for (int j = 0; j < cntM; j++) {
                       max.append('0') ; // 50
                    }
                } else { // 이전에 M이 없을 경우
                    max.append('5');
                }

                // 2. 최솟값 구하기
                if (cntM > 0) { // 이전에 M이 있을 경우 
                    min.append('1');    // 1
                    for (int j = 1; j < cntM; j++) {
                        min.append('0');    // 나머지 M은 0으로, 10
                    }
                    min.append('5'); // 현재 K를 반환, 5
                } else {
                    min.append('5');
                }
                cntM = 0;
            }
        }
        // 남은 M 처리
        if (cntM > 0) {
            // 최댓값
            for (int j = 0; j < cntM; j++) {
                max.append('1');
            }
            // 최솟값
            min.append('1');
            for (int j = 1; j < cntM; j++) {
                min.append('0');
            }
        }

        // 출력
        System.out.println(max);
        System.out.println(min);
    }

}