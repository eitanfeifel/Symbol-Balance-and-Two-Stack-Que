public class TwoStackQueue<T> implements TwoStackQueueInterface<T>
{

    MyStack s1 = new MyStack();
    MyStack s2 = new MyStack();

    public TwoStackQueue(MyStack s1, MyStack s2){
        this.s1 = s1;
        this.s2 = s2;

    }

    public void enqueue(T x){
        s1.push(x);
    }

    public T dequeue(){
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return (T)s2.pop();
    }

    public int size(){
        return(s1.size()+ s2.size());
    }

    public boolean isEmpty(){
        return(s1.isEmpty() && s2.isEmpty());
    }


}
