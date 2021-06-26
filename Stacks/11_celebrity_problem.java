import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"
        
        Stack<Integer> st = new Stack<>();
        
        // O(n)
        for(int i=0; i<arr.length; i++) {
            st.push(i);
        }
        
        // O(n)
        while(st.size() > 1) {
            int i = st.pop();
            int j = st.pop();
            
            if(arr[i][j] == 1) {
                // i knows j, so i is not a celebrity
                st.push(j);
            } else {
                // i does not know j, so j is not a celebrity
                st.push(i);
            }
        }
        
        int candidate = st.pop();
        
        // check its row
        for(int c=0; c<arr[0].length; c++) {
            if(arr[candidate][c] == 1) {
                System.out.println("none");
                return;
            }
        }
        
        // check its column
        for(int r=0; r<arr.length; r++) {
            if(r != candidate && arr[r][candidate] == 0) {
                System.out.println("none");
                return;
            }
        }
        
        System.out.println(candidate);
    }

}