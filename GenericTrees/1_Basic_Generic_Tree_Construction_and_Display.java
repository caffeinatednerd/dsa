import java.util.*;

public class Main {
    public static class Node {
        int data;
        // list of children Nodes of current node
        ArrayList<Node> children;
        
        public Node() {
            children  = new ArrayList<>();
        }
    }
    
    public static Node construct(int[] arr) {
        Node rootnode = new Node();
        rootnode.data = arr[0];
        
        // to keep track of current node (top of stack), to add children
        Stack<Node> st = new Stack<>();
        // push rootnode as a first step
        st.push(rootnode);
        
        for(int i=1; i<arr.length; i++) {
            if(arr[i] == -1) {
                // pop from top of stack -> go 1 level up in tree
                st.pop();
            } else {
                // create new node
                Node n = new Node();
                // assign data to new node
                n.data = arr[i];
                // Add n as child of st.peek
                st.peek().children.add(n);
                // push node at top of stack
                st.push(n);
            }
        }
        
        return rootnode;
    }
    
    public static void display(Node node) {
        
       // To print only those who have at least 1 children
        // if(node.children.size() == 0)
        //     return;
        
        // Method 1 - Using for loop
        
        // ArrayList<Node> childrenList = node.children;
        
        // // Expectation - Print Self.data and Self.children
        // System.out.print(node.data + " -> ");
        // for(int i = 0; i < childrenList.size(); i++) {
        //     Node childNode = childrenList.get(i);
        //     System.out.print(childNode.data + ", ");   
        // }
        // // Faith - Print all others
        // for(int i = 0; i < childrenList.size(); i++) {
        //     Node childNode = childrenList.get(i);
        //     display(childNode);
        // }
        
        // Method 2 - Using forEach loop
        String s = "";
        s += node.data + " -> ";
        for(Node child : node.children) {
            s += child.data + ", ";
        }
        System.out.print(s);
        System.out.println(" .");
        
        for(Node child : node.children) {
            display(child);
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30 ,70, -1, 80, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        
        Node root = construct(arr);
        display(root);
    }
}