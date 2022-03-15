package queue;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue<T> {

    Queue<T> queue = new LinkedList<>();

    public void enqueue(T item) {
        queue.add(item);
    }

    public T dequeue() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.remove();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {

        MyQueue<String> myQueue = new MyQueue<>();

        myQueue.enqueue("a");
        myQueue.enqueue("b");
        myQueue.enqueue("c");

        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
    }
}
