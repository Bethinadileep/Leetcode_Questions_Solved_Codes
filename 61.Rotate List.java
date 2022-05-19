import java.util.*;
class Node{
    
    int val;
    Node next;
    Node(int a) {
        val = a;
        next = null;
    }
}
class Main{
    static Node insertNode(Node head, int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return head;
        }
        Node temp = head;
        while(temp.next != null) temp = temp.next;
        
        temp.next = newNode;
        return head;
    }
    static Node rotateRight(Node head, int k) {
        if (head == null || head.next ==null) return head;
        for(int i = 0; i < k; i++) {
            Node temp = head;
            while (temp.next.next != null) temp = temp.next;
            Node end = temp.next;
            temp.next = null;
            end.next = head;
            head =end;
        }
        return head;
    }
    //utility function to print List 
    static void printList(Node head) {
        while(head.next != null) {
            System.out.println(head.val + "->");
            head = head.next;
        }
        System.out.println(head.val);
    }


	public static void main(String[] args) {
	    Node head = null;
	    head = insertNode(head, 1);
	    head = insertNode(head, 2);
	    head = insertNode(head, 3);
	    head = insertNode(head, 4);
	    head = insertNode(head, 5);
	    
	    System.out.println("Original List: ");
	    printList(head);
	    
	    int k = 2;
	    Node newHead = rotateRight(head, k); //calling funtion for rotationg 
	    
	    System.out.println("After " + k + " iterations: ");
	    printList(newHead);
	}
}
