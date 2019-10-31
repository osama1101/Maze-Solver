import java.util.*;

class MazeSolver {
    public static final int STACK=1,QUEUE=2;
    private Worklist<Square> worklist;
    protected Maze maze;
    protected boolean finished=false;
    protected boolean pathFound=false;
    
    MazeSolver(Maze maze, Worklist<Square> worklist){
	this.maze = maze;
	this.worklist = worklist;
	this.worklist.clear();
	this.worklist.add(maze.getStart());
    }

    public boolean isFinished(){
	return finished;
    }
    
    public boolean pathFound(){
	return pathFound;
    }
    
    /* makes a list of the squares on a path from the start square
       to the exit square */
    public List<Square> getPath(){
    	if(pathFound == false) {
    		return new ArrayList<Square>();
    	}
    	else {
    		ArrayList<Square> list = new ArrayList<Square>();
    		MyStack<Square> stack = new MyStack<Square>();
    		//Square loop = maze.getExit();
    		Square temp = worklist.remove();// is it working?
    		stack.add(temp);
    		while(temp != maze.getStart()) {
    			stack.add(temp.getBack());
    			temp = temp.getBack();
    		}
    		while(!stack.isEmpty()) {
    			list.add(stack.pop());
    		}
    		return list;
    	}
	//TODO:  write the getPath method
    }
    
    /* performs one step of the maze solver algorithm */
    public void step(){
    	
    		//1. Is the worklist empty? If so, the exit is unreachable; terminate the algorithm (the maze is not solvable).
    		if(worklist.isEmpty()) {
    			finished = true;
    			pathFound = false;
    			return;
    		}
    		//2.Otherwise, grab a square from the worklist.
    		else {
    			Square square = worklist.remove();
				//Square oldSq = square;
    			//System.out.println(square);//Testing
    			square.mark();
    			//3.Does the square correspond to the exit square? If so, the finish was reachable; terminate the algorithm (you've found a solution).
    			//System.out.println(square.getRow() + " " + square.getColumn());// Testing
    			//
    			if(square.getType() != Square.EXIT) {
    				ArrayList<Square> neighborsList = new ArrayList<Square>();
					neighborsList = maze.getNeighbors(square);
					for(Square x : neighborsList) {
						if(x.isMarked() == false  && x.isOnlist() == false) {
							//Square oldSq = x;
    						x.onlist();
							x.setBack(square);
							worklist.add(x);
						}
					}
    			}
    			if(square.getType() == Square.EXIT) {
        			//System.out.println("Please print me"); //Testing
        			//square.setBack(worklist.peek());// Testing
    				worklist.add(square);// Should I add it again???
    				finished = true;
    				pathFound = true; 
    				return;
    			}
    		}
    	}
    	//}
	//TODO:  write the step method
}