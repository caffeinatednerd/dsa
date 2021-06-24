import java.io.*;
import java.util.*;

public class Main{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] nge = solve(a);
    display(nge);
 }

 public static int[] solve(int[] arr){
    Stack<Integer> st = new Stack<>();
    st.push(0);
    
    int[] res = new int[arr.length];
    
    for(int i=1; i<arr.length; i++) {
        int curNum = arr[i];
        while(st.size() > 0 && curNum > arr[st.peek()]) {
            res[st.pop()] = curNum;
        }
        st.push(i);
    
    }
    
    while(st.size() > 0) {
        res[st.pop()] = -1;
    }
    
    return res;
 }

}