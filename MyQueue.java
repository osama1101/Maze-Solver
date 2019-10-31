import java.util.NoSuchElementException;
public class MyQueue<T> implements QueueADT<T>, Worklist<T>
{
    private QNode<T> front;
    private QNode<T> rear;
    
    //nested class QNode:  nodes used in the queue
    class QNode<T>{
    	//holds the data value and reference for a node
    	private T item;
    	private QNode<T> next;
    	
    	//constructors for node
    	QNode(T item){
    	    this(item,null);
    	}
    	
    	QNode(T item, QNode<T> next){
    	    this.item = item;
    	    this.next = next;
    	}
    }
    //initializes empty queue
    public MyQueue(){
    	this.front = null;
    	this.rear = null;
	//TODO:  write this constructor
    }
    
    //adds element to the queue
    public void enqueue(T item){
    	QNode node = new QNode(item);
    	if(front == null) {
    		front = node;
    		rear = node;
    	}
    	else {
    		rear.next = node;
    		rear = node;
    	}
	//TODO:  write the enqueue method
    }
    
    public void add(T item){
    	enqueue(item);
	//TODO:  write the add method
    }
    
    // gets and removes the next thing in the queue that is supposed to be executed
    // throw a NoSuchElementException if the queue is empty
    public T dequeue() {
    	if(front == null) {
    		throw new NoSuchElementException(); // FIX THE EXCEPTIONS AND TEST THEM
    	}
    	T data = front.item;
    	front = front.next;
    	if(front == null) {
    		rear = null;
    	}
    	return data;
	//TODO: write the dequeue method
    }
    
    public T remove(){
    	return dequeue();
	//TODO: write the remove method
    }
    
    // gets the first item in the queue without removing it
    // throw a NoSuchElementException if the queue is empty
    public T peek(){
    	if(front == null) {
    		throw new NoSuchElementException(); // FIX THE EXCEPTIONS AND TEST THEM
    	}
    	return front.item;
	//TODO:  write the peek method
    }
    
    // tests to see if the queue is empty
    public boolean isEmpty(){
    	if(front == null) {
    		return true;
    	}
    	else {
    		return false;
    	}
	//TODO:  write the isEmpty method
    }
    
    //clears the queue
    public void clear(){
    	front = null;
    	rear = null;
	//TODO:  write the clear method
    }
}

