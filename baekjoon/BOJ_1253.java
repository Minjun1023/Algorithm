package baekjoon;

import java.util.*;
import java.io.*;
public class BOJ_1253 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N-1;    
            while (left < right) {
                if (i == left || i == right) {  // 본인인 경우
                    if (left == i) left++;
                    else right--;
                } else {
                    int now = arr[left] + arr[right];
                    if (arr[i] == now) {    // 찾은 경우
                        cnt++;
                        break;
                    } else if (now < arr[i]) {  // 더 큰 숫자가 필요한 경우
                        left++;
                    } else {    // 더 작은 숫자가 필요한 경우
                        right--;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
