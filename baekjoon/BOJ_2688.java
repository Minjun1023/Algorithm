package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2688 {
    static ArrayList<Integer> lst;
    static int n;
    static int[] arr;
    static int[] num;
    static boolean[] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        lst = new ArrayList<>();
        visited = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        // 정렬해서 출력
        Collections.sort(lst);
        // 배열 크기 출력
        System.out.println(lst.size());
        
        // 결과값 출력
        for (int r : lst) {
            System.out.println(r);
        }

    }

    public static void dfs(int start, int target) {
        if (visited[arr[start]] == false) {
            visited[arr[start]] = true;
            dfs(arr[start], target);
            visited[arr[start]] = false;
        }
        // 사이클이 생긴 경우 lst에 추가.
        if (arr[start] == target) lst.add(target);
    }
    
}
