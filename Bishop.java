package chess.app;




public class Bishop{
	
	char color;
	int code;
	int posX = 0;
	int posY = 0;
	String str = "";
	public Bishop(char color, int x, int y) {
		this.color = color;
		
		
		
		if(color == 'b') {
			 posX = x;
			 posY =	y;	 
			 code = 9;
		}
		
		if(color == 'w') {
			posX = x;
			posY = y;
			code = 3;
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
	
	
	
	public boolean validMovement(int fromX, int fromY, int toX, int toY){
		if(Math.abs(toX - fromX) == Math.abs(toY - fromY)) { 
			int difX = toX - fromX;
			int difY = toY - fromY;
			if(difX > 0) {
			
				if(difY > 0) { //+1 +1
				
					while(fromX != toX && fromY != toY){
						
						if((Board.board[fromX + 1][fromY + 1] == 12 || Board.board[fromX + 1][fromY + 1]== 13)
								|| (fromX+1 == toX && fromY +1 == toY)) {
						fromX++;
						fromY++;
					} else {
						System.out.println("Move not allowed");
						return false;
					}
						
					
					
					}
				
			} else if(difY < 0) { //+1 -1
				while(fromX != toX && fromY != toY){
						
						if((Board.board[fromX + 1][fromY -1] == 12 || Board.board[fromX + 1][fromY - 1]== 13)
								|| (fromX+1 == toX && fromY -1 == toY)) {
						fromX++;
						fromY--;
					} else {
						System.out.println("Move not allowed");
						return false;
					}
						
					
					
					}
				
				
				
				
			}
		} else if(difX < 0) { //-1 +1
			if(difY > 0) {
				while(fromX != toX && fromY != toY){
						
						if(Board.board[fromX - 1][fromY + 1] == 12 || Board.board[fromX - 1][fromY + 1]== 13
								|| (fromX-1 == toX && fromY +1 == toY)) {
						fromX--;
						fromY++;
					} else {
						System.out.println("Move not allowed");
						return false;
					}
						
					
					
					}
				
				
				
				
				
			} else if(difY<0) { //-1 -1
				while(fromX != toX && fromY != toY){
						
						if(Board.board[fromX - 1][fromY - 1] == 12 || Board.board[fromX - 1][fromY - 1]== 13
								|| (fromX-1 == toX && fromY -1 == toY)) {
						fromX--;
						fromY--;
					} else {
						System.out.println("Move not allowed");
						return false;
					}
						
					
					
				}
				
				
				
			} 
		}
			
			
			
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