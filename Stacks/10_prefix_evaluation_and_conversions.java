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
  
    public static int prefixEval(String str) {
        Stack<Integer> vstack = new Stack<>();
        
        for(int i=str.length()-1; i>=0; i--) {
            char ch = str.charAt(i);
            
            if(ch >= '0' && ch <= '9') {
                vstack.push((int)(ch - '0'));
            } else {
                int val1 = vstack.pop();
                int val2 = vstack.pop();
                
                int res = evaluate(val2, val1, ch);
                vstack.push(res);
            }
        }
        
        return vstack.pop();
    }
    
      public static String prefixToInfix(String str) {
        Stack<String> vstack = new Stack<>();
        
        for(int i=str.length()-1; i>=0; i--) {
            char ch = str.charAt(i);
            
            if(ch >= '0' && ch <= '9') {
                vstack.push(ch + "");
            } else {
                String val1 = vstack.pop();
                String val2 = vstack.pop();
                char op = ch;
                
                String res = "(" + val1 + op + val2 + ")";
                vstack.push(res);
            }
        }
        
        return vstack.pop();
    }
    
    public static String prefixToPostfix(String str) {
        Stack<String> vstack = new Stack<>();
        
        for(int i=str.length()-1; i>=0; i--) {
            char ch = str.charAt(i);
            
            if(ch >= '0' && ch <= '9') {
                vstack.push(ch + "");
            } else {
                String val1 = vstack.pop();
                String val2 = vstack.pop();
                char op = ch;
                
                String res = val1 + val2 + op;
                vstack.push(res);
            }
        }
        
        return vstack.pop();
    }
    
public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    System.out.println(prefixEval(exp));
    System.out.println(prefixToInfix(exp));
    System.out.println(prefixToPostfix(exp));
 }
}