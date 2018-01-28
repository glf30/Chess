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
			posX = 3;
			posY = 7;
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
	
	
	
	public boolean validMovement(int x, int y){

		int distY = y - posY;
		int distX = Math.abs(x - posX); //Should be 0 most of the time, 1 for attacking
		boolean valid = false;
	
		//Check if position is at the start, then movement is allowed by two units
		
		if(distY == 2 && posY == 6)
		{
			this.posY = y;
			valid = true;
		}
		else if(distY == 1)
		{
			this.posY = y;
			valid = true;
		}
		
		
		
		
		
		//Else
		
		System.out.println("Move not allowed");
		return false;
	}

	
}
