package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_21918 {
    static int N;
    static int M;
    static int[] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            find(a, b, c);
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void find(int a, int b, int c) {
        if (a == 1) {
            arr[b] = c;
        } else if (a == 2) {
            for (int i = b; i <= c; i++) {
                if (arr[i] == 0) {
                    arr[i] = 1;
                } else {
                    arr[i] = 0;
                }
            }
        } else if (a == 3) {
            for (int i = b; i <= c; i++) {
                arr[i] = 0; 
            }
        }
        else if (a == 4) {
            for(int i = b; i <= c; i++) {
                arr[i] = 1;
            }
        }
    }
    
}
