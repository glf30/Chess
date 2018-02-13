package chess.app;


public class Piece{

	int posX = 0;
	int posY = 0;
	//int board[][];
	Queen Queen = new Queen('b');
	Pawn Pawn = new Pawn('w',2,2);
	Rook Rook = new Rook('b',0,0);
	Bishop Bishop = new Bishop('b', 3, 0);
	Knight Knight = new Knight('w',2,1);
	King King = new King('w');
	
	int currcode = -1;
	public boolean valid(int code, int fromX, int fromY, int toX, int toY) {
		
		if(code == 0 || code == 6) {
			return Queen.validMovement(fromX, fromY, toX,toY);
		} else if(code == 1 || code == 7){
			return King.validMovement(fromX,fromY,toX,toY);
		} else if(code == 2 || code == 8){
			return Rook.validMovement(fromX, fromY, toX,toY);
		} else if(code == 3 || code == 9){
			return Bishop.validMovement(fromX, fromY, toX,toY);
		} else if(code == 4 || code == 10){
			return Knight.validMovement(fromX, fromY, toX, toY);
		} else if(code == 5 || code ==  11) {
			
			/*if(code == 5) {
				Pawn.color = 'w';
			} else if (code == 11) {
				Pawn.color = 'b';
			}*/
			 
			return Pawn.validMovement(code, fromX, fromY, toX, toY);
		}
		
		
		
		
		
		return false;
	}
	
	
	
}