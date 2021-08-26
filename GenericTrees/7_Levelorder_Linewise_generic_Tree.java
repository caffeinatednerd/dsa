import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  public static int size(Node node) {
    int s = 0;

    for (Node child : node.children) {
      s += size(child);
    }
    s += 1;

    return s;
  }

  public static int max(Node node) {
    int m = Integer.MIN_VALUE;

    for (Node child : node.children) {
      int cm = max(child);
      m = Math.max(m, cm);
    }
    m = Math.max(m, node.data);

    return m;
  }

  public static int height(Node node) {
    int h = -1;

    for (Node child : node.children) {
      int ch = height(child);
      h = Math.max(h, ch);
    }
    h += 1;

    return h;
  }

  public static void traversals(Node node){
    System.out.println("Node Pre " + node.data);

    for(Node child: node.children){
      System.out.println("Edge Pre " + node.data + "--" + child.data);
      traversals(child);
      System.out.println("Edge Post " + node.data + "--" + child.data);
    }

    System.out.println("Node Post " + node.data);
  }

  public static void levelOrderLinewise(Node node){
    // // Approach 1: Using a single queue
    //   Queue<Node> qu = new ArrayDeque<Node>();
    //   // Add root node
    //   qu.add(node);
      
    //   // kaam chaleha till queue.size() > 0
    //   while(qu.size() > 0) {
    //       // get number of nodes of current Level
    //       int size = qu.size();
          
    //       // loop till number of elements of current level
    //       for(int i=0; i<size; i++) {
    //           // remove node
    //           Node rem = qu.remove();
    //           // print node
    //           System.out.print(rem.data + " ");
    //           // add children of current node in queue
    //           for(Node child: rem.children) {
    //             qu.add(child);
    //           }
    //       }
    //       // Enter into newline when all nodes of current level have been traversed
    //       System.out.println();
    //   }
      
      
    // // Approach 2: Using 2 Queues 
    
    // // to store current node
    // Queue<Node> q1 = new ArrayDeque<Node>();
    // // to store children of current node
    // Queue<Node> q2 = new ArrayDeque<Node>();
    
    // // Add rootnode
    // q1.add(node);
    
    // while(q1.size() > 0) {
    //     while(q1.size() > 0) {
    //         Node rem = q1.remove();
    //         System.out.print(rem.data + " ");
    //         for(Node child: rem.children) {
    //             q2.add(child);
    //         }
    //     }
        
    //     System.out.println();
    //     q1 = q2;
    //     q2 = new ArrayDeque<>();
        
    //     // Failed approach but can be successful
    //     /*if(q1.size() == 0) {
    //         q1 = q2;
    //         q2 = new ArrayDeque<>();
    //         System.out.println();
    //     }
    //     else {
    //         for(Node child : rem.children) {
    //             q2.add(child);
    //         }
    //     }*/
    // }
    
    // TODO
    // Approach 3 - Marker node in a single queue to keep track level, -1
    
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    levelOrderLinewise(root);
  }

}