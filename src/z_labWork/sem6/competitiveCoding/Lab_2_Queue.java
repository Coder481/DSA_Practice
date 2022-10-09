package z_labWork.sem6.competitiveCoding;

public class Lab_2_Queue {
    public static void main(String[] args) {

        QueueImplementation queue = new QueueImplementation(4);
        queue.push("Java");
        queue.push("Kotlin");
        queue.push("Python");
        queue.pop();
        queue.push("C++");
        queue.push("C");

        System.out.println("Now popping from Queue");
        queue.pop();
        queue.pop();
        queue.pop();
        queue.pop();
        queue.push("#");
        queue.pop();

    }
}


class QueueImplementation{

    Object[] arr;
    int filledElements;
    int capacity ;
    int rear;
    int front;

    public QueueImplementation(int size) {
        arr = new Object[size];
        capacity = size;
        filledElements = 0;
        rear = -1;
        front = 0;
    }

    public void push(Object element){
        if(filledElements == capacity){
            System.out.println("Queue Overflow");
            return;
        }

        rear = (rear + 1) % capacity;
        arr[rear] = element;
        filledElements++;
    }

    public Object pop(){
        if (filledElements == 0){
            System.out.println("Queue Underflow");
            return null;
        }

        Object res = arr[front];
        arr[front] = null;
        front = (front + 1) % capacity;
        filledElements--;
        System.out.println("Popped: "+res.toString());
        return res;
    }

}
