import java.io.*;
import java.util.*;
// O(t*n)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {   // O(t)
            String s = br.readLine();
            boolean check = true;
            Stack<Character> stack = new Stack<>(); // O(1)
            for (int j = 0; j < s.length(); j++) {  // O(n)
                char c = s.charAt(j);
                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        check = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (stack.isEmpty() && check) {
                sb.append("YES").append('\n');
            } else {
                sb.append("NO").append('\n');
            }
        }
        System.out.print(sb);
    }
}
