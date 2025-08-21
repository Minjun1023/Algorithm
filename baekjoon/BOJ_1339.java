package baekjoon;

import java.io.*;
import java.util.*;
/* 
 * AAA AAA
 * 100+10+1 = 111*9 = 999
 * 100+10+1 = 111*9 = 999
 * 999+999 = 1998
 * GCF 
 * ACDEB
 * 10000A, 1B, 1000C, 100D, 10E
 * GCF
 * 100G, 10C, 1F
 * ACDEB + GCF = 10000A, 1B, 1010C, 100D, 10E, 1F, 100G
 * 10000*9 + 1010*8 + 100*7 + 100*6 + 10*5 + 1*4 + 1*3 = 99437
 */

public class BOJ_1339 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        // 알파벳 수만큼 배열 생성 
        arr = new int[26];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++){
                char c = input.charAt(j);
                // 자릿수에 따른 값 구하기(10의 거듭제곱)
                arr[c - 'A'] += (int)Math.pow(10, input.length() - 1 - j);
            }
        }

        Arrays.sort(arr);

        // 가장 큰 자릿수에 곱하는 값
        int num = 9;
        int turn = 25;
        int ans = 0;
        // 배열의 값이 0이면 종료
        while (arr[turn] != 0) {
            ans += arr[turn]*num;
            turn--;
            num--;
        }
        System.out.print(ans);
    }
}


