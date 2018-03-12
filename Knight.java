package chess.app;




public class Knight{
	
	char color;
	int code = -1;
	int posX = 0;
	int posY = 0;
	
	public Knight(char color, int x, int y) {
		this.color = color;
		
		if(color == 'b') {
			 posX = x;
			 posY =	y;	 
			 code = 10;
		}
		else if(color == 'w') {
			posX = x;
			posY = y;
			code = 4;
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
		 * 
		 */
		
		
		
		
		int[][] validMovements =  new int[8][2];
		
		validMovements[0][0] = posX + 2;
		validMovements[0][1] = posY + 1;
		
		validMovements[1][0] = posX + 2;
		validMovements[1][1] = posY - 1;
		
		validMovements[2][0] = posX - 2;
		validMovements[2][1] = posY + 1;
		
		validMovements[3][0] = posX - 2;
		validMovements[3][1] = posY - 1;
		
		validMovements[4][0] = posX + 1;
		validMovements[4][1] = posY + 2;
		
		validMovements[5][0] = posX - 1;
		validMovements[5][1] = posY + 2;
		
		validMovements[6][0] = posX + 1;
		validMovements[6][1] = posY - 2;
		
		validMovements[7][0] = posX - 1;
		validMovements[7][1] = posY - 2;
		
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
		
		//System.out.println("Move not allowed");
		return valid;
	}

	
}