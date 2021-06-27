import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static class Pair implements Comparable<Pair> {
        int st = 0;
        int end = 0;
        
        public Pair(int st, int end) {
            this.st = st;
            this.end = end;
        }
        
        public int compareTo(Pair o) {
            // + this.st is > o.st
            // - this.st is < o.st
            // == this.st is == o.st
            return this.st - o.st;
        }
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
        Pair[] pairs = new Pair[arr.length];
        for(int i=0; i<arr.length; i++) {
            pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }
        Arrays.sort(pairs);
        
        // for(Pair p : pairs) {
        //     System.out.println(p.st + " " + p.end);
        // }
        
        Stack<Pair> st = new Stack<>();
        
        st.push(pairs[0]);
        
        for(int i=1; i<pairs.length; i++) {
            int sTime = pairs[i].st;
            int eTime = pairs[i].end;
            
            if(sTime > st.peek().end) {
                // push pair in stack as it is a disjoint set
                st.push(pairs[i]);
            } else {
                // check if eTime is less or more than st.peek()'s end time
                if(eTime <= st.peek().end) {
                    // make no change and continue
                    continue;
                } else {
                    // replace st.peek()'s end time with eTime
                    Pair curPair = st.pop();
                    curPair.end = eTime;
                    st.push(curPair);
                }
            }
        }
        
        Stack<Pair> res = new Stack<>();
        while(st.size() > 0) {
            res.push(st.pop());
        }
        
        while(res.size() > 0) {
            Pair resPair = res.pop();
            System.out.println(resPair.st + " " + resPair.end);
        }
    }

}