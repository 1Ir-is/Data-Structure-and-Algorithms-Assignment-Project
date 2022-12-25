public class Queue {
    int MAX;
    char[] Q;
    int front = -1;
    int rear = -1;

    // init QUEUE
    public Queue(int M){
        Q = new char[M];
        this.MAX = M;
    }
    boolean isEmpty(){
        return (front == -1);
    }
    boolean isFull(){
        return (rear + 1) % MAX == front;
    }
    public void enQueue(char x){
        if (isFull()){
            return;
        }
        if (isEmpty()){
            front = rear = 0;
        }
        else{
            rear = (rear + 1) % MAX;
        }
        Q[rear] = x;
    }
    public char deQueue(){
        Character x = null;
        if (isEmpty()){
            return x;
        }
        x = Q[front];
        if (front == rear){
            front = rear = -1;
        }
        else {
            front = (front + 1) % MAX;
        }
        return x;
    }
    public int count(){
        if (front == 0 && rear == MAX-1){
            return MAX;
        }
        if (isEmpty()){
            return 0;
        }
        return (2 * MAX + rear - front + 1) % MAX;
    }
}



