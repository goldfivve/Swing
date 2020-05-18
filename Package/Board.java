package Package;
import javax.swing.*;
import java.awt.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;

public class Board extends JPanel implements MouseListener {

    public Level level;
    public Field [][] tile;
    Beginner beginner;
    Medium medium;
    Advanced advanced;
    int value;
    int minesValue;
    int start;




    public Board(Level level) {

        start = 0;


        if (level instanceof Beginner) {
            beginner = new Beginner();
            value = Beginner.size;
            tile = new Field[value][value];
            minesValue = Beginner.mineNumber;
        }
        if (level instanceof Medium) {

            medium = new Medium();
            value = Medium.size;
            tile = new Field[value][value];
            minesValue = Medium.mineNumber;
        }
        if (level instanceof Advanced) {

            advanced = new Advanced();
            value = Advanced.size;
            tile = new Field[value][value];
            minesValue = Advanced.mineNumber;
        }
        addMouseListener(this);
        placeMine();
        fieldMinesNumber();
    }



    @Override
    public void paintComponent(Graphics graphics){
        if(start==0) {
            graphics.setColor(Color.BLACK);
            graphics.fillRect(0, 0, 692, 800);
            graphics.setColor(Color.DARK_GRAY);
            for (int i = 0; i < value; i++) {
                for (int j = 0; j < value; j++) {

                    graphics.fillRect(132 + (54 * j), 200 + (54 * i), 50, 50);
                    tile[i][j] = new Field(132 + (54 * j), 200 + (54 * i), 50, 50);


                    //graphics.fillRect(116+(29 * j), 200 + (29 * i), 25, 25);
                    //tile[i][j]=new Field(116+(29 * j), 200 + (29 * i), 25, 25);

                    //graphics.fillRect((29 * j), 50 + (29 * i), 25, 25);
                    // tile[i][j]=new Field((29 * j), 50 + (29 * i), 25, 25);


                }
            }
        }
        if(start == 1){

            for (int i = 0; i < value; i++) {
                for (int j = 0; j < value; j++) {


                    graphics.setColor(tile[i][j].rectangleColor);
                    graphics.fillRect(132 + (54 * j), 200 + (54 * i), 50, 50);



                    //graphics.fillRect(116+(29 * j), 200 + (29 * i), 25, 25);
                    //tile[i][j]=new Field(116+(29 * j), 200 + (29 * i), 25, 25);

                    //graphics.fillRect((29 * j), 50 + (29 * i), 25, 25);
                    // tile[i][j]=new Field((29 * j), 50 + (29 * i), 25, 25);


                }
            }

        }





    }


    private void placeMine() {
        int mine = 0;
        while (mine < minesValue + 1) {

            int x = generateRandomIndex();
            int y = generateRandomIndex();

            if (!tile[x][y].isMine) {

                tile[x][y].isMine = true;
                mine++;
            }

        }
    }


    private int generateRandomIndex() {
        Random rnd = new Random();
        int numberField = rnd.nextInt(value);
        return numberField;
    }

    private void fieldMinesNumber() {
        for (int i = 0; i < value; i++) {
            for (int j = 0; j < value; j++) {
                tile[i][j].minesAround = countMinesAround(i, j);
            }
        }
    }


    private int countMinesAround(int x, int y) {



        int mine = 0;
        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                if (insideBoard(i, j) && tile[i][j].isMine) mine++;
                else continue;
            }
        }

        return mine;


    }


    boolean insideBoard(int x, int y) {
        if (x < value && y < value) return true;

        return false;
    }


    @Override
    public void mouseClicked(MouseEvent e) {

        if(SwingUtilities.isLeftMouseButton(e)) {
            start = 1;
            System.out.println(e.getX() + " " + e.getY());
            int clickedX = e.getX();
            int clickedY = e.getY();

            for (int i = 0; i < value; i++) {
                for (int j = 0; j < value; j++) {
                    if (tile[i][j].contains(clickedX, clickedY) && !tile[i][j].isMine && !tile[i][j].isFlag) {

                        tile[i][j].isCovered=false;
                        tile[i][j].rectangleColor = Color.WHITE;
                        this.repaint();
                    }
                    if(tile[i][j].contains(clickedX, clickedY) && tile[i][j].isMine && !tile[i][j].isFlag){
                        tile[i][j].rectangleColor = Color.RED;
                        this.repaint();
                    }
                }

            }
        }
        if(SwingUtilities.isRightMouseButton(e)){
            start = 1;
            System.out.println(e.getX() + " " + e.getY());
            int clickedX = e.getX();
            int clickedY = e.getY();

            for (int i = 0; i < value; i++) {
                for (int j = 0; j < value; j++) {
                    if (tile[i][j].contains(clickedX, clickedY)&&tile[i][j].isCovered) {

                        tile[i][j].isFlag=true;
                        tile[i][j].rectangleColor = Color.BLUE;
                        this.repaint();
                    }
                }

            }
        }


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
}
