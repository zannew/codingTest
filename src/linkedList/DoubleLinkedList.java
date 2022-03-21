package linkedList;

public class DoubleLinkedList<T> {

    public Node<T> head = null;
    public Node<T> tail = null;

    public class Node<T> {
        T data;
        Node<T> prev = null;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public void addNode(T data){
        if(this.head == null){
            this.head = new Node<>(data);
            this.tail = this.head;
        } else {
            Node<T> node = this.head;
            while(node.next != null){
                node = node.next;
            }
            node.next = new Node<>(data);
            node.next.prev = node;
            this.tail = node.next;
        }
    }

    public void printAll(){
        if(this.head != null){
            Node<T> node = this.head;
            System.out.println(node.data);
            while(node.next != null){
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public T searchFromHead (T isData){
        if(this.head == null){
            return null;
        } else {
            Node<T> node = this.head;
            while(node != null){
                if(node.data == isData){
                    return node.data;
                } else {
                    node = node.next;
                }
            }
        }
        return null;
    }

    public T searchFromTail (T isData) {
        if(this.head == null){
            return null;
        } else {
            Node<T> node = this.tail;
            while(node != null) {
                if(node.data == isData){
                    return node.data;
                } else {
                    node = node.prev;
                }
            }
        }
        return null;
    }

    public boolean addToFront(T existedData, T newData) {
        if (this.head == null) {
            this.head = new Node<>(newData);
            this.tail = this.head;
            return true;
        } else if (this.head.data == existedData) {
            Node<T> newHead = new Node<>(newData);
            newHead.next = this.head;
            this.head = newHead;
            return true;
        } else {
            Node<T> node = this.head;
            while (node != null) {
                if (node.data == existedData) {
                    Node<T> nodePrev = node.prev;

                    nodePrev.next = new Node<>(newData);
                    nodePrev.next.next = node;

                    nodePrev.next.prev = nodePrev;
                    node.prev = nodePrev.next;
                    return true;
                } else {
                    node = node.next;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();

        doubleLinkedList.addNode(1);
        doubleLinkedList.addNode(2);
        doubleLinkedList.addNode(3);
        doubleLinkedList.addNode(4);
        doubleLinkedList.addNode(5);
        doubleLinkedList.addNode(6);
        doubleLinkedList.addNode(7);
        doubleLinkedList.addNode(8);
        doubleLinkedList.addNode(9);

        doubleLinkedList.printAll();
        System.out.println("------------------------");

        System.out.println(doubleLinkedList.searchFromHead(3));
        System.out.println(doubleLinkedList.searchFromHead(10));
        System.out.println(doubleLinkedList.searchFromTail(3));
        System.out.println(doubleLinkedList.searchFromTail(0));

        doubleLinkedList.addToFront(3,2);
        doubleLinkedList.printAll();
        System.out.println("------------------------");

        doubleLinkedList.addToFront(9,8);
        doubleLinkedList.printAll();
        System.out.println("------------------------");

    }


}
