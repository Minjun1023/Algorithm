import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Stack<Character> s = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while(!s.isEmpty() && priority(s.peek()) >= priority(c)) {
                        sb.append(s.pop());
                    }
                    s.push(c);
                    break;
                case '(':
                    s.push(c);
                    break;
                case ')':
                    while (!s.isEmpty() && s.peek() != '(') {
                        sb.append(s.pop());
                    }
                    s.pop();
                    break;
                default:
                    sb.append(c);
            }
        }
        
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }
        
        System.out.print(sb);
    }

    public static int priority(char operator) {
        if (operator == '(' || operator == ')') {
            return 0;
        } else if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return -1;
    }
    
}
