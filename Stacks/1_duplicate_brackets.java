import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        
        Stack<Character> st = new Stack<>();
        
        boolean flag = false;
        // enter elements in stack till end of string
        for(int i=0; i<str.length(); i++) {
            char chr = str.charAt(i);
               
            if(chr == ')') {
                if(st.peek() == '(') {
                    flag = true;
                    break;
                }
                
                while(st.peek() != '(') {
                    st.pop();
                }
                st.pop();
            }
            
            else {
                st.push(chr);
            }
        }
        
        System.out.println(flag);
    }

}