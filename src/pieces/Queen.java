package pieces;

/*
 * Name: Pragati Makani
 * Id: 920821704
 * File Name: Queen.java
 * 
 * Description: Inherited from the abstract Piece class
 */

import java.util.ArrayList;
import chess.Cell;

public class Queen extends Piece {
	public Queen(String i,String p,int c) {
		setId(i);
		setPath(p);
		setColor(c);
	}
	
	//defined move function defined
	public ArrayList<Cell> move(Cell state[][],int x,int y) {
        //queen has the most possible movements 
        //the queen can take any number of steps in any of the eight directions 
        //a combination of Rook and Bishop movements are conceivable for the queen
		possiblemoves.clear();
	    //checking vertical movement possibilities
		int tempx=x-1;
		while(tempx>=0) {
			if(state[tempx][y].getpiece()==null)
				possiblemoves.add(state[tempx][y]);
			else if(state[tempx][y].getpiece().getcolor()==this.getcolor())
				break;
			else {
				possiblemoves.add(state[tempx][y]);
				break;
			}
			tempx--;
		}
		
		tempx=x+1;
		while(tempx<8) {
			if(state[tempx][y].getpiece()==null)
				possiblemoves.add(state[tempx][y]);
			else if(state[tempx][y].getpiece().getcolor()==this.getcolor())
				break;
			else {
				possiblemoves.add(state[tempx][y]);
				break;
			}
			tempx++;
		}
		
	    //checking horizontal movement possibilities
		int tempy=y-1;
		while(tempy>=0) {
			if(state[x][tempy].getpiece()==null)
				possiblemoves.add(state[x][tempy]);
			else if(state[x][tempy].getpiece().getcolor()==this.getcolor())
				break;
			else {
				possiblemoves.add(state[x][tempy]);
				break;
			}
			tempy--;
		}

		tempy=y+1;
		while(tempy<8) {
			if(state[x][tempy].getpiece()==null)
				possiblemoves.add(state[x][tempy]);
			else if(state[x][tempy].getpiece().getcolor()==this.getcolor())
				break;
			else {
				possiblemoves.add(state[x][tempy]);
				break;
			}
			tempy++;
		}
		
		//checking for possible moves in diagonal direction
		tempx=x+1;tempy=y-1;
		while(tempx<8&&tempy>=0) {
			if(state[tempx][tempy].getpiece()==null)
				possiblemoves.add(state[tempx][tempy]);
			else if(state[tempx][tempy].getpiece().getcolor()==this.getcolor())
				break;
			else {
				possiblemoves.add(state[tempx][tempy]);
				break;
			}
			tempx++;
			tempy--;
		}

		tempx=x-1;tempy=y+1;
		while(tempx>=0&&tempy<8) {
			if(state[tempx][tempy].getpiece()==null)
				possiblemoves.add(state[tempx][tempy]);
			else if(state[tempx][tempy].getpiece().getcolor()==this.getcolor())
				break;
			else
			{
				possiblemoves.add(state[tempx][tempy]);
				break;
			}
			tempx--;
			tempy++;
		}

		tempx=x-1;tempy=y-1;
		while(tempx>=0&&tempy>=0) {
			if(state[tempx][tempy].getpiece()==null)
				possiblemoves.add(state[tempx][tempy]);
			else if(state[tempx][tempy].getpiece().getcolor()==this.getcolor())
				break;
			else {
				possiblemoves.add(state[tempx][tempy]);
				break;
			}
			tempx--;
			tempy--;
		}

		tempx=x+1;tempy=y+1;
		while(tempx<8&&tempy<8) {
			if(state[tempx][tempy].getpiece()==null)
				possiblemoves.add(state[tempx][tempy]);
			else if(state[tempx][tempy].getpiece().getcolor()==this.getcolor())
				break;
			else {
				possiblemoves.add(state[tempx][tempy]);
				break;
			}
			tempx++;
			tempy++;
		}
		return possiblemoves;
	}
}