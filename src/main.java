import java.util.Scanner;
import java.util.Random;
public class main {

    public static void main(String[] args) {
        char[][] Board = new char[5][5];
        int row = 0;
        int col = 0;
        Random rand = new Random();
        int Round = rand.nextInt(2);
        System.out.println(Round);
        int playerGetColor=rand.nextInt(2);
        char Player=' ';
        char AI=' ';
        if (playerGetColor==0)
        {
            Player='B';
            AI='R';
        }else{
            Player='R';
            AI='B';
        }
        try (Scanner scanner = new Scanner(System.in)) {
            for (int i = 0; i < Board.length; i++) {
                for (int j = 0; j < Board.length; j++) {
                    Board[i][j] = ' ';
                }
            }
            boolean noWinGame = true;
            while (noWinGame) {
                System.out.println("------------");
                for (int i = 0; i < Board.length; i++) {
                    System.out.printf("| %c %c %c %c %c |\n", Board[i][0], Board[i][1], Board[i][2],Board[i][3],Board[i][4]);
                }
                System.out.println("------------");
                noWinGame = gamestate(Board);
                while (noWinGame) {
                    if (Round % 2 != 0){
                        System.out.print("Player Round\n");
                        System.out.print("Sor és oszlop: ");


                    String[] rowAndCol = scanner.nextLine().split(" ");
                    try {
                        row = Integer.parseInt(rowAndCol[0]) - 1;
                        col = Integer.parseInt(rowAndCol[1]) - 1;
                    } catch (Exception e) {
                        System.out.println("A sor és oszlop értékek csak számok lehetnek!");
                        continue;
                    }
                    if (row + 1 > 5 || row + 1 < 1 || col + 1 > 5 || col + 1 < 1) {
                        System.out.println("A koordináták csak 1-től 5-ig lehet megadni!");
                        continue;
                    }
                    if (Board[row][col] == ' ') {
                        Board[row][col] = Player;
                        Round++;
                        break;
                    } else {
                        System.out.println("Ez a cella nem üres!");
                        continue;
                    }
                }else{
                        System.out.print("AI Round\n");
                        int i =rand.nextInt(5);
                        int j =rand.nextInt(5);
                        if( Board[i][j]==' '){
                            Board[i][j] = AI;
                            Round++;
                            break;
                        }else {
                            continue;
                        }
                    }

                }
            }
        }
    }

