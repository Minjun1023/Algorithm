import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int height = Integer.parseInt(st.nextToken());

            if (stack.isEmpty()) {
                // 레이저 신호를 수신하는 탑이 존재하지 않는 경우 0 출력
                sb.append(0).append(" ");
                stack.push(new int[] {i, height});
            } else {
                while (true) {
                    // 초기 값 설정
                    if (stack.isEmpty()) {
                        sb.append(0).append(" ");
                        stack.push(new int[] {i, height});
                        break;
                    }

                    // 현재 높이
                    int[] preHeight = stack.peek();

                    // 이전 높이가 현재 높이보다 클 경우
                    if (preHeight[1] > height) {
                        // 이전 높이의 인덱스 번호 출력
                        sb.append(preHeight[0] + " ");
                        // 현재 인덱스 번호, 높이를 스택에 추가
                        stack.push(new int[] {i, height});
                        break;
                    } else {
                        // 이전 높이가 현재 높이보다 작을 경우
                        stack.pop();
                    }
                }
            }
        }
        System.out.print(sb);
    }
}
