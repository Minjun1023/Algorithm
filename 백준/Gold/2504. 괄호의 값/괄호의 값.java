import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int ans = 0;
        int cnt = 1;
        boolean check = true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(') {
                stack.push(c);
                cnt *= 2;
            }
            else if (c == '[') {
                stack.push(c);
                cnt *= 3;
            }
            else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    check = false;
                    break;
                }
                if (str.charAt(i-1) == '(') {
                    ans += cnt;
                }
                stack.pop();
                cnt /= 2;
            }
            else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    check = false;
                    break;
                }
                if (str.charAt(i-1) == '[') {
                    ans += cnt;
                }
                stack.pop();
                cnt /= 3;
            }
            else {
                check = false;
                break;
            }
        }

        if (!check || !stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(ans);
        }
    }
}
