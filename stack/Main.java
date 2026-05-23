public class Main {
    public static void main(String[] args) {
        // Stack using Linked List
        SStack s = new SStack();

        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        s.push(100);

        s.display();

        s.pop();
        s.display();
        System.out.println(s.peek());

        // Stack using Array
        AStack a = new AStack(5);
        System.out.println(a.peek()); // empty
        a.push(10);
        a.push(20);
        a.push(30);
        a.push(40);
        a.push(50);
        a.push(100); // full

        a.display();

        a.pop();
        a.display();
        System.out.println(a.peek());
    }
}
