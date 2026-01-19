import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            list.add(new int[] {i, x-r, 0});    // 시작
            list.add(new int[] {i, x+r, 1});    // 끝
        }
        
        // 좌표 오름차순으로 정렬. 좌표 같을 경우 끝 -> 시작
        list.sort((a, b) ->  {
            if (a[1] != b[1]) return a[1] - b[1];
            return b[2] - a[2];
        });

        System.out.println(stack(n, list));
        
    }

    public static String stack(int n, List<int[]> list) {
        Stack<Integer> stack = new Stack<>();

        for (int[] cur : list) {
            int idx = cur[0];
            int type = cur[2];

            if (type == 0) {
                stack.push(idx);
            } else {
                // 원이 교차하는경우
                if (stack.isEmpty() || stack.peek() != idx) {
                    return "NO";
                }
                stack.pop();
            }
        }
        return "YES";
    }
}
