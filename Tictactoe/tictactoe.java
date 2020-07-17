import java.util.Scanner;

class Player {
    char type;
    char mark;
    boolean winner = false;
    Player(char x, char type){
        this.mark = x;
        this.type = type;
    }
    void placeMark(char[][] board) {
        int x,y;
        System.out.println("Player " + (tictactoe.turn+1) + " >> ");
        if (this.type=='C') {
            int[] coords = think(board);
            x = coords[0];
            y = coords[1];
        }
        else {
            x = tictactoe.sc.nextInt();
            y = tictactoe.sc.nextInt();
        }
        if (checkBlank(board, x ,y)) {
            board[x][y] = this.mark;
            checkRow(board, x, y, this.mark);
            if (tictactoe.turn==0){
                tictactoe.turn=1;
            } else if (tictactoe.turn==1) {
                tictactoe.turn=0;
            }
        }
    }
    boolean checkBlank(char[][] board, int x, int y) {
        if (board[x][y]!='X'&&board[x][y]!='O'){
            return true;
        } else {
            System.out.println("Space already taken, try again.");
            return false;
        }
    }
    void checkRow(char[][] board, int x, int y, char mark){
        int row = 0;
        int col = 0;
        int diag = 0;
        int inv = 0;
        for (int i=0;i<3;i++){
            if (board[x][i]==mark)
                row++;
            if (board[i][y]==mark)
                col++;
            if (board[i][i]==mark)
                diag++;
            if (board[2-i][i]==mark)
                inv++;
        }
        if (row==3||col==3||diag==3||inv==3){
            this.winner = true;
            tictactoe.gameOn = false;
        }
    }

    int[] think(char[][] board) {
        int[] coords = {0,0};
        
        coords[0] = (int)(Math.random() * 3);
        coords[1] = (int)(Math.random() * 3);
        if (!checkBlank(board, coords[0], coords[1])) {
            return think(board);
        } else {
            return coords;
        }
    }
}
public class tictactoe {
    static boolean gameOn = true;
    static int turn = 0;
    static Scanner sc = new Scanner(System.in);
    static void boardPrint(char[][] board) {
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
    static void PlayGame(char[][] board,Player[] players) {
        while (gameOn){
            boardPrint(board);
            players[turn].placeMark(board);
        }
        boardPrint(board);
        if (players[0].winner){
            System.out.println("Player 1 won!");
        }
        else if (players[1].winner){
            System.out.println("Player 2 won!");
        }
        else {
            System.out.println("Meh, it's a draw, try again...");
        }
        System.out.println("Try Again? (y/n)");
        char inp = sc.next().charAt(0);
        if (inp=='y'){
            gameOn=true;
            for (int i=0;i<3;i++){
                for (int j=0;j<3;j++){
                    board[i][j]='.';
                }
            }
        PlayGame(board, players);
        }
        else {
            System.out.print("\nSayonara!");
        }
    }
    public static void main(String[] args){
        char[][] game = new char[3][3];
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                game[i][j]='.';
            }
        }
        System.out.println("Press C for single player and H for 2 player...");
        char pl = sc.nextLine().charAt(0);
        Player[] play = new Player[2];
        play[0] = new Player('O','H');
        if (pl=='H') {
            play[1] = new Player('X','H');
        } else {
            play[1] = new Player('X','C');
        }
        PlayGame(game,play);
    }
}
