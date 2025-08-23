package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1753 {

    static class Node {
        int v;
        int cost;
        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    // 각 노드에 연결되어있는 노드에 대한 정보를 담는 리스트
    static ArrayList<Node>[] graph;
    // 방문여부
    static boolean[] visited;
    // 최단 거리 테이블
    static int[] dist;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        graph = new ArrayList[v+1];
        visited = new boolean[v+1];
        dist = new int[v+1];
        
        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
            // 최대값으로 초기화, 최단거리를 찾기 위함
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int inputU = Integer.parseInt(st.nextToken());
            int inputV = Integer.parseInt(st.nextToken());
            int inputW = Integer.parseInt(st.nextToken());

            graph[inputU].add(new Node(inputV, inputW));
        }

        // 다익스트라 알고리즘 수행
        dijkstra(k);

        for (int i = 1; i <= v; i++) {
            System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
        }
    }

    public static void dijkstra(int start) {
        // 가중치를 기준으로 오름차순으로 정렬
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        // 시작 노드에 대해서 초기화
        q.add(new Node(start, 0));
        // 시작점은 0
        dist[start] = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (!visited[now.v]) {
                visited[now.v] = true;
            }
            
            for (Node next : graph[now.v]) {
                // 방문하지 않고, 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                if (!visited[next.v] && dist[next.v] > now.cost + next.cost) {
                    dist[next.v] = now.cost + next.cost;
                    q.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}
