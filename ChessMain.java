package chess.app;

import java.util.ArrayList;
import java.util.Scanner;



public class ChessMain{
	
	/*
	 WHITE
	0 - Queen
	1 - King
	2 - Rook
	3 - Bishop
	4 - Knight
	5 - Pawn

	BLACK
	6 - Queen
	7 - King
	8 - Rook
	9 - Bishop
	10 - Knight
	11 - Pawn 
	  
	  
	 */
	
	
public static void main(String[] args) {
		
	int rank = 0;
	int x = 0;
	
	Pawn wPawn;
	Pawn bPawn;
	
	Queen wQueen;
	Queen bQueen;
	
	King wKing;
	King bKing;
	
	Rook wRook;
	Rook bRook;
	
	Bishop wBishop;
	Bishop bBishop;
	
	Knight wKnight;
	Knight bKnight;
	
	//String alt = "  ";
	//int board[][] = new int[8][8];
	while(rank <8) {
		x = 0;
		while(x<8) {
			if(rank == 1) {
				bPawn = new Pawn('b', x, 1);
				Board.board[x][rank] = bPawn.code;
				x++; 
				continue;
				//	board[x][rank] = "bp";
			}
			
			if(rank == 6) {
				 wPawn = new Pawn('w', x, 6);
				Board.board[x][rank] = wPawn.code;
				x++;
				continue; 
				//board[x][rank] = "wp";
			}
		
			Board.board[x][rank] = 12;
			if(rank%2 == 0 && x %2 != 0) {
				Board.board[x][rank] = 13;
			} else if(rank%2 != 0 &&  x%2 == 0){
				Board.board[x][rank] = 13;
			}
			
			
			//board[x][rank] = alt;
		
			
			x++;
		
		}
		rank++;
		
		
	}
	//set up board
	Piece currPiece = new Piece();
	
	wQueen = new Queen('w');
	int posx = wQueen.getPosX();
	int posy = wQueen.getPosY();
	Board.board[posx][posy] = wQueen.getCode();
	
	bQueen = new Queen('b');
	posx = bQueen.getPosX();
	posy = bQueen.getPosY();
	Board.board[posx][posy] = bQueen.getCode();
	
	wKing = new King('w');
	posx = wKing.getPosX();
	posy = wKing.getPosY();
	Board.board[posx][posy] = wKing.getCode();
	
	bKing = new King('b');
	posx = bKing.getPosX();
	posy = bKing.getPosY();
	Board.board[posx][posy] = bKing.getCode();
	
	wRook = new Rook('w',0, 7);
	posx = wRook.getPosX();
	posy = wRook.getPosY();
	Board.board[posx][posy] = wRook.getCode();
	
	wRook = new Rook('w',7, 7);
	posx = wRook.getPosX();
	posy = wRook.getPosY();
	Board.board[posx][posy] = wRook.getCode();
	
	bRook = new Rook('b',0, 0);
	posx = bRook.getPosX();
	posy = bRook.getPosY();
	Board.board[posx][posy] = bRook.getCode();
	
	bRook = new Rook('b',7, 0);
	posx = bRook.getPosX();
	posy = bRook.getPosY();
	Board.board[posx][posy] = bRook.getCode();
	
	
	wKnight = new Knight('w',1,7);
	posx = wKnight.getPosX();
	posy = wKnight.getPosY();
	Board.board[posx][posy] = wKnight.getCode();
	
	wKnight = new Knight('w',6,7);
	posx = wKnight.getPosX();
	posy = wKnight.getPosY();
	Board.board[posx][posy] = wKnight.getCode();
	
	
	bKnight = new Knight('b',1,0);
	posx = bKnight.getPosX();
	posy = bKnight.getPosY();
	Board.board[posx][posy] = bKnight.getCode();
	
	bKnight = new Knight('b',6,0);
	posx = bKnight.getPosX();
	posy = bKnight.getPosY();
	Board.board[posx][posy] = bKnight.getCode();
	
	
	wBishop = new Bishop('w',2, 7);
	posx = wBishop.getPosX();
	posy = wBishop.getPosY();
	Board.board[posx][posy] = wBishop.getCode();
	
	wBishop = new Bishop('w',5, 7);
	posx = wBishop.getPosX();
	posy = wBishop.getPosY();
	Board.board[posx][posy] = wBishop.getCode();
	
	bBishop = new Bishop('b',2, 0);
	posx = bBishop.getPosX();
	posy = bBishop.getPosY();
	Board.board[posx][posy] = bBishop.getCode();
	
	bBishop = new Bishop('b',5, 0);
	posx = bBishop.getPosX();
	posy = bBishop.getPosY();
	Board.board[posx][posy] = bBishop.getCode();
	
	
	
	
	/*posx = wPawn.getPosX();
	posy = wPawn.getPosY();
	board[posx][posy] = wPawn.getCode();
	
	wPawn = new Pawn('w', 5, 6);
	posx = wPawn.getPosX();
	posy = wPawn.getPosY();
	board[posx][posy] = wPawn.getCode();*/
	
	
	printBoard(Board.board);	
	
	boolean valid = false;
	Scanner sr;

	String input = "";
	
	char chr = '0';
	
	int fromx = 0;
	int fromy = 0;
	char chr2 = '0';
	int tox = 0;
	int toy = 0;
	int last = 0;
	char isPromo = ' ';
	
	boolean isDraw = false;
	
	boolean inCheckB = false;
	boolean inCheckW = false;
	
	while(!(input.equals("resign"))) {
		
		
			valid = false;
			
			while(valid == false) {
				System.out.println();
				System.out.print("White's Move: ");
				sr = new Scanner(System.in);
				//exp string: "e5 e6"
				input = sr.nextLine();
				System.out.println(input);
				
				if(isDraw) {
					if(input.equals("draw")) {
						System.exit(0);
					} else {
						isDraw = false;
					}
				} 
				
				if(input.toLowerCase().equals("resign")) {
					System.out.println("Black wins");
					System.exit(0);
				}
				chr = input.charAt(0);
				
				if(input.length() >= 7 && input.substring(6).equals("draw?")) {
					isDraw = true; 
				}
				
				fromx = letterToIndex(chr);
				fromy = numberToIndex(Character.getNumericValue(input.charAt(1))) ;
				
				
				//last = board[fromx][fromy];
				last = 12;
				if(fromy%2 == 0 && fromx %2 != 0) {
					last = 13;
				} else if(fromy%2 != 0 &&  fromx%2 == 0){
					last = 13;
				}
				//last = board[fromx][fromy];
				
				chr2 = input.charAt(3);
				tox = letterToIndex(chr2);
				toy = numberToIndex(Character.getNumericValue(input.charAt(4)));
				
				if(input.length() == 7) {
					isPromo = input.charAt(6);
				}
				//getcurrent piece
				//valid = valid(wQueen.validMovement(tox, toy));
				
				currPiece.posX = fromx;
				currPiece.posY = fromy;
				if(Board.board[fromx][fromy] != 0 && Board.board[fromx][fromy] != 1 && Board.board[fromx][fromy] != 2 &&
						Board.board[fromx][fromy] != 3 && Board.board[fromx][fromy] != 4 && Board.board[fromx][fromy] != 5) {
					System.out.println("Illegal move, try again");
					continue;
					
				}
				//valid = valid(wQueen.validMovement(tox, toy));
				if(Board.board[tox][toy] != 12 && Board.board[tox][toy] != 13 && Board.board[tox][toy] != 6 && Board.board[tox][toy] != 7 &&
						Board.board[tox][toy] != 8 && Board.board[tox][toy] != 9 && Board.board[tox][toy] != 10 && Board.board[tox][toy] != 11) {
					System.out.println("Illegal move, try again");
					continue;
				}
				
				currPiece.currcode = Board.board[fromx][fromy];
				
				valid = valid(currPiece.valid(Board.board[fromx][fromy], fromx, fromy, tox, toy));
				if(valid == false) {
					System.out.println("Illegal move, try again");
				}
				
				if(Check('b',Board.board) && inCheckW == false) {
					valid = false;
					System.out.println("Illegal move, try again");
				}
				
			}
			if(Board.board[fromx][fromy] == 5) {
				//is White Pawn advancing to end of board
				
				if(toy == 0) { //black 7
					currPiece.currcode = 0;	
					if(isPromo != ' ') {
						if(isPromo == 'R') {
							currPiece.currcode = 2;
						} else if(isPromo == 'B') {
							currPiece.currcode = 3;
						} else if(isPromo == 'N') {
							currPiece.currcode = 4;
						}
					}
				}
				
				
				
				
			}
			
			isPromo = ' ';
			
			if(Board.board[tox][toy] == 7) {
				System.out.println("White wins");
				System.exit(0);
			}
			
			
			Board.board[fromx][fromy] = last;
			last = Board.board[tox][toy];		
			Board.board[tox][toy]= currPiece.currcode;
			
			
			Board.lastX = tox;
			Board.lastY = toy;
			Board.piece = currPiece.currcode;
			Board.lastDistY = toy - fromy;
			Board.lastDistX = tox - fromx;

			
			printBoard(Board.board);
		
			if(Check('w',Board.board)) {
				System.out.println("Check");
				inCheckB = true;
				if(isCheckmate('b')) {
					System.out.println("Checkmate");
					System.out.println("White wins");
					System.exit(0);
				}
			} else {
				inCheckB = false;
			}
			
		
			valid = false;
			
			while(valid == false) {
				System.out.println();
				System.out.print("Black's Move: ");
				sr = new Scanner(System.in);
				
				//exp string: "e5 e6"
				input = sr.nextLine();
				
				if(isDraw) {
					if(input.equals("draw")) {
						System.exit(0);
					} else {
						isDraw = false;
					}
				} 
				
				System.out.println(input);
				if(input.toLowerCase().equals("resign")) {
					System.out.println("White wins");
					System.exit(0);
				}
				
				chr = input.charAt(0);
				if(input.length() >= 7 && input.substring(6).equals("draw?")) {
					isDraw = true;
				}
				fromx = letterToIndex(chr);
				fromy = numberToIndex(Character.getNumericValue(input.charAt(1))) ;
				
				
				//last = Board.board[fromx][fromy];
				last = 12;
				if(fromy%2 == 0 && fromx %2 != 0) {
					last = 13;
				} else if(fromy%2 != 0 &&  fromx%2 == 0){
					last = 13;
				}
				//last = Board.board[fromx][fromy];
				
				chr2 = input.charAt(3);
				tox = letterToIndex(chr2);
				toy = numberToIndex(Character.getNumericValue(input.charAt(4)));
				
				//getcurrent piece
				//valid = valid(wQueen.validMovement(tox, toy));
				
				currPiece.posX = fromx;
				currPiece.posY = fromy;
				if(Board.board[fromx][fromy] != 6 && Board.board[fromx][fromy] != 7 && Board.board[fromx][fromy] != 8 &&
						Board.board[fromx][fromy] != 9 && Board.board[fromx][fromy] != 10 && Board.board[fromx][fromy] != 11) {
					System.out.println("Illegal move, try again");
					continue;
					
				}
				
				if(Board.board[tox][toy] != 12 && Board.board[tox][toy] != 13 && Board.board[tox][toy] != 0 && Board.board[tox][toy] != 1 &&
						Board.board[tox][toy] != 2 && Board.board[tox][toy] != 3 && Board.board[tox][toy] != 4 && Board.board[tox][toy] != 5) {
					System.out.println("Illegal move, try again");
					continue;
				}
				
				
				//valid = valid(wQueen.validMovement(tox, toy));
				currPiece.currcode = Board.board[fromx][fromy];
				valid = valid(currPiece.valid(Board.board[fromx][fromy], fromx, fromy, tox, toy));
				
				if(valid == false) {
					System.out.println("Illegal move, try again");
				}
				
				if(Check('w',Board.board) && inCheckB == false) {
					valid = false;
					System.out.println("Illegal move, try again");
				}
				
			}	
			if(Board.board[fromx][fromy] == 11) {
				//is Black Pawn advancing to end of board
				
				if(toy == 7) {
					currPiece.currcode = 6;	
					if(isPromo != ' ') {
						if(isPromo == 'R') {
							currPiece.currcode = 8;
						} else if(isPromo == 'B') {
							currPiece.currcode = 9;
						} else if(isPromo == 'N') {
							currPiece.currcode = 10;
						}
					}
				}
				
				
				
				
			}
			
			isPromo = ' ';
			
			if(Board.board[tox][toy] == 7) {
				System.out.println("Black wins");
				System.exit(0);
			}
			
			
			
			Board.board[fromx][fromy] = last;
			last = Board.board[tox][toy];		
			Board.board[tox][toy]= currPiece.currcode;
			
			Board.lastX = tox;
			Board.lastY = toy;
			Board.piece = currPiece.currcode;
			Board.lastDistY = toy - fromy;
			Board.lastDistX = tox - fromx;
			
			printBoard(Board.board);
			if(Check('b',Board.board)) {
				System.out.println("Check");
				inCheckW = true;
				if(isCheckmate('w')) {
					System.out.println("Checkmate");
					System.out.println("Black wins");
					System.exit(0);
				}
			} else {
				inCheckW = false;
			}
		
			
			
			
	}
	

		
	}


