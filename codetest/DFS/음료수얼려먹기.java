// 상하좌우로 이동해서 값이 0이면서 아직 방문하지 않은 곳이면 해당 지점을 방문

package codetest.DFS;

import java.io.*;
import java.util.*;

public class 음료수얼려먹기 {

    static int n;
    static int m;
    static int graph[][];

    static boolean dfs(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m)
            return false;
        if (graph[x][y] == 0) {
            // 방문처리
            graph[x][y] = 1;

            // 상하좌우 이동
            dfs(x-1, y);
            dfs(x+1, y);
            dfs(x, y-1);
            dfs(x, y+1);

            return true;
        }
        return false;
    }
    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        for (int i = 0; i < n; i++){
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                // 입력받은 배열을 문자열에서 숫자로 바꾸기 위함
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j) == true) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
    
}
