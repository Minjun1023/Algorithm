package codetest.최단경로;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Node o) {
        return this.distance - o.distance;
    }
}

public class 전보 {
    static final int INF = (int) 1e9;
    static int n, m, c, x, y, z;
    static int count = -1;
    static int[] d = new int[30001];
    static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static void dijkstra(int start) {
        d[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int distance = node.getDistance();
            int index = node.getIndex();

            if (d[index] < distance) continue;

            for (int i = 0; i < graph.get(index).size(); i++) {
                int cost = d[index] + graph.get(index).get(i).getDistance();
                if (cost < d[graph.get(index).get(i).getIndex()]) {
                    d[graph.get(index).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(index).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());
            graph.get(x).add(new Node(y, z));
        }

        Arrays.fill(d, INF);

        dijkstra(c);

        int max_value = -1;

        for (int i = 1; i <= n; i++) {
            if (d[i] != INF) {
                count++;
                if (d[i] > max_value) {
                    max_value = d[i];
                }
            }
        }
        bw.write(count + " " + max_value);

        br.close();
        bw.close();
    }
}
