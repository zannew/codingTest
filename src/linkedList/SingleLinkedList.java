package linkedList;

public class SingleLinkedList<T> {

    public Node<T> head = null;

    public class Node<T> {
        T data;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public void addNode(T data){
        if(head == null){
            head = new Node<>(data);
        } else {
            Node<T> node = this.head;
            while(node.next != null){
                node= node.next;
            }
            node.next = new Node<T>(data);
        }
    }

    public void printAll(){
        if(head != null){
            Node<T> node = this.head;
            System.out.println(node.data);
            while(node.next != null){
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> myLinkedList = new SingleLinkedList<>();
        myLinkedList.addNode(1);
        System.out.println(myLinkedList.head.data);
        myLinkedList.addNode(2);
        System.out.println(myLinkedList.head.data);
        // head 의 next 의 data
        System.out.println(myLinkedList.head.next.data);

        myLinkedList.addNode(3);

        myLinkedList.printAll();
    }
}
