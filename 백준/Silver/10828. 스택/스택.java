import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        while (n --> 0) {
            st = new StringTokenizer(br.readLine());

            switch(st.nextToken()) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    stack.push(num);
                    break;

                case "pop":
                    if (!stack.isEmpty()) {
                        sb.append(stack.pop()).append('\n');
                    } else {
                        sb.append(-1).append('\n');
                    }
                    break;

                case "size":
                    sb.append(stack.size()).append('\n');
                    break;

                case "empty":
                    if (!stack.isEmpty()) {
                        sb.append(0).append('\n');
                    } else {
                        sb.append(1).append('\n');
                    }
                    break;

                case "top":
                    if (!stack.isEmpty()) {
                        sb.append(stack.peek()).append('\n');
                    } else {
                        sb.append(-1).append('\n');
                    }
                    break;
            }
        }
        System.out.print(sb);
    }
    
}
