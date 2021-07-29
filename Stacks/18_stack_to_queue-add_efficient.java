import java.io.*;
import java.util.*;

public class Main {

  public static class StackToQueueAdapter {
    Stack<Integer> mainS;
    Stack<Integer> helperS;

    public StackToQueueAdapter() {
      mainS = new Stack<>();
      helperS = new Stack<>();
    }

    int size() {
      return mainS.size();
    }

    void add(int val) {
      mainS.push(val);
    }

    // O(N)

    int remove() {
      if(mainS.size() == 0) {
          System.out.println("Queue underflow");
          return -1;
      }
      
      // 1. move n-1 elements from main stack to helper stack
      while(mainS.size() > 1)
        helperS.push(mainS.pop());
    
      // 2. get last element in stack + remove last element
      int res = mainS.pop();
      
      // 3. move n-1 elements from helper to main
      while(helperS.size() > 0)
        mainS.push(helperS.pop());
      
      // 4. return res
      return res;
    }

    int peek() {
      if(mainS.size() == 0) {
          System.out.println("Queue underflow");
          return -1;
      }
      
      // 1. move n-1 elements from main stack to helper stack
      while(mainS.size() > 1)
        helperS.push(mainS.pop());
    
      // 2. get last element in stack 
      int res = mainS.peek();
      
      // 3. move n-1 elements from helper to main
      while(helperS.size() > 0)
        mainS.push(helperS.pop());
      
      // return res
      return res;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StackToQueueAdapter qu = new StackToQueueAdapter();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}