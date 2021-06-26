import java.io.*;
import java.util.*;

public class Main{
    
    public static int priority(char op) {
        if(op == '/' || op == '*') return 2;
        else if(op == '+' || op == '-') return 1;
        else return 0;
    }
    
    public static int evaluate(int val1, int val2, char op) {
        if(op == '+') {
            return val2 + val1;
        } else if(op == '-') {
            return val2 - val1;
        } else if(op == '*') {
            return val2 * val1;
        } else if(op == '/') {
            return val2 / val1;
        } else {
            return 0;
        }
    }
    
    public static int infixEval(String str) {
        Stack<Integer> vstack = new Stack<>();
        Stack<Character> ostack = new Stack<>();
        
        for(int i=0; i<str.length(); i++) {
            char chr = str.charAt(i);
            
            if(chr == ' ') {
                continue;
            } else if(chr>='0' && chr<='9') {
                vstack.push((int)(chr - '0'));
            } else if(chr == '(') {
                ostack.push(chr);
            } else if(chr == ')') {
                while(ostack.peek() != '(') {
                    int val1 = vstack.pop();
                    int val2 = vstack.pop();
                    char op = ostack.pop();
                    
                    int res = evaluate(val1, val2, op);
                    vstack.push(res);
                }
                // to remove ')' itself
                ostack.pop();
            } else {
                // operators
                // solve equal priority now, otherwise after loop ends, we solve the equal priority from right to left which gives wrong answer
                // beacause of behviour of stack
                while(ostack.size() > 0 && ostack.peek() != '(' && priority(ostack.peek()) >= priority(chr)) {
                    int val1 = vstack.pop();
                    int val2 = vstack.pop();
                    char op = ostack.pop();
                    
                    int res = evaluate(val1, val2, op);
                    vstack.push(res);
                }
                ostack.push(chr);
            }
        }
        
        // some elements maybe present in stack
        while(ostack.size() > 0) {
            int val1 = vstack.pop();
            int val2 = vstack.pop();
            char op = ostack.pop();
            
            int res = evaluate(val1, val2, op);
            vstack.push(res);
        }
        
        return vstack.pop();
    }

    public static void main(String[] args) throws Exception {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scn = new Scanner(System.in);
        // String exp = br.readLine();
        String exp = scn.nextLine();
    
        System.out.println(infixEval(exp));
     }
}