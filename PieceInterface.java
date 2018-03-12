package chess.app;


public interface PieceInterface {
	
	
    public int getCode();
	
	public int getPosX();
    public int getPosY();
	
	public boolean validMovement(int fromX, int fromY, int toX, int toY);
	
	
	
}