import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    
    System.out.println(solve(a));
 }
 
    public static int[] findNextSmallerIndexOnRight(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[arr.length];
        st.push(0);
        
        for(int i=0; i<arr.length; i++) {
            while(st.size() > 0 && arr[i] < arr[st.peek()]) {
                res[st.pop()] = i;
            }
            st.push(i);
        }
        
        while(st.size() > 0) {
            res[st.pop()] = arr.length;
        }
        
        return res;
    }
    
    public static int[] findNextSmallerIndexOnLeft(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[arr.length];
        st.push(arr.length-1);
        
        for(int i=arr.length-2; i>=0; i--) {
            while(st.size() > 0 && arr[i] < arr[st.peek()]) {
                res[st.pop()] = i;
            }
            st.push(i);
        }
        
        while(st.size() > 0) {
            res[st.pop()] = -1;
        }
        
        return res;
    }
    
    public static int solve(int[] arr) {
        int[] res = new int[arr.length];
        
        // check left side
        int[] nsl = findNextSmallerIndexOnLeft(arr);
        // check right side
        int[] nsr = findNextSmallerIndexOnRight(arr);
        
        for(int i=0; i<res.length; i++) {
            int length = arr[i];
            int breadth = (i - nsl[i] - 1) + (nsr[i] - i);
            
            res[i] = length * breadth;    
        }
        
        // find and return max value in array of rectangle areas
        int max = arr[0];
        for(int i=1; i<res.length; i++) {
            if(res[i] > max)
                max = res[i];
        }
        
        return max;
    }
    
}