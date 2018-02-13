package chess.app;




public class King{
	
	char color;
	int code = -1;
	int posX = 0;
	int posY = 0;
	
	public King(char color) {
		this.color = color;
		
		if(color == 'b') {
			 posX = 4;
			 posY =	0;	 
			 code = 7;
		}
		else if(color == 'w') {
			posX = 4;
			posY = 7;
			code = 1;
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
	
	
	
	public boolean validMovement(int posX, int posY, int x, int y){
		
		/*	List formatted as
		 * 	[a][1]
		 * 	[b][2]
		 * 	...
		 * 	[h][8]
		 */
		
		if(posX == 4 && posY == 0){
			if(x == 6 && y == 0) {
				if(Board.board[7][0] == 8 &&(Board.board[6][0] == 12 || Board.board[6][0] == 13) 
						&& (Board.board[5][0] == 12 || Board.board[5][0] == 13)) {
					Board.board[7][0] = 13;
					Board.board[5][0] = 8;
					
					
					
					return true;
				} 
				
				
				
				
			} else if(x == 2 && y == 0) {
				if(Board.board[0][0] == 8 &&(Board.board[1][0] == 12 || Board.board[1][0] == 13) 
						&& (Board.board[2][0] == 12 || Board.board[2][0] == 13)
						&& (Board.board[3][0] == 12 || Board.board[3][0] == 13)) {
					
					Board.board[0][0] = 12;
					Board.board[3][0] = 8;
					
					
					
					
					return true;
				}
				
				
				
				
			}
			
			
		} else if(posX == 4 && posY == 7 && x == 6 && y == 7) {
			if(x == 6 && y == 7) {
				if(Board.board[7][7] == 2 &&(Board.board[6][7] == 12 || Board.board[6][7] == 13) 
						&& (Board.board[5][7] == 12 || Board.board[5][7] == 13)) {
					
					Board.board[7][7] = 12;
					Board.board[5][7] = 2;
					
					
					return true;
				} 
				
				
				
			} else if(x == 2 && y == 7) {
				if(Board.board[0][7] == 2 &&(Board.board[1][7] == 12 || Board.board[1][7] == 13) 
						&& (Board.board[2][7] == 12 || Board.board[2][7] == 13)
						&& (Board.board[3][7] == 12 || Board.board[3][7] == 13)) {
					
					Board.board[0][7] = 13;
					Board.board[3][7] = 2;
					
					
					
					
					return true;
				}
				
				
				
				
			}
			
			
		}
		
		
		int[][] validMovements =  new int[8][2];
		
		validMovements[0][0] = posX;
		validMovements[0][1] = posY + 1;
		
		validMovements[1][0] = posX;
		validMovements[1][1] = posY - 1;
		
		validMovements[2][0] = posX - 1;
		validMovements[2][1] = posY;
		
		validMovements[3][0] = posX + 1;
		validMovements[3][1] = posY;
		
		validMovements[4][0] = posX + 1;
		validMovements[4][1] = posY + 1;
		
		validMovements[5][0] = posX - 1;
		validMovements[5][1] = posY + 1;
		
		validMovements[6][0] = posX + 1;
		validMovements[6][1] = posY - 1;
		
		validMovements[7][0] = posX - 1;
		validMovements[7][1] = posY - 1;
		
		boolean valid = false;
		
		for(int c = 0; c < 8; c++)
		{
			if(validMovements[c][0] == x && validMovements[c][1] == y)
			{
				valid = true;
				return valid;
			}
		}
		
		//Else
		
		System.out.println("Illegal move, try again");
		return valid;
	}

	
}