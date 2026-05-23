public class AStack {
    int[] arr;
    int top;
    int n;
    int last;
    AStack(int size) {
        arr = new int[size];
        n = size;
        top = -1;
        last = -1;
    }

    // empty
    public boolean isEmpty() {
        return top == -1;
    }

    // full
    public boolean isFull() {
        return last == n - 1;
    }

    //push
    public void push(int val){
        if(isFull()){
            System.out.println("Stack is full");
            return;
        } else {
            last++;
            arr[last] = val;
            if(top == -1)top++;
        }
    }
    //pop
    public int pop(){
        int val;
        if(isEmpty()){
            System.out.println("Stack is empty");
            val = -1;
        } else {
            val = arr[top];
            top++;
            if(top > last){
                top = -1;
                last = -1;
            } 
        }
        return val;
    }
    //peek
    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        } else {
            return arr[top];
        }
    }

    // display
    public void display(){
        if(isEmpty()){
            System.out.println("Stack is empty");
        } else {
            for(int i = top; i <= last; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
