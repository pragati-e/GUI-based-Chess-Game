package chess;

/*
 * Name: Pragati Makani
 * Id: 920821704
 * File Name: Cell.java
 * 
 * Description: The Board is made of up of approximately 64 cells.   
 * It's our user interface's token class.
 */

import pieces.*;
import java.awt.*;
import javax.swing.*;

public class Cell extends JPanel implements Cloneable{
	private static final long serialVersionUID = 1L;
	private boolean ispossibledestination;
	private JLabel content;
	private Piece piece;                           
	private boolean isSelected=false;
	private boolean ischeck=false;
	public int x,y; 

	public Cell(int x,int y,Piece p) {		
		this.x=x;
		this.y=y;
		setLayout(new BorderLayout());
	
		if((x+y)%2==0) {
			setBackground(new Color(113,198,113));
		}
	    setBackground(Color.white);
	 
		if(p!=null) {
			setPiece(p);
		}
	}
	
	//accepting a cell as a parameter 
	//generating a new cell with identical content but a distinct addres
	public Cell(Cell cell) throws CloneNotSupportedException {
		this.x=cell.x;
		this.y=cell.y;
		setLayout(new BorderLayout());
		if((x+y)%2==0) {
			setBackground(new Color(113,198,113));
		}
        setBackground(Color.white);
		if(cell.getpiece()!=null) {
			setPiece(cell.getpiece().getcopy());
		}
		piece=null;
	}
	
	//expanding a cell using a bit of code
	public void setPiece(Piece p) {
		piece=p;
		ImageIcon img=new javax.swing.ImageIcon(this.getClass().getResource(p.getPath()));
		content=new JLabel(img);
		this.add(content);
	}

	//removing a component from a cell
	public void removePiece() {
		if (piece instanceof King) {
			piece=null;
			this.remove(content);
		}
		else {
			piece=null;
			this.remove(content);
		}
	}
	
	//acquiring access to a component of a predefined cell
	public Piece getpiece() {
		return this.piece;
	}

	//labeling a cell as targeted
	public void select() {
		this.setBorder(BorderFactory.createLineBorder(Color.red,6));
		this.isSelected=true;
	}

	//returning the targeted cell
	public boolean isselected() {
		return this.isSelected;
	}

	//disabling a cell
	public void deselect() {
		this.setBorder(null);
		this.isSelected=false;
	}

	//flagging a cell as a potentially eligible move
	public void setpossibledestination() {
		this.setBorder(BorderFactory.createLineBorder(Color.blue,4));
		this.ispossibledestination=true;
	}

	//deleteing a cell from the eligible moves list
	public void removepossibledestination() {
		this.setBorder(null);
		this.ispossibledestination=false;
	}

	//checking whether the cell may be used as a destination
	public boolean ispossibledestination() {
		return this.ispossibledestination;
	}

	public void setcheck() {
		this.setBackground(Color.RED);
		this.ischeck=true;
	}

	//assigning the targeted cell as "King"  
	public void removecheck() {
		this.setBorder(null);
		if((x+y)%2==0) {
			setBackground(new Color(113,198,113)); 
		}
		setBackground(Color.white);
		this.ischeck=false;
	}

	//viewing the current cell
	public boolean ischeck() {
		return ischeck;
	}
}