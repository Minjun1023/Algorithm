import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> st = new Stack<>();

        String str = br.readLine();

        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                st.push(c);
                continue;
            }
            if (c == ')') {
                st.pop();
                
                if (str.charAt(i-1) == '(') {
                    result += st.size();
                } else {
                    result++;
                }
            }
        }
        System.out.print(result);
    }
}    
