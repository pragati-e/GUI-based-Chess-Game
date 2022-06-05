package pieces;

/*
 * Name: Pragati Makani
 * Id: 920821704
 * File Name: Bishop.java
 * 
 * Description: Basic principles governing Bishop movement on a chessboard are defined by the Move Function
 */

import java.util.ArrayList;
import chess.Cell;

public class Bishop extends Piece {
	public Bishop(String i,String p,int c) {
		setId(i);
		setPath(p);
		setColor(c);
	}
	
	//move function is defined
    //returns a list of all the Bishop's possible destinations
    //essential notion of bishop movement has been implemented on the board
	public ArrayList<Cell> move(Cell state[][],int x,int y) {
		//bishop has the ability to move diagonally in all four directions which is defined below
		possiblemoves.clear();
		int tempx=x+1,tempy=y-1;

		while(tempx<8&&tempy>=0) {
			if(state[tempx][tempy].getpiece()==null) {
				possiblemoves.add(state[tempx][tempy]);
			}
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
			else {
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
