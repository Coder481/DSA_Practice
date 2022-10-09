package z_labWork.sem6.competitiveCoding;

public class Lab_3_LinkedList {

    public static void main(String[] args) {

        LinkedListImplementation linkedList = new LinkedListImplementation();

        linkedList.insert(10);
        System.out.println("Deleted Node value: "+linkedList.deleteLastNode());
        linkedList.insert(20);
        linkedList.insert(30);
        System.out.println("Deleted Node value: "+linkedList.deleteLastNode());
        linkedList.insert(40);

        linkedList.printList();
    }

}

class LinkedListImplementation{
    Node head;

    public void insert(int value){

        Node newNode = new Node(value);

        if(head == null){
            head = newNode;
        }
        else {
            Node temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }

    }

    public Integer deleteLastNode(){
        Node temp = head;

        if(temp == null){
            return null;
        }
        if (temp.next == null){
            int res = head.value;
            head = null;
            return res;
        }

        while (temp.next.next != null){
            temp = temp.next;
        }
        int res = temp.next.value;
        temp.next = null;
        return res;
    }

    public void deleteNode(int value){
        Node temp = head;

        Node prevNode = temp;
        while (temp != null && temp.value == value){
            prevNode = temp;
            temp = temp.next;
        }

        if (temp == null) return;

        Node nextNode = temp.next;

    }

    /*public void deleteHead(){
        if (head != null &&){
            head = head.next;
        }
    }*/

    public void insertAfter(int value){

    }

    public void printList(){

        Node temp = head;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }

    }

}

class Node{

    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}
