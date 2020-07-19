import java.util.Scanner;

class Game {
    Scanner sc = new Scanner(System.in);
    String movie;
    char[] input;
    int strike = 0;
    boolean gameOn = true;
    Game(){
        this.movie = GuessTheMovie.pickRandomMovie();
        this.input = new char[this.movie.length()];
    }
    boolean present(char [] arr, char x){
        for (int i=0;i<arr.length;i++){
            if (arr[i]==x){
                return true;
            }
        }
        return false;
    }
    boolean strikecheck() {
        if (this.strike==5){
            this.gameOn = false;
            System.out.println("FATALITY!");
            replay();
            return true;
        }
        else
            return false;
    }
    boolean arrcmp(char[] arr1, char[] arr2){
        if (arr1.length!=arr2.length)
            return false;
        for (int i=0;i<arr1.length;i++){
            if (arr1[i]!=arr2[i])
                return false;
        }
        return true;
    }
    void play() {
        input = new char[this.movie.length()];
        char[] mov = new char[this.movie.length()];
        char c;
        for (int i=0;i<this.movie.length();i++){
            mov[i] = movie.charAt(i);
            if (mov[i]==' ')
                input[i] = mov[i];
            else
                input[i] = '_';
        }
        System.out.println("Guess the Movie");
        for (int i=0;i<input.length;i++){
            System.out.print(input[i]);
        }
        while (gameOn) {
            if (!strikecheck()){
                System.out.println(">> ");
                c = sc.next().charAt(0);
                if (present(mov, c)){
                    for (int i=0;i<input.length;i++){
                        if (Character.toLowerCase(mov[i])==Character.toLowerCase(c)){
                            input[i]=mov[i];
                        }
                    }
                }
                else {
                    System.out.println("Oops! Wrong Choice Amigo...");
                    this.strike++;
                    System.out.println("Strike " + this.strike);
                    strikecheck();
                    if (this.strike==5){
                        break;
                    }
                }
                if (arrcmp(input, mov)){
                    System.out.println(this.movie);
                    System.out.println("Sweet Victory!");
                    this.gameOn = false;
                    replay();
                }
                System.out.println();
                for (int i=0;i<input.length;i++){
                    System.out.print(input[i]);
                }
                System.out.println();
            }
        }
    }
    void replay(){
        System.out.println("Replay? (y/n)");
        char ch = sc.next().charAt(0);
        if (ch=='y') {
            this.movie = GuessTheMovie.pickRandomMovie();
            this.gameOn = true;
            this.strike = 0;
            this.input = new char[movie.length()];
            this.play();
        }
        else
            this.gameOn = false;
            System.out.println("Adios Migos");
    }
}

public class GuessTheMovie {
    static String[] movieList = {
        "Star Wars", "The Matrix", "John Wick", "Deadpool", "Shazam", "Ready Player One", "Interstellar"
    };
    static String pickRandomMovie(){
        int index = (int)(Math.random()*movieList.length);
        return movieList[index];
    }
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
