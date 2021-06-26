import java.io.*;
import java.util.*;

public class Main{
  
    public static int evaluate(int val1, int val2, char op) {
        if(op == '+') return val2 + val1;
        else if(op == '-') return val2 - val1;
        else if(op == '*') return val2 * val1;
        else if(op == '/') return val2 / val1;
        else return 0;
    }
  
    public static int postfixEval(String str) {
        Stack<Integer> vstack = new Stack<>();
        
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            
            if(ch >= '0' && ch <= '9') {
                vstack.push((int)(ch - '0'));
            } else {
                int val1 = vstack.pop();
                int val2 = vstack.pop();
                
                int res = evaluate(val1, val2, ch);
                vstack.push(res);
            }
        }
        
        return vstack.pop();
    }
    
      public static String postfixToInfix(String str) {
        Stack<String> vstack = new Stack<>();
        
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            
            if(ch >= '0' && ch <= '9') {
                vstack.push(ch + "");
            } else {
                String val1 = vstack.pop();
                String val2 = vstack.pop();
                char op = ch;
                
                String res = "(" + val2 + op + val1 + ")";
                vstack.push(res);
            }
        }
        
        return vstack.pop();
    }
    
    public static String postfixToPrefix(String str) {
        Stack<String> vstack = new Stack<>();
        
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            
            if(ch >= '0' && ch <= '9') {
                vstack.push(ch + "");
            } else {
                String val1 = vstack.pop();
                String val2 = vstack.pop();
                char op = ch;
                
                String res = op + val2 + val1;
                vstack.push(res);
            }
        }
        
        return vstack.pop();
    }
    
public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    System.out.println(postfixEval(exp));
    System.out.println(postfixToInfix(exp));
    System.out.println(postfixToPrefix(exp));
 }
}