
class linkedList{
    public static void main(String[] args) {
        LL list = new LL();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);

        list.display();
    }
}
class Node{
    public int data;
    public Node next;
    Node (int data){
        this.data = data;
        this.next = null;
    }
}
class LL{
    public static Node head;
    public static Node tail;
    LL(){
        head = null;
        tail = null;
    }
    public void insert(int data){
        Node p = new Node(data);
        if(head == null){
            head = p;
            tail = p;
        }else{
            tail.next = p;
            tail = tail.next;
        }
    }
    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}