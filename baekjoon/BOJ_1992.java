    package baekjoon;

    import java.io.*;
    import java.util.*;

    public class BOJ_1992 {
        static StringBuilder sb = new StringBuilder();
        static int[][] arr;
        public static void main(String[] args)throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                String a = br.readLine();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = a.charAt(j) - '0';
                }
            }
            quadTree(0, 0, n);
            System.out.println(sb);
        }

        public static void quadTree(int x, int y, int size) {
            // 압축이 가능할경우 (0 or 1로만 이루어져있는 경우)
            if (isPossible(x, y, size)) {
                sb.append(arr[x][y]);
                return;
            }

            int newSize = size / 2; // 등분
            sb.append('(');         
            quadTree(x, y, newSize);    // 왼쪽 위
            quadTree(x, y+newSize, newSize);    // 오른쪽 위
            quadTree(x+newSize, y, newSize);    // 왼쪽 아래
            quadTree(x+newSize, y+newSize, newSize);    // 오른쪽 아래          

            sb.append(')');
        }

        public static boolean isPossible(int x, int y, int size) {
            int value = arr[x][y];

            for (int i = x; i < x+size; i++) {
                for (int j = y; j < y+size; j++) {
                    // 0과 1이 섞여 있을 경우
                    if (value != arr[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }
        
    }
