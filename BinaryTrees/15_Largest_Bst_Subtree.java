import java.io.*;
import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }
  
  public static class BSTPair {
      int max;
      int min;
      boolean isBST;
      int size;
  }
  
  
  public static int maxNodeData;
  public static int maxSize;

  public static BSTPair isLargestBST(Node node) {
      if(node == null) {
          BSTPair bp = new BSTPair();
          bp.max = Integer.MIN_VALUE;
          bp.min = Integer.MAX_VALUE;
          bp.isBST = true;
          bp.size = 0;
          
          return bp;
      }
      
      BSTPair lp = isLargestBST(node.left);
      BSTPair rp = isLargestBST(node.right);
      
      BSTPair curPair = new BSTPair();
      curPair.max = Math.max(node.data, Math.max(lp.max, rp.max));
      curPair.min = Math.min(node.data, Math.min(lp.min, rp.min));
      curPair.size = lp.size + rp.size + 1;
      
      curPair.isBST = (lp.isBST && rp.isBST) &&
                        (node.data >= lp.max && node.data <= rp.min);
                        
      if(curPair.isBST && (curPair.size > maxSize)) {
          maxNodeData = node.data;
          maxSize = curPair.size;
      }
      
      return curPair;
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
    
    isLargestBST(root);
    System.out.println(maxNodeData + "@" + maxSize);
  }

}