package Package;
import Package.Board;

import java.util.Random;

public class Game {
    Board board;
    Field [][] tiles;
    public static Level beginner;
    public static Level medium;
    public static Level advanced;
    public void start(Level level){
        board = new Board(level);
        beginner = new Beginner();
        medium = new Medium();
        advanced = new Advanced();
    }

    void uncoverSurroundings(int x, int y){

        if(tiles[x][y].minesAround==0) {
            for(int k=x-1;k<x+2;k++){
                for(int l=y-1; l<y+2; l++){
                    tiles[k][l].isCovered = false;
                }
            }
        }
    }

    void putFlag(int x, int y) {
        if (tiles[x][y].isCovered) tiles[x][y].isFlag=true;
    }

    void uncoverField(int x, int y) {
        if(tiles[x][y].isCovered && !tiles[x][y].isMine) {
            tiles[x][y].isCovered=false;
            for(int i = x;i>=0; i--){
                for (int j = y; j>=0; j--) {
                    uncoverSurroundings(i,j);
                }

                for (int j = y; j<Level.size; j++){
                    uncoverSurroundings(i,j);
                }
            }
            for(int i = x;i<Level.size; i++){
                for (int j = y; j>=0; j--) {
                    uncoverSurroundings(i,j);
                }

                for (int j = y; j<Level.size; j++){
                    uncoverSurroundings(i,j);
                }
            }

        }

    }
    void showMine(int x, int y){
        if(tiles[x][y].isCovered && tiles[x][y].isMine) System.out.println("Game over");
    }

    void findAnotherPlace(int x, int y){
        if(tiles[x][y].isMine) {
            int mine = 0;
            while (mine < 2) {
                int a = generateRandomIndex();
                int b = generateRandomIndex();
                if (!tiles[a][b].isMine) {

                    tiles[x][y].isMine=false;
                    tiles[a][b].isMine = true;
                    mine++;
                }
            }
        }
    }
    int generateRandomIndex(){
        Random rnd = new Random();
        int numberField = rnd.nextInt(Level.size);
        return numberField;
    }




}


