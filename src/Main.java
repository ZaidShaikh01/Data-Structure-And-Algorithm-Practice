
import java.util.*;

public class Main {
    public static void recursiveBottomPush(int data,Stack<Integer> s1) {
        if(s1.empty()){
            s1.push(data);
            return;
        }
        int t=s1.pop();
        recursiveBottomPush(data,s1);
        s1.push(t);
    }
    public static void reversString(String str1){
        Stack<Character> s2=new Stack<>();

        for (int i=0;i<str1.length();i++){
            s2.push(str1.charAt(i));
        }
        StringBuilder str2 = new StringBuilder("");
        for (int i=0;i<str1.length();i++){
            str2.append(s2.pop());
        }
        str1=str2.toString();
        System.out.println(str1);
    }
    public static void reverseStack(Stack<Integer> s1){
        if(s1.empty()){

            return;
        }
        int top=s1.pop();
        reverseStack(s1);
        recursiveBottomPush(top,s1);
    }

    public static void nextGreater(int [] arr,int [] nextGreater){
        Stack<Integer> s=new Stack<>();

        for (int i=arr.length-1;i>=0;i--){
            while (!s.empty() && arr[i]>arr[s.peek()]){
                s.pop();
            }
            if (s.empty() ){
                nextGreater[i]=-1;
            }
            else {
                nextGreater[i]= arr[s.peek()];
            }
            s.push(i);
        }
    }
    public static void stackSpanProblem(int [] stocks, int [] span){
        Stack<Integer> s1=new Stack<>();
        span[0]=1;
        s1.push(0);
        for (int i=1;i<stocks.length;i++){
            int currPrice=stocks[i];
            while (!s1.empty() && currPrice>=stocks[s1.peek()]){
                s1.pop();
            }

            if (s1.isEmpty()){
                span[i]=i+1;
            }
            else {
                int prevHigh=s1.peek();
                span[i]=i-prevHigh;
            }
            s1.push(i);

        }

    }
    public static void parenthesisCheck(String str) {
        Stack<Character> s = new Stack<>();
        boolean flag=true;

        for (int i = 0; i < str.length(); i++) {
            char parenthesis = str.charAt(i);
            if (parenthesis == '{' || parenthesis == '[' || parenthesis == '(') {
                s.push(parenthesis);
            }
            else {
                if(s.empty()){
                    flag=false;
                    break;
                }
                if(s.peek()=='(' && parenthesis==')' || s.peek()=='[' && parenthesis==']' || s.peek()=='{' && parenthesis=='}'){
                    s.pop();
                }
                else {
                    flag=false;
                }
            }
        }
        System.out.println(flag?"True":"False");
    }
    public static void duplicateParenthesis(String string){
        Stack<Character> s1=new Stack<>();
        boolean flag=true;

        for (int i=0;i<string.length();i++){
            char ch=string.charAt(i);

            if (ch==')' ){
                int count =0;
                while(s1.peek()!='('){
                    count++;
                    s1.pop();
                }
                if(count<1){
                    flag=false;
                    break;
                }
                else {
                    s1.pop();
                }

            }
            else {
                s1.push(ch);
            }
        }
        if (flag){
            System.out.println("No duplicates");
        }
        else {
            System.out.println("Duplicates are available");
        }
    }
    public static void main(String[] args) {
       /* Stack<Integer> s1=new Stack<>();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        //System.out.println(s1.pop());
        recursiveBottomPush(0,s1);
        System.out.println(s1);
        //s1.clear();
        //System.out.println(s1.search(1));

        reversString("Zaid Shaikh");
        System.out.println(s1);
        reverseStack(s1);
        System.out.println(s1);*/

        int [] stocks={100,80,60,70,60,85,100};
        int [] span=new int[stocks.length];
        stackSpanProblem(stocks,span);
        System.out.println(Arrays.toString(span));

        //Greatest element
        int [] arr={6,8,0,1,3};
        int [] nextGreat=new int[arr.length];
        nextGreater(arr,nextGreat);
        System.out.println(Arrays.toString(nextGreat));
        parenthesisCheck("({})[]})");
        duplicateParenthesis("(((a+b)+c)+(z))");
    }
}