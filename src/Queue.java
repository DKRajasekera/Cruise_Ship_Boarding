public class Queue {
     int front = -1;
     int rear = -1;
     Cabin[] queue;
     int size;

     public Queue(int size){
         queue = new Cabin[size];
         this.size = size;
     }
    public void enqueue(Cabin passangers){
        if (front == -1 && rear == -1){
            front = rear = 0;
            queue[rear] = passangers;
        }
        else if (((rear + 1)%size) == front){
            System.out.println("Queue is full");
        }
        else {
            rear = (rear + 1)%size;
            queue[rear] = passangers;
        }
    }
    public void dequeue(){
        if (front == -1 && rear == -1){
            System.out.println("Queue is empty");
        }
        else if (front == rear){
            queue[front] = null;
            front = rear = -1;
            System.out.println("ewfwghr");
        }
        else {
            queue[front] = null;
            front = (front + 1)%10;
        }
    }
}
