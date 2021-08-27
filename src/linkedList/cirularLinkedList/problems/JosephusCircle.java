package linkedList.cirularLinkedList.problems;

import java.util.Scanner;

/**
 * There are n people standing in a circle waiting to be executed.
 * The counting out begins at some point in the circle and proceeds around the circle in a fixed direction.
 * In each step, a certain number of people are skipped and the next person is executed.
 * The elimination proceeds around the circle (which is becoming smaller and smaller as the executed people are removed),
 * until only the last person remains, who is given freedom.
 *
 * Steps:
 *      1. First create a CLL of n nodes
 *      2. Now start removing nodes from the CLL till the last node remains
 *              -> a.Make the node (to be remove) a head node
 *              -> b.Remove head node and make it's next node a head node
 *              -> c.Again proceed with step a
 *      3. Repeat Step 2 till a last node remain
 *      4. Return data of the last node remain as Josephus Position
 */
public class JosephusCircle {

    private static class Node{
        int data;
        Node next;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        print("Enter number of people:");
        int noOfPeople = sc.nextInt();
        print("Enter number of steps:");
        int noOfSteps = sc.nextInt();

        if (noOfPeople<0 || noOfSteps<0) {
            printLn("Please enter a positive value");
            main(args);
            return;
        }

        int position = getJosephusPosition(noOfPeople,noOfSteps);

        String winnerStr = position==0 ? "No one wins as no one is playing" :  "Person at position "+position+" will be the winner";

        printLn(winnerStr);
    }

    public static int getJosephusPosition(int n, int k){

        Node head = null;

        for (int i = n; i >= 1; i--){
            head = addNodeAtStart(head,i);
        }

        if (head == null) return 0;

        print("Numbering of the people: ");
        printList(head);
        printLn("");

        // remove all nodes till last one remains
        while (head.next != head){

            // get the node (as head of the CLL) to remove
            int j = 1;
            while (j <= k){
                head = head.next;
                j++;
            }

            // now remove that head (removal node)
            head = removeHeadNode(head);

        }

        return head.data;
    }

    private static Node removeHeadNode(Node head){

        Node temp = head;
        while (temp.next != head){
            temp = temp.next;
        }
        Node secondNode = head.next;
        temp.next = secondNode;
        return secondNode;
    }

    private static Node addNodeAtStart(Node head, int data){

        Node newNode = new Node();
        newNode.data = data;
        newNode.next = head;

        Node temp = head;

        if (head == null){
            newNode.next = newNode;
        }else {
            // move to last node
            while (temp.next != head){
                temp = temp.next;
            }
            temp.next = newNode;
        }

        head = newNode;
        return head;

    }

    private static void printList(Node head) {
        Node temp = head;
        if (head == null) return;
        do{
            print(temp.data+" ");
            temp = temp.next;
        }while (temp != head);
    }

    private static void printLn(String s){
        System.out.println(s);
    }
    private static void print(String s){
        System.out.print(s);
    }
}
