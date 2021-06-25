import java.io.*;
import java.util.*;

public class Main{
  
    public static int[] ngr(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        
        for(int i=1; i<arr.length; i++) {
            while(st.size() > 0 && arr[i] > arr[st.peek()]) {
                res[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
        
        while(st.size() > 0) {
            res[st.peek()] = arr.length;
            st.pop();
        }
        
        return res;
    }
  
    public static void slidingWindowMax(int[] arr, int k) {
        int[] rgi = ngr(arr);
        
        int j = 0;
        for(int i=0; i <= arr.length-k; i++) {
            if(i > j) {
                j = i;    
            }
            
            // check next greater of next greater till in range of k
            
            // loop breaks when the index is last index in the range or greater than that
            while(i + k > rgi[j]) {
                // Update the j so that it checks for the next greater in the range
                j = rgi[j];
            }
            System.out.println(arr[j]);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
           a[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());
        
        slidingWindowMax(a, k);
     }
}