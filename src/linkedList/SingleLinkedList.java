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
                node = node.next;
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

    public void addNodeInside(T data, T isData){
        Node<T> searchedNode = this.search(isData);

        if (searchedNode == null) {
           this.addNode(data);
        } else {
            Node<T> nextNode = searchedNode.next;
            // 1. 기존 node의 next가 새로운 node를 가리키게 함
            searchedNode.next = new Node<>(data);
            // 2. 새로 넣어준 node의 next가 기존 node가 가리키던 next를 가리키게 함
            searchedNode.next.next = nextNode;
        }
    }

    private Node<T> search(T data) {
        if(this.head == null){
            return null;
        } else {
            Node<T> node = this.head;
            while (node != null){
                if (node.data == data){
                    return node;
                } else {
                    node = node.next;
                }
            }
            return null;
        }
    }

    private boolean deleteNode(T isData){
        if(this.head == null){
            return false;
        } else {
            Node<T> node = this.head;
            // 삭제하려는 data가 head 인 경우
            if (node.data == isData){
                this.head = this.head.next;
                return true;
            } else {
                while(node.next != null){
                    if(node.next.data == isData){
                        node.next = node.next.next;
                        return true;
                    }
                    node = node.next;
                }
                return false;
            }
        }
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> myLinkedList = new SingleLinkedList<>();
        myLinkedList.addNode(1);
        myLinkedList.addNode(2);
        myLinkedList.addNode(3);
        myLinkedList.addNode(4);
        myLinkedList.addNode(5);

        myLinkedList.addNodeInside(5, 1);
        myLinkedList.addNodeInside(6, 3);
        myLinkedList.addNodeInside(7, 20);

        // 헤드 삭제
        myLinkedList.deleteNode(1);
        // 중간 삭제
        myLinkedList.deleteNode(3);
        // 끝 삭제
        myLinkedList.deleteNode(5);
        myLinkedList.printAll();


    }
}
