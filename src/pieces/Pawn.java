package pieces;

/*
 * Name: Pragati Makani
 * Id: 920821704
 * File Name: Pawn.java
 * 
 * Description: This is the Pawn Class that was passed down from the piece package.
 */

import java.util.ArrayList;
import chess.Cell;

public class Pawn extends Piece{
	
	public Pawn(String i,String p,int c) {
		setId(i);
		setPath(p);
		setColor(c);
	}
	
	//move function overridden
	public ArrayList<Cell> move(Cell state[][],int x,int y) {
		//with the exception of the first opportunity, when it may move two steps, Pawn may only move one step
        //it can only move diagonally to attack a piece of the opposing color
        //to attract a piece, it cannot travel backward or ahead
		possiblemoves.clear();
		if(getcolor()==0) {
			if(x==0)
				return possiblemoves;

			if(state[x-1][y].getpiece()==null) {
				possiblemoves.add(state[x-1][y]);
				if(x==6) {
					if(state[4][y].getpiece()==null)
						possiblemoves.add(state[4][y]);
				}
			}

			if((y>0)&&(state[x-1][y-1].getpiece()!=null)&&(state[x-1][y-1].getpiece().getcolor()!=this.getcolor()))
				possiblemoves.add(state[x-1][y-1]);
			if((y<7)&&(state[x-1][y+1].getpiece()!=null)&&(state[x-1][y+1].getpiece().getcolor()!=this.getcolor()))
				possiblemoves.add(state[x-1][y+1]);
		}
        
		else {
			if(x==8)
				return possiblemoves;
			
            if(state[x+1][y].getpiece()==null) {
				possiblemoves.add(state[x+1][y]);
				if(x==1) {
					if(state[3][y].getpiece()==null)
						possiblemoves.add(state[3][y]);
				}
			}

			if((y>0)&&(state[x+1][y-1].getpiece()!=null)&&(state[x+1][y-1].getpiece().getcolor()!=this.getcolor()))
				possiblemoves.add(state[x+1][y-1]);
			if((y<7)&&(state[x+1][y+1].getpiece()!=null)&&(state[x+1][y+1].getpiece().getcolor()!=this.getcolor()))
				possiblemoves.add(state[x+1][y+1]);
		}
		return possiblemoves;
	}
}