    private static boolean gamestate(char[][] Board) {
        int win = 0;
        char winnerChar=' ';
        int rowCountRed=0;
        int rowCountBlue=0;
        int colCountRed=0;
        int colCountBlue=0;
        int diagCountRed=0;
        int diagCountBlue=0;
        //row
        for (int i=0; i<5;i++){
            for (int j=0; j < 5;j++) {
                if (Board[i][j] == 'R') {
                    rowCountRed++;
                    if (rowCountRed>=3){
                        win++;
                        winnerChar='B';
                    }
                }else if (Board[i][j] == 'B') {
                    rowCountBlue++;
                    if (rowCountBlue>=3){
                        win++;
                        winnerChar='R';
                    }
                }
            }
            rowCountRed=0;
            rowCountBlue=0;
        }
        //col
        for (int j=0; j < 5;j++) {
            for (int i=0; i<5;i++){
                if (Board[i][j] == 'R') {
                    colCountRed++;
                    if (colCountRed>=3){
                        win++;
                        winnerChar='B';
                    }
                }else if (Board[i][j] == 'B') {
                    colCountBlue++;
                    if (colCountBlue>=3){
                        win++;
                        winnerChar='R';
                    }
                }
            }
            colCountBlue=0;
            colCountRed=0;
        }
        //diag 3 long
        for(int n = 0; n < 4; n++) {
            if(n == 0) {
                for(int i = 2, j = 0; i >= 0 && j <= 2; i--, j++) {
                    if (Board[i][j] == 'R') {
                        diagCountRed++;
                        if (diagCountRed>=3){
                            win++;
                            winnerChar='B';
                        }
                    }else if (Board[i][j] == 'B') {
                        diagCountBlue++;
                        if (diagCountBlue>=3){
                            win++;
                            winnerChar='R';
                        }
                    }
                }
                diagCountBlue=0;
                diagCountRed=0;
            }
            else if (n == 1) {
                for(int i = 2, j = 0; i <= 4 && j <= 2; i++, j++) {
                    if (Board[i][j] == 'R') {
                        diagCountRed++;
                        if (diagCountRed>=3){
                            win++;
                            winnerChar='B';
                        }
                    }else if (Board[i][j] == 'B') {
                        diagCountBlue++;
                        if (diagCountBlue>=3){
                            win++;
                            winnerChar='R';
                        }
                    }
                }
                diagCountBlue=0;
                diagCountRed=0;
            }
            else if (n == 2) {
                for(int i = 2, j = 4; i >= 0 && j >= 2; i--, j--) {
                    if (Board[i][j] == 'R') {
                        diagCountRed++;
                        if (diagCountRed>=3){
                            win++;
                            winnerChar='B';
                        }
                    }else if (Board[i][j] == 'B') {
                        diagCountBlue++;
                        if (diagCountBlue>=3){
                            win++;
                            winnerChar='R';
                        }
                    }
                }
                diagCountBlue=0;
                diagCountRed=0;
            }
            else {
                for(int i = 2, j = 4; i <= 4 && j >= 2; i++, j--) {
                    if (Board[i][j] == 'R') {
                        diagCountRed++;
                        if (diagCountRed>=3){
                            win++;
                            winnerChar='B';
                        }
                    }else if (Board[i][j] == 'B') {
                        diagCountBlue++;
                        if (diagCountBlue>=3){
                            win++;
                            winnerChar='R';
                        }
                    }
                }
                diagCountBlue=0;
                diagCountRed=0;
            }
        }
        //diag 4 long
        for(int n = 0; n < 4; n++) {
            if(n == 0) {
                for(int i = 3, j = 0; i >= 0 && j <= 3; i--, j++) {
                    if (Board[i][j] == 'R') {
                        diagCountRed++;
                        if (diagCountRed>=3){
                            win++;
                            winnerChar='B';
                        }
                    }else if (Board[i][j] == 'B') {
                        diagCountBlue++;
                        if (diagCountBlue>=3){
                            win++;
                            winnerChar='R';
                        }
                    }
                }
                diagCountBlue=0;
                diagCountRed=0;
            }
            else if (n == 1) {
                for(int i = 1, j = 0; i <= 4 && j <= 3; i++, j++) {
                    if (Board[i][j] == 'R') {
                        diagCountRed++;
                        if (diagCountRed>=3){
                            win++;
                            winnerChar='B';
                        }
                    }else if (Board[i][j] == 'B') {
                        diagCountBlue++;
                        if (diagCountBlue>=3){
                            win++;
                            winnerChar='R';
                        }
                    }
                }
                diagCountBlue=0;
                diagCountRed=0;
            }
            else if (n == 2) {
                for(int i = 3, j = 4; i >= 0 && j >= 1; i--, j--) {
                    if (Board[i][j] == 'R') {
                        diagCountRed++;
                        if (diagCountRed>=3){
                            win++;
                            winnerChar='B';
                        }
                    }else if (Board[i][j] == 'B') {
                        diagCountBlue++;
                        if (diagCountBlue>=3){
                            win++;
                            winnerChar='R';
                        }
                    }
                }
                diagCountBlue=0;
                diagCountRed=0;
            }
            else {
                for(int i = 1, j = 4; i <= 4 && j >= 1; i++, j--) {
                    if (Board[i][j] == 'R') {
                        diagCountRed++;
                        if (diagCountRed>=3){
                            win++;
                            winnerChar='B';
                        }
                    }else if (Board[i][j] == 'B') {
                        diagCountBlue++;
                        if (diagCountBlue>=3){
                            win++;
                            winnerChar='R';
                        }
                    }
                }
                diagCountBlue=0;
                diagCountRed=0;
            }
        }
        //diag 5 long
        for(int i = 0, j = 0; i <= 4 && j <= 4; i++, j++) {
            if (Board[i][j] == 'R') {
                diagCountRed++;
                if (diagCountRed>=3){
                    win++;
                    winnerChar='B';
                }
            }else if (Board[i][j] == 'B') {
                diagCountBlue++;
                if (diagCountBlue>=3){
                    win++;
                    winnerChar='R';
                }
            }
        }
        diagCountBlue=0;
        diagCountRed=0;
        for(int i = 0, j = 4; i <= 4 && j >= 0; i++, j--) {
            if (Board[i][j] == 'R') {
                diagCountRed++;
                if (diagCountRed>=3){
                    win++;
                    winnerChar='B';
                }
            }else if (Board[i][j] == 'B') {
                diagCountBlue++;
                if (diagCountBlue>=3){
                    win++;
                    winnerChar='R';
                }
            }
        }
        diagCountBlue=0;
        diagCountRed=0;

        if (win >= 1) {
            if (winnerChar=='B') {
                System.out.println("-----------");
                System.out.println("|\\ - - - /|");
                System.out.println("|-\\ - - /-|");
                System.out.println("| B L U E |");
                System.out.println("|-/W I N\\-|");
                System.out.println("|/ - - - \\|");
                System.out.println("-----------");
            }else if (winnerChar=='R') {
                System.out.println("-----------");
                System.out.println("|\\ - - - /|");
                System.out.println("|-\\ - - /-|");
                System.out.println("|  R E D  |");
                System.out.println("|-/W I N\\-|");
                System.out.println("|/ - - - \\|");
                System.out.println("-----------");
            }
            return false;

        }

        return true;
    }
}
