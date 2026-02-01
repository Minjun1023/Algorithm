import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> tree[];
    static int[] num;
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        k = Integer.parseInt(br.readLine());
        tree = new ArrayList[k+1];
        int size = (int)(Math.pow(2, k) - 1);
        num = new int[size+1];

        for (int i = 1; i <= k; i++) {
            tree[i] = new ArrayList<>();
        }

        int index = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            num[index++] = Integer.parseInt(st.nextToken());
        }
        search(1, 1, size);
        for (int i = 1; i <= k; i++) {
            // 층 별로 출력
            for (int j = 0; j < tree[i].size(); j++) {
                sb.append(tree[i].get(j) + " ");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void search(int depth, int start, int end) {
        int mid = (start + end) / 2;
        tree[depth].add(num[mid]);
        // 단말노드인 경우
        if (depth == k) {
            return;
        }

        // 왼쪽
        search(depth+1, start, mid-1);
        // 오른쪽
        search(depth+1, mid+1, end);
    }
    
}
