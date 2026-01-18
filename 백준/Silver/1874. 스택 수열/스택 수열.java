import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (int test_case = 0; test_case < n; test_case++) {
            int num = Integer.parseInt(br.readLine());

            if (num > start) {
                for (int i = start+1; i <= num; i++) {
                    stack.push(i);
                    sb.append('+').append('\n');
                }
                start = num;
            } else if (stack.peek() != num) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append('-').append('\n');  
        }
        System.out.print(sb);
    }
}    