	public static int getCode(int[][] board, int x, int y) {
		return Board.board[x][y];
		
	}


	public static boolean valid(boolean v) {
		
		
		
		
		return v;
	}

	public static int letterToIndex(char chr) {
		int x = 0;
		if(chr == 'a') {
			x = 0;
		} else if(chr == 'b' ) {
			x = 1;
		} else if(chr == 'c' ) {
			x = 2;
		} else if(chr == 'd' ) {
			x = 3;
		} else if(chr == 'e' ) {
			x = 4;
		} else if(chr == 'f' ) {
			x = 5;
		} else if(chr == 'g' ) {
			x = 6;
		} else if(chr == 'h' ) {
			x = 7;
		}
	
	
	
		return x;
	}

	public static int numberToIndex(int c) {
		int x = 0;
		if(c == 8) {
			x = 0;
		} else if(c == 7 ) {
			x = 1;
		} else if(c == 6 ) {
			x = 2;
		} else if(c == 5 ) {
			x = 3;
		} else if(c == 4 ) {
			x = 4;
		} else if(c == 3 ) {
			x = 5;
		} else if(c == 2 ) {
			x = 6;
		} else if(c == 1 ) {
			x = 7;
		}
	
	
	
		return x;
	}
	
	public static String codeToString(int code) {
		String strcode = "";
		/*
		 WHITE
		0 - Queen
		1 - King
		2 - Rook
		3 - Bishop
		4 - Knight
		5 - Pawn

		BLACK
		6 - Queen
		7 - King
		8 - Rook
		9 - Bishop
		10 - Knight
		11 - Pawn 
		  
		  
		 */
		if(code == 0) {
			strcode = "wQ";
		} else if(code == 1) {
			strcode = "wK";
		} else if(code == 2) {
			strcode = "wR";
		} else if(code == 3) {
			strcode = "wB";
		} else if(code == 4) {
			strcode = "wN";
		} else if(code == 5) {
			strcode = "wp";
		} else if(code == 6) {
			strcode = "bQ";
		} else if(code == 7) {
			strcode = "bK";
		} else if(code == 8) {
			strcode = "bR";
		} else if(code == 9) {
			strcode = "bB";
		} else if(code == 10) {
			strcode = "bN";
		} else if(code == 11) {
			strcode = "bp";
		} else if (code == 12) {
			strcode = "  ";
		} else if (code == 13) {
			strcode = "##";
		}
		
		return strcode;
	}
	
