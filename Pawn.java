package chess.app;




public class Pawn{
	
	char color;
	int code = -1;
	int posX = 0;
	int posY = 0;
	
	public Pawn(char color, int x, int y) {
		this.color = color;
		
		if(color == 'b') {
			 posX = x;
			 posY =	y;	 
			 code = 11;
		}
		else if(color == 'w') {
			posX = x;
			posY = y;
			code = 5;
		}
		
		
		
	}
	
	public int getCode() {
		
		return this.code;
	}

	
	public int getPosX() {
		
		return this.posX;
	}
	
    public int getPosY() {
		
		return this.posY;
	}
	
	
	
	//public boolean validMovement(int x, int y){
	public boolean validMovement(int code, int fromX, int fromY, int toX, int toY) {	

		int distY = toY - fromY;
		int distX = Math.abs(toX - fromX); //Should be 0 most of the time, 1 for attacking
		//boolean valid = false;
	
		//Check if position is at the start, then movement is allowed by two units
		
		//System.out.println("FROM " + fromY);
		//System.out.println("To X " + toX);
		//System.out.println("To Y " + toY);
		//System.out.println("Occupancy Code is " + Board.board[toX][toY]);
		//CHANGE FOR BLACK AND WHITE
		if(code == 5) {
		
		
			if(distY == -2 && fromY == 6 && distX == 0)
			{
				//this.posY = y;
				
				return true;
			}
			else if(distY == -1 && distX == 1 && (Board.board[toX][toY] != 12 && Board.board[toX][toY] !=13))
			{
				//this.posY = y;
				//System.out.println("I moved diagonal");
				return true;
			}
			else if(distY == -1 && distX == 0)
			{
				//this.posY = y;
			
				return true;
			}
			else if(Board.piece == 11 && Board.lastDistX == 0 && Board.lastDistY == 2 && fromY == 3)
			{
				//ERASE PAWN CODE HERE
				System.out.println("En Passant made here");
				return true;
			}
		
		} else if(code == 11) {
			
			if(distY == 2 && fromY == 1 && distX == 0)
			{
				//this.posY = y;
				
				return true;
			}
			else if(distY == 1 && distX == 1 && (Board.board[toX][toY] != 12 && Board.board[toX][toY] != 13))
			{
				//this.posY = y;
				//System.out.println("I moved diagonal");
				return true;
			}
			else if(distY == 1 && distX == 0)
			{
				//this.posY = y;
			
				return true;
			}
			else if(Board.piece == 5 && Board.lastDistX == 0 && Board.lastDistY == 2 && fromY == 4)
			{
				//ERASE PAWN CODE HERE
				System.out.println("En Passant made here");
				return true;
			}
			
			
			
		}
		
		
		
		//Else
		
		//System.out.println("Illegal Move, Try Again");
		return false;
	}

	
}