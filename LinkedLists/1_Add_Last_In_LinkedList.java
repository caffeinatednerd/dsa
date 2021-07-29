import java.io.*;
import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node next;
    
    Node(int val) {
        data = val;
        next = null;
    }
  }

  public static class LinkedList {
    Node head;
    Node tail;
    int size;

    void addLast(int val) {
        // create a new node with given value
        Node n = new Node(val);
        // update currentLast's address with new Node's address
        tail = n;
        // increase size of LL by 1
        size++;
        // print the last added element (as per question requirement)
        System.out.println(val);
    }
  }

  public static void testList(LinkedList list) {
    for (Node temp = list.head; temp != null; temp = temp.next) {
      System.out.println(temp.data);
    }
    System.out.println(list.size);

    if (list.size > 0) {
      System.out.println(list.tail.data);
    } 
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    LinkedList list = new LinkedList();

    String str = br.readLine();
    while(str.equals("quit") == false){
      if(str.startsWith("addLast")){
        int val = Integer.parseInt(str.split(" ")[1]);
        list.addLast(val);
      } 
      str = br.readLine();
    }

    testList(list);
  }
}