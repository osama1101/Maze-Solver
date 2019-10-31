import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;
public class MyStackTest {

	@Test
	public void test() {
		Stack<Integer> stack = new Stack<Integer>();
		MyStack<Integer> myStack = new MyStack<Integer>();
		stack.push(2);
		myStack.push(2);
		assertEquals(stack.isEmpty(), myStack.isEmpty());
		assertEquals(stack.peek(), myStack.peek());
		assertEquals(stack.pop(), myStack.pop());
		assertEquals(stack.isEmpty(), myStack.isEmpty());
		stack.push(2);
		myStack.push(2);
		stack.push(5);
		myStack.push(5);
		assertEquals(stack.isEmpty(), myStack.isEmpty());
		System.out.println(myStack.isEmpty());// Testing
		myStack.clear();
		stack.clear();
		assertEquals(stack.isEmpty(), myStack.isEmpty());
		System.out.println(myStack.isEmpty());// Testing
		
	}

}