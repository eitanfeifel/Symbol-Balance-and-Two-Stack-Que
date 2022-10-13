import java.util.*;
public class MyStack<T> implements MyStackInterface<T> {

    
    private T[] stackList;
    private int arraySize;
    private static final int SIZE = 10;


    public MyStack(){
        
        
        stackList = (T []) new Object [SIZE];
        arraySize = 0;
        
        
    }

    public void push(T x){
        if(arraySize == stackList.length)
            ensureCapacity(size() *2 +1);
        
        stackList[arraySize] = x;
        arraySize++;
    }

    public T pop(){
        if (size() == 0){
            throw new ArrayIndexOutOfBoundsException("Empty Stack!");
        }
        T removed = stackList[arraySize-1];
        arraySize--;
        return removed;
    } 

    public T peek(){
      if (size() == 0){
            throw new ArrayIndexOutOfBoundsException("Empty Stack!");
        }
        T peeked = stackList[arraySize-1];
        return peeked;
    }
    public boolean isEmpty(){
        return (arraySize ==0);
    }

    public int size(){
        return arraySize;
    }

    
    private void ensureCapacity(int newCapacity){
        if (newCapacity < arraySize)
            return;
        T [] old = stackList;
        stackList = (T []) new Object [newCapacity];
        for (int i =0; i< size(); i++){
            stackList[i] = old[i];
        }
    }


}
