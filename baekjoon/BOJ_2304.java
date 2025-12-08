package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2304 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        int start = Integer.MAX_VALUE;
        int end = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());;
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            arr[l] = h;
            start = Math.min(l, start);
            end = Math.max(l, end);
        }

        Stack<Integer> height = new Stack<>();

        // 왼쪽 비교
        int temp = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] < temp) {
                height.push(i);
            }
            else {
                while (!height.isEmpty()) {
                    int x = height.pop();
                    arr[x] = temp;
                }
                temp = arr[i];
            }
        }
        height.clear();

        // 오른쪽 비교
        temp = arr[end];
        for (int i = end - 1; i >= start; i--) {
            if (arr[i] < temp) height.push(i);
            else {
                while (!height.isEmpty()) {
                    int x = height.pop();
                    arr[x] = temp;
                }
                temp = arr[i];
            }
        }

        int result = 0;
        for (int i = start; i <= end; i++) {
            result += arr[i];
        }

        sb.append(result);
        System.out.print(sb);

    }
    
}
