import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class MyStack<T> implements StackADT<T>, Worklist<T> {

    private ArrayList<T> data;
    
    //initializes the stack
    public MyStack(){
    	data = new ArrayList<T>();
	//TODO:  write the MyStack constructor
    }

    //adds an item to the stack
    public void push(T item){
    	data.add(item);
	//TODO:  write the push method
    }
    
    public void add(T item){
    	push(item);
	//TODO:  write the add method
    }
    
    //returns and removes the top element of the stack unless the stack is empty
    public T pop() {
    	if(data.size() == 0) {
    		throw new EmptyStackException();
    	}
    	else {
    		T item = data.remove(data.size()-1);
        	return item;
    	}
	//TODO:  write the pop method
    }
    
    public T remove(){
    	return pop();
	//TODO:  write the remove method
    }

    // returns the top of the stack without removing it    
    public T peek(){
    	if(data.size() == 0) {
    		throw new EmptyStackException();
    	}
    	return data.get(data.size()-1);
	//TODO:  write the peek method
    }
    
    //determines if the stack is empty or not
    public boolean isEmpty() {
    	if(data.size() == 0) {
    		return true;
    	}
    	else{
    		return false;
    	}
	//TODO:  write the isEmpty method
    }
    
    //clears the stack
    public void clear(){
    	data = new ArrayList<T>();
	//TODO:  write the clear method
    }
    //Check whether the the list has this square or not
    /*public boolean isFound(Square square) {
    	for(T x : data) {
    		if(x == square) {
    			return true;
    		}
    	}
    	return false;
    }*/
    
}