package pieces;

/*
 * Name: Pragati Makani
 * Id: 920821704
 * File Name: Piece.java
 * 
 * Description: It's an abstract class that all the real parts are derived from. 
 * It specifies all of the components' shared functions.
 * The move() function is an abstract function that all inherited classes must override
 * It has a cloneable interface since a duplicate of the item is frequently required 
 */

import java.util.ArrayList;
import chess.Cell;

public abstract class Piece implements Cloneable{

	private int color;
	private String id=null;
	private String path;
	protected ArrayList<Cell> possiblemoves = new ArrayList<Cell>();  //Protected (access from child classes)
	public abstract ArrayList<Cell> move(Cell pos[][],int x,int y);  //Abstract Function. Must be overridden
	
    //setter for Id
	public void setId(String id) {
		this.id=id;
	}
	
	//setter for path
	public void setPath(String path) {
		this.path=path;
	}
	
	//setter for color
	public void setColor(int c) {
		this.color=c;
	}
	
	//getter for path
	public String getPath() {
		return path;
	}
	
	//getter for Id
	public String getId() {
		return id;
	}
	
	//getter for color
	public int getcolor() {
		return this.color;
	}
	
	//returning a copy of the object with the same variable values as the original but a different reference
	public Piece getcopy() throws CloneNotSupportedException {
		return (Piece) this.clone();
	}
}
