public class LL {
    public Node head;
    public Node tail;

    LL() {
        head = null;
        tail = null;
    }

    // Insert at last
    public void insert(int data) {
        Node p = new Node(data);
        if (head == null) {
            head = p;
            tail = p;
        } else {
            tail.next = p;
            tail = p; // Updated directly to the new node
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }   

    // Delete at head
    public void deleteAtHead() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
        if (head == null) { // If the list became empty, reset tail too
            tail = null;
        }
    }

    public int peek(){
        if(head == null){
            System.out.println("List is empty");
            return -1;
        }
        return head.data;
    }
}