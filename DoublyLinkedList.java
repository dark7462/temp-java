public class DoublyLinkedList {
    public static void main(String[] args) {
        DLL list = new DLL();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.display();
        list.displayReverse();
        list.insertAtHead(5);
        list.display();
        list.insertAtPosition(15, 2);
        list.display();
    }
}

class DLLNode{
    public int data;
    public DLLNode next;
    public DLLNode prev;
    DLLNode (int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
class DLL{
    public static DLLNode head;
    public static DLLNode tail;
    DLL(){
        head = null;
        tail = null;
    }
    // defult / insert at last
    public void insert(int data){
        DLLNode p = new DLLNode(data);
        if(head == null){
            head = p;
            tail = p;
        }else{
            p.prev = tail;
            tail.next = p;
            tail = tail.next;
        }
    }
    // insert at head
    public void insertAtHead(int data){
        DLLNode p = new DLLNode(data);
        if(head == null){
            head = p;
            tail = p;
            // insert(10);
        }else{
            p.next = head;
            head.prev = p;
            head = p;
        }
    }
    // insert at position
    public void insertAtPosition(int data, int pos){
        DLLNode p = new DLLNode(data);
        if(head == null){
            insert(data);
        }else if (pos == 0){
            insertAtHead(data);
        }else{
            DLLNode temp = head;
            for(int i = 0; temp != null && i < pos - 1; i++){
                temp = temp.next;
            }
            if(temp == null){
                System.out.println("Position is out of bounds");
                return;
            }
            p.next = temp.next;
            if(temp.next != null){
                temp.next.prev = p;
            }
            temp.next = p;
            p.prev = temp;
        }
    }
    public void display(){
        DLLNode temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    } 
    public void displayReverse(){
        DLLNode temp = tail;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }
    // delete at last
    public void delete(){
        if(head == null){
            System.out.println("List is empty");
        }else if(head == tail){
            head = null;
            tail = null;
        }else{
            tail = tail.prev;
            tail.next = null;
        }
    }
    // delete at head
    public void deleteAtHead(){
        if(head == null){
            System.out.println("List is empty");
        }else if(head == tail){
            head = null;
            tail = null;
        }else{
            head = head.next;
            head.prev = null;  
        }
    }
    // delete at position
    public void deleteAtPosition(int pos){
        if(head == null){
            System.out.println("List is empty");
        }else if(pos == 0){
            deleteAtHead();
        }else{
            DLLNode temp = head;
            for(int i = 0; temp != null && i < pos - 1; i++){
                temp = temp.next;
            }
            if(temp == null || temp.next == null){
                System.out.println("Position is out of bounds");
                return;
            }
            temp.next = temp.next.next;
            if(temp.next != null){
                temp.next.prev = temp;
            }
        }
    }
}
