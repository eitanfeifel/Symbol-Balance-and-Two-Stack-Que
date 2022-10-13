public class MyStackTester{

    public static void main(String[] args){
        MyStack newStack = new MyStack();


        newStack.push(1);
        newStack.push(2);
        newStack.push(3);
        newStack.push(4);


        System.out.println(newStack.peek());
        System.out.println(newStack.size());
        System.out.println(newStack.pop());
        System.out.println(newStack.size());
        System.out.println(newStack.peek());

        newStack.push(5);
        newStack.push(6);
        newStack.push(7);
        newStack.push(8);
        newStack.push(9);
        newStack.push(10);
        System.out.println(newStack.size());

        newStack.push(7);
        System.out.println(newStack.size());
        newStack.push(8);
        System.out.println(newStack.size());
         newStack.push(8);
        System.out.println(newStack.size());
        System.out.println(newStack.pop());



    }













}
