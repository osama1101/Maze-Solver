import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
public class MyQueueTest {

	@Test
	public void test() {
		ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
		MyQueue<Integer> myQueue = new MyQueue<Integer>();
		myQueue.add(2);
		queue.add(2);
		assertEquals(queue.peek(), myQueue.peek());
		assertEquals(queue.isEmpty(), myQueue.isEmpty());
		myQueue.remove();
		queue.remove();
		assertEquals(queue.isEmpty(), myQueue.isEmpty());
		myQueue.add(2);
		queue.add(2);
		myQueue.add(5);
		queue.add(5);
		assertEquals(queue.isEmpty(), myQueue.isEmpty());
		myQueue.clear();
		queue.clear();
		assertEquals(queue.isEmpty(), myQueue.isEmpty());
	}

}
