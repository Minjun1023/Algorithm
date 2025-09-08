package baekjoon;

import java.io.*;
import java.util.*;

/*
    모든 탑의 레이저 송신기는 레이저 신호를 지표면과 평행하게 수평 직선의 왼쪽 방향으로 발사.
    탑의 기둥 모두 레이저 신호를 수신하는 장치 설치.
    하나의 탑에서 발사된 레이저 신호는 가장 먼저 만나는 단 하나의 탑에서만 수신 가능
 * 6, 9, 5, 7, 4
 * 6    0   stack = [{1, 6}] 0출력
 * 6pop 00  stack = [{}] 0출력
 * 6pop 9 5 002 stack = [{2,9}, {3,5}] 9>=5 -> 2출력 
 * 6pop 9 5 7 0022 stack = [{2,9}, {4,7}]  5 < 7 -> pop 9 >= 7 -> 2출력 
 * 6pop 9 5 7 4 00224 stack = [{2,9}, {4,7}, {5,4}] 7 >= 4 -> 4출력
 */

public class BOJ_2493 {
    static int N;
    static Stack<int[]> stack = new Stack<>(); // {i(인덱스 번호), top(탑의 높이)}
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            int top = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty()) {
                // 현재 탑의 높이가 다음 탑의 높이보다 크거나 같은 경우 현재 탑의 인덱스를 출력
                if (stack.peek()[1] >= top) {
                    System.out.print(stack.peek()[0] + " ");
                    break;
                }
                // 현재 탑의 높이가 다음 탑의 높이보다 작은 경우 pop
                stack.pop();
            }
            // 스택이 비어있는 경우 0을 출력
            if (stack.isEmpty()) {
                System.out.print("0 ");
            }
            // 다음 top값 stack에 push
            stack.push(new int[] {i, top});
        }
    }
}
