import java.io.*;
import java.util.*;

public class Main{
    
    public static int priority(char op) {
        if(op == '/' || op == '*') return 2;
        else if(op == '+' || op == '-') return 1;
        else return 0;
    }
    
    public static String infixToPrefix(String str) {
        Stack<String> vstack = new Stack<>();
        Stack<Character> ostack = new Stack<>();
        
        for(int i=0; i<str.length(); i++) {
            char chr = str.charAt(i);
            
            if(chr == ' ') {
                continue;
            } else if(chr>='a' && chr<='z') {
                vstack.push(chr + "");
            } else if(chr == '(') {
                ostack.push(chr);
            } else if(chr == ')') {
                while(ostack.peek() != '(') {
                    String val1 = vstack.pop();
                    String val2 = vstack.pop();
                    char op = ostack.pop();
                    
                    String res = op + val2 + val1;
                    vstack.push(res);
                }
                // to remove ')' itself
                ostack.pop();
            } else {
                // operators
                // solve equal priority now, otherwise after loop ends, we solve the equal priority from right to left which gives wrong answer
                // beacause of behviour of stack
                while(ostack.size() > 0 && ostack.peek() != '(' && priority(ostack.peek()) >= priority(chr)) {
                    String val1 = vstack.pop();
                    String val2 = vstack.pop();
                    char op = ostack.pop();
                    
                    String res = op + val2 + val1;
                    vstack.push(res);
                }
                ostack.push(chr);
            }
        }
        
        // some elements maybe present in stack
        while(ostack.size() > 0) {
            String val1 = vstack.pop();
            String val2 = vstack.pop();
            char op = ostack.pop();
            
            String res = op + val2 + val1;
            vstack.push(res);
        }
        
        return vstack.pop();
    }
    
    public static String infixToPostfix(String str) {
        Stack<String> vstack = new Stack<>();
        Stack<Character> ostack = new Stack<>();
        
        for(int i=0; i<str.length(); i++) {
            char chr = str.charAt(i);
            
            if(chr == ' ') {
                continue;
            } else if(chr>='a' && chr<='z') {
                vstack.push(chr + "");
            } else if(chr == '(') {
                ostack.push(chr);
            } else if(chr == ')') {
                while(ostack.peek() != '(') {
                    String val1 = vstack.pop();
                    String val2 = vstack.pop();
                    char op = ostack.pop();
                    
                    String res = val2 + val1 + op;
                    vstack.push(res);
                }
                // to remove ')' itself
                ostack.pop();
            } else {
                // operators
                // solve equal priority now, otherwise after loop ends, we solve the equal priority from right to left which gives wrong answer
                // beacause of behviour of stack
                while(ostack.size() > 0 && ostack.peek() != '(' && priority(ostack.peek()) >= priority(chr)) {
                    String val1 = vstack.pop();
                    String val2 = vstack.pop();
                    char op = ostack.pop();
                    
                    String res = val2 + val1 + op;
                    vstack.push(res);
                }
                ostack.push(chr);
            }
        }
        
        // some elements maybe present in stack
        while(ostack.size() > 0) {
            String val1 = vstack.pop();
            String val2 = vstack.pop();
            char op = ostack.pop();
            
            String res = val2 + val1 + op;
            vstack.push(res);
        }
        
        return vstack.pop();
    }

    public static void main(String[] args) throws Exception {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scn = new Scanner(System.in);
        // String exp = br.readLine();
        String exp = scn.nextLine();
    
        System.out.println(infixToPostfix(exp));
        System.out.println(infixToPrefix(exp));
     }
}