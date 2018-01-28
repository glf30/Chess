package chess.app;



public class Queen{
	
	char color;
	int code;
	int posX = 0;
	int posY = 0;
	String str = "";
	public Queen(char color) {
		this.color = color;
		
		
		
		if(color == 'b') {
			 posX = 3;
			 posY =	0;	 
			 code = 6;
		}
		
		if(color == 'w') {
			posX = 3;
			posY = 7;
			code = 0;
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

		if(x == posX) {
			posY = y;
			return true;
		} else if(y == posY) {
			posX = x;
			return true;
		} else if(Math.abs(x - posX) == Math.abs(y - posY)) { 
			
			/*if(x > posX) {
			if(y> posY) {
				if((x - posX) == (y - posY)) {
					return true;
				}
			} else if(y < posY) {
				if(Math.abs(x - )())
			}
		} else if(y > posY) {
			if(x>posX) {
				
			} else if(y>posY) {
				
			} */
			posX = x;
			posY = y;
			return true;
		}
		
		System.out.println("Move not allowed");
		return false;
	}
	
	
	/*public String strCode() {
		if(this.code == 0) {
			str = "wQ";
		} else if(this.code == 6) {
			str = "bQ";
		}
		return str;
	}*/
	
	
	
	
	
	
	
	
}
