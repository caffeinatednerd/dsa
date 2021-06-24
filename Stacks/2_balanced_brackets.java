/* Three conditions for false:
if closing bracket occurs:
      1. if closing bracket couldn't find it's matching opening bracket at peek (incorrext pair of bracket is there)
      2. if size of stack is 0, no bracket (pair or not) is there in stack
      
3. Opening bracket reamins after all pop operations */


import java.io.*;
import java.util.*;

public class Main {
    
    public static boolean isBalanced(String str) {
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<str.length(); i++) {
            char chr = str.charAt(i);
            
            if(chr == ')') {
                if(st.size() == 0 || st.peek() != '(') return false;
                st.pop();
            } else if(chr == ']') {
                if(st.size() == 0 || st.peek() != '[') return false;
                st.pop();
            } else if(chr == '}') {
                if(st.size() == 0 || st.peek() != '{') return false;
                st.pop();
            }
            else if(chr == '{' || chr == '(' || chr == '[') {
                st.push(chr);
            } else {
                continue;
            }
        }
        
        return st.size() == 0;
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        
        System.out.println(isBalanced(str));
    }   

}