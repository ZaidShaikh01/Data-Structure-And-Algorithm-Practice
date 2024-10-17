import java.util.Arrays;
import java.util.LinkedList;

public class Queue {
    //Creating an array using Array
    static class UsingArray{
        static int arr[];
        static int size;
        static int rear;

        UsingArray(int n){
            arr=new int[n];
            size=n;
            rear=-1;
        }
        public static boolean isEmpty(){
            return rear ==-1;
        }
        public static void add(int el){
            if (rear==size-1){
                System.out.println("Overflow Queue");
                return;
            }
            rear++;
            arr[rear]=el;
        }
        public static int remove(){
            if (isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }
            int front=arr[0];
            for (int i=0;i<rear;i++){
                arr[i]=arr[i+1];
            }
            rear--;
            return front;

        }
        public static int peek(){
            if (isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }
            return arr[0];
        }
    }
    static class UsingArrayCircularQueue{
        static int[]array;
        static int size;
        static int rear;
        static int front;
        UsingArrayCircularQueue(int n){
            array=new int[n];
            size=n;
            rear=-1;
            front=-1;
        }
        public static boolean isEmpty(){
            return rear==-1 && front==-1;
        }
        public static boolean isFull(){
            return (rear+1)%size == front;
        }
        public static void add(int el){
            if (isFull()){
                System.out.println("Overflow Queue");
                return;
            }
            if (front==-1){
                front=0;
            }

                rear=(rear+1)%size;
                array[rear]=el;

        }
        public static int remove(){
            if (isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }


            int res=array[front];

            //Removing last element of queue
            if (front==rear){
                front=rear=-1;
            }
            else {
                front=(front+1)%size;
            }
            return res;
        }
        public static int peek(){
            if (isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }
            return array[front];
        }

    }

    //Now using linked list to implement queue
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static class LinkListQueue{
        public static Node head=null;
        public static Node tail=null;

        public static boolean isEmpty(){
            return head==null && tail==null;
        }
        public static void add(int element){
            Node newNode=new Node(element);
            if (head==null){
                head=tail=newNode;
                return;
            }

            tail.next=newNode;
            tail=newNode;
        }
        public static int remove(){
            if (isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int res=head.data;

            if (head==tail){
                head=tail=null;
            }
            else {
                head=head.next;
            }
            return res;
        }
        public static int peek(){
            if (isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {
      /*  UsingArray a=new UsingArray(4);
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(8);
        a.add(9);

        System.out.println(a.remove());
        System.out.println(a.peek());
        a.remove();
        a.remove();
        a.remove();
        a.remove();*/

/*
        UsingArrayCircularQueue cQue=new UsingArrayCircularQueue(3);
        cQue.add(1);
        cQue.add(2);
        cQue.add(3);

        System.out.println(cQue.remove());
        cQue.add(4);
        System.out.println(cQue.remove());
        cQue.add(5);


        while (!cQue.isEmpty()){
            System.out.println(cQue.peek());
            cQue.remove();
        }
        */
        LinkListQueue l1=new LinkListQueue();
        l1.add(5);
        l1.add(6);
        l1.add(7);
        l1.add(8);
        l1.add(9);
        while (!l1.isEmpty()){
            System.out.println(l1.peek());
            l1.remove();
        }
        l1.peek();
        l1.remove();



    }
}
