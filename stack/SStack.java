public class SStack {
    public LL list;
    
    SStack() {
        list = new LL();
    }

    public void push(int data) {
        list.insert(data);
    }

    public int pop() {
        if(list.head == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        int ans = list.peek();
        list.deleteAtHead();
        return ans;
    }
    public int peek() {
        return list.peek();
    }

    public void display() {
        list.display();
    }
}
