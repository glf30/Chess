package chess.app;




public class Queen implements PieceInterface{
	
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
	
	
	
	public boolean validMovement(int fromX, int fromY, int toX, int toY){
		//System.out.println("fromX: " + fromX + " toX: " + toX);
		//System.out.println("fromY: " + fromY + " toY: " + toY);
		
		
		int dif = 0;
		
		if(toX == fromX) {
			//fromY = toY;
			dif = toY - fromY;
			while(fromY != toY) {
			
				if(dif > 0) {
					if((Board.board[fromX][fromY+1] == 12 || Board.board[fromX][fromY+1]== 13) || fromY+1 == toY ) {
						fromY++;
					} else {
						//System.out.println("Move not allowed");
						return false;
					}
					
					
					
				} else {
					if((Board.board[fromX][fromY-1] == 12 || Board.board[fromX][fromY-1]== 13) || fromY-1 == toY ) {
						fromY--;
					} else {
						//System.out.println("Move not allowed");
						return false;
					}
					
					
					
				}
				
			}
			
			
			return true;
		} else if(toY == fromY) {
			//fromX = toX;
			dif = toX - fromX;
			while(fromX != toX) {
				
				if(dif > 0) {
					if((Board.board[fromX + 1][fromY] == 12 || Board.board[fromX + 1][fromY]== 13) || fromX +1 == toX) {
						fromX++;
					} else {
						//System.out.println("Move not allowed");
						return false;
					}
					
					
					
				} else {
					if((Board.board[fromX - 1][fromY] == 12 || Board.board[fromX- 1][fromY]== 13) || fromX -1 == toX) {
						fromX--;
					} else {
						//System.out.println("Move not allowed");
						return false;
					}
					
					
					
				}
				
			}
			
			
			
			return true;
		} else if(Math.abs(toX - fromX) == Math.abs(toY - fromY)) { 
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
						//System.out.println("Move not allowed");
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
						//System.out.println("Move not allowed");
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
						//System.out.println("Move not allowed");
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
						//System.out.println("Move not allowed");
						return false;
					}
						
					
					
				}
				
				
				
			} 
		}
			
			
			
			return true;
		}
		
		//System.out.println("Move not allowed");
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