	public static void printBoard(int board[][]){
		int r = 8;
		for(int y = 0; y<8; y++) {
			for(int x = 0; x<8; x++) {
				System.out.print(codeToString(board[x][y]));
				System.out.print(" ");
				
				
			}
			
			System.out.print(r);
			r--;
			System.out.print("\n");
			
		}
		System.out.println("a  b  c  d  e  f  g  h");
	}
	
	public static void initBoard(int board[][]) {
		
		
		
		
	}
	
	
	
	public static boolean isCheckmate(char color) {
		ArrayList<int[]> whitePieceList = getAllWhitePieces();
		ArrayList<int[]> blackPieceList = getAllBlackPieces();
		int boardT[][] = new int[8][8];
		int tx = 0;
		int ty = 0;
		while(ty < 8) {
			while (tx < 8) {
				boardT[tx][ty] = Board.board[tx][ty];
				tx++;
			}
			tx = 0;
			ty++;
		}
		
		int w = 0;
		int b = 0;
		int fromX = 0;
		int fromY = 0;
		int toX = 0;
		int toY = 0;
		int currPiece = 0;
		int last = 0;
		int x = 0;
		int y = 0;
		Piece tempPiece = new Piece();
		if(color == 'b') {
			
		while(b < blackPieceList.size()) {	
			while(y < 8) {
				while(x < 8) {
					
					
					fromX =blackPieceList.get(b)[1];
					fromY = blackPieceList.get(b)[2];
					
					toX = x;
					toY = y;
					
					currPiece = blackPieceList.get(b)[0];
					
					
					
					if((Board.board[toX][toY] < 6 || Board.board[toX][toY] >= 12) &&
							tempPiece.valid(Board.board[fromX][fromY], fromX, fromY, toX, toY)) {
						last = 12;
						if(fromY%2 == 0 && fromX %2 != 0) {
							last = 13;
						} else if(fromY%2 != 0 &&  fromX%2 == 0){
							last = 13;
						}
						Board.board[fromX][fromY] = last;
						last = Board.board[toX][toY];		
						Board.board[toX][toY]= currPiece;
						
					}
				
					if(!Check('w',Board.board)) {
						System.out.println("BLACK NOT IN CHECKMATE");
						
						tx = 0;
						ty = 0;
						while(ty < 8) {
							while (tx < 8) {
								Board.board[tx][ty] = boardT[tx][ty];
								tx++;
							}
							tx = 0;
							ty++;
						}
						
						return false;
					}
					
					tx = 0;
					ty = 0;
					while(ty < 8) {
						while (tx < 8) {
							Board.board[tx][ty] = boardT[tx][ty];
							tx++;
						}
						tx = 0;
						ty++;
					}
					
					
					
					x++;
					
					
				
				}
				x = 0;
				y++;
				
			}
			y = 0;
			b++;
			
		}
			
		    return true;
		}
		w = 0;
		b = 0;
		fromX = 0;
		fromY = 0;
		toX = 0;
		toY = 0;
		currPiece = 0;
		last = 0;
		x = 0;
		y = 0;
		
		if(color == 'w') {
		while(w < whitePieceList.size())	{
			while(y < 8) {
				while(x < 8) {
					
					
					fromX = whitePieceList.get(w)[1];
					fromY = whitePieceList.get(w)[2];
					toX = x;
					toY = y;
					currPiece = whitePieceList.get(w)[0];
					
					
					
					
					if(Board.board[toX][toY] >= 6 && 
							tempPiece.valid(Board.board[fromX][fromY], fromX, fromY, toX, toY)) {
						last = 12;
						if(fromY%2 == 0 && fromX %2 != 0) {
							last = 13;
						} else if(fromY%2 != 0 &&  fromX%2 == 0){
							last = 13;
						}
						Board.board[fromX][fromY] = last;
						last = Board.board[toX][toY];		
						Board.board[toX][toY]= currPiece;
						//printBoard(Board.board);
						
						
					}
					if(!Check('b',Board.board)) {
						System.out.println("WHITE NOT IN CHECKMATE");
						//printBoard(Board.board);
						tx = 0;
						ty = 0;
						while(ty < 8) {
							while (tx < 8) {
								Board.board[tx][ty] = boardT[tx][ty];
								tx++;
							}
							tx = 0;
							ty++;
						}
						return false;
					}
					tx = 0;
					ty = 0;
					while(ty < 8) {
						while (tx < 8) {
							Board.board[tx][ty] = boardT[tx][ty];
							tx++;
						}
						tx = 0;
						ty++;
					}
					
					
					x++;
					
				}
				x = 0;
				y++;
			}
			y = 0;
			w++;
		}
			return true;
		}
		
		
		return false;
	}
	
