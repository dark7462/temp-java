class SingleLinkedList {
    public static void main(String[] args) {
        LL list = new LL();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);

        System.out.print("Original list: ");
        list.display();

        list.deleteAtLast();
        System.out.print("After deleting last: ");
        list.display();
    }
}

class Node {
    public int data;
    public Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LL {
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

    // Insert at head
    public void insertAtHead(int data) {
        Node p = new Node(data);
        if (head == null) {
            head = p;
            tail = p;
        } else {
            p.next = head;
            head = p;
        }
    }

    // Insert at position
    public void insertAtPosition(int data, int pos) {
        if (pos == 0) {
            insertAtHead(data);
            return;
        }
        
        Node p = new Node(data);
        Node temp = head;
        for (int i = 0; temp != null && i < pos - 1; i++) {
            temp = temp.next;
        }
        
        if (temp == null) {
            System.out.println("Position is out of bounds");
            return;
        }
        
        p.next = temp.next;
        temp.next = p;
        
        if (p.next == null) { // If inserted at the very end, update tail
            tail = p;
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

    // Delete at last
    public void deleteAtLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) { // Only one element
            head = null;
            tail = null;
            return;
        }
        
        // Stop at the second-to-last node
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        
        temp.next = null; // Sever the link to the last node
        tail = temp;      // Update the tail pointer
    }

    // Delete at position
    public void deleteAtPosition(int pos) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (pos == 0) {
            deleteAtHead();
            return;
        }
        
        Node temp = head;
        for (int i = 0; temp != null && i < pos - 1; i++) {
            temp = temp.next;
        }
        
        if (temp == null || temp.next == null) {
            System.out.println("Position is out of bounds");
            return;
        }
        
        if (temp.next == tail) { // If deleting the last node, update tail
            tail = temp;
        }
        temp.next = temp.next.next;
    }
}