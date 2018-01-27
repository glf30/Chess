package chess.app;

import java.util.Scanner;



public class ChessMain{
	
	
	
	
public static void main(String[] args) {
		
	int rank = 0;
	int x = 0;
	String alt = "  ";
	String board[][] = new String[8][8];
	while(rank <8) {
		x = 0;
		while(x<8) {
			if(rank == 1) {
				
			//	board[x][rank] = "bp";
			}
			
			if(rank == 6) {
				
				//board[x][rank] = "wp";
			}
		
			board[x][rank] = alt;
			if(rank%2 == 0 && x %2 != 0) {
				board[x][rank] = "##";
			} else if(rank%2 != 0 &&  x%2 == 0){
				board[x][rank] = "##";
			}
			
			
			//board[x][rank] = alt;
		
			
			x++;
		
		}
		rank++;
		
		
	}
	int posx = 3;
	int posy = 4;
	String last = board[posx][posy];
	board[posx][posy] = "**";
	int r = 8;
	for(int y = 0; y<8; y++) {
		for(x = 0; x<8; x++) {
			System.out.print(board[x][y]);
			System.out.print(" ");
			
			
		}
		
		System.out.print(r);
		r--;
		System.out.print("\n");
		
	}
	System.out.println("a  b  c  d  e  f  g  h");
		
	

	System.out.println();
	System.out.print("Input point: ");
	Scanner sr = new Scanner(System.in);
	//exp string: "e5 e6"
	String input = sr.nextLine();
	System.out.println(input);
	
	char chr = input.charAt(0);
	
	int fromx = letterToIndex(chr);
	int fromy = numberToIndex(Character.getNumericValue(input.charAt(1))) ;
	char chr2 = input.charAt(3);
	int tox = letterToIndex(chr2);
	int toy = numberToIndex(Character.getNumericValue(input.charAt(4)));
	
	
	board[fromx][fromy] = last;
	last = board[tox][toy];		
	board[tox][toy]= "**";
	
	
	
	
	r = 8;
	for(int y = 0; y<8; y++) {
		for(x = 0; x<8; x++) {
			System.out.print(board[x][y]);
			System.out.print(" ");
			
			
		}
		
		System.out.print(r);
		r--;
		
		System.out.print("\n");
		
	}
	System.out.println("a  b  c  d  e  f  g  h");
	while(!(input.equals("resign"))) {
		
		System.out.println();
		System.out.print("Input point: ");
		sr = new Scanner(System.in);
		//exp string: "e5 e6"
		input = sr.nextLine();
		System.out.println(input);
		
		chr = input.charAt(0);
		
		fromx = letterToIndex(chr);
		fromy = numberToIndex(Character.getNumericValue(input.charAt(1))) ;
		chr2 = input.charAt(3);
		tox = letterToIndex(chr2);
		toy = numberToIndex(Character.getNumericValue(input.charAt(4)));
		
		board[fromx][fromy] = last;
		last = board[tox][toy];		
		board[tox][toy]= "**";
		
		
		
		
		r = 8;
		for(int y = 0; y<8; y++) {
			for(x = 0; x<8; x++) {
				System.out.print(board[x][y]);
				System.out.print(" ");
				
				
			}
			
			System.out.print(r);
			r--;
			System.out.print("\n");
			
		}
		System.out.println("a  b  c  d  e  f  g  h");
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
		
		//initBoard();
		//printBoard(board);
		
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



*/
