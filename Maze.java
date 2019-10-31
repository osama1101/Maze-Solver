import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.util.*;
public class Maze {
   private static int MAXSQSIZE = 30;
   private int height;
   private int width;
   private Square[][] grid;
   private Square startSquare;
   private Square exitSquare;
   
   public int getHeight(){
      return height;
   }
   
   public int getWidth(){
      return width;
   }
   
   public Square getStart(){
      return startSquare;
   }
   
   public Square getExit(){
      return exitSquare;
   }
   
   public Square getSquare(int row, int col){
      return grid[row][col];
   }

    /* resets the maze by resetting all of its squares  */   
   public void reset(){
      for(int r=0; r<height; r++)
         for(int c=0; c<width; c++)
         grid[r][c].reset();
   }
   
   public static Maze loadMaze(String fname) throws FileNotFoundException {
	   Maze maze1 = new Maze();
	   Scanner input = new Scanner(new File(fname));
	   int rows = input.nextInt();
       int columns = input.nextInt();
       maze1.height = rows;
       maze1.width = columns;
       maze1.grid = new Square[rows][columns]; 
       for(int i = 0; i < rows; i++){
           for(int j = 0; j < columns; j++){
        	   int type = input.nextInt();
        	   maze1.grid[i][j] = new Square(type, i, j);
        	   if(type == Square.START) {
        		   maze1.startSquare = new Square(type, i, j);
        	   }
        	   else if(type == Square.EXIT) {
        		   maze1.exitSquare = new Square(type, i, j);
        	   }
           }
       }
	   //Validation check
       if(maze1.startSquare == null) {
    	   throw new RuntimeException("There is no start to the maze");
       }
       if(maze1.exitSquare == null) {
    	   throw new RuntimeException("There is no end to the maze");
       }
       return maze1;   
       }
   
   public ArrayList<Square> getNeighbors(Square square){
	   ArrayList<Square> list = new ArrayList<Square>();
	   //Check that the neighbor in the north can be added
	   if(square.getRow() != 0) {
		   int type = (grid[square.getRow()-1][square.getColumn()]).getType();
		   if(type == Square.SPACE || type == Square.EXIT) {
			   list.add(grid[square.getRow()-1][square.getColumn()]);
		   }
	   }
	   //Check that the neighbor in the East can be added
	   if(square.getColumn() != width-1) {
		   int type = (grid[square.getRow()][square.getColumn()+1]).getType();
		   if(type == Square.SPACE || type == Square.EXIT) {
			   list.add(grid[square.getRow()][square.getColumn()+1]);
		   }
	   }
	   //Check that the neighbor in the South can be added
	   if(square.getRow() != height-1) {
		   int type = (grid[square.getRow()+1][square.getColumn()]).getType();
		   if(type == Square.SPACE || type == Square.EXIT) {
			   list.add(grid[square.getRow()+1][square.getColumn()]);
		   }
	   }
	   //Check that the neighbor in the West can be added
	   if(square.getColumn() != 0) {
		   int type = (grid[square.getRow()][square.getColumn()-1]).getType();
		   if(type == Square.SPACE || type == Square.EXIT) {
			   list.add(grid[square.getRow()][square.getColumn()-1]);
		   }
	   }
	   return list;
   }
   
                   
   public String toString(){
      String mstring = "";
      for(int i=0; i<height; i++){
        for(int j=0; j<width; j++){
           mstring += grid[i][j];
        }
        if(i<height-1)
           mstring+="\n";
      }
      return mstring;
   }

    /* draws the maze on the GUI.  DO NOT CHANGE! */   
   public void draw(Graphics g, Dimension d){
      int sqsize = Math.min(Math.min(d.width/width,d.height/height),MAXSQSIZE);
      int top=(d.height-sqsize*height)/2;
      int left=(d.width-sqsize*width)/2;
      for(int i=0; i<height; i++){
         for(int j=0; j<width; j++){
            Square sq = grid[i][j];
            Color c = Color.white;
            switch(sq.getType()){
               case Square.START: c = Color.green; break;
               case Square.EXIT: c = Color.red; break;
               case Square.WALL: c = Color.black; break;
               case Square.SPACE: c = Color.white;
               if(sq.isMarked())
                  c = Color.lightGray;
               if(sq.isOnPath())
                  c = Color.yellow;
               break;
            }
            g.setColor(c);
            g.fillRect(left+j*sqsize,top+i*sqsize,sqsize,sqsize);
         }
      }
      g.setColor(Color.black);
      for(int i=0; i<height; i++){         
         for(int j=0; j<width; j++){
            g.drawRect(left+j*sqsize,top+i*sqsize,sqsize,sqsize);
         }
      }
   }
}