	public static ArrayList<int[]> getAllWhitePieces()
	{
		ArrayList<int[]> list = new ArrayList<int[]>();
		for(int x = 0; x < 8; x++)
		{
			for(int y = 0; y < 8; y++)
			{
				if(Board.board[x][y]>=0 && Board.board[x][y] <= 5)
				{
					int[] toAdd = new int[]{Board.board[x][y],x,y};	
					//System.out.println("Added "+Board.board[x][y]+" "+x+" "+y);
					list.add(toAdd);
				}
			}
		}
			return list;
	}
	
	public static ArrayList<int[]> getAllBlackPieces()
	{
		ArrayList<int[]> list = new ArrayList<int[]>();
		for(int x = 0; x < 8; x++)
		{
			for(int y = 0; y < 8; y++)
			{
				if(Board.board[x][y]>=6 && Board.board[x][y] <= 11)
				{
					int[] toAdd = new int[]{Board.board[x][y],x,y};	
					list.add(toAdd);
				}
			}
		}
			return list;
	}
	
	public static boolean Check(char color, int board[][]) {
		int toX = 0;
		int toY = 0;
		
		Piece tempPiece = new Piece();
		//go through board and find king
		//go through board and test valid movement for each piece to king
		if(color == 'w') {
			
			int r = 8;
			for(int y = 0; y<8; y++) {
				for(int x = 0; x<8; x++) {
					if(board[x][y] == 7) {
						toX = x;
						toY = y;
					}
					
					
				}

				r--;

			}
			
			r = 8;
			for(int y = 0; y<8; y++) {
				for(int x = 0; x<8; x++) {
					if(board[x][y] < 6) {
						if(tempPiece.valid(board[x][y], x, y, toX, toY)) {
							return true;
						}
						
					}
					
					
				}

				r--;

			}
			
			
			
			
		} else if(color == 'b') {
			int r = 8;
			for(int y = 0; y<8; y++) {
				for(int x = 0; x<8; x++) {
					if(board[x][y] == 1) {
						toX = x;
						toY = y;
					}
					
					
				}

				r--;

			}
			
			r = 8;
			for(int y = 0; y<8; y++) {
				for(int x = 0; x<8; x++) {
					if(board[x][y] > 5 && board[x][y] < 12) {
						if(tempPiece.valid(board[x][y], x, y, toX, toY)) {
							return true;
						}
						
					}
					
					
				}

				r--;

			}
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		return false;
	}
	
	
	
	
}


/*
bR bN bB bQ bK bB bN bR 8
bp bp bp bp bp bp bp bp 7
   ##    ##    ##    ## 6
##    ##    ##    ##    5
   ##    ##    ##    ## 4
##    ##    ##    ##    3
wp wp wp wp wp wp wp wp 2
wR wN wB wQ wK wB wN wR 1
 a  b  c  d  e  f  g  h

White's move: 


*/

/*
bR bN bB bQ bK bB bN bR 8 0
bp bp bp bp bp bp bp bp 7 1
   ##    ##    ##    ## 6 2
##    ##    ##    ##    5 3
   ##    ##    ##    ## 4 4
##    ##    ##    ##    3 5
wp wp wp wp wp wp wp wp 2 6
wR wN wB wQ wK wB wN wR 1 7
 0  1  2  3  4  5  6  7

White's move:  
 
 
 
 
   ##    ##    ##    ## 8
##    ##    ##    ##    7
   ##    ##    ##    ## 6
##    ##    ##    ##    5
   ##    ##    ##    ## 4
##    ##    ##    ##    3
   ##    ##    ##    ## 2
##    ##    ##    ##    1

WHITE
0 - Queen
1 - King
2 - Rook
3 - Bishop
4 - Knight
5 - Pawn

BLACK
6 - Queen
7 - King
8 - Rook
9 - Bishop
10 - Knight
11 - Pawn

*/
