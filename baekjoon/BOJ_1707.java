package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1707 {
    // 테스트케이스 K, 정점의 개수 V, 간선의 개수 E
    static int K, V, E;
    // 두 정점의 번호 u, v
    static int u, v;
    static boolean ans;
    static int[] color;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            V = Integer.parseInt(stk.nextToken());
            E = Integer.parseInt(stk.nextToken());
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int j = 0; j <= V; j++) {
                graph.add(new ArrayList<Integer>());
            }
            color = new int[V+1];

            for (int k = 0; k < E; k++) {
                StringTokenizer stk1 = new StringTokenizer(br.readLine());
                u = Integer.parseInt(stk1.nextToken());
                v = Integer.parseInt(stk1.nextToken());
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            ans = true;

            // 모든 정점을 탐색하며 방문되지 않은 정점에서 DFS 시작
            for (int node = 1; node <= V; node++) {
                if (color[node] == 0) {
                    dfs(graph, color, node, 1);
                }
            }

            if (ans) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

        public static void dfs(ArrayList<ArrayList<Integer>> graph, int[] colors, int now, int color) {
            colors[now] = color;
            ArrayList<Integer> nexts = graph.get(now);

            for (int next : nexts) {
                if (colors[next] == colors[now]) {
                    ans = false;
                    return; // 이분 그래프가 아님을 확인한 경우 더 이상 탐색하지 않음
                }

                if (colors[next] == 0) {
                    dfs(graph, colors, next, 3-color);
                }
            }
        }
    }

// package baekjoon;

// import java.io.*;
// import java.util.*;

// public class 이분그래프 {
//     static int v,e;
//     static List<Integer>[] list;
//     static int[] color;
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer stk = new StringTokenizer(br.readLine());
//         // 테스트 케이스
//         int K = Integer.parseInt(stk.nextToken());

//         for (int i = 0; i < K; i++) {
//             // 테스트 케이스 줄 만큼, 정점 v, 간선 e를 입력받음
//             stk = new StringTokenizer(br.readLine());
//             v = Integer.parseInt(stk.nextToken());
//             e = Integer.parseInt(stk.nextToken());

//             // 정점 수 만큼 배열 생성
//             list = new ArrayList[v+1];
//             // 각 인덱스마다 ArrayList 객체 생성
//             for (int j = 1; j < v+1; j++) {
//                 list[j] = new ArrayList<>();
//             }

//             // 간선의 줄 만큼, 두 정점 u, v를 입력받음
//             for (int k = 0; k < e; k++) {
//                 stk = new StringTokenizer(br.readLine());
//                 int u = Integer.parseInt(stk.nextToken());
//                 int v = Integer.parseInt(stk.nextToken());

//                 // 연결된 정점을 리스트에 저장
//                 list[u].add(v);
//                 list[v].add(u);
//             }
//             // 이분그래프인지 표시하기 위해 color 생성
//             color = new int[v+1];
//             // bfs 시작: 1
//             isBiGraph(1);
//     }
// }

//     public static void isBiGraph(int start) {
//         Queue<Integer> q = new LinkedList<>();

//         // 모든 정점에 대해 방문 확인
//         for (int i = 1; i < v+1; i++) {
//             // 색칠 X -> 방문 X
//             if (color[i] == 0) {
//                 // 첫 정점 = 1
//                 color[i] = 1;
//                 q.add(i);
//             }

//             while(!q.isEmpty()) {
//                 int pos = q.poll();

//                 // 현재 정점과 연결된 모든 이웃 정점 확인
//                 for (int next : list[pos]) {
//                     // 연결된 두 정점이 같은 색이면
//                     if (color[next] == color[pos]) {
//                         System.out.println("NO");
//                         return;
//                     }
//                     // 아직 색칠되지 않은 정점이면                   
//                     if (color[next] == 0) {
//                         q.add(next);

//                         // 현재 정점이 1인경우 이웃을 2로
//                         if (color[pos] == 1) {
//                             color[next] = 2;
//                             // 현재 정점이 2인 경우 이웃을 1로
//                         } else {
//                             color[next] = 1;
//                         }
//                     }
//                 }
//             }
//         }
//         // 이분 그래프일 경우
//         System.out.println("YES");
//     }
// }