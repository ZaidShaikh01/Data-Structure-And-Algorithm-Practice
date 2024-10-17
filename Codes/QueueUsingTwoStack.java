import java.util.Stack;
public class QueueUsingTwoStack {
    static class TwoStackQueue{
        static Stack<Integer> s1=new Stack<>();
        static Stack<Integer> s2=new Stack<>();


        public static boolean isEmpty(){
            return s1.isEmpty();
        }

        static void add(int data){ //O(N)
            while (!s1.empty()){
                int element=s1.pop();
                s2.push(element);
            }
            s1.push(data);

            while (!s2.empty()){
                int element=s2.pop();
                s1.push(element);
            }

        }
        static int remove(){
            if (isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }
            return s1.pop();
        }
        static int peek(){
            if (isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }
            return s1.peek();
        }
    }
    public static void main(String[] args) {
        TwoStackQueue tq=new TwoStackQueue();
        tq.add(5);
        tq.add(2);
        tq.add(3);

        tq.add(19);
        while (!tq.isEmpty()){
            System.out.println(tq.peek());
            tq.remove();
        }


    }

}
