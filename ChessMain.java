package chess.app;

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
	int board[][] = new int[8][8];
	while(rank <8) {
		x = 0;
		while(x<8) {
			if(rank == 1) {
				bPawn = new Pawn('b', x, 1);
				board[x][rank] = bPawn.code;
				x++; 
				continue; 
				//	board[x][rank] = "bp";
			}
			
			if(rank == 6) {
				wPawn = new Pawn('w', x, 6);
				board[x][rank] = wPawn.code;
				x++;
				continue; 
				//board[x][rank] = "wp";
			}
		
			board[x][rank] = 12;
			if(rank%2 == 0 && x %2 != 0) {
				board[x][rank] = 13;
			} else if(rank%2 != 0 &&  x%2 == 0){
				board[x][rank] = 13;
			}
			
			
			//board[x][rank] = alt;
		
			
			x++;
		
		}
		rank++;
		
		
	}
	//set up board
	Piece currPiece = new Piece();
	
	wQueen = new Queen('w',board);
	int posx = wQueen.getPosX();
	int posy = wQueen.getPosY();
	board[posx][posy] = wQueen.getCode();
	
	bQueen = new Queen('b',board);
	posx = bQueen.getPosX();
	posy = bQueen.getPosY();
	board[posx][posy] = bQueen.getCode();
	
	wKing = new King('w');
	posx = wKing.getPosX();
	posy = wKing.getPosY();
	board[posx][posy] = wKing.getCode();
	
	bKing = new King('b');
	posx = bKing.getPosX();
	posy = bKing.getPosY();
	board[posx][posy] = bKing.getCode();
	
	wRook = new Rook('w',0, 7,board);
	posx = wRook.getPosX();
	posy = wRook.getPosY();
	board[posx][posy] = wRook.getCode();
	
	wRook = new Rook('w',7, 7,board);
	posx = wRook.getPosX();
	posy = wRook.getPosY();
	board[posx][posy] = wRook.getCode();
	
	bRook = new Rook('b',0, 0,board);
	posx = bRook.getPosX();
	posy = bRook.getPosY();
	board[posx][posy] = bRook.getCode();
	
	bRook = new Rook('b',7, 0,board);
	posx = bRook.getPosX();
	posy = bRook.getPosY();
	board[posx][posy] = bRook.getCode();
	
	
	wKnight = new Knight('w',1,7);
	posx = wKnight.getPosX();
	posy = wKnight.getPosY();
	board[posx][posy] = wKnight.getCode();
	
	wKnight = new Knight('w',6,7);
	posx = wKnight.getPosX();
	posy = wKnight.getPosY();
	board[posx][posy] = wKnight.getCode();
	
	
	bKnight = new Knight('b',1,0);
	posx = bKnight.getPosX();
	posy = bKnight.getPosY();
	board[posx][posy] = bKnight.getCode();
	
	bKnight = new Knight('b',6,0);
	posx = bKnight.getPosX();
	posy = bKnight.getPosY();
	board[posx][posy] = bKnight.getCode();
	
	
	wBishop = new Bishop('w',2, 7,board);
	posx = wBishop.getPosX();
	posy = wBishop.getPosY();
	board[posx][posy] = wBishop.getCode();
	
	wBishop = new Bishop('w',5, 7,board);
	posx = wBishop.getPosX();
	posy = wBishop.getPosY();
	board[posx][posy] = wBishop.getCode();
	
	bBishop = new Bishop('b',2, 0,board);
	posx = bBishop.getPosX();
	posy = bBishop.getPosY();
	board[posx][posy] = bBishop.getCode();
	
	bBishop = new Bishop('b',5, 0,board);
	posx = bBishop.getPosX();
	posy = bBishop.getPosY();
	board[posx][posy] = bBishop.getCode();
	
	
	
	
	/*posx = wPawn.getPosX();
	posy = wPawn.getPosY();
	board[posx][posy] = wPawn.getCode();
	
	wPawn = new Pawn('w', 5, 6);
	posx = wPawn.getPosX();
	posy = wPawn.getPosY();
	board[posx][posy] = wPawn.getCode();*/
	
	
	printBoard(board);	
	
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
	
	while(!(input.equals("resign"))) {
		
		
			valid = false;
			
			while(valid == false) {
				System.out.println();
				System.out.print("White Move: ");
				sr = new Scanner(System.in);
				//exp string: "e5 e6"
				input = sr.nextLine();
				System.out.println(input);
				
				chr = input.charAt(0);
				
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
				
				//getcurrent piece
				//valid = valid(wQueen.validMovement(tox, toy));
				
				currPiece.posX = fromx;
				currPiece.posY = fromy;
				if(board[fromx][fromy] != 0 && board[fromx][fromy] != 1 && board[fromx][fromy] != 2 &&
						board[fromx][fromy] != 3 && board[fromx][fromy] != 4 && board[fromx][fromy] != 5) {
					System.out.println("Not a White piece " + board[fromx][fromy]);
					continue;
					
				}
				//valid = valid(wQueen.validMovement(tox, toy));
				if(board[tox][toy] != 12 && board[tox][toy] != 13 && board[tox][toy] != 6 && board[tox][toy] != 7 &&
						board[tox][toy] != 8 && board[tox][toy] != 9 && board[tox][toy] != 10 && board[tox][toy] != 11) {
					System.out.println("Move not allowed");
					continue;
				}
				
				currPiece.currcode = board[fromx][fromy];
				
				valid = valid(currPiece.valid(board[fromx][fromy], fromx, fromy, tox, toy,board));
			}	
			board[fromx][fromy] = last;
			last = board[tox][toy];		
			board[tox][toy]= currPiece.currcode;
			
			printBoard(board);
		
		
			valid = false;
			
			while(valid == false) {
				System.out.println();
				System.out.print("Black Move: ");
				sr = new Scanner(System.in);
				//exp string: "e5 e6"
				input = sr.nextLine();
				System.out.println(input);
				
				chr = input.charAt(0);
				
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
				
				//getcurrent piece
				//valid = valid(wQueen.validMovement(tox, toy));
				
				currPiece.posX = fromx;
				currPiece.posY = fromy;
				if(board[fromx][fromy] != 6 && board[fromx][fromy] != 7 && board[fromx][fromy] != 8 &&
						board[fromx][fromy] != 9 && board[fromx][fromy] != 10 && board[fromx][fromy] != 11) {
					System.out.println("Not a Black piece " + board[fromx][fromy]);
					continue;
					
				}
				
				if(board[tox][toy] != 12 && board[tox][toy] != 13 && board[tox][toy] != 0 && board[tox][toy] != 1 &&
						board[tox][toy] != 2 && board[tox][toy] != 3 && board[tox][toy] != 4 && board[tox][toy] != 5) {
					System.out.println("Move not allowed");
					continue;
				}
				
				
				//valid = valid(wQueen.validMovement(tox, toy));
				currPiece.currcode = board[fromx][fromy];
				valid = valid(currPiece.valid(board[fromx][fromy], fromx, fromy, tox, toy,board));
			}	
			board[fromx][fromy] = last;
			last = board[tox][toy];		
			board[tox][toy]= currPiece.currcode;
			
			printBoard(board);
		
		
	}
	
	
	
	
	
	
	
		
		//initBoard();
		//printBoard(board);
		
	}


	public static int getCode(int[][] board, int x, int y) {
		return board[x][y];
		
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
