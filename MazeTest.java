import static org.junit.Assert.*;
import java.util.*;
import java.io.FileNotFoundException;

import org.junit.Test;

public class MazeTest {

	@Test
	public void loadMazeTest() throws FileNotFoundException {
		Maze maze1 = Maze.loadMaze("maze-1");
		assertEquals(maze1.getHeight(), 3);
		//System.out.println(maze1.getHeight()); // Testing
		Maze maze2 = Maze.loadMaze("maze-2");
		assertEquals(maze2.getHeight(), 7);
		assertEquals(maze2.getWidth(), 13);
		assertEquals((maze2.getStart()).getType(), Square.START);
		assertEquals((maze2.getExit()).getType(), Square.EXIT);
	}
	@Test
	public void getNeighborsTest() throws FileNotFoundException {
		Maze maze2 = Maze.loadMaze("maze-2");
		ArrayList<Square> list = maze2.getNeighbors(maze2.getSquare(4, 2));
		System.out.println(list);// Testing
		assertEquals("Checking the no of neighbors", list.size(), 2);
		assertEquals("Checking that the neighbors are in correct positions", list.get(0), maze2.getSquare(3, 2));
		assertEquals("Checking that the neighbors are in correct positions", list.get(1), maze2.getSquare(4, 1));
	}
}
