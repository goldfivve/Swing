package Package;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Board extends JPanel implements MouseListener {

    public Level level;
    public Field [][] board;
    Graphics graphics;
    public Board(Level level){


        addMouseListener(this);
        if(level instanceof Beginner){
            paintBoard(level, graphics);
            this.createBoard(level);
            this.placeMine(level);
            this.fieldMinesNumber(board);
        }
        if(level instanceof Medium){
            this.createBoard(level);
            this.placeMine(level);
            this.fieldMinesNumber(board);
        }
        if(level instanceof Advanced){
            this.createBoard(level);
            this.placeMine(level);
            this.fieldMinesNumber(board);
        }



    }

    void createBoard(Level level){

        for(int i=0; i<level.size; i++){
            for (int j=0; j<level.size; j++){

                board[i][j] = new Field(false);

            }

        }

    }


    void paintBoard(Level level, Graphics graphics){
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,200,400,400);
        graphics.setColor(Color.DARK_GRAY);
        for (int i=0; i <level.size; i++){
            for(int j=0; j<level.size; j++){
                graphics.fillRect((30)*j,200+(30*i),50,50);
            }
        }
    }

    private void placeMine(Level level){
        int mine=0;
        while(mine<level.mineNumber+1){

            int x = generateRandomIndex();
            int y = generateRandomIndex();

            if(!board[x][y].isMine) {

                board[x][y].isMine=true;
                mine++;
            }

        }
    }

     int generateRandomIndex(){
        Random rnd = new Random();
        int numberField = rnd.nextInt(level.size);
        return numberField;
    }

    private void fieldMinesNumber(Field [][] board){
       for(int i=0; i<level.size; i++) {
          for(int j=0; j<level.size; j++) board[i][j].minesAround = countMinesAround(i,j);
       }
    }
    private int countMinesAround(int x, int y){


        int mine = 0;
        for(int i=x-1;i<x+2;i++){
                for(int j=y-1; j<y+2; j++){
                    if(insideBoard(i,j) && board[i][j].isMine) mine++;
                    else continue;
                }
        }

        return mine;


    }
    boolean insideBoard(int x, int y) {
        if (x<level.size && y<level.size) return true;

        return false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX() + e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    /*

int countMinesAround(int x, int y){


        int mine = 0;

        if(board[x][y].isCovered || !insideBoard(x,y) ) return -1;

        else{

            for(int i=x-1; i<x+2;i++ ){
                for(int j=y-1; j<j+2; j++){

                    if(insideBoard(i,j) && board[i][j].isMine) mine++;
                    else continue;
                }
            }
            return mine;
        }

    }
    boolean isFlag(int x, int y) {

        if(board[x][y].isFlag && board[x][y].isCovered && insideBoard(x,y))return true;
        else return false;
    }
    void putFlag(int x, int y) {
        if (board[x][y].isCovered && insideBoard(x,y)) board[x][y].isFlag=true;
    }

    boolean isCovered(int x, int y) {
        if(board[x][y].isCovered && insideBoard(x,y))return true;

        return false;
    }
    void uncoverField(int x, int y) {

        if(board[x][y].isCovered && !board[x][y].isMine) board[x][y].isCovered=false;
    }
    boolean insideBoard(int x, int y) {
        if (x<level.size && y<level.size) return true;

        return  false;
     */
}
