// Makes use of Stack for reverse printing

import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    Stack<Integer> st = new Stack<>();
    int count = 1;
    
    for(int i=0; i<str.length(); i++) {
        char ch = str.charAt(i);
        st.push(count);
        count++;
        if(ch == 'i') {
            while(st.size() > 0) {
                System.out.print(st.pop());
            }   
        }
    }
    
    // For 1 extra element at the end (for 8 characters, 9 digits are to be printed)
    st.push(count);
    while(st.size() > 0) {
        System.out.print(st.pop());
    }    
 }
